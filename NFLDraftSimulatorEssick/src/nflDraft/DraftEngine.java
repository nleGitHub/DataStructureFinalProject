package nflDraft;

public class DraftEngine {

public static void main(String args[]){
	
	DraftSetup newDraft = new DraftSetup();
	
	NflTeam tempTeam = newDraft.getTeamList().pop();
	String tempNeedWant = tempTeam.getWantsNeeds().pop();
	
	for(Player player : newDraft.getPlayerList()){
		if(player.getPosition().equals(tempNeedWant)){
			tempTeam.getDraftedPlayers().add(player);
			newDraft.getPlayerList().remove(player);
			break;
		}
	}
	
	
	}

}
