package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AirTicket;
import ru.netology.repository.AitTicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketsManagerTest {

    private AitTicketRepository repository = new AitTicketRepository();
    private AirTicketManager manager = new AirTicketManager(repository);

    private AirTicket ticket1 = new AirTicket(1, 100, 60, "SOA", "JAK");
    private AirTicket ticket2 = new AirTicket(2, 210, 75, "SOA", "JAK");
    private AirTicket ticket3 = new AirTicket(3, 201, 66, "SOA", "JAK");
    private AirTicket ticket4 = new AirTicket(4, 406, 90, "JAK", "EUR");
    private AirTicket ticket5 = new AirTicket(5, 5050, 100, "SOA", "SAS");
    private AirTicket ticket6 = new AirTicket(6, 6080, 110, "SOA", "SAS");
    private AirTicket ticket7 = new AirTicket(7, 703, 120, "EUR", "SOA");

    @BeforeEach
    public void setup() {
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
        repository.save(ticket5);
        repository.save(ticket6);
        repository.save(ticket7);
    }

    @Test
    void shouldSortByTime() {
        AirTicket[] actual = manager.findAll("SOA", "JAK");
        AirTicket[] expected = new AirTicket[]{ticket1, ticket3, ticket2};
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(expected));
        //TODO еще вопросик, не могу понять почему именно работает сортировка через данные показатели цены, почему через скажем цена 100, 200,300 не дает сортировать?
        //TODO решил проверить работает ли отображение с ожидаемым и фактическим результатом, пока что разницы нет.
    }

    @Test
    void shouldNotFindWithWrongIata() {
        AirTicket[] actual = manager.findAll("GDX", "IST");
        AirTicket[] expected = new AirTicket[]{};
        assertArrayEquals(expected, actual);
        System.out.print(Arrays.toString(actual));
    }

    @Test
    void shouldFindWithCorrectIata() {
        AirTicket[] actual = manager.findAll("SOA", "SAS");
        AirTicket[] expected = new AirTicket[]{ticket5, ticket6};
        assertArrayEquals(expected, actual);
        System.out.print(Arrays.toString(actual));

    }

    @Test
    void shouldWrongFrom() {
        AirTicket[] actual = manager.findAll("", "SAS");
        AirTicket[] expected = new AirTicket[]{};
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));
    }
    @Test
    void shouldWrongTo() {
        AirTicket[] actual = manager.findAll("EUR", "");
        AirTicket[] expected = new AirTicket[]{};
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));
    }
}