package Persistence;

public class EventDTO {
    private Integer id;

    private Integer eventId;

    private Integer userId;

    private Integer row;

    private Integer place;

    private Integer price;

    public EventDTO(Integer id, Integer eventId, Integer userId, Integer row, Integer place, Integer price) {
        this.id = id;
        this.eventId = eventId;
        this.userId = userId;
        this.row = row;
        this.place = place;
        this.price = price;
    }

    public EventDTO(Integer eventId, Integer userId, Integer row, Integer place, Integer price) {
        this.eventId = eventId;
        this.userId = userId;
        this.row = row;
        this.place = place;
        this.price = price;
    }

    public EventDTO(Integer eventId, Integer row, Integer place, Integer price) {
        this.eventId = eventId;
        this.row = row;
        this.place = place;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
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
