package model;

import static org.junit.Assert.*;

import org.junit.Test;



public class PrinterTest {
/**
 * it tests if all the condition are met the machine does is job
 */
	@Test
	public void test() {
		Printer printer = new Printer();
		assertFalse(printer.isOffLine());
		assertFalse(printer.isError());
		Job job = new Job("PRT01");
		job.setDescription("Print a pdf");
		job.setOwner("Daniele");
		assertEquals("PRT", printer.getCode());
		printer.processJob(job);
	}
	/**
	 * check if the codes don't match ,the machine gives an error message and put the machine in error state
	 * assert the error state
	 */
	@Test
	public void testPrintError() {
		Printer printer = new Printer();
		Job job = new Job("pt01");
		job.setDescription("Print a pdf");
		job.setOwner("Daniele");
		assertEquals("PRT", printer.getCode());
		printer.processJob(job);
		assertTrue(printer.isError());
	}
	/**
	 * check if the machine is offline assert is offline and print the offline state
	 */
	@Test
	public void testPrintError2() {
		Printer printer = new Printer();
		printer.setOffline();
		Job job = new Job("PRT01");
		job.setDescription("Print a pdf");
		job.setOwner("Daniele");
		assertEquals("PRT", printer.getCode());
		printer.processJob(job);
		assertFalse(printer.isError());
		assertTrue(printer.isOffLine());
	}
	/**
	 * test if the machine in error state will prompt an error message 
	 */
	@Test
	public void testErrorState() {
		Printer printer = new Printer();
		printer.setInError();
		Job job = new Job("PRT01");
		job.setDescription("Print a pdf");
		job.setOwner("Daniele");
		printer.processJob(job);
		assertTrue(printer.isError());
	}
}