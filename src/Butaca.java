public abstract class Butaca implements Comparable<Butaca> {
    private int fila;
    private int columna;
    private boolean ocupada=false;

    public Butaca(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public abstract double calcularPrecio();

    @Override
    public String toString() {
        return "Fila: " + this.fila + " Columna: " + this.columna + " Ocupada:" + this.ocupada;
    }

    @Override
    public int compareTo(Butaca otra) {
        // Primero ordena por fila, luego por columna
        if (this.fila != otra.fila) {
            return Integer.compare(this.fila, otra.fila);
        }
        return Integer.compare(this.columna, otra.columna);
    }
}
