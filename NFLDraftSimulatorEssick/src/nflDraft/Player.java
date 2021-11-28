package nflDraft;

public class Player {

	private String name;
	private int rating;
	private String position;
	
	public Player(String givenName, int givenRating, String givenPosition){
		this.name = givenName;
		this.rating = givenRating;
		this.position = givenPosition;
	}
	
	public String getName() {
		return name;
	}
	
	public int getRating() {
		return rating;
	}
	
	public String getPosition() {
		return position;
	}

}
