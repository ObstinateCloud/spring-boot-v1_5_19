package com.lenged.springbootv1_5_19.dao;

/**
 * @title: SysUserDao
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/5/7 11:07
 */

import com.lenged.springbootv1_5_19.bo.EsUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 第一种方式，类似于JPA，编写一个ElasticsearchRepository
 *  第一个泛型为Bean的类型
 *  第二个泛型为Bean的主键类型
 */

@Repository
public interface SysUserDao  {

    List<EsUser> findSysUsersByUsername(String username);

    List<EsUser> findByUsername(String username);

    List<EsUser> findByLevelGreaterThanEqual(int level);

    List<EsUser> findSysUsersByLevelGreaterThanEqual(int level);

}
