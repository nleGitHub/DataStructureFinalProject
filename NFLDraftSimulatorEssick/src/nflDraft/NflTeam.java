package nflDraft;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class NflTeam {

	private String teamName;
	private Stack<String> wantsNeeds;
	private ArrayList<Player> draftedPlayers;
	
	
	public NflTeam(String teamName) {
		this.teamName = teamName;
		this.wantsNeeds = generateWantsNeedsStack();
		this.draftedPlayers = new ArrayList<Player>();
	}
	
	
	public String getTeamName() {
		return teamName;
	}
	
	
	public Stack<String> getWantsNeeds() {
		return wantsNeeds;
	}
	
	
	public ArrayList<Player> getDraftedPlayers() {
		return draftedPlayers;
	}
	
	private Stack<String> generateWantsNeedsStack(){
		Stack<String> tempStack = new Stack<String>();
		
		String playerPosition[] = {"Quarterback", "Runningback", "Wide Receiver", "Tightend", "Offensive Lineman", "Deffensive Lineman", "Safety", "Linebacker", "Cornerback"};
		
		for(int i = 0; i < 7; i++){
			String newPosition = playerPosition[new Random().nextInt(playerPosition.length)];
			tempStack.push(newPosition);
		}
		return tempStack;
	}


}