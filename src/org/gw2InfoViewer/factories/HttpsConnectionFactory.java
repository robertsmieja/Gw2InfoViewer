/*
 *  Gw2InfoViewer - Java Swing based application that reads the Guild Wars 2 JSON API
 *  Copyright (C) 2013 Robert Smieja
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gw2InfoViewer.factories;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Factory to return HttpClients with custom SSL options
 *
 * @author Robert Smieja
 */
public class HttpsConnectionFactory {
    private static HttpsConnectionFactory instance = null;
    
    protected HttpsConnectionFactory() {
    }

    public static HttpsConnectionFactory getInstance() {
        if (instance == null) {
            instance = new HttpsConnectionFactory();
        }
        return instance;
    }

    public static Certificate[] convertByteArrayToCertificate(byte[] sslCertificate) throws CertificateException {
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        Collection c = cf.generateCertificates(new ByteArrayInputStream(sslCertificate));
        Certificate[] certs;
        certs = new Certificate[c.toArray().length];
        if (c.size() == 1) {
            InputStream certstream = new ByteArrayInputStream(sslCertificate);
            Certificate cert = cf.generateCertificate(certstream);
            certs[0] = cert;
        } else {
            certs = (Certificate[]) c.toArray();
        }

        return certs;
    }

    public static HttpClient getHttpsClient(byte[] sslCertificateBytes) {
        DefaultHttpClient httpClient;
        Certificate[] sslCertificate;

        httpClient = new DefaultHttpClient();
        try {
            sslCertificate = convertByteArrayToCertificate(sslCertificateBytes);

            TrustManagerFactory tf = TrustManagerFactory.getInstance("X509");
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            ks.load(null);
            for (int i = 0; i < sslCertificate.length; i++) {
                ks.setCertificateEntry("StartCom" + i, sslCertificate[i]);
            }
            
            tf.init(ks);
            TrustManager[] tm = tf.getTrustManagers();
            
            SSLContext sslCon = SSLContext.getInstance("SSL");
            sslCon.init(null, tm, new SecureRandom());
            SSLSocketFactory socketFactory = new SSLSocketFactory(ks);
            Scheme sch = new Scheme("https", 443, socketFactory);
            
            httpClient.getConnectionManager().getSchemeRegistry().register(sch);
        } catch (CertificateException | NoSuchAlgorithmException | KeyStoreException | IOException | KeyManagementException | UnrecoverableKeyException ex) {
            Logger.getLogger(HttpsConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return httpClient;
    }
    
        public static HttpClient getHttpsClient(Certificate[] sslCertificate) {
        DefaultHttpClient httpClient;

        httpClient = new DefaultHttpClient();
        try {
            TrustManagerFactory tf = TrustManagerFactory.getInstance("X509");
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            ks.load(null);
            for (int i = 0; i < sslCertificate.length; i++) {
                ks.setCertificateEntry("StartCom" + i, sslCertificate[i]);
            }
            
            tf.init(ks);
            TrustManager[] tm = tf.getTrustManagers();
            
            SSLContext sslCon = SSLContext.getInstance("SSL");
            sslCon.init(null, tm, new SecureRandom());
            SSLSocketFactory socketFactory = new SSLSocketFactory(ks);
            Scheme sch = new Scheme("https", 443, socketFactory);
            
            httpClient.getConnectionManager().getSchemeRegistry().register(sch);
        } catch (CertificateException | NoSuchAlgorithmException | KeyStoreException | IOException | KeyManagementException | UnrecoverableKeyException ex) {
            Logger.getLogger(HttpsConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return httpClient;
    }

    public static String getStringFromHttpResponse(HttpResponse response) throws IOException {
        BufferedReader reader;
        String result = "";
        String output;

        reader = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

        while ((output = reader.readLine()) != null) {
            result += output;
        }

        return result;
    }
}