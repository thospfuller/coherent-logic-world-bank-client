package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.Indicator;
import com.coherentlogic.wb.client.db.integration.repositories.IndicatorRepository;

/**
 * Repository service implementation for working with Indicator data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.Indicator}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(IndicatorService.BEAN_NAME)
@Transactional
public class IndicatorService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "indicatorService";

    @Autowired
    private IndicatorRepository indicatorRepository;

    public IndicatorRepository getindicatorRepository() {
        return indicatorRepository;
    }

    void setIndicatorRepository(IndicatorRepository indicatorRepository) {
        this.indicatorRepository =  indicatorRepository;
    }

    public long count() {
        return indicatorRepository.count();
    }

    public <S extends Indicator> long count(Example<S> example) {
        return indicatorRepository.count(example);
    }

    public void delete(Indicator target) {
        indicatorRepository.delete(target);
    }

    public void delete(Iterable<? extends Indicator> iterable) {
        indicatorRepository.delete(iterable);
    }

    public void delete(Long id) {
        indicatorRepository.delete(id);
    }

    public void deleteAll() {
        indicatorRepository.deleteAll();
    }

    public List<Indicator> findAll(Sort sort) {
        return indicatorRepository.findAll(sort);
    }

    public List<Indicator> findAll(Iterable<Long> ids) {
        return indicatorRepository.findAll(ids);
    }

    public <S extends Indicator> List<S> save(Iterable<S> entities) {
        return indicatorRepository.save(entities);
    }

    public void flush() {
        indicatorRepository.flush();
    }

    public <S extends Indicator> S saveAndFlush(S entity) {
        return indicatorRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<Indicator> entities) {
        indicatorRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        indicatorRepository.deleteAllInBatch();
    }

    public <S extends Indicator> boolean exists(Example<S> example) {
        return indicatorRepository.exists(example);
    }

    public boolean exists(Long id) {
        return indicatorRepository.exists(id);
    }

    public List<Indicator> findAll() {
        return indicatorRepository.findAll();
    }

    public <S extends Indicator> Page<S> findAll(Example<S> example, Pageable pageable) {
        return indicatorRepository.findAll(example, pageable);
    }

    public Indicator getOne(Long id) {
        return indicatorRepository.getOne(id);
    }

    public <S extends Indicator> List<S> findAll(Example<S> example) {
        return indicatorRepository.findAll(example);
    }

    public <S extends Indicator> List<S> findAll(Example<S> example, Sort sort) {
        return indicatorRepository.findAll(example, sort);
    }

    public Page<Indicator> findAll(Pageable pageable) {
        return indicatorRepository.findAll(pageable);
    }

    public <S extends Indicator> S findOne(Example<S> example) {
        return indicatorRepository.findOne(example);
    }

    public Indicator findOne(Long id) {
        return indicatorRepository.findOne(id);
    }

    public <S extends Indicator> S save(S entity) {
        return indicatorRepository.save(entity);
    }
}

