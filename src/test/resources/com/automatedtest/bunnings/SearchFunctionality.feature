Feature: search Functionality

  Scenario Outline: Verify Alert Message on Clicking Search Icon without Text
    Given A user navigates to Bunnings URL
    When User clicks on search icon without entering any item in search box
    Then Verify <searchMessage> message is displayed
    When User clicks on ok button
    Then User navigates back to home page and page title contains "Bunnings Warehouse"

    Examples:
      | searchMessage                |
      | Please enter search keywords |


  Scenario Outline: Verify Search Results
    Given A user navigates to Bunnings URL
    When User clicks on search button
    And User enters item as <item> in search box
    Then Number of search results are displayed for <item>

    Examples:
      | item |
      | Fans |


  Scenario Outline: Verify List of Recent Searches
    Given A user navigates to Bunnings URL
    When User clicks on search button
    And User enters item as <firstItem> in search box
    When User clicks on search button
    And User enters item as <secondItem> in search box
    And User clicks on search button
    Then First item <firstItem> and second item <secondItem> are displayed in the recent search list
    When User clicks on search button
    And User clicks on clear search history
    And User clicks on search button
    Then Recent search list is not displayed

    Examples:
      | firstItem | secondItem |
      | Fans      | Cooler     |



