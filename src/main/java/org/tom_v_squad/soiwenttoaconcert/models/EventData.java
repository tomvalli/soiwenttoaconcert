package org.tom_v_squad.soiwenttoaconcert.models;

import java.util.ArrayList;

public class EventData {

    public static ArrayList<Event> findByColumnAndValue(String column, String value, Iterable<Event> allEvents) {

        ArrayList<Event> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Event>) allEvents;
        }

        if (column.equals("all")){
            results = findByValue(value, allEvents);
            return results;
        }
        for (Event event : allEvents) {

            String aValue = getFieldValue(event, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(event);
            }
        }

        return results;
    }

    public static String getFieldValue(Event event, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = event.getArtistName();
        } else if (fieldName.equals("location")){
            theValue = event.getLocation().toString();
        } else if (fieldName.equals("date")){
            theValue = event.getDate().toString();
        } else {
            theValue = event.toString();
        }

        return theValue;
    }

    public static ArrayList<Event> findByValue(String value, Iterable<Event> allEvents) {
        String lower_val = value.toLowerCase();

        ArrayList<Event> results = new ArrayList<>();

        for (Event event : allEvents) {

            if (event.getArtistName().toLowerCase().contains(lower_val)) {
                results.add(event);
            } else if (event.getLocation().toString().toLowerCase().contains(lower_val)) {
                results.add(event);
            } else if (event.toString().toLowerCase().contains(lower_val)) {
                results.add(event);
            } else if (event.getDate().toLowerCase().contains(lower_val)) {
                results.add(event);
            }
        }

        return results;
    }
    }
