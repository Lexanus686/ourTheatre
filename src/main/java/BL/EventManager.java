package BL;

import BL.entities.Event;
import Persistence.EventDAO;
import Persistence.EventDAOInterface;
import Persistence.EventDTO;

import java.util.ArrayList;

import static Persistence.EventDAO.convertEventDTOToEvent;
import static Persistence.EventDAO.convertEventToEventDTO;

public class EventManager implements EventManagerInterface {
    private EventDAOInterface eventRepository;
    private Event currentEvent;

    public EventManager() {
        eventRepository = new EventDAO();
    }

    @Override
    public Event getCurrentEvent() {
        return this.currentEvent;
    }

    @Override
    public void setCurrentEvent(Event event) {
        this.currentEvent = event;
    }

    @Override
    public void updateEvent(Event event) {
        eventRepository.updateObject(convertEventToEventDTO(event));
    }

    @Override
    public void fullyUpdateEvent() {
        updateEvent(this.currentEvent);
    }

    @Override
    public ArrayList<Event> getInfo(Event event) {

        ArrayList<EventDTO> eventDTOS = eventRepository.getInfo(convertEventToEventDTO(event));

        ArrayList<Event> tmp = new ArrayList<Event>();
        for (EventDTO eventDTO : eventDTOS) {
            if (eventDTO.getUserId() == 0)
                tmp.add(convertEventDTOToEvent(eventDTO));
        }

        return tmp;
    }
}
