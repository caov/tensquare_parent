package com.tensquare.user.dao;

import com.tensquare.user.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @program: tensquare_parent
 * @description: 管理员dao层
 * @author: cf
 * @create: 2019-06-17 10:55
 */
public interface AdminDao extends JpaRepository<Admin,String>, JpaSpecificationExecutor<Admin> {
   Admin findByLoginname(String loginname);
}
