package org.example;

public abstract class Ticket {
    protected int id;
    protected String requester;
    protected int priority;
    protected int daysOpen;

    public Ticket(int id, String requester, int priority, int daysOpen) {
        this.id = id;
        this.requester = requester;
        this.priority = priority;
        this.daysOpen = daysOpen;
    }

    public int getId() {
        return id;
    }

    // TODO #1 – Method Overloading
    public int estimateResolutionHours() {
        return priority * 4;
    }

    public int estimateResolutionHours(int complexity) {
        return priority * 4 + complexity * 2;
    }

    public int estimateResolutionHours(int complexity, int afterHours) {
        return priority * 4 + complexity * 2 + afterHours;
    }

    public abstract int urgencyScore();

    @Override
    public String toString() {
        return "Ticket{id=" + id +
                ", requester='" + requester + '\'' +
                ", priority=" + priority +
                ", daysOpen=" + daysOpen +
                ", urgency=" + urgencyScore() +
                '}';
    }
}
