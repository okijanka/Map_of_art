package classesMap;

public class Ticket {
    private String ticketType;
    private String email;
    private Museum museum;

    public Ticket(String ticketType, String email, Museum museum) {
        this.ticketType = ticketType;
        this.email = email;
        this.museum = museum;
    }

    public String isTicketType() {
        return ticketType;
    }

    public String getEmail() {
        return email;
    }

    public Museum getMuseum() {
        return museum;
    }
}
