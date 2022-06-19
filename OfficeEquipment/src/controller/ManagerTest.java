package controller;

import static org.junit.Assert.*;

import org.junit.Test;

import model.CoffeeMachine;
import model.Job;
import model.Photocopy;
import model.Printer;
import model.Scanner;
import model.VendingMachine;

public class ManagerTest {
	/**
	 * test if the jobs get processed
	 */
	@Test
	public void test() {
		Manager manager = new Manager();
		Job job1 = new Job("PRT001");
		Job job2 = new Job("PRT002");
		job1.setDescription("Print a pdf");
		job2.setDescription("Print a doc document");
		assertEquals(0, manager.getJobs());
		manager.addJob(job1);
		manager.addJob(job2);
		assertEquals(2, manager.getJobs());
		manager.assignJob();
		assertEquals(0, manager.getJobs());

	}

	/**
	 * test if different type of jobs are processed
	 */
	@Test
	public void testDifferentTypeOfJob() {
		Manager manager = new Manager();
		Job job1 = new Job("PRT001");
		Job job2 = new Job("CFE001");
		job1.setDescription("Print a pdf");
		job2.setDescription("Espresso");
		job2.setOwner("1Daniele");
		manager.addJob(job1);
		manager.addJob(job2);
		manager.assignJob();
		assertEquals(0, manager.getJobs());

	}
	/**
	 * test if after the machine goes in error state will stay error state and will prompt an error message
	 */
	@Test
	public void testMachineError() {
		Manager manager = new Manager();
		Job job1 = new Job("PR001");
		job1.setDescription("Print a pdf");
		manager.addJob(job1);
		manager.assignJob();
		assertEquals(0, manager.getJobs());
		Job job2 = new Job("PRT");
		manager.addJob(job2);
		job2.setDescription("Print a pdf");
		manager.assignJob();

	}
	/**
	 * test if different type of jobs are processed
	 */
	@Test
	public void testMIxed() {
		Manager manager = new Manager();
		Printer printer = new Printer();
		CoffeeMachine coffee = new CoffeeMachine();
		VendingMachine vending = new VendingMachine();
		Photocopy copier = new Photocopy();
		Scanner scanner = new Scanner();
		scanner.setManager(manager);
		manager.addMachine(copier);
		manager.addMachine(vending);
		manager.addMachine(coffee);
		manager.addMachine(printer);
		manager.addMachine(scanner);
		Job job1 = new Job("PRT001");
		Job job2 = new Job("CFE001");
		Job job3 = new Job("VND001");
		Job job4 = new Job("CPY001");
		Job job5 = new Job("SCN001");
		job1.setDescription("Print a pdf");
		job2.setDescription("Espresso");
		job3.setDescription("A mars bar");
		job5.setOwner("Daniele");
		job5.setDescription("scan a doc");
		job3.setOwner("Elisa");
		job2.setOwner("1Daniele");
		job4.setNumCopies(3);
		manager.addJob(job1);
		manager.addJob(job2);
		manager.addJob(job3);
		manager.addJob(job4);
		manager.addJob(job5);
		manager.assignJob();
		assertEquals(0, manager.getJobs());
		

	}
	@Test
	public void testListener() {
		Manager manager = new Manager();
		Printer printer = new Printer();
		Scanner scanner = new Scanner();
		manager.addMachine(scanner);
		manager.addMachine(printer);
		scanner.registerListener(manager);
		printer.registerListener(manager);
		printer.setOffline();
		scanner.setInError();
	}
	
}