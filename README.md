# 🎬 Sistema de Reservas de Cine

Sistema de gestión de butacas para una sala de cine, desarrollado en **Java** como parte de mi aprendizaje en programación orientada a objetos y manejo de arreglos bidimensionales.  
El programa permite visualizar el mapa de butacas, realizar reservas y manejar errores básicos.

---

## 📋 Características

- ✅ Mapa interactivo de **5 filas × 8 columnas**.
- ✅ Reserva de butacas con validación de disponibilidad.
- ✅ Validación de entradas (rangos de filas y columnas).
- ✅ Menú cíclico hasta que el usuario decida salir.
- ✅ Código modularizado en métodos para mayor claridad.
- ✅ Constantes para evitar números mágicos.

---

## 🚀 Cómo ejecutarlo

### Requisitos
- Java 11 o superior.
- Un IDE (IntelliJ IDEA, Eclipse, VS Code) o terminal con `javac` y `java`.

### Pasos
1. Cloná el repositorio:
   ```bash
   git clone https://github.com/thomiperezz/Mini-proyecto-de-reservas---Cine.git
Abrí la carpeta en tu IDE o terminal.

Compilá el programa:

bash
javac Cine.java
Ejecutalo:

bash
java Cine
🧩 Estructura del código
El proyecto está organizado en una sola clase principal Cine, con métodos que separan responsabilidades:

Método	Descripción
main	Controla el flujo del programa (menú, bucle).
inicializarButacas	Llena la matriz con 'L' (libre).
mostrarMapa	Imprime el mapa con números de fila y columna.
reservarButaca	Gestiona la entrada de datos y modifica la matriz si es válido.
🛠️ Tecnologías utilizadas
Java – Lenguaje base.

Scanner – Para entrada de datos por consola.

Arreglos bidimensionales – Representación de la sala.

📌 Próximas mejoras (en progreso)
Mostrar cantidad de butacas libres y porcentaje de ocupación.

Reservas múltiples en una sola operación.

Precios por fila y cálculo total a pagar.

Persistencia en archivo o base de datos.

👤 Autor
thomi.bash

GitHub: @thomiperezz

LinkedIn (opcional)

📄 Licencia
Este proyecto está bajo la licencia MIT. Podés usarlo y modificarlo libremente.

⭐ Si te gustó este proyecto, no olvides dejar una estrella en GitHub.
¡Gracias por visitar!
