package io.github.bonigarcia.wdm.test.ds;

import io.github.bonigarcia.wdm.base.BrowserTestParent;
import io.github.bonigarcia.wdm.pageObjectModel.NewUser;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertThat;

public class InitialTests extends BrowserTestParent {

    @Test
    public void newUserPageUpAndRunning() throws Exception {
        //Initial test to make sure the correct page is loaded
        assertThat("New User page not found!", driver.getTitle(), CoreMatchers.containsString("New User"));
    }

    @Test
    public void allUserPageUpAndRunning() throws Exception {
        //Initial test to make sure the correct page is loaded
        NewUser newUser = PageFactory.initElements(driver, NewUser.class);
        newUser.clickOnAllUser();
        assertThat("All User page not found!", driver.getTitle(), CoreMatchers.containsString("All User"));
    }
}
