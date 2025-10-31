import cr.ac.ucenfotec.ui.UI;
// import cr.ac.ucenfotec.tl.Controller; // Descomentar cuando se integre con JAR

public class MainUI {
    public static void main(String[] args) {
        // TODO: Integración pendiente con el JAR del proyecto principal (src)
        // Por ahora, este es solo el esqueleto de la UI
        
        UI ui = new UI();
        
        ui.mostrarBienvenida();
        ui.mostrarMensaje("╔════════════════════════════════════════════╗");
        ui.mostrarMensaje("║   PROYECTO EN DESARROLLO - UI LAYER        ║");
        ui.mostrarMensaje("║                                            ║");
        ui.mostrarMensaje("║   Esta es la capa de presentación del      ║");
        ui.mostrarMensaje("║   sistema HelpDesk.                        ║");
        ui.mostrarMensaje("║                                            ║");
        ui.mostrarMensaje("║   Para ejecutar el sistema completo:       ║");
        ui.mostrarMensaje("║   1. Compilar src como JAR                 ║");
        ui.mostrarMensaje("║   2. Agregar el JAR al classpath           ║");
        ui.mostrarMensaje("║   3. Descomentar import del Controller     ║");
        ui.mostrarMensaje("║   4. Implementar la lógica completa        ║");
        ui.mostrarMensaje("╚════════════════════════════════════════════╝");
        
        // Demostración de los menús disponibles
        ui.mostrarMensaje("\n=== DEMOSTRACIÓN DE MENÚS DISPONIBLES ===\n");
        
        ui.mostrarMenuAcceso();
        ui.mostrarMensaje("\n(Menú de acceso - Login/Registro)");
        
        ui.pausar();
        ui.limpiarPantalla();
        
        ui.mostrarMenuUsuario();
        ui.mostrarMensaje("\n(Menú para usuarios normales)");
        
        ui.pausar();
        ui.limpiarPantalla();
        
        ui.mostrarMenuSoporte();
        ui.mostrarMensaje("\n(Menú para personal de soporte)");
        
        ui.pausar();
        ui.limpiarPantalla();
        
        ui.mostrarMenuAdmin();
        ui.mostrarMensaje("\n(Menú para administradores)");
        
        ui.pausar();
        
        ui.mostrarExito("Estructura de UI lista para integración!");
        
        ui.cerrarScanner();
    }
}
