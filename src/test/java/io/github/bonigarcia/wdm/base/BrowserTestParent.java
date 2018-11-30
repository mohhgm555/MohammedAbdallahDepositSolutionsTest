/*
 * (C) Copyright 2016 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.github.bonigarcia.wdm.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Parent class for browser based tests.
 *
 * @author Boni Garcia (boni.gg@gmail.com)
 * @since 1.4.1
 */

//Make the class abstract for multi browser testing
public class BrowserTestParent {

    public static WebDriver driver = null;

    @Before
    public void initialize() throws IOException {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        //To maximize browser
        driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //To open new user page
        driver.get("http://85.93.17.135:9000/");
    }

    @After
    //Test cleanup
    public void TeardownTest() {
        BrowserTestParent.driver.quit();
    }
}