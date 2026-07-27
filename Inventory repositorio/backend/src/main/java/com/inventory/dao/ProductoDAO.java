package com.inventory.dao;

import com.inventory.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO (Data Access Object) para la entidad Producto.
 * Contiene los metodos CRUD: Insertar, Consultar, Actualizar y Eliminar.
 * Se conecta a MySQL mediante JDBC usando la clase ConexionDB.
 *
 * @author Angela Carvajal Ortiz y Dario Bustamante Camargo 
 * @version 1.0
 * @since 2026
 * Ficha: 3186706 - SENA GA7-220501096-AA2-EV01
 */
public class ProductoDAO {

    // = CREATE - INSERTAR =

    /**
     * Inserta un nuevo producto en la base de datos.
     * Operacion: CREATE del CRUD.
     *
     * @param producto objeto Producto con los datos a insertar
     * @return true si la insercion fue exitosa, false si hubo error
     */
    public boolean insertar(Producto producto) {
        String sql = "INSERT INTO productos (nombre, descripcion, precio, stock) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("  ERROR al insertar producto: " + e.getMessage());
            return false;
        }
    }

    // = READ - CONSULTAR TODOS =

    /**
     * Consulta todos los productos registrados en la base de datos.
     * Operacion: READ del CRUD.
     *
     * @return lista con todos los productos, o lista vacia si no hay registros
     */
    public List<Producto> consultarTodos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, descripcion, precio, stock FROM productos ORDER BY id";

        try (Connection con = ConexionDB.obtenerConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Producto p = new Producto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio"),
                    rs.getInt("stock")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("  ERROR al consultar productos: " + e.getMessage());
        }

        return lista;
    }

    // = READ - CONSULTAR POR ID =

    /**
     * Consulta un producto especifico por su ID.
     *
     * @param id identificador unico del producto
     * @return objeto Producto encontrado, o null si no existe
     */
    public Producto consultarPorId(int id) {
        String sql = "SELECT id, nombre, descripcion, precio, stock FROM productos WHERE id = ?";

        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Producto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio"),
                    rs.getInt("stock")
                );
            }

        } catch (SQLException e) {
            System.out.println("  ERROR al consultar producto por ID: " + e.getMessage());
        }

        return null;
    }

    // = UPDATE - ACTUALIZAR =

    /**
     * Actualiza los datos de un producto existente en la base de datos.
     * Operacion: UPDATE del CRUD.
     *
     * @param producto objeto Producto con el ID y los nuevos datos
     * @return true si la actualizacion fue exitosa, false si hubo error
     */
    public boolean actualizar(Producto producto) {
        String sql = "UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, stock = ? WHERE id = ?";

        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setInt(5, producto.getId());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("  ERROR al actualizar producto: " + e.getMessage());
            return false;
        }
    }

    // = DELETE - ELIMINAR =

    /**
     * Elimina un producto de la base de datos por su ID.
     * Operacion: DELETE del CRUD.
     *
     * @param id identificador unico del producto a eliminar
     * @return true si la eliminacion fue exitosa, false si hubo error
     */
    public boolean eliminar(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";

        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("  ERROR al eliminar producto: " + e.getMessage());
            return false;
        }
    }
}
