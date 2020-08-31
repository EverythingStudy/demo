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

public class BaseZookeeperImpl implements Watcher,BaseZookeeper {
    private ZooKeeper zookeeper;

    private static final int SESSION_TIME_OUT = 2000;
    private CountDownLatch countDownLatch = new CountDownLatch(1);


    /**
     * @Author cly
     * @Description //TODO 连接zookeeper
     * @Date 9:47 2019/6/26
     * @Param [host, timeout, watcher]
     * @return void
     **/
    @Override
    public void connectZooKeeper(String host, int timeout, Watcher watcher) {
        try {
            zookeeper = new ZooKeeper(host, SESSION_TIME_OUT, this);
            countDownLatch.await();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("zookeeper connection success");

    }
    @Override
    public void process(WatchedEvent watchedEvent) {
        if(watchedEvent.getState()== Event.KeeperState.SyncConnected){
            System.out.println("Watch received event");
            countDownLatch.countDown();
        }else if(Event.EventType.NodeChildrenChanged == watchedEvent.getType()){
            try {
                System.out.println("get Child:" + zookeeper.getChildren(watchedEvent.getPath(), true));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(Event.EventType.NodeDataChanged == watchedEvent.getType()){
            try {
                System.out.println("the data of:" + watchedEvent.getPath() + " is::" + new String(zookeeper.getData(watchedEvent.getPath(), true,stat)));
                System.out.println("watch czxid::"+stat.getCzxid()+",mzxid::" + stat.getMzxid() + ",version::" + stat.getVersion());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(Event.EventType.NodeDeleted == watchedEvent.getType()){
            System.out.println("node " + watchedEvent.getPath() + " deleted.");
            try {
                zookeeper.exists(watchedEvent.getPath(), true);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if(Event.EventType.NodeCreated == watchedEvent.getType()){
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
     * @Author cly
     * @Description //TODO 同步创建节点
     * @Date 9:58 2019/6/26
     * @Param [path, data]
     * @return java.lang.String
     **/

    @Override
    public String createZnode(String path, String data) throws Exception {
        return this.zookeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }
    /**
     * @Author cly
     * @Description //TODO 异步创建节点
     * @Date 13:53 2019/6/26
     * @Param [path, data]
     * @return void
     **/

    public void createAsyncZnode(String path, String data) throws Exception {
        zookeeper.create(path, data.getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT,new IStringCallBack(),"");
    }
    class IStringCallBack implements AsyncCallback.StringCallback {
        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            System.out.println("rc:"+rc+",path:"+path+",ctx:"+ctx+"name,"+name);
        }
    }
    /**
     * @Author cly
     * @Description //TODO 同步获取子节点
     * @Date 9:58 2019/6/26
     * @Param [path]
     * @return java.lang.String
     **/

    @Override
    public List<String> getChildren(String path) throws KeeperException, InterruptedException {
        List<String> children = zookeeper.getChildren(path, true);//true 和false 不同
        return children;
    }
    public void getChildrenAsync(String path)throws KeeperException,InterruptedException{
        zookeeper.getChildren(path,true,new IChildren2Callback(),null);
    }
    class IChildren2Callback implements AsyncCallback.Children2Callback {
        @Override
        public void processResult(int rc, String path, Object ctx, List<String> children, Stat stat) {
            System.out.println(rc + "::" + path + "::" +ctx +"::" + children + "::" + stat);
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
    public String getData(String path,boolean watch) throws KeeperException, InterruptedException {
        byte[] data = zookeeper.getData(path, watch, stat);
        if (data == null) {
            return "";
        }
        return new String(data);
    }
    public void getDataAsync(String path,boolean watch){
        zookeeper.getData(path, true, new IDataCallback(), null);
    }
    class IDataCallback implements AsyncCallback.DataCallback {
        @Override
        public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
            System.out.println("watch rc::" + rc + ", path::" + path + ", ctx::" + ctx +", data::" + new String(data));
            System.out.println("watch czxid::"+stat.getCzxid()+",mzxid::" + stat.getMzxid() + ",version::" + stat.getVersion());
        }
    }
    /**
     * @Author cly
     * @Description //TODO 同步设置节点信息/更新节点信息
     * @Date 9:59 2019/6/26
     * @Param [path, data]
     * @return org.apache.zookeeper.data.Stat
     **/

    @Override
    public Stat setData(String path, String data) throws KeeperException, InterruptedException {
        Stat stat = zookeeper.setData(path, data.getBytes(), -1);
        return stat;
    }
    public void setDataAsync(String path, String data)throws KeeperException, InterruptedException{
        zookeeper.setData(path,"hello2".getBytes(), -1, new StatCallback(), null);
    }
    class StatCallback implements AsyncCallback.StatCallback {
        @Override
        public void processResult(int rc, String path, Object ctx, Stat stat) {
            System.out.println("rc:"+rc + ", path:" + path + ",ctx:" + ctx + ", stat:" + stat);
        }
    }
    /**
     * @Author cly
     * @Description //TODO 同步删除节点 删除时要先删除子节点再删除父节点
     * @Date 10:00 2019/6/26
     * @Param [path]
     * @return void
     **/

    @Override
    public void deleteNode(String path) throws InterruptedException, KeeperException {
        zookeeper.delete(path, -1);
    }
    /**
     * @Author cly
     * @Description //TODO 异步删除节点
     * @Date 14:05 2019/6/26
     * @Param [nodePath]
     * @return void
     **/

    public void deleteAsyncNode(String nodePath) throws InterruptedException,KeeperException{
        zookeeper.delete(nodePath,-1,new IVoidCallback(),null);
    }
    class IVoidCallback implements AsyncCallback.VoidCallback {
        @Override
        public void processResult(int rc, String path, Object ctx) {
            System.out.println(rc + "::" + path + "::" +ctx);
        }
    }
    /**
     * @Author cly
     * @Description //TODO 获取创建时间
     * @Date 10:00 2019/6/26
     * @Param [path]
     * @return java.lang.String
     **/

    @Override
    public String getCTime(String path) throws KeeperException, InterruptedException {
        Stat stat = zookeeper.exists(path, false);
        return String.valueOf(stat.getCtime());
    }
    /**
     * @Author cly
     * @Description //TODO 获取某个路径下孩子的数量
     * @Date 10:00 2019/6/26
     * @Param [path]
     * @return java.lang.Integer
     **/

    @Override
    public Integer getChildrenNum(String path) throws KeeperException, InterruptedException {
        int childenNum = zookeeper.getChildren(path, false).size();
        return childenNum;
    }
    /**
     * @Author cly
     * @Description //TODO 关闭连接
     * @Date 10:00 2019/6/26
     * @Param []
     * @return void
     **/

    @Override
    public void closeConnection() throws InterruptedException {
        if (zookeeper != null) {
            zookeeper.close();
        }
    }

    public static void main(String[] args) {
        BaseZookeeperImpl baseZookeeper=new BaseZookeeperImpl();
        baseZookeeper.connectZooKeeper("101.201.78.208:2181",0,null);
        try {
//baseZookeeper.setData("/test","cly");
            baseZookeeper.createZnode("/test","ww");
            List<String> listData= baseZookeeper.getChildren("/test");
//baseZookeeper.deleteNode("/test");
//baseZookeeper.getChildren("/test");
//String data=baseZookeeper.getData("/test");
            System.out.println("获取节点信息=="+listData.toString());
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
// try {
// String returnData=baseZookeeper.createZnode("/test","chenlinya");
// System.out.println(returnData);
// } catch (Exception e) {
// e.printStackTrace();
// }
    }
}
