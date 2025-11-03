package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.bl.entities.Ticket;

import java.util.ArrayList;

public class DataTickets {
    private ArrayList<Ticket> tickets;

    public DataTickets() {
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
