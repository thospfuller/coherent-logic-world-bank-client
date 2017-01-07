package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.Country;
import com.coherentlogic.wb.client.db.integration.repositories.CountryRepository;

/**
 * Repository service implementation for working with Country data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.Country}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(CountryService.BEAN_NAME)
@Transactional
public class CountryService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "countryService";

    @Autowired
    private CountryRepository countryRepository;

    public CountryRepository getCountryRepository() {
        return countryRepository;
    }

    void setCountryRepository(CountryRepository countryRepository) {
        this.countryRepository =  countryRepository;
    }

    public long count() {
        return countryRepository.count();
    }

    public <S extends Country> long count(Example<S> example) {
        return countryRepository.count(example);
    }

    public void delete(Country target) {
        countryRepository.delete(target);
    }

    public void delete(Iterable<? extends Country> iterable) {
        countryRepository.delete(iterable);
    }

    public void delete(Long id) {
        countryRepository.delete(id);
    }

    public void deleteAll() {
        countryRepository.deleteAll();
    }

    public List<Country> findAll(Sort sort) {
        return countryRepository.findAll(sort);
    }

    public List<Country> findAll(Iterable<Long> ids) {
        return countryRepository.findAll(ids);
    }

    public <S extends Country> List<S> save(Iterable<S> entities) {
        return countryRepository.save(entities);
    }

    public void flush() {
        countryRepository.flush();
    }

    public <S extends Country> S saveAndFlush(S entity) {
        return countryRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<Country> entities) {
        countryRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        countryRepository.deleteAllInBatch();
    }

    public <S extends Country> boolean exists(Example<S> example) {
        return countryRepository.exists(example);
    }

    public boolean exists(Long id) {
        return countryRepository.exists(id);
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public <S extends Country> Page<S> findAll(Example<S> example, Pageable pageable) {
        return countryRepository.findAll(example, pageable);
    }

    public Country getOne(Long id) {
        return countryRepository.getOne(id);
    }

    public <S extends Country> List<S> findAll(Example<S> example) {
        return countryRepository.findAll(example);
    }

    public <S extends Country> List<S> findAll(Example<S> example, Sort sort) {
        return countryRepository.findAll(example, sort);
    }

    public Page<Country> findAll(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }

    public <S extends Country> S findOne(Example<S> example) {
        return countryRepository.findOne(example);
    }

    public Country findOne(Long id) {
        return countryRepository.findOne(id);
    }

    public <S extends Country> S save(S entity) {
        return countryRepository.save(entity);
    }
}
