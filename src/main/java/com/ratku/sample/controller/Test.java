package com.ratku.sample.controller;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ratku.quickquery.CriteriaField;
import com.ratku.quickquery.CriteriaFieldHelper;
import com.ratku.quickquery.CriteriaFieldInfo;
import com.ratku.quickquery.CriteriaOperate;
import com.ratku.quickquery.SpecificationHelper;
import com.ratku.sample.criteriadao.UcUserCriteriaFieldDao;
import com.ratku.sample.dao.UcUserDao;
import com.ratku.sample.dataobject.UcUser;
import com.ratku.sample.impl.UcUserDaoImpl;

@RestController
public class Test {
	
	@Autowired
	private UcUserDao ucUserDao;
	
	
	
//	@RequestMapping("/ass")
//	@ResponseBody
//	public String ttt() throws ClassNotFoundException {
//		
//		Field[] f = Class.forName("com.ratku.sample.controller.Test").getFields();
//		for(int i =0;i < f.length;i++)
//		{
//			CriteriaField annotation =  f[i].getAnnotation(CriteriaField.class);
//			return String.valueOf( annotation.criteriaOperate());
//		}	
//		return "123";
//	}
	
	@RequestMapping("/abc")
	@ResponseBody
	public List<UcUser> abc(String name,String code) {
		
		UcUserCriteriaFieldDao criteriaObj = new UcUserCriteriaFieldDao();	
		criteriaObj.name = name;
		criteriaObj.code = code;
		//Specification<UcUser> a = SpecificationHelper.<UcUser>getSpecification(criteriaObj);
		//List<UcUser> result = ucUserDao.findAll(a);
		List<UcUser> result = criteriaObj.Fetch();
		return result;
	
		//return "123";
	}
	
	
}
				