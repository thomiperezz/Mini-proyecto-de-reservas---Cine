import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sala {
    private int numero;
    private List<Butaca> butacas;
    private List<Funcion> funciones;
    private static int ultimoId;

    public Sala(List<Butaca> butacas) {
        this.numero = ultimoId++;
        this.butacas = new  ArrayList<Butaca>();
        this.funciones = new ArrayList<Funcion>();
    }

    public Sala(List<Butaca> butacas, List<Funcion> funciones) {
        this(butacas);
        this.funciones = new ArrayList<Funcion>();
    }

    public int getNumero() {
        return numero;
    }

    public List<Butaca> getButacas() {
        return butacas;
    }

    public void setButacas(List<Butaca> butacas) {
        this.butacas = butacas;
    }

    public List<Funcion> getFunciones() {
        return funciones;
    }

    public void setFunciones(List<Funcion> funciones) {
        this.funciones = funciones;
    }

    public boolean estaSalaLlena() {
        for (int i = 0; i < this.butacas.size(); i++) {
            if (!this.butacas.get(i).isOcupada()) {
                return false;
            }
        }
        return true;
    }

    public double calcularOcupacion () {
        int total=0;
        int ocupados=0;

        for  (int i = 0; i < this.butacas.size(); i++) {
            if(this.butacas.get(i).isOcupada()) {
                ocupados++;
            }
            total++;
        }

        double ocupacion =  ((double) ocupados/total)*100;
        return ocupacion;
    }

    public void crearSala (int filas, int columnas) {
        List<Butaca> butacas = new ArrayList<Butaca>();

        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                Butaca butacaCreada;
                if (i<2) {
                    butacaCreada = new VIP(i,j);
                } else if (i >= filas - 2) {
                    butacaCreada = new Gold(i,j);
                } else {
                    butacaCreada = new Platinum(i,j);
                }
                butacas.add(butacaCreada);
            }
        }

        Sala salaNueva = new Sala(butacas);
    }

    public void reservarButaca(ArrayList<Integer> numeroFilas, ArrayList<Integer> numeroColumnas) {
        for  (int i = 0; i < numeroFilas.size(); i++) {
            for (int j=0;j<this.butacas.size();j++) {
                if (this.butacas.get(j).getFila()==numeroFilas.get(i) && this.butacas.get(j).getColumna()==numeroColumnas.get(i) && this.butacas.get(i).isOcupada()==false) {
                    this.butacas.get(j).setOcupada(true);
                }
            }

        }

    }

    public Butaca buscarButaca(int fila,int columna) {
        for (Butaca butaca : this.butacas) {
            if (butaca.getFila()==fila && butaca.getColumna()==columna) {
                return butaca;
            }
        }
        return null;
    }

    public String mostrarSala() {
        Collections.sort(this.butacas);
        String sala = "";
        for (int i = 0; i < this.butacas.size(); i++) {
            if (this.butacas.get(i).isOcupada()) {
                sala+="X ";
            } else {
                sala+="L ";
            }
        }
        return sala;
    }

    public List<Funcion> buscarFuncionesPorDia(LocalDate dia) {
        List<Funcion> resultado = new ArrayList<>();
        for (Funcion f : funciones) {
            if (f.getFecha().toLocalDate().equals(dia)) {
                resultado.add(f);
            }
        }
        return resultado;
    }

    public List<Funcion> buscarFuncionesPorMes(int mes, int anio) {
        List<Funcion> resultado = new ArrayList<>();
        for (Funcion f : funciones) {
            LocalDateTime fecha = f.getFecha();
            if (fecha.getMonthValue() == mes && fecha.getYear() == anio) {
                resultado.add(f);
            }
        }
        return resultado;
    }


    @Override
    public String toString() {
        return "Sala N: " + this.numero + "\n" + mostrarSala();
    }

}
