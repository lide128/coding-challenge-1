package problem1;

/**
 * A class to describe a range of years, with a beginning and an end.
 * Created by Alex White on 4/5/2017.
 */
public class Range {

    int start, finish, total;

    public Range(int begin, int end){
        start = begin;
        finish = end;
        total = end - begin;
    }
}
