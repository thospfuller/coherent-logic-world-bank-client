package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.Region;
import com.coherentlogic.wb.client.db.integration.repositories.RegionRepository;

/**
 * Repository service implementation for working with Region data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.Region}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(RegionService.BEAN_NAME)
@Transactional
public class RegionService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "regionService";

    @Autowired
    private RegionRepository regionRepository;

    public RegionRepository getRegionRepository() {
        return regionRepository;
    }

    void setRegionRepository(RegionRepository regionRepository) {
        this.regionRepository =  regionRepository;
    }

    public long count() {
        return regionRepository.count();
    }

    public <S extends Region> long count(Example<S> example) {
        return regionRepository.count(example);
    }

    public void delete(Region target) {
        regionRepository.delete(target);
    }

    public void delete(Iterable<? extends Region> iterable) {
        regionRepository.delete(iterable);
    }

    public void delete(Long id) {
        regionRepository.delete(id);
    }

    public void deleteAll() {
        regionRepository.deleteAll();
    }

    public List<Region> findAll(Sort sort) {
        return regionRepository.findAll(sort);
    }

    public List<Region> findAll(Iterable<Long> ids) {
        return regionRepository.findAll(ids);
    }

    public <S extends Region> List<S> save(Iterable<S> entities) {
        return regionRepository.save(entities);
    }

    public void flush() {
        regionRepository.flush();
    }

    public <S extends Region> S saveAndFlush(S entity) {
        return regionRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<Region> entities) {
        regionRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        regionRepository.deleteAllInBatch();
    }

    public <S extends Region> boolean exists(Example<S> example) {
        return regionRepository.exists(example);
    }

    public boolean exists(Long id) {
        return regionRepository.exists(id);
    }

    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    public <S extends Region> Page<S> findAll(Example<S> example, Pageable pageable) {
        return regionRepository.findAll(example, pageable);
    }

    public Region getOne(Long id) {
        return regionRepository.getOne(id);
    }

    public <S extends Region> List<S> findAll(Example<S> example) {
        return regionRepository.findAll(example);
    }

    public <S extends Region> List<S> findAll(Example<S> example, Sort sort) {
        return regionRepository.findAll(example, sort);
    }

    public Page<Region> findAll(Pageable pageable) {
        return regionRepository.findAll(pageable);
    }

    public <S extends Region> S findOne(Example<S> example) {
        return regionRepository.findOne(example);
    }

    public Region findOne(Long id) {
        return regionRepository.findOne(id);
    }

    public <S extends Region> S save(S entity) {
        return regionRepository.save(entity);
    }
}
