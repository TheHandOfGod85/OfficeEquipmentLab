package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoffeeMachineTest {
/**
 * test if all conditions are met and the coffee is free
 */
	@Test
	public void test() {
		CoffeeMachine cfm = new CoffeeMachine();
		Job job1 = new Job("CFE");
		job1.setOwner("1Daniele");
		job1.setDescription("Latte macchiato");
		cfm.processJob(job1);
	}
	/**
	 * test if all condition are met and the manager code is not inserted the coffee will be processed and charged
	 */
	@Test
	public void test1() {
		CoffeeMachine cfm = new CoffeeMachine();
		Job job1 = new Job("CFE");
		job1.setOwner("Daniele");
		job1.setDescription("Latte macchiato");
		cfm.processJob(job1);
	}
	/**
	 * test if machine is offline the job wont be processed and will prompt a message about the offline state
	 * assert the machine is offline
	 */
	@Test
	public void test3() {
		CoffeeMachine cfm = new CoffeeMachine();
		cfm.setOffline();
		Job job1 = new Job("CFE");
		job1.setOwner("Daniele");
		job1.setDescription("Latte macchiato");
		cfm.processJob(job1);
		assertTrue(cfm.isOffLine());
	}
	/**
	 * check if machine has not matching code will prompt a message of error and put the machine in error state
	 * assert the machine is error state afterwards
	 */
	@Test
	public void test4() {
		CoffeeMachine cfm = new CoffeeMachine();
		Job job1 = new Job("PRT");
		job1.setOwner("Daniele");
		job1.setDescription("Latte macchiato");
		cfm.processJob(job1);
		assertTrue(cfm.isError());
	}
	/**
	 * test if the machine in error state will prompt a message of error state
	 */
	@Test
	public void test5() {
		CoffeeMachine cfm = new CoffeeMachine();
		cfm.setInError();
		Job job1 = new Job("CFE");
		job1.setOwner("Daniele");
		job1.setDescription("Latte macchiato");
		cfm.processJob(job1);
		assertTrue(cfm.isError());
	}
}
