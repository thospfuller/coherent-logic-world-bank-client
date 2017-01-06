package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.Topic;
import com.coherentlogic.wb.client.db.integration.repositories.TopicRepository;

/**
 * Repository service implementation for working with Topic data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.Topic}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(TopicService.BEAN_NAME)
@Transactional
public class TopicService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "topicService";

    @Autowired
    private TopicRepository topicRepository;

    public TopicRepository gettopicRepository() {
        return topicRepository;
    }

    void setTopicRepository(TopicRepository topicRepository) {
        this.topicRepository =  topicRepository;
    }

    public long count() {
        return topicRepository.count();
    }

    public <S extends Topic> long count(Example<S> example) {
        return topicRepository.count(example);
    }

    public void delete(Topic target) {
        topicRepository.delete(target);
    }

    public void delete(Iterable<? extends Topic> iterable) {
        topicRepository.delete(iterable);
    }

    public void delete(Long id) {
        topicRepository.delete(id);
    }

    public void deleteAll() {
        topicRepository.deleteAll();
    }

    public List<Topic> findAll(Sort sort) {
        return topicRepository.findAll(sort);
    }

    public List<Topic> findAll(Iterable<Long> ids) {
        return topicRepository.findAll(ids);
    }

    public <S extends Topic> List<S> save(Iterable<S> entities) {
        return topicRepository.save(entities);
    }

    public void flush() {
        topicRepository.flush();
    }

    public <S extends Topic> S saveAndFlush(S entity) {
        return topicRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<Topic> entities) {
        topicRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        topicRepository.deleteAllInBatch();
    }

    public <S extends Topic> boolean exists(Example<S> example) {
        return topicRepository.exists(example);
    }

    public boolean exists(Long id) {
        return topicRepository.exists(id);
    }

    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    public <S extends Topic> Page<S> findAll(Example<S> example, Pageable pageable) {
        return topicRepository.findAll(example, pageable);
    }

    public Topic getOne(Long id) {
        return topicRepository.getOne(id);
    }

    public <S extends Topic> List<S> findAll(Example<S> example) {
        return topicRepository.findAll(example);
    }

    public <S extends Topic> List<S> findAll(Example<S> example, Sort sort) {
        return topicRepository.findAll(example, sort);
    }

    public Page<Topic> findAll(Pageable pageable) {
        return topicRepository.findAll(pageable);
    }

    public <S extends Topic> S findOne(Example<S> example) {
        return topicRepository.findOne(example);
    }

    public Topic findOne(Long id) {
        return topicRepository.findOne(id);
    }

    public <S extends Topic> S save(S entity) {
        return topicRepository.save(entity);
    }
}

