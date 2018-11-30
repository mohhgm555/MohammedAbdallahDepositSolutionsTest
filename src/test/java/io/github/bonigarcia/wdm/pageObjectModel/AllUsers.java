package io.github.bonigarcia.wdm.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class AllUsers {
    //All Users Table
    @FindBy(how = How.ID, using = "users")
    WebElement UserTable;
    //Button New User
    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/a")
    WebElement NewUser;

    public String getNameInLastRow() {
        List<WebElement> rows = UserTable.findElements(By.tagName("tr"));
        List<WebElement> columns = rows.get(rows.size() - 1).findElements(By.tagName("td"));
        String lastName = columns.get(columns.size() - 3).getText();
        return lastName;
    }

    public String getEmailInLastRow() {
        List<WebElement> rows = UserTable.findElements(By.tagName("tr"));
        List<WebElement> columns = rows.get(rows.size() - 1).findElements(By.tagName("td"));
        String lastEmail = columns.get(columns.size() - 2).getText();
        return lastEmail;
    }

    public String getPasswordInLastRow() {
        List<WebElement> rows = UserTable.findElements(By.tagName("tr"));
        List<WebElement> columns = rows.get(rows.size() - 1).findElements(By.tagName("td"));
        String lastRowData[] = new String[3];
        String lastPassword = columns.get(columns.size() - 1).getText();
        return lastPassword;
    }

    //Click the New User button
    public void clickOnNewUser() {
        NewUser.click();
    }
}
