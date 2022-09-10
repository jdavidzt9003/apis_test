# Author: Jesús David Zaraza Toro

Feature: Buscar un empleado
  Como automatizador de pruebas apis
  requiero automatizar la busqueda de un empleado registrado
  para poder consultar correctamente la informacion del empleado

  @test-01
  Scenario: Consultar exitosamente los datos de un empleado por el id
    Given que cargo la información del empleado
    When llamo la api de consulta
    Then debería ver los datos del empleado exitosamente