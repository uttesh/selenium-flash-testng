/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uttesh.seleniumflash;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Uttesh Kumar T.H.
 */
public class WaterLifeTest extends SeleniumBase {

    WebDriver driver;

    ScreenHelper screenHelper;

    @BeforeClass
    public void setUp() throws Exception {
        PageLoader pageload = new PageLoader(getDriver());
        pageload.WaterLifeHomePage();
        Thread.sleep(5000);
        setDriver(pageload.getPageDriver());
        screenHelper = new ScreenHelper();

    }

    @Test
    public void waterlifeFishingTest() throws FindFailed, InterruptedException {
        System.out.println("waterlifeTest");
        Assert.assertEquals(true, true);
    }

    @AfterSuite
    public void tearDown_() {
        screenHelper = null;
        driver.quit();
        System.gc();
        //System.exit(1);
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getPageDriver() {
        return this.driver;
    }
}
