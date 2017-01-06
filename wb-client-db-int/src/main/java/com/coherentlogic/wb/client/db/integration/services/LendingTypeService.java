package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.LendingType;
import com.coherentlogic.wb.client.db.integration.repositories.LendingTypeRepository;

/**
 * Repository service implementation for working with LendingType data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.LendingType}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(LendingTypeService.BEAN_NAME)
@Transactional
public class LendingTypeService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "lendingTypeService";

    @Autowired
    private LendingTypeRepository lendingTypeRepository;

    public LendingTypeRepository getlendingTypeRepository() {
        return lendingTypeRepository;
    }

    void setLendingTypeRepository(LendingTypeRepository lendingTypeRepository) {
        this.lendingTypeRepository =  lendingTypeRepository;
    }

    public long count() {
        return lendingTypeRepository.count();
    }

    public <S extends LendingType> long count(Example<S> example) {
        return lendingTypeRepository.count(example);
    }

    public void delete(LendingType target) {
        lendingTypeRepository.delete(target);
    }

    public void delete(Iterable<? extends LendingType> iterable) {
        lendingTypeRepository.delete(iterable);
    }

    public void delete(Long id) {
        lendingTypeRepository.delete(id);
    }

    public void deleteAll() {
        lendingTypeRepository.deleteAll();
    }

    public List<LendingType> findAll(Sort sort) {
        return lendingTypeRepository.findAll(sort);
    }

    public List<LendingType> findAll(Iterable<Long> ids) {
        return lendingTypeRepository.findAll(ids);
    }

    public <S extends LendingType> List<S> save(Iterable<S> entities) {
        return lendingTypeRepository.save(entities);
    }

    public void flush() {
        lendingTypeRepository.flush();
    }

    public <S extends LendingType> S saveAndFlush(S entity) {
        return lendingTypeRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<LendingType> entities) {
        lendingTypeRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        lendingTypeRepository.deleteAllInBatch();
    }

    public <S extends LendingType> boolean exists(Example<S> example) {
        return lendingTypeRepository.exists(example);
    }

    public boolean exists(Long id) {
        return lendingTypeRepository.exists(id);
    }

    public List<LendingType> findAll() {
        return lendingTypeRepository.findAll();
    }

    public <S extends LendingType> Page<S> findAll(Example<S> example, Pageable pageable) {
        return lendingTypeRepository.findAll(example, pageable);
    }

    public LendingType getOne(Long id) {
        return lendingTypeRepository.getOne(id);
    }

    public <S extends LendingType> List<S> findAll(Example<S> example) {
        return lendingTypeRepository.findAll(example);
    }

    public <S extends LendingType> List<S> findAll(Example<S> example, Sort sort) {
        return lendingTypeRepository.findAll(example, sort);
    }

    public Page<LendingType> findAll(Pageable pageable) {
        return lendingTypeRepository.findAll(pageable);
    }

    public <S extends LendingType> S findOne(Example<S> example) {
        return lendingTypeRepository.findOne(example);
    }

    public LendingType findOne(Long id) {
        return lendingTypeRepository.findOne(id);
    }

    public <S extends LendingType> S save(S entity) {
        return lendingTypeRepository.save(entity);
    }
}

