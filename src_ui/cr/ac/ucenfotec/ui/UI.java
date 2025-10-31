package cr.ac.ucenfotec.ui;

import java.util.Scanner;

public class UI {
    private Scanner scanner;

    public UI() {
        scanner = new Scanner(System.in);
    }

    // ==================== MENÚS PRINCIPALES ====================
    
    public void mostrarBienvenida() {
        limpiarPantalla();
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║     SISTEMA DE HELPDESK - HELP DESK        ║");
        System.out.println("║          Gestión de Tickets de Soporte     ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println();
    }

    public void mostrarMenuAcceso() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│         MENÚ DE ACCESO              │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ 1. Iniciar Sesión                   │");
        System.out.println("│ 2. Registrarse                      │");
        System.out.println("│ 3. Salir                            │");
        System.out.println("└─────────────────────────────────────┘");
        System.out.print("Seleccione una opción: ");
    }

    public void mostrarMenuUsuario() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│         MENÚ USUARIO                │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ 1. Crear Nuevo Ticket               │");
        System.out.println("│ 2. Ver Mis Tickets                  │");
        System.out.println("│ 3. Ver Todos los Tickets            │");
        System.out.println("│ 4. Ver Departamentos                │");
        System.out.println("│ 5. Mi Perfil                        │");
        System.out.println("│ 6. Cerrar Sesión                    │");
        System.out.println("└─────────────────────────────────────┘");
        System.out.print("Seleccione una opción: ");
    }

    public void mostrarMenuSoporte() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│         MENÚ SOPORTE                │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ 1. Ver Todos los Tickets            │");
        System.out.println("│ 2. Ver Tickets por Estado           │");
        System.out.println("│ 3. Ver Tickets por Prioridad        │");
        System.out.println("│ 4. Actualizar Estado de Ticket      │");
        System.out.println("│ 5. Ver Estadísticas                 │");
        System.out.println("│ 6. Mi Perfil                        │");
        System.out.println("│ 7. Cerrar Sesión                    │");
        System.out.println("└─────────────────────────────────────┘");
        System.out.print("Seleccione una opción: ");
    }

    public void mostrarMenuAdmin() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│       MENÚ ADMINISTRADOR            │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ 1. Gestión de Usuarios              │");
        System.out.println("│ 2. Gestión de Departamentos         │");
        System.out.println("│ 3. Gestión de Tickets               │");
        System.out.println("│ 4. Ver Estadísticas                 │");
        System.out.println("│ 5. Reportes                         │");
        System.out.println("│ 6. Cerrar Sesión                    │");
        System.out.println("└─────────────────────────────────────┘");
        System.out.print("Seleccione una opción: ");
    }

    // ==================== SUBMENÚS ====================
    
    public void mostrarMenuGestionUsuarios() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│     GESTIÓN DE USUARIOS             │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ 1. Listar Usuarios                  │");
        System.out.println("│ 2. Cambiar Rol de Usuario           │");
        System.out.println("│ 3. Eliminar Usuario                 │");
        System.out.println("│ 4. Volver                           │");
        System.out.println("└─────────────────────────────────────┘");
        System.out.print("Seleccione una opción: ");
    }

    public void mostrarMenuGestionDepartamentos() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│   GESTIÓN DE DEPARTAMENTOS          │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ 1. Listar Departamentos             │");
        System.out.println("│ 2. Crear Departamento               │");
        System.out.println("│ 3. Modificar Departamento           │");
        System.out.println("│ 4. Eliminar Departamento            │");
        System.out.println("│ 5. Volver                           │");
        System.out.println("└─────────────────────────────────────┘");
        System.out.print("Seleccione una opción: ");
    }

    // ==================== MÉTODOS DE ENTRADA ====================
    
    public int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public String[] obtenerCredencialesLogin() {
        System.out.println("\n=== INICIAR SESIÓN ===");
        String correo = leerTexto("Correo: ");
        String password = leerTexto("Contraseña: ");
        return new String[]{correo, password};
    }

    public String[] obtenerDatosRegistro() {
        System.out.println("\n=== REGISTRO DE USUARIO ===");
        String nombre = leerTexto("Nombre completo: ");
        String correo = leerTexto("Correo: ");
        String password = leerTexto("Contraseña: ");
        String telefono = leerTexto("Teléfono: ");
        return new String[]{nombre, correo, password, telefono};
    }

    // ==================== MÉTODOS DE VISUALIZACIÓN ====================
    
    public void mostrarMensaje(String mensaje) {
        System.out.println("\n" + mensaje);
    }

    public void mostrarError(String mensaje) {
        System.out.println("\n❌ ERROR: " + mensaje);
    }

    public void mostrarExito(String mensaje) {
        System.out.println("\n✓ " + mensaje);
    }

    public void mostrarLoginExitoso(String nombreUsuario) {
        System.out.println("\n✓ Bienvenido/a " + nombreUsuario + "!");
        pausar();
    }

    public void mostrarLoginFallido() {
        System.out.println("\n❌ Credenciales incorrectas. Intente nuevamente.");
        pausar();
    }

    public void mostrarRegistroExitoso() {
        System.out.println("\n✓ Registro exitoso! Bienvenido al sistema.");
        pausar();
    }

    // ==================== MÉTODOS AUXILIARES ====================
    
    public void limpiarPantalla() {
        // En Windows: cls, en Unix: clear
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Si falla, simplemente imprime líneas en blanco
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    public void pausar() {
        System.out.print("\nPresione Enter para continuar...");
        scanner.nextLine();
    }

    public void cerrarScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
