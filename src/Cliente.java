import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Persona{
    private String plan;
    private List<Funcion> funciones;

    public Cliente(String nombre, String apellido, String email, String dni, String plan) {
        super(nombre, apellido, email, dni);
        this.plan = plan;
        funciones = new ArrayList<>();
    }


    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public List<Funcion> getFunciones() {
        return funciones;
    }

    public void setFunciones(List<Funcion> funciones) {
        this.funciones = funciones;
    }
}
