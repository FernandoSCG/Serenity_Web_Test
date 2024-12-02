@CompraArticulo
Feature: Comprar articulo


  Background:
    Given el usuario esta en la pagina de inicio

  @Logeo
  Scenario Outline: Registrar,Logear Usuario y Comprar articulo
    And selecciona el boton de registro
    And ingresa nombre de usuario "<username>" y contraseña "<password>"
    And selecciona el boton de registrar
    Then se realiza el registro de manera exitosa
    Given el usuario esta en la pagina de inicio
    And selecciona el boton de logeo
    And ingresa nombre de usuario "<username>" y contraseña "<password>" en el login
    And selecciona el boton de logear
    Then se realiza el logeo de manera exitosa
    And selecciona producto con nombre "<nameProduct>"
    And agrega al carrito
    Examples:
      | username        | password | nameProduct      |
      | Jhonny Lawrence | 12345    | HTC One M9       |
      | Daniel Larusso  | 12345    | Nokia lumia 1520 |
      | Miguel Diaz     | 12345    | Dell i7 8gb      |

