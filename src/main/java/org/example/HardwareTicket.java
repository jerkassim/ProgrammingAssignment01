package org.example;
public class HardwareTicket extends Ticket {
    private final String deviceType;     // e.g., "Laptop", "Desktop", "Printer"
    private final boolean labCritical;    // true if affects a lab/classroom
    private final int affectedUsers;      // number of impacted users

    public HardwareTicket(int id, String requester, int priority, int daysOpen,
                          String deviceType, boolean labCritical, int affectedUsers) {
        super(id, requester, priority, daysOpen);
        if (affectedUsers < 0) throw new IllegalArgumentException("affectedUsers must be >= 0");
        this.deviceType = deviceType;
        this.labCritical = labCritical;
        this.affectedUsers = affectedUsers;
    }

    public String getDeviceType() { return deviceType; }
    public boolean isLabCritical() { return labCritical; }
    public int getAffectedUsers() { return affectedUsers; }

   @Override
public int urgencyScore() {
    int score = priority * 10 + daysOpen * 2;

    if (labCritical) {
        score += 20;
    }

    score += Math.min(affectedUsers, 30);

    if (deviceType.equalsIgnoreCase("Printer")) {
        score += 5;
    }

    return score;
}
----------------------------------------
    @Override
    public int urgencyScore() {
        // TODO #2
        return -1;
    }
}
