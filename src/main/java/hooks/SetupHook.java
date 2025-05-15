package hooks;

import utils.BaseTest;

import java.net.MalformedURLException;

public class SetupHook {


    public void setUp() throws MalformedURLException {

        BaseTest.startAppiumServer();
        BaseTest.initializeDriver();
    }
        public void tearDown(){
            BaseTest.stopAppiumServer();
            BaseTest.quitDriver();
    }
}
