
package com.ratku.quickquery;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.ratku.sample.criteriadao.UcUserCriteriaFieldDao;

public class CriteriaFieldHelper {

	private static Object GetFieldValue(Object CriteriaObject,Field field)
    {	
		try {
			return field.get(CriteriaObject);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
	
	private static CriteriaFieldInfo GetCriteriaFieldMapInfo(Field field)
    {
		CriteriaField annotation =  field.getAnnotation(CriteriaField.class);
		if(annotation == null){
			return null;
		}	
		CriteriaFieldInfo info = new CriteriaFieldInfo();
		info.fieldName = field.getName();
		info.ignoreValue = annotation.IgnoreValue();
		info.criteriaOperate = annotation.criteriaOperate();
		info.field = field;
		return info;
    }
		
	public static List<CriteriaFieldInfo> GetCriteriaFieldMapInfo(Object CriteriaObject)
    {
		List<CriteriaFieldInfo> criteriaFieldInfoList = new ArrayList<CriteriaFieldInfo>();

		String className = CriteriaObject.getClass().getName().toString();
		className = className.split("\\$")[0];
		Class<?> userCla;
		try {
			userCla = Class.forName(className );
			criteriaFieldInfoList = GetCriteriaFieldMapInfo(CriteriaObject,userCla);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return criteriaFieldInfoList;
    }
	
	public static List<CriteriaFieldInfo> GetCriteriaFieldMapInfo(Object CriteriaObject,Class<?> userCla)
    {
		List<CriteriaFieldInfo> criteriaFieldInfoList = GetCriteriaFieldMapInfo(userCla);

		for(int i =0;i < criteriaFieldInfoList.size();i++)
		{
			CriteriaFieldInfo info  =  criteriaFieldInfoList.get(i);
			info.fieldValue = GetFieldValue(CriteriaObject,info.field);
		}	
	
        return criteriaFieldInfoList;
    }
	
	private static List<CriteriaFieldInfo> GetCriteriaFieldMapInfo(Class<?> userCla)
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
