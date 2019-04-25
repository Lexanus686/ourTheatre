package BL.entities;

public class Event {

    private Integer eventId;
    private Integer userID;
    private Integer row;
    private Integer place;
    private Integer price;

    public Event(Integer eventId, Integer userID, Integer row, Integer place, Integer price) {
        this.eventId = eventId;
        this.userID = userID;
        this.row = row;
        this.place = place;
        this.price = price;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getId() {
        return eventId;
    }

    public void setId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
