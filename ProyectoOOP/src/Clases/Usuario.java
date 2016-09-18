/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Josua
 */
public abstract class Usuario {

private String nombre;
private int cedula;
private String correo;
private String contraseña;
private String fechaRegistro;

    public Usuario(String nombre, int cedula, String correo, String contraseña, String fechaRegistro) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.contraseña = contraseña;
        this.fechaRegistro = fechaRegistro;
    }

    
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int numero) {
        this.cedula = numero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String texto) {
        this.correo = texto;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String password) {
        this.contraseña = password;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fecha) {
        this.fechaRegistro = fecha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", cedula=" + cedula + ", correo=" + correo + ", contrase\u00f1a=" + contraseña + ", fechaRegistro=" + fechaRegistro + '}';
    }

    

    
}
