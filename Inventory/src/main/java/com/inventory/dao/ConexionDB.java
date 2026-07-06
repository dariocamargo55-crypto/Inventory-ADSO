package com.inventory.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que gestiona la conexion a la base de datos MySQL mediante JDBC.
 * Centraliza los parametros de conexion para todo el proyecto.
 *
 * @author Angela Carvajal Ortiz y Dario Bustamante Camargo 
 * @version 1.0
 * @since 2026
 * Ficha: 3186706 - SENA GA7-220501096-AA2-EV01
 */
public class ConexionDB {

    // ==================== CONSTANTES DE CONEXION ====================
    // IMPORTANTE: Cambia CONTRASENA por tu contrasena real de MySQL

    /** URL de conexion JDBC a la base de datos inventory_db */
    private static final String URL = "jdbc:mysql://localhost:3306/inventory_db?useSSL=false&serverTimezone=UTC";

    /** Usuario de MySQL (por defecto: root) */
    private static final String USUARIO = "root";

    /** Contrasena de MySQL - CAMBIA ESTE VALOR */
    private static final String CONTRASENA = "root";

    /**
     * Obtiene una conexion activa a la base de datos MySQL.
     * Utiliza DriverManager de JDBC para establecer la conexion.
     *
     * @return objeto Connection listo para ejecutar consultas SQL
     * @throws SQLException si no se puede establecer la conexion
     */
    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
}
