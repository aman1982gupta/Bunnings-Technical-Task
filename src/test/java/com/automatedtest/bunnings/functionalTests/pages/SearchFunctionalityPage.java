package com.automatedtest.bunnings.functionalTests.pages;

import com.automatedtest.bunnings.basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchFunctionalityPage extends BasePage {

    private static final String LOGIN_URL = "https://www.bunnings.com.au";

    @FindBy(className = "search-container_btn-submit")
    private WebElement searchIcon;

    @FindBy(xpath = "//input[@data-page='/search']")
    private WebElement searchButton;

    @FindBy(className = "responsive-search-title")
    private WebElement resultCountText;

    @FindBy(xpath = "//ul[@class ='search-container_history_list']/li")
    private List<WebElement> historySearch;

    @FindBy(className = "search-container_history_clear")
    private WebElement clearSearch;

    public SearchFunctionalityPage() {
        PageFactory.initElements(driver, this);
    }

    public void homePage_Navigation() {
        driver.get(LOGIN_URL);
        wait.forLoading(20);
    }

    public void searchIconClick() {
        searchIcon.click();
    }

    public void messageDisplay(String searchMessage) {
        String displayedText = driver.switchTo().alert().getText();
        Assert.assertTrue("Displayed text is " + displayedText + " instead of " + searchMessage,
                displayedText.contains(searchMessage));
    }

    public void acceptButton() {
        driver.switchTo().alert().accept();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void searchButtonClick() {
        searchButton.click();
    }

    public void enterItem(String product) {
        searchButton.clear();
        searchButton.sendKeys(product);
        searchButton.sendKeys(Keys.ENTER);
        wait.forLoading(20);
    }

    public void verifyResultText(String searchItem) {
        wait.forLoading(20);
                String resultText = resultCountText.getText();
        assertEquals(true, resultText.matches("[*0-9]+ results for " + searchItem));
    }

    public void verifyRecentSearchHistory(String firstitem, String seconditem) {
        String resultRecentProduct1 = historySearch.get(1).getText();
        String resultRecentProduct2 = historySearch.get(2).getText();
        assertEquals(resultRecentProduct1, seconditem);
        assertEquals(resultRecentProduct2, firstitem);
    }

    public void clearHistoryButton() {
        clearSearch.click();
    }

    public void recentSearch() {
        Assert.assertFalse(Boolean.parseBoolean(historySearch.get(0).getText()));
    }
}
