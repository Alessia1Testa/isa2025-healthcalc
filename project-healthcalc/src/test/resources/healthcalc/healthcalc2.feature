@tag
Feature: Basal Metabolic Rate Calculation 
    As a user I want to compute my Basal Metabolic Rate so that I can know my daily calorie needs

    @tag1
    Scenario: Compute BMR for a man with weight 80 kg, height 175 cm, and age 30 
        Given I have a health calculator 
        When I enter weight 80 kg, height 175 cm, age 30, and gender 'm' 
        Then the system returns a BMR of 1829.637