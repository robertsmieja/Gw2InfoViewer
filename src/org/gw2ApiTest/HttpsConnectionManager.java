/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gw2ApiTest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.String;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Manages an HTTPS connection
 *
 * @author Robert Smieja
 */
public class HttpsConnectionManager {

    private URL url;
    private HttpClient httpClient;
    final private byte[] sslCertificateBytes;
    final private Certificate[] sslCertificate;

    public HttpsConnectionManager(byte[] sslCertificateBytes) throws CertificateException {
        this.sslCertificateBytes = sslCertificateBytes;
        this.sslCertificate = convertByteArrayToCertificate(this.sslCertificateBytes);
    }
//    public HttpsConnectionManager(String url){
//        try {
//           this(new URL(url));
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(HttpsConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

//   public HttpsConnectionManager(URL url){
//       this.url = url;
//       this.httpClient = setUpConnection(this.url);
//       
//    }
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

    public HttpClient getHttpClient() {

        DefaultHttpClient httpClient = new DefaultHttpClient();

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
            Logger.getLogger(Gw2ApiTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        return httpClient;
    }

    public static String stringFromHttpResponse(HttpResponse response) throws IOException {
        BufferedReader br;
        String result = "";
        String output;

        br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

        while ((output = br.readLine()) != null) {
            result += output;
        }

        return result;

    }
//     public HttpClient setUpConnection(URL url) {
// 
//
//        //
////       if (config.isAllowSelfSignedCertificates()) {
////        SchemeSocketFactory factory = new SSLSocketFactory();
////        try {
////            URI uri = new URI(url);
//////          URI uri = new URI(config.getBaseUrl());
////          int port = uri.getPort();
////          if (port == -1) {
////            port = 443;
////          }
////          Protocol easyHttps = new Protocol(uri.getScheme(), factory, port);
////          hostConfiguration.setHost(uri.getHost(), port, easyHttps);
////        } catch (URISyntaxException e) {
////          throw new IOException("could not parse URI " + config.getBaseUrl(), e);
////        }
////      }
////       //
//
//
//
//
//        CertificateFactory cf = CertificateFactory.getInstance("X.509");
//        Collection c = cf.generateCertificates(new ByteArrayInputStream(Gw2ApiTest.StartComRootCertificate));
//        Certificate[] certs;
//        certs = new Certificate[c.toArray().length];
//        if (c.size() == 1) {
//            InputStream certstream = new ByteArrayInputStream(Gw2ApiTest.StartComRootCertificate);
//            Certificate cert = cf.generateCertificate(certstream);
//            certs[0] = cert;
//        } else {
//            certs = (Certificate[]) c.toArray();
//        }
//        TrustManagerFactory tf = TrustManagerFactory.getInstance("X509");
//        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
//        ks.load(null);
//        for (int i = 0; i < certs.length; i++) {
//            ks.setCertificateEntry("StartCom" + i, certs[i]);
//        }
//
//        SSLSocketFactory sslSocketFactory;
//        sslSocketFactory = new SSLSocketFactory(ks);
//
//        HttpClient httpClient = new DefaultHttpClient();
//
//        ResponseHandler<String> responseHandler = new BasicResponseHandler();
//        String responseBody = httpClient.execute(httpGet, responseHandler);
//        System.out.println("----------------------------------------");
//        System.out.println(responseBody);
//        System.out.println("----------------------------------------");
//    }
}
