package org.example;

public class SoftwareTicket extends Ticket {
    private final String systemName;
    private final boolean securityIssue;
    private final boolean blocksAccess;

    public SoftwareTicket(int id, String requester, int priority, int daysOpen,
                          String systemName, boolean securityIssue, boolean blocksAccess) {
        super(id, requester, priority, daysOpen);
        this.systemName = systemName;
        this.securityIssue = securityIssue;
        this.blocksAccess = blocksAccess;
    }

    @Override
    public int urgencyScore() {
        int score = priority * 10 + daysOpen * 3;

        if (securityIssue) score += 25;
        if (blocksAccess) score += 15;

        return score;
    }
}
