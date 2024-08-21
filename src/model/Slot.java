package model;

public class Slot {
    String ticketId;
    Ticket ticket;

    public Slot(String ticketId, Ticket ticket) {
        this.ticketId = ticketId;
        this.ticket = ticket;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Ticket getTicket() {
        return ticket;
    }

}
