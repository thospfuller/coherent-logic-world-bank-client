package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.Topics;
import com.coherentlogic.wb.client.db.integration.repositories.TopicsRepository;

/**
 * Repository service implementation for working with Topics data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.Topics}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(TopicsService.BEAN_NAME)
@Transactional
public class TopicsService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "topicsService";

    @Autowired
    private TopicsRepository topicsRepository;

    public TopicsRepository getTopicsRepository() {
        return topicsRepository;
    }

    void setTopicsRepository(TopicsRepository topicsRepository) {
        this.topicsRepository =  topicsRepository;
    }

    public long count() {
        return topicsRepository.count();
    }

    public <S extends Topics> long count(Example<S> example) {
        return topicsRepository.count(example);
    }

    public void delete(Topics target) {
        topicsRepository.delete(target);
    }

    public void delete(Iterable<? extends Topics> iterable) {
        topicsRepository.delete(iterable);
    }

    public void delete(Long id) {
        topicsRepository.delete(id);
    }

    public void deleteAll() {
        topicsRepository.deleteAll();
    }

    public List<Topics> findAll(Sort sort) {
        return topicsRepository.findAll(sort);
    }

    public List<Topics> findAll(Iterable<Long> ids) {
        return topicsRepository.findAll(ids);
    }

    public <S extends Topics> List<S> save(Iterable<S> entities) {
        return topicsRepository.save(entities);
    }

    public void flush() {
        topicsRepository.flush();
    }

    public <S extends Topics> S saveAndFlush(S entity) {
        return topicsRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<Topics> entities) {
        topicsRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        topicsRepository.deleteAllInBatch();
    }

    public <S extends Topics> boolean exists(Example<S> example) {
        return topicsRepository.exists(example);
    }

    public boolean exists(Long id) {
        return topicsRepository.exists(id);
    }

    public List<Topics> findAll() {
        return topicsRepository.findAll();
    }

    public <S extends Topics> Page<S> findAll(Example<S> example, Pageable pageable) {
        return topicsRepository.findAll(example, pageable);
    }

    public Topics getOne(Long id) {
        return topicsRepository.getOne(id);
    }

    public <S extends Topics> List<S> findAll(Example<S> example) {
        return topicsRepository.findAll(example);
    }

    public <S extends Topics> List<S> findAll(Example<S> example, Sort sort) {
        return topicsRepository.findAll(example, sort);
    }

    public Page<Topics> findAll(Pageable pageable) {
        return topicsRepository.findAll(pageable);
    }

    public <S extends Topics> S findOne(Example<S> example) {
        return topicsRepository.findOne(example);
    }

    public Topics findOne(Long id) {
        return topicsRepository.findOne(id);
    }

    public <S extends Topics> S save(S entity) {
        return topicsRepository.save(entity);
    }
}
