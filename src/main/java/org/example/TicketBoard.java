package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class TicketBoard {
    private Ticket[] tickets;
    private int size;

    public TicketBoard(int capacity) {
        tickets = new Ticket[capacity];
        size = 0;
    }

    public void add(Ticket ticket) {
        tickets[size++] = ticket;
    }

    public Ticket get(int index) {
        return tickets[index];
    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.println(tickets[i]);
        }
    }

    public void sortByUrgencyDesc() {
        Arrays.sort(tickets, 0, size,
                (a, b) -> Integer.compare(b.urgencyScore(), a.urgencyScore()));
    }

    public void sortByIdAsc() {
        Arrays.sort(tickets, 0, size,
                Comparator.comparingInt(Ticket::getId));
    }

    // TODO #4 – Binary Search
    public Ticket findByIdBinarySearch(int id) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midId = tickets[mid].getId();

            if (midId == id) {
                return tickets[mid];
            } else if (midId < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
