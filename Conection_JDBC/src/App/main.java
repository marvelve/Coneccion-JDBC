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
import Interivalle.Model.Servicio_ObraBlanca;

public class main {
    
    public static void main(String[] args) {
        OperacionesCRUD clienteDAO = new OperacionesCRUD();

        //insertar un nuevo cliente
        Cliente nuevoCliente = new Cliente(0,"Carlos Alberto Prueba", "3223456789", "carlosalbertoprueba@example.com", "Proyecto G");
       // clienteDAO.insertarCliente(nuevoCliente);

        //consulta todos los clientes
       clienteDAO.obtenerTodosLosClientes();
       System.out.println("Lista de todos los clientes:");
       
       //clienteDAO.actualizarCliente("pepito.perez@example.com", "Pepito pere", "315234567", "prueba");
      // clienteDAO.borrarCliente("marinapantojaxx@example.com");
     
      Servicio_ObraBlanca nuevaObraBlanca= new Servicio_ObraBlanca(0,45.5, 2, 3, 12.0, 8.0, 15.0, 12.0);
      clienteDAO.insertarServicioObraBlanca(nuevaObraBlanca);
    }
}
 
