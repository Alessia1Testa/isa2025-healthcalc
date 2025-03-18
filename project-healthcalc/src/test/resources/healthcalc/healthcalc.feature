@tag
Feature: Ideal Weight Calculation
  As a user I want to compute my ideal weight so that I can know if I am healthy

    @tag1
    Scenario: Compute ideal weight for a man of 175 cm
        Given I have a health calculator
        When I enter a height of 175 cm and a man gender
        Then The system returns an ideal weight of 68.75
 
    @tag2
    Scenario Outline: Compute ideal weight for a woman
        Given I have a health calculator
        When I enter a height of <height> cm and gender "w"
        Then the system returns an ideal weight of <expectedWeight>

    Examples:
        | height | expectedWeight |
        | 160    | 56.00          |
        | 170    | 62.00          |

    @tag3
    Scenario Outline: Negative height value
        Given I have a health calculator
        When I enter a height of -160 cm and gender 'w'
        Then the system throws an InvalidHeightException

    @tag4
    Scenario Outline: Invalid gender value 
        Given I have a health calculator 
        When I enter a height of 160 cm and gender 'x' 
        Then the system throws an InvalidGenderException