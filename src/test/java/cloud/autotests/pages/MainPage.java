package cloud.autotests.pages;

import cloud.autotests.data.CategoryItem;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private SelenideElement categorySideBar = $(".listbox");
    private SelenideElement pageBody = $(".page");
    private ElementsCollection productItems = pageBody.$$(".product-item");

    public void checkOpenedPage (String text) {
        pageBody.shouldHave(Condition.text(text));
    }

    public void navigateToCategory (CategoryItem categoryName) {
        categorySideBar.find(byText(categoryName.getDisplayedName())).click();
    }

    public void checkQuantityItems (int quantity) {
        productItems.shouldHave(CollectionCondition.size(quantity));
    }
}
