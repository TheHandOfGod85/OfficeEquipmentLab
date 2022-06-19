/**
 * 
 */
package model;

import java.util.ArrayList;

import controller.Manager;

/**
 * An abstract class that will set up the different machines as they have 
 * features in common
 * @author Daniele
 *
 */
public abstract class Equipment implements Notifier {
	protected  String code;
	protected boolean offLine;
	protected boolean error;
	protected ArrayList<Manager> listeners;
	
/**
 * each subclass machine will have a unique personal code and start offline and in error state
 */
	protected Equipment() {
		code =  null;
		offLine = true;
		error = false;
		listeners = new ArrayList<>();
		
		

	}

	/**
	 * @return the offLine
	 */
	public boolean isOffLine() {
		return offLine;
	}

	/**
	 * @return the error
	 */
	public boolean isError() {
		return error;
	}
    /**
     * set the machine online
     */
	public void setOnline() {
		offLine = false;
		if(!offLine) {
			notifyListener();
		}
	}
	/**
	 * set the machine offline
	 */
	public void setOffline() {
		offLine = true;
		if(offLine) {
			notifyListener();
		}
	}
	/**
	 * reset the machine from error state
	 */
	public void resetError() {
		error = false;
	}
	/**
	 * set the machine in error state
	 */
	public void setInError() {
		this.error = true;
		if(error) {
			notifyListener();
		}
	}
	/**
	 * subclass will implement this method to process differently each machine
	 * @param job one job per time will be processed
	 */
	public abstract void processJob(Job job);

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	@Override
	public void registerListener(Manager listener) {
		this.listeners.add(listener);
		
	}

	@Override
	public void notifyListener() {
		for(Manager listener : this.listeners) {
			listener.showStatus();
		}
		
	}

	/**
	 * @return the listeners
	 */
	public ArrayList<Manager> getListeners() {
		return listeners;
	}

	

	

	
}