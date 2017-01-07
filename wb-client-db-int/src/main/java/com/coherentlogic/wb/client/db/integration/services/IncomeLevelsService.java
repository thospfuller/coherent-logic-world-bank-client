package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.IncomeLevels;
import com.coherentlogic.wb.client.db.integration.repositories.IncomeLevelsRepository;

/**
 * Repository service implementation for working with IncomeLevels data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.IncomeLevels}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(IncomeLevelsService.BEAN_NAME)
@Transactional
public class IncomeLevelsService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "incomeLevelsService";

    @Autowired
    private IncomeLevelsRepository incomeLevelsRepository;

    public IncomeLevelsRepository getIncomeLevelsRepository() {
        return incomeLevelsRepository;
    }

    void setIncomeLevelsRepository(IncomeLevelsRepository incomeLevelsRepository) {
        this.incomeLevelsRepository =  incomeLevelsRepository;
    }

    public long count() {
        return incomeLevelsRepository.count();
    }

    public <S extends IncomeLevels> long count(Example<S> example) {
        return incomeLevelsRepository.count(example);
    }

    public void delete(IncomeLevels target) {
        incomeLevelsRepository.delete(target);
    }

    public void delete(Iterable<? extends IncomeLevels> iterable) {
        incomeLevelsRepository.delete(iterable);
    }

    public void delete(Long id) {
        incomeLevelsRepository.delete(id);
    }

    public void deleteAll() {
        incomeLevelsRepository.deleteAll();
    }

    public List<IncomeLevels> findAll(Sort sort) {
        return incomeLevelsRepository.findAll(sort);
    }

    public List<IncomeLevels> findAll(Iterable<Long> ids) {
        return incomeLevelsRepository.findAll(ids);
    }

    public <S extends IncomeLevels> List<S> save(Iterable<S> entities) {
        return incomeLevelsRepository.save(entities);
    }

    public void flush() {
        incomeLevelsRepository.flush();
    }

    public <S extends IncomeLevels> S saveAndFlush(S entity) {
        return incomeLevelsRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<IncomeLevels> entities) {
        incomeLevelsRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        incomeLevelsRepository.deleteAllInBatch();
    }

    public <S extends IncomeLevels> boolean exists(Example<S> example) {
        return incomeLevelsRepository.exists(example);
    }

    public boolean exists(Long id) {
        return incomeLevelsRepository.exists(id);
    }

    public List<IncomeLevels> findAll() {
        return incomeLevelsRepository.findAll();
    }

    public <S extends IncomeLevels> Page<S> findAll(Example<S> example, Pageable pageable) {
        return incomeLevelsRepository.findAll(example, pageable);
    }

    public IncomeLevels getOne(Long id) {
        return incomeLevelsRepository.getOne(id);
    }

    public <S extends IncomeLevels> List<S> findAll(Example<S> example) {
        return incomeLevelsRepository.findAll(example);
    }

    public <S extends IncomeLevels> List<S> findAll(Example<S> example, Sort sort) {
        return incomeLevelsRepository.findAll(example, sort);
    }

    public Page<IncomeLevels> findAll(Pageable pageable) {
        return incomeLevelsRepository.findAll(pageable);
    }

    public <S extends IncomeLevels> S findOne(Example<S> example) {
        return incomeLevelsRepository.findOne(example);
    }

    public IncomeLevels findOne(Long id) {
        return incomeLevelsRepository.findOne(id);
    }

    public <S extends IncomeLevels> S save(S entity) {
        return incomeLevelsRepository.save(entity);
    }
}
