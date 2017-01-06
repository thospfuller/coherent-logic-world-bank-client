package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.DataPoint;
import com.coherentlogic.wb.client.db.integration.repositories.DataPointRepository;

/**
 * Repository service implementation for working with DataPoint data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.DataPoint}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(DataPointService.BEAN_NAME)
@Transactional
public class DataPointService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "dataPointService";

    @Autowired
    private DataPointRepository dataPointRepository;

    public DataPointRepository getdataPointRepository() {
        return dataPointRepository;
    }

    void setDataPointRepository(DataPointRepository dataPointRepository) {
        this.dataPointRepository =  dataPointRepository;
    }

    public long count() {
        return dataPointRepository.count();
    }

    public <S extends DataPoint> long count(Example<S> example) {
        return dataPointRepository.count(example);
    }

    public void delete(DataPoint target) {
        dataPointRepository.delete(target);
    }

    public void delete(Iterable<? extends DataPoint> iterable) {
        dataPointRepository.delete(iterable);
    }

    public void delete(Long id) {
        dataPointRepository.delete(id);
    }

    public void deleteAll() {
        dataPointRepository.deleteAll();
    }

    public List<DataPoint> findAll(Sort sort) {
        return dataPointRepository.findAll(sort);
    }

    public List<DataPoint> findAll(Iterable<Long> ids) {
        return dataPointRepository.findAll(ids);
    }

    public <S extends DataPoint> List<S> save(Iterable<S> entities) {
        return dataPointRepository.save(entities);
    }

    public void flush() {
        dataPointRepository.flush();
    }

    public <S extends DataPoint> S saveAndFlush(S entity) {
        return dataPointRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<DataPoint> entities) {
        dataPointRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        dataPointRepository.deleteAllInBatch();
    }

    public <S extends DataPoint> boolean exists(Example<S> example) {
        return dataPointRepository.exists(example);
    }

    public boolean exists(Long id) {
        return dataPointRepository.exists(id);
    }

    public List<DataPoint> findAll() {
        return dataPointRepository.findAll();
    }

    public <S extends DataPoint> Page<S> findAll(Example<S> example, Pageable pageable) {
        return dataPointRepository.findAll(example, pageable);
    }

    public DataPoint getOne(Long id) {
        return dataPointRepository.getOne(id);
    }

    public <S extends DataPoint> List<S> findAll(Example<S> example) {
        return dataPointRepository.findAll(example);
    }

    public <S extends DataPoint> List<S> findAll(Example<S> example, Sort sort) {
        return dataPointRepository.findAll(example, sort);
    }

    public Page<DataPoint> findAll(Pageable pageable) {
        return dataPointRepository.findAll(pageable);
    }

    public <S extends DataPoint> S findOne(Example<S> example) {
        return dataPointRepository.findOne(example);
    }

    public DataPoint findOne(Long id) {
        return dataPointRepository.findOne(id);
    }

    public <S extends DataPoint> S save(S entity) {
        return dataPointRepository.save(entity);
    }
}

