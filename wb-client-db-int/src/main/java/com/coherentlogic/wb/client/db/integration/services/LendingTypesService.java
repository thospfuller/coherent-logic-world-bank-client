package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.LendingTypes;
import com.coherentlogic.wb.client.db.integration.repositories.LendingTypesRepository;

/**
 * Repository service implementation for working with LendingTypes data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.LendingTypes}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(LendingTypesService.BEAN_NAME)
@Transactional
public class LendingTypesService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "lendingTypesService";

    @Autowired
    private LendingTypesRepository lendingTypesRepository;

    public LendingTypesRepository getLendingTypesRepository() {
        return lendingTypesRepository;
    }

    void setLendingTypesRepository(LendingTypesRepository lendingTypesRepository) {
        this.lendingTypesRepository =  lendingTypesRepository;
    }

    public long count() {
        return lendingTypesRepository.count();
    }

    public <S extends LendingTypes> long count(Example<S> example) {
        return lendingTypesRepository.count(example);
    }

    public void delete(LendingTypes target) {
        lendingTypesRepository.delete(target);
    }

    public void delete(Iterable<? extends LendingTypes> iterable) {
        lendingTypesRepository.delete(iterable);
    }

    public void delete(Long id) {
        lendingTypesRepository.delete(id);
    }

    public void deleteAll() {
        lendingTypesRepository.deleteAll();
    }

    public List<LendingTypes> findAll(Sort sort) {
        return lendingTypesRepository.findAll(sort);
    }

    public List<LendingTypes> findAll(Iterable<Long> ids) {
        return lendingTypesRepository.findAll(ids);
    }

    public <S extends LendingTypes> List<S> save(Iterable<S> entities) {
        return lendingTypesRepository.save(entities);
    }

    public void flush() {
        lendingTypesRepository.flush();
    }

    public <S extends LendingTypes> S saveAndFlush(S entity) {
        return lendingTypesRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<LendingTypes> entities) {
        lendingTypesRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        lendingTypesRepository.deleteAllInBatch();
    }

    public <S extends LendingTypes> boolean exists(Example<S> example) {
        return lendingTypesRepository.exists(example);
    }

    public boolean exists(Long id) {
        return lendingTypesRepository.exists(id);
    }

    public List<LendingTypes> findAll() {
        return lendingTypesRepository.findAll();
    }

    public <S extends LendingTypes> Page<S> findAll(Example<S> example, Pageable pageable) {
        return lendingTypesRepository.findAll(example, pageable);
    }

    public LendingTypes getOne(Long id) {
        return lendingTypesRepository.getOne(id);
    }

    public <S extends LendingTypes> List<S> findAll(Example<S> example) {
        return lendingTypesRepository.findAll(example);
    }

    public <S extends LendingTypes> List<S> findAll(Example<S> example, Sort sort) {
        return lendingTypesRepository.findAll(example, sort);
    }

    public Page<LendingTypes> findAll(Pageable pageable) {
        return lendingTypesRepository.findAll(pageable);
    }

    public <S extends LendingTypes> S findOne(Example<S> example) {
        return lendingTypesRepository.findOne(example);
    }

    public LendingTypes findOne(Long id) {
        return lendingTypesRepository.findOne(id);
    }

    public <S extends LendingTypes> S save(S entity) {
        return lendingTypesRepository.save(entity);
    }
}
