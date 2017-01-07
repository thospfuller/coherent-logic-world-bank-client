package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.DataPointIndicator;
import com.coherentlogic.wb.client.db.integration.repositories.DataPointIndicatorRepository;

/**
 * Repository service implementation for working with DataPointIndicator data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.DataPointIndicator}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(DataPointIndicatorService.BEAN_NAME)
@Transactional
public class DataPointIndicatorService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "dataPointIndicatorService";

    @Autowired
    private DataPointIndicatorRepository dataPointIndicatorRepository;

    public DataPointIndicatorRepository getDataPointIndicatorRepository() {
        return dataPointIndicatorRepository;
    }

    void setDataPointIndicatorRepository(DataPointIndicatorRepository dataPointIndicatorRepository) {
        this.dataPointIndicatorRepository =  dataPointIndicatorRepository;
    }

    public long count() {
        return dataPointIndicatorRepository.count();
    }

    public <S extends DataPointIndicator> long count(Example<S> example) {
        return dataPointIndicatorRepository.count(example);
    }

    public void delete(DataPointIndicator target) {
        dataPointIndicatorRepository.delete(target);
    }

    public void delete(Iterable<? extends DataPointIndicator> iterable) {
        dataPointIndicatorRepository.delete(iterable);
    }

    public void delete(Long id) {
        dataPointIndicatorRepository.delete(id);
    }

    public void deleteAll() {
        dataPointIndicatorRepository.deleteAll();
    }

    public List<DataPointIndicator> findAll(Sort sort) {
        return dataPointIndicatorRepository.findAll(sort);
    }

    public List<DataPointIndicator> findAll(Iterable<Long> ids) {
        return dataPointIndicatorRepository.findAll(ids);
    }

    public <S extends DataPointIndicator> List<S> save(Iterable<S> entities) {
        return dataPointIndicatorRepository.save(entities);
    }

    public void flush() {
        dataPointIndicatorRepository.flush();
    }

    public <S extends DataPointIndicator> S saveAndFlush(S entity) {
        return dataPointIndicatorRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<DataPointIndicator> entities) {
        dataPointIndicatorRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        dataPointIndicatorRepository.deleteAllInBatch();
    }

    public <S extends DataPointIndicator> boolean exists(Example<S> example) {
        return dataPointIndicatorRepository.exists(example);
    }

    public boolean exists(Long id) {
        return dataPointIndicatorRepository.exists(id);
    }

    public List<DataPointIndicator> findAll() {
        return dataPointIndicatorRepository.findAll();
    }

    public <S extends DataPointIndicator> Page<S> findAll(Example<S> example, Pageable pageable) {
        return dataPointIndicatorRepository.findAll(example, pageable);
    }

    public DataPointIndicator getOne(Long id) {
        return dataPointIndicatorRepository.getOne(id);
    }

    public <S extends DataPointIndicator> List<S> findAll(Example<S> example) {
        return dataPointIndicatorRepository.findAll(example);
    }

    public <S extends DataPointIndicator> List<S> findAll(Example<S> example, Sort sort) {
        return dataPointIndicatorRepository.findAll(example, sort);
    }

    public Page<DataPointIndicator> findAll(Pageable pageable) {
        return dataPointIndicatorRepository.findAll(pageable);
    }

    public <S extends DataPointIndicator> S findOne(Example<S> example) {
        return dataPointIndicatorRepository.findOne(example);
    }

    public DataPointIndicator findOne(Long id) {
        return dataPointIndicatorRepository.findOne(id);
    }

    public <S extends DataPointIndicator> S save(S entity) {
        return dataPointIndicatorRepository.save(entity);
    }
}
