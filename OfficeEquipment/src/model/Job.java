/**
 * 
 */
package model;

/**
 * a job class
 * @author Daniele
 *
 */
public class Job {
	private String code;
	private String owner;
	private String description;
	private int numCopies;

	/**
	 * a job will have a code and the first 3 letter must match the machine code
	 * then a owner will be set 
	 * and a description job will be set
	 */
	public Job(String code) {
		this.code = code;
		owner ="";
		description = "";
		numCopies = 0;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	public void setNumCopies(int copies) {
		numCopies = copies;
	}
	
	public void setCode(String newCode) {
		this.code = newCode;
	}
	
	public int getNumCopies() {
		return numCopies;
	}

}
