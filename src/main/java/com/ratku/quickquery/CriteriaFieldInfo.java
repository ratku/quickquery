package com.ratku.quickquery;

import java.lang.reflect.Field;

public class CriteriaFieldInfo {

	CriteriaOperate criteriaOperate;
	Object fieldValue ;
	Object ignoreValue ;
	String fieldName ;
	Field field;
	//Boolean comparable;
	
	public Boolean IsAppendQuery() {

		switch (this.criteriaOperate) {
		case IsNotNull:
			return true;
		case IsNull:
			return true;
		default:
			break;
		}
		return (fieldValue != null) && !ignoreValue.equals(fieldValue);

	}
}
