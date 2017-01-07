package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.DataPointCountry;
import com.coherentlogic.wb.client.db.integration.repositories.DataPointCountryRepository;

/**
 * Repository service implementation for working with DataPointCountry data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.DataPointCountry}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(DataPointCountryService.BEAN_NAME)
@Transactional
public class DataPointCountryService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "dataPointCountryService";

    @Autowired
    private DataPointCountryRepository dataPointCountryRepository;

    public DataPointCountryRepository getDataPointCountryRepository() {
        return dataPointCountryRepository;
    }

    void setDataPointCountryRepository(DataPointCountryRepository dataPointCountryRepository) {
        this.dataPointCountryRepository =  dataPointCountryRepository;
    }

    public long count() {
        return dataPointCountryRepository.count();
    }

    public <S extends DataPointCountry> long count(Example<S> example) {
        return dataPointCountryRepository.count(example);
    }

    public void delete(DataPointCountry target) {
        dataPointCountryRepository.delete(target);
    }

    public void delete(Iterable<? extends DataPointCountry> iterable) {
        dataPointCountryRepository.delete(iterable);
    }

    public void delete(Long id) {
        dataPointCountryRepository.delete(id);
    }

    public void deleteAll() {
        dataPointCountryRepository.deleteAll();
    }

    public List<DataPointCountry> findAll(Sort sort) {
        return dataPointCountryRepository.findAll(sort);
    }

    public List<DataPointCountry> findAll(Iterable<Long> ids) {
        return dataPointCountryRepository.findAll(ids);
    }

    public <S extends DataPointCountry> List<S> save(Iterable<S> entities) {
        return dataPointCountryRepository.save(entities);
    }

    public void flush() {
        dataPointCountryRepository.flush();
    }

    public <S extends DataPointCountry> S saveAndFlush(S entity) {
        return dataPointCountryRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<DataPointCountry> entities) {
        dataPointCountryRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        dataPointCountryRepository.deleteAllInBatch();
    }

    public <S extends DataPointCountry> boolean exists(Example<S> example) {
        return dataPointCountryRepository.exists(example);
    }

    public boolean exists(Long id) {
        return dataPointCountryRepository.exists(id);
    }

    public List<DataPointCountry> findAll() {
        return dataPointCountryRepository.findAll();
    }

    public <S extends DataPointCountry> Page<S> findAll(Example<S> example, Pageable pageable) {
        return dataPointCountryRepository.findAll(example, pageable);
    }

    public DataPointCountry getOne(Long id) {
        return dataPointCountryRepository.getOne(id);
    }

    public <S extends DataPointCountry> List<S> findAll(Example<S> example) {
        return dataPointCountryRepository.findAll(example);
    }

    public <S extends DataPointCountry> List<S> findAll(Example<S> example, Sort sort) {
        return dataPointCountryRepository.findAll(example, sort);
    }

    public Page<DataPointCountry> findAll(Pageable pageable) {
        return dataPointCountryRepository.findAll(pageable);
    }

    public <S extends DataPointCountry> S findOne(Example<S> example) {
        return dataPointCountryRepository.findOne(example);
    }

    public DataPointCountry findOne(Long id) {
        return dataPointCountryRepository.findOne(id);
    }

    public <S extends DataPointCountry> S save(S entity) {
        return dataPointCountryRepository.save(entity);
    }
}
