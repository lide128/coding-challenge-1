package problem1;

import java.util.ArrayList;

/**
 * This class contains the main code for finding the most populous year from the set of fictitious persons.
 * Created by Alex White on 4/7/17.
 */
public class MostPopulous {

    /**
     * This method finds the most populous year given a list of people and a range of years.
     * It outputs the first most populous year when encountered with multiple equal years.
     * @param listOfPeople  - an array list of Person objects of any given size.
     * @param timeSpan      - a range of years in which to perform the search.
     * @return
     */
    public static int findMostPopulousYear(ArrayList<Person> listOfPeople, Range timeSpan){

        final int SUBTRACTOR = timeSpan.start;
        final int SPAN = timeSpan.total;
        int subjectNum = 0;
        String subjectName;
        int birth, death;

        int peopleCount = listOfPeople.size();
        String[][] yearSpan = new String[SPAN][peopleCount];

        for(Person subject : listOfPeople){
            subjectName = subject.fullName;
            birth = subject.birthYear - SUBTRACTOR;
            death = subject.deathYear - SUBTRACTOR;
            if(death >= SPAN){
                death = SPAN - 1;
            }
            if(birth <= 0){
                birth = 0;
            }
            if((birth > 0) && (death < SPAN)) {
                for (int i = birth; i <= death; i++) {
                    yearSpan[i][subjectNum] = subjectName;
                }
            }
            subjectNum++;
        }

        int currentPeoplePerYear;
        int standingRecord = 0;
        int mostPopulousYear = 0;

        for(int i = 0; i < SPAN; i++){
            currentPeoplePerYear = 0;
            for(int j = 0; j < peopleCount; j++){
                if(yearSpan[i][j] != null) currentPeoplePerYear++;
            }
            if(currentPeoplePerYear > standingRecord){
                mostPopulousYear = i + SUBTRACTOR;
                standingRecord = currentPeoplePerYear;
            }
        }
        return mostPopulousYear;
    }


    public static int findMostPopulousRange(ArrayList<Person> listOfPeople, Range timeSpan){

        return 0;
    }
}
