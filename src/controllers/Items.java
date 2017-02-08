package controllers;

/**
 * @author Judy
 * @param A Items Class 
 */
public class Items implements Comparable<Items> {

	public String getEnglish() {
		return english;
	}


	public void setEnglish(String english) {
		this.english = english;
	}


	public String getSpanish() {
		return spanish;
	}


	public void setSpanish(String spanish) {
		this.spanish = spanish;
	}


	@Override
	public String toString() {
		return english + " = "   + spanish;
	}


	public String english;
	public String spanish;
	



	/** Constructor for object of class Item. 
	 * @param 
	 
	 * @return 
	 */

	public Items(String english, String spanish)
	{
		this.english = english;
		this.spanish = spanish;

	}


	@Override
    public int compareTo(Items item) {
        return this.english.compareTo(item.english);
    }
	
	
	
}
