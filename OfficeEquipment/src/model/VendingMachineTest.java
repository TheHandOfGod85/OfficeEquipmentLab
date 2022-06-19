package model;



import org.junit.Test;

public class VendingMachineTest {

	@Test
	public void test() {
		VendingMachine vnd = new VendingMachine();
		Job job = new Job("VND001");
		job.setDescription("A mars bar");
		job.setOwner("Franco");
		vnd.processJob(job);
	}
	@Test
	public void test1() {
		VendingMachine vnd = new VendingMachine();
		Job job = new Job("VNe001");
		job.setDescription("A mars bar");
		job.setOwner("Franco");
		vnd.processJob(job);
	}
	
}
