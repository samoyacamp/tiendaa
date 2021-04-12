package Tienda;

/**
 *
 * @author power
 */
public class Ropa extends Articulo {

    public Ropa() {
    }

    
    private String color;
    private TallaSML talla;

    public Ropa(String gama, String color, TallaSML talla, String codigo, String nombre, float precio, int stock) {
        this.color = color;
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor() {
        this.color = color;
    }

    public TallaSML talla() {
        return talla;
    }

    public void setTalla() {
        this.talla = talla;
    }
    public void getGama(){
    }
    /**
     * 
     * @param codigoPromo 
     */
    @Override
    public void applyPromo(String codigoPromo) {
        //Si el codigo de descuento es "ROPAPROMO" se aplica un 20% de descuento.
        if(codigoPromo.equals("ROPAPROMO")){
            this.setPrecio (((float)this.getPrecio()*0.8));
        }
    }
    public String toStringFile(){
    return color +","+ talla +","+super.getCodigo()+","+super.getNombre()+","+super.getPrecio()+","+super.getStock();
    }
    
    
}
