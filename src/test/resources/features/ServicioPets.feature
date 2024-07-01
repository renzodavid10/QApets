Feature: Order Mascotas POST y GET

  @OrderPost
  Scenario Outline: creacion de Order: POST
    Given que estoy en el servicio de PETS
    When hare un post para crear el order con los datos de id:"<id>",petId:"<petId>", quantity:"<quantity>",shipDate:"<shipDate>",status:"<status>",complete:"<complete>"
    Then valido que el codigo de respuesta sea 200
    And valido el body de respuesta con respecto al id "<id>"
    And valido el body de respuesta con respecto al petId "<petId>"
    And valido el body de respuesta con respecto al quantity "<quantity>"
    And valido el body de respuesta con respecto al status "<status>"
    And valido el body de respuesta con respecto al complete "<complete>"
    Examples:
      | id | petId | quantity | shipDate                 | status | complete |
      | 5  | 10    | 100      | 2024-06-30T23:33:42.485Z | placed | true     |
      | 6  | 12    | 105      | 2024-06-30T23:33:42.485Z | placed | true     |

  @OrderGet
  Scenario Outline: creacion del Order: GET
    Given que estoy en el servicio de PETS
    When consulto el order de un pet con id "<id>"
    Then valido que el codigo de respuesta sea 200
    And verifico el body de respuesta
    Examples:
      | id |
      | 5  |
      | 6  |

