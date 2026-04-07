public class Platinum extends Butaca {
    public Platinum(int fila, int columna) {
        super(fila, columna);
    }

    public double calcularPrecio() {
        this.setPrecio(50);
        double precio = this.getPrecio();
        return precio;
    }
}
