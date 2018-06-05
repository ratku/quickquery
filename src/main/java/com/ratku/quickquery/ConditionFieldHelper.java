
package com.ratku.quickquery;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ratku.sample.criteriadao.UcUserCriteriaFieldDao;

public class ConditionFieldHelper {

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
	
	///收集查询对象上有效的查询条件
	public static List<ConditionField> GetConditionFields(Object CriteriaObject)
    {
		String className = CriteriaObject.getClass().getName().toString();
		className = className.split("\\$")[0];
		Class<?> userCla;
		try {
			userCla = Class.forName(className );
			return GetConditionFields(CriteriaObject,userCla);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	///收集查询对象上有效的查询条件
	public static List<ConditionField> GetConditionFields(Object CriteriaObject,Class<?> userCla)
    {
		List<CriteriaFieldInfo> criteriaFieldInfoList = CriteriaFieldHelper.GetCriteriaFieldMapInfo(userCla);

		List<ConditionField> conditionFieldList = new ArrayList<ConditionField>();
		for(int i =0;i < criteriaFieldInfoList.size();i++)
		{
			CriteriaFieldInfo info  =  criteriaFieldInfoList.get(i);
			info.fieldValue = GetFieldValue(CriteriaObject,info.field);
			if(info.IsAppendQuery())
			{
				conditionFieldList.add(info);
			}
		}	
        return conditionFieldList;
    }
	
	public static List<ConditionField> GetConditionFields(Map<String, Object> CriteriaList)
    {
		List<ConditionField> conditionFieldList = new ArrayList<ConditionField>();
		
		for(Map.Entry<String, Object> entry : CriteriaList.entrySet()){  
			ConditionField info = CriteriaOperateHelper.GetConditionFieldFromString(entry.getKey());
			if(info != null)
			{	
				info.fieldValue = entry.getValue();
				conditionFieldList.add(info);
			}
        }   

        return conditionFieldList;
    }
	
}
