package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.AdminRegion;
import com.coherentlogic.wb.client.db.integration.repositories.AdminRegionRepository;

/**
 * Repository service implementation for working with AdminRegion data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.AdminRegion}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(AdminRegionService.BEAN_NAME)
@Transactional
public class AdminRegionService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "adminRegionService";

    @Autowired
    private AdminRegionRepository adminRegionRepository;

    public AdminRegionRepository getadminRegionRepository() {
        return adminRegionRepository;
    }

    void setAdminRegionRepository(AdminRegionRepository adminRegionRepository) {
        this.adminRegionRepository =  adminRegionRepository;
    }

    public long count() {
        return adminRegionRepository.count();
    }

    public <S extends AdminRegion> long count(Example<S> example) {
        return adminRegionRepository.count(example);
    }

    public void delete(AdminRegion target) {
        adminRegionRepository.delete(target);
    }

    public void delete(Iterable<? extends AdminRegion> iterable) {
        adminRegionRepository.delete(iterable);
    }

    public void delete(Long id) {
        adminRegionRepository.delete(id);
    }

    public void deleteAll() {
        adminRegionRepository.deleteAll();
    }

    public List<AdminRegion> findAll(Sort sort) {
        return adminRegionRepository.findAll(sort);
    }

    public List<AdminRegion> findAll(Iterable<Long> ids) {
        return adminRegionRepository.findAll(ids);
    }

    public <S extends AdminRegion> List<S> save(Iterable<S> entities) {
        return adminRegionRepository.save(entities);
    }

    public void flush() {
        adminRegionRepository.flush();
    }

    public <S extends AdminRegion> S saveAndFlush(S entity) {
        return adminRegionRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<AdminRegion> entities) {
        adminRegionRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        adminRegionRepository.deleteAllInBatch();
    }

    public <S extends AdminRegion> boolean exists(Example<S> example) {
        return adminRegionRepository.exists(example);
    }

    public boolean exists(Long id) {
        return adminRegionRepository.exists(id);
    }

    public List<AdminRegion> findAll() {
        return adminRegionRepository.findAll();
    }

    public <S extends AdminRegion> Page<S> findAll(Example<S> example, Pageable pageable) {
        return adminRegionRepository.findAll(example, pageable);
    }

    public AdminRegion getOne(Long id) {
        return adminRegionRepository.getOne(id);
    }

    public <S extends AdminRegion> List<S> findAll(Example<S> example) {
        return adminRegionRepository.findAll(example);
    }

    public <S extends AdminRegion> List<S> findAll(Example<S> example, Sort sort) {
        return adminRegionRepository.findAll(example, sort);
    }

    public Page<AdminRegion> findAll(Pageable pageable) {
        return adminRegionRepository.findAll(pageable);
    }

    public <S extends AdminRegion> S findOne(Example<S> example) {
        return adminRegionRepository.findOne(example);
    }

    public AdminRegion findOne(Long id) {
        return adminRegionRepository.findOne(id);
    }

    public <S extends AdminRegion> S save(S entity) {
        return adminRegionRepository.save(entity);
    }
}

