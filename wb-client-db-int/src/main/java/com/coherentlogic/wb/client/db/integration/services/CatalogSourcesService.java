package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.CatalogSources;
import com.coherentlogic.wb.client.db.integration.repositories.CatalogSourcesRepository;

/**
 * Repository service implementation for working with CatalogSources data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.CatalogSources}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(CatalogSourcesService.BEAN_NAME)
@Transactional
public class CatalogSourcesService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "catalogSourcesService";

    @Autowired
    private CatalogSourcesRepository catalogSourcesRepository;

    public CatalogSourcesRepository getcatalogSourcesRepository() {
        return catalogSourcesRepository;
    }

    void setCatalogSourcesRepository(CatalogSourcesRepository catalogSourcesRepository) {
        this.catalogSourcesRepository =  catalogSourcesRepository;
    }

    public long count() {
        return catalogSourcesRepository.count();
    }

    public <S extends CatalogSources> long count(Example<S> example) {
        return catalogSourcesRepository.count(example);
    }

    public void delete(CatalogSources target) {
        catalogSourcesRepository.delete(target);
    }

    public void delete(Iterable<? extends CatalogSources> iterable) {
        catalogSourcesRepository.delete(iterable);
    }

    public void delete(Long id) {
        catalogSourcesRepository.delete(id);
    }

    public void deleteAll() {
        catalogSourcesRepository.deleteAll();
    }

    public List<CatalogSources> findAll(Sort sort) {
        return catalogSourcesRepository.findAll(sort);
    }

    public List<CatalogSources> findAll(Iterable<Long> ids) {
        return catalogSourcesRepository.findAll(ids);
    }

    public <S extends CatalogSources> List<S> save(Iterable<S> entities) {
        return catalogSourcesRepository.save(entities);
    }

    public void flush() {
        catalogSourcesRepository.flush();
    }

    public <S extends CatalogSources> S saveAndFlush(S entity) {
        return catalogSourcesRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<CatalogSources> entities) {
        catalogSourcesRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        catalogSourcesRepository.deleteAllInBatch();
    }

    public <S extends CatalogSources> boolean exists(Example<S> example) {
        return catalogSourcesRepository.exists(example);
    }

    public boolean exists(Long id) {
        return catalogSourcesRepository.exists(id);
    }

    public List<CatalogSources> findAll() {
        return catalogSourcesRepository.findAll();
    }

    public <S extends CatalogSources> Page<S> findAll(Example<S> example, Pageable pageable) {
        return catalogSourcesRepository.findAll(example, pageable);
    }

    public CatalogSources getOne(Long id) {
        return catalogSourcesRepository.getOne(id);
    }

    public <S extends CatalogSources> List<S> findAll(Example<S> example) {
        return catalogSourcesRepository.findAll(example);
    }

    public <S extends CatalogSources> List<S> findAll(Example<S> example, Sort sort) {
        return catalogSourcesRepository.findAll(example, sort);
    }

    public Page<CatalogSources> findAll(Pageable pageable) {
        return catalogSourcesRepository.findAll(pageable);
    }

    public <S extends CatalogSources> S findOne(Example<S> example) {
        return catalogSourcesRepository.findOne(example);
    }

    public CatalogSources findOne(Long id) {
        return catalogSourcesRepository.findOne(id);
    }

    public <S extends CatalogSources> S save(S entity) {
        return catalogSourcesRepository.save(entity);
    }
}

