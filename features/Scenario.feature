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
      | item       |
      | Vanilla JS |
      | AngularJS  |
      | Ractive.js |


  Scenario Outline: Remove a ToDo
    Given I launch chrome browser
    And I open the website
    Given I can click on the link "<item>"
    And I type in a todo "Automation is fun!"
    Then I can see a todo added to todo list
    And I can delete a todo
    And I can close the site


    Examples:
      | item       |
      | Vanilla JS |
      | AngularJS  |
      | Ractive.js |


  Scenario Outline: Complete a ToDo
    Given I launch chrome browser
    And I open the website
    Given I can click on the link "<item>"
    And I type in a todo "Automation is fun!"
    And I type in a todo "owee a second string"
    And I type in a todo "and even a third one"
    Then I can see all todos added to todo list
    And I can complete a todo
    And I can close the site


    Examples:
      | item       |
      | Vanilla JS |
      | AngularJS  |
      | Ractive.js |


  Scenario Outline: Modify a ToDo
    Given I launch chrome browser
    And I open the website
    Given I can click on the link "<item>"
    And I type in a todo "Automation is fun!"
    And I type in a todo "owee a second string"
    And I type in a todo "and even a third one"
    Then I can see all todos added to todo list
    When I search a todo "Automation is fun!" I can change it to "This is the new input!"
    And I can close the site


    Examples:
      | item       |
      | Vanilla JS |
      | AngularJS  |
      | Ractive.js |



  Scenario Outline: Viewing completed ToDos
    Given I launch chrome browser
    And I open the website
    Given I can click on the link "<item>"
    And I type in a todo "Automation is fun!"
    And I type in a todo "owee a second string"
    And I type in a todo "and even a third one"
    Then I can see all todos added to todo list
    When I change to completed todo page
    Then completed todo page is empty, but there are still "3" todos
    When I change back to all todos page
    And I can complete a todo
    When I change to completed todo page
    Then completed todo page has 1 todo
    And I can close the site


    Examples:
      | item       |
      | Vanilla JS |
      | AngularJS  |
      | Ractive.js |

