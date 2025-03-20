@tag
Feature: Basal Metabolic Rate Calculation 
    As a user I want to compute my Basal Metabolic Rate so that I can know my daily calorie needs

    @tag1
    Scenario: Compute BMR for a man with weight 80 kg, height 175 cm, and age 30 
        Given I have a health calculator 
        When I enter weight 80 kg, height 175 cm, age 30, and gender 'm' 
        Then the system returns a BMR of 1829.637

    @tag2
    Scenario Outline: Compute BMR for different users
        Given I have a health calculator
        When I enter weight <weight> kg, height <height> cm, age <age>, and gender '<gender>'
        Then the system returns a BMR of <expectedBMR>

        Examples:
        | weight | height | age | gender | expectedBMR |
        | 60     | 160    | 25  | w      | 1389.84     |
        | 70     | 175    | 30  | m      | 1695.67     |
        | 55     | 165    | 22  | w      | 1372.09     |
        | 80     | 180    | 40  | m      | 1796.86     |
        | 90     | 170    | 35  | m      | 1911.23     |

    @tag3 
    Scenario Outline: Zero weight for a man 
        Given I have a health calculator 
        When I enter weight 0 kg, height 175 cm, age 30, and gender 'm' 
        Then the system throws an InvalidValueException

    @tag4 
    Scenario Outline: Negative age value 
        Given I have a health calculator 
        When I enter weight 70 kg, height 160 cm, age -5, and gender 'w' 
        Then the system throws an InvalidValueException

    @tag5 
    Scenario Outline: Invalid gender value in BMR calculation 
        Given I have a health calculator 
        When I enter weight 70 kg, height 160 cm, age 30, and gender 'x' 
        Then the system throws an InvalidGenderException