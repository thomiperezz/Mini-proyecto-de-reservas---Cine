import java.util.Scanner;

public class Cine {

    static char[][] butacas;

    public static void main(String[] args) {
        /*
            Sistema de Reservas de Cine
            Desarrollá un programa en Java que simule la gestión de butacas de una sala de cine.

            Requerimientos obligatorios
            Estructura de datos

            Que se solicite el ingreso del tamaño del cine para iniciar a gestionar las butacas.

            Usá una matriz de caracteres (char) para representar el estado de cada butaca:

            'L' → Libre

            'X' → Ocupada

            Mostrar el mapa de butacas

            El programa debe mostrar un mapa visual como este:

            text
                1 2 3 4 5 6 7 8
            1   L L L L L L L L
            2   L L L L L L L L
            3   L L L L L L L L
            4   L L L L L L L L
            5   L L L L L L L L
            Los números de fila y columna deben verse claramente.

            Menú interactivo

            Al iniciar, mostrar el mapa y luego un menú con dos opciones:

            Reservar una butaca
            Salir
            El menú debe repetirse hasta que el usuario elija salir.

            Reserva de butacas

            Solicitar al usuario el número de fila y número de columna.

            Validar que los números estén dentro del rango. Si no, mostrar un mensaje de error y volver al menú.

            Verificar si la butaca está libre ('L').

            Si está libre, marcarla como ocupada ('X') y mostrar mensaje de éxito.

            Si ya está ocupada, mostrar mensaje de error y no modificar nada.

            Después de reservar, volver a mostrar el mapa actualizado y el menú.

            Manejo de errores básico

            Evitar que el programa falle si el usuario ingresa letras o números fuera de rango (podés usar nextInt() y manejar entradas inválidas con condicionales; más adelante podrás mejorarlo con excepciones).

            Extras (opcionales, podés agregarlos cuando termines lo obligatorio)
            Mostrar cantidad de butacas libres y ocupadas después de cada reserva.

            Calcular y mostrar el porcentaje de ocupación.

            Permitir reservar múltiples butacas a la vez (preguntar cuántas y luego pedir cada posición).

            Asignar precios diferentes por fila (ej. filas 1–2: $100, filas 3–5: $80) y mostrar el total a pagar al finalizar la reserva.

            Evitar que se muestre el menú si la sala está completamente llena; mostrar un mensaje y terminar el programa.

            Buenas prácticas que debés aplicar
            Usá constantes (static final int FILAS = 5;) en lugar de números mágicos.

            Dividí el código en métodos con responsabilidades claras (por ejemplo: mostrarMapa(), reservarButaca(), estaDentroDeRango()).

            Comentá las partes clave para que se entienda tu lógica.

            Elegí nombres de variables en inglés o español consistentes y descriptivos.

            Entregable
            Al final, tenés que tener un archivo .java que compile y ejecute correctamente en IntelliJ (o cualquier IDE). Probalo con diferentes casos:

            Reservar butacas libres.

            Intentar reservar la misma butaca dos veces.

            Ingresar filas/columnas inválidas.

            Salir del programa.
        *
        * */
        System.out.println("-----------Bienvenido al sistema de gestión de Cines-----------");

        System.out.println("Ingrese la cantidad de filas que tiene la sala: ");
        Scanner inputFilas = new Scanner(System.in);
        int filas=inputFilas.nextInt();

        System.out.println("Ingrese la cantidad de columnas que tiene la sala: ");
        Scanner inputColumnas = new Scanner(System.in);
        int columnas = inputColumnas.nextInt();

        // Inicializamos la matriz
        butacas  = inicializarCine(filas,columnas);


        System.out.println("-----------MAPA DE BUTACAS-----------");
        System.out.println(mostrarMapa());

        System.out.println(" ");

        System.out.println("-----------MENU-----------");
        System.out.println("1. Reservar una butaca");
        System.out.println("2. Salir");
        System.out.println("---------------------------------");

        Scanner inputMenu = new Scanner(System.in);
        System.out.println("Ingrese la opcion: ");
        int opcion = inputMenu.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Ingrese la cantidad de reservas de butaca que quiere realizar: ");
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
                    System.out.println(mostrarMapa());
                    System.out.println("El porcentaje de ocupación actual es: " + calcularPorcentajeOcupacion()+ "%");

                } else if (cantidad==1) {
                    System.out.println("Ingrese la fila: ");
                    Scanner inputFila = new Scanner(System.in);
                    int fila = inputFila.nextInt()-1;

                    System.out.println("Ingrese la columna: ");
                    Scanner inputColumna = new Scanner(System.in);
                    int columna = inputColumna.nextInt()-1;

                    reservarButaca(fila,columna);
                    System.out.println(mostrarMapa());
                    System.out.println("El porcentaje de ocupación actual es: " + calcularPorcentajeOcupacion() + "%");

                } else if (cantidad==-1) {
                    System.exit(0);
                } else {
                    System.err.println("Debe ingresar al menos una reserva..");
                }

            case 2:
                System.exit(0);
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
}
