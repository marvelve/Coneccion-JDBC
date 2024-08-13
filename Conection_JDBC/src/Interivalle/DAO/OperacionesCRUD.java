/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interivalle.DAO;
/**
 *
 * @author Maricela Velasco
 */
import java.sql.*;
import Interivalle.Model.Cliente;
import conection_jdbc.Conexion_JDBC;

public class OperacionesCRUD {

    //Metodo para insertar los datos de Clientes a la Base de datos por Medio de Insert REGRISTRO
    public void insertarCliente(Cliente cliente) {
        String query = "INSERT INTO cliente (Id_Usuario, Nombre_Cliente, Telefono_Cliente, Email_Cliente, Proyecto_Cotizar) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexion = Conexion_JDBC.getConnection();
            PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setInt(1, cliente.getIdUsuario());
            stmt.setString(2, cliente.getNombreCliente());
            stmt.setString(3, cliente.getTelefonoCliente());
            stmt.setString(4, cliente.getEmailCliente());
            stmt.setString(5, cliente.getProyectoCotizar());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Metodo para visualizar todo lo que esta en la tabla cliente CONSULTA
    public void obtenerTodosLosClientes() {
        String sql = "SELECT * FROM cliente";

        try (Connection conexion = Conexion_JDBC.getConnection();
             PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rst = stmt.executeQuery()) 
        {
            rst.next();
            do {
              System.out.println(rst.getInt("Id_Usuario")+" | " +rst.getString("Nombre_Cliente")+" | " +rst.getString("Telefono_Cliente")+" | " +rst.getString("Email_Cliente")+" | " +rst.getString("Proyecto_Cotizar"));
            }while (rst.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Método para actualizar un cliente busqueda por Email
    public void actualizarCliente(String Email_Cliente, String N_nombreCliente, String N_telefonoCliente, String N_proyectoCotizar) {
        String sql = "UPDATE cliente SET Nombre_Cliente = ?, Telefono_Cliente = ?, Proyecto_Cotizar = ? WHERE Email_Cliente = ?";

        try (Connection conexion = Conexion_JDBC.getConnection(); 
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
             
            stmt.setString(1, N_nombreCliente);
            stmt.setString(2, N_telefonoCliente);
            stmt.setString(3, N_proyectoCotizar);
            stmt.setString(4, Email_Cliente);

            int FilasActualizadas = stmt.executeUpdate();
            if (FilasActualizadas > 0) {
                System.out.println("Cliente actualizado exitosamente.");
            } else {
                System.out.println("Cliente no encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Metodo para eliminar un Cliente por email
    public void borrarCliente(String Email_Cliente) {
        String query = "DELETE FROM cliente WHERE Email_Cliente = ?";
        try (Connection conexion = Conexion_JDBC.getConnection();
             PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setString(1, Email_Cliente);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
