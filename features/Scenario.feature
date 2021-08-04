Feature: Check out TodoLists
  As a user, I want to be able to CRUD a todolist so that I can modify the todolist


  Scenario Outline: Create a ToDo
    Given I launch chrome browser
    And I open the website
    Given I can click on the link "<item>"
    And I type in a todo "Automation is fun!"
    Then I can see a todo added to todo list
    And I can close the site


    Examples:
      | item |
      | Vanilla JS |
      | AngularJS |
      | Ractive.js |

    Scenario Outline:


      Examples:
        |  |