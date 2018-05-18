package com.ratku.sample.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ratku.sample.dataobject.UcUser;

public class UcUserExtendDao {

	@PersistenceContext(unitName = "springJpa")
	EntityManager em;

	@SuppressWarnings("unused")
	public List<UcUser> getUserInfo(String name, int age, int high) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<UcUser> query = cb.createQuery(UcUser.class);

		// from
		Root<UcUser> root = query.from(UcUser.class);

		// where
		Predicate p1 = null;
		if (name != null) {
			Predicate p2 = cb.equal(root.get("name"), name);
			if (p1 != null) {
				p1 = cb.and(p1, p2);
			} else {
				p1 = p2;
			}
		}

//		if (age != 0) {
//			Predicate p2 = cb.equal(root.get(UcUser.age), age);
//			if (p1 != null) {
//				p1 = cb.and(p1, p2);
//			} else {
//				p1 = p2;
//			}
//		}
//
//		if (high != 0) {
//			Predicate p2 = cb.equal(root.get(UcUser.high), high);
//			if (p1 != null) {
//				p1 = cb.and(p1, p2);
//			} else {
//				p1 = p2;
//			}
//		}
		query.where(p1);

		List<UcUser> userInfos = em.createQuery(query).getResultList();
		return userInfos;
	}
}