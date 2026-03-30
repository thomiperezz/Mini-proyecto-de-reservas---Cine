import java.util.Scanner;

public class Cine {

    static char[][] butacas;

    public static void main(String[] args) {
        System.out.println("-----------Bienvenido al sistema de gestión de Cines-----------");

        System.out.println("Ingrese la cantidad de filas que tiene la sala: ");
        Scanner inputFilas = new Scanner(System.in);
        int filas=inputFilas.nextInt();

        System.out.println("Ingrese la cantidad de columnas que tiene la sala: ");
        Scanner inputColumnas = new Scanner(System.in);
        int columnas = inputColumnas.nextInt();

        // Inicializamos la matriz
        butacas  = inicializarCine(filas,columnas);


        boolean salir = false;

        while (salir==false) {
            System.out.println("-----------MAPA DE BUTACAS-----------");
            System.out.println(mostrarMapa());
            System.out.println("Porcentaje de ocupación de la sala: " + calcularPorcentajeOcupacion()+"%");
            System.out.println(" ");

            if (estaSalaLlena()==true){
                System.out.println("Sala llena, no se pueden realizar más reservas..");
                System.exit(0);
            }

            System.out.println("-----------MENU-----------");
            System.out.println("1. Reservar una butaca");
            System.out.println("2. Salir");
            System.out.println("---------------------------------");

            Scanner inputMenu = new Scanner(System.in);
            System.out.println("Ingrese la opcion: ");
            int opcion = inputMenu.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la cantidad de reservas que quiere realizar (-1 para cancelar la operación): ");
                    Scanner inputCantidadReservas = new Scanner(System.in);
                    int cantidad = inputCantidadReservas.nextInt();

                    if (cantidad>1) {
                        System.out.println("Ingrese las filas: ");
                        Scanner inputFila = new Scanner(System.in);
                        int[] filasReserva = new int[cantidad];

                        for  (int i = 0; i < cantidad; i++) {
                            int ingresoFila = inputFila.nextInt();
                            filasReserva[i] = ingresoFila-1;
                        }

                        System.out.println("Ingrese las columnas: ");
                        Scanner inputColumna = new Scanner(System.in);
                        int [] columnasReserva = new int[cantidad];

                        for ( int i = 0; i < cantidad; i++) {
                            int ingresoColumna = inputColumna.nextInt();
                            columnasReserva[i] = ingresoColumna-1;
                        }

                        reservarButaca(filasReserva,columnasReserva);

                    } else if (cantidad==1) {
                        System.out.println("Ingrese la fila: ");
                        Scanner inputFila = new Scanner(System.in);
                        int fila = inputFila.nextInt()-1;

                        System.out.println("Ingrese la columna: ");
                        Scanner inputColumna = new Scanner(System.in);
                        int columna = inputColumna.nextInt()-1;

                        reservarButaca(fila,columna);


                    } else if (cantidad==-1) {
                        break;
                    } else {
                        System.err.println("Debe ingresar al menos una reserva..");
                    }
                    break;
                case 2:
                    salir = true;
                    break;
                    default:
                        System.err.println("Opción inválida. Por favor ingrese 1 o 2.");
                        break;
            }
        }

    }

    public static void reservarButaca(int numeroFila, int numeroColumna) {
        if (butacas[numeroFila][numeroColumna] == 'L') {
            butacas[numeroFila][numeroColumna] = 'X';
        }
    }

    public static void reservarButaca(int[] numeroFilas, int[] numeroColumnas) {
        for  (int i = 0; i < numeroFilas.length; i++) {
            if (butacas[(numeroFilas[i])][(numeroColumnas[i])] == 'L') {
                butacas [(numeroFilas[i])][(numeroColumnas[i])] = 'X';
            }
        }

    }


    public static char[][] inicializarCine(int filas, int columnas) {
        butacas = new char[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                butacas[i][j] = 'L';
            }
        }

        return butacas;
    }

    public static String mostrarMapa () {
        String mapa="";
        for (int i = 0; i < butacas.length; i++) {
            if (i==0) {
                mapa+="   ";
                for (int k = 0; k < butacas[i].length; k++) {
                    mapa+=(k+1) + " ";
                }
            }

            mapa+="\n"+(i+1) + "  ";

            for (int j = 0; j < butacas[i].length; j++) {
                mapa+=butacas[i][j] + " ";
            }
        }
        return mapa;
    }

    public static double calcularPorcentajeOcupacion () {
        int total=0;
        int ocupados=0;

        for  (int i = 0; i < butacas.length; i++) {
            for  (int j = 0; j < butacas[i].length; j++) {
                if (butacas[i][j]=='X') {
                    ocupados++;
                }
                total++;
            }
        }

        double ocupacion =  ((double) ocupados/total)*100;
        return ocupacion;
    }

    public static boolean estaSalaLlena () {
        for(int i = 0; i < butacas.length; i++) {
            for(int j = 0; j < butacas[i].length; j++) {
                if (butacas[i][j]=='L') {
                    return false;
                }
            }
        }
        return true;
    }
}
