package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.Countries;
import com.coherentlogic.wb.client.db.integration.repositories.CountriesRepository;

/**
 * Repository service implementation for working with Countries data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.Countries}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(CountriesService.BEAN_NAME)
@Transactional
public class CountriesService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "countriesService";

    @Autowired
    private CountriesRepository countriesRepository;

    public CountriesRepository getCountriesRepository() {
        return countriesRepository;
    }

    void setCountriesRepository(CountriesRepository countriesRepository) {
        this.countriesRepository =  countriesRepository;
    }

    public long count() {
        return countriesRepository.count();
    }

    public <S extends Countries> long count(Example<S> example) {
        return countriesRepository.count(example);
    }

    public void delete(Countries target) {
        countriesRepository.delete(target);
    }

    public void delete(Iterable<? extends Countries> iterable) {
        countriesRepository.delete(iterable);
    }

    public void delete(Long id) {
        countriesRepository.delete(id);
    }

    public void deleteAll() {
        countriesRepository.deleteAll();
    }

    public List<Countries> findAll(Sort sort) {
        return countriesRepository.findAll(sort);
    }

    public List<Countries> findAll(Iterable<Long> ids) {
        return countriesRepository.findAll(ids);
    }

    public <S extends Countries> List<S> save(Iterable<S> entities) {
        return countriesRepository.save(entities);
    }

    public void flush() {
        countriesRepository.flush();
    }

    public <S extends Countries> S saveAndFlush(S entity) {
        return countriesRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<Countries> entities) {
        countriesRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        countriesRepository.deleteAllInBatch();
    }

    public <S extends Countries> boolean exists(Example<S> example) {
        return countriesRepository.exists(example);
    }

    public boolean exists(Long id) {
        return countriesRepository.exists(id);
    }

    public List<Countries> findAll() {
        return countriesRepository.findAll();
    }

    public <S extends Countries> Page<S> findAll(Example<S> example, Pageable pageable) {
        return countriesRepository.findAll(example, pageable);
    }

    public Countries getOne(Long id) {
        return countriesRepository.getOne(id);
    }

    public <S extends Countries> List<S> findAll(Example<S> example) {
        return countriesRepository.findAll(example);
    }

    public <S extends Countries> List<S> findAll(Example<S> example, Sort sort) {
        return countriesRepository.findAll(example, sort);
    }

    public Page<Countries> findAll(Pageable pageable) {
        return countriesRepository.findAll(pageable);
    }

    public <S extends Countries> S findOne(Example<S> example) {
        return countriesRepository.findOne(example);
    }

    public Countries findOne(Long id) {
        return countriesRepository.findOne(id);
    }

    public <S extends Countries> S save(S entity) {
        return countriesRepository.save(entity);
    }
}
