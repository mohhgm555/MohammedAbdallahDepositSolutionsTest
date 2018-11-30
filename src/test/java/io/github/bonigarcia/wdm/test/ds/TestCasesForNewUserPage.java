package io.github.bonigarcia.wdm.test.ds;

import io.github.bonigarcia.wdm.base.BrowserTestParent;
import io.github.bonigarcia.wdm.pageObjectModel.NewUser;
import io.github.bonigarcia.wdm.testData.GeneralTestData;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class TestCasesForNewUserPage extends BrowserTestParent {
    @Test
    public void plainVanilla() throws Exception {
        //Prepare test data
        GeneralTestData generalTestData = new GeneralTestData();
        //Get a new password
        String pwd = generalTestData.getPwd(8);
        //Get timestamp
        String timestamp = generalTestData.getTimestamp();
        //Test steps
        NewUser newUser = PageFactory.initElements(driver, NewUser.class);
        newUser.setName("MA" + timestamp);
        newUser.setEmail("ma.test" + timestamp + "@ds.com");
        newUser.setPassword(pwd);
        newUser.setConfirmationPassword(pwd);
        newUser.clickOnSubmit();
        assertThat(driver.getTitle(), containsString("All User"));
    }

    @Test
    public void nameWithSpecialCharacters() throws Exception {
        //Prepare test data
        GeneralTestData generalTestData = new GeneralTestData();
        //Generate Complex name and email
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        String nameStr = RandomStringUtils.random(100, characters);
        //Get a new password
        String pwd = generalTestData.getPwd(100);
        //Get timestamp
        String timestamp = generalTestData.getTimestamp();
        //Test steps
        NewUser newUser = PageFactory.initElements(driver, NewUser.class);
        newUser.setName(nameStr + timestamp);
        newUser.setEmail("ma" + timestamp + "@ds.com");
        newUser.setPassword(pwd);
        newUser.setConfirmationPassword(pwd);
        newUser.clickOnSubmit();
        assertThat(driver.getTitle(), containsString("All User"));
    }
}
