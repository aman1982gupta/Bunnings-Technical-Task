package com.automatedtest.bunnings.functionalTests.steps;

import com.automatedtest.bunnings.functionalTests.pages.SearchFunctionalityPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchFunctionalitySteps {

    private SearchFunctionalityPage searchFunctionalityPage;

    public SearchFunctionalitySteps() {
        this.searchFunctionalityPage = new SearchFunctionalityPage();
    }

    @Given("^A user navigates to Bunnings URL$")
    public void a_user_navigates_to_bunnings_url() throws Throwable {
        this.searchFunctionalityPage.homePage_Navigation();
    }

    @When("^User clicks on search icon without entering any item in search box$")
    public void user_clicks_on_search_icon_without_entering_any_item_in_search_box() throws Throwable {
        this.searchFunctionalityPage.searchIconClick();
    }

    @Then("^Verify (.+) message is displayed$")
    public void verify_message_is_displayed(String searchmessage) throws Throwable {
        this.searchFunctionalityPage.messageDisplay(searchmessage);

    }

    @When("User clicks on ok button$")
    public void user_clicks_on_ok_button() throws Throwable {
        this.searchFunctionalityPage.acceptButton();
    }

    @Then("^User navigates back to home page and page title contains \"([^\"]*)\"$")
    public void user_navigates_back_to_home_page_and_page_title_contains_something(String title) throws Throwable {
        String displayedTitle = this.searchFunctionalityPage.getTitle();
        Assert.assertTrue("Displayed title is " + displayedTitle + " instead of " + title,
                displayedTitle.contains(title));
    }

    @When("^User clicks on search button$")
    public void user_clicks_on_search_button() throws Throwable {
        System.out.println("test");
        this.searchFunctionalityPage.searchButtonClick();
    }

    @When("^User enters item as (.+) in search box$")
    public void user_enters_item_as_in_search_box(String product) throws Throwable {
        this.searchFunctionalityPage.enterItem(product);
    }

    @Then("^Number of search results are displayed for (.+)$")
    public void number_of_search_results_are_displayed(String searchTerm) throws Throwable {
        this.searchFunctionalityPage.verifyResultText(searchTerm);
    }

    @Then("^First item (.+) and second item (.+) are displayed in the recent search list$")
    public void first_item_and_second_item_are_displayed_in_the_recent_search_list(String firstitem, String seconditem) throws Throwable {
        this.searchFunctionalityPage.verifyRecentSearchHistory(firstitem, seconditem);
    }

    @When("^User clicks on clear search history$")
    public void user_clicks_on_clear_search_history() throws Throwable {
        this.searchFunctionalityPage.clearHistoryButton();
    }

    @Then("^Recent search list is not displayed$")
    public void recent_search_list_is_not_displayed() throws Throwable {
        this.searchFunctionalityPage.recentSearch();

    }
}