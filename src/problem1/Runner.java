package problem1;

import java.util.*;
/**
 * This is where the main method is located and serves are the runner for the program.
 * Created by Alex White on 4/5/2017.
 */
public class Runner {

    public static void main(String [] args){

        Range yearsToSearch = new Range(1900, 2000);

        ArrayList<Person> randomPeople = Creator.createListOfPeople(20, yearsToSearch);
        Creator.printPersonList(randomPeople);

        int answerYear = MostPopulous.findMostPopulousYear(randomPeople, yearsToSearch);
        Creator.outputPersonChart(randomPeople, answerYear, yearsToSearch);

        System.out.println("The most populous year with this set of people is: " + answerYear);
    }



}
