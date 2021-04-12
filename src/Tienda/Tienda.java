/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author power
 */
public class Tienda {

    public static void main(String[] args) throws IOException {
        Scanner numeros = new Scanner(System.in);
        Scanner cadenas = new Scanner(System.in);
        Usuario user = new Usuario();
        

        int opcion = -1;

        ArrayList<Articulo> catalogo = new ArrayList<Articulo>();
        inicializaCatalogo(catalogo);

        Carrito cesta = new Carrito();

        
        do {
            System.out.println("Elige una opcion: ");
            System.out.println("1. Alta Articulo");
            System.out.println("2. Comprar");
            System.out.println("3. Confirmar compra");
            System.out.println("4. Crear Usuario");
            System.out.println("0. Salir");
            opcion = numeros.nextInt();

            switch (opcion) {
                case 1:
                    addArticuloCatalogo(catalogo, cadenas, numeros);
                    mostrarCatalogo(catalogo);
                    break;
                case 2:
                    comprar(catalogo, cesta, cadenas, numeros);
                    break;
                case 3:
                    break;
                case 4:
                    crearUsuario(user, cadenas);
                case 5:darOpinion(user, catalogo, cadenas,numeros);
                    break;
                case 6: loadArticulosFromFile();
                    break;
                case 7: saveArticulosToFile();
                    break;
                case 0:
                    System.out.println("Muchas gracias por su compra.");
                    break;
                default:
                    System.out.println("Opcion incorrecta, lea atentamente.");
                    break;
            }
        } while (opcion != 0);

    }

    private static void inicializaCatalogo(ArrayList<Articulo> c) {
//        c.add(new Articulo("0001", "Monitor", 200.00F, 10));
//        c.add(new Articulo("0002", "Teclado", 10.00F, 100));
//        c.add(new Articulo("0003", "RJ45 2M", 4.50F, 50));
//        c.add(new Articulo("0004", "Raton", 20.00F, 15));


    }

    private static void addArticuloCatalogo(ArrayList<Articulo> c, Scanner sc, Scanner sn) {
        System.out.println("Introduce el codigo del nuevo articulo:");
        String codigo = sc.nextLine();
        System.out.println("Introduce el nombre del nuevo articulo:");
        String nombre = sc.nextLine();
        System.out.println("Introduce el precio del nuevo articulo:");
        float precio = sn.nextFloat();
        System.out.println("Introduce el stock del nuevo articulo:");
        int stock = sn.nextInt();
//        c.add(new Articulo(codigo, nombre, precio, stock));
    }

    private static void mostrarCatalogo(ArrayList<Articulo> c) {
        for (Articulo a : c) {
            System.out.println(a);
        }
    }

    private static Articulo buscarArticuloPorCodigo(ArrayList<Articulo> c, String codigo) {
        int talla_catalogo = c.size();
        int i = 0;
        Articulo a = null;
        boolean found = false;

        while (i < talla_catalogo && !(found)) {
            if (c.get(i).getCodigo().equals(codigo)) {
                a = c.get(i);
                found = true;
            } else {
                i++;
            }
        }

        return a;

    }

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

    private static void comprar(ArrayList<Articulo> c, Carrito carro, Scanner sc, Scanner sn) {
        int salircomprar = -1;
        do {
            //Mostramos catalogo
            mostrarCatalogo(c);
            System.out.println("Elige un articulo e introduce su codigo: ");
            String codigo = sc.nextLine();
            Articulo a = buscarArticuloPorCodigo(c, codigo);
            if (a != null) {
                System.out.println("Indica la cantidad que quieres: ");
                int cantidad = sn.nextInt();
                //Si no tengo suficiente hare lo mismo que si no hubiera encontrado el articulo
                if (a.disponible(cantidad)) {
                    carro.addArticulo(a, cantidad);
                } else {
                    System.out.println("Articulo no disponible, elija otro o revise la cantidad elegida.");
                }
            } else {
                System.out.println("Articulo no disponible, elija otro o revise la cantidad elegida.");
            }

            System.out.println(carro.mostrarCarrito());

            System.out.println("Pulsa 0 si quieres salir de comprar e ir a confirmar. "
                    + "Cualquier otra tecla para seguir comprando.");
            salircomprar = sn.nextInt();

        } while (salircomprar != 0);

        //Pedimos articulo por codigo, lo buscamos
        //    si existe Pedimos cantidad
        //	  	si hay disponibilidad
        //			Añadimos al carrito
        //mostrar carrito 
        //repetir mientras 
    }

    private static void modificarStockCatalogo(ArrayList<Articulo> c, Carrito carro) {
        int pos;
        for (ArticuloCarrito ac : carro.pedido) {
            pos = buscarPosicionArticuloPorCodigo(c, ac.elemento.getCodigo());
            if (pos > -1) {
                c.get(pos).controlStock(-1 * ac.cantidad);
            }
        }
    }

    private static void confirmarCarrito(ArrayList<Articulo> c, Carrito carro, Scanner sn) {
        //Mostramos carrito articulos+cantidades+ el total y estado
        System.out.println(carro.mostrarCarrito());
        System.out.println("Pulsa 1 si quieres confirmar la compra del carrito. Cualquier otra tecla para seguir comprando.");
        int confirmar = sn.nextInt();
        if (confirmar == 1) {
            modificarStockCatalogo(c, carro);
            carro.confirmado = Carrito.CONFIRMADO;
            System.out.println(carro.mostrarCarrito());
            mostrarCatalogo(c);
            System.out.println("Gracias por su compra. Puede continuar comprando.");
            carro = new Carrito();
        } else {
            System.out.println("Puede continuar comprando.");
        }
        //Preguntamos confirmacion
        // Si se confirma
        // 		Modificar en el catalogo el stock de los articulos del carrito, restando
        // 		las cantidades al stock
        //		Cambiar estado carrito a confirmado
        //		Mostramos carrito articulos+cantidades+ el total y estado
        //		Mostramos catalogo con el nuevo stock
        //		Mostramos mensaje de despedida y salimos del programa
        //Si no se confirma: Mostramos mensaje de que puede seguir comprando
    }

    private static void crearUsuario(Usuario us, Scanner sn) {
        String nombre, email, pwd;
        do {
            System.out.println("Dame un nombre de usuario machine");
            nombre = sn.nextLine();
        } while (!us.nombre(nombre));
        us.setNombre(nombre);
        /** 
         *Este hacerlo con el email
         */
        do {
            System.out.println("Dame un email gañan");
            email = sn.nextLine();
        } while (!us.nombre(nombre));
        us.setNombre(nombre);
        /**
         * Este hacerlo con el password 
         **/
        do {
            System.out.println("Dame tu contraseña marcial");
            nombre = sn.nextLine();
        } while (!us.nombre(nombre));
        us.setNombre(nombre);
    }
    

    public static void darOpinion(Usuario user, ArrayList<Articulo> catalogo, Scanner cadenas, Scanner numeros) {
       File fichero = null;
       FileReader lector = null;
       BufferedReader buffer = null;
       String[] nuevaRopa; 
       try {
           fichero = new File("articulo.txt");
           lector = new FileReader(fichero);
           buffer= new BufferedReader(lector);
           String linea = null;
           while ((linea = buffer.readLine()) !=null)
           {
               nuevaRopa = linea.split(",");
               //TO DO cada linea creado un objeto ropa en cada articulo
               //nuevaRopa[]
               System.out.print(linea);
               //Utilizar un Split para separar con comas la linea que sale por pantalla//
           }
           }
       catch(FileNotFoundException fnfe){
           fnfe.printStackTrace();
       }
       catch(IOException ioe){
           ioe.printStackTrace();
       }finally{
           if(buffer!=null)
               try{
               buffer.close();
               }catch (IOException ioe){
                   ioe.printStackTrace();
               }
       }
    }
   

    public static void loadArticulosFromFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void saveArticulosToFile() throws IOException {
        FileWriter fichero = null;
        PrintWriter escritor = null;
        
        try{
            fichero=new FileWriter("articulo.txt");
            escritor=new PrintWriter(fichero);
            escritor.println("Esto es una linea del fichero");
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }finally{
            if (fichero != null)
                try{
                    fichero.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
        }
            
        }
    }


