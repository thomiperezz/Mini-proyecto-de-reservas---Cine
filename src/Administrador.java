import java.util.ArrayList;
import java.util.List;

public class Administrador extends Persona {
    private int legajo;
    private List<Cine> cines;

    public Administrador(String nombre, String apellido, String email, String dni, int legajo) {
        super(nombre, apellido, email, dni);
        this.legajo = legajo;
        this.cines = new ArrayList<>();
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public List<Cine> getCines() {
        return cines;
    }

    public void listarCines() {
        System.out.println("\n=== CINES DISPONIBLES ===");
        if (cines.isEmpty()) {
            System.err.println("No hay cines registrados.");
            return;
        }
        for (int i = 0; i < cines.size(); i++) {
            Cine cine = cines.get(i);
            System.out.println((i + 1) + ". " + cine.getNombre());
            System.out.println("   - Salas: " + cine.getSalas().size());
            int totalButacas = 0;
            for (Sala sala : cine.getSalas()) {
                totalButacas += sala.getButacas().size();
            }
            System.out.println("   - Total de butacas: " + totalButacas);
        }
    }



    public void listarFunciones(int indiceCine, int indiceSala) {
        if (indiceCine < 0 || indiceCine >= cines.size()) {
            return;
        }
        
        Cine cine = cines.get(indiceCine);
        if (indiceSala < 0 || indiceSala >= cine.getSalas().size()) {
            return;
        }
        
        Sala sala = cine.getSalas().get(indiceSala);
        System.out.println("\n=== FUNCIONES - Sala " + sala.getNumero() + " ===");
        if (sala.getFunciones() == null || sala.getFunciones().isEmpty()) {
            System.out.println("No hay funciones programadas.");
            return;
        }
        for (int i = 0; i < sala.getFunciones().size(); i++) {
            Funcion funcion = sala.getFunciones().get(i);
            System.out.println((i + 1) + ". " + funcion.getPelicula().getNombre() + " - " + funcion.getFecha());
        }
    }

    public void mostrarOcupacionSala(int indiceCine, int indiceSala) {
        if (indiceCine < 0 || indiceCine >= cines.size()) {
            return;
        }
        
        Cine cine = cines.get(indiceCine);
        
        Sala sala = cine.getSalas().get(indiceSala);
        System.out.println("\n=== OCUPACION - Sala " + sala.getNumero() + " ===");
        System.out.println(sala.mostrarSala());
        System.out.printf("Ocupacion: %.2f%%\n", sala.calcularOcupacion());
        int butacasOcupadas = (int)(sala.getButacas().size() * sala.calcularOcupacion() / 100.0);
        System.out.println("Butacas ocupadas: " + butacasOcupadas + "/" + sala.getButacas().size());
    }

    public void listarDetallesCine(int indiceCine) {
        if (indiceCine < 0 || indiceCine >= cines.size()) {
            return;
        }
        
        Cine cine = cines.get(indiceCine);
        System.out.println("\n=== DETALLES - " + cine.getNombre() + " ===");
        System.out.println("Total de salas: " + cine.getSalas().size());
        
        int totalButacas = 0;
        int totalOcupadas = 0;
        
        for (Sala sala : cine.getSalas()) {
            totalButacas += sala.getButacas().size();
            for (Butaca b : sala.getButacas()) {
                if (b.isOcupada()) {
                    totalOcupadas++;
                }
            }
        }
        
        System.out.println("Total de butacas: " + totalButacas);
        System.out.println("Butacas ocupadas: " + totalOcupadas);
        double ocupacionGeneral = (totalButacas > 0 ? (totalOcupadas * 100.0 / totalButacas) : 0);
        System.out.printf("Ocupacion general: %.2f%%\n", ocupacionGeneral);
    }

    public void crearCine (String nombre, int cantidadSalas) {
        Cine cine = new Cine(nombre);

        for (int i = 0; i < cantidadSalas; i++) {
            Sala sala = new Sala();
            cine.agregarSala( sala );
        }
    }

    public void agregarSalaCine (Cine cine, int filas, int columnas) {
        for (Cine cineRecorrido : this.getCines()) {
            if (cineRecorrido.getNombre().equals(cine.getNombre())) {
                Sala sala = new Sala();
                sala.rellenarSala(filas,columnas);
            }
        }
    }
}