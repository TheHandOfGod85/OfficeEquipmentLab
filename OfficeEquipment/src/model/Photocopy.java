/**
 * 
 */
package model;

/**
 * @author Daniele
 *
 */
public class Photocopy extends Equipment {

	/**
	 * 
	 */
	public Photocopy() {
		super();
		code = "CPY";
		setOnline();
		
	}

	@Override
	public void processJob(Job job) {
		String jobCode = job.getCode();
		int cps = job.getNumCopies();
		if (jobCode.toUpperCase().startsWith(code) && !isOffLine() && !isError()) {
			for (int i = 1; i <= cps; i++) {
				System.out.println("page " + i + " of " + cps);
			}
		} else if (!jobCode.toUpperCase().startsWith(code)) {
			System.out.println("The job`s code :" + job.getCode() + "\n" + "doesn`t match the Photocopy`s code :" + code
					+ "\nPhotocopy ERROR, please reset!");
			setInError();
		} else if (isOffLine()) {
			System.out.println("Photocopy is offline");
		} else if (isError()) {
			System.out.println("Photocopy is in error state , please reset!");
		}

	}
}