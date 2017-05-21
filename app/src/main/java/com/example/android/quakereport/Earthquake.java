package com.example.android.quakereport;

/**
 * {@link Earthquake} represents an Earthquake event data from USGS.
 * It contains the magnitude, place, and date of the earthquake.
 */

public class Earthquake {

    /* Magnitude of the earthquake */
    private String mMagnitude;

    /* Closest city of the earthquake */
    private String mPlace;

    /* Time of the earthquake in the format of milliseconds*/
    private long mTimeInMilliseconds;

    /**
     * Create a new Earthquake object.
     *
     * @param magnitude is the magnitude of the earthquake.
     * @param place is the string city that is closest to the earthquake
     * @param timeInMilliseconds is the time of when the earthquake occurred.
     */
    public Earthquake(String magnitude, String place, long timeInMilliseconds) {
        this.mMagnitude = magnitude;
        this.mPlace = place;
        this.mTimeInMilliseconds = timeInMilliseconds;
    }

    /**
     * Return the magnitude of the earthquake.
     */
    public String getMagnitude() {
        return mMagnitude;
    }

    /**
     * Return the place of the earthquake.
     */
    public String getPlace() {
        return mPlace;
    }

    /**
     * Return the date of the earthquake.
     */
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

}
