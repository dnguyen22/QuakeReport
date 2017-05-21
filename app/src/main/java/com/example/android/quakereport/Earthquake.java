package com.example.android.quakereport;

/**
 * {@link Earthquake} represents an Earthquake event data from USGS.
 * It contains the magnitude, place, and date of the earthquake.
 */

public class Earthquake {

    /* Magnitude of the earthquake */
    private Double mMagnitude;

    /* Closest city of the earthquake */
    private String mPlace;

    /* Time of the earthquake in the format of milliseconds */
    private long mTimeInMilliseconds;

    /* URL of the earthquake on USGS.gov */
    private String mUrl;

    /**
     * Create a new Earthquake object.
     *
     * @param magnitude is the magnitude of the earthquake.
     * @param place is the string city that is closest to the earthquake
     * @param timeInMilliseconds is the time of when the earthquake occurred.
     * @param url is the website URL to find more details about the earthquake on USGS.gov.
     */
    public Earthquake(Double magnitude, String place, long timeInMilliseconds, String url) {
        this.mMagnitude = magnitude;
        this.mPlace = place;
        this.mTimeInMilliseconds = timeInMilliseconds;
        this.mUrl = url;
    }

    /**
     * Return the magnitude of the earthquake.
     */
    public Double getMagnitude() {
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

    /**
     * Return the URL of the earthquake.
     */
    public String getUrl() {
        return mUrl;
    }
}
