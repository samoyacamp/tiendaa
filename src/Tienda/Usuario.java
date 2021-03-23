/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

/**
 *
 * @author power
 */
public class Usuario {

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private String password;
    private String email;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{nombre=").append(nombre);
        sb.append(", email=").append(email);
        sb.append('}');
        return sb.toString();
    }

    public Usuario() {
    }

    public Usuario(String nombre, String password, String email) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        this.password = password;
    }

    public static boolean password(String pwd) {
        //(['65'-'90'])
        //pwd = "RamonRamirez";
        //        boolean ok=true;
        //        
        //        if (pwd.length() >= 8 && pwd.matches("([A-Z])") == false) 
        //            ok=false;

        return pwd.length() >= 8 && pwd.matches("[^A-Z]");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = email;
    }

    public boolean email(String correo) {
        //** ESTO ES PARA EL RETURN TRUE DEL PASSWORD
        //** return pwd.length() >= 8 && pwd.matches("([A-Z])");
        /**  ^ **/
        /**  |  **/
        if (correo.endsWith("(gmail.com)")) {
            System.out.println("El gmail esta correcto.");
        } else {
            System.out.println("El gmail esta incorrecto, le añadimos, gmail.com ");
            correo.concat("gmail.com");
        }
        return correo.contains("[.*@.*]");
    }

    public boolean nombre(String nombre) {

        return nombre.length() >= 6;

    }
    

}
