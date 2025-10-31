package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.bl.entities.Ticket;
import cr.ac.ucenfotec.bl.entities.Usuario;
import cr.ac.ucenfotec.bl.entities.Departamento;

import java.util.ArrayList;

public class TicketsData {
    private ArrayList<Ticket> tickets;

    public TicketsData() {
        tickets = new ArrayList<>();
        // Inicialización sin datos de prueba por ahora
        // Los tickets se crearán dinámicamente
    }

    public void addTicket(Ticket ticket) {
        if (tickets == null) {
            tickets = new ArrayList<>();
        }
        tickets.add(ticket);
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
}
