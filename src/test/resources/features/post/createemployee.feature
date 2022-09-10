# Author: Jesús David Zaraza Toro

Feature: Registrar un empleado
  Como un usuario que visita un sitio de datos dummy
  requiero crear un empleado
  para poder visualizar correctamente la informacion en las consultas

  @test-02
  Scenario: Registrar exitosamente un empleado
    Given se quiere registrar un empleado
    When se envia la información del empleado
    Then se deberá registrar exitosamente