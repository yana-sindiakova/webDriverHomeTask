package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.GoogleSearchResultPage;

public class SearchForImage extends BaseTest {
    private static final String SEARCH_KEYWORD = "image";
    private static final int EXPECTED_IMAGES_NUMBER = 12;
    private static final String ATTRIBUTE = "src";
    private static final String EXPECTED_ATTRIBUTE_VALUE = "data:image/";
    SoftAssert softAssert;

    @Test(description = "Search for image")
    public void checkThatSearchResultTabContainsImages() {
        softAssert = new SoftAssert();
        GoogleSearchResultPage googleSearchResultPage = getGoogleSearchPage()
                .searchByKeyword(SEARCH_KEYWORD);
        softAssert.assertEquals(googleSearchResultPage.getSearchResultImagesNumber(), EXPECTED_IMAGES_NUMBER, "The number of images is incorrect");
        softAssert.assertTrue(googleSearchResultPage.checkAttributeValue(ATTRIBUTE, EXPECTED_ATTRIBUTE_VALUE), ATTRIBUTE + " attribute doesn't contain " + EXPECTED_ATTRIBUTE_VALUE);
        softAssert.assertAll();
    }
}
