# Author: Jesús David Zaraza Toro

Feature: Buscar empleados
  Como automatizador de pruebas
  requiero buscar todos empleados registrados
  para poder visualizar correctamente la informacion de dichos empleados

  @test-01
  Scenario: Consultar todos los empleados registrados
    Given que se carga la información de todos los empleados
    When se consulta el registro de todos los empleados
    Then deberá ver los datos de los empleados registrados