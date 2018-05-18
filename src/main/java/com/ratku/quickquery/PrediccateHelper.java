
package com.ratku.quickquery;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ratku.sample.dataobject.UcUser;

public class PrediccateHelper {

	///create search Predicate
	private static Predicate toPredicateSearch(CriteriaBuilder cb,Expression<String> path,  Object fieldValue,CriteriaOperate criteriaOperate) {
		switch(criteriaOperate)
		{
		case Contains:
			return cb.like(path, String.format("%%%s%%", fieldValue));
		case EndWith:
			return cb.like(path, String.format("%s%%", fieldValue));
		case Equal:
			return cb.equal(path, fieldValue);	
		case IsNotNull:
			return cb.isNotNull(path);
		case IsNull:
			return cb.isNull(path);
		case In:
			return path.in(fieldValue);
		case Like:
			return cb.like(path, String.valueOf(fieldValue));
		case StartWith:
			return cb.like(path, String.format("%%%s", fieldValue));
		case Unequal:
			return cb.notEqual(path, fieldValue);
		case Unlike:
			return cb.notLike(path, String.format("%{0}%", fieldValue));
		default:
			break;	
		}		
		return null;
	}
	
	///create Comparable Predicate
	@SuppressWarnings("unchecked")
	private static <Y extends Comparable<? super Y>> Predicate toPredicateCompare(CriteriaBuilder cb, Path<Y> path,  Object fieldValue,CriteriaOperate criteriaOperate) {
		
		switch(criteriaOperate)
		{	
		case Greater:
			return cb.greaterThan(path, (Y)fieldValue);
		case GreaterOrEqual:
			return cb.greaterThanOrEqualTo(path, (Y)fieldValue);
		case Lesser:
			return cb.lessThan(path, (Y)fieldValue);
		case LesserOrEqual:
			return cb.lessThanOrEqualTo(path, (Y)fieldValue);		
		default:
			break;
		}		
		return null;
	}
			
	private static <T> Predicate toPredicate(Root<T> root, CriteriaBuilder cb, CriteriaFieldInfo info) {
		if (!info.IsAppendQuery()) {
			return null;
		}

		Predicate p = null;
		try {
			CriteriaOperateType ctype = CriteriaOperateType.GetCriteriaOperateType(info.criteriaOperate);

			switch (ctype) {
			case Compare: {
				Path<Integer> path = root.<Integer> get(info.fieldName);
				p = toPredicateCompare(cb, path, info.fieldValue, info.criteriaOperate);
			}
				break;
			case Search: {
				Expression<String> path = root.get(info.fieldName);
				p = toPredicateSearch(cb, path, info.fieldValue, info.criteriaOperate);
			}
				break;
			default:
				break;

			}
		} catch (Exception ex) {

		}

		return p;

	}
	
	public static <T> Predicate toPredicate(Root<T> root, CriteriaBuilder cb, List<CriteriaFieldInfo> infoList) {
		Predicate p1 = null;
		for (int i = 0; i < infoList.size(); i++) {
			Predicate p2 = toPredicate(root, cb, infoList.get(i));
			if (p2 != null) {
				if (p1 == null) {
					p1 = p2;
				} else {
					p1 = cb.and(p1, p2);
				}
			}
		}
		return p1;
	}
	
	public static <T> Predicate toPredicate(Root<T> root, CriteriaBuilder cb, Object CriteriaObject) {
		List<CriteriaFieldInfo> infoList =CriteriaFieldHelper.GetCriteriaFieldMapInfo(CriteriaObject);	
		return toPredicate(root,cb,infoList);
	}
	
	public static <T> Predicate toPredicate(Root<T> root, CriteriaBuilder cb, Object CriteriaObject,Class<?> userCla) {
		List<CriteriaFieldInfo> infoList =CriteriaFieldHelper.GetCriteriaFieldMapInfo(CriteriaObject,userCla);	
		return toPredicate(root,cb,infoList);
	}
	
	
}
