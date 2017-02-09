package controllers;

/**
 * @author Judy
 * @param A Items Class 
 */
public class Items implements Comparable<Items> {


	public String english;
	public String spanish;
	

	/** Constructor for object of class Item. 
	 * @param 
	 
	 * @return 
	 */

	public Items(String spanish, String english)
	{
		this.english = english;
		this.spanish = spanish;

	}

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
		return spanish + " = "   + english;
	}




	@Override
    public int compareTo(Items item) {
        return this.spanish.compareTo(item.spanish);
    }

	
	
	
}
