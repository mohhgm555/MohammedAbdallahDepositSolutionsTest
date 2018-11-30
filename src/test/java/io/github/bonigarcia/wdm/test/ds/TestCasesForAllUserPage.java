package io.github.bonigarcia.wdm.test.ds;

import io.github.bonigarcia.wdm.base.BrowserTestParent;
import io.github.bonigarcia.wdm.pageObjectModel.AllUsers;
import io.github.bonigarcia.wdm.pageObjectModel.NewUser;
import io.github.bonigarcia.wdm.testData.GeneralTestData;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class TestCasesForAllUserPage extends BrowserTestParent {

    @Test
    public void verifySavedRowsInTable() throws Exception {
        //Prepare test data
        GeneralTestData generalTestData = new GeneralTestData();
        //Get timestamp
        String timestamp = generalTestData.getTimestamp();

        //Test steps
        NewUser newUser = PageFactory.initElements(driver, NewUser.class);
        newUser.setName("TableTest" + timestamp);
        newUser.setEmail("TableTest" + timestamp + "@tabletest.com");
        newUser.setPassword("TableTest");
        newUser.setConfirmationPassword("TableTest");
        newUser.clickOnSubmit();
        AllUsers allUser = PageFactory.initElements(driver, AllUsers.class);
        assertThat("Given Name is not found in the table!", allUser.getNameInLastRow(), containsString("TableTest" + timestamp));
        assertThat("Given Email is not found in the table!", allUser.getEmailInLastRow(), containsString("TableTest" + timestamp + "@tabletest.com"));
        assertThat("Given Password is not found in the table!", allUser.getPasswordInLastRow(), containsString("TableTest"));
    }
}
