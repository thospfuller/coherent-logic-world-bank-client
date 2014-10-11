package com.coherentlogic.wb.client.db.integration.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.coherentlogic.coherent.data.model.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.IdValuePair;

/**
 * A class which is used to test children of {@link IdValuePair}.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class IdValuePairTestHelper<T extends IdValuePair> {

    static final String NAME1 = "name1";

    private final SerializableDAO<T> serializableDAO;

    public IdValuePairTestHelper(SerializableDAO<T> defaultDAO) {
        super();
        this.serializableDAO = defaultDAO;
    }

    public static <T extends IdValuePair> T create (Class<T> type) {

        T idValuePair = null;

        try {
            idValuePair = (T) type.newInstance();
        } catch (InstantiationException | IllegalAccessException exception) {
            throw new RuntimeException (
                "Unable to create the type " + type, exception);
        }

        idValuePair.setId(DataPointCountryDAOTest.VALUEX);
        idValuePair.setValue(DataPointCountryDAOTest.VALUEY);

        return idValuePair;
    }

    /**
     * @todo We need to check some of the child objects to ensure changes are
     *  being handled correctly at that level.
     */
    public void testAllCRUDOperations (T idValuePair) {
        serializableDAO.persist(idValuePair);

        Long primaryKey = idValuePair.getPrimaryKey();

        assertNotNull(primaryKey);

        T idValuePair2 =
            serializableDAO.find(primaryKey);

        assertNotNull(idValuePair2);
        assertEquals(idValuePair, idValuePair2);

        idValuePair2.setId(NAME1);

        serializableDAO.merge(idValuePair2);

        T idValuePair3 =
            serializableDAO.find(primaryKey);

        assertEquals(NAME1, idValuePair3.getId ());

        serializableDAO.remove(idValuePair3);

        IdValuePair idValuePair4 =
            serializableDAO.find(primaryKey);

        assertNull(idValuePair4);
    }
}
