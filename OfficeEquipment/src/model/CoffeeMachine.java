/**
 * 
 */
package model;

/**
 * a coffeeMachine class
 * 
 * @author daniele
 *
 */
public class CoffeeMachine extends Equipment {

	/**
	 * 
	 */
	public CoffeeMachine() {
		super();
		code = "CFE";
		setOnline();
		
	}

	@Override
	public void processJob(Job job) {
		String jobCode = job.getCode();
		String jobOwner = job.getOwner();
		if (jobCode.toUpperCase().startsWith(code) && !isOffLine() && !isError() && jobOwner.toUpperCase().startsWith("1")) {
			System.out.println("Your  " + job.getDescription() + " is ready and it`s free!");	
			

		} else if (jobCode.toUpperCase().startsWith(code) && !isOffLine() && !isError() && !jobOwner.toUpperCase().startsWith("1")) {
			System.out.println("Your coffee is ready, standard amount (10p) will be charged on the account of :\n" + job.getOwner());	
			
					
		} else if (isOffLine()) {
			System.out.println("Coffee machine is offline");
		

		}else if (!jobCode.toUpperCase().startsWith(code)){
			System.out.println("The job`s code :" + job.getCode() + "\n" + "doesn`t match the Coffee Machine`s code :" + code
					+ "\nCoffee Machine ERROR, please reset!");
			setInError();

		}else if(isError()) {
			System.out.println("Coffee Machine is in error state , please reset!");
		}
			
	}
}
