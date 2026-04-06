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

    public void listarSalas() {
        if (this.salas.isEmpty()) {
            return;
        }

        System.out.println("\n=== SALAS DE: " + this.nombre + " ===");
        if (this.getSalas().isEmpty()) {
            System.err.println("No hay salas en este cine.");
            return;
        }
        for (int i = 0; i < this.salas.size(); i++) {
            Sala sala = this.salas.get(i);
            System.out.println((i + 1) + ". Sala " + (sala.getNumero()+1) + " - " + sala.getButacas().size() + " butacas");
        }
    }

    @Override
    public String toString() {
        return  "Cine: " + nombre + "\nSalas: " + salas.toString();
    }
}
