public class DetalleReserva {
    private int id;
    private Butaca butaca;
    private double subTotal;
    private static int ultimoId;


    public DetalleReserva(double precioFinal, Butaca butaca, double subTotal) {
        this.id = ultimoId++;
        this.subTotal = subTotal;
        this.butaca = butaca;
    }

    public int getId() {
        return id;
    }

    public Butaca getButaca() {
        return butaca;
    }

    public void setButaca(Butaca butaca) {
        this.butaca = butaca;
    }

    public double getSubTotal() {
        return this.getButaca().calcularPrecio();
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double calcularSubTotal(){
        return this.getButaca().calcularPrecio();
    }
}
