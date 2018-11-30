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
package io.github.bonigarcia.wdm.test.browsersNotInUse;

import org.junit.Before;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.base.VersionTestParent;

/**
 * Test asserting Firefox versions.
 *
 * @author Boni Garcia (boni.gg@gmail.com)
 * @since 1.5.0
 */
public class FirefoxVersionTest extends VersionTestParent {

    @Before
    public void setup() {
        browserManager = WebDriverManager.firefoxdriver();
        specificVersions = new String[] { "0.8.0", "0.19.1" };
    }

}