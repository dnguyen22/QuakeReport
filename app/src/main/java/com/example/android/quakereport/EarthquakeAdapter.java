package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;


import java.util.List;


/**
 * Created by Don on 5/20/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    /* Separtaor for full location string*/
    private static final String LOCATION_SEPARATOR = " of ";

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the earthquake data we want
     * to populate into the lists.
     *
     * @param context       The current context. Used to inflate the layout file.
     * @param objects       A List of Earthquake objects to dipsplay in a list.
     */
    public EarthquakeAdapter(@NonNull Context context, @NonNull List<Earthquake> objects) {
        super(context, 0, objects);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Earthquake} object located at this position in the list
        Earthquake currentEarthquake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        // Get the magnitude from the current Earthquake object and
        // format the magnitude to one decimal place
        DecimalFormat formatter = new DecimalFormat("0.0");
        String formattedMagnitude = formatter.format(currentEarthquake.getMagnitude());
        // Set this text on the magnitude TextView
        magnitudeTextView.setText(formattedMagnitude);

        String fullLocation = currentEarthquake.getPlace();
        String primaryLocation;
        String locationOffset;

        if (fullLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = fullLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = fullLocation;
        }

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView offsetLocationTextView = (TextView) listItemView.findViewById(R.id.offset_location);
        // Get the offset location name from the current Earthquake object and
        // set this text on the offset location TextView
        offsetLocationTextView.setText(locationOffset);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView primaryLocationTextView = (TextView) listItemView.findViewById(R.id.primary_location);
        // Get the primary location name from the current Earthquake object and
        // set this text on the primary location TextView
        primaryLocationTextView.setText(primaryLocation);

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        // Get the date from the current Earthquake object and
        // set this text on the date TextView

        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateTextView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
