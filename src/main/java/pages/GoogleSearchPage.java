package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage extends BasePage {
    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private WebElement searchInputField;

    @FindBy(xpath = "//div[contains(@class, 'CqAVzb')]//input[@value='Google Search']")
    private WebElement searchButton;

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public GoogleSearchResultPage searchByKeyword(String keyword) {
        waitForPageLoadComplete();
        searchInputField.sendKeys(keyword);
        clickElement(searchButton);
        return new GoogleSearchResultPage(driver);
    }
}
