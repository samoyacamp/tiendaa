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
public class Prueba {
    
    private String descripcion;
    private String etiqueta;
    private int contador;

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public int getContador() {
        return contador;
    }

    public Prueba(String descripcion, String etiqueta, int contador) {
        this.descripcion = descripcion;
        this.etiqueta = etiqueta;
        this.contador = contador;
    }


}
