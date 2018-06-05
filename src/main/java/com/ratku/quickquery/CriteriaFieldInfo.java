package com.ratku.quickquery;

import java.lang.reflect.Field;

public class CriteriaFieldInfo extends ConditionField {

	Field field;
	
	Object ignoreValue ;
	
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
