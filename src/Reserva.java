import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reserva {
    private int numero;
    private Date fecha;
    private String estado;
    private double total;
    private Cliente cliente;
    private List<DetalleReserva> listaDetalle;
    private Funcion funcion;

    public Reserva(Date fecha, String estado, double total, Cliente cliente, DetalleReserva detalleReserva, Funcion funcion) {
        this.numero = (int)(Math.random()*10000);
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
        this.cliente = cliente;
        this.listaDetalle = new ArrayList<DetalleReserva>();
        this.funcion = funcion;
    }

    public int getNumero() {
        return numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleReserva> getDetalleReserva() {
        return listaDetalle;
    }

    public void setDetalleReserva(List<DetalleReserva> listaDetalle) {
        this.listaDetalle=listaDetalle;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public double calcularTotal(){
        double total=0;
        for (int i=0; i<this.listaDetalle.size();i++){
            DetalleReserva detalleReserva = this.listaDetalle.get(i);
            total+=detalleReserva.calcularSubTotal();
        }
        return total;
    }

    public boolean confirmar(int numero) {
        if (this.numero == numero) {
            return true;
        }
        return false;
    }

}
