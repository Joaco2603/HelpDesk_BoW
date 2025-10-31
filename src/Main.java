import cr.ac.ucenfotec.tl.Controller;

public class Main {
    public static void main(String[] args) {
        // Punto de entrada principal del sistema HelpDesk
        // La interfaz de usuario estará en src_ui
        // Este Main será utilizado cuando se integre todo con JAR
        
        Controller controller = new Controller();
        
        // Por ahora solo inicializa el sistema
        System.out.println("Sistema HelpDesk - Business & Data Layer");
        System.out.println("La UI se encuentra en src_ui (separada)");
        System.out.println("Controller inicializado correctamente.");
    }
}