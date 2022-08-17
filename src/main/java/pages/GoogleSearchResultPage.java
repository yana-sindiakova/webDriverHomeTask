package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleSearchResultPage extends BasePage {
    @FindBy(xpath = "//div[contains(@class, 'pvresd LFls2 MBlpC')]//img")
    private List<WebElement> searchResultImages;

    @FindBy(xpath = "//div[@class='pvresd LFls2 MBlpC']")
    private WebElement searchResultTab;

    public GoogleSearchResultPage(WebDriver driver) {
        super(driver);
    }


    public int getSearchResultImagesNumber() {
        waitForPageLoadComplete();
        waitVisibilityOfElement(searchResultTab);
        return searchResultImages.size();
    }

    public boolean checkAttributeValue(String attribute, String expectedAttributeValue) {
        if (!searchResultImages.isEmpty()) {
            return searchResultImages.stream()
                    .allMatch(e -> e.getAttribute(attribute).contains(expectedAttributeValue));
        }
        return false;
    }
}
