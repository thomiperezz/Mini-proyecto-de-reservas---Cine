public abstract class Butaca implements Comparable<Butaca> {
    private int fila;
    private int numero;
    private boolean ocupada=false;
    private double precio;

    public Butaca(int fila, int numero) {
        this.fila = fila;
        this.numero = numero;
        this.precio = this.calcularPrecio();
        this.ocupada=false;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return numero;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public abstract double calcularPrecio();

    @Override
    public String toString() {
        return "Fila: " + this.fila + " Numero: " + this.numero + "Precio: " + this.precio + " Ocupada:" + this.ocupada;
    }

    @Override
    public int compareTo(Butaca otra) {
        // Primero ordena por fila, luego por numero de asiento
        if (this.fila != otra.fila) {
            return Integer.compare(this.fila, otra.fila);
        }
        return Integer.compare(this.numero, otra.numero);
    }
}
