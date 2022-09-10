# Author: Jesús David Zaraza Toro

Feature: Buscar un empleado
  Como un usuario que visita un sitio de datos dummy
  requiero buscar por id un empleado registrado
  para poder visualizar correctamente la informacion del empleado

  @test-01
  Scenario: Consultar exitosamente los datos de un empleado por el id
    Given que el usuario está en la pagina de empleados
    When consulta el registro de un empleado por id
    Then deberá ver los datos del empleado exitosamente