Feature: Ahorcado

  Scenario: Arriesgar una letra que esta contenida en la palabra secreta.
    Given la palabra secreta es "auto"
    When arriesgo "a"
    Then estado es "a***"
    And me quedan 7 vidas

  Scenario: Arriesgar una letra en mayuscula que esta contenida en la palabra secreta.
    Given la palabra secreta es "auto"
    When arriesgo "A"
    Then estado es "a***"
    And me quedan 7 vidas
