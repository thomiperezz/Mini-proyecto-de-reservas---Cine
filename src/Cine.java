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

    @Override
    public String toString() {
        return "Cine{" +
                "nombre='" + nombre + '\'' +
                ", salas=" + this.getSalas().toString() +
                '}';
    }
}
