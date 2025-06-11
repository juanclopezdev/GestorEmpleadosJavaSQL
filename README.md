# Gestor de Empleados App (Java Swing & SQL)

Este proyecto es una aplicación de escritorio simple para la gestión de empleados, desarrollada como parte de mi portafolio para demostrar habilidades en Java, Swing para la interfaz gráfica (GUI) y JDBC para la interacción con bases de datos SQL.

## Descripción General

La aplicación permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre una base de datos de empleados. Es un proyecto base que puede ser extendido con más funcionalidades.

## Tecnologías Utilizadas

*   **Lenguaje:** Java (JDK 8 o superior)
*   **IDE:** Apache NetBeans IDE
*   **Interfaz Gráfica (GUI):** Java Swing
*   **Base de Datos:** MySQL (configurable para otras bases de datos SQL compatibles con JDBC)
*   **Conexión a Base de Datos:** JDBC (MySQL Connector/J)
*   **Gestión de Dependencias/Construcción:** Apache Ant (integrado en NetBeans para proyectos Java SE)
*   **Control de Versiones:** Git & GitHub

## Características Principales

*   **Registro de Nuevos Empleados:** Permite ingresar la información de un nuevo empleado (Nombre, Apellido, Puesto, Salario, Fecha de Contratación).
*   **Listado de Empleados:** Muestra todos los empleados registrados en una tabla.
*   **Actualización de Datos:** Permite modificar la información de un empleado existente.
*   **Eliminación de Empleados:** Permite borrar el registro de un empleado de la base de datos.
*   **Interfaz Gráfica Intuitiva:** Campos de texto con texto guía (placeholder) para mejorar la usabilidad.
*   **Conexión Centralizada a BD:** Utiliza una clase de utilidad para gestionar la conexión a la base de datos.
*   **Separación de Capas (Básica):**
    *   **GUI (`com.gestorempleados.gui`):** Clases para la interfaz de usuario.
    *   **DAO (`com.gestorempleados.dao`):** Clases para el acceso a datos.
    *   **Modelo (`com.gestorempleados.model`):** Clases de entidad (Empleado).
    *   **Utilidades (`com.gestorempleados.util`):** Clase de conexión a BD.

## Requisitos Previos

*   Java Development Kit (JDK) 8 o superior instalado.
*   Apache NetBeans IDE (opcional, si se quiere modificar el código fácilmente).
*   Servidor de Base de Datos MySQL (u otro compatible con el driver JDBC utilizado) en ejecución.
*   Git (para clonar el repositorio).

## Configuración

1.  **Clonar el Repositorio:**
    ```bash
    git clone https://github.com/juanclopezdev/GestorEmpleadosJavaSQL.git
    cd NombreDelRepositorio
    ```

2.  **Configurar la Base de Datos:**
    *   Asegúrate de tener MySQL Server instalado y en ejecución.
    *   Crea una base de datos llamada `gestor_empleados_db`.
        ```sql
        CREATE DATABASE gestor_empleados_db;
        USE gestor_empleados_db;
        ```
    *   Ejecuta el siguiente script SQL para crear la tabla `empleados`:
        ```sql
        CREATE TABLE empleados (
            id INT AUTO_INCREMENT PRIMARY KEY,
            nombre VARCHAR(100) NOT NULL,
            apellido VARCHAR(100) NOT NULL,
            puesto VARCHAR(100),
            salario DECIMAL(10, 2),
            fecha_contratacion DATE
        );
        ```

3.  **Configurar la Conexión a la Base de Datos en el Código:**
    *   Abre el proyecto en NetBeans (o tu IDE preferido).
    *   Navega al archivo `src/com/gestorempleados/util/ConexionDB.java`.
    *   Modifica las siguientes constantes con tus credenciales de MySQL:
        ```java
        private static final String USER = "root";
        private static final String PASSWORD = "12345";
        // Asegúrate que la URL sea correcta para tu servidor MySQL
        // private static final String URL = "jdbc:mysql://localhost:3306/gestor_empleados_db";
        ```

4.  **Asegurar el Conector JDBC:**
    *   Este proyecto espera que el `mysql-connector-java-X.X.XX.jar` esté añadido a las librerías del proyecto en NetBeans. Si no está, descárgalo del sitio oficial de MySQL y agrégalo.

## Cómo Ejecutar

1.  Abre el proyecto en Apache NetBeans IDE.
2.  Haz "Clean and Build" del proyecto (Clic derecho en el proyecto > Clean and Build).
3.  Ejecuta la clase principal `com.gestorempleados.gui.FrmPrincipal` (Clic derecho en el proyecto > Run, o clic derecho en `FrmPrincipal.java` > Run File).

## Estructura del Proyecto