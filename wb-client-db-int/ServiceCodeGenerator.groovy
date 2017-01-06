
def beans = [
    "adminRegion",
    "catalogSource",
    "catalogSources",
    "countries",
    "country",
    "dataPointCountry",
    "dataPointIndicator",
    "dataPoint",
    "dataPoints",
    "incomeLevel",
    "incomeLevels",
    "indicator",
    "indicatorSource",
    "indicators",
    "indicatorTopic",
    "indicatorTopics",
    "lendingType",
    "lendingTypes",
    "message",
    "region",
    "source",
    "topic",
    "topics"
]

def getTemplate (it) {
def template = """package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.AdminRegion;
import com.coherentlogic.wb.client.db.integration.repositories.AdminRegionRepository;

/**
 * Repository service implementation for working with ${it.capitalize ()} data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.${it.capitalize ()}}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(${it.capitalize ()}Service.BEAN_NAME)
@Transactional
public class ${it.capitalize ()}Service extends EntityManagerAwareService {

    public static final String BEAN_NAME = "${it}Service";

    @Autowired
    private ${it.capitalize ()}Repository ${it}Repository;

    public ${it.capitalize ()}Repository get${it}Repository() {
        return ${it}Repository;
    }

    void set${it.capitalize ()}Repository(${it.capitalize ()}Repository ${it}Repository) {
        this.${it}Repository =  ${it}Repository;
    }

    public long count() {
        return ${it}Repository.count();
    }

    public <S extends ${it.capitalize ()}> long count(Example<S> example) {
        return ${it}Repository.count(example);
    }

    public void delete(${it.capitalize ()} target) {
        ${it}Repository.delete(target);
    }

    public void delete(Iterable<? extends ${it.capitalize ()}> iterable) {
        ${it}Repository.delete(iterable);
    }

    public void delete(Long id) {
        ${it}Repository.delete(id);
    }

    public void deleteAll() {
        ${it}Repository.deleteAll();
    }

    public List<${it.capitalize ()}> findAll(Sort sort) {
        return ${it}Repository.findAll(sort);
    }

    public List<${it.capitalize ()}> findAll(Iterable<Long> ids) {
        return ${it}Repository.findAll(ids);
    }

    public <S extends ${it.capitalize ()}> List<S> save(Iterable<S> entities) {
        return ${it}Repository.save(entities);
    }

    public void flush() {
        ${it}Repository.flush();
    }

    public <S extends ${it.capitalize ()}> S saveAndFlush(S entity) {
        return ${it}Repository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<${it.capitalize ()}> entities) {
        ${it}Repository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        ${it}Repository.deleteAllInBatch();
    }

    public <S extends ${it.capitalize ()}> boolean exists(Example<S> example) {
        return ${it}Repository.exists(example);
    }

    public boolean exists(Long id) {
        return ${it}Repository.exists(id);
    }

    public List<${it.capitalize ()}> findAll() {
        return ${it}Repository.findAll();
    }

    public <S extends ${it.capitalize ()}> Page<S> findAll(Example<S> example, Pageable pageable) {
        return ${it}Repository.findAll(example, pageable);
    }

    public ${it.capitalize ()} getOne(Long id) {
        return ${it}Repository.getOne(id);
    }

    public <S extends ${it.capitalize ()}> List<S> findAll(Example<S> example) {
        return ${it}Repository.findAll(example);
    }

    public <S extends ${it.capitalize ()}> List<S> findAll(Example<S> example, Sort sort) {
        return ${it}Repository.findAll(example, sort);
    }

    public Page<${it.capitalize ()}> findAll(Pageable pageable) {
        return ${it}Repository.findAll(pageable);
    }

    public <S extends ${it.capitalize ()}> S findOne(Example<S> example) {
        return ${it}Repository.findOne(example);
    }

    public ${it.capitalize ()} findOne(Long id) {
        return ${it}Repository.findOne(id);
    }

    public <S extends ${it.capitalize ()}> S save(S entity) {
        return ${it}Repository.save(entity);
    }
}

"""
}

for (def it : beans) {

    def file = new File ("C:/Temp/beans/${it.capitalize ()}Service.java")
    
    file << getTemplate (it)
}