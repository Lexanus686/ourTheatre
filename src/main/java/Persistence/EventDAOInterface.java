package Persistence;

import java.util.ArrayList;

public interface EventDAOInterface extends Repository<EventDTO> {
    ArrayList<EventDTO> getInfo(EventDTO dto);
}
