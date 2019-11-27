package com.example.demo.test.Spring.aop.transactional;

import com.example.demo.test.Spring.entity.AdapterApi;
import com.example.demo.test.Spring.entity.Backup;

/**
 * @Description 事务处理
 * @Date 2019/11/26 14:47
 * @Author cly
 **/
public interface TransactionalService {
    public void addData(Backup backup,AdapterApi adapterApi);

}
