/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

import java.util.ArrayList;

/**
 *
 * @author power
 */
public class ArticuloCarrito {

    Articulo elemento;
    int cantidad;

    public ArticuloCarrito() {};
	
	public ArticuloCarrito(Articulo articulo, int cantidad) {
        this.elemento = articulo;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return this.elemento + "x" + this.cantidad + "\n";
    }
    ArrayList<String> Opinion = new ArrayList<String>();

    private static int buscarPosicionArticuloPorCodigo(ArrayList<Articulo> c, String codigo) {
        int talla_catalogo = c.size();
        int i = 0;
        boolean found = false;

        while (i < talla_catalogo && !(found)) {
            if (c.get(i).getCodigo().equals(codigo)) {
                found = true;
            } else {
                i++;
            }
        }
        if (found) {
            return i;
        } else {
            return -1;
        }

    }

}
