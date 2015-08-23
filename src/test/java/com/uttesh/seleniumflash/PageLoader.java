package com.uttesh.seleniumflash;

import com.uttesh.seleniumflash.pages.WaterLife;
import com.uttesh.seleniumflash.pages.Wechoosethemoon;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;



public class PageLoader extends SeleniumBase {

    WebDriver driver;

    public PageLoader(WebDriver driver) {
        this.driver = driver;
    }

    public void WechoosethemoonHomePage() throws InterruptedException {
        Wechoosethemoon wechoosethemoon = new Wechoosethemoon(getDriver());
        wechoosethemoon.home();
    }
    
    public void WechoosethemoonMailing() throws FindFailed, InterruptedException {
        Wechoosethemoon wechoosethemoon = new Wechoosethemoon(getDriver());
        wechoosethemoon.Mailing();
    }
    
    public void WaterLifeHomePage() throws InterruptedException {
        WaterLife waterLife = new WaterLife(getDriver());
        waterLife.home();
    }
    

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getPageDriver() {
        return this.driver;
    }

}
