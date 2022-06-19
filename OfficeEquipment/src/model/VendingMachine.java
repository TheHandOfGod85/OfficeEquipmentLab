/**
 * 
 */
package model;



/**
 * a class vending machine inherit from equipment
 * @author Daniele
 *
 */
public class VendingMachine extends Equipment {

	/**
	 * the vending machine will be initialized with a unique code then set online and
	 * reseted any error
	 */
	public VendingMachine() {
		super();
		code = "VND";
		setOnline();
		
	}

	@Override
	public void processJob(Job job) {
		String jobCode = job.getCode();
		String jobOwner = job.getOwner();
		if (jobCode.toUpperCase().startsWith(code) && !isOffLine() && !isError() && jobOwner.toUpperCase().startsWith("1")) {
			System.out.println("Your  " + job.getDescription() + " is ready and it`s free!");	
			

		} else if (jobCode.toUpperCase().startsWith(code) && !isOffLine() && !isError() && !jobOwner.toUpperCase().startsWith("1")) {
			System.out.println("Price (10p) will be charged on the account of :\n" + job.getOwner());	
			
					
		} else if (isOffLine()) {
			System.out.println("Vending machine is offline");
		

		}else if (!jobCode.toUpperCase().startsWith(code)){
			System.out.println("The job`s code :" + job.getCode() + "\n" + "doesn`t match the Vending Machine`s code :" + code
					+ "\nVending Machine ERROR, please reset!");
			setInError();

		}else if(isError()) {
			System.out.println("Vending Machine is in error state , please reset!");
		}
			
	}


}
