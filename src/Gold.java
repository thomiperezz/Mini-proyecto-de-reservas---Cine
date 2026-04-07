public class Gold extends Butaca{
    public Gold(int fila, int columna) {
        super(fila, columna);
    }

    public double calcularPrecio() {
        this.setPrecio(75);
        double precio = this.getPrecio();
        return precio;
    }
}
