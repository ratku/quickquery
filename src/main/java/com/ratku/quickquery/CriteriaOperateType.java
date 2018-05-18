
package com.ratku.quickquery;

public enum CriteriaOperateType {

	None,
	Compare,
	Search,;
	
	public static CriteriaOperateType GetCriteriaOperateType(CriteriaOperate criteriaOperate)
	{
		switch(criteriaOperate)
		{
		case Contains:
			return CriteriaOperateType.Search;
		case EndWith:
			return CriteriaOperateType.Search;
		case Equal:
			return CriteriaOperateType.Search;
		case Greater:
			return CriteriaOperateType.Compare;
		case GreaterOrEqual:
			return CriteriaOperateType.Compare;
		case In:
			return CriteriaOperateType.Search;
		case IsNotNull:
			return CriteriaOperateType.Search;
		case IsNull:
			return CriteriaOperateType.Search;
		case Lesser:
			return CriteriaOperateType.Compare;
		case LesserOrEqual:
			return CriteriaOperateType.Compare;
		case Like:
			return CriteriaOperateType.Search;
		case None:
			return CriteriaOperateType.None;
		case StartWith:
			return CriteriaOperateType.Search;
		case Unequal:
			return CriteriaOperateType.Search;
		case Unlike:
			return CriteriaOperateType.Search;
		default:
			return CriteriaOperateType.None;
		
		}
		
	}

}
