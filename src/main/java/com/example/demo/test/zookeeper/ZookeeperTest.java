package com.example.demo.test.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;

import java.util.List;

/**
 * @Description Zookeeper分支文件存储--分布式锁--分布式服务协调
 * @Date 2020/6/30 10:11
 * @Author cly
 **/
public class ZookeeperTest {
    public static void main(String[] args) {
        BaseZookeeperImpl baseZookeeper = new BaseZookeeperImpl();
        Watcher watcher=new BaseZookeeperImpl();
        baseZookeeper.connectZooKeeper("101.200.235.90:2181", 0, watcher);
        try {
            baseZookeeper.createZnode("/watcherTESTtt", "ww", CreateMode.PERSISTENT);
            //String base=baseZookeeper.getData("/watcherTESTtt",true);
            //System.out.println("==base=="+base);
           // baseZookeeper.createZnode("/watcherTESTtt", "ww", CreateMode.EPHEMERAL_SEQUENTIAL);
            Thread.sleep(Long.MAX_VALUE);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
