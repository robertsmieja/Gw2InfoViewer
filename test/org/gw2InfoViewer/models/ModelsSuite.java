/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gw2InfoViewer.models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Robert Smieja
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({org.gw2InfoViewer.models.EventTest.class, org.gw2InfoViewer.models.EventStateTest.class, org.gw2InfoViewer.models.EventListTest.class})
public class ModelsSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}