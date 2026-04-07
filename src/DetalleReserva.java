import java.util.ArrayList;
import java.util.List;

public class DetalleReserva {
    private int id;
    private Butaca butaca;
    private static int ultimoId;


    public DetalleReserva(Butaca butaca) {
        this.id=ultimoId++;
        this.butaca = butaca;
    }

    public int getId() {
        return id;
    }

    public double calcularImporte () {
        double subTotal = 0;

        subTotal=this.butaca.calcularPrecio();
        return subTotal;
    }

}
