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
public class Opinion implements Comparable<Opinion> {

    private Usuario user;
    private Puntuacion puntuacion;
    private String comentario;
    private int positivo;
    private int negativo;

    @Override
    public int compareTo(Opinion o) {
        //o.puntuacion;
        return 0;
    }




    public Opinion() {
        positivo = 0;
        negativo = 0;
    }

    /**
     *
     * @param user
     * @param puntuacion
     * @param comentario
     */
    public Opinion(Usuario user, Puntuacion puntuacion, String comentario) {
        positivo = 0;
        negativo = 0;
        this.user = user;
        this.puntuacion = puntuacion;
        this.comentario = comentario;

    }

    public void votarPositivo() {
        this.positivo++;
    }

    public void votarNegativo() {
        this.negativo--;
    }

    public Puntuacion getPuntuacion() {
        return this.puntuacion;
    }

    /**
     *
     * @return @author Samuel
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nUsuario=").append(user);
        sb.append("\ncomentario=").append(puntuacion);
        sb.append("\npositivos=").append(positivo);
        sb.append("\negativos=").append(negativo);
        return sb.toString();
    }

}
