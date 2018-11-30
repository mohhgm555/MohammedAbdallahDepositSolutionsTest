package io.github.bonigarcia.wdm.test.ds;

import io.github.bonigarcia.wdm.base.BrowserTestParent;
import io.github.bonigarcia.wdm.pageObjectModel.AllUsers;
import io.github.bonigarcia.wdm.pageObjectModel.NewUser;
import io.github.bonigarcia.wdm.testData.GeneralTestData;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class NegativeTestCasesForNewUserPage extends BrowserTestParent {
    @Test
    public void nameIsEmpty() throws Exception {
        //Prepare test data
        GeneralTestData generalTestData = new GeneralTestData();
        //Get a new password
        String pwd = generalTestData.getPwd(8);
        //Get timestamp
        String timestamp = generalTestData.getTimestamp();

        //Test steps
        NewUser newUser = PageFactory.initElements(driver, NewUser.class);
        newUser.setEmail("ma.test" + timestamp + "@ds.com");
        newUser.setPassword(pwd);
        newUser.setConfirmationPassword(pwd);
        newUser.clickOnSubmit();
        //Make sure browser still on the same page
        assertThat(driver.getTitle(), containsString("New User"));
        //Verify name error required
        assertThat(newUser.getNameError(), containsString("Required"));
    }

    @Test
    public void nameIsNotUnique() throws Exception {
        //Prepare test data
        GeneralTestData generalTestData = new GeneralTestData();
        //Get a new password
        String pwd = generalTestData.getPwd(8);
        //Get timestamp
        String timestamp = generalTestData.getTimestamp();

        //Test steps
        NewUser newUser = PageFactory.initElements(driver, NewUser.class);
        newUser.setName("Same Person" + timestamp);
        newUser.setEmail("ma.test" + timestamp + "@ds.com");
        newUser.setPassword(pwd);
        newUser.setConfirmationPassword(pwd);
        newUser.clickOnSubmit();
        AllUsers allUsers = PageFactory.initElements(driver, AllUsers.class);
        allUsers.clickOnNewUser();
        //Make sure browser returns to New User page
        assertThat(driver.getTitle(), containsString("New User"));
        newUser.setName("Same Person" + timestamp);
        newUser.setEmail("ma2.test" + timestamp + "@ds.com");
        newUser.setPassword(pwd);
        newUser.setConfirmationPassword(pwd);
        newUser.clickOnSubmit();
        //Verify name error unique
        assertThat(newUser.getNameError(), containsString("Must be unique"));
    }

    @Test
    public void nameIsTooLong() throws Exception {
        //Prepare test data
        GeneralTestData generalTestData = new GeneralTestData();
        //Get a new password
        String pwd = generalTestData.getPwd(8);
        //Get timestamp
        String timestamp = generalTestData.getTimestamp();

        //Test steps
        NewUser newUser = PageFactory.initElements(driver, NewUser.class);
        newUser.setName("123456789012345678901234567890123456789012345678901234567890132456798012345678901234567901234567890" + //100 Char
                "123456789012345678901234567890123456789012345679801234567890123456790123456789012346579801234567890" +         //100 Char
                "123456789012345678901234567890123456789012345678901" + timestamp);                                               //55 Char + timestamp

        newUser.setEmail("ma.test" + timestamp + "@ds.com");
        newUser.setPassword(pwd);
        newUser.setConfirmationPassword(pwd);
        newUser.clickOnSubmit();
        //Make sure browser still on the same page
        assertThat("Page changed!", driver.getTitle(), containsString("New User"));
        //Verify name error
        assertThat("Expected error message not found!", newUser.getNameError(), containsString("Maximum size is 255"));
    }

    @Test
    public void emailIsEmpty() throws Exception {
        //Prepare test data
        GeneralTestData generalTestData = new GeneralTestData();
        //Get a new password
        String pwd = generalTestData.getPwd(8);
        //Get timestamp
        String timestamp = generalTestData.getTimestamp();

        //Test steps
        NewUser newUser = PageFactory.initElements(driver, NewUser.class);
        newUser.setName("MA" + timestamp);
        newUser.setPassword(pwd);
        newUser.setConfirmationPassword(pwd);
        newUser.clickOnSubmit();
        //Make sure browser still on the same page
        assertThat("Page changed!", driver.getTitle(), containsString("New User"));
        //Verify email error required
        assertThat("Expected error message not found!", newUser.getEmailError(), containsString("Required"));
    }

    @Test
    public void emailIsNotUnique() throws Exception {
        //Prepare test data
        GeneralTestData generalTestData = new GeneralTestData();
        //Get a new password
        String pwd = generalTestData.getPwd(8);
        //Get timestamp
        String timestamp = generalTestData.getTimestamp();

        //Test steps
        NewUser newUser = PageFactory.initElements(driver, NewUser.class);
        newUser.setName("MA" + timestamp);
        newUser.setEmail("ma.same.email" + timestamp + "@ds.com");
        newUser.setPassword(pwd);
        newUser.setConfirmationPassword(pwd);
        newUser.clickOnSubmit();
        AllUsers allUsers = PageFactory.initElements(driver, AllUsers.class);
        allUsers.clickOnNewUser();
        //Make sure browser returns to New User page
        assertThat(driver.getTitle(), containsString("New User"));
        newUser.setName("MA2" + timestamp);
        newUser.setEmail("ma.same.email" + timestamp + "@ds.com");
        newUser.setPassword(pwd);
        newUser.setConfirmationPassword(pwd);
        newUser.clickOnSubmit();
        //Verify email error unique
        assertThat("Expected error message not found!", newUser.getEmailError(), containsString("Must be unique"));
    }

    @Test
    public void emailInWrongFormatWithoutAt() throws Exception {
        //Prepare test data
        GeneralTestData generalTestData = new GeneralTestData();
        //Get a new password
        String pwd = generalTestData.getPwd(8);
        //Get timestamp
        String timestamp = generalTestData.getTimestamp();

        //Test steps
        NewUser newUser = PageFactory.initElements(driver, NewUser.class);
        newUser.setName("MA" + timestamp);
        newUser.setEmail("ma" + timestamp + "ds.com");
        newUser.setPassword(pwd);
        newUser.setConfirmationPassword(pwd);
        newUser.clickOnSubmit();
        //Make sure browser still on the same page
        assertThat("Page changed!", driver.getTitle(), containsString("New User"));
        //Verify email error
        assertThat("Expected error message not found!", newUser.getEmailError(), containsString("Invalid email address"));
    }

    @Test
    public void emailInWrongFormatWithoutDot() throws Exception {
        //Prepare test data
        GeneralTestData generalTestData = new GeneralTestData();
        //Get a new password
        String pwd = generalTestData.getPwd(8);
        //Get timestamp
        String timestamp = generalTestData.getTimestamp();

        //Test steps
        NewUser newUser = PageFactory.initElements(driver, NewUser.class);
        newUser.setName("MA" + timestamp);
        newUser.setEmail("ma" + timestamp + "@dscom");
        newUser.setPassword(pwd);
        newUser.setConfirmationPassword(pwd);
        newUser.clickOnSubmit();
        //Make sure browser still on the same page
        assertThat("Page changed!", driver.getTitle(), containsString("New User"));
        //Verify email error
        assertThat("Expected error message not found!", newUser.getEmailError(), containsString("Invalid email address"));
    }

    @Test
    public void emailInWrongFormatWithoutSpecialCharacters() throws Exception {
        //Prepare test data
        GeneralTestData generalTestData = new GeneralTestData();
        //Get a new password
        String pwd = generalTestData.getPwd(8);
        //Get timestamp
        String timestamp = generalTestData.getTimestamp();

        //Test steps
        NewUser newUser = PageFactory.initElements(driver, NewUser.class);
        newUser.setName("MA" + timestamp);
        newUser.setEmail("~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?" + "@ds.com");
        newUser.setPassword(pwd);
        newUser.setConfirmationPassword(pwd);
        newUser.clickOnSubmit();
        //Make sure browser still on the same page
        assertThat("Page changed!", driver.getTitle(), containsString("New User"));
        //Verify email error
        assertThat("Expected error message not found!", newUser.getEmailError(), containsString("Invalid email address"));
    }

    @Test
    public void emailIsTooLong() throws Exception {
        //Prepare test data
        GeneralTestData generalTestData = new GeneralTestData();
        //Get a new password
        String pwd = generalTestData.getPwd(8);
        //Get timestamp
        String timestamp = generalTestData.getTimestamp();

        //Test steps
        NewUser newUser = PageFactory.initElements(driver, NewUser.class);
        newUser.setName("MA" + timestamp);
        newUser.setEmail("123456789012345678901234567890123456789012345678901234567890132456798012345678901234567901234567890" + //100 Char
                "123456789012345678901234567890123456789012345679801234567890123456790123456789012346579801234567890" +          //100 Char
                "123456789012345678901234567890123456789012345678901" + timestamp + "@ds.com");                                      //55 Char + timestamp
        newUser.setPassword(pwd);
        newUser.setConfirmationPassword(pwd);
        newUser.clickOnSubmit();
        //Make sure browser still on the same page
        assertThat("Page changed!", driver.getTitle(), containsString("New User"));
        //Verify email error
        assertThat("Expected error message not found!", newUser.getEmailError(), containsString("Maximum size is 255"));
    }

    @Test
    public void passwordIsEmpty() throws Exception {
        //Prepare test data
        GeneralTestData generalTestData = new GeneralTestData();
        //Get a new password
        String pwd = generalTestData.getPwd(8);
        //Get timestamp
        String timestamp = generalTestData.getTimestamp();

        //Test steps
        NewUser newUser = PageFactory.initElements(driver, NewUser.class);
        newUser.setName("MA" + timestamp);
        newUser.setEmail("ma" + timestamp + "@dscom");
        newUser.setConfirmationPassword(pwd);
        newUser.clickOnSubmit();
        //Make sure browser still on the same page
        assertThat("Page changed!", driver.getTitle(), containsString("New User"));
        //Verify password error required
        assertThat("Expected error message not found!", newUser.getPasswordError(), containsString("Required"));
    }

    @Test
    public void confirmationPasswordIsEmpty() throws Exception {
        //Prepare test data
        GeneralTestData generalTestData = new GeneralTestData();
        //Get a new password
        String pwd = generalTestData.getPwd(8);
        //Get timestamp
        String timestamp = generalTestData.getTimestamp();

        //Test steps
        NewUser newUser = PageFactory.initElements(driver, NewUser.class);
        newUser.setName("MA" + timestamp);
        newUser.setEmail("ma" + timestamp + "@ds.com");
        newUser.setPassword(pwd);
        newUser.clickOnSubmit();
        //Make sure browser still on the same page
        assertThat("Page changed!", driver.getTitle(), containsString("New User"));
        //Verify confirmation password error
        assertThat("Expected error message not found!", newUser.getConfirmationPasswordError(), containsString("passwords are not the same"));
    }

    @Test
    public void passwordAndConfirmationPasswordAreNotTheSame() throws Exception {
        //Prepare test data
        GeneralTestData generalTestData = new GeneralTestData();
        //Get a new password
        String pwd1 = generalTestData.getPwd(8);
        //Get another password
        String pwd2 = generalTestData.getPwd(8);
        //Get timestamp
        String timestamp = generalTestData.getTimestamp();

        //Test steps
        NewUser newUser = PageFactory.initElements(driver, NewUser.class);
        newUser.setName("MA" + timestamp);
        newUser.setEmail("ma" + timestamp + "@ds.com");
        newUser.setPassword(pwd1);
        newUser.setConfirmationPassword(pwd2);
        newUser.clickOnSubmit();
        //Make sure browser still on the same page
        assertThat("Page changed!", driver.getTitle(), containsString("New User"));
        //Verify confirmation password error
        assertThat("Expected error message not found!", newUser.getConfirmationPasswordError(), containsString("passwords are not the same"));
    }

    @Test
    public void passwordIsLessThanTheMinimum() throws Exception {
        //Prepare test data
        GeneralTestData generalTestData = new GeneralTestData();
        //Get a new password
        String pwd = generalTestData.getPwd(5);
        //Get timestamp
        String timestamp = generalTestData.getTimestamp();

        //Test steps
        NewUser newUser = PageFactory.initElements(driver, NewUser.class);
        newUser.setName("MA" + timestamp);
        newUser.setEmail("ma" + timestamp + "@ds.com");
        newUser.setPassword(pwd);
        newUser.setConfirmationPassword(pwd);
        newUser.clickOnSubmit();
        //Make sure browser still on the same page
        assertThat("Page changed!", driver.getTitle(), containsString("New User"));
        //Verify Password error
        assertThat("Expected error message not found!", newUser.getPasswordError(), containsString("Minimum size is 6"));
    }

    @Test
    public void passwordIsTooLong() throws Exception {
        //Prepare test data
        GeneralTestData generalTestData = new GeneralTestData();
        //Get a new password
        String pwd = generalTestData.getPwd(256);
        //Get timestamp
        String timestamp = generalTestData.getTimestamp();

        //Test steps
        NewUser newUser = PageFactory.initElements(driver, NewUser.class);
        newUser.setName("MA" + timestamp);
        newUser.setEmail("ma" + timestamp + "@ds.com");
        newUser.setPassword(pwd);
        newUser.setConfirmationPassword(pwd);
        newUser.clickOnSubmit();
        //Make sure browser still on the same page
        assertThat("Page changed!", driver.getTitle(), containsString("New User"));
        //Verify Password error
        assertThat("Expected error message not found!", newUser.getPasswordError(), containsString("Maximum size is 255"));
    }
}
