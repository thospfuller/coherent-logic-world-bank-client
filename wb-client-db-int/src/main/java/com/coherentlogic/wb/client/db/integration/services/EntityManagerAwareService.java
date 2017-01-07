package com.coherentlogic.wb.client.db.integration.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class EntityManagerAwareService {

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
