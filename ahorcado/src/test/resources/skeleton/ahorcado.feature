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

  Scenario: Arriesgo tres letras que estan contenida en la palabra secreta.
    Given la palabra secreta es "auto"
    When arriesgo "a"
    And arriesgo "u"
    And arriesgo "t"
    Then estado es "aut*"
    And me quedan 7 vidas

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

  Scenario: Arriesgo una letra no acierto y quedo sin vidas.
    Given la palabra secreta es "auto"
    When arriesgo "l"
    Then estado es "****"
    When arriesgo "s"
    Then estado es "****"
    When arriesgo "z"
    Then estado es "****"
    When arriesgo "W"
    Then estado es "****"
    When arriesgo "P"
    Then estado es "****"
    When arriesgo "M"
    Then estado es "****"
    When arriesgo "I"
    And me quedan 0 vidas