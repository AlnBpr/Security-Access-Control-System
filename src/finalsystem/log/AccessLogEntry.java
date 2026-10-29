package finalsystem.log;

import java.time.LocalDateTime;

import finalsystem.model.Operation;
import finalsystem.model.Role;

public class AccessLogEntry {
    private final LocalDateTime timestamp;
    private final String userId;
    private final Role role;
    private final String resourceName;
    private final Operation operation;
    private final Decision decision;

    public AccessLogEntry(LocalDateTime timestamp, String userId, Role role,
                          String resourceName, Operation operation, Decision decision) {
        this.timestamp = timestamp;
        this.userId = userId;
        this.role = role;
        this.resourceName = resourceName;
        this.operation = operation;
        this.decision = decision;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public Role getRole() {
        return role;
    }

    public String getResourceName() {
        return resourceName;
    }

    public Operation getOperation() {
        return operation;
    }

    public Decision getDecision() {
        return decision;
    }

    @Override
    public String toString() {
        return timestamp + ", " + userId + ", " + role + ", "
                + resourceName + ", " + operation + ", " + decision;
    }
}
