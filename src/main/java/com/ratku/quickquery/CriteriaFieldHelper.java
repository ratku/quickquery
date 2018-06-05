
package com.ratku.quickquery;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.ratku.sample.criteriadao.UcUserCriteriaFieldDao;

public class CriteriaFieldHelper {

	private static CriteriaFieldInfo GetCriteriaFieldMapInfo(Field field)
    {
		CriteriaField annotation =  field.getAnnotation(CriteriaField.class);
		if(annotation != null){	
			CriteriaFieldInfo info = new CriteriaFieldInfo();
			info.fieldName = field.getName();
			info.ignoreValue = annotation.IgnoreValue();
			info.criteriaOperate = annotation.criteriaOperate();
			info.field = field;
			return info;
		}
		else
		{
			return null;
		}
		
    }
		
	public static List<CriteriaFieldInfo> GetCriteriaFieldMapInfo(Class<?> userCla)
    {
		List<CriteriaFieldInfo> criteriaFieldInfoList = new ArrayList<CriteriaFieldInfo>();
		Field[] fields = userCla.getDeclaredFields();
		for(int i =0;i < fields.length;i++)
		{
			CriteriaFieldInfo info  =  GetCriteriaFieldMapInfo(fields[i]);
			if(info != null){
				criteriaFieldInfoList.add(info);
			}
		}			
        return criteriaFieldInfoList;
    }
}
