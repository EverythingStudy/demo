package com.example.demo.test.Spring.aop.transactional;

import com.example.demo.test.Spring.entity.AdapterApi;
import com.example.demo.test.Spring.entity.Backup;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 事务测试 1.springbootapplication 入口类中加入注解@EnableTransactionManagement// 开启注解事务管理，等同于xml配置文件中的 <tx:annotation-driven />
 *                     2.在需要事务管理的service方法中加入注解自动提交：注解参数：读写-传播性-隔离级别--回滚@Transactional(readOnly=false,propagation=Propagation.REQUIRED,isolation= Isolation.REPEATABLE_READ,rollbackFor = Exception.class)
 *                     3.或者在事务方法中手动提交事务TransactionAspectSupport.currentTransactionStatus().setRollbackOnly()
 *                     4.注意Mysql数据库引擎要支持事务才行，InnoDB支持事务，MyIASM不支持事务
 * @Date 2019/11/26 14:37
 * @Author cly
 **/
@RestController
public class TransactionalController {
    @Resource
    TransactionalService transactionalService;
    @RequestMapping(value = "transaction",method = RequestMethod.GET)
    public void transaction(HttpServletRequest request, HttpServletResponse response){
        AdapterApi adapterApi=new AdapterApi();
        adapterApi.setApiName("cly");
        Backup backup=new Backup();
        backup.setFacilityId(12);
        transactionalService.addData(backup,adapterApi);
    }
}
