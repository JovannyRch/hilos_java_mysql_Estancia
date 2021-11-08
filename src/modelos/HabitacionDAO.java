package modelos;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class HabitacionDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
     public ArrayList listar() {
        ArrayList<Habitacion> lista = new ArrayList<>();
        String sql = "select id_habitacion, tipo_habitacion, estatus, no_habitacion, costo from habitaciones";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Habitacion item = new Habitacion();
                item.setIdHabitacion(rs.getInt(1));
                item.setTipoHabitacion(rs.getString(2));
                item.setEstatus(rs.getString(3));
                item.setNoHabitacion(rs.getInt(4));
                item.setCosto(rs.getFloat(5));
                lista.add(item);

            }
        } catch (Exception e) {
            System.out.println("Error en el query: "+e.getMessage());
        }
        return lista;
    }
     
     public ArrayList listarDisponibles() {
        ArrayList<Habitacion> lista = new ArrayList<>();
        String sql = "select id_habitacion, tipo_habitacion, estatus, no_habitacion, costo from habitaciones where estatus = 'Disponible'";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Habitacion item = new Habitacion();
                item.setIdHabitacion(rs.getInt(1));
                item.setTipoHabitacion(rs.getString(2));
                item.setEstatus(rs.getString(3));
                item.setNoHabitacion(rs.getInt(4));
                item.setCosto(rs.getFloat(5));
                lista.add(item);

            }
        } catch (Exception e) {
            System.out.println("Error en el query: "+e.getMessage());
        }
        return lista;
    }

}
