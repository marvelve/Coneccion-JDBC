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
import Interivalle.Model.Servicio_ObraBlanca;
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
            System.out.println("Registro Borrado:");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Metodo para Ingresar los datos para el servicio Obra blanca
     public void insertarServicioObraBlanca(Servicio_ObraBlanca obra_blanca) {
        String query = "INSERT INTO obra_blanca (Id_Actividad, area_privada_apto, cantidad_panel, cantidad_poyo, medida_zona_oficio, medida_salpicadero_cocina,medida_cocina,medida_bano) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexion = Conexion_JDBC.getConnection();
            PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setInt (1, obra_blanca.getId_Actividad());
            stmt.setDouble(2, obra_blanca.getAreaPrivadaApto());
            stmt.setInt (3, obra_blanca.getCantidadPanel());
            stmt.setInt(4, obra_blanca.getCantidadPoyo());
            stmt.setDouble(5, obra_blanca.getMedidaZonaOficio());
            stmt.setDouble(6, obra_blanca.getMedidaSalpicaderoCocina());
            stmt.setDouble(7, obra_blanca.getMedidaCocina());
            stmt.setDouble(8, obra_blanca.getMedidaBanos());

            stmt.executeUpdate();
            System.out.println("Registro de ObraBlanca insertado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
      //Metodo para visualizar todo lo que esta en la tabla cliente CONSULTA
    public void obtenerServiosObraBlanca() {
        String sql = "SELECT * FROM obra_blanca";

        try (Connection conexion = Conexion_JDBC.getConnection();
             PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rst = stmt.executeQuery()) 
        {
            rst.next();
            do {
              System.out.println(rst.getInt("Id_Actividad")+" | " +rst.getDouble("area_privada_apto")+" | " +rst.getInt("cantidad_panel")+" | " +rst.getInt("cantidad_poyo")+" | " +rst.getDouble("medida_zona_oficio")+" | " +rst.getDouble("medida_salpicadero_cocina")+" | " +rst.getDouble("medida_cocina")+" | " +rst.getDouble("medida_bano"));
            }while (rst.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Método para actualizar un cliente busqueda por Email
    public void actualizarServiciosObraBlanca(int Id_Actividad, double N_areaPrivadaApto, int N_cantidadPanel, int N_cantidadPoyo,
                      double N_medidaZonaOficio, double N_medidaSalpicaderoCocina, double N_medidaCocina, double N_medidaBanos) {
        String sql = "UPDATE obra_blanca SET area_privada_apto = ?, cantidad_panel = ?, cantidad_poyo = ?, medida_zona_oficio = ?, medida_salpicadero_cocina = ?, medida_cocina = ?, medida_bano = ? WHERE Id_Actividad = ?";

        try (Connection conexion = Conexion_JDBC.getConnection(); 
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
             
            stmt.setDouble(1, N_areaPrivadaApto);
            stmt.setInt(2, N_cantidadPanel);
            stmt.setInt(3, N_cantidadPoyo);
            stmt.setDouble(4, N_medidaZonaOficio);
            stmt.setDouble(5, N_medidaSalpicaderoCocina);
            stmt.setDouble(6, N_medidaCocina);
            stmt.setDouble(7, N_medidaBanos);
            stmt.setInt(8, Id_Actividad);

            int FilasActualizadas = stmt.executeUpdate();
            if (FilasActualizadas > 0) {
                System.out.println("Servicio Obra Blanca actualizado exitosamente.");
            } else {
                System.out.println("Servicio Obra Blanca no encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Metodo para eliminar un Cliente por email
    public void borrarServicioObraBlanca(int Id_Actividad) {
        String query = "DELETE FROM obra_blanca WHERE Id_Actividad = ?";
        try (Connection conexion = Conexion_JDBC.getConnection();
             PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setInt(1, Id_Actividad);
            stmt.executeUpdate();
            System.out.println("Registro Borrado:");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
