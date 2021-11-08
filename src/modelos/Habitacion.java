/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;


public class Habitacion {
    
    private int idHabitacion;
    private String tipoHabitacion;
    private String estatus;
    private int noHabitacion;
    private float costo;
    
    public static String DISPONIBLE = "Disponible";
    public static String OCUPADO = "Ocupado";

    public Habitacion(int idHabitacion, String tipoHabitacion, String estatus, int noHabitacion, float costo) {
        this.idHabitacion = idHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.estatus = estatus;
        this.noHabitacion = noHabitacion;
        this.costo = costo;
    }

    public Habitacion() {
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int id_habitacion) {
        this.idHabitacion = id_habitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipo_habitacion) {
        this.tipoHabitacion = tipo_habitacion;
    }

    public String getEstatus() {
        return estatus;
    }

    @Override
    public String toString() {
        return "#: " + noHabitacion + ", Tipo: " + tipoHabitacion + ", Costo: $" + costo;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getNoHabitacion() {
        return noHabitacion;
    }

    public void setNoHabitacion(int noHabitacion) {
        this.noHabitacion = noHabitacion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
    
    
    
}
