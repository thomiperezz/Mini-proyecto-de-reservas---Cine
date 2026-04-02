import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funcion {
    private int numero;
    private LocalDateTime fecha;
    private Sala sala;
    private Pelicula pelicula;
    private static int ultimoId;

    public Funcion(LocalDateTime fecha, Sala sala, Pelicula pelicula) {
        this.numero = ultimoId++;
        this.fecha = fecha;
        this.sala = sala;
        this.pelicula = pelicula;
    }

    public int getNumero() {
        return numero;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public static int getUltimoId() {
        return ultimoId;
    }

    public static void setUltimoId(int ultimoId) {
        Funcion.ultimoId = ultimoId;
    }

    @Override
    public String toString() {
        return "N. Función: " + this.numero + ", fecha: " + this.fecha + ", sala: " + this.sala +  ", pelicula: " + this.pelicula;
    }


}
