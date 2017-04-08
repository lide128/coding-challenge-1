package problem1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class handles the creation and handling of the random data needed for the most populous year problem.
 * And also handles most of the data output to console and file. File writing is formatted for unix.
 * Created by Alex White on 4/5/2017.
 */
public class Creator {

    /**
     * This method creates randomized list of data to be used in the findMostPopulousYear method.
     * @param numberOfPeople    - the number of people desired
     * @param timeSpan          - the range of years to create the data for
     * @return
     */
    public static ArrayList<Person> createListOfPeople(int numberOfPeople, Range timeSpan){
        ArrayList<Person> people = new ArrayList<>();
        for(int i = 0; i < numberOfPeople; i++){
            Range lifespan = randomLifeRange(timeSpan);
            String name = randomName();
            Person newPerson = new Person(lifespan.start, lifespan.finish, name);
            people.add(newPerson);
        }
        return people;
    }

    /**
     * Creates a random (not truly) range of two dates to serve as a fictitious lifespan for a fictitious person.
     * @param timeSpan - the length of time in which to include the fictitious lifespan
     * @return
     */
    public static Range randomLifeRange(Range timeSpan){
        Random rand = new Random();

        int deathYear = rand.nextInt(timeSpan.total);
        int birthYear;
        if(deathYear == timeSpan.start){
            birthYear = 0;
        }
        else {
            birthYear = rand.nextInt(deathYear);
        }

        Range lifeRange = new Range(birthYear + timeSpan.start, deathYear + timeSpan.start);
        return lifeRange;
    }

    /**
     * A method to create a silly name for a fictitious person with a fictitious lifespan.
     * @return - the silly name
     */
    public static String randomName(){
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};

        Random rand = new Random();
        int nameLength = 0;
        while(nameLength <= 2) nameLength = rand.nextInt(10);
        char first = (char)(rand.nextInt(26) + 'a');
        String name = "" + first;
        name = name.toUpperCase();

        for(int i = 0; i < nameLength; i++){
            char letter;
            if(i%2 == 0){
                letter = vowels[rand.nextInt(vowels.length)];
            }
            else{
                letter = consonants[rand.nextInt(consonants.length)];
            }
            name = name + letter;
        }
        return name;
    }

    /**
     * A method to output the list of people to the console
     * @param toPrint - the list of people to output to the console
     */
    public static void printPersonList(ArrayList<Person> toPrint){
        for(Person dudeguy: toPrint){
            dudeguy.printPerson();
        }
    }

    /**
     * A method to wrtie a formatted string to a file.
     * @param populousYear  - the solution of the most populous year problem
     * @param toWrite       - the formatted string to write to a file
     */
    public static void outputFile(int populousYear, String toWrite){
        Random rand = new Random();
        try {
            File output = new File("problem1_" + rand.nextInt(100) + ".txt");
            if (!output.exists()) {
                output.createNewFile();
            }
            FileOutputStream fileO = new FileOutputStream(output);
            OutputStreamWriter outputSW = new OutputStreamWriter(fileO);
            Writer w = new BufferedWriter(outputSW);
            w.write(toWrite);
            w.write("\n\nThe most populous year with this set of people is: " + populousYear);
            w.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * A method to create a file with a list of people and the most populous year written to it.
     * @param toOutput      - the array list of people to output
     * @param populousYear  - the solution of the most populous year problem
     */
    public static void outputPersonList(ArrayList<Person> toOutput, int populousYear){
        outputFile(populousYear, createPersonList(toOutput));
    }

    /**
     * A method to create a file with a simple text chart representation of data.
     * @param toOutput      - the array list of people to output
     * @param populousYear  - the solution of the most populous year problem
     */
    public static void outputPersonChart(ArrayList<Person> toOutput, int populousYear, Range yearsToShow){
        outputFile(populousYear, createPersonChart(toOutput, populousYear, yearsToShow));
    }

    /**
     * A method to create a list of the people in question.
     * @param toOutput - the array list of people to output
     * @return
     */
    public static String createPersonList(ArrayList<Person> toOutput){
        String personList = "\n";
        for(Person dudeguy: toOutput){
            personList += dudeguy.outputPerson();
        }
        return personList;
    }

    /**
     * A method to create a simple text chart representing the data
     * @param toOutput      - the array list of people to output
     * @param populousYear  - the solution of the most populous year problem
     * @return
     */
    public static String createPersonChart(ArrayList<Person> toOutput, int populousYear, Range yearsToShow){
        String personChart = "\n";
        int timeSpan = yearsToShow.total;
        int start = yearsToShow.start;

        for(Person dudeguy: toOutput){
            personChart += nameFit(dudeguy);
            for(int i = 0; i < timeSpan; i++){
                if((i + start) >= dudeguy.birthYear && (i + start) <= dudeguy.deathYear){
                    if(i == populousYear - start){
                        personChart += "0";
                    }
                    else{
                        personChart += "+";
                    }
                }
                else{
                    personChart += "-";
                }
            }
        }
        return personChart;
    }

    /**
     * A method to correctly space person names in the text data chart.
     * @param subject - the person who's name in which to fit
     * @return
     */
    public static String nameFit(Person subject){
        String outputString = "";
        String nameAndDates = subject.outputPerson();
        int nameLength = subject.fullName.length();
        switch (nameLength){
            case 2:
                outputString += nameAndDates + "        ";
                break;
            case 3:
                outputString += nameAndDates + "       ";
                break;
            case 4:
                outputString += nameAndDates + "      ";
                break;
            case 5:
                outputString += nameAndDates + "     ";
                break;
            case 6:
                outputString += nameAndDates + "    ";
                break;
            case 7:
                outputString += nameAndDates + "   ";
                break;
            case 8:
                outputString += nameAndDates + "  ";
                break;
            case 9:
                outputString += nameAndDates + " ";
                break;
            default:
                outputString += nameAndDates;
                break;
        }
        return outputString;
    }

}


