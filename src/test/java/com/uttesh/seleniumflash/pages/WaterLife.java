/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uttesh.seleniumflash.pages;

import com.uttesh.seleniumflash.ScreenHelper;
import com.uttesh.seleniumflash.SeleniumBase;
import com.uttesh.seleniumflash.common.AppUtils;
import com.uttesh.seleniumflash.common.Constants;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

/**
 * @author Uttesh Kumar T.H.
 */
public class WaterLife extends SeleniumBase {

    WebDriver driver;

    ScreenHelper screenHelper = new ScreenHelper();

    public WaterLife(WebDriver driver) {
        this.driver = getDriver();
    }

    public void home() throws InterruptedException {
        String baseUrl = AppUtils.getProperty("waterlife.url");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Thread.sleep(4000);
        screenHelper.click(Constants.Images.WaterLife.ENTER_BUTTON);
        Thread.sleep(4000);
        screenHelper.mouseover(Constants.Images.WaterLife.WATER_IS_MENU);
    }

    

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getPageDriver() {
        return this.driver;
    }
}
