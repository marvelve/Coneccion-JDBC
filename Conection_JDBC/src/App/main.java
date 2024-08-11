/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 *
 * @author Maricela Velasco
 */

import Interivalle.DAO.OperacionesCRUD;
import conection_jdbc.Conexion_JDBC;
import Interivalle.Model.Cliente;

public class main {
    
    public static void main(String[] args) {
        OperacionesCRUD clienteDAO = new OperacionesCRUD();

        // Crear e insertar un nuevo cliente
        Cliente nuevoCliente = new Cliente(1, "Juan Perez", "555-1234", "juan.perez@example.com", "Proyecto A");
        clienteDAO.insertarCliente(nuevoCliente);

        // Consultar un cliente por su ID
        Cliente clienteConsultado = clienteDAO.obtenerCliente(1);
        if (clienteConsultado != null) {
            System.out.println(clienteConsultado);
        }
    }
}
 
