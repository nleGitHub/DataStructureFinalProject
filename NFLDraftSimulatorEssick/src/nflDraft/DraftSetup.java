package nflDraft;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Random;

import com.github.javafaker.Faker;

public class DraftSetup {

private LinkedList<Player> playerList;
private LinkedList<NflTeam> teamList;
private Faker faker;

	public DraftSetup() {
		this.faker = new Faker();
		generatePlayerList();
		generateTeamList();
	}
	
	public LinkedList<Player> getPlayerList() {
		return playerList;
	}
	
	public LinkedList<NflTeam> getTeamList() {
		return teamList;
	}
	
	
	//instaniate player list
	//add player to list 10k times
	//each player needs a name, position, rating created
	private void generatePlayerList(){
		playerList = new LinkedList<Player>();
		
		for(int i = 0; i < 10000; i++){
			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String fullName = firstName + " " + lastName;
		
		
			Random rand = new Random();
			int randomRating = rand.nextInt(1000) + 1;
			
			String playerPosition[] = {"Quarterback", "Runningback", "Wide Receiver", "Tightend", "Offensive Lineman", "Deffensive Lineman", "Safety", "Linebacker", "Cornerback"};
			String newPosition = playerPosition[new Random().nextInt(playerPosition.length)];
			
			
			Player newPlayer = new Player(fullName, randomRating, newPosition);
			playerList.push(newPlayer);
		}
		
		Collections.sort(playerList, new Comparator<Player>() {
		   
		@Override
		public int compare(Player playerOne, Player playerTwo) {
		// TODO Auto-generated method stub
			return playerTwo.getRating() - playerOne.getRating();
		}
		});
	
	}
	
	private void generateTeamList(){
		teamList = new LinkedList<NflTeam>();
		
		for(int i = 0; i < 32; i++){
			String newTeamName = faker.team().name();
		
			NflTeam team = new NflTeam(newTeamName);
			teamList.push(team);
	}
	}



}
