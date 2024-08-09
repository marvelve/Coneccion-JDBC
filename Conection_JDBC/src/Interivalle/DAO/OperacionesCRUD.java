/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interivalle.DAO;

/**
 *
 * @author Maricela Velasco
 */

import Interivalle.Model.Cliente;
import conection_jdbc.Conexion_JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperacionesCRUD {

    public void insertarCliente(Cliente cliente) {
        String query = "INSERT INTO cliente (Id_Usuario, Nombre_Cliente, Telefono_Cliente, Email_Cliente, Proyecto_Cotizar) VALUES ('1234560', 'prueba1', '123456','prueba1@gmial.com','Rosales')";
        try (Connection conn = Conexion_JDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

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

    public Cliente obtenerCliente(int idUsuario) {
        String query = "SELECT * FROM cliente WHERE Id_Usuario = '12345'";
        Cliente cliente = null;
        try (Connection conn = Conexion_JDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente(
                    rs.getInt("Id_Usuario"),
                    rs.getString("Nombre_Cliente"),
                    rs.getString("Telefono_Cliente"),
                    rs.getString("Email_Cliente"),
                    rs.getString("Proyecto_Cotizar")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    public void actualizarCliente(Cliente cliente) {
        String query = "UPDATE cliente SET Nombre_Cliente = ?, Telefono_Cliente = ?, Email_Cliente = ?, Proyecto_Cotizar = ? WHERE Id_Usuario = ?";
        try (Connection conn = Conexion_JDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, cliente.getNombreCliente());
            stmt.setString(2, cliente.getTelefonoCliente());
            stmt.setString(3, cliente.getEmailCliente());
            stmt.setString(4, cliente.getProyectoCotizar());
            stmt.setInt(5, cliente.getIdUsuario());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrarCliente(int idUsuario) {
        String query = "DELETE FROM cliente WHERE Id_Usuario = ?";
        try (Connection conn = Conexion_JDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> obtenerTodosLosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM cliente";
        try (Connection conn = Conexion_JDBC.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getInt("Id_Usuario"),
                    rs.getString("Nombre_Cliente"),
                    rs.getString("Telefono_Cliente"),
                    rs.getString("Email_Cliente"),
                    rs.getString("Proyecto_Cotizar")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    
}
