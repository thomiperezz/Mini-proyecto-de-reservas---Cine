import java.time.LocalDateTime;
import java.util.*;

public class Main {
    static List<Cine> cines = new ArrayList<>();
    static List<Pelicula> peliculas = new ArrayList<>();
    static List<Reserva> todasLasReservas = new ArrayList<>();
    static Administrador admin=new Administrador("Admin", "Sistema", "admin@cine.com", "00000000", 1);
    static Cliente cliente = new Cliente("Thomas","Perez","perezthomas17@hotmail.com","111111111","Sin plan");
    static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("Con qué usuario quiere ingresar al sistema?");
        System.out.println("1. Usuario Administrador.");
        System.out.println("2. Usuario Cliente.");
        scanner = new Scanner(System.in);
        int opcion = obtenerOpcion(scanner);
        switch (opcion) {
            case 1:
                consultarAdmin(scanner);
                break;
                case 2:
                    mostrarMenuPrincipal(cliente);
                    break;
        }

    }

    static void mostrarMenuPrincipal(Cliente cliente) {
        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("1. Ver Mapa de Butacas");
        System.out.println("2. Hacer Reserva");
        System.out.println("3. Salir");
        scanner = new Scanner(System.in);

        int opcion;
        while (true) {
            mostrarMenuPrincipal(cliente);
            System.out.println("Bienvenido al sistema " + cliente.getNombre()+ ", seleccione al acción que quiere realizar:  ");
            opcion = obtenerOpcion(scanner);

            switch (opcion) {
                case 1:
                    verMapaButacas(scanner);
                    break;
                case 2:
                    hacerReserva(scanner);
                    break;
                case 3:
                    System.out.println("\nGracias!");
                    scanner.close();
                    return;
            }
            System.out.println("\nPresiona Enter...");
            scanner.nextLine();
        }


    }

    static int obtenerOpcion(Scanner s) {
        System.out.print("Opcion: ");
        return Integer.parseInt(s.nextLine());
    }

    static String obtenerTexto(Scanner s, String msg) {
        System.out.print(msg);
        return s.nextLine();
    }

    static int obtenerEntero(Scanner s, String msg) {
        System.out.print(msg);
        return Integer.parseInt(s.nextLine());
    }

    static void crearCine(Scanner s) {
        System.out.println("\n=== CREAR CINE ===");
        String nombre = obtenerTexto(s, "Nombre: ");
        Cine cine = new Cine(nombre, new ArrayList<>());
        admin.getCines().add(cine);
        System.out.println("Cine creado!");
    }

    static void crearSala(Scanner s) {
        if (admin.getCines().isEmpty()) {
            System.err.println("Crea un cine primero.");
            return;
        }

        List <Cine> cines = admin.getCines();

        System.out.println("\n=== CREAR SALA ===");
        for (int i = 0; i < cines.size(); i++) {
            System.out.println((i + 1) + ". " + cines.get(i).getNombre());
        }

        int inputCine = obtenerEntero(s, "Cine: ") - 1;
        Cine cine = admin.getCines().get(inputCine);

        int filas = obtenerEntero(s, "Filas: ");
        int cols = obtenerEntero(s, "Columnas: ");
        Sala sala = new Sala();
        sala.rellenarSala(filas, cols);
        cine.agregarSala(sala);
        System.out.println("Sala creada!");
    }


    static void crearPelicula(Scanner s) {
        System.out.println("\n=== CREAR PELICULA ===");
        String nombre = obtenerTexto(s, "Nombre: ");
        String autor = obtenerTexto(s, "Director: ");
        Pelicula p = new Pelicula(nombre, new Date(), autor);
        peliculas.add(p);
        System.out.println("Pelicula creada!");
    }

    static void crearFuncion(Scanner s) {
        if (cines.isEmpty() || peliculas.isEmpty()) { System.out.println("Necesitas cine y pelicula."); return; }
        System.out.println("\n=== CREAR FUNCION ===");
        for (int i = 0; i < cines.size(); i++) System.out.println((i + 1) + ". " + cines.get(i).getNombre());
        int cinIdx = obtenerEntero(s, "Cine: ") - 1;
        Cine cine = cines.get(cinIdx);
        if (cine.getSalas().isEmpty()) { System.out.println("Sin salas."); return; }
        for (int i = 0; i < cine.getSalas().size(); i++) System.out.println((i + 1) + ". Sala " + cine.getSalas().get(i).getNumero());
        int salaIdx = obtenerEntero(s, "Sala: ") - 1;
        Sala sala = cine.getSalas().get(salaIdx);
        for (int i = 0; i < peliculas.size(); i++) System.out.println((i + 1) + ". " + peliculas.get(i).getNombre());
        int pelIdx = obtenerEntero(s, "Pelicula: ") - 1;
        Pelicula pel = peliculas.get(pelIdx);
        int anio = obtenerEntero(s, "Anio: ");
        int mes = obtenerEntero(s, "Mes: ");
        int dia = obtenerEntero(s, "Dia: ");
        int hora = obtenerEntero(s, "Hora: ");
        int min = obtenerEntero(s, "Minuto: ");
        LocalDateTime fecha = LocalDateTime.of(anio, mes, dia, hora, min);
        Funcion func = new Funcion(fecha, sala, pel);
        sala.getFunciones().add(func);
        System.out.println("Funcion creada!");
    }

    static void verMapaButacas(Scanner s) {
        if (cines.isEmpty()) {
            System.out.println("Sin cines.");
            return;
        }
        System.out.println("\n=== VER MAPA ===");
        for (int i = 0; i < cines.size(); i++) System.out.println((i + 1) + ". " + cines.get(i).getNombre());
        int cinIdx = obtenerEntero(s, "Cine: ") - 1;
        Cine cine = admin.getCines().get(cinIdx);
        if (cine.getSalas().isEmpty()) {
            System.out.println("Sin salas.");
            return; }

        for (int i = 0; i < cine.getSalas().size(); i++) {
            System.out.println((i + 1) + ". Sala " + cine.getSalas().get(i).getNumero());
        }
        int salaIdx = obtenerEntero(s, "Sala: ") - 1;
        Sala sala = cine.getSalas().get(salaIdx);
        System.out.println("\nMapa:"); System.out.println(sala.mostrarSala());
        System.out.println("L=Libre, X=Ocupada"); System.out.printf("Ocupacion: %.2f%%\n", sala.calcularOcupacion());
        System.out.println("\nPrecios: VIP=$100, Platinum=$75, Gold=$50");
    }

    static void hacerReserva(Scanner s) {
        if (cines.isEmpty()) { System.out.println("Sin cines."); return; }
        System.out.println("\n=== RESERVA ===");
        String nombre = obtenerTexto(s, "Nombre: ");
        String apellido = obtenerTexto(s, "Apellido: ");
        String email = obtenerTexto(s, "Email: ");
        String dni = obtenerTexto(s, "DNI: ");
        Cliente cliente = new Cliente(nombre, apellido, email, dni, "Regular");
        System.out.println("\nFunciones:"); 
        int cnt = 1; 
        List<Funcion> funcs = new ArrayList<>();
        for (Cine cine : cines) {
            for (Sala sala : cine.getSalas()) {
                for (Funcion f : sala.getFunciones()) {
                    System.out.println(cnt + ". " + f.getPelicula().getNombre() + " - " + f.getFecha());
                    funcs.add(f);
                    cnt++;
                }
            }
        }
        if (funcs.isEmpty()) { System.out.println("Sin funciones."); return; }
        int funcIdx = obtenerEntero(s, "Funcion: ") - 1;
        Funcion func = funcs.get(funcIdx);
        Sala sala = func.getSala();
        System.out.println("\nMapa actual:"); System.out.println(sala.mostrarSala());
        List<Butaca> butacas = new ArrayList<>();
        ArrayList<Integer> filas = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        double total = 0;
        boolean continua = true;
        while (continua) {
            int fila = obtenerEntero(s, "Fila: ");
            int col = obtenerEntero(s, "Columna: ");
            Butaca b = sala.buscarButaca(fila, col);
            if (b != null) {
                butacas.add(b);
                filas.add(fila);
                cols.add(col);
                total += b.calcularPrecio();
                System.out.println("Butaca: " + b.getClass().getSimpleName() + " - $" + b.calcularPrecio());
            }
            System.out.print("Otra butaca? (s/n): ");
            if (!s.nextLine().equalsIgnoreCase("s")) continua = false;
        }
        sala.reservarButaca(filas, cols);
        Reserva res = new Reserva(new Date(), "Confirmada", total, cliente, null, func);
        for (Butaca b : butacas) res.getDetalleReserva().add(new DetalleReserva(0, b, b.calcularPrecio()));
        todasLasReservas.add(res);
        System.out.println("\n=== RESUMEN ===");
        System.out.println("Reserva: " + res.getNumero());
        System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("Pelicula: " + func.getPelicula().getNombre());
        System.out.println("Fecha: " + func.getFecha());
        System.out.println("\nButacas:");
        for (DetalleReserva d : res.getDetalleReserva()) {
            Butaca b = d.getButaca();
            System.out.println("  Fila " + b.getFila() + ", Col " + b.getColumna() + " - $" + b.calcularPrecio());
        }
        System.out.printf("Total: $%.2f\n", res.calcularTotal());
        System.out.println("\nMapa actualizado:"); System.out.println(sala.mostrarSala());
        System.out.printf("Ocupacion: %.2f%%\n", sala.calcularOcupacion());
    }

    static void consultarAdmin(Scanner s) {

        boolean enMenu = true;
        while (enMenu) {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1. Crear Nuevo Cine");
            System.out.println("2. Crear Nueva Sala");
            System.out.println("3. Crear Nueva Pelicula");
            System.out.println("4. Crear Nueva Funcion");
            System.out.println("5. Listar cines");
            System.out.println("6. Listar salas");
            System.out.println("7. Listar funciones");
            System.out.println("8. Ver ocupacion");
            System.out.println("9. Detalles cine");
            System.out.println("10. Volver");
            int op = obtenerEntero(s, "Opcion: ");
            switch (op) {
                case 1:
                    crearCine(scanner);
                    break;
                case 2:
                    crearSala(scanner);
                    break;
                case 3:
                    crearPelicula(scanner);
                    break;
                case 4:
                    crearFuncion(scanner);
                    break;
                case 5:
                    admin.listarCines();
                    break;
                case 6:
                    if (!admin.getCines().isEmpty()) {
                        for (int i = 0; i < admin.getCines().size(); i++) {
                            Cine cine = admin.getCines().get(i);
                            System.out.println((i + 1) + ". " + cine.getNombre());
                        }
                        int idx = obtenerEntero(s, "Cine: ") - 1;
                        admin.listarSalas(idx);
                    } else {
                        System.err.println("\nNo se encontró ningun cine para listar las salas");
                    }
                    break;
                case 7:
                    if (!cines.isEmpty()) {
                        for (int i = 0; i < cines.size(); i++) System.out.println((i + 1) + ". " + cines.get(i).getNombre());
                        int idx = obtenerEntero(s, "Cine: ") - 1;
                        Cine c = cines.get(idx);
                        if (!c.getSalas().isEmpty()) {
                            for (int i = 0; i < c.getSalas().size(); i++) System.out.println((i + 1) + ". Sala " + c.getSalas().get(i).getNumero());
                            int sIdx = obtenerEntero(s, "Sala: ") - 1;
                            admin.listarFunciones(idx, sIdx);
                        } else {
                            System.err.println("\nSala no encontrada\n");
                        }

                    }
                    break;
                case 8:
                    if (!admin.getCines().isEmpty()) {
                        for (int i = 0; i < admin.getCines().size(); i++) {
                            System.out.println((i + 1) + ". " + admin.getCines().get(i).getNombre());
                        }
                        int idx = obtenerEntero(s, "Cine: ") - 1;
                        Cine c = admin.getCines().get(idx);
                        if (!c.getSalas().isEmpty()) {
                            for (int i = 0; i < c.getSalas().size(); i++) System.out.println((i + 1) + ". Sala " + (c.getSalas().get(i).getNumero()+1));
                            int sIdx = obtenerEntero(s, "Sala: ") - 1;
                            System.out.println(c.getSalas().get(sIdx).calcularOcupacion()+"%");
                        }
                    }
                    break;
                case 9:
                    if (!cines.isEmpty()) {
                        for (int i = 0; i < cines.size(); i++) System.out.println((i + 1) + ". " + cines.get(i).getNombre());
                        int idx = obtenerEntero(s, "Cine: ") - 1;
                        admin.listarDetallesCine(idx);
                    }
                    break;
                case 10:
                    enMenu = false;
                    break;
            }
        }
    }
}