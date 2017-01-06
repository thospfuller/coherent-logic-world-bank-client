package com.coherentlogic.wb.client.db.integration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.Message;

/**
 * <a href="http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories">Repository</a>
 * specification for {@link Message} objects.
 *
 * @see <a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/">
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Transactional
public interface MessageRepository extends JpaRepository<Message, Long> {

}
