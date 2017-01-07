package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.IncomeLevel;
import com.coherentlogic.wb.client.db.integration.repositories.IncomeLevelRepository;

/**
 * Repository service implementation for working with IncomeLevel data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.IncomeLevel}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(IncomeLevelService.BEAN_NAME)
@Transactional
public class IncomeLevelService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "incomeLevelService";

    @Autowired
    private IncomeLevelRepository incomeLevelRepository;

    public IncomeLevelRepository getIncomeLevelRepository() {
        return incomeLevelRepository;
    }

    void setIncomeLevelRepository(IncomeLevelRepository incomeLevelRepository) {
        this.incomeLevelRepository =  incomeLevelRepository;
    }

    public long count() {
        return incomeLevelRepository.count();
    }

    public <S extends IncomeLevel> long count(Example<S> example) {
        return incomeLevelRepository.count(example);
    }

    public void delete(IncomeLevel target) {
        incomeLevelRepository.delete(target);
    }

    public void delete(Iterable<? extends IncomeLevel> iterable) {
        incomeLevelRepository.delete(iterable);
    }

    public void delete(Long id) {
        incomeLevelRepository.delete(id);
    }

    public void deleteAll() {
        incomeLevelRepository.deleteAll();
    }

    public List<IncomeLevel> findAll(Sort sort) {
        return incomeLevelRepository.findAll(sort);
    }

    public List<IncomeLevel> findAll(Iterable<Long> ids) {
        return incomeLevelRepository.findAll(ids);
    }

    public <S extends IncomeLevel> List<S> save(Iterable<S> entities) {
        return incomeLevelRepository.save(entities);
    }

    public void flush() {
        incomeLevelRepository.flush();
    }

    public <S extends IncomeLevel> S saveAndFlush(S entity) {
        return incomeLevelRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<IncomeLevel> entities) {
        incomeLevelRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        incomeLevelRepository.deleteAllInBatch();
    }

    public <S extends IncomeLevel> boolean exists(Example<S> example) {
        return incomeLevelRepository.exists(example);
    }

    public boolean exists(Long id) {
        return incomeLevelRepository.exists(id);
    }

    public List<IncomeLevel> findAll() {
        return incomeLevelRepository.findAll();
    }

    public <S extends IncomeLevel> Page<S> findAll(Example<S> example, Pageable pageable) {
        return incomeLevelRepository.findAll(example, pageable);
    }

    public IncomeLevel getOne(Long id) {
        return incomeLevelRepository.getOne(id);
    }

    public <S extends IncomeLevel> List<S> findAll(Example<S> example) {
        return incomeLevelRepository.findAll(example);
    }

    public <S extends IncomeLevel> List<S> findAll(Example<S> example, Sort sort) {
        return incomeLevelRepository.findAll(example, sort);
    }

    public Page<IncomeLevel> findAll(Pageable pageable) {
        return incomeLevelRepository.findAll(pageable);
    }

    public <S extends IncomeLevel> S findOne(Example<S> example) {
        return incomeLevelRepository.findOne(example);
    }

    public IncomeLevel findOne(Long id) {
        return incomeLevelRepository.findOne(id);
    }

    public <S extends IncomeLevel> S save(S entity) {
        return incomeLevelRepository.save(entity);
    }
}
