package mx.edu.utez.model.peliculas;

import mx.edu.utez.service.ConnectionMySQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPeliculas {
    Connection con;
    CallableStatement cstm;
    ResultSet rs;
    Logger logger = LoggerFactory.getLogger(DaoPeliculas.class);

    public List<BeanPeliculas> findAll(){
        List<BeanPeliculas> listPeliculas = new ArrayList<>();
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_findAll}");
            rs = cstm.executeQuery();

            while(rs.next()){
                BeanPeliculas peliculas = new BeanPeliculas();

                peliculas.setId(rs.getInt("id"));
                peliculas.setNombre(rs.getString("nombre"));
                peliculas.setDescripcion(rs.getString("descripcion"));
                peliculas.setFechaEstreno(rs.getString("fechaEstreno"));
                peliculas.setRecaudacion(rs.getInt("recaudacion"));
                peliculas.setStatus(rs.getInt("status"));

                listPeliculas.add(peliculas);
            }
        }catch (SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return listPeliculas;
    }

    public BeanPeliculas findById(int id){
        BeanPeliculas peliculas = null;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("SELECT * FROM peliculas WHERE id = ?");
            cstm.setInt(1, id);
            rs = cstm.executeQuery();

            if(rs.next()){
                peliculas = new BeanPeliculas();

                peliculas.setId(rs.getInt("id"));
                peliculas.setNombre(rs.getString("nombre"));
                peliculas.setDescripcion(rs.getString("descripcion"));
                peliculas.setFechaEstreno(rs.getString("fechaEstreno"));
                peliculas.setRecaudacion(rs.getInt("recaudacion"));
                peliculas.setStatus(rs.getInt("status"));
            }
        }catch (SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return peliculas;
    }

    public boolean create(BeanPeliculas peliculas){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_create(?,?,?,?,?)}");
            cstm.setString(1, peliculas.getNombre());
            cstm.setString(2, peliculas.getDescripcion());
            cstm.setString(3, peliculas.getFechaEstreno());
            cstm.setInt(4, peliculas.getRecaudacion());
            cstm.setInt(5, peliculas.getStatus());
            cstm.execute();
            flag = true;
        }catch(SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean update(BeanPeliculas peliculas){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_update(?,?,?,?,?,?,?)}");
            cstm.setInt(1, peliculas.getId());
            cstm.setString(2, peliculas.getNombre());
            cstm.setString(3, peliculas.getDescripcion());
            cstm.setString(4, peliculas.getFechaEstreno());
            cstm.setInt(5, peliculas.getRecaudacion());
            cstm.setInt(6, peliculas.getStatus());

            flag = cstm.execute();
        }catch(SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean delete(int id){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_delete2(?)}");
            cstm.setLong(1, id);

            flag = cstm.execute();
        }catch(SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }
}