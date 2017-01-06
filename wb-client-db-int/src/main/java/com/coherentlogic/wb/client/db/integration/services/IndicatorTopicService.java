package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.IndicatorTopic;
import com.coherentlogic.wb.client.db.integration.repositories.IndicatorTopicRepository;

/**
 * Repository service implementation for working with IndicatorTopic data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.IndicatorTopic}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(IndicatorTopicService.BEAN_NAME)
@Transactional
public class IndicatorTopicService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "indicatorTopicService";

    @Autowired
    private IndicatorTopicRepository indicatorTopicRepository;

    public IndicatorTopicRepository getindicatorTopicRepository() {
        return indicatorTopicRepository;
    }

    void setIndicatorTopicRepository(IndicatorTopicRepository indicatorTopicRepository) {
        this.indicatorTopicRepository =  indicatorTopicRepository;
    }

    public long count() {
        return indicatorTopicRepository.count();
    }

    public <S extends IndicatorTopic> long count(Example<S> example) {
        return indicatorTopicRepository.count(example);
    }

    public void delete(IndicatorTopic target) {
        indicatorTopicRepository.delete(target);
    }

    public void delete(Iterable<? extends IndicatorTopic> iterable) {
        indicatorTopicRepository.delete(iterable);
    }

    public void delete(Long id) {
        indicatorTopicRepository.delete(id);
    }

    public void deleteAll() {
        indicatorTopicRepository.deleteAll();
    }

    public List<IndicatorTopic> findAll(Sort sort) {
        return indicatorTopicRepository.findAll(sort);
    }

    public List<IndicatorTopic> findAll(Iterable<Long> ids) {
        return indicatorTopicRepository.findAll(ids);
    }

    public <S extends IndicatorTopic> List<S> save(Iterable<S> entities) {
        return indicatorTopicRepository.save(entities);
    }

    public void flush() {
        indicatorTopicRepository.flush();
    }

    public <S extends IndicatorTopic> S saveAndFlush(S entity) {
        return indicatorTopicRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<IndicatorTopic> entities) {
        indicatorTopicRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        indicatorTopicRepository.deleteAllInBatch();
    }

    public <S extends IndicatorTopic> boolean exists(Example<S> example) {
        return indicatorTopicRepository.exists(example);
    }

    public boolean exists(Long id) {
        return indicatorTopicRepository.exists(id);
    }

    public List<IndicatorTopic> findAll() {
        return indicatorTopicRepository.findAll();
    }

    public <S extends IndicatorTopic> Page<S> findAll(Example<S> example, Pageable pageable) {
        return indicatorTopicRepository.findAll(example, pageable);
    }

    public IndicatorTopic getOne(Long id) {
        return indicatorTopicRepository.getOne(id);
    }

    public <S extends IndicatorTopic> List<S> findAll(Example<S> example) {
        return indicatorTopicRepository.findAll(example);
    }

    public <S extends IndicatorTopic> List<S> findAll(Example<S> example, Sort sort) {
        return indicatorTopicRepository.findAll(example, sort);
    }

    public Page<IndicatorTopic> findAll(Pageable pageable) {
        return indicatorTopicRepository.findAll(pageable);
    }

    public <S extends IndicatorTopic> S findOne(Example<S> example) {
        return indicatorTopicRepository.findOne(example);
    }

    public IndicatorTopic findOne(Long id) {
        return indicatorTopicRepository.findOne(id);
    }

    public <S extends IndicatorTopic> S save(S entity) {
        return indicatorTopicRepository.save(entity);
    }
}

