/**
 * 
 */
package model;



import controller.Manager;

/**
 * @author Daniele
 *
 */
public class Scanner extends Equipment{
	private Manager manager;
	
	

	/**
	 * 
	 */
	public Scanner() {
		super();
		code = "SCN";
		setOnline();
	}

	@Override
	public void processJob(Job j) {
		Job job = j;
		String jobCode = job.getCode();
		if (jobCode.toUpperCase().startsWith(code) && !isOffLine() && !isError()) {
			job.setOwner(code);
			job.setCode("PRT");
			manager.addJob(job);
		}else if (!jobCode.toUpperCase().startsWith(code)){
			System.out.println("The job`s code :" + job.getCode() + "\n" + "doesn`t match the scanner`s code :" + code +"\nScanner ERROR, please reset!");
			setInError();
		}else if(isOffLine()) {
			System.out.println("Scanner is offline");
		}else if(isError()) {
			System.out.println("Scanner is in error state , please reset!");
		}
	}
	public void setManager(Manager mng) {
		manager = mng;
	}
}
