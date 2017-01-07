package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.IndicatorTopics;
import com.coherentlogic.wb.client.db.integration.repositories.IndicatorTopicsRepository;

/**
 * Repository service implementation for working with IndicatorTopics data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.IndicatorTopics}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(IndicatorTopicsService.BEAN_NAME)
@Transactional
public class IndicatorTopicsService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "indicatorTopicsService";

    @Autowired
    private IndicatorTopicsRepository indicatorTopicsRepository;

    public IndicatorTopicsRepository getIndicatorTopicsRepository() {
        return indicatorTopicsRepository;
    }

    void setIndicatorTopicsRepository(IndicatorTopicsRepository indicatorTopicsRepository) {
        this.indicatorTopicsRepository =  indicatorTopicsRepository;
    }

    public long count() {
        return indicatorTopicsRepository.count();
    }

    public <S extends IndicatorTopics> long count(Example<S> example) {
        return indicatorTopicsRepository.count(example);
    }

    public void delete(IndicatorTopics target) {
        indicatorTopicsRepository.delete(target);
    }

    public void delete(Iterable<? extends IndicatorTopics> iterable) {
        indicatorTopicsRepository.delete(iterable);
    }

    public void delete(Long id) {
        indicatorTopicsRepository.delete(id);
    }

    public void deleteAll() {
        indicatorTopicsRepository.deleteAll();
    }

    public List<IndicatorTopics> findAll(Sort sort) {
        return indicatorTopicsRepository.findAll(sort);
    }

    public List<IndicatorTopics> findAll(Iterable<Long> ids) {
        return indicatorTopicsRepository.findAll(ids);
    }

    public <S extends IndicatorTopics> List<S> save(Iterable<S> entities) {
        return indicatorTopicsRepository.save(entities);
    }

    public void flush() {
        indicatorTopicsRepository.flush();
    }

    public <S extends IndicatorTopics> S saveAndFlush(S entity) {
        return indicatorTopicsRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<IndicatorTopics> entities) {
        indicatorTopicsRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        indicatorTopicsRepository.deleteAllInBatch();
    }

    public <S extends IndicatorTopics> boolean exists(Example<S> example) {
        return indicatorTopicsRepository.exists(example);
    }

    public boolean exists(Long id) {
        return indicatorTopicsRepository.exists(id);
    }

    public List<IndicatorTopics> findAll() {
        return indicatorTopicsRepository.findAll();
    }

    public <S extends IndicatorTopics> Page<S> findAll(Example<S> example, Pageable pageable) {
        return indicatorTopicsRepository.findAll(example, pageable);
    }

    public IndicatorTopics getOne(Long id) {
        return indicatorTopicsRepository.getOne(id);
    }

    public <S extends IndicatorTopics> List<S> findAll(Example<S> example) {
        return indicatorTopicsRepository.findAll(example);
    }

    public <S extends IndicatorTopics> List<S> findAll(Example<S> example, Sort sort) {
        return indicatorTopicsRepository.findAll(example, sort);
    }

    public Page<IndicatorTopics> findAll(Pageable pageable) {
        return indicatorTopicsRepository.findAll(pageable);
    }

    public <S extends IndicatorTopics> S findOne(Example<S> example) {
        return indicatorTopicsRepository.findOne(example);
    }

    public IndicatorTopics findOne(Long id) {
        return indicatorTopicsRepository.findOne(id);
    }

    public <S extends IndicatorTopics> S save(S entity) {
        return indicatorTopicsRepository.save(entity);
    }
}

