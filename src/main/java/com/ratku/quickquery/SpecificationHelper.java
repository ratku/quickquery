
package com.ratku.quickquery;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class SpecificationHelper{

	public static <T> Specification<T> getSpecification(Object CriteriaObject) {
		
		   return new Specification<T>() {
		     @Override
		     public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		       Predicate p1 = null;
		       p1 =PrediccateHelper.toPredicate(root, cb, CriteriaObject);	       
		       return p1;
		     }
		   };
		 }
}
