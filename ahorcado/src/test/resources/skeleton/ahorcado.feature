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

  Scenario: Arriesgar una letra que no esta contenida en la palabra secreta.
    Given la palabra secreta es "auto"
    When arriesgo "x"
    Then estado es "****"
    And me quedan 6 vidas

  Scenario: Arriesgo todas las letras contenidas en la palabra.
    Given la palabra secreta es "auto"
    When arriesgo "a"
    Then estado es "a***"
    When arriesgo "u"
    Then estado es "au**"
    When arriesgo "T"
    Then estado es "aut*"
    When arriesgo "O"
    And me quedan 7 vidas
