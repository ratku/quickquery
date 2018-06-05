
package com.ratku.quickquery;

import java.util.ArrayList;
import java.util.List;

public class CriteriaOperateHelper {

	
	private static String CriteriaOperateNames = 
			"None,Equal,Greater,GreaterOrEqual,Lesser,esserOrEqual"
			+",Unequal,Like,Unlike,IsNull,IsNotNull,"
			+"In,StartWith,EndWith,Contains";
	
	public static ConditionField GetConditionFieldFromString(String Criteria)
	{
		String[] CriteriaOperateNameArray = CriteriaOperateNames.split(",");
		
		String[] CriteriaOperateNames = evaluate(CriteriaOperateNameArray); 
		
		for(String coName :CriteriaOperateNames)
		{
			if(Criteria.startsWith(coName))
			{
				ConditionField condition = new ConditionField();
				condition.criteriaOperate =CriteriaOperate.valueOf(CriteriaOperate.class, coName);
				condition.fieldName = Criteria.replaceFirst(coName, "");
				return condition;
			}
		}		
		return null;
	}
	
		  
	private static String[] evaluate(String[] strarr) {  
	  
	        try {  
	            List<String> result = new ArrayList<>();  
	            String temp;  
	            for (int i = 0; i < strarr.length; i++) {  
	                for (int j = strarr.length - 1; j > i; j--) {  
	                	
	                	//>  or  <
	                    if (strarr[i].length() < strarr[j].length()) {  
	  
	                        temp = strarr[i];  
	                        strarr[i] = strarr[j];  
	                        strarr[j] = temp;  
	                    }  
	                }  
	            }  
	            
	            for (int i = 0; i < strarr.length; i++) {  
	                int flag = 0;  
	                for (int j = i + 1; j < strarr.length; j++) {  
	                    if (strarr[j].indexOf(strarr[i]) != -1) {  
	                        flag = 1;  
	                        continue;  
	                    }  
	                }  
	                if (flag == 0) {  
	                    result.add(strarr[i]);  
	                }  
	            }  
	  
	            int ressize = result.size();  
	            String[] resArr = new String[ressize];  
	            for (int i = 0; i < ressize; i++) {  
	                resArr[i] = result.get(i);  
	            }  
	            return resArr;  
	        } catch (Exception e) {  
	  
	        }  
	        return null;  
	    }  
}
