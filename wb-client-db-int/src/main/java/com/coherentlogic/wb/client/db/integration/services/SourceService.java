package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.Source;
import com.coherentlogic.wb.client.db.integration.repositories.SourceRepository;

/**
 * Repository service implementation for working with Source data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.Source}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(SourceService.BEAN_NAME)
@Transactional
public class SourceService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "sourceService";

    @Autowired
    private SourceRepository sourceRepository;

    public SourceRepository getsourceRepository() {
        return sourceRepository;
    }

    void setSourceRepository(SourceRepository sourceRepository) {
        this.sourceRepository =  sourceRepository;
    }

    public long count() {
        return sourceRepository.count();
    }

    public <S extends Source> long count(Example<S> example) {
        return sourceRepository.count(example);
    }

    public void delete(Source target) {
        sourceRepository.delete(target);
    }

    public void delete(Iterable<? extends Source> iterable) {
        sourceRepository.delete(iterable);
    }

    public void delete(Long id) {
        sourceRepository.delete(id);
    }

    public void deleteAll() {
        sourceRepository.deleteAll();
    }

    public List<Source> findAll(Sort sort) {
        return sourceRepository.findAll(sort);
    }

    public List<Source> findAll(Iterable<Long> ids) {
        return sourceRepository.findAll(ids);
    }

    public <S extends Source> List<S> save(Iterable<S> entities) {
        return sourceRepository.save(entities);
    }

    public void flush() {
        sourceRepository.flush();
    }

    public <S extends Source> S saveAndFlush(S entity) {
        return sourceRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<Source> entities) {
        sourceRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        sourceRepository.deleteAllInBatch();
    }

    public <S extends Source> boolean exists(Example<S> example) {
        return sourceRepository.exists(example);
    }

    public boolean exists(Long id) {
        return sourceRepository.exists(id);
    }

    public List<Source> findAll() {
        return sourceRepository.findAll();
    }

    public <S extends Source> Page<S> findAll(Example<S> example, Pageable pageable) {
        return sourceRepository.findAll(example, pageable);
    }

    public Source getOne(Long id) {
        return sourceRepository.getOne(id);
    }

    public <S extends Source> List<S> findAll(Example<S> example) {
        return sourceRepository.findAll(example);
    }

    public <S extends Source> List<S> findAll(Example<S> example, Sort sort) {
        return sourceRepository.findAll(example, sort);
    }

    public Page<Source> findAll(Pageable pageable) {
        return sourceRepository.findAll(pageable);
    }

    public <S extends Source> S findOne(Example<S> example) {
        return sourceRepository.findOne(example);
    }

    public Source findOne(Long id) {
        return sourceRepository.findOne(id);
    }

    public <S extends Source> S save(S entity) {
        return sourceRepository.save(entity);
    }
}

