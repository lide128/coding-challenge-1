package problem1;

import java.util.ArrayList;

/**
 * Class describing a fictitious person object with a birth year, death year and a name.
 * Assumes well formatted input, no negative numbers, birth year not after death year and death year not before birth year.
 * Created by Alex White on 4/5/2017.
 */
public class Person {

    public int birthYear;
    public int deathYear;
    public String fullName;

    public Person(int birth, int death, String name){
        birthYear = birth;
        deathYear = death;
        fullName = name;
    }

    public int lifeSpan(){
        return deathYear - birthYear;
    }

    /**
     * Set the birthYear or deathYear
     * @param newYear - the new year to add, must be greater than or equal to 0
     * @param whichDate - indicates which date to change, true for birthYear, false for deathYear
     */
    public void setYear(int newYear, boolean whichDate){
        int year;
        if(newYear < 0) year = 0;
        else year = newYear;
        if(whichDate == true) birthYear = year;
        if(whichDate == false) deathYear = year;
    }

    public void changeName(String newName){
        fullName = newName;
    }

    public String outputPerson(){
        return "\n" + fullName + " - " + birthYear + " to " + deathYear;
    }

    public void printPerson(){
        System.out.println(outputPerson());
    }

    /**
     * This method finds the earliest birth date and latest death date from a set of fictitious persons.
     * @param personList - the list of persons in which to search
     * @return
     */
    public static Range findLifeSpanRange(ArrayList<Person> personList){

        int lowestBirthYear = Integer.MAX_VALUE;
        int greatestDeathYear = 0;

        for(Person dudeguy: personList){
            if(dudeguy.birthYear < lowestBirthYear) lowestBirthYear = dudeguy.birthYear;
            if(dudeguy.deathYear > greatestDeathYear) greatestDeathYear = dudeguy.deathYear;
        }
        return new Range(lowestBirthYear, greatestDeathYear);
    }

}
