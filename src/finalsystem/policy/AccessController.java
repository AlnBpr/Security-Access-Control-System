package finalsystem.policy;

import finalsystem.capability.Capability;
import finalsystem.capability.Read;
import finalsystem.capability.Write;
import finalsystem.log.AccessLogger;
import finalsystem.log.Decision;
import finalsystem.model.Operation;
import finalsystem.model.Resource;
import finalsystem.model.User;

public class AccessController {
    private final AccessPolicy policy;
    private final AccessLogger logger;

    public AccessController(AccessPolicy policy, AccessLogger logger) {
        this.policy = policy;
        this.logger = logger;
    }

    public boolean canAccess(User user, Resource resource, Operation operation) {
        boolean allowed = policy.isAllowed(user, resource, operation);

        logger.log(
                user,
                resource,
                operation,
                allowed ? Decision.ALLOW : Decision.REFUSE
        );

        return allowed;
    }

    public Capability<Read> requestReadCapability(User user, Resource resource) {
        if (canAccess(user, resource, Operation.READ)) {
            return new Capability<>(resource.getName());
        }
        return null;
    }

    public Capability<Write> requestWriteCapability(User user, Resource resource) {
        if (canAccess(user, resource, Operation.WRITE)) {
            return new Capability<>(resource.getName());
        }
        return null;
    }
}

