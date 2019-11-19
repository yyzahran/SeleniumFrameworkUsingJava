Feature: User Registration
	The user can register successfully on the e-commerce website.
	
	Scenario Outline: User Registration
	Given the user on the homepage
	When User clicks on registerlink
	And User enters "<firstname>", "<lastname>", "<email>", "<password>"
	Then the registration page is displayed successfully
	
	Examples: 
	| firstname | lastname | email | password |
	| Joe | Jack | e5sleke@t11est.com | 123456789 |
	| Will | Smith | teet@us11er.ca | 987654321 |