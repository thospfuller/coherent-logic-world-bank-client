package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.CatalogSource;
import com.coherentlogic.wb.client.db.integration.repositories.CatalogSourceRepository;

/**
 * Repository service implementation for working with CatalogSource data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.CatalogSource}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(CatalogSourceService.BEAN_NAME)
@Transactional
public class CatalogSourceService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "catalogSourceService";

    @Autowired
    private CatalogSourceRepository catalogSourceRepository;

    public CatalogSourceRepository getCatalogSourceRepository() {
        return catalogSourceRepository;
    }

    void setCatalogSourceRepository(CatalogSourceRepository catalogSourceRepository) {
        this.catalogSourceRepository =  catalogSourceRepository;
    }

    public long count() {
        return catalogSourceRepository.count();
    }

    public <S extends CatalogSource> long count(Example<S> example) {
        return catalogSourceRepository.count(example);
    }

    public void delete(CatalogSource target) {
        catalogSourceRepository.delete(target);
    }

    public void delete(Iterable<? extends CatalogSource> iterable) {
        catalogSourceRepository.delete(iterable);
    }

    public void delete(Long id) {
        catalogSourceRepository.delete(id);
    }

    public void deleteAll() {
        catalogSourceRepository.deleteAll();
    }

    public List<CatalogSource> findAll(Sort sort) {
        return catalogSourceRepository.findAll(sort);
    }

    public List<CatalogSource> findAll(Iterable<Long> ids) {
        return catalogSourceRepository.findAll(ids);
    }

    public <S extends CatalogSource> List<S> save(Iterable<S> entities) {
        return catalogSourceRepository.save(entities);
    }

    public void flush() {
        catalogSourceRepository.flush();
    }

    public <S extends CatalogSource> S saveAndFlush(S entity) {
        return catalogSourceRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<CatalogSource> entities) {
        catalogSourceRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        catalogSourceRepository.deleteAllInBatch();
    }

    public <S extends CatalogSource> boolean exists(Example<S> example) {
        return catalogSourceRepository.exists(example);
    }

    public boolean exists(Long id) {
        return catalogSourceRepository.exists(id);
    }

    public List<CatalogSource> findAll() {
        return catalogSourceRepository.findAll();
    }

    public <S extends CatalogSource> Page<S> findAll(Example<S> example, Pageable pageable) {
        return catalogSourceRepository.findAll(example, pageable);
    }

    public CatalogSource getOne(Long id) {
        return catalogSourceRepository.getOne(id);
    }

    public <S extends CatalogSource> List<S> findAll(Example<S> example) {
        return catalogSourceRepository.findAll(example);
    }

    public <S extends CatalogSource> List<S> findAll(Example<S> example, Sort sort) {
        return catalogSourceRepository.findAll(example, sort);
    }

    public Page<CatalogSource> findAll(Pageable pageable) {
        return catalogSourceRepository.findAll(pageable);
    }

    public <S extends CatalogSource> S findOne(Example<S> example) {
        return catalogSourceRepository.findOne(example);
    }

    public CatalogSource findOne(Long id) {
        return catalogSourceRepository.findOne(id);
    }

    public <S extends CatalogSource> S save(S entity) {
        return catalogSourceRepository.save(entity);
    }
}
