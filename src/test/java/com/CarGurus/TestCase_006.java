/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CarGurus;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author RANGANI2
 */
public class TestCase_006 {

    public TestCase_006() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\driver\\chromedriver.exe");//location of chromedriver defined here
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cargurus.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        options.addArguments("start-maximized"); 
        options.addArguments("enable-automation"); 
        options.addArguments("--no-sandbox"); 
        options.addArguments("--disable-infobars"); 
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation"); 
        options.addArguments("--disable-gpu");
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void changeLanguage() throws Exception {

        driver.findElement(By.id("location-menu-control")).click();
        driver.findElement(By.partialLinkText("Canada (F")).click();

        String t = driver.findElement(By.xpath("//body/nav[@id='headerNav']/div[1]/ul[2]/li[2]/button[1]/span[1]")).getText();
        System.out.println("Language: " + t);
        try {
            assertEquals("FR", t);
            System.out.println("Tes case Pass");
        } catch (Error e) {
            System.out.println(e.toString());
        }

    }
}
