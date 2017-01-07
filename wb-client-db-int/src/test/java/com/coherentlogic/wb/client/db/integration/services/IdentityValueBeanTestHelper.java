package com.coherentlogic.wb.client.db.integration.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coherentlogic.coherent.data.model.core.domain.IdentityValueBean;

/**
 * A class which is used to test children of {@link IdentityValueBean}.
 *
 * @param <S> The service type.
 * @param <T> The bean type.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class IdentityValueBeanTestHelper<R extends JpaRepository<T, Long>, T extends IdentityValueBean> {

    static final String NAME1 = "name1";

    private final R repository;

    public IdentityValueBeanTestHelper(R repository) {
        super();
        this.repository = repository;
    }

    public static <T extends IdentityValueBean> T create (Class<T> type) {

        T idValuePair = null;

        try {
            idValuePair = (T) type.newInstance();
        } catch (InstantiationException | IllegalAccessException exception) {
            throw new RuntimeException (
                "Unable to create the type " + type, exception);
        }

        idValuePair.setId(DataPointCountryServiceTest.VALUEX);
        idValuePair.setValue(DataPointCountryServiceTest.VALUEY);

        return idValuePair;
    }

    /**
     * @todo We need to check some of the child objects to ensure changes are
     *  being handled correctly at that level.
     */
    public void testAllCRUDOperations (T idValuePair) {

    	repository.save(idValuePair);

        Long primaryKey = idValuePair.getPrimaryKey();

        assertNotNull("primaryKey", primaryKey);

        T idValuePair2 = repository.findOne(primaryKey);

        assertNotNull("idValuePair2", idValuePair2);
        assertEquals(idValuePair, idValuePair2);

        idValuePair2.setId(NAME1);

        repository.save(idValuePair2);

        T idValuePair3 = repository.findOne(primaryKey);

        assertEquals(NAME1, idValuePair3.getId ());

        repository.delete(idValuePair3);

        IdentityValueBean idValuePair4 = repository.findOne(primaryKey);

        assertNull(idValuePair4);
    }
}
