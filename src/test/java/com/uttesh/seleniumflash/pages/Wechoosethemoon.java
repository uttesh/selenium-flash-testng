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
import org.sikuli.script.FindFailed;

/**
 * @author Uttesh Kumar T.H.
 */
public class Wechoosethemoon extends SeleniumBase {

    WebDriver driver;

    ScreenHelper screenHelper = new ScreenHelper();

    public Wechoosethemoon(WebDriver driver) {
        this.driver = getDriver();
    }

    public void home() throws InterruptedException {
        String baseUrl = AppUtils.getProperty("wechoosethemoon.url");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Thread.sleep(8000);
        screenHelper.click(Constants.Images.WeChooseMoon.START_BUTTON);
    }

    public void Mailing() throws FindFailed, InterruptedException {
        screenHelper.click(Constants.Images.WeChooseMoon.MAILING_MENU);
        screenHelper.click(Constants.Images.WeChooseMoon.FIRST_NAME_FIELD);
        screenHelper.inputText("Uttesh ");
        screenHelper.click(Constants.Images.WeChooseMoon.LAST_NAME_FIELD);
        screenHelper.inputText("Kumar T.H.");
        screenHelper.click(Constants.Images.WeChooseMoon.BIRTH_YEAR_FIELD);
        screenHelper.inputText("1985");
        screenHelper.click(Constants.Images.WeChooseMoon.SUBMIT_BUTTON);

    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getPageDriver() {
        return this.driver;
    }
}
