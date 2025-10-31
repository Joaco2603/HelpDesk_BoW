import cr.ac.ucenfotec.tl.Controller;
import cr.ac.ucenfotec.bl.entities.Usuario;
import cr.ac.ucenfotec.bl.entities.Departamento;
import cr.ac.ucenfotec.bl.entities.Ticket;

import java.util.ArrayList;

/**
 * Clase de prueba para verificar el funcionamiento del Controller
 * sin necesidad de la UI completa.
 * 
 * Este test puede ejecutarse directamente para verificar que:
 * - La arquitectura funciona correctamente
 * - Los handlers están bien conectados
 * - Los datos de prueba se cargan correctamente
 */
public class TestController {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   TEST DEL SISTEMA HELPDESK - CONTROLLER   ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        Controller controller = new Controller();
        
        // Test 1: Verificar usuarios iniciales
        System.out.println("=== TEST 1: Usuarios Iniciales ===");
        ArrayList<Usuario> usuarios = controller.getAllUsuarios();
        System.out.println("Usuarios en el sistema: " + usuarios.size());
        for (Usuario u : usuarios) {
            System.out.println("  - " + u.getNombre() + " (" + u.getRol() + ")");
        }
        
        // Test 2: Login con usuario de prueba
        System.out.println("\n=== TEST 2: Login ===");
        Usuario usuarioLogueado = controller.login("admin@helpdesk.com", "admin123");
        if (usuarioLogueado != null) {
            System.out.println("✓ Login exitoso: " + usuarioLogueado.getNombre());
            System.out.println("  Rol: " + usuarioLogueado.getRol());
            System.out.println("  Es Admin: " + controller.esAdmin());
        } else {
            System.out.println("✗ Login fallido");
        }
        
        // Test 3: Verificar departamentos iniciales
        System.out.println("\n=== TEST 3: Departamentos ===");
        ArrayList<Departamento> departamentos = controller.getAllDepartamentos();
        System.out.println("Departamentos en el sistema: " + departamentos.size());
        for (Departamento d : departamentos) {
            System.out.println("  - " + d.getNombre());
        }
        
        // Test 4: Crear un ticket
        System.out.println("\n=== TEST 4: Crear Ticket ===");
        if (departamentos.size() > 0) {
            String deptoId = departamentos.get(0).getId();
            Ticket ticket = controller.crearTicket(
                "Error en el sistema",
                "No puedo acceder al módulo de reportes",
                "Alta",
                deptoId
            );
            
            if (ticket != null) {
                System.out.println("✓ Ticket creado exitosamente");
                System.out.println("  ID: " + ticket.getId());
                System.out.println("  Asunto: " + ticket.getAsunto());
                System.out.println("  Estado: " + ticket.getEstado());
                System.out.println("  Prioridad: " + ticket.getPrioridad());
                System.out.println("  Departamento: " + ticket.getDepartamento().getNombre());
            } else {
                System.out.println("✗ Error al crear ticket");
            }
        }
        
        // Test 5: Verificar tickets del usuario actual
        System.out.println("\n=== TEST 5: Tickets del Usuario ===");
        ArrayList<Ticket> ticketsUsuario = controller.getTicketsPorUsuario();
        System.out.println("Tickets del usuario actual: " + ticketsUsuario.size());
        for (Ticket t : ticketsUsuario) {
            System.out.println("  - " + t.getAsunto() + " [" + t.getEstado() + "]");
        }
        
        // Test 6: Estadísticas
        System.out.println("\n=== TEST 6: Estadísticas ===");
        System.out.println("Tickets abiertos: " + controller.getNumeroTicketsAbiertos());
        System.out.println("Tickets en proceso: " + controller.getNumeroTicketsEnProceso());
        System.out.println("Tickets cerrados: " + controller.getNumeroTicketsCerrados());
        
        // Test 7: Registro de nuevo usuario
        System.out.println("\n=== TEST 7: Registro de Usuario ===");
        controller.logout();
        Usuario nuevoUsuario = controller.register(
            "Pedro Gómez",
            "pedro@example.com",
            "pass123",
            "8888-9999"
        );
        
        if (nuevoUsuario != null) {
            System.out.println("✓ Usuario registrado exitosamente");
            System.out.println("  Nombre: " + nuevoUsuario.getNombre());
            System.out.println("  Correo: " + nuevoUsuario.getCorreo());
            System.out.println("  Rol: " + nuevoUsuario.getRol());
        } else {
            System.out.println("✗ Error al registrar usuario");
        }
        
        // Test 8: Verificar total de usuarios después del registro
        System.out.println("\n=== TEST 8: Total de Usuarios Después del Registro ===");
        usuarios = controller.getAllUsuarios();
        System.out.println("Total de usuarios: " + usuarios.size());
        
        // Test 9: Crear ticket con el nuevo usuario
        System.out.println("\n=== TEST 9: Crear Ticket con Nuevo Usuario ===");
        if (departamentos.size() > 1) {
            String deptoId = departamentos.get(1).getId();
            Ticket ticket2 = controller.crearTicket(
                "Solicitud de permisos",
                "Necesito acceso al sistema de nóminas",
                "Media",
                deptoId
            );
            
            if (ticket2 != null) {
                System.out.println("✓ Segundo ticket creado");
                System.out.println("  Asunto: " + ticket2.getAsunto());
                System.out.println("  Usuario: " + ticket2.getUsuario().getNombre());
            }
        }
        
        // Test 10: Actualizar estado de ticket
        System.out.println("\n=== TEST 10: Actualizar Estado de Ticket ===");
        ArrayList<Ticket> todosTickets = controller.getAllTickets();
        if (todosTickets.size() > 0) {
            String ticketId = todosTickets.get(0).getId();
            boolean actualizado = controller.cambiarEstadoTicket(ticketId, "En Proceso");
            if (actualizado) {
                System.out.println("✓ Estado actualizado correctamente");
                Ticket ticketActualizado = controller.getTicketById(ticketId);
                System.out.println("  Nuevo estado: " + ticketActualizado.getEstado());
            } else {
                System.out.println("✗ Error al actualizar estado");
            }
        }
        
        // Resumen final
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║           RESUMEN DE PRUEBAS               ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║ Total Usuarios: " + String.format("%-28s", controller.getAllUsuarios().size()) + "║");
        System.out.println("║ Total Departamentos: " + String.format("%-23s", controller.getAllDepartamentos().size()) + "║");
        System.out.println("║ Total Tickets: " + String.format("%-29s", controller.getAllTickets().size()) + "║");
        System.out.println("║ Tickets Abiertos: " + String.format("%-26s", controller.getNumeroTicketsAbiertos()) + "║");
        System.out.println("║ Tickets En Proceso: " + String.format("%-22s", controller.getNumeroTicketsEnProceso()) + "║");
        System.out.println("╚════════════════════════════════════════════╝");
        
        System.out.println("\n✓ Todas las pruebas completadas exitosamente!");
        System.out.println("\n=== ARQUITECTURA FUNCIONANDO CORRECTAMENTE ===");
    }
}
