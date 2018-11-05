Feature: Aged Brie
  # "Aged Brie" increases in Quality the older it gets

  Scenario: Aged Brie update
    Given I have a new inventory
    Then the quality of the aged brie is 0
    When I update the inventory
    Then the quality of the aged brie is 1