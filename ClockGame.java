package com.inn.foresight.servicebarring.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClockGame {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in); 
		System.out.print("Enter Total No. of People ");  
		int numOfPeople= sc.nextInt();  
		System.out.print("Enter Song Duration ");  
		int songDuration= sc.nextInt();  
		if(numOfPeople >0 && songDuration>0) {
			int winner = getWinner(numOfPeople, songDuration);
			System.out.println("Winner is "+winner);
		}else {
			System.out.println("Enter valid values");
		}
	}
	
	public static int getWinner(int numOfPeople, int songDuration) {
		List<Integer> participants = prepareParticipantList(numOfPeople);
		int pillowHolder = 0;
		for(int i=0; i<numOfPeople-1; i++) {
			pillowHolder = playSongAndEliminateOne(participants.size(), songDuration, pillowHolder);
			if(participants.size() == 1) {
				return participants.get(0);
			}
			participants.remove(pillowHolder);
		}
		return participants.get(0);
	}

	private static int playSongAndEliminateOne(int peopleLeft, int songDuration, int pillowHolder) {
		while(songDuration > 0) {
			if(pillowHolder  >= peopleLeft) {
				pillowHolder = 0;
			}
			pillowHolder++; songDuration--;
		}
		return pillowHolder-1;
	}

	private static List<Integer> prepareParticipantList(int numOfPeople) {
		List<Integer> participants = new ArrayList<Integer>(numOfPeople);
		for(int i=0; i<numOfPeople; i++) {
			participants.add(i+1);
		}
		return participants;
	}
}
