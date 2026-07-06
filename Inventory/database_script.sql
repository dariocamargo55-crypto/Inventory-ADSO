-- ============================================================
-- SCRIPT SQL - Sistema Inventory
-- SENA - Ficha 3186706 - GA7-220501096-AA2-EV01
-- Autores: Angela Carvajal Ortiz y Dario Bustamante Camargo 
-- ============================================================
-- INSTRUCCIONES:
-- 1. Abre MySQL Workbench
-- 2. Copia y pega todo este script
-- 3. Ejecutalo con el boton del rayo (lightning bolt)
-- ============================================================

-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS inventory_db
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

-- Seleccionar la base de datos
USE inventory_db;

-- Crear tabla de productos
CREATE TABLE IF NOT EXISTS productos (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    nombre      VARCHAR(100)  NOT NULL,
    descripcion VARCHAR(255),
    precio      DOUBLE        NOT NULL,
    stock       INT           NOT NULL DEFAULT 0,
    created_at  TIMESTAMP     DEFAULT CURRENT_TIMESTAMP
);

-- Insertar datos de prueba para verificar que funciona
INSERT INTO productos (nombre, descripcion, precio, stock) VALUES
('Cuaderno universitario', 'Cuaderno 100 hojas rayado', 4500.00, 50),
('Lapicero azul',          'Lapicero punta fina azul', 1200.00, 100),
('Resma papel carta',      'Resma 500 hojas blancas',  18000.00, 30),
('Carpeta plastica',       'Carpeta con ganchos',       3500.00, 40),
('Corrector liquido',      'Corrector 20ml blanco',     2800.00, 25);

-- Verificar que los datos se insertaron correctamente
SELECT * FROM productos;
