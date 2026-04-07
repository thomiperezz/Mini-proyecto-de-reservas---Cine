import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cine {
    private String nombre;
    private List<Sala> salas;

    public Cine(String nombre, List<Sala> salas) {
        this.nombre = nombre;
        this.salas = new  ArrayList<Sala>();
    }

    public Cine (String nombre) {
        this.nombre = nombre;
        this.salas=new ArrayList<>();
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

    public String listarSalas() {
        String detalleCines = "";
        for (int i = 0; i < salas.size(); i++) {
            Sala sala = salas.get(i);

            detalleCines+=sala.toString();
        }
        return detalleCines;
    }

    @Override
    public String toString() {
        return  "\nCine: " + nombre + ", Salas: " + salas.toString()+"\n";
    }
}
