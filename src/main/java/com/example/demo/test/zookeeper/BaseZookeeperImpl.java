package com.example.demo.test.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Author cly
 * @Description //TODO Zookeeper JAVA API的使用
 * @Date 2019/6/26 9:38
 * @Param
 * @return
 **/

public class BaseZookeeperImpl implements Watcher, BaseZookeeper {
    private ZooKeeper zookeeper;
    private static final int SESSION_TIME_OUT = 2000;
    private CountDownLatch countDownLatch = new CountDownLatch(1);


    /**
     * @return void
     * @Author cly
     * @Description //TODO 连接zookeeper
     * @Date 9:47 2019/6/26
     * @Param [host, timeout, watcher]
     **/
    @Override
    public void connectZooKeeper(String host, int timeout, Watcher watcher) {
        try {
            if(timeout==0){
                zookeeper = new ZooKeeper(host, SESSION_TIME_OUT, this);
            }else{
                zookeeper = new ZooKeeper(host, timeout, this);
            }
            countDownLatch.await();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("zookeeper connection success");

    }
    /**
     * @Author cly
     * @Description //TODO Watch事件回调函数
     * @Date 10:14 2020/6/30
     * @Param [watchedEvent]
     * @return void
     **/
    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            System.out.println("Watch received event"+watchedEvent.getPath());
            try {
                //watch 参数true会重新设置监听，false不设置监听
                getData("/watcherTEST",true);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        } else if (Event.EventType.NodeChildrenChanged == watchedEvent.getType()) {
            try {
                System.out.println("get Child:" + zookeeper.getChildren(watchedEvent.getPath(), true));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (Event.EventType.NodeDataChanged == watchedEvent.getType()) {
            try {
                System.out.println("the data of:" + watchedEvent.getPath() + " is::" + new String(zookeeper.getData(watchedEvent.getPath(), true, stat)));
                System.out.println("watch czxid::" + stat.getCzxid() + ",mzxid::" + stat.getMzxid() + ",version::" + stat.getVersion());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (Event.EventType.NodeDeleted == watchedEvent.getType()) {
            System.out.println("node " + watchedEvent.getPath() + " deleted.");
            try {
                zookeeper.exists(watchedEvent.getPath(), true);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (Event.EventType.NodeCreated == watchedEvent.getType()) {
            System.out.println("node " + watchedEvent.getPath() + " created.");
            try {
                zookeeper.exists(watchedEvent.getPath(), true);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @return java.lang.String
     * @Author cly
     * @Description //TODO 同步创建节点
     * @Date 9:58 2019/6/26
     * @Param [path, data]
     **/

    @Override
    public String createZnode(String path, String data,CreateMode createMode) throws Exception {
        return this.zookeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, createMode);
    }

    /**
     * @return void
     * @Author cly
     * @Description //TODO 异步创建节点
     * @Date 13:53 2019/6/26
     * @Param [path, data]
     **/

    public void createAsyncZnode(String path, String data) throws Exception {
        zookeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT, new IStringCallBack(), "");
    }

    class IStringCallBack implements AsyncCallback.StringCallback {
        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            System.out.println("rc:" + rc + ",path:" + path + ",ctx:" + ctx + "name," + name);
        }
    }

    /**
     * @return java.lang.String
     * @Author cly
     * @Description //TODO 同步获取子节点
     * @Date 9:58 2019/6/26
     * @Param [path]
     **/

    @Override
    public List<String> getChildren(String path) throws KeeperException, InterruptedException {
        List<String> children = zookeeper.getChildren(path, true);//true 和false 不同
        return children;
    }

    public void getChildrenAsync(String path) throws KeeperException, InterruptedException {
        zookeeper.getChildren(path, true, new IChildren2Callback(), null);
    }

    class IChildren2Callback implements AsyncCallback.Children2Callback {
        @Override
        public void processResult(int rc, String path, Object ctx, List<String> children, Stat stat) {
            System.out.println(rc + "::" + path + "::" + ctx + "::" + children + "::" + stat);
        }

    }

    /**
     * @Author cly
     * @Description //TODO 同步获取节点上面的数据
     * @Date 9:59 2019/6/26
     * @Param [path]
     * @return java.lang.String
     **/
    private static final Stat stat = new Stat();

    @Override
    public String getData(String path, boolean watch) throws KeeperException, InterruptedException {
        byte[] data = zookeeper.getData(path, watch, stat);
        if (data == null) {
            return "";
        }
        return new String(data);
    }

    public void getDataAsync(String path, boolean watch) {
        zookeeper.getData(path, true, new IDataCallback(), null);
    }

    class IDataCallback implements AsyncCallback.DataCallback {
        @Override
        public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
            System.out.println("watch rc::" + rc + ", path::" + path + ", ctx::" + ctx + ", data::" + new String(data));
            System.out.println("watch czxid::" + stat.getCzxid() + ",mzxid::" + stat.getMzxid() + ",version::" + stat.getVersion());
        }
    }

    /**
     * @return org.apache.zookeeper.data.Stat
     * @Author cly
     * @Description //TODO 同步设置节点信息/更新节点信息
     * @Date 9:59 2019/6/26
     * @Param [path, data]
     **/

    @Override
    public Stat setData(String path, String data) throws KeeperException, InterruptedException {
        Stat stat = zookeeper.setData(path, data.getBytes(), -1);
        return stat;
    }

    public void setDataAsync(String path, String data) throws KeeperException, InterruptedException {
        zookeeper.setData(path, "hello2".getBytes(), -1, new StatCallback(), null);
    }

    class StatCallback implements AsyncCallback.StatCallback {
        @Override
        public void processResult(int rc, String path, Object ctx, Stat stat) {
            System.out.println("rc:" + rc + ", path:" + path + ",ctx:" + ctx + ", stat:" + stat);
        }
    }

    /**
     * @return void
     * @Author cly
     * @Description //TODO 同步删除节点 删除时要先删除子节点再删除父节点
     * @Date 10:00 2019/6/26
     * @Param [path]
     **/

    @Override
    public void deleteNode(String path) throws InterruptedException, KeeperException {
        zookeeper.delete(path, -1);
    }

    /**
     * @return void
     * @Author cly
     * @Description //TODO 异步删除节点
     * @Date 14:05 2019/6/26
     * @Param [nodePath]
     **/

    public void deleteAsyncNode(String nodePath) throws InterruptedException, KeeperException {
        zookeeper.delete(nodePath, -1, new IVoidCallback(), null);
    }

    class IVoidCallback implements AsyncCallback.VoidCallback {
        @Override
        public void processResult(int rc, String path, Object ctx) {
            System.out.println(rc + "::" + path + "::" + ctx);
        }
    }

    /**
     * @return java.lang.String
     * @Author cly
     * @Description //TODO 获取创建时间
     * @Date 10:00 2019/6/26
     * @Param [path]
     **/

    @Override
    public String getCTime(String path) throws KeeperException, InterruptedException {
        Stat stat = zookeeper.exists(path, false);
        return String.valueOf(stat.getCtime());
    }

    /**
     * @return java.lang.Integer
     * @Author cly
     * @Description //TODO 获取某个路径下孩子的数量
     * @Date 10:00 2019/6/26
     * @Param [path]
     **/

    @Override
    public Integer getChildrenNum(String path) throws KeeperException, InterruptedException {
        int childenNum = zookeeper.getChildren(path, false).size();
        return childenNum;
    }

    /**
     * @return void
     * @Author cly
     * @Description //TODO 关闭连接
     * @Date 10:00 2019/6/26
     * @Param []
     **/

    @Override
    public void closeConnection() throws InterruptedException {
        if (zookeeper != null) {
            zookeeper.close();
        }
    }
}
