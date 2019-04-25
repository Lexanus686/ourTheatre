package Persistence;

public class UserDTO {
    private int id;
    private String email;
    private String name;
    private String surname;
    private String phone;

    public UserDTO(int id, String email, String name, String surname, String phone) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    UserDTO(String email, String name, String surname, String phone) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
