package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

//接口可以多继承不可实现implement，类只能单继承多实现implement
public interface EnterpriseDao extends JpaRepository<Enterprise,String>, JpaSpecificationExecutor<Enterprise> {

    //面向对象的查询语句jphl。jphl类似于hql。hql是hibernate内部面向对象的查询语句
     List<Enterprise> findByIshot(String ishot);
}
