import java.text.DecimalFormat;
import java.util.Random;

public class NflPlayers {
	
	public class createPlayer{
		//import Faker class to generate random names
		//Faker faker = new Faker();
		//String name = faker.name().fullName();
		
		double playerRating = Math.random()*100;
		
		String playerPosition[] = {"Quarterback", "Runningback", "Wide Receiver", "Tightend", "Offensive Lineman", "Deffensive Lineman", "Safety", "Linebacker", "Cornerback"};
		
		//tested random player position generated 
//		System.out.println(playerPosition[new Random().nextInt(playerPosition.length)]);

		//tested that the score will convert to decimal places and holding two places after decimal
//		System.out.println(playerRating);
//		
//		DecimalFormat numberFormat = new DecimalFormat("#.00");
//		
//		System.out.println(numberFormat.format(playerRating));
	}
	
	public class createNflTeam{
		
		private int top;
		private int maxSize;
		private String playerList[];
		
		public createNflTeam() {
			this.maxSize = 7;
			this.top = -1;
			this.playerList = new String[maxSize];
			
		}
		
		public boolean isFull() {
			return top == maxSize -1; 
		}
		
		public String pop() {
			String player = null;
			player = playerList[top];
			return player;
		}
		
		public void push(String player) {
			top = top + 1;
			playerList[top] = player;
		}
	}
	
	public static void main(String arg[]) {
		//create players
		//create a linked list
		//add players to the list based on rating
		//put teams into queue
		//draft begins
			
	}

}
