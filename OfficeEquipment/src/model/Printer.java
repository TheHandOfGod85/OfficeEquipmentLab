/**
 * 
 */
package model;



/**
 * the printer will inherit all the Equipment features
 * 
 * @author Daniele
 *
 */
public class Printer extends Equipment {
	
	

	/**
	 * the printer will be initialized with a unique code then set online and
	 * reseted any error
	 */
	public Printer() {
		super();
		code = "PRT";
		setOnline();
				

	}

	/**
	 * the printer will process a job per time and will print the description of a
	 * job if 3 conditions are met: the job Code must start as the unique code the
	 * machine is online and free from errors if the conditions are not met then a
	 * message of error will prompt and machine will be in error state
	 */
	@Override
	public void processJob(Job job) {
		String jobCode = job.getCode();
		String jobDescription = job.getDescription();
		if (jobCode.toUpperCase().startsWith(code) && !isOffLine() && !isError()) {
			System.out.println(jobDescription);
		} else if (!jobCode.toUpperCase().startsWith(code)){
			System.out.println("The job`s code :" + job.getCode() + "\n" + "doesn`t match the printer`s code :" + code +"\nPrinter ERROR, please reset!");
			setInError();
		}else if(isOffLine()) {
			System.out.println("Printer is offline");
		}else if(isError()) {
			System.out.println("Printer is in error state , please reset!");
		}
		

	}

}
