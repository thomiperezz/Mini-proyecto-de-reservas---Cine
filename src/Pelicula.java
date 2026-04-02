import java.util.Date;

public class Pelicula {
    private String nombre;
    private Date creacion;
    private String autor;

    public Pelicula(String nombre, Date creacion, String autor) {
        this.nombre = nombre;
        this.creacion = creacion;
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ", Autor: " + this.autor +  ", Fecha de creación: " + this.creacion;
    }
}
