package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import javax.swing.Timer;

import Corpus.CorpusLoader;
import NPC.NPCBase;
import NPC.NPCGenerator;

public class Lanuch {
	public static void main(String[] args) throws ParseException, Exception {
		
		int currentDay=0;
		int totalDays=5;
		
		int Credit = 50;
		int food = 20;
		int heat = 10;
		
		int friendly = 60;
		int serious = 60;
		int wrongRate = 40;
		
		int countryEvent = -1;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = format.parse("1983-11-04");
		Calendar cd = Calendar.getInstance();   
        cd.setTime(startDate);   
		
		NPCGenerator np = new NPCGenerator();
		CorpusLoader c = new CorpusLoader();
		System.out.println("done");
					
		System.out.println("Please tell us your name, comrade.");
		Scanner hci = new Scanner(System.in);
		String playerName = hci.nextLine();
		System.out.println("Congratulations! "+playerName+".");
		System.out.print("The October Labor Lottery was drawn. Your name was drawn.\r\n" + 
				"You will take office immediately. Please report to the immigration department at the border checkpoint in East Grestin.\r\n" + 
				"We will arrange apartments for you and your family in East Grestin.\r\n" + 
				"Long live Arstotzka!\n"+
				"Tip: Type \"Long live Arstotzka\" to start your work.\n");
		String checkPoint_1 = hci.nextLine();
		if(checkPoint_1.contentEquals("Long live Arstotzka")) {
			System.out.println("For national residents.\r\n" + 
					"As long as they present a valid passport, they can pass.");
			System.out.println("All foreign visitors must hold passports and visas.\r\n" + 
					"Please carefully check their passport information and visa information.\r\n" + 
					"Please note whether the visa has expired.");
		}else{
			System.out.println("Arstotzka cannot tolerate any guys who evade work.\r\n" + 
					"An inspector who replaces your position is very easy to find."+ 
					"Long live Arstotzka!\n"+
					"Ending No. 1");
			System.exit(0);
		};
		
		System.out.println("Do you remember? Input y or n");
		String checkPoint_2 = hci.nextLine();
		if(checkPoint_2.contentEquals("n")) {
			System.out.println("Arstotzka cannot tolerate any guys who evade work.\r\n" + 
					"An inspector who replaces your position is very easy to find."+ 
					"Long live Arstotzka!\n"+
					"Ending No. 1");
			System.exit(0);
		}
		
		
		int t =300000;
		TestTimer testTimer = new TestTimer();
		Timer tme =new Timer(t,testTimer);
		tme.setRepeats(false);
		tme.start();
		
		while(currentDay < totalDays) {
			int wrongNum = 0;
			int rightNum = 0;
			
			int passNum = 0;
			int refuseNum = 0;
			int kindNum = 0;
			int coldNum = 0;
			int angryNum = 0;
			
			String today = format.format(startDate);
			
			System.out.println("System: "+today+", East Grestin, Arstotzka");
			
			Thread.sleep(1000);
			
			System.out.println("System: Good morning, sir, Please be ready to start work.");
			
			Thread.sleep(1000);
			
			while(!TestTimer.endDay) {
				NPCBase newNb = np.generator(wrongRate,countryEvent);
				System.out.println(playerName+": Papers, please.");

				newNb.talkBeforeCheck(friendly, serious);
				
				newNb.generatePassport();
				newNb.generateAttache();
				System.out.println("System: Whether to question the documents? Input q(question) or n(no) ?");
				String question = hci.nextLine();
				if(question.contentEquals("q")) {
					newNb.talkAfterCheck(playerName);
					System.out.println(playerName+": It seems that things have come to a conclusion.");
				}else {
					System.out.println(playerName+": It seems that things have come to a conclusion.");
				}
				System.out.println("System: It's time to make a decision. Input Pass or Refuse ?");
				String checkPoint_3 = hci.nextLine();
				if(checkPoint_3.contentEquals("pass")) {
					passNum++;
					System.out.println(playerName+": Welcome to Arstotzka.");
					newNb.talkFinal(true);
					System.out.println(playerName+": Please observing discipline and obeying the law.");
					System.out.println("****************************************************************");
					if(newNb.wrongType!=-1) {
						kindNum++;
						wrongNum++;

						Thread.sleep(1000);
						
						System.out.println("Warning: Error-Invalid VISA.\nMore than 2 mistakes will get punishment.");
						System.out.println("****************************************************************");
						if(wrongNum>2) {
							System.out.println("Warning: You have made too many mistakes and have been punished accordingly");
							System.out.println("****************************************************************");
						}
					}else {
						rightNum++;
					}
				}else {
					refuseNum++;
					System.out.println(playerName+": Sorry, i can't let you pass.");
					newNb.talkFinal(false);
					System.out.println("****************************************************************");
					if(newNb.wrongType!=-1) {
						coldNum++;
						rightNum++;
					}else {
						angryNum++;
						wrongNum++;
					
						Thread.sleep(1000);
						
						System.out.println("Warning: Error-Valid certificates was rejected.\nMore than 2 mistakes will get punishment.");
						System.out.println("****************************************************************");
						if(wrongNum>2) {
							System.out.println("Warning: You have made too many mistakes and have been punished accordingly");
							System.out.println("****************************************************************");
						}
					}
				}
				
				Thread.sleep(1000);
				
				System.out.println(playerName + ": Next!");
				
				Thread.sleep(2000);
				
			}
			System.out.println("System: Today's work is over.");
			Credit = printCredit(wrongNum,rightNum,Credit,food,heat);
			if(Credit<0) {
				System.out.println("Arstotzka cannot tolerate any debt.");
				System.out.println("You will be immediately sent to the prison in Gennistora");
				System.out.println("Your family will be sent back to the countryside");
				System.out.println("A new immigration manager is ready to take office");
				System.out.println("Long live Arstotzka !");
				System.out.println("Ending No. 2");
				System.exit(0);
			}else {
				System.out.println("System: It's time to sleep. Input anything to go sleep.");
			}
			String checkPoint_4 = hci.nextLine();
			Thread.sleep(2000);
			System.out.println("System: Good morning, Sir. This is today's morning newspaper.");
			Thread.sleep(1000);
			int newFriend = friendUpadateCal(friendly,passNum,refuseNum,angryNum);
			int newSerious = seriousUpadateCal(serious,passNum,refuseNum,angryNum,kindNum,coldNum);
			countryEvent = printNewsPaper(friendly,newFriend,serious,newSerious);
			friendly = newFriend;
			serious = newSerious;
			System.out.println("System: Input anything to go to work.");
			String checkPoint_5 = hci.nextLine();
			cd.add(Calendar.DATE, 1);
	        startDate = cd.getTime();
	        currentDay++;
			TestTimer.endDay = false;
			tme.restart();
		}	
		System.out.println("The trial period for the work of the immigration administrator is over");
		System.out.println("Your performance is good, and the leadership decided to continue with you in this position.");
		System.out.println("Your family sees the hope of life, and you start talking about moving into a better apartment.");
		System.out.println("The world is turbulent\r\n" + 
				"Arstotzka is like a harbour, which inevitably attracts neighbors to seek asylum.");
		System.out.println("In response to the current situation, the government is preparing to introduce a new immigration policy.");
		System.out.println("New day comes, work is still busy");
		System.out.println("Long live Arstotzka !");
		System.out.println("Ending No. 3");
	}
	
	public static int printCredit(int w, int r, int credit, int food, int heat) {
		int d = credit;
		int fine = 0;
		int pay = 5*r;
		if(w>2) {
			fine = 10*(w-2);
			credit = credit-fine+pay-food-heat;
		}else {
			credit = credit+pay-food-heat;
		}
		System.out.println("|  Deposit:  "+d);
		System.out.println("|  pay: +"+pay);
		System.out.println("|  Fine: -"+fine);
		System.out.println("|  Food: -"+food);
		System.out.println("|  Heater: -"+heat);
		System.out.println("-----------------------------");
		System.out.println("|  Balance:  "+credit);
		return credit;
	}
	
	public static int friendUpadateCal(int f, int p, int r, int a) {
		float updateRate = ((p-r-2*a)/(p+r));
		if(updateRate>0.3) {
			updateRate = 0.3f;
		}
		if(updateRate<-0.3) {
			updateRate = -0.3f;
		}
		f = (int) (f*(1+updateRate));
		if(f>99) {
			f = 99;
		}
		if(f<20) {
			f = 20;
		}
		return f;
	}
	
	public static int seriousUpadateCal(int s, int p, int r, int a, int k, int c) {
		float updateRate = (p+2*k-r-2*c-2*a)/(p+r);
		if(updateRate>0.3) {
			updateRate = 0.3f;
		}
		if(updateRate<-0.3) {
			updateRate = -0.3f;
		}
		s = (int) (s*(1+updateRate));
		if(s>99) {
			s = 99;
		}
		if(s<20) {
			s = 20;
		}
		return s;
	}
	
	public static int printNewsPaper(int f, int nf, int s, int ns ) {
		Random rand = new Random();
		int r = rand.nextInt(5);
		int i = 0;
		System.out.println("||========================================================================||");
		System.out.println("||=============================Daily Grestin==============================||");
		if(f<nf) {
			System.out.println("||===============The shadow of the war gradually dissipated===============||\n" + 
					"||The border resumed its former prosperity.                               ||");
			System.out.println("||========================================================================||");
		}else {
			System.out.println("||============Guardian of the country? Or xenophobic stubborn?============||\n" +
					"||Complaints of immigration office are increasing.                        ||");
			System.out.println("||========================================================================||");
		}
		if(s<ns) {
			System.out.println("||==================National security is above everything=================||\n" +
					"||The public criticized the border inspection work for being too lax.     ||");
			System.out.println("||========================================================================||");
		}else {
			System.out.println("||=======================The iron man on the border=======================||\n" +
					"||The new border inspector was accused of being too strict.               ||");
			System.out.println("||========================================================================||");
		}
		switch(r) {
		case 0:
			i = 0;
			System.out.println("||======The political situation in Antegria continues to be volatile.=====||\n" +
					"||Antegria refugees came to Arstotzka to seek political asylum.           ||");
			System.out.println("||========================================================================||");
			break;
		case 1:
			i = 1;
			System.out.println("||===Impor further strengthened the economic restrictions on Arstotzka.===||\n" +
					"||Some Arstotzka people complain of discrimination at Impor.              ||");
			System.out.println("||========================================================================||");
			break;
		case 2:
			i = 2;
			System.out.println("||=============Kolechia's anti-Arstotzka sentiment is growing.============||\n" +
					"||Government warns of the increase of Kolechia arrivals in recent days.   ||");
			System.out.println("||========================================================================||");
			break;
		case 3:
			i = 3;
			System.out.println("||===========Will Republia get rid of Antegria's political storm?=========||\n" +
					"||Republians at the border checkpoint are no longer just businessmen.     ||");
			System.out.println("||========================================================================||");
			break;
		case 4:
			i = 4;
			System.out.println("||========Children in the United Federation are at risk from polio.=======||\n" +
					"||Arstotzka promised United Federation to exempt tariffs on related drugs.||");
			System.out.println("||========================================================================||");
			break;
		}
		return i;
	}
	
}

class TestTimer implements ActionListener{
	public static boolean endDay=false;
	public void actionPerformed(ActionEvent e){
		System.out.println("********************************************************");
		System.out.println("Broadcast: \"Today's work is over \nplease come back tomorrow for immigration business.\"");
		System.out.println("********************************************************");
		endDay = true;
	} 
}   


