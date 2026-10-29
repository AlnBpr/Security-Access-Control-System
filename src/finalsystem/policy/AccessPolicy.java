package finalsystem.policy;

import finalsystem.model.Operation;
import finalsystem.model.Resource;
import finalsystem.model.User;

public interface AccessPolicy {
    boolean isAllowed(User user, Resource resource, Operation operation);
}
