package ru.netology.manager;

import ru.netology.domain.AirTicket;
import ru.netology.repository.AitTicketRepository;

import java.util.Arrays;

public class AirTicketManager {
    private AitTicketRepository repository;

    public AirTicketManager(AitTicketRepository repository) {
        this.repository = repository;
    }

    public AirTicket[] findAll(String from, String to) {
        AirTicket[] allTickets = repository.getAll();
        AirTicket[] result = new AirTicket[0];

        for (AirTicket ticket : allTickets) {
            if (ticket.getFrom() .equals(from) && ticket.getTo() .equals(to)) {
                int length = result.length + 1;
                AirTicket[] tmp = new AirTicket[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;


    }
}
