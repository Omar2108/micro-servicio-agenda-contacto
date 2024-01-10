# micro-servicio-agenda-contacto
 Micro servicio para la administracion de una agenda de contactos, donde se podra agregar contactos, listar tus contacto, actualizar todas su informacion y eliminar, la cual se almacenara en una base de datos MySQL. Conectado a jenkins para que ejecute los test cada vez que se realice un push a la rama main
 
 Desarrollada con Spring boot version 2.7.3, se utilizo como dependencias Spring web, spring boot devtools, spring-boot-starter-data-jpa, mysql-connector-java, y lombok, como manejador de base de datos MySQL version 8.0.30.
 
 Documnetacion o Swagger de la API, la podra ver en la direccion http://localhost:8080/swagger-ui.html

 ## Instalacion

### Forma 1:
-Dar clic en code y luego en donwload zip, para descargarlo desde el repositorio.
-Luego lo puede abrir en el IDE que este utilizando, importando el proyecto o desde un editor de codigo de su preferencia.

 ### Forma 2:
 -Crear una carpeta, ingresar a git bash y ejecutar la siguiente linea de comando:
    
           git clone https://github.com/Omar2108/micro-servicio-agenda-contacto.git
            
 -Luego lo puede abrir en el IDE que este utilizando, importando el proyecto o desde un editor de codigo de su preferencia.
      

### Levantamiento de la aplicacion 
#### En Desarrollo
     En su IDE dar click en run para comenzar a correr el programa
     Correr los test: mvn test
#### Con Docker
     - A traves de linea de comando, utilice el siguiente: docker-compose up
     - A traves de linea de comando para detener, utilice el siguiente: tecla control + c 
     - A traves de linea de comando para eliminar los contenedores, utilice el siguiente: docker-compose down
#### En Produccion 
    - A traves de linea de comando, utilice el siguiente: mvn spring-boot:run
    - Dando doble click en el archivo .jar

## Descarga y registro de cambios:
Siempre se recomienda descargar desde GitHub la última versión.
###  Usando la línea de comando:
####  via Git:
    git clone https://github.com/Omar2108/micro-servicio-agenda-contacto.git

## Compatibilidad
- Sistema operativo Windows 10

## Contribución
1. Crea un Fork del repositorio.
2. Clonar en tu maquina mediante git clone https://github.com/Omar2108/micro-servicio-agenda-contacto.git
3. Crear una nueva rama.
4. Realiza tus cambios.
5. Manda tu pull request.

## Licencia
   [![licencia](https://img.shields.io/apm/l/modo?style=for-the-badge "licencia")](hthttps://img.shields.io/apm/l/modo?style=for-the-badgetp:// "licencia")


