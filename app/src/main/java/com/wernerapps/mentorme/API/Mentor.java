package com.wernerapps.mentorme.API;

/**
 * Created by Tom on 4/18/2015.
 */
public class Mentor implements Comparable<Mentor>{
    public final String major;
    public final int rating;
    public final double gpa;
    public final String name;

    public Mentor(String name, double gpa, int rating, String major) {
        this.name = name;
        this.gpa = gpa;
        this.rating = rating;
        this.major = major;
    }

    @Override
    public int compareTo(Mentor another) {
        if (rating == another.rating)
            return 0;
        else if (rating > another.rating)
            return 1;
        else
            return -1;
    }
}
