package conection_jdbc;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Maricela Velasco
 */


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion_JDBC {

    private static String user="root";
    private static String password="";
    private static String url="jdbc:mysql://localhost:3306/mydb";    
   
     public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos");
            e.printStackTrace(); // Imprime el error detallado
        }
        return connection;
    } 
}
