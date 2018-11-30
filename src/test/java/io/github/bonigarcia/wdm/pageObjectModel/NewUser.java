package io.github.bonigarcia.wdm.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class NewUser {

    WebDriver driver;
    //Using FindBy for locating elements
    //Text field Name
    @FindBy(how = How.ID, using = "name")
    WebElement Name;
    //Error label Name
    @FindBy(how = How.ID, using = "user.name.error")
    WebElement NameError;
    //Text field Email
    @FindBy(how = How.ID, using = "email")
    WebElement Email;
    //Error label Email
    @FindBy(how = How.ID, using = "user.email.error")
    WebElement EmailError;
    //Text field Password
    @FindBy(how = How.ID, using = "password")
    WebElement Password;
    //Error label Password
    @FindBy(how = How.ID, using = "user.password.error")
    WebElement PasswordError;
    //Text field Confirmation password
    @FindBy(how = How.ID, using = "confirmationPassword")
    WebElement ConfirmationPassword;
    //Error label Confirmation password
    @FindBy(how = How.ID, using = "user.confirmationPassword.error")
    WebElement ConfirmationPasswordError;
    //Button Submit
    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/fieldset/div[5]/button")
    WebElement Submit;
    //Button All User
    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/fieldset/div[5]/a")
    WebElement AllUser;
    public NewUser(WebDriver driver) {
        this.driver = driver;
    }

    // Defining all the user actions (Methods) that can be performed in the New User page
    //Set Name
    public void setName(String strName) {
        Name.sendKeys(strName);
    }

    public String getNameError() {
        String nameErrorStr = NameError.getText();
        return nameErrorStr;
    }

    //Set Email
    public void setEmail(String strEmail) {
        Email.sendKeys(strEmail);
    }

    public String getEmailError() {
        String emailErrorStr = EmailError.getText();
        return emailErrorStr;
    }

    //Set Password
    public void setPassword(String strPassword) {
        Password.sendKeys(strPassword);
    }

    public String getPasswordError() {
        String passwordErrorStr = PasswordError.getText();
        return passwordErrorStr;
    }

    //Set Confirmation Password
    public void setConfirmationPassword(String strConfirmationPassword) {
        ConfirmationPassword.sendKeys(strConfirmationPassword);
    }

    public String getConfirmationPasswordError() {
        String confirmationPasswordErrorStr = ConfirmationPasswordError.getText();
        return confirmationPasswordErrorStr;
    }

    //Click the Submit button
    public void clickOnSubmit() {
        Submit.click();
    }

    //Click the All User button
    public void clickOnAllUser() {
        AllUser.click();
    }
}
