package com.tensquare.gathering.dao;

import com.tensquare.gathering.pojo.Gathering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @program: tensquare_parent
 * @description: 招聘Dao层
 * @author: cf
 * @create: 2019-06-14 15:20
 */
public interface GatheringDao extends JpaRepository<Gathering,String>, JpaSpecificationExecutor<Gathering> {

}
