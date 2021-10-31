package cloud.autotests.tests.ui;

import cloud.autotests.data.CategoryItem;
import cloud.autotests.pages.MainPage;
import cloud.autotests.pages.RegisterPage;
import cloud.autotests.tests.TestBase;
import org.junit.jupiter.api.Test;

public class DemowebshopTests extends TestBase {
    MainPage mainPage = new MainPage();
    RegisterPage registerPage = new RegisterPage();

    @Test
    void addProductTest() {
        mainPage.openPage()
                .checkOpenedPage("Welcome to our store")
                .navigateToCategory(CategoryItem.BOOKS)
                .checkOpenedPage("Books")
                .checkQuantityItems(6);
    }

    @Test
    void checkBooksQuantityTest() {
        mainPage.openPage()
                .checkOpenedPage("Welcome to our store")
                .navigateToCategory(CategoryItem.BOOKS)
                .checkQuantityItems(6);
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
