Feature: Search Action

Scenario: Successful search with Search Credentials
	Given User is on https://www.amazon.com
	And User enters SearchName for the item
	When User selects the second item from search results
	And User views the details
	Then Message displayed Search Successful