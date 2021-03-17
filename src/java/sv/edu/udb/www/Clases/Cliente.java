/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.Clases;
import java.io.Serializable;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Drosselmeyer
 */
public class Cliente implements Serializable{
    //Atributos
    private int id;
    private String nombre;
    private int cantidad;
    private float precio;
    private float total;
    private int guardarCliente=0;

    //El constructor debe estar siempre vacio para los JavaBeans
    public Cliente() {
    }
    
    //Declaramos todos los setter y getter sin excepcion

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.cantidad = Cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float Precio) {
        this.precio = Precio;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float Total) {
        this.total = Total;
    }
    
    public int setGuardarCliente(){
        try {
            //Conectamos la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda?useSSL=false","root","123456");
            PreparedStatement statement= null;
            
            //Preparamos la query
            String query = "insert into cliente values(?,?,?,?,?)";
            statement=con.prepareStatement(query);
            
            //Enviamos cada uno de los valores a la base de datos
            statement.setInt(1,this.id);
            statement.setString(2,this.nombre);
            statement.setInt(3,this.cantidad);
            statement.setFloat(4, this.precio);
            statement.setFloat(5,this.total);
            
            //Cambiamos el valor a 1 para definir que fue correcto
            this.guardarCliente=statement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        
        return this.guardarCliente;
    }
}
