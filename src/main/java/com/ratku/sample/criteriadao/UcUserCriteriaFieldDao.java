package com.ratku.sample.criteriadao;

import com.ratku.quickquery.CriteriaField;
import com.ratku.quickquery.CriteriaOperate;

public class UcUserCriteriaFieldDao {
	@CriteriaField(criteriaOperate = CriteriaOperate.Contains, IgnoreValue = "")
	public String name;

	@CriteriaField(criteriaOperate = CriteriaOperate.Equal, IgnoreValue = "")
	public String code;
}
