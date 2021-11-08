/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Andy
 */
public class ReservacionDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public ArrayList listar() {
        ArrayList<Reservacion> lista = new ArrayList<>();
        String sql = "select id_reservacion, fecha_entrada, fecha_salida, dias, id_habitacion from reservaciones";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Reservacion item = new Reservacion();
                item.setIdReservacion(rs.getInt(1));
                item.setFechaEntrada(rs.getString(2));
                item.setFechaSalida(rs.getString(3));
                item.setDias(rs.getInt(4));
                item.setIdHabitacion(rs.getInt(5));
                lista.add(item);

            }
        } catch (Exception e) {
            System.out.println("Error en el query: " + e.getMessage());
        }
        return lista;
    }
    
     public ArrayList listarWithEstatusHabitacion() {
        ArrayList<Reservacion> lista = new ArrayList<>();
        String sql = "select r.id_reservacion, r.fecha_entrada, r.fecha_salida, r.dias, r.id_habitacion, h.estatus as estatus from reservaciones r natural join habitaciones h order by r.id_reservacion desc";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Reservacion item = new Reservacion();
                item.setIdReservacion(rs.getInt(1));
                item.setFechaEntrada(rs.getString(2));
                item.setFechaSalida(rs.getString(3));
                item.setDias(rs.getInt(4));
                item.setIdHabitacion(rs.getInt(5));
                item.setHabitacion(rs.getString(6));
                lista.add(item);

            }
        } catch (Exception e) {
            System.out.println("Error en el query: " + e.getMessage());
        }
        return lista;
    }

    public int add(Reservacion reservacion) {
        int r = 0;
        String sql = "insert into reservaciones"
                + "(id_reservacion, fecha_entrada, fecha_salida, dias, id_habitacion)"
                + " values(?,?,?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, reservacion.getIdReservacion());
            ps.setObject(2, reservacion.getFechaEntrada());
            ps.setObject(3, reservacion.getFechaSalida());
            ps.setObject(4, reservacion.getDias());
            ps.setObject(5, reservacion.getIdHabitacion());

            r = ps.executeUpdate();

            updateHabitacion(reservacion.getIdHabitacion(), Habitacion.OCUPADO);

        } catch (Exception e) {
            System.out.println("Error en: " + sql);
            System.out.println(e.getMessage());
        }
        return r;
    }

    public int updateHabitacion(int idHabitacion, String disponibilidad) {
        int r = 0;
        String sql = "update habitaciones set estatus=? where id_habitacion=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, disponibilidad);
            ps.setObject(2, idHabitacion);
            r = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en: " + sql);
            System.out.println(e.getMessage());
        }
        return r;
    }
}
