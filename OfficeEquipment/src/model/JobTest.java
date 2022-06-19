package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class JobTest {

	@Test
	public void testConstrucor() {
		Job job = new Job("PRT01");
		assertEquals("PRT01", job.getCode());
		job.setDescription("Print a pdf");
		assertEquals("Print a pdf", job.getDescription());
		job.setOwner("Daniele");
		assertEquals("Daniele", job.getOwner());
	}

	

}
