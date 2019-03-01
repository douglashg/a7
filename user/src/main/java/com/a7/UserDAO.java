package com.a7;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Default
public class UserDAO extends CommonDAO<UserJPA> {
    
	@Inject
	UserJPA userJPA;

	@Override
	public UserJPA getEntity() {
		return new UserJPA();
	}

	@PersistenceContext(unitName = "userPU")
	public EntityManager em;

	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}
