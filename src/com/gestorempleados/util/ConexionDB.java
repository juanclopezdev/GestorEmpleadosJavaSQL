package com.gestorempleados.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/gestor_empleados_db";
    // REEMPLAZA CON TUS CREDENCIALES
    private static final String USER = "root";
    private static final String PASSWORD = "12345";

    private static Connection connection = null;

    // Bloque estático para cargar el driver una sola vez
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("FATAL ERROR: Driver JDBC de MySQL no encontrado. Asegúrate de que el JAR está en las librerías.");
            // Lanzar una excepción aquí detendrá la aplicación si el driver no está, lo cual es bueno.
            throw new RuntimeException("Driver MySQL no encontrado", e);
        }
    }

    public static Connection obtenerConexion() {
        try {
            // Si la conexión es null o está cerrada, crear una nueva.
            if (connection == null || connection.isClosed()) {
                System.out.println("Conexión es null o está cerrada. Creando nueva conexión..."); // Mensaje de depuración
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión a la BD establecida/reestablecida exitosamente!");
            } else {
                System.out.println("Reutilizando conexión existente (ya estaba abierta)."); // Mensaje de depuración
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener/reabrir la conexión a la base de datos: " + e.getMessage());
            // Imprime la traza completa del error de SQL
            // Si hay un error, es mejor que 'connection' sea null para forzar un nuevo intento completo la próxima vez.
            connection = null;
        }
        return connection;
    }

    /**
     * Este método cierra la conexión ESTÁTICA compartida.
     * En general, con try-with-resources en los DAOs, este método
     * no debería ser llamado explícitamente durante el flujo normal de la aplicación,
     * A MENOS QUE sea al final de la aplicación o en un caso de error muy específico.
     * Los try-with-resources cierran la conexión que obtienen, y nuestro
     * obtenerConexion() la reabrirá si es necesario.
     */
    public static void cerrarConexionGlobal() { // Cambié el nombre para mayor claridad
        if (connection != null) {
            try {
                System.out.println("Cerrando la conexión global a la BD..."); // Mensaje de depuración
                connection.close();
                connection = null; // Importante: poner a null después de cerrar para que obtenerConexion() cree una nueva.
                System.out.println("Conexión global cerrada.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión global: " + e.getMessage());
            }
        }
    }

    // Este main es solo para pruebas directas de esta clase, puedes comentarlo o quitarlo luego.
    public static void main(String[] args) {
        Connection conn1 = ConexionDB.obtenerConexion();
        if (conn1 != null) {
            System.out.println("Prueba 1: Conexión obtenida.");
            // Simulamos que un DAO usa y cierra la conexión devuelta
            try {
                 conn1.close(); // Esto es lo que haría el try-with-resources en el DAO
                 System.out.println("Prueba 1: Conexión 'conn1' cerrada (simulando DAO). La estática 'connection' ahora está cerrada.");
            } catch (SQLException e) {
            }
        } else {
            System.out.println("Prueba 1: Fallo la obtención de conexión.");
        }
        
        System.out.println("\nIntentando obtener conexión de nuevo (debería reabrirse)...");
        Connection conn2 = ConexionDB.obtenerConexion();
         if (conn2 != null) {
            System.out.println("Prueba 2: Conexión obtenida exitosamente (reabierta o nueva).");
             try {
                 // Ejemplo de uso de la conexión conn2
                 if(!conn2.isClosed()){
                     System.out.println("Prueba 2: conn2 está abierta y lista para usarse.");
                     conn2.close(); // Cerrarla para la prueba
                 }
            } catch (SQLException e) {
            }
        } else {
            System.out.println("Prueba 2: Fallo la obtención de conexión.");
        }
        
        // Cierre final si es necesario para terminar la prueba del main
        // ConexionDB.cerrarConexionGlobal();
    }
}