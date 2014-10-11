package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.PropertyConstants.PAGE;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.PAGES;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.PER_PAGE;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.TOTAL;
import static com.coherentlogic.wb.client.core.util.TestUtils.TEST_INT;
import static com.coherentlogic.wb.client.core.util.TestUtils.testSetterMethod;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coherentlogic.coherent.data.model.core.util.Action;
import com.coherentlogic.coherent.data.model.core.util.Flag;

/**
 * Unit test for the {@link PaginationBean} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class PaginationBeanTest {

    private final Flag flag = new Flag ();

    private PaginationBean paginationBean = new PaginationBean ();

    @Before
    public void setUp() throws Exception {
        paginationBean = new PaginationBean ();
    }

    @After
    public void tearDown() throws Exception {
        paginationBean = null;
        flag.setValue(false);
    }

    @Test
    public void testSetPage() {
        testSetterMethod (
            paginationBean,
            flag,
            PAGE,
            null,
            TEST_INT,
            new Action<PaginationBean> () {
                @Override
                public void execute(PaginationBean data) {
                    data.setPage(TEST_INT);
                }
            }
        );
    }

    @Test
    public void testSetPages() {
        testSetterMethod (
            paginationBean,
            flag,
            PAGES,
            null,
            TEST_INT,
            new Action<PaginationBean> () {
                @Override
                public void execute(PaginationBean data) {
                    data.setPages(TEST_INT);
                }
            }
        );
    }

    @Test
    public void testSetPerPage() {
        testSetterMethod (
            paginationBean,
            flag,
            PER_PAGE,
            null,
            TEST_INT,
            new Action<PaginationBean> () {
                @Override
                public void execute(PaginationBean data) {
                    data.setPerPage(TEST_INT);
                }
            }
        );
    }

    @Test
    public void testSetTotal() {
        testSetterMethod (
            paginationBean,
            flag,
            TOTAL,
            null,
            TEST_INT,
            new Action<PaginationBean> () {
                @Override
                public void execute(PaginationBean data) {
                    data.setTotal(TEST_INT);
                }
            }
        );
    }
}
