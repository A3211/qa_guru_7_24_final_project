package cloud.autotests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegisterPage {
    Faker faker = new Faker();

    String userName = faker.name().firstName();
    String userLastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userPassword = "Test123456";

    private SelenideElement firstName = $("#FirstName");
    private SelenideElement lastName = $("#LastName");
    private SelenideElement email = $("#Email");
    private SelenideElement password = $("#Password");
    private SelenideElement confirmPassword = $("#ConfirmPassword");
    private SelenideElement registerButton = $("#register-button");
    private SelenideElement resultPage = $(".result");

    private SelenideElement myAccount = $(".header-links").$(".account");

    public void openPage() {
        open("http://demowebshop.tricentis.com/register");
        $(".page-title").shouldHave(Condition.text("Register"));
    }

    public void typeFirstName() {
        firstName.setValue(userName);
    }

    public void typeLastName() {
        lastName.setValue(userLastName);
    }

    public void typeEmail() {
        email.setValue(userEmail);
    }

    public void typePassword() {
        password.setValue(userPassword);
    }

    public void typeConfirmPassword() {
        confirmPassword.setValue(userPassword);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void checkSuccessfulRegistration() {
        resultPage.shouldHave(Condition.text("Your registration completed"));
        myAccount.click();
        firstName.shouldHave(Condition.value(userName));
        lastName.shouldHave(Condition.value(userLastName));
        email.shouldHave(Condition.value(userEmail));
    }
}
