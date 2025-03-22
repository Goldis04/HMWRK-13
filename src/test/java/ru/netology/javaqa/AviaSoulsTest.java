package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;


class AviaSoulsTest {
    @Test
    public void testInTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                35_000,
                15_10,
                18_45
        );
        Ticket ticket2 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                30_000,
                19_10,
                22_45
        );
        Ticket ticket3 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                35_000,
                15_10,
                18_45
        );
        Ticket ticket4 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                37_000,
                19_10,
                22_45
        );
        Ticket ticket5 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                40_000,
                19_10,
                22_45
        );
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("Москва", "Санкт-Петербург");
        Ticket[] expected = {ticket2, ticket4, ticket5};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testInTicketNull() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                35_000,
                15_10,
                18_45
        );
        Ticket ticket2 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                30_000,
                19_10,
                22_45
        );
        Ticket ticket3 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                35_000,
                15_10,
                18_45
        );
        Ticket ticket4 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                37_000,
                19_10,
                22_45
        );
        Ticket ticket5 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                40_000,
                19_10,
                22_45
        );
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("Москва", "Екатеринбург");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testInTicketOne() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                35_000,
                15_10,
                18_45
        );
        Ticket ticket2 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                30_000,
                19_10,
                22_45
        );
        Ticket ticket3 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                35_000,
                15_10,
                18_45
        );
        Ticket ticket4 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                37_000,
                19_10,
                22_45
        );
        Ticket ticket5 = new Ticket(
                "Москва",
                "Хайнань",
                40_000,
                19_10,
                22_45
        );
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("Москва", "Хайнань");
        Ticket[] expected = {ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                35_000,
                15,
                18_45
        );
        Ticket ticket2 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                30_000,
                19,
                16
        );
        Ticket ticket3 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                35_000,
                15,
                10
        );
        Ticket ticket4 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                37_000,
                9,
                12
        );
        Ticket ticket5 = new Ticket(
                "Москва",
                "Хайнань",
                40_000,
                19,
                22
        );
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("Москва", "Санкт-Петербург", comparator);
        Ticket[] expected = {ticket4, ticket3, ticket2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortComparatorOne() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                35_000,
                15,
                18_45
        );
        Ticket ticket2 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                30_000,
                19,
                16
        );
        Ticket ticket3 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                35_000,
                15,
                10
        );
        Ticket ticket4 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                37_000,
                9,
                12
        );
        Ticket ticket5 = new Ticket(
                "Москва",
                "Хайнань",
                40_000,
                19,
                22
        );
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("Москва", "Хайнань", comparator);
        Ticket[] expected = {ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortComparatorNot() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                35_000,
                15,
                18_45
        );
        Ticket ticket2 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                30_000,
                19,
                16
        );
        Ticket ticket3 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                35_000,
                15,
                10
        );
        Ticket ticket4 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                37_000,
                9,
                12
        );
        Ticket ticket5 = new Ticket(
                "Москва",
                "Хайнань",
                40_000,
                19,
                22
        );
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("Москва", "Екатеренбург", comparator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
}