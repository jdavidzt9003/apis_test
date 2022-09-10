# Author: Jesús David Zaraza Toro

Feature: Registrar un empleado
  Como un usuario que visita un sitio de datos dummy
  requiero crear un empleado
  para poder visualizar correctamente la informacion en las consultas

  @test-01
  Scenario: Registrar exitosamente un empleado
    Given que el usuario está en la pagina de empleados
    When registra a un empleado
    Then la creación será exitosa