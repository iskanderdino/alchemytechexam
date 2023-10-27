@api
Feature: This feature will test Users API Request


  @smoke
  Scenario: Verify status code of users api request
    Given I set url "booking" "GET" service request api endpoint
    Then I should receive http response code "200"

#  Scenario: Verify response schema on the users api
#    Then the schema response for user "id" should be "integer"
#    Then the schema response for user "name" should be "string"
#    Then the schema response for user "address" should be "string"
#    Then the schema response for user "city" should be "string"
#    Then the schema response for user "zipcode" should be "integer"
#
#  Scenario Verify API response for specific users
#    When "POST" method for "users" api request where "username" is "Kamren"
#    Then the api response for username "Kamren" "city" should be "Roscoeview"