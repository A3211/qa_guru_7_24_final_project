package cloud.autotests.tests.ui;

import cloud.autotests.data.CategoryItem;
import cloud.autotests.pages.MainPage;
import cloud.autotests.pages.RegisterPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class AddProductTests {
    MainPage mainPage = new MainPage();
    RegisterPage registerPage = new RegisterPage();

    @Test
    void addProductTest() {
        open("http://demowebshop.tricentis.com/");
        mainPage.checkOpenedPage("Welcome to our store");
        mainPage.navigateToCategory(CategoryItem.BOOKS);
        mainPage.checkOpenedPage("Books");
        mainPage.checkQuantityItems(6);
    }

    @Test
    void checkBooksQuantityTest() {
        open("http://demowebshop.tricentis.com/");
        mainPage.checkOpenedPage("Welcome to our store");
        mainPage.navigateToCategory(CategoryItem.BOOKS);
        mainPage.checkQuantityItems(6);
    }

    @Test
    void successfulRegistrationTest() {
        registerPage.openPage()
                    .typeFirstName()
                    .typeLastName()
                    .typeEmail()
                    .typePassword()
                    .typeConfirmPassword()
                    .clickRegisterButton()
                    .checkSuccessfulRegistration();
    }
}
