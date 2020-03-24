package com.example.demo.test.Spring.service;

import com.example.demo.test.Spring.entity.Swaggerperson;
import java.util.List;

/**
 * (Swaggerperson)表服务接口
 *
 * @author makejava
 * @since 2020-03-05 10:57:47
 */
public interface SwaggerpersonService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Swaggerperson queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Swaggerperson> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param swaggerperson 实例对象
     * @return 实例对象
     */
    Swaggerperson insert(Swaggerperson swaggerperson);

    /**
     * 修改数据
     *
     * @param swaggerperson 实例对象
     * @return 实例对象
     */
    Swaggerperson update(Swaggerperson swaggerperson);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}