package classesMap;

public class Ticket {
    private String ticketType;
    private String email;
    private String museum;

    public Ticket(String ticketType, String email, String museum) {
        this.ticketType = ticketType;
        this.email = email;
        this.museum =museum;
    }

    public String getTicketType() {
        return ticketType;
    }

    public String getEmail() {
        return email;
    }

    public String getMuseum() {
        return museum;
    }
}
