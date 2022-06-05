package RandomTeamGenerator;

import jdk.jfr.Category;

import java.util.ArrayList;
import java.util.Random;

public class randomTeams {

    public static ArrayList<String> CategoryA;
    public static ArrayList<String> CategoryB;
    public static ArrayList<String> CategoryC;

    public static void main(String[] args)
    {
        //pg
        CategoryA=new ArrayList<String>();
        CategoryA.add("Kelvin");
        CategoryA.add("Brian");
        CategoryA.add("Alex");
        CategoryA.add("Sami");
        CategoryA.add("Alvin");
        CategoryA.add("Romen");
        CategoryA.add("Sakib");
        CategoryA.add("Fahim");

        //big men
        CategoryB=new ArrayList<String>();
        CategoryA.add("Korab");
        CategoryA.add("Diar");
        CategoryA.add("Fahad");
        CategoryA.add("Joi");
        CategoryA.add("Farhan");
        CategoryA.add("Louie");
        CategoryA.add("Mash");
        CategoryA.add("Aaron");

        //key pieces
        CategoryC=new ArrayList<String>();
        CategoryA.add("Vova");
        CategoryA.add("Jason");
        CategoryA.add("Jacka");
        CategoryA.add("Yash");
        CategoryA.add("Shardar");
        CategoryA.add("Keshav");
        CategoryA.add("Favio");
        CategoryA.add("Kevin");

        ArrayList<String> team1,team2,team3,team4,team5,team6,team7,team8;
        team1 = new ArrayList<String>();
        team2 = new ArrayList<String>();
        team3 = new ArrayList<String>();
        team4 = new ArrayList<String>();
        team5 = new ArrayList<String>();
        team6 = new ArrayList<String>();
        team7 = new ArrayList<String>();
        team8 = new ArrayList<String>();

        team1.add("Brian");
        team1.add("Aaron");
        team1.add("Kevin");

        team2.add("Alex");
        team2.add("Louie");
        team2.add("Favio");

        team3.add("Romen");
        team3.add("Diar");
        team3.add("Jacka");

        team4.add("Sami");
        team4.add("Fahad");
        team4.add("Keshav");

        team5.add("Kelvin");
        team5.add("Joi");
        team5.add("Jason");

        team6.add("Sakib");
        team6.add("Korab");
        team6.add("Shardar");

        team7.add("Fahim");
        team7.add("Mash");
        team7.add("Vova");

        team8.add("Alvin");
        team8.add("Farhan");
        team8.add("Yash");


        int counter = 1;
        for(int i=0; i<8; i++)
        {
            Random rnd = new Random();
            int randomA = rnd.nextInt(CategoryA.size());
            //int randomB = rnd.nextInt(CategoryB.size());
            //int randomC = rnd.nextInt(CategoryC.size());
            String playerA=CategoryA.get(randomA);
            //String playerB=CategoryB.get(randomB);
            //String playerC=CategoryC.get(randomC);
            CategoryA.remove(randomA);
            randomA = rnd.nextInt(CategoryA.size());
            String playerB=CategoryA.get(randomA);
            CategoryA.remove(randomA);
            randomA = rnd.nextInt(CategoryA.size());
            String playerC=CategoryA.get(randomA);
            CategoryA.remove(randomA);




            System.out.println("Team "+counter+" :" +playerA+", "+playerB+", "+playerC);

            counter++;


        }


    }



}
