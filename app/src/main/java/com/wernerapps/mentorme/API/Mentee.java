package com.wernerapps.mentorme.API;

/**
 * Created by Tom on 4/18/2015.
 */
public class Mentee implements Comparable<Mentee>{
    public final String major;
    public final String name;
    public final String reason;
    public final double bonus;

    public Mentee(String name, String major, String reason, double cashBonus) {
        this.name = name;
        this.major = major;
        this.reason = reason;
        this.bonus = cashBonus;
    }

    @Override
    public int compareTo(Mentee another) {
        return name.compareTo(another.name);
    }
}
