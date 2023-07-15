# Transport-Catalog-API


### About :
  #### This API is designed to implement functionality for performing tasks related to the transport company.

 
  
  #### This API has functions:

      Vehicle:
        Returns all Vehicles 
        Returns One Vehicle by id 
        Adds new Vehicle
        Updates Vehicle in db
        Returns a filtered list of Vehicles by filters
    
      Category:
        Returns all Categories
        Returns One Category by id 
    
      Type:
        Returns all Types
        Returns One Type by id

# How to start:
      1. Clone repository, and open it in IDE
      2. Create database by this file (PostgreSql syntax): 
            https://github.com/4ubov/transport-catalog-api/blob/main/src/main/resources/transport_catalog_db.sql
      3. Fill application.properties fields by your own dataSource
      4. Run project in IDE
      5. Go to the browser and go to the address: http://localhost:yourPort/ 
            Example link: http://localhost:8080/
            On this address will contain the builded version of the frontend client.
            path: resources/templates/index.html
      

# REST API

## Vehicle-Controller
### Request description: Return all Vehicles from db.

<details>

  <summary>⚪ GET /api/vehicle/</summary>
  
#### Request
  
    Request body: No parameters
      
      
#### Response

  ###### Status code: `200`
    Description: Successfully found!
    Media type: application/json
    Json return: List<VehicleDTO>
    Example value:
      [
        {
          "vehicleId": 53,
          "brand": "Mercedes",
          "model": "E250",
          "category": "A",
          "stateNumber": "F553RH58",
          "type": "Хэтчбек",
          "yearOfRealise": 2007,
          "hasTrailer": false
        },
        {
          "vehicleId": 54,
          "brand": "Mercedes",
          "model": "GLS3",
          "category": "A",
          "stateNumber": "R282AA58",
          "type": "Седан",
          "yearOfRealise": 2017,
          "hasTrailer": false
        }
      ]
  

</details>

</br>

### Request description: Return one Vehicle from db by ID.

<details>

<summary>⚪ POST /api/vehicle/get-one</summary>

#### Request

    Request body: application/json
    Example value:
      {
        "vehicleId" : "56"
      }
      
#### Response

  ###### Status code: `200`
    Description: Vehicle successfully found!
    Media type: application/json
    Json return: VehicleDTO
    Example value:
      {
        "vehicleId": 56,
        "brand": "BMW",
        "model": "E3",
        "category": "A",
        "stateNumber": "A111AA58",
        "type": "Хэтчбек",
        "yearOfRealise": 2011,
        "hasTrailer": false
    }
       
       
  ###### Status code: `404`
    Description: Bad ID format! ("vehicleId" : "56DFE") only Long value
    Media type: application/json
    Example value:
      {
        "statusCode": 404,
        "message": "Entered vehicleId is incorrect type, it need be a number",
        "timestamp": 1679587416465
      }


  ###### Status code: `404`
    Description: Entity not found! If entered vehicleId dont exist in db.
    Media type: application/json
    Example value:
      {
        "statusCode": 404,
        "message": "Vehicle Entity with entered id not found!",
        "timestamp": 1679587416465
      }
        
</details>


</br>

### Request description: Add new Vehicle.

<details>

<summary>⚪ POST /api/vehicle/add</summary>

#### Request

    Request body: application/json
    Json contain: VehicleDTO
    Example value:
      {
        "brand": "Audi",
        "model": "R8",
        "category": "A",
        "stateNumber": "F287FR777",
        "type": "Седан",
        "yearOfRealise": 2012,
        "hasTrailer": false
    }
      
#### Response

  ###### Status code: `200`
    Description: Vehicle successfully added!           
    Media type: application/json
    Example value:
      {
        "CREATED"
      }
       
       
  ###### Status code: `400`
    Description: Exceptions that will throws in case bad Validation @Valid!
    Media type: application/json
    Example value:
      {
        "statusCode": 400,
        "message": "brand - Поле brand не должно быть пустым!; 
            Поле model не должно быть пустым! Example: M3;
            VehicleType Entity with entered name not found!; 
            VehicleCategory Entity with entered name not found!" ,
        "timestamp": 1689438720293
      }


  ###### Status code: `400`
    Description: State Number is unique field, your request contain same number!
    Media type: application/json
    Example value:
      {
        "statusCode": 400,
        "message": "stateNumber - Транспорт с таким гос. номером уже есть в БД!; ",
        "timestamp": 1689438543459
      }
        
</details>

</br>


### Request description: Add new Vehicle.

<details>

<summary>⚪ PUT /api/vehicle/add</summary>

#### Request

    Request body: application/json
    Example value:
    Json contain: VehicleDTO
      {
        "vehicleId": "5",
        "brand": "Audi",
        "model": "RX7",
        "category": "A",
        "stateNumber": "F237FR777",
        "type": "Кроссовер",
        "yearOfRealise": 2014,
        "hasTrailer": false
    }
      
#### Response

  ###### Status code: `200`
    Description: Vehicle successfully updated!          
    Media type: application/json
    Example value:
      {
        "CREATED"
      }
       
       
  ###### Status code: `400`
    Description: Exceptions that will throws in case bad Validation @Valid!
    Media type: application/json
    Example value:
      {
        "statusCode": 400,
        "message": "brand - Поле brand не должно быть пустым!; 
            Поле model не должно быть пустым! Example: M3;
            VehicleType Entity with entered name not found!; 
            VehicleCategory Entity with entered name not found!" ,
        "timestamp": 1689438720293
      }


  ###### Status code: `400`
    Description: State Number is unique field, your request contain same number!
    Media type: application/json
    Example value:
      {
        "statusCode": 400,
        "message": "stateNumber - Транспорт с таким гос. номером уже есть в БД!; ",
        "timestamp": 1689438543459
      }
        
</details>

</br>

### Request description: Filter Vehicles by imputed filters.

<details>

<summary>⚪ POST /api/vehicle/filter</summary>

#### Request

    Request body: application/json
    Json contain: Map<String, String>
    Example value:
      {
        "brand": "Audi",
        "type": "Седан"
      }
      
#### Response

  ###### Status code: `200`
    Description: Vehicles successfully filtered!           
    Media type: application/json
    Json return: List<VehicleDTO>
    Example value:
      [
        {
          "vehicleId": 67,
          "brand": "Audi",
          "model": "R8",
          "category": "A",
          "stateNumber": "F287FR777",
          "type": "Седан",
          "yearOfRealise": 2012,
          "hasTrailer": false
      },
      {
        "vehicleId": 58,
        "brand": "Audi",
        "model": "Q7",
        "category": "A",
        "stateNumber": "G283GR777",
        "type": "Седан",
        "yearOfRealise": 2022,
        "hasTrailer": false
      }
    ]
       
       
  ###### Status code: `400`
    Description: Exceptions that will throws if sended category or type dont exist in db!
                    Because VehicleCategory and VehicleType data in db added manually.
    Media type: application/json
    Example value:
      {
        "statusCode": 400,
        "message": 
            VehicleType Entity with entered name not found!; 
            VehicleCategory Entity with entered name not found!" ,
        "timestamp": 1689438720293
      }

        
</details>

</br>

## Type-Controller
### Request description: Return all VehicleType from db.

<details>

  <summary>⚪ GET /api/type/</summary>
  
#### Request
  
    Request body: No parameters
      
      
#### Response

  ###### Status code: `200`
    Description: Successfully found!
    Media type: application/json
    Json return: List<VehicleTypeDTO>
    Example value:
      [
        {
          "typeId": 1,
          "typeName": "Седан"
        },
        {
          "typeId": 2,
          "typeName": "Хэтчбек"
        },
        {
          "typeId": 3,
          "typeName": "Минивэн"
        }
      ]
  

</details>

</br>

### Request description: Return one VehicleType from db by ID.

<details>

<summary>⚪ POST /api/type/get-one</summary>

#### Request

    Request body: application/json
    Request contain: Long id
    Example value:
    
        2
      
      
#### Response

  ###### Status code: `200`
    Description: Vehicle Type successfully found!
    Media type: application/json
    Json return: VehicleTypeDTO
    Example value:
      {
        "typeId": 2,
        "typeName": "Хэтчбек"
      }
       
       
  ###### Status code: `400`
    Description: VehicleType not Found!
    Media type: application/json
    Example value:
      {
        "statusCode": 400,
        "message": "VehicleType Entity with entered ID not found!",
        "timestamp": 1679587416465
      }
        
</details>


</br>

## Category-Controller
### Request description: Return all VehicleCategory from db.

<details>

  <summary>⚪ GET /api/category/</summary>
  
#### Request
  
    Request body: No parameters
      
      
#### Response

  ###### Status code: `200`
    Description: Successfully found!
    Media type: application/json
    Json return: List<VehicleCategoryDTO>
    Example value:
      [
        {
          "categoryId": 1,
          "categoryName": "A"
        },
        {
          "categoryId": 2,
          "categoryName": "B"
        },
        {
          "categoryId": 3,
          "categoryName": "C"
        }
      ]
  

</details>

</br>

### Request description: Return one VehicleCategory from db by ID.

<details>

<summary>⚪ POST /api/category/get-one</summary>

#### Request

    Request body: application/json
    Request contain: Long id
    Example value:
    
        2
      
      
#### Response

  ###### Status code: `200`
    Description: Vehicle Type successfully found!
    Media type: application/json
    Json return: VehicleTypeDTO
    Example value:
      {
        "categoryId": 2,
        "categoryName": "B"
      }
       
       
  ###### Status code: `400`
    Description: VehicleType not Found!
    Media type: application/json
    Example value:
      {
        "statusCode": 400,
        "message": "VehicleCategory Entity with entered ID not found!",
        "timestamp": 1679587413465
      }
        
</details>


</br>

### Schemas:

#### `VehicleDTO`

<details>

<summary>⚪ vehicleId</summary>

        type: integer64

</details>

<details>

<summary>⚪ brand</summary>

        type: string

</details>

<details>

<summary>⚪ model</summary>

        type: string

</details>

<details>

<summary>⚪ category</summary>

        type: string

</details>

<details>

<summary>⚪ stateNumber</summary>

        type: string

</details>

<details>

<summary>⚪ type</summary>

        type: integer32

</details>

<details>

<summary>⚪ hasTrailer</summary>

        type: boolean

</details>



</br>

#### `VehicleTypeDTO`

<details>

<summary>⚪ typeId</summary>

        type: integer64

</details>


<details>

<summary>⚪ typeName</summary>

        type: string

</details>

</br>


#### `VehicleCategoryDTO`

<details>

<summary>⚪ categoryId</summary>

        type: integer64

</details>


<details>

<summary>⚪ categoryName</summary>

        type: string

</details>

</br>






### transport_catalog_db DataBase : <a href="https://github.com/4ubov/transport-catalog-api/blob/main/src/main/resources/transport_catalog_db.sql">Link to db file</a>
![image](https://github.com/4ubov/transport-catalog-api/assets/46792640/6e2931e5-feb3-4745-a891-7e3e21286d57)
![image](https://github.com/4ubov/transport-catalog-api/assets/46792640/38b83775-f618-43d9-9344-1178c5825526)


#### UI screenshots 

##### Starter page: "http://localhost:8080/"
![image](https://github.com/4ubov/transport-catalog-api/assets/46792640/10f66009-36e1-4970-814e-f0103d4f72ac)


##### Edit page
![image](https://github.com/4ubov/transport-catalog-api/assets/46792640/ca791fa6-f349-41c8-9a0d-49df88829289)

##### Add new Vehicle page
![image](https://github.com/4ubov/transport-catalog-api/assets/46792640/93a0fe87-3666-4ee1-abb2-d89cc8cfef32)

##### Drop-down menu view
![image](https://github.com/4ubov/transport-catalog-api/assets/46792640/1d3eafec-ea01-4b4d-99c6-d94db79a0db8)



</br>

### Client (Frontend) on React JS, that implements this REST-API - <a href="https://github.com/4ubov/transport-catalog-client">ReactJs-Client</a>
