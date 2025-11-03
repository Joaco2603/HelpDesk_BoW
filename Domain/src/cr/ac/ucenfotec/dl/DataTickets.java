package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.bl.entities.Ticket;

import java.util.ArrayList;

public class TicketsData {
    private ArrayList<Ticket> tickets;

    public TicketsData() {
        tickets = new ArrayList<>();
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
