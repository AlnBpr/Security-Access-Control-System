package finalsystem.app;

import finalsystem.capability.Capability;
import finalsystem.capability.Read;
import finalsystem.capability.Write;
import finalsystem.log.AccessLogger;
import finalsystem.model.AccessScope;
import finalsystem.model.Resource;
import finalsystem.model.Role;
import finalsystem.model.User;
import finalsystem.policy.AccessController;
import finalsystem.policy.RoleAccessPolicy;

public class FinalSystemRunner {

    public static void main(String[] args) {
        AccessLogger logger = new AccessLogger();
        RoleAccessPolicy policy = new RoleAccessPolicy();
        AccessController controller = new AccessController(policy, logger);

        User guest = new User("u1", Role.GUEST);
        User student = new User("u2", Role.STUDENT);
        User staff = new User("u3", Role.STAFF);
        User admin = new User("u4", Role.ADMIN);

        Resource lectureMaterial = new Resource("Lecture Material", AccessScope.PUBLIC, "Week 1 Notes");
        Resource printer = new Resource("Printer", AccessScope.INTERNAL, "Printer Queue");
        Resource examPaper = new Resource("Exam Paper", AccessScope.CONFIDENTIAL, "Original Exam Questions");

        System.out.println("Combined Final System Demo");

        performRead(controller, guest, lectureMaterial);
        performRead(controller, guest, examPaper);

        performRead(controller, student, printer);
        performWrite(controller, student, printer, "Updated Printer Queue");

        performRead(controller, staff, examPaper);
        performWrite(controller, staff, examPaper, "Staff Attempt To Edit Exam");

        performWrite(controller, admin, examPaper, "Approved Final Exam Paper");
        performRead(controller, admin, examPaper);
    }

    private static void performRead(AccessController controller, User user, Resource resource) {
        Capability<Read> readCapability = controller.requestReadCapability(user, resource);

        if (readCapability != null && readCapability.appliesTo(resource.getName())) {
            System.out.println(user.getRole() + " read " + resource.getName() + ": " + resource.getData());
        } else {
            System.out.println(user.getRole() + " was denied READ on " + resource.getName());
        }
    }

    private static void performWrite(AccessController controller, User user, Resource resource, String newData) {
        Capability<Write> writeCapability = controller.requestWriteCapability(user, resource);

        if (writeCapability != null && writeCapability.appliesTo(resource.getName())) {
            resource.setData(newData);
            System.out.println(user.getRole() + " wrote to " + resource.getName() + ": " + resource.getData());
        } else {
            System.out.println(user.getRole() + " was denied WRITE on " + resource.getName());
        }
    }
}

