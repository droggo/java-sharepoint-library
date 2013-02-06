package org.korecky.sharepoint.sp2007;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.korecky.sharepoint.HttpProxy;
import org.korecky.sharepoint.NetworkCredentials;

/**
 *
 * @author vkorecky
 */
public class SP2007Test {

    public SP2007Test() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws MalformedURLException, IOException, NoSuchAlgorithmException, KeyManagementException {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAllWebs method, of class SPSite.
     */
    @Test
    public void ComplexTest() throws MalformedURLException, KeyManagementException, NoSuchAlgorithmException {        
        // SPSite test
        NetworkCredentials credentials = new NetworkCredentials("aaa", "aaa", "aa");
        HttpProxy httpProxy = new HttpProxy("127.0.0.1", 8888);

        SPSite instance = new SPSite(new URL("https://devport2.gordic.cz/"), credentials, httpProxy, true);
        List<SPWeb> result = instance.getAllWebs();
        assertNotNull(result);
        if (result != null) {
            for (SPWeb web : result) {
                // SPWebTest
                System.out.println(web.getUrl());
                List<SPAlert> alertCollection = web.getAlerts();
            }
        }
    }
}