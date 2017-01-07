package com.coherentlogic.wb.client.db.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.Message;
import com.coherentlogic.wb.client.db.integration.repositories.MessageRepository;

/**
 * Repository service implementation for working with Message data.
 *
 * @see {@link com.coherentlogic.wb.client.core.domain.Message}
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Repository(MessageService.BEAN_NAME)
@Transactional
public class MessageService extends EntityManagerAwareService {

    public static final String BEAN_NAME = "messageService";

    @Autowired
    private MessageRepository messageRepository;

    public MessageRepository getMessageRepository() {
        return messageRepository;
    }

    void setMessageRepository(MessageRepository messageRepository) {
        this.messageRepository =  messageRepository;
    }

    public long count() {
        return messageRepository.count();
    }

    public <S extends Message> long count(Example<S> example) {
        return messageRepository.count(example);
    }

    public void delete(Message target) {
        messageRepository.delete(target);
    }

    public void delete(Iterable<? extends Message> iterable) {
        messageRepository.delete(iterable);
    }

    public void delete(Long id) {
        messageRepository.delete(id);
    }

    public void deleteAll() {
        messageRepository.deleteAll();
    }

    public List<Message> findAll(Sort sort) {
        return messageRepository.findAll(sort);
    }

    public List<Message> findAll(Iterable<Long> ids) {
        return messageRepository.findAll(ids);
    }

    public <S extends Message> List<S> save(Iterable<S> entities) {
        return messageRepository.save(entities);
    }

    public void flush() {
        messageRepository.flush();
    }

    public <S extends Message> S saveAndFlush(S entity) {
        return messageRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<Message> entities) {
        messageRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        messageRepository.deleteAllInBatch();
    }

    public <S extends Message> boolean exists(Example<S> example) {
        return messageRepository.exists(example);
    }

    public boolean exists(Long id) {
        return messageRepository.exists(id);
    }

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    public <S extends Message> Page<S> findAll(Example<S> example, Pageable pageable) {
        return messageRepository.findAll(example, pageable);
    }

    public Message getOne(Long id) {
        return messageRepository.getOne(id);
    }

    public <S extends Message> List<S> findAll(Example<S> example) {
        return messageRepository.findAll(example);
    }

    public <S extends Message> List<S> findAll(Example<S> example, Sort sort) {
        return messageRepository.findAll(example, sort);
    }

    public Page<Message> findAll(Pageable pageable) {
        return messageRepository.findAll(pageable);
    }

    public <S extends Message> S findOne(Example<S> example) {
        return messageRepository.findOne(example);
    }

    public Message findOne(Long id) {
        return messageRepository.findOne(id);
    }

    public <S extends Message> S save(S entity) {
        return messageRepository.save(entity);
    }
}
