# Author: Jesús David Zaraza Toro

Feature: eliminar un empleado
  Como automatizador de pruebas
  necesito eliminar un empleado registrado
  para no ver más el registro en la consulta

  @test-01
  Scenario: eliminar exitosamente un empleado registrado
    Given que se requiere eliminar un empleado registrado
    When elimina el registro de un empleado por id
    Then la eliminación será exitosa