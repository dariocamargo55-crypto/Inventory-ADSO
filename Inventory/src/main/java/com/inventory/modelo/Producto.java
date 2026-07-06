package com.inventory.modelo;

/**
 * Clase modelo que representa un Producto del inventario.
 * Corresponde a la tabla "productos" en la base de datos MySQL.
 *
 * @author Angela Carvajal Ortiz y Dario Bustamante Camargo 
 * @version 1.0
 * @since 2026
 * Ficha: 3186706 - SENA GA7-220501096-AA2-EV01
 */
public class Producto {

    // Atributos (corresponden a las columnas de la tabla productos)
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;

    /**
     * Constructor vacio requerido para instanciacion generica.
     */
    public Producto() {
    }

    /**
     * Constructor con todos los atributos del producto.
     *
     * @param id          Identificador unico del producto
     * @param nombre      Nombre del producto
     * @param descripcion Descripcion del producto
     * @param precio      Precio unitario del producto
     * @param stock       Cantidad disponible en inventario
     */
    public Producto(int id, String nombre, String descripcion, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    // ==================== GETTERS Y SETTERS ====================

    /**
     * Obtiene el ID del producto.
     * @return id del producto
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del producto.
     * @param id nuevo ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     * @return nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripcion del producto.
     * @return descripcion del producto
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripcion del producto.
     * @param descripcion nueva descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el precio del producto.
     * @return precio unitario
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     * @param precio nuevo precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el stock actual del producto.
     * @return cantidad en inventario
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece el stock del producto.
     * @param stock nueva cantidad
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Representacion en texto del producto para mostrar en consola.
     * @return cadena formateada con los datos del producto
     */
    @Override
    public String toString() {
        return String.format("| ID: %-4d | %-20s | %-25s | Precio: $%-8.2f | Stock: %-5d |",
                id, nombre, descripcion, precio, stock);
    }
}
