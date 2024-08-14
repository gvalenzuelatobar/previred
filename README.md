# Desafio

Repositorio para obtener el proyecto
git@github.com:gvalenzuelatobar/previred.git

En el Archivo application.properties, se encuentra la configuracion de Swagger y la BD H2
En el Archivo schema.sql, se encuentra el script de la creacion de la BD
En el Archivo data se ingresa unos valores a la tabla usuario

url swagger , documentacion de los controladores
http://localhost:8080/swagger/swagger-ui/index.html

JDBC 
dbc:h2:mem:test

Credenciales 
username: sa
password: 

url BD H2
http://localhost:8080/h2-console

tablas ocupadas
select * from usuario;



Segun el menseaje, se analizo que a la tabla  de entrada se le asigna un los siguientes valores 

Pruebas con Postman

- Para el ingreso del mensaje
PostMapping
SI el ID NO existe en la BD, se crea en la BD
http://localhost:8080/usuario/todos

{
    "id": 20,
    "nombre": "nombre",
    "username": "username",
    "password": "password",
    "edad": 22,
    "fechaNacimiento":"2024-12-12"
}

SI el ID  existe en la BD, se actualizan los valor

{
    
    "id": 32,
    "nombre": "nombre",
    "username": "username",
    "password": "password",
    "edad": 22,
    "fechaNacimiento":"2024-12-12"
}
    


- Para obtener todos los valores BD
GetMapping
http://localhost:8080/usuario/todos

- Para buscar por ID
GetMapping
http://localhost:8080/usuario/buscar/{id}


- Para eliminar por ID
DeleteMapping
http://localhost:8080/usuario/eliminar/{id}




