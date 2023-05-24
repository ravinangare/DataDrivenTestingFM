package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class DeleteCustomerTest extends BaseTest{
	public void DeleteCustomerTest(String name, String lastName, String postCode,String id) {
        click("btnLoginManager_XPATH");
        wait.until(ExpectedConditions.elementToBeClickable(super.getSelectorType("tabAddCustomer_XPATH")));
        click("tabAddCustomer_XPATH");
        if (display("inputFirstName_XPATH")) { 
            type("inputFirstName_XPATH", name);
            type("inputLastName_XPATH", lastName);
            type("inputPostCode_XPATH", postCode);
            click("btnAddCustomer_XPATH");
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertMessage = alert.getText();
            alert.accept();
            log.info(alertMessage);
            click("btnHome_XPATH");
        } else {
            String errorMessage = "The form to add a customer could not be found";
            log.info(errorMessage);
            Assert.fail(errorMessage);
        }
    }

}
