# Author: Jesús David Zaraza Toro

Feature: eliminar un empleado
  Como un usuario que visita un sitio de datos dummy
  necesito eliminar un empleado registrado
  para no ver más el registro en la consulta

  @test-01
  Scenario: eliminar exitosamente un empleado registrado
    Given que el usuario está en la pagina de empleados
    When elimina el registro de un empleado por id
    Then la eliminación será exitosa