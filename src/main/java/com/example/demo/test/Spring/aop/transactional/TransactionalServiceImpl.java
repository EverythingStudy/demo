package com.example.demo.test.Spring.aop.transactional;

/**
 * @Description
 * @Date 2019/11/26 14:47
 * @Author cly
 **/

import com.example.demo.test.Spring.dao.AdapterApiMapper;
import com.example.demo.test.Spring.dao.BackupMapper;
import com.example.demo.test.Spring.entity.AdapterApi;
import com.example.demo.test.Spring.entity.AdapterApiExample;
import com.example.demo.test.Spring.entity.Backup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TransactionalServiceImpl implements TransactionalService {
    @Autowired
    AdapterApiMapper adapterApiMapper;
    @Autowired
    BackupMapper backupMapper;

    @Transactional(readOnly=false,propagation=Propagation.REQUIRED,isolation= Isolation.REPEATABLE_READ,rollbackFor = Exception.class)
    @Override
    public void addData(Backup backup,AdapterApi adapterApi) {
        AdapterApiExample example=new AdapterApiExample();
        AdapterApiExample.Criteria criteria=example.createCriteria();
        criteria.andApiNameEqualTo(adapterApi.getApiName());
        backupMapper.insert(backup);
        int i=1/0;

    }

}
