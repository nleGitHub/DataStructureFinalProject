package nflDraft;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DraftEngine implements ActionListener{
	
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JFrame frame;
	private JPanel panel;

	public DraftEngine() {
		
		JButton button = new JButton("Create Draft");
		label1 = new JLabel("Create the draft by click 'Create Draft' button first");
		label2 = new JLabel("");
		label3 = new JLabel("");
		button.addActionListener(this);
		
		
		frame = new JFrame();
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 50, 100));
		panel.setLayout(new GridLayout(0,1));
		panel.add(button);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("NFL Draft");
		frame.pack();
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
		
		label1.setText("Draft has been created.");
		label2.setText("Nfl Teams have now drafted their players.");
		label3.setText("Check the console to see the full team list and players draft.");
		
		for(NflTeam team : newDraftRoundQueue){
		System.out.println( "*****************" + team.getTeamName() + "*****************");
		for(Player player : team.getDraftedPlayers()){
			System.out.println(player.getName() + "-" + player.getPosition() + "-" + player.getRating());
		}
	}
		
		
	}
	
public static void main(String args[]){

		new DraftEngine();
		
//		DraftSetup newDraft = new DraftSetup();
//		
//		//Temporary empty queue. We'll add teams to this after a team has drafted so they'll be ready to start the next round.
//		LinkedList<NflTeam> newDraftRoundQueue = new LinkedList<NflTeam>();
//		
//		
//		//Do the draft thing for 7 rounds
//		for(int i = 0; i < 7; i++){
//			//if it's the first round, do nothing since draft order is already set
//			//in our draft set up class
//			if(i !=0){
//				//otherwise, take our newDraftRoundQueue from above, and set the new round order 
//				//(we add teams to the newDraftRoundQueue down below)
//				newDraft.setTeamList(newDraftRoundQueue);
//				//then reset the queue so we can start a new queue for the next round
//				newDraftRoundQueue = new LinkedList<NflTeam>();
//			}
//		//run through all 32 teams and draft their desired player
//			while(!newDraft.getTeamList().isEmpty()){
//				NflTeam tempTeam = newDraft.getTeamList().pop();
//				String tempNeedWant = tempTeam.getWantsNeeds().pop();
//				
//				for(Player player : newDraft.getPlayerList()){
//					if(player.getPosition().equals(tempNeedWant)){
//						//draft the player to the team
//						tempTeam.getDraftedPlayers().add(player);
//						//remove the player from the list of available players so no one else can double draft them
//						newDraft.getPlayerList().remove(player);
//						//set up the queue for the next round. This is then used for the following round
//						newDraftRoundQueue.add(tempTeam);
//						//System.out.println(tempTeam.getTeamName() + " drafted " + player.getName());
//						break;
//					}
//				}
//			}
//		
//		}
//		
//		for(NflTeam team : newDraftRoundQueue){
//			System.out.println( "*****************" + team.getTeamName() + "*****************");
//			for(Player player : team.getDraftedPlayers()){
//				System.out.println(player.getName() + "-" + player.getPosition() + "-" + player.getRating());
//			}
//		}
	
	}

}
