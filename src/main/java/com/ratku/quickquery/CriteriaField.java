package com.ratku.quickquery;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
//@Target( { ElementType.METHOD, ElementType.CONSTRUCTOR })
@Retention(RetentionPolicy.RUNTIME)
public @interface CriteriaField {

	CriteriaOperate criteriaOperate();
	
	String IgnoreValue() ;
}
