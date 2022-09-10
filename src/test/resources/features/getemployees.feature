# Author: Jesús David Zaraza Toro

Feature: Buscar empleados
  Como un usuario que visita un sitio de datos dummy
  requiero buscar los empleados registrados
  para poder visualizar correctamente la informacion de dichos empleados

  @test-01
  Scenario: Consultar todos los empleados registrados
    Given el usuario está en la pagina de empleados
    When el usuario quiere consultar el registro de todos los empleados
    Then deberá ver los datos de los empleados registrados