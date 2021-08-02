package mx.edu.utez.model.peliculas;

public class BeanPeliculas {
    private int id;
    private String nombre;
    private String descripcion;
    private String fechaEstreno;
    private int recaudacion;
    private int status;

    public BeanPeliculas() {
    }

    public BeanPeliculas(int id, String nombre, String descripcion, String fechaEstreno, int recaudacion, int status) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaEstreno = fechaEstreno;
        this.recaudacion = recaudacion;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public int getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(int recaudacion) {
        this.recaudacion = recaudacion;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
