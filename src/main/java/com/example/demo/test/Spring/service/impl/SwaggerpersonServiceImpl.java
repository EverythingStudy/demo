package com.example.demo.test.Spring.service.impl;

import com.example.demo.test.Spring.entity.Swaggerperson;
import com.example.demo.test.Spring.dao.SwaggerpersonDao;
import com.example.demo.test.Spring.service.SwaggerpersonService;
import com.example.demo.test.concurrent.Thread.ThreadPoolBySlef.MyFutureTask;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.*;

/**
 * (Swaggerperson)表服务实现类
 *
 * @author makejava
 * @since 2020-03-05 10:57:48
 */
@Service("swaggerpersonService")
public class SwaggerpersonServiceImpl implements SwaggerpersonService {
    @Resource
    private SwaggerpersonDao swaggerpersonDao;


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Swaggerperson queryById(Integer id) {
        return this.swaggerpersonDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Swaggerperson> queryAllByLimit(int offset, int limit) {
        return this.swaggerpersonDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param swaggerperson 实例对象
     * @return 实例对象
     */

    @Override
    public Swaggerperson insert(Swaggerperson swaggerperson) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = swaggerpersonDao.insert(swaggerperson);
                System.out.println(count);
                try {
                    Thread.sleep(3 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.submit(thread);
        //定义带返回值的线程
        Callable callable = new Thread2();
        MyFutureTask myFutureTask=new MyFutureTask(callable);
        new Thread(myFutureTask).start();
        //定义带返回值的线程
        Callable callable3 = new Thread3();
        MyFutureTask myFutureTask3=new MyFutureTask(callable3);
        new Thread(myFutureTask3).start();
        Swaggerperson swaggerpersonT = null;
        try {
            swaggerpersonT =(Swaggerperson)myFutureTask.get();
            System.out.println("2=="+swaggerpersonT.toString());
            Swaggerperson swaggerpersonk=(Swaggerperson) myFutureTask3.get();
            System.out.println("3==="+swaggerpersonk.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return swaggerpersonT;
    }

    class Thread2 implements Callable {
        @Override
        public Swaggerperson call() {
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Swaggerperson swaggerpersons = swaggerpersonDao.queryById(1);
            return swaggerpersons;

        }
    }
    class Thread3 implements Callable {
        @Override
        public Swaggerperson call() {
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Swaggerperson swaggerpersons = swaggerpersonDao.queryById(18);
            return swaggerpersons;

        }
    }

    /**
     * 修改数据
     *
     * @param swaggerperson 实例对象
     * @return 实例对象
     */
    @Override
    public Swaggerperson update(Swaggerperson swaggerperson) {
        this.swaggerpersonDao.update(swaggerperson);
        return this.queryById(swaggerperson.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.swaggerpersonDao.deleteById(id) > 0;
    }
}