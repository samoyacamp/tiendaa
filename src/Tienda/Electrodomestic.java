package Tienda;

/**
 *
 * @author power
 */
public class Electrodomestic extends Electrodomestico{
    public Electrodomestic(){}
    
    private String etiquetado;
    private String funcionalidad;
    private String diseño;
    
    public Electrodomestic(String etiquetado,String funcionalidad, String diseño, String codigo, String nombre, float precio, int stock){
        super();
        
    }
    public String getFuncionalidad(){
        return funcionalidad;
    }
    public void setFuncionalidad(){
        this.funcionalidad=funcionalidad;
    }    
    public String getEtiquetado(){
    return etiquetado;
    }
    public void setEtiquetado(){
    this.etiquetado=etiquetado;
    }
    public String diseño(){
    return diseño;
    }
    public void getDiseño(){
    this.diseño=diseño;
    }
    @Override
    public String toString(){
    return this.etiquetado +"x" + this.diseño +"x" +this.funcionalidad;
    }  
    
}
