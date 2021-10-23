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

    // рандомный гендер https://coderoad.ru/57680255/%D0%9A%D0%B0%D0%BA-%D1%81%D0%BE%D0%B7%D0%B4%D0%B0%D1%82%D1%8C-%D0%BA%D0%BE%D0%B3%D0%B5%D1%80%D0%B5%D0%BD%D1%82%D0%BD%D1%8B%D0%B9-%D0%BE%D0%B1%D1%8A%D0%B5%D0%BA%D1%82-%D1%81-%D0%BF%D0%BE%D0%BC%D0%BE%D1%89%D1%8C%D1%8E-java-faker
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

    public RegisterPage openPage() {
        open("http://demowebshop.tricentis.com/register");
        $(".page-title").shouldHave(Condition.text("Register"));
        return this;
    }

    public RegisterPage typeFirstName() {
        firstName.setValue(userName);
        return this;
    }

    public RegisterPage typeLastName() {
        lastName.setValue(userLastName);
        return this;
    }

    public RegisterPage typeEmail() {
        email.setValue(userEmail);
        return this;
    }

    public RegisterPage typePassword() {
        password.setValue(userPassword);
        return this;
    }

    public RegisterPage typeConfirmPassword() {
        confirmPassword.setValue(userPassword);
        return this;
    }

    public RegisterPage clickRegisterButton() {
        registerButton.click();
        return this;
    }

    public RegisterPage checkSuccessfulRegistration() {
        resultPage.shouldHave(Condition.text("Your registration completed"));
        myAccount.click();
        firstName.shouldHave(Condition.value(userName));
        lastName.shouldHave(Condition.value(userLastName));
        email.shouldHave(Condition.value(userEmail));
        return this;
    }
}
