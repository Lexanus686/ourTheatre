package BL;

import BL.entities.Event;

import java.util.ArrayList;

public interface EventManagerInterface {
    void updateEvent(Event event);

    ArrayList<Event> getInfo(Event event);

    void fullyUpdateEvent();

    Event getCurrentEvent();

    void setCurrentEvent(Event event);
}
