package Persistence;

import BL.entities.Event;

import java.sql.*;
import java.util.ArrayList;

public class EventDAO implements EventDAOInterface {
    private Connection connection;

    public EventDAO() {
        try {
            this.connection = DBHandler.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static EventDTO convertEventToEventDTO(Event event) {
        return new EventDTO(event.getEventId(), event.getUserID(), event.getRow(), event.getPlace(), event.getPrice());
    }

    public static Event convertEventDTOToEvent(EventDTO eventDTO) {
        return new Event(eventDTO.getEventId(), eventDTO.getUserId(), eventDTO.getRow(), eventDTO.getPlace(), eventDTO.getPrice());
    }

    @Override
    public EventDTO getObject(EventDTO dto) {
        return null;
    }

    @Override
    public void addObject(EventDTO dto) {

    }

    @Override
    public void removeObject(EventDTO dto) {

    }

    @Override
    public void updateObject(EventDTO dto) {
        String sql = "UPDATE SPECTACLE" + dto.getEventId() +
                " SET USERID = ? WHERE ROW = ? AND PLACE = ?";
        try {
            PreparedStatement statement = this.connection.prepareStatement("UPDATE SPECTACLE" + dto.getEventId() +
                    " SET USERID = ? WHERE ROW = ? AND PLACE = ?");
            statement.setObject(1, dto.getUserId());
            statement.setObject(2, dto.getRow());
            statement.setObject(3, dto.getPlace());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<EventDTO> getInfo(EventDTO dto) {
        ArrayList<EventDTO> eventDTOS = new ArrayList<EventDTO>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Spectacle%d", dto.getEventId()));

            while (resultSet.next()) {
                EventDTO tmp = new EventDTO(resultSet.getInt(1), resultSet.getInt(2),
                        resultSet.getInt(3), resultSet.getInt(4),
                        resultSet.getInt(5));
                eventDTOS.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventDTOS;
    }
}
