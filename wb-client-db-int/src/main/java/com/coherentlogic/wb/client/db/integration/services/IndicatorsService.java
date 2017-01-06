package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.Indicators;
import com.coherentlogic.wb.client.db.integration.repositories.IndicatorsRepository;

/**
 * Repository service implementation for working with Indicators data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.Indicators}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(IndicatorsService.BEAN_NAME)
@Transactional
public class IndicatorsService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "indicatorsService";

    @Autowired
    private IndicatorsRepository indicatorsRepository;

    public IndicatorsRepository getindicatorsRepository() {
        return indicatorsRepository;
    }

    void setIndicatorsRepository(IndicatorsRepository indicatorsRepository) {
        this.indicatorsRepository =  indicatorsRepository;
    }

    public long count() {
        return indicatorsRepository.count();
    }

    public <S extends Indicators> long count(Example<S> example) {
        return indicatorsRepository.count(example);
    }

    public void delete(Indicators target) {
        indicatorsRepository.delete(target);
    }

    public void delete(Iterable<? extends Indicators> iterable) {
        indicatorsRepository.delete(iterable);
    }

    public void delete(Long id) {
        indicatorsRepository.delete(id);
    }

    public void deleteAll() {
        indicatorsRepository.deleteAll();
    }

    public List<Indicators> findAll(Sort sort) {
        return indicatorsRepository.findAll(sort);
    }

    public List<Indicators> findAll(Iterable<Long> ids) {
        return indicatorsRepository.findAll(ids);
    }

    public <S extends Indicators> List<S> save(Iterable<S> entities) {
        return indicatorsRepository.save(entities);
    }

    public void flush() {
        indicatorsRepository.flush();
    }

    public <S extends Indicators> S saveAndFlush(S entity) {
        return indicatorsRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<Indicators> entities) {
        indicatorsRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        indicatorsRepository.deleteAllInBatch();
    }

    public <S extends Indicators> boolean exists(Example<S> example) {
        return indicatorsRepository.exists(example);
    }

    public boolean exists(Long id) {
        return indicatorsRepository.exists(id);
    }

    public List<Indicators> findAll() {
        return indicatorsRepository.findAll();
    }

    public <S extends Indicators> Page<S> findAll(Example<S> example, Pageable pageable) {
        return indicatorsRepository.findAll(example, pageable);
    }

    public Indicators getOne(Long id) {
        return indicatorsRepository.getOne(id);
    }

    public <S extends Indicators> List<S> findAll(Example<S> example) {
        return indicatorsRepository.findAll(example);
    }

    public <S extends Indicators> List<S> findAll(Example<S> example, Sort sort) {
        return indicatorsRepository.findAll(example, sort);
    }

    public Page<Indicators> findAll(Pageable pageable) {
        return indicatorsRepository.findAll(pageable);
    }

    public <S extends Indicators> S findOne(Example<S> example) {
        return indicatorsRepository.findOne(example);
    }

    public Indicators findOne(Long id) {
        return indicatorsRepository.findOne(id);
    }

    public <S extends Indicators> S save(S entity) {
        return indicatorsRepository.save(entity);
    }
}

