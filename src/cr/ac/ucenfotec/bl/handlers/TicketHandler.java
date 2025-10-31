package cr.ac.ucenfotec.bl.handlers;

import cr.ac.ucenfotec.bl.entities.Ticket;
import cr.ac.ucenfotec.bl.entities.Usuario;
import cr.ac.ucenfotec.bl.entities.Departamento;
import cr.ac.ucenfotec.dl.TicketsData;

import java.util.ArrayList;
import java.util.UUID;
import java.time.LocalDateTime;

public class TicketHandler {
    private TicketsData dataTickets;

    public TicketHandler() {
        dataTickets = new TicketsData();
    }

    public Ticket createTicket(String asunto, String descripcion, String prioridad, Usuario usuario, Departamento departamento) {
        String estado = "Abierto";
        Ticket ticket = new Ticket(UUID.randomUUID().toString(), asunto, descripcion, estado, prioridad, usuario, departamento);
        dataTickets.addTicket(ticket);
        return ticket;
    }

    public Ticket findTicketById(String id) {
        for (Ticket ticket : dataTickets.getTickets()) {
            if (ticket.getId().equals(id)) {
                return ticket;
            }
        }
        return null;
    }

    public ArrayList<Ticket> getTicketsByUsuario(String usuarioId) {
        ArrayList<Ticket> ticketsUsuario = new ArrayList<>();
        for (Ticket ticket : dataTickets.getTickets()) {
            if (ticket.getUsuario().getId().equals(usuarioId)) {
                ticketsUsuario.add(ticket);
            }
        }
        return ticketsUsuario;
    }

    public ArrayList<Ticket> getTicketsByDepartamento(String departamentoId) {
        ArrayList<Ticket> ticketsDepartamento = new ArrayList<>();
        for (Ticket ticket : dataTickets.getTickets()) {
            if (ticket.getDepartamento().getId().equals(departamentoId)) {
                ticketsDepartamento.add(ticket);
            }
        }
        return ticketsDepartamento;
    }

    public ArrayList<Ticket> getTicketsByEstado(String estado) {
        ArrayList<Ticket> ticketsEstado = new ArrayList<>();
        for (Ticket ticket : dataTickets.getTickets()) {
            if (ticket.getEstado().equalsIgnoreCase(estado)) {
                ticketsEstado.add(ticket);
            }
        }
        return ticketsEstado;
    }

    public ArrayList<Ticket> getTicketsByPrioridad(String prioridad) {
        ArrayList<Ticket> ticketsPrioridad = new ArrayList<>();
        for (Ticket ticket : dataTickets.getTickets()) {
            if (ticket.getPrioridad().equalsIgnoreCase(prioridad)) {
                ticketsPrioridad.add(ticket);
            }
        }
        return ticketsPrioridad;
    }

    public ArrayList<Ticket> getAllTickets() {
        return dataTickets.getTickets();
    }

    public boolean updateTicket(Ticket ticket) {
        ticket.setFechaActualizacion(LocalDateTime.now());
        ArrayList<Ticket> tickets = dataTickets.getTickets();
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getId().equals(ticket.getId())) {
                tickets.set(i, ticket);
                return true;
            }
        }
        return false;
    }

    public boolean updateEstadoTicket(String ticketId, String nuevoEstado) {
        Ticket ticket = findTicketById(ticketId);
        if (ticket != null) {
            ticket.setEstado(nuevoEstado);
            return updateTicket(ticket);
        }
        return false;
    }

    public boolean deleteTicket(String id) {
        ArrayList<Ticket> tickets = dataTickets.getTickets();
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getId().equals(id)) {
                tickets.remove(i);
                return true;
            }
        }
        return false;
    }
}
