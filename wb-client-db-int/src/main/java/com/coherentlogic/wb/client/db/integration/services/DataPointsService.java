package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.DataPoints;
import com.coherentlogic.wb.client.db.integration.repositories.DataPointsRepository;

/**
 * Repository service implementation for working with DataPoints data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.DataPoints}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(DataPointsService.BEAN_NAME)
@Transactional
public class DataPointsService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "dataPointsService";

    @Autowired
    private DataPointsRepository dataPointsRepository;

    public DataPointsRepository getdataPointsRepository() {
        return dataPointsRepository;
    }

    void setDataPointsRepository(DataPointsRepository dataPointsRepository) {
        this.dataPointsRepository =  dataPointsRepository;
    }

    public long count() {
        return dataPointsRepository.count();
    }

    public <S extends DataPoints> long count(Example<S> example) {
        return dataPointsRepository.count(example);
    }

    public void delete(DataPoints target) {
        dataPointsRepository.delete(target);
    }

    public void delete(Iterable<? extends DataPoints> iterable) {
        dataPointsRepository.delete(iterable);
    }

    public void delete(Long id) {
        dataPointsRepository.delete(id);
    }

    public void deleteAll() {
        dataPointsRepository.deleteAll();
    }

    public List<DataPoints> findAll(Sort sort) {
        return dataPointsRepository.findAll(sort);
    }

    public List<DataPoints> findAll(Iterable<Long> ids) {
        return dataPointsRepository.findAll(ids);
    }

    public <S extends DataPoints> List<S> save(Iterable<S> entities) {
        return dataPointsRepository.save(entities);
    }

    public void flush() {
        dataPointsRepository.flush();
    }

    public <S extends DataPoints> S saveAndFlush(S entity) {
        return dataPointsRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<DataPoints> entities) {
        dataPointsRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        dataPointsRepository.deleteAllInBatch();
    }

    public <S extends DataPoints> boolean exists(Example<S> example) {
        return dataPointsRepository.exists(example);
    }

    public boolean exists(Long id) {
        return dataPointsRepository.exists(id);
    }

    public List<DataPoints> findAll() {
        return dataPointsRepository.findAll();
    }

    public <S extends DataPoints> Page<S> findAll(Example<S> example, Pageable pageable) {
        return dataPointsRepository.findAll(example, pageable);
    }

    public DataPoints getOne(Long id) {
        return dataPointsRepository.getOne(id);
    }

    public <S extends DataPoints> List<S> findAll(Example<S> example) {
        return dataPointsRepository.findAll(example);
    }

    public <S extends DataPoints> List<S> findAll(Example<S> example, Sort sort) {
        return dataPointsRepository.findAll(example, sort);
    }

    public Page<DataPoints> findAll(Pageable pageable) {
        return dataPointsRepository.findAll(pageable);
    }

    public <S extends DataPoints> S findOne(Example<S> example) {
        return dataPointsRepository.findOne(example);
    }

    public DataPoints findOne(Long id) {
        return dataPointsRepository.findOne(id);
    }

    public <S extends DataPoints> S save(S entity) {
        return dataPointsRepository.save(entity);
    }
}

