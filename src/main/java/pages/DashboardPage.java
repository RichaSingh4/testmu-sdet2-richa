package pages;

import base.BasePage;
import base.DriverFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {

    public DashboardPage() {

        PageFactory.initElements(
                DriverFactory.getDriver(),
                this);
    }

    @FindBy(css = ".title")
    private WebElement productsTitle;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartButton;

    @FindBy(css = ".shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeButton;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartIcon;

    public String getProductsTitle() {

        return getText(productsTitle);
    }

    public void addProductToCart() {

        click(addToCartButton);
    }

    public String getCartBadgeCount() {

        return getText(cartBadge);
    }

    public void removeProductFromCart() {

        click(removeButton);
    }

    public boolean isCartBadgeDisplayed() {

        try {

            return cartBadge.isDisplayed();

        } catch (NoSuchElementException e) {

            return false;
        }
    }

    public void openCart() {

        click(cartIcon);
    }
}