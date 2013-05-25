/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gw2InfoViewer.factories;

import java.security.cert.Certificate;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;


/**
 *
 * @author Robert Smieja
 */
public class HttpsConnectionFactoryTest {
    
    public HttpsConnectionFactoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class HttpsConnectionFactory.
     */
    @Test
    public void testGetInstance() {        
        HttpsConnectionFactory result = HttpsConnectionFactory.getInstance();
        
        assertNotNull(result);
    }

    /**
     * Test of convertByteArrayToCertificate method, of class HttpsConnectionFactory.
     */
    @Test
    public void testConvertByteArrayToCertificate() throws Exception {
        byte[] sslCertificate = any(byte[].class);
        Certificate[] expResult = any(Certificate[].class);
        
        Certificate[] result = HttpsConnectionFactory.convertByteArrayToCertificate(sslCertificate);
        
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getHttpsClient method, of class HttpsConnectionFactory.
     */
    @Test
    public void testGetHttpsClient_byteArr() {
        byte[] sslCertificateBytes = any(byte[].class);
        HttpClient expResult = any(HttpClient.class);
        
        HttpClient result = HttpsConnectionFactory.getHttpsClient(sslCertificateBytes);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getHttpsClient method, of class HttpsConnectionFactory.
     */
    @Test
    public void testGetHttpsClient_CertificateArr() {
        Certificate[] sslCertificate = any(Certificate[].class);
        HttpClient expResult = any(HttpClient.class);
        
        HttpClient result = HttpsConnectionFactory.getHttpsClient(sslCertificate);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getStringFromHttpResponse method, of class HttpsConnectionFactory.
     */
    @Test
    public void testGetStringFromHttpResponse() throws Exception {
        HttpResponse response = any(HttpResponse.class);
        
        String expResult = anyString();
        
        String result = HttpsConnectionFactory.getStringFromHttpResponse(response);
        
        assertEquals(expResult, result);
    }
}