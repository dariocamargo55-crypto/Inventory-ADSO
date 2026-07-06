=========================================================
  SISTEMA INVENTORY - GA7-220501096-AA2-EV01
  SENA - Ficha 3186706 - 2026
  Autores: Angela Carvajal Ortiz y Dario Bustamante Camargo
=========================================================

DESCRIPCION DEL PROYECTO
--------------------------
Sistema de gestion de inventario para pequeñas y medianas empresas.
Aplicacion de consola en Java con conexion a MySQL mediante JDBC.
Permite realizar operaciones CRUD sobre productos del inventario.

TECNOLOGIAS UTILIZADAS
------------------------
- Lenguaje: Java 17
- Base de datos: MySQL 8
- Conexion BD: JDBC (mysql-connector-j 8.3.0)
- Gestion de dependencias: Maven (pom.xml)
- IDE recomendado: NetBeans
- Versionamiento: Git + GitHub

ESTRUCTURA DEL PROYECTO
------------------------
Inventory/
  pom.xml                          <- Dependencias Maven (incluye JDBC)
  database_script.sql              <- Script para crear la BD en MySQL
  README.txt                       <- Este archivo
  src/main/java/com/inventory/
      modelo/
          Producto.java            <- Clase modelo (datos del producto)
      dao/
          ConexionDB.java          <- Conexion a MySQL via JDBC
          ProductoDAO.java         <- Operaciones CRUD en la BD
      vista/
          Menu.java                <- Menu principal (clase con main)

PASOS PARA EJECUTAR
--------------------
1. CONFIGURAR MYSQL:
   - Abre MySQL Workbench
   - Ejecuta el archivo database_script.sql
   - Esto crea la base de datos y la tabla con datos de prueba

2. CONFIGURAR CONTRASENA:
   - Abre el archivo: src/main/java/com/inventory/dao/ConexionDB.java
   - Busca la linea: private static final String CONTRASENA = "root";
   - Cambia "root" por TU contrasena de MySQL

3. ABRIR EN NETBEANS:
   - File -> Open Project -> selecciona la carpeta Inventory
   - NetBeans detecta automaticamente que es proyecto Maven
   - Clic derecho en el proyecto -> Build (descarga el conector JDBC)

4. EJECUTAR:
   - Clic derecho en el proyecto -> Run
   - O presiona F6

FUNCIONALIDADES CRUD
---------------------
1. INSERTAR  -> Agregar un nuevo producto al inventario
2. CONSULTAR -> Ver todos los productos registrados
3. ACTUALIZAR -> Modificar datos de un producto existente
4. ELIMINAR  -> Borrar un producto del inventario

ENLACE AL REPOSITORIO GITHUB
------------------------------
Ver archivo: repositorio.txt
