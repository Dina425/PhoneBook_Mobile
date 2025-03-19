package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class LaunchTest extends AppiumConfig {
    @Test
    public void lounch(){
       String version= new SplashScreen(driver).getCurrentVersion();
        Assert.assertEquals(version,"Version 1.0.0");

    }
}
