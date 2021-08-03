Feature: Making to do tests

  Scenario Outline: Create a ToDo
    Given User clicks on implementation as "<impl>"
    And User can see ToDoList
    Then User can make TodoList

    When User types in inputfield "Automation is fun!"
    And User clicks on enter button
    Then User can see new todo in todolist

    Examples:
      | impl  |
      | Vanilla JS  |
      | Vanilla Js  |
      | Vanilla Js  |