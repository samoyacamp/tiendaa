package Tienda;

import java.util.ArrayList;

/**
 *
 * @author power
 */
public abstract class Articulo {

    private String codigo;
    private String nombre;
    private float precio;
    private int stock;
    private ArrayList<Opinion> opiniones;
    /**
     * @param codigoPromo
     */
    public abstract void applyPromo(String codigoPromo);
    public Articulo() {
        opiniones = new ArrayList<Opinion>();
    }

    public Articulo(String codigo, String nombre, float precio, int stock) {
        setCodigo(codigo);
        setNombre(nombre);
        setPrecio(precio);
        setStock(stock);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Codigo: ").append(this.codigo).append("\nNombre: ").append(this.nombre).append("\nPrecio: ").append(this.precio).append("€\nStock: ").append(this.stock).append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this.getClass() != o.getClass()) {
            return false;
        } else {
            Articulo a = (Articulo) o;
            if (this.codigo.equals(a.getCodigo())) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean disponible(int cantidad) {
        return cantidad <= stock;
    }

    public void controlStock(int cantidad) {
        this.stock += cantidad;
    }

    public void addOpinion(ArrayList<Opinion> s) {

        s.add(new Opinion());

    }

    
    public void mediaOpinion(){
        
        int media=0;
    }
        public String showOpinions(){
            StringBuilder sb = new StringBuilder();
            for(Opinion o: opiniones){
                sb.append("\n").append(o);
            }
            return sb.toString();
        }
	
        private float mediaOpinions(){
            float media = 0;
            for(Opinion o: opiniones){
                if(o.getPuntuacion() == Puntuacion.MAL)
                    media += 1;
                if(o.getPuntuacion() == Puntuacion.REGULAR)
                    media += 2;
                if(o.getPuntuacion() == Puntuacion.BIEN)
                    media += 3;
                if(o.getPuntuacion() == Puntuacion.MUY_BIEN)
                    media += 4;
                if(o.getPuntuacion() == Puntuacion.EXCELENTE)
                    media += 5;             
            }
            
            if (opiniones.size() > 0)
                media = media/opiniones.size();
            
            return media;
                    
        }

}
