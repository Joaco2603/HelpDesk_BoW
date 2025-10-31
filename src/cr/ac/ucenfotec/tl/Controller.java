package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.handlers.UsuarioHandler;
import cr.ac.ucenfotec.bl.handlers.DepartamentoHandler;
import cr.ac.ucenfotec.bl.handlers.TicketHandler;
import cr.ac.ucenfotec.bl.entities.Usuario;
import cr.ac.ucenfotec.bl.entities.Departamento;
import cr.ac.ucenfotec.bl.entities.Ticket;

import java.util.ArrayList;

public class Controller {
    // Handlers para manejar las entidades
    private final UsuarioHandler usuarioHandler = new UsuarioHandler();
    private final DepartamentoHandler departamentoHandler = new DepartamentoHandler();
    private final TicketHandler ticketHandler = new TicketHandler();
    
    // Usuario actualmente autenticado
    private Usuario usuarioActual = null;
    private boolean isLogged = false;

    public Controller() {
    }

    // ==================== MÉTODOS DE AUTENTICACIÓN ====================
    
    public Usuario login(String correo, String password) {
        Usuario usuario = usuarioHandler.findUsuarioByCorreoAndPassword(correo, password);
        if (usuario != null) {
            this.usuarioActual = usuario;
            this.isLogged = true;
        }
        return usuario;
    }

    public Usuario register(String nombre, String correo, String password, String telefono) {
        // Verificar si el correo ya existe
        if (usuarioHandler.findUsuarioByCorreo(correo) != null) {
            return null; // El usuario ya existe
        }
        
        Usuario usuario = usuarioHandler.addUsuario(nombre, correo, password, telefono, "usuario");
        this.usuarioActual = usuario;
        this.isLogged = true;
        return usuario;
    }

    public void logout() {
        this.usuarioActual = null;
        this.isLogged = false;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public boolean isLogged() {
        return isLogged;
    }

    // ==================== MÉTODOS DE USUARIO ====================
    
    public ArrayList<Usuario> getAllUsuarios() {
        return usuarioHandler.getAllUsuarios();
    }

    public Usuario getUsuarioById(String id) {
        return usuarioHandler.findUsuarioById(id);
    }

    public boolean updateUsuario(Usuario usuario) {
        return usuarioHandler.updateUsuario(usuario);
    }

    public boolean deleteUsuario(String id) {
        return usuarioHandler.deleteUsuario(id);
    }

    public boolean cambiarRolUsuario(String usuarioId, String nuevoRol) {
        Usuario usuario = usuarioHandler.findUsuarioById(usuarioId);
        if (usuario != null) {
            usuario.setRol(nuevoRol);
            return usuarioHandler.updateUsuario(usuario);
        }
        return false;
    }

    // ==================== MÉTODOS DE DEPARTAMENTO ====================
    
    public Departamento crearDepartamento(String nombre, String descripcion, String contacto) {
        return departamentoHandler.addDepartamento(nombre, descripcion, contacto);
    }

    public ArrayList<Departamento> getAllDepartamentos() {
        return departamentoHandler.getAllDepartamentos();
    }

    public Departamento getDepartamentoById(String id) {
        return departamentoHandler.findDepartamentoById(id);
    }

    public Departamento getDepartamentoByNombre(String nombre) {
        return departamentoHandler.findDepartamentoByNombre(nombre);
    }

    public boolean updateDepartamento(Departamento departamento) {
        return departamentoHandler.updateDepartamento(departamento);
    }

    public boolean deleteDepartamento(String id) {
        return departamentoHandler.deleteDepartamento(id);
    }

    // ==================== MÉTODOS DE TICKET ====================
    
    public Ticket crearTicket(String asunto, String descripcion, String prioridad, String departamentoId) {
        if (!isLogged || usuarioActual == null) {
            return null; // Usuario no autenticado
        }
        
        Departamento departamento = departamentoHandler.findDepartamentoById(departamentoId);
        if (departamento == null) {
            return null; // Departamento no encontrado
        }
        
        return ticketHandler.createTicket(asunto, descripcion, prioridad, usuarioActual, departamento);
    }

    public ArrayList<Ticket> getAllTickets() {
        return ticketHandler.getAllTickets();
    }

    public ArrayList<Ticket> getTicketsPorUsuario() {
        if (!isLogged || usuarioActual == null) {
            return new ArrayList<>();
        }
        return ticketHandler.getTicketsByUsuario(usuarioActual.getId());
    }

    public ArrayList<Ticket> getTicketsPorUsuarioId(String usuarioId) {
        return ticketHandler.getTicketsByUsuario(usuarioId);
    }

    public ArrayList<Ticket> getTicketsPorDepartamento(String departamentoId) {
        return ticketHandler.getTicketsByDepartamento(departamentoId);
    }

    public ArrayList<Ticket> getTicketsPorEstado(String estado) {
        return ticketHandler.getTicketsByEstado(estado);
    }

    public ArrayList<Ticket> getTicketsPorPrioridad(String prioridad) {
        return ticketHandler.getTicketsByPrioridad(prioridad);
    }

    public Ticket getTicketById(String id) {
        return ticketHandler.findTicketById(id);
    }

    public boolean updateTicket(Ticket ticket) {
        return ticketHandler.updateTicket(ticket);
    }

    public boolean cambiarEstadoTicket(String ticketId, String nuevoEstado) {
        return ticketHandler.updateEstadoTicket(ticketId, nuevoEstado);
    }

    public boolean deleteTicket(String id) {
        return ticketHandler.deleteTicket(id);
    }

    // ==================== MÉTODOS DE VALIDACIÓN Y PERMISOS ====================
    
    public boolean esAdmin() {
        return isLogged && usuarioActual != null && usuarioActual.getRol().equalsIgnoreCase("admin");
    }

    public boolean esSoporte() {
        return isLogged && usuarioActual != null && usuarioActual.getRol().equalsIgnoreCase("soporte");
    }

    public boolean esUsuario() {
        return isLogged && usuarioActual != null && usuarioActual.getRol().equalsIgnoreCase("usuario");
    }

    // ==================== MÉTODOS DE ESTADÍSTICAS ====================
    
    public int getNumeroTicketsAbiertos() {
        return ticketHandler.getTicketsByEstado("Abierto").size();
    }

    public int getNumeroTicketsEnProceso() {
        return ticketHandler.getTicketsByEstado("En Proceso").size();
    }

    public int getNumeroTicketsCerrados() {
        return ticketHandler.getTicketsByEstado("Cerrado").size();
    }

    public int getNumeroTicketsPorPrioridad(String prioridad) {
        return ticketHandler.getTicketsByPrioridad(prioridad).size();
    }
}
