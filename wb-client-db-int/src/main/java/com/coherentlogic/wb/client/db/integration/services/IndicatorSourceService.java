package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.IndicatorSource;
import com.coherentlogic.wb.client.db.integration.repositories.IndicatorSourceRepository;

/**
 * Repository service implementation for working with IndicatorSource data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.IndicatorSource}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(IndicatorSourceService.BEAN_NAME)
@Transactional
public class IndicatorSourceService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "indicatorSourceService";

    @Autowired
    private IndicatorSourceRepository indicatorSourceRepository;

    public IndicatorSourceRepository getindicatorSourceRepository() {
        return indicatorSourceRepository;
    }

    void setIndicatorSourceRepository(IndicatorSourceRepository indicatorSourceRepository) {
        this.indicatorSourceRepository =  indicatorSourceRepository;
    }

    public long count() {
        return indicatorSourceRepository.count();
    }

    public <S extends IndicatorSource> long count(Example<S> example) {
        return indicatorSourceRepository.count(example);
    }

    public void delete(IndicatorSource target) {
        indicatorSourceRepository.delete(target);
    }

    public void delete(Iterable<? extends IndicatorSource> iterable) {
        indicatorSourceRepository.delete(iterable);
    }

    public void delete(Long id) {
        indicatorSourceRepository.delete(id);
    }

    public void deleteAll() {
        indicatorSourceRepository.deleteAll();
    }

    public List<IndicatorSource> findAll(Sort sort) {
        return indicatorSourceRepository.findAll(sort);
    }

    public List<IndicatorSource> findAll(Iterable<Long> ids) {
        return indicatorSourceRepository.findAll(ids);
    }

    public <S extends IndicatorSource> List<S> save(Iterable<S> entities) {
        return indicatorSourceRepository.save(entities);
    }

    public void flush() {
        indicatorSourceRepository.flush();
    }

    public <S extends IndicatorSource> S saveAndFlush(S entity) {
        return indicatorSourceRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<IndicatorSource> entities) {
        indicatorSourceRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        indicatorSourceRepository.deleteAllInBatch();
    }

    public <S extends IndicatorSource> boolean exists(Example<S> example) {
        return indicatorSourceRepository.exists(example);
    }

    public boolean exists(Long id) {
        return indicatorSourceRepository.exists(id);
    }

    public List<IndicatorSource> findAll() {
        return indicatorSourceRepository.findAll();
    }

    public <S extends IndicatorSource> Page<S> findAll(Example<S> example, Pageable pageable) {
        return indicatorSourceRepository.findAll(example, pageable);
    }

    public IndicatorSource getOne(Long id) {
        return indicatorSourceRepository.getOne(id);
    }

    public <S extends IndicatorSource> List<S> findAll(Example<S> example) {
        return indicatorSourceRepository.findAll(example);
    }

    public <S extends IndicatorSource> List<S> findAll(Example<S> example, Sort sort) {
        return indicatorSourceRepository.findAll(example, sort);
    }

    public Page<IndicatorSource> findAll(Pageable pageable) {
        return indicatorSourceRepository.findAll(pageable);
    }

    public <S extends IndicatorSource> S findOne(Example<S> example) {
        return indicatorSourceRepository.findOne(example);
    }

    public IndicatorSource findOne(Long id) {
        return indicatorSourceRepository.findOne(id);
    }

    public <S extends IndicatorSource> S save(S entity) {
        return indicatorSourceRepository.save(entity);
    }
}

