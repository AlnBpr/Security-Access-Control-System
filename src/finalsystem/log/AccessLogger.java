package finalsystem.log;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import finalsystem.model.Operation;
import finalsystem.model.Resource;
import finalsystem.model.User;

public class AccessLogger {
    private final List<AccessLogEntry> entries = new ArrayList<>();

    public void log(User user, Resource resource, Operation operation, Decision decision) {
        AccessLogEntry entry = new AccessLogEntry(
                LocalDateTime.now(),
                user.getId(),
                user.getRole(),
                resource.getName(),
                operation,
                decision
        );

        entries.add(entry);
        System.out.println(entry);
    }

    public List<AccessLogEntry> getEntries() {
        return Collections.unmodifiableList(entries);
    }
}
