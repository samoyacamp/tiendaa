/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 * @author power
 */
public class Carrito {
    ArrayList<ArticuloCarrito> pedido;
	float total;
	boolean confirmado;
        
	public static boolean CONFIRMADO = true;
	public static boolean PENDIENTE = false;
	
	public Carrito() {
		pedido = new ArrayList<ArticuloCarrito>();
		total = 0;
		confirmado = PENDIENTE;
	}

	private float calculaTotal() {
		float acumulado = 0;
		for(ArticuloCarrito ac: this.pedido) {
			acumulado = acumulado + ac.elemento.getPrecio()*ac.cantidad;
		}
		return acumulado;
	}
	
	public void addArticulo(Articulo articulo, int cantidad) {
		boolean found = false;
		//Primero busco el articulo en el pedido. Si lo encuentra
		//TODO modificarlo por un bucle while, evitar recorrido completo
		for(ArticuloCarrito ac: pedido) {
			if (ac.elemento.equals(articulo)) {
				ac.cantidad +=cantidad;
				found = true;
			}
		}
		
		if (!found) {
			ArticuloCarrito nuevo = new ArticuloCarrito(articulo,cantidad);
			pedido.add(nuevo);
		}
			
		this.total = calculaTotal();
	}
	
	public String mostrarCarrito() {
		StringBuilder sb = new StringBuilder();
		sb.append("************ CARRITO **************\n");
		for(ArticuloCarrito ac: pedido) {
			sb.append(ac);
		}
		
		sb.append("Total: ").append(this.total);
		if (confirmado) 
			sb.append("\nEstado confirmado\n");
		else
			sb.append("\nEstado pendiente\n");
	
		sb.append("************ CARRITO FIN **********\n");
		return sb.toString();
	}

}
