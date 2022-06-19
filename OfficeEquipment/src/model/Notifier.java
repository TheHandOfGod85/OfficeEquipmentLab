/**
 * 
 */
package model;



import controller.Manager;



/**
 * @author Daniele
 *
 */
public interface Notifier {
	void registerListener(Manager listener);
	void notifyListener();

}
