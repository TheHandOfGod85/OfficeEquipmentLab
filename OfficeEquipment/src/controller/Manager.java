package controller;


import java.util.ArrayList;
import model.Equipment;
import model.Job;
import model.Notifier;


/**
 * @author Daniele
 *
 */
public class Manager implements Listener{
	private ArrayList<Job> jobs;
	private ArrayList<Equipment> equipments;
	private Notifier notifier;

	public Manager(){
		equipments = new ArrayList<>();
		jobs = new ArrayList<Job>();

	}

	/**
	 * @return the notifier
	 */
	public Notifier getNotifier() {
		return notifier;
	}

	/**
	 * @param notifier the notifier to set
	 */
	public void setNotifier(Notifier notifier) {
		this.notifier = notifier;
	}

	/**
	 * @return the equipments
	 */
	public ArrayList<Equipment> getEquipments() {
		return equipments;
	}

	/**
	 * Assign jobs to appropriate machine
	 * 
	 */
	public void assignJob() {
		    for (int i = 0; i < jobs.size(); i++) {
			Job job = jobs.get(i);
			String jobCode = job.getCode();
			if (jobs.isEmpty()) {
				System.out.println("No job is available");
			}
			if (!equipments.isEmpty()) {
				for(int j = 0; j < equipments.size(); j++) {
					if(equipments.get(j).getCode().equals(jobCode.toUpperCase().substring(0,3))) {
						equipments.get(j).processJob(job);	
					}
				}
			}
		}
		jobs.removeAll(jobs);
	}

	/**
	 * @return the number of jobs
	 */
	public int getJobs() {
		int numberJobs = jobs.size();
		return numberJobs;
	}

	/**
	 * @param jobs the jobs to set
	 */
	public void addJob(Job job) {
		jobs.add(job);
	}

	/**
	 * add machines to the manager list
	 */
	public void addMachine(Equipment machine) {
		equipments.add(machine);
	}

	@Override
	public void showStatus() {
		for(Equipment machine: equipments) {
			if(machine.isOffLine()) {
				System.out.println("The " + machine.getClass().getSimpleName() + " is offline now!");
			}if(!machine.isOffLine()) {
				System.out.println("The " + machine.getClass().getSimpleName() + " is online now!");
			}if(machine.isError()) {
				System.out.println("The " + machine.getClass().getSimpleName() +  " is in error state now!");
			}
		}
	}
}