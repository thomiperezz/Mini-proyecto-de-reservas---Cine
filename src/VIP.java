public class VIP extends Butaca{
    public VIP(int fila, int columna) {
        super (fila, columna);
    }

    public double calcularPrecio() {
        this.setPrecio(100);
        double precio = this.getPrecio();
        return precio;
    }
}
