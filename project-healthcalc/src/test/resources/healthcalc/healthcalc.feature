@tag
Feature: Ideal Weight Calculation
  As a user I want to compute my ideal weight so that I can know if I am healthy

    @tag1
    Scenario: Compute ideal weight for a man of 175 cm
        Given I have a health calculator
        When I enter a height of 175 cm and a man gender
        Then The system returns an ideal weight of 68.75
 
    @tag2
    Scenario: Compute ideal weight for a woman of <n> cm
        Given I have a health calculator
        When I enter a height of <n> cm and gender 'w'
        Then the system returns an ideal weight of <value>