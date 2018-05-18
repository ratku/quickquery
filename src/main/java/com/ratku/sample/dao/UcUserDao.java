package com.ratku.sample.dao;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ratku.sample.dataobject.UcUser;

public interface UcUserDao extends JpaRepository<UcUser, Integer>,JpaSpecificationExecutor<UcUser>{

	UcUser findByPhone(String Phone);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE uc_user u SET u.NAME=?1 , u.CODE=?2, u.EMAIL=?3 , u.UPDATE_TIME=?4 ,u.UPDATE_USER=?5 WHERE u.USER_ID = ?6 ",nativeQuery = true)
	boolean updateNameByTenantId(String name,String code ,String email ,Date updateTime , String updateUser, String userID);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE uc_user u SET u.PASSWORD=?1 WHERE u.USER_ID = ?2 ",nativeQuery = true)
	boolean updatePasswordByUserId(String password, String userID);
	
	
}
