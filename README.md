# 🎬 Sistema de Reservas de Cine en Java

Este proyecto es una aplicación de consola en **Java** que simula la gestión de butacas en una sala de cine.  
Permite reservar asientos, mostrar el mapa actualizado y calcular el porcentaje de ocupación.

---

## 🚀 Características principales
- Representación de la sala mediante una **matriz de caracteres**:
  - `L` → Libre
  - `X` → Ocupada
- Muestra un **mapa visual** con filas y columnas numeradas.
- Menú interactivo:
  - Reservar una o varias butacas.
  - Salir del programa.
- Validación de entradas:
  - Evita reservas fuera de rango.
  - No permite reservar butacas ya ocupadas.
- Cálculo del **porcentaje de ocupación** de la sala.
- Finaliza automáticamente cuando la sala está llena.

---

## 📂 Estructura del proyecto
- `Cine.java` → Contiene toda la lógica del programa:
  - Inicialización de la sala.
  - Métodos para mostrar el mapa, reservar butacas y calcular ocupación.
  - Bucle principal con menú interactivo.

---

## 🖥️ Ejemplo de uso
Al iniciar el programa:

-----------Bienvenido al sistema de gestión de Cines-----------
Ingrese la cantidad de filas que tiene la sala:
5
Ingrese la cantidad de columnas que tiene la sala:
8
-----------MAPA DE BUTACAS-----------
1 2 3 4 5 6 7 8
1  L L L L L L L L
2  L L L L L L L L
3  L L L L L L L L
4  L L L L L L L L
5  L L L L L L L L
Porcentaje de ocupación de la sala: 0.0%

-----------MENU-----------

Reservar una butaca

Salir

Después de reservar, el mapa se actualiza y se muestra el porcentaje de ocupación.

---

## 🛠️ Instalación y ejecución
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/tuusuario/cine-reservas.git
Compilar el archivo:

bash
javac Cine.java
Ejecutar el programa:

bash
java Cine
📈 Posibles mejoras futuras
Mostrar cantidad de butacas libres y ocupadas.

Asignar precios diferentes por fila y calcular el total.

Permitir cancelar reservas.

Manejo avanzado de errores (ej. entradas no numéricas).

Persistencia de datos (guardar reservas en archivo o base de datos).

🤝 Contribuciones
¡Las contribuciones son bienvenidas!
Podés hacer un fork del repositorio, crear una rama con tus mejoras y abrir un pull request.

📜 Licencia
Este proyecto se distribuye bajo la licencia MIT.
Podés usarlo libremente para aprender, modificar y compartir.
