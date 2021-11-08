/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;


import modelos.*;

public class ReservacionHilo extends Thread {

    
    private Reservacion reservacion;
    private ReservacionDAO reservacionDao;
    
    public ReservacionHilo(Reservacion reservacion){
        this.reservacion = reservacion;
        this.reservacionDao = new ReservacionDAO();
    }
    
    @Override
    public void run() {
        int dias = reservacion.getDias();
        
        System.out.println("---------------------------");
        System.out.println("Se ha ocupado la habitacion con id: "+reservacion.getIdHabitacion()+" por "+dias+" días");
        System.out.println("---------------------------\n\n");
        
        esperarNSegundos(dias * 24);
        reservacionDao.updateHabitacion(reservacion.getIdHabitacion(), Habitacion.DISPONIBLE);
        
        System.out.println("\n---------------------------");
        System.out.println("Se ha desocupado la habitacion con id: "+reservacion.getIdHabitacion()+", después de "+dias+" días");
        System.out.println("---------------------------\n");
    }

    private void esperarNSegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
