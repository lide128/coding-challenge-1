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
        int birthYear = rand.nextInt(deathYear);

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

    public static void printPersonList(ArrayList<Person> toPrint){
        for(Person dudeguy: toPrint){
            dudeguy.printPerson();
        }
    }

    /**
     * A method to create a file with the data created and the most populous year written to it.
     * @param toOutput      - the array list of people to output
     * @param populousYear  - the solution of the most populous year problem
     */
    public static void outputPersonList(ArrayList<Person> toOutput, int populousYear){
        Random rand = new Random();
        try {
            File output = new File("problem1_" + rand.nextInt(100) + ".txt");
            if (!output.exists()) {
                output.createNewFile();
            }
            FileOutputStream fileO = new FileOutputStream(output);
            OutputStreamWriter outputSW = new OutputStreamWriter(fileO);
            Writer w = new BufferedWriter(outputSW);
            for(Person dudeguy: toOutput){
                w.write(dudeguy.outputPerson());
            }
            w.write("\n\nThe most populous year with this set of people is: " + populousYear);
            w.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}


