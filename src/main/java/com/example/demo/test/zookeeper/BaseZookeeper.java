package com.example.demo.test.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;

import java.util.List;

public interface BaseZookeeper {
    public void connectZooKeeper(String host, int timeout, Watcher watcher);
    public void process(WatchedEvent watchedEvent);
    public String createZnode(String path, String data) throws Exception;
    public List<String>  getChildren(String path) throws KeeperException, InterruptedException;
    public String getData(String path,boolean watch) throws KeeperException, InterruptedException;
    public Stat setData(String path, String data) throws KeeperException, InterruptedException;
    public void deleteNode(String path) throws InterruptedException, KeeperException;
    public String getCTime(String path) throws KeeperException, InterruptedException;
    public Integer getChildrenNum(String path) throws KeeperException, InterruptedException;
    public void closeConnection() throws InterruptedException;
}
