package RandomTeamGenerator;

import java.util.ArrayList;
import java.util.Random;

public class bracketCreation {

    public static void main(String[] args)
    {
        ArrayList<String> team1,team2,team3,team4,team5,team6,team7,team8;
        team1 = new ArrayList<String>();
        team2 = new ArrayList<String>();
        team3 = new ArrayList<String>();
        team4 = new ArrayList<String>();
        team5 = new ArrayList<String>();
        team6 = new ArrayList<String>();
        team7 = new ArrayList<String>();
        team8 = new ArrayList<String>();


        team1.add("team1");
        team1.add("Brian");
        team1.add("Aaron");
        team1.add("Kevin");

        team2.add("team2");
        team2.add("Alex");
        team2.add("Louie");
        team2.add("Favio");

        team3.add("team3");
        team3.add("Romen");
        team3.add("Diar");
        team3.add("Jacka");

        team4.add("team4");
        team4.add("Sami");
        team4.add("Fahad");
        team4.add("Keshav");

        team5.add("team5");
        team5.add("Kelvin");
        team5.add("Joi");
        team5.add("Jason");

        team6.add("team6");
        team6.add("Sakib");
        team6.add("Korab");
        team6.add("Shardar");

        team7.add("team7");
        team7.add("Fahim");
        team7.add("Mash");
        team7.add("Vova");

        team8.add("team8");
        team8.add("Alvin");
        team8.add("Farhan");
        team8.add("Yash");

        ArrayList<ArrayList<String>> allteams=new ArrayList<ArrayList<String>>();
        allteams.add(team1);
        allteams.add(team2);
        allteams.add(team3);
        allteams.add(team4);
        allteams.add(team5);
        allteams.add(team6);
        allteams.add(team7);
        allteams.add(team8);
        for(int i =0; i<4;i++)
        {
            Random rnd = new Random();
            int rndNum= rnd.nextInt(allteams.size());
            ArrayList<String> teamA= allteams.get(rndNum);
            allteams.remove(rndNum);
            rndNum=rnd.nextInt(allteams.size());
            ArrayList<String> teamB= allteams.get(rndNum);
            allteams.remove(rndNum);


            //System.out.println("Round "+(i+1)+": "+ teamA.get(0)+": " +teamA.get(1)+", "+teamA.get(2)+", "+teamA.get(3)+" VS " + teamB.get(0)+": " +teamB.get(1)+", "+teamB.get(2)+", "+teamB.get(3));
            System.out.println("Round "+(i+1)+": "+teamA.get(0)+" VS "+ teamB.get(0));



        }
    }
}
