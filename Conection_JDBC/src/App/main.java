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
import Interivalle.Model.Cliente;

public class main {
    
    public static void main(String[] args) {
        OperacionesCRUD clienteDAO = new OperacionesCRUD();

        // Crear e insertar un nuevo cliente
        Cliente nuevoCliente = new Cliente(1111111, "Juan Perez", "5551234312", "juan.perez@example.com", "Proyecto A");
        clienteDAO.insertarCliente(nuevoCliente);

       
    }
}
 
