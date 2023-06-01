package JavaMavenNetology.JavaMavenNetology_11.ticketManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ManagerTest {

    @Test
    public void sortTickets() {
        TicketRepo repo = new TicketRepo();
        Manager manager = new Manager(repo);

        Ticket ticket_1 = new Ticket(1, "MSK", "SPB", 110, 60);
        Ticket ticket_2 = new Ticket(2, "MSK", "SPB", 90, 66);
        Ticket ticket_3 = new Ticket(3, "MSK", "SPB", 110, 59);
        Ticket ticket_4 = new Ticket(4, "MSK", "SPB", 200, 60);
        Ticket ticket_5 = new Ticket(5, "MSK", "SPB", 88, 55);
        Ticket ticket_6 = new Ticket(6, "SPB", "LA", 1000, 600);

        manager.add(ticket_1);
        manager.add(ticket_2);
        manager.add(ticket_3);
        manager.add(ticket_4);
        manager.add(ticket_5);
        manager.add(ticket_6);

        Ticket[] expected = {ticket_5, ticket_2, ticket_1, ticket_3, ticket_4};
        Ticket[] actual = manager.findAll("MSK", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void oneTickets() {
        TicketRepo repo = new TicketRepo();
        Manager manager = new Manager(repo);

        Ticket ticket_1 = new Ticket(1, "MSK", "SPB", 110, 60);
        Ticket ticket_2 = new Ticket(2, "MSK", "SPB", 90, 66);
        Ticket ticket_3 = new Ticket(3, "MSK", "SPB", 110, 59);
        Ticket ticket_4 = new Ticket(4, "MSK", "SPB", 200, 60);
        Ticket ticket_5 = new Ticket(5, "MSK", "SPB", 88, 55);
        Ticket ticket_6 = new Ticket(6, "SPB", "LA", 1000, 600);

        manager.add(ticket_1);
        manager.add(ticket_2);
        manager.add(ticket_3);
        manager.add(ticket_4);
        manager.add(ticket_5);
        manager.add(ticket_6);

        Ticket[] expected = {ticket_6};
        Ticket[] actual = manager.findAll("SPB", "LA");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notFoundTickets() {
        TicketRepo repo = new TicketRepo();
        Manager manager = new Manager(repo);

        Ticket ticket_1 = new Ticket(1, "MSK", "SPB", 110, 60);
        Ticket ticket_2 = new Ticket(2, "MSK", "SPB", 90, 66);
        Ticket ticket_3 = new Ticket(3, "MSK", "SPB", 110, 59);
        Ticket ticket_4 = new Ticket(4, "MSK", "SPB", 200, 60);
        Ticket ticket_5 = new Ticket(5, "MSK", "SPB", 88, 55);
        Ticket ticket_6 = new Ticket(6, "SPB", "LA", 1000, 600);

        manager.add(ticket_1);
        manager.add(ticket_2);
        manager.add(ticket_3);
        manager.add(ticket_4);
        manager.add(ticket_5);
        manager.add(ticket_6);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("MSK", "LA");

        Assertions.assertArrayEquals(expected, actual);
    }
}