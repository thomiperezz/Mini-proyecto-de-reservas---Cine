import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cine {
    private String nombre;
    private List<Sala> salas;

    public Cine(String nombre, List<Sala> salas) {
        this.nombre = nombre;
        this.salas = salas;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public void agregarSala(Sala sala) {
        this.salas.add(sala);
    }

    public void eliminarSala(Sala sala) {
        this.salas.remove(sala);
    }

    @Override
    public String toString() {
        return  "Cine: " + nombre + "\nSalas: " + salas.toString();
    }
}
