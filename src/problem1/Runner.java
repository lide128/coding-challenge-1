package problem1;

import java.util.*;
/**
 * ---------- CHANGE THIS COMMENT -------------
 * Created by Alex White on 4/5/2017.
 */
public class Runner {

    public static void main(String [] args){

//        Person subject1 = new Person(1960, 2000, "Steve");
//        Person subject2 = new Person(1939, 1997, "Mary");
//        Person subject3 = new Person(1912, 1989, "Brian");
//        Person subject4 = new Person(1990, 2067, "Sarah");
//        Person subject5 = new Person(1970, 1980, "Jennifer");
//        Person subject6 = new Person(1975, 2010, "Jason");
//        Person subject7 = new Person(2001, 2100,"Future Steve");
//        Person subject8 = new Person(1850, 1890, "Past Jennifer");

//        Person subject1 = new Person(1968,1986,"Isika");
//        Person subject2 = new Person(1941,1990,"Ujoyol");
//        Person subject3 = new Person(1907,1924,"Bgebe");
//        Person subject4 = new Person(1933,1950,"Knig");
//        Person subject5 = new Person(1906,1908,"Mgejuy");
//        Person subject6 = new Person(1914,1963,"Phusywer");
//        Person subject7 = new Person(1984,1987,"Wlib");
//        Person subject8 = new Person(1954,1957,"Jcesyr");
//        Person subject9 = new Person(1912,1923,"Ymuk");
//        Person subject10 = new Person(1903,1946,"Bziyodomer");
//        Person subject11 = new Person(1936,1962,"Psoluhafec");
//        Person subject12 = new Person(1914,1989,"Ilegan");
//        Person subject13 = new Person(1916,1927,"Osocah");
//        Person subject14 = new Person(1915,1924,"Llofuj");
//        Person subject15 = new Person(1902,1904,"Zroj");
//        Person subject16 = new Person(1942,1965,"Zwol");
//        Person subject17 = new Person(1901,1935,"Ydofyh");
//        Person subject18 = new Person(1909,1941,"Xsukef");
//        Person subject19 = new Person(1900,1901,"Qdonyh");
//        Person subject20 = new Person(1958,1984,"Kgoja");


//        ArrayList<Person> people = new ArrayList<Person>();
//        people.add(subject1);
//        people.add(subject2);
//        people.add(subject3);
//        people.add(subject4);
//        people.add(subject5);
//        people.add(subject6);
//        people.add(subject7);
//        people.add(subject8);
//        people.add(subject9);
//        people.add(subject10);
//        people.add(subject11);
//        people.add(subject12);
//        people.add(subject13);
//        people.add(subject14);
//        people.add(subject15);
//        people.add(subject16);
//        people.add(subject17);
//        people.add(subject18);
//        people.add(subject19);
//        people.add(subject20);

        Range yearsToSearch = new Range(1900, 2000);

        ArrayList<Person> randomPeople = Creator.createListOfPeople(4, yearsToSearch);
        Creator.printPersonList(randomPeople);

        int answerYear = findMostPopulousYear(randomPeople, yearsToSearch);
//        int answerYear = findMostPopulousYear(people, 1900, 2000);
        Creator.outputPersonList(randomPeople, answerYear);


        System.out.println("The most populous year with this set of people is: " + answerYear);
    }

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
