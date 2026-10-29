package finalsystem.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import finalsystem.capability.*;
import finalsystem.log.*;
import finalsystem.model.*;
import finalsystem.policy.*;

public class Finalsystemtest {
	
	@Test
	public void testStudentConfidential() {
		AccessLogger logger = new AccessLogger();
		RoleAccessPolicy policy = new RoleAccessPolicy();
		AccessController controller = new AccessController(policy, logger);
		
		User student = new User("user1", Role.STUDENT);
		Resource exam = new Resource("Exam Paper", AccessScope.CONFIDENTIAL, "Private");
		
		Capability<Write> cap = controller.requestWriteCapability(student, exam);
		assertNull(cap);
	}
	
	@Test
	public void testStudentInternal() {
		AccessLogger logger = new AccessLogger();
		RoleAccessPolicy policy = new RoleAccessPolicy();
		AccessController controller = new AccessController(policy, logger);
		
		User student = new User("user2", Role.STUDENT);
		Resource printer = new Resource("Printer", AccessScope.INTERNAL, "Queue");
		
		Capability<Read> cap = controller.requestReadCapability(student, printer);
		assertNotNull(cap);
	}
	
	@Test
	public void testAdminAccess() {
		AccessLogger logger = new AccessLogger();
		RoleAccessPolicy policy = new RoleAccessPolicy();
		AccessController controller = new AccessController(policy, logger);
		
		User admin = new User("user3", Role.ADMIN);
		Resource exam = new Resource("Exam Paper", AccessScope.CONFIDENTIAL, "Private");
		
		Capability<Write> cap = controller.requestWriteCapability(admin, exam);
		assertNotNull(cap);
	}
	
	@Test
	public void testGuestConfidential() {
		AccessLogger logger = new AccessLogger();
		RoleAccessPolicy policy = new RoleAccessPolicy();
		AccessController controller = new AccessController(policy, logger);
		
		User guest = new User("user4", Role.GUEST);
		Resource exam = new Resource("Exam Paper", AccessScope.CONFIDENTIAL, "Private");
		
		Capability<Read> cap = controller.requestReadCapability(guest, exam);
		assertNull(cap);
		
	}
	
	@Test
	public void testStaffInternalWrite() {
		AccessLogger logger = new AccessLogger();
		RoleAccessPolicy policy = new RoleAccessPolicy();
		AccessController controller = new AccessController(policy, logger);
		
		User staff = new User("user5", Role.STAFF);
		Resource lecture = new Resource("Lecture Material", AccessScope.INTERNAL, "Notes");
		
		Capability<Write> cap = controller.requestWriteCapability(staff, lecture);
		assertNotNull(cap);
		
	}
	@Test
	
	public void testStaffConfidentialRead() {
		AccessLogger logger = new AccessLogger();
		RoleAccessPolicy policy = new RoleAccessPolicy();
		AccessController controller = new AccessController(policy, logger);
		
		User staff = new User("user5", Role.STAFF);
		Resource exam = new Resource("Exam Paper", AccessScope.CONFIDENTIAL, "Private");
		
		Capability<Read> cap = controller.requestReadCapability(staff, exam);
		assertNotNull(cap);
	}
		

}
