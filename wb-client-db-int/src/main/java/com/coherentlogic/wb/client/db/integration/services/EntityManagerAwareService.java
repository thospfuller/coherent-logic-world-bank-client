package com.coherentlogic.wb.client.db.integration.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.coherentlogic.wb.client.db.integration.repositories.AdminRegionRepository;

public abstract class EntityManagerAwareService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AdminRegionRepository adminRegionRepository;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
