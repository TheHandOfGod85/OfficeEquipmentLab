package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PhotocopyTest {

	@Test
	public void test() {
		Photocopy copier = new Photocopy();
		Job job = new Job("CPY001");
		job.setOwner("Daniele");
		job.setNumCopies(3);
		job.setDescription("A document");
		assertEquals(3,job.getNumCopies());
		copier.processJob(job);
	}

}
