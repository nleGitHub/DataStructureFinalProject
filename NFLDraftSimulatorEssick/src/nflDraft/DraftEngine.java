package nflDraft;

import java.util.LinkedList;

public class DraftEngine {

public static void main(String args[]){
		
		DraftSetup newDraft = new DraftSetup();
		
		//Temporary empty queue. We'll add teams to this after a team has drafted so they'll be ready to start the next round.
		LinkedList<NflTeam> newDraftRoundQueue = new LinkedList<NflTeam>();
		
		
		//Do the draft thing for 7 rounds
		for(int i = 0; i < 7; i++){
			//if it's the first round, do nothing since draft order is already set
			//in our draft set up class
			if(i !=0){
				//otherwise, take our newDraftRoundQueue from above, and set the new round order 
				//(we add teams to the newDraftRoundQueue down below)
				newDraft.setTeamList(newDraftRoundQueue);
				//then reset the queue so we can start a new queue for the next round
				newDraftRoundQueue = new LinkedList<NflTeam>();
			}
		//run through all 32 teams and draft their desired player
			while(!newDraft.getTeamList().isEmpty()){
				NflTeam tempTeam = newDraft.getTeamList().pop();
				String tempNeedWant = tempTeam.getWantsNeeds().pop();
				
				for(Player player : newDraft.getPlayerList()){
					if(player.getPosition().equals(tempNeedWant)){
						//draft the player to the team
						tempTeam.getDraftedPlayers().add(player);
						//remove the player from the list of available players so no one else can double draft them
						newDraft.getPlayerList().remove(player);
						//set up the queue for the next round. This is then used for the following round
						newDraftRoundQueue.add(tempTeam);
						//System.out.println(tempTeam.getTeamName() + " drafted " + player.getName());
						break;
					}
				}
			}
		
		}
		
		for(NflTeam team : newDraftRoundQueue){
			System.out.println( "*****************" + team.getTeamName() + "*****************");
			for(Player player : team.getDraftedPlayers()){
				System.out.println(player.getName() + "-" + player.getPosition() + "-" + player.getRating());
			}
		}
	
	}

}
