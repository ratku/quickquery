package com.ratku.sample.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ratku.quickquery.PrediccateHelper;
import com.ratku.sample.dao.UcUserDao;
import com.ratku.sample.dataobject.UcUser;

@Service
public abstract class UcUserDaoImpl implements UcUserDao{

	public static Specification<UcUser> getSpec(Object CriteriaObject) {
		
		Specification<UcUser> user = new Specification<UcUser>() {
		     @Override
		     public Predicate toPredicate(Root<UcUser> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		       Predicate p1 = null;
		       p1 = PrediccateHelper.toPredicate(root, cb, CriteriaObject);	       
		       return p1;	       
		     }
		   };
		   
		   return user;
		 }
}
