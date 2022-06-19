package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScannerTest {

	@Test
	public void test() {
		Scanner scanner = new Scanner();
		Job job = new Job("SCN");
		job.setOwner("Daniele");
		job.setDescription("scan a doc");
		scanner.processJob(job);
		assertEquals("PRT", job.getCode());
		assertEquals("SCN", job.getOwner());
		
		
	
	}
	@Test
	public void test2() {
		Scanner scanner = new Scanner();
		Job job = new Job("SCN");
		job.setOwner("Daniele");
		job.setDescription("scan a doc");
		scanner.processJob(job);
		
		
		
	}

}
