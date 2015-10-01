Feature: Juego Piedra Papel Tijera

  Scenario: Piedra vs Papel
    Given jugadorUno juega PIEDRA
    When jugadorDos juega PAPEL
    Then gana jugadorDos

  Scenario: Piedra vs Piedra
    Given jugadorUno juega PIEDRA
    When jugadorDos juega PIEDRA
    Then hay empate

  Scenario: Piedra vs Tijera
    Given jugadorUno juega PIEDRA
    When jugadorDos juega TIJERA
    Then gana jugadorUno

  Scenario: Papel vs Piedra
    Given jugadorUno juega PAPEL
    When jugadorDos juega PIEDRA
    Then gana jugadorUno

  Scenario: Papel vs Papel
    Given jugadorUno juega PAPEL
    When jugadorDos juega PAPEL
    Then hay empate

  Scenario: Tijera vs Tijera
    Given jugadorUno juega TIJERA
    When jugadorDos juega TIJERA
    Then hay empate

  Scenario: Tijera vs Papel
    Given jugadorUno juega TIJERA
    When jugadorDos juega PAPEL
    Then gana jugadorUno


  Scenario: Papel vs Tijera
    Given jugadorUno juega PAPEL
    When jugadorDos juega TIJERA
    Then gana jugadorDos

  Scenario: Tijera vs Piedra
    Given jugadorUno juega TIJERA
    When jugadorDos juega PIEDRA
    Then gana jugadorDos