package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.Ticket;
import cr.ac.ucenfotec.bl.entities.Usuario;
import cr.ac.ucenfotec.bl.entities.Departamento;
import cr.ac.ucenfotec.dl.DataTickets;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class GestorTicket {
    private DataTickets dataTickets;

    public GestorTicket() {
        dataTickets = new DataTickets();
    }

    public Ticket createTicket(int id, String asunto, String descripcion, String prioridad, Usuario usuario, Departamento departamento) {
        String estado = "Abierto";
        Ticket ticket = new Ticket(id, asunto, descripcion, estado, prioridad, usuario, departamento);
        dataTickets.addTicket(ticket);
        return ticket;
    }

    public Ticket findTicketById(int id) {
        for (Ticket ticket : dataTickets.getTickets()) {
            if (ticket.getId() == id) {
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
            if (String.valueOf(ticket.getDepartamento().getId()).equals(departamentoId)) {
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
            if (tickets.get(i).getId() == ticket.getId()) {
                tickets.set(i, ticket);
                return true;
            }
        }
        return false;
    }

    public boolean updateEstadoTicket(int ticketId, String nuevoEstado) {
        Ticket ticket = findTicketById(ticketId);
        if (ticket != null) {
            ticket.setEstado(nuevoEstado);
            return updateTicket(ticket);
        }
        return false;
    }

    public boolean deleteTicket(int id) {
        ArrayList<Ticket> tickets = dataTickets.getTickets();
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getId() == id) {
                tickets.remove(i);
                return true;
            }
        }
        return false;
    }
}
