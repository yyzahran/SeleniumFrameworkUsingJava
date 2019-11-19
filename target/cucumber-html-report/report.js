$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/End2EndTests.feature");
formatter.feature({
  "name": "Automated End2End Tests",
  "description": "  Description: The purpose of this feature is to test End 2 End integration.",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Customer place an order by purchasing an item from search",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user is on Home Page",
  "keyword": "Given "
});
formatter.step({
  "name": "he search for \"\u003cproductName\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "choose to buy Two items",
  "keyword": "And "
});
formatter.step({
  "name": "moves to checkout cart and enter personal details on checkout page and place the order",
  "keyword": "And "
});
formatter.step({
  "name": "he can view the order and download the invoice",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "productName"
      ]
    },
    {
      "cells": [
        "Apple MacBook Pro 13-inch"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Customer place an order by purchasing an item from search",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user is on Home Page",
  "keyword": "Given "
});
formatter.match({
  "location": "E2ETestSteps.user_is_on_Home_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he search for \"Apple MacBook Pro 13-inch\"",
  "keyword": "When "
});
formatter.match({
  "location": "E2ETestSteps.he_search_for(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "choose to buy Two items",
  "keyword": "And "
});
formatter.match({
  "location": "E2ETestSteps.choose_to_buy_Two_items()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "moves to checkout cart and enter personal details on checkout page and place the order",
  "keyword": "And "
});
formatter.match({
  "location": "E2ETestSteps.moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he can view the order and download the invoice",
  "keyword": "Then "
});
formatter.match({
  "location": "E2ETestSteps.he_can_view_the_order_and_download_the_invoice()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:src/test/java/features/UserRegistration.feature");
formatter.feature({
  "name": "User Registration",
  "description": "\tThe user can register successfully on the e-commerce website.",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "User Registration",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "the user on the homepage",
  "keyword": "Given "
});
formatter.step({
  "name": "User clicks on registerlink",
  "keyword": "When "
});
formatter.step({
  "name": "User enters \"\u003cfirstname\u003e\", \"\u003clastname\u003e\", \"\u003cemail\u003e\", \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "the registration page is displayed successfully",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "firstname",
        "lastname",
        "email",
        "password"
      ]
    },
    {
      "cells": [
        "Joe",
        "Mama",
        "e5sleke@t11est.com",
        "123456789"
      ]
    },
    {
      "cells": [
        "Yuri",
        "Tarded",
        "teet@us11er.ca",
        "987654321"
      ]
    }
  ]
});
formatter.scenario({
  "name": "User Registration",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "the user on the homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "UserRegistrationSteps.the_user_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on registerlink",
  "keyword": "When "
});
formatter.match({
  "location": "UserRegistrationSteps.user_clicks_on_registerlink()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters \"Joe\", \"Mama\", \"e5sleke@t11est.com\", \"123456789\"",
  "keyword": "And "
});
formatter.match({
  "location": "UserRegistrationSteps.user_enters(String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the registration page is displayed successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "UserRegistrationSteps.the_registration_page_is_displayed_successfully()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User Registration",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "the user on the homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "UserRegistrationSteps.the_user_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on registerlink",
  "keyword": "When "
});
formatter.match({
  "location": "UserRegistrationSteps.user_clicks_on_registerlink()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters \"Yuri\", \"Tarded\", \"teet@us11er.ca\", \"987654321\"",
  "keyword": "And "
});
formatter.match({
  "location": "UserRegistrationSteps.user_enters(String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the registration page is displayed successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "UserRegistrationSteps.the_registration_page_is_displayed_successfully()"
});
formatter.result({
  "status": "passed"
});
});