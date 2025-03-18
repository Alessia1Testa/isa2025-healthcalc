
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

    @tag5
    Scenario Outline: Minimum height for men 
        Given I have a health calculator 
        When I enter a height of 84 cm and gender 'm' 
        Then the system returns an ideal weight of 0.5

    @tag6
    Scenario Outline: Minimum height for women 
        Given I have a health calculator 
        When I enter a height of 67 cm and gender 'w' 
        Then the system returns an ideal weight of 0.2

    @tag7 
    Scenario Outline: Invalid range height for men 
        Given I have a health calculator 
        When I enter a height of 83 cm and gender 'm' 
        Then the system throws an InvalidHeightException

    @tag8
    Scenario Outline: Invalid range height for women 
        Given I have a health calculator 
        When I enter a height of 66 cm and gender 'w' 
        Then the system throws an InvalidHeightException

    @tag9 
    Scenario Outline: Unreal height value 
        Given I have a health calculator 
        When I enter a height of 250 cm and gender 'w' 
        Then the system throws an InvalidHeightException


