package finalsystem.policy;

import finalsystem.model.AccessScope;
import finalsystem.model.Operation;
import finalsystem.model.Resource;
import finalsystem.model.Role;
import finalsystem.model.User;

public class RoleAccessPolicy implements AccessPolicy {

    @Override
    public boolean isAllowed(User user, Resource resource, Operation operation) {
        Role role = user.getRole();
        AccessScope scope = resource.getScope();

        switch (role) {
            case ADMIN:
                return true;

            case STAFF:
                if (operation == Operation.READ) {
                    return true;
                }
                return scope != AccessScope.CONFIDENTIAL;

            case STUDENT:
                if (operation == Operation.READ) {
                    return scope == AccessScope.PUBLIC || scope == AccessScope.INTERNAL;
                }
                return false;

            case GUEST:
                if (operation == Operation.READ) {
                    return scope == AccessScope.PUBLIC;
                }
                return false;

            default:
                return false;
        }
    }
}
