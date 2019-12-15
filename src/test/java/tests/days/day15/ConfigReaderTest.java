package tests.days.day15;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigurationReader;

public class ConfigReaderTest {

    @Test
    public void test1(){
        String expectedBrowser ="chrome";
        String actualBrowser = ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actualBrowser,expectedBrowser);
        System.out.println(ConfigurationReader.getProperty("url"));
        System.out.println(ConfigurationReader.getProperty("user_name"));
        System.out.println(ConfigurationReader.getProperty("password"));
    }
}
