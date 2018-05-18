package com.ratku.sample.criteriadao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import com.ratku.quickquery.CriteriaField;
import com.ratku.quickquery.CriteriaOperate;
import com.ratku.quickquery.PrediccateHelper;
import com.ratku.quickquery.SpecificationHelper;
import com.ratku.sample.dao.UcUserDao;
import com.ratku.sample.dataobject.UcUser;

public class UcUserCriteriaFieldDao {
	@CriteriaField(criteriaOperate = CriteriaOperate.Contains, IgnoreValue = "")
	public String name;

	@CriteriaField(criteriaOperate = CriteriaOperate.Equal, IgnoreValue = "")
	public String code;

	
	@Autowired
	private UcUserDao ucUserDao;
	
	public List<UcUser> Fetch() {
		Specification<UcUser> a = SpecificationHelper.getSpecification(this);
		List<UcUser> result = ucUserDao.findAll(a);
		return result;
	}
}
