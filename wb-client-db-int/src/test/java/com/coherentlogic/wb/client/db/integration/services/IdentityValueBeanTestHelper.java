package com.coherentlogic.wb.client.db.integration.services;

import com.coherentlogic.coherent.data.model.core.domain.IdentityValueBean;

/**
 * A class which is used to test children of {@link IdentityValueBean}.
 *
 * @param <S> The service type.
 * @param <T> The bean type.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class IdentityValueBeanTestHelper<S, T extends IdentityValueBean> {

    static final String NAME1 = "name1";

    private final S serializableDAO;

    public IdentityValueBeanTestHelper(S defaultDAO) {
        super();
        this.serializableDAO = defaultDAO;
    }

    public static <T extends IdentityValueBean> T create (Class<T> type) {

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

//    /**
//     * @todo We need to check some of the child objects to ensure changes are
//     *  being handled correctly at that level.
//     */
//    public void testAllCRUDOperations (T idValuePair) {
//        serializableDAO.persist(idValuePair);
//
//        Long primaryKey = idValuePair.getPrimaryKey();
//
//        assertNotNull(primaryKey);
//
//        T idValuePair2 =
//            serializableDAO.find(primaryKey);
//
//        assertNotNull(idValuePair2);
//        assertEquals(idValuePair, idValuePair2);
//
//        idValuePair2.setId(NAME1);
//
//        serializableDAO.merge(idValuePair2);
//
//        T idValuePair3 =
//            serializableDAO.find(primaryKey);
//
//        assertEquals(NAME1, idValuePair3.getId ());
//
//        serializableDAO.remove(idValuePair3);
//
//        IdentityValueBean idValuePair4 =
//            serializableDAO.find(primaryKey);
//
//        assertNull(idValuePair4);
//    }
}
