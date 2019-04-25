package BL.entities;

public class User {
    private String email;
    private String name;
    private String surname;
    private String phone;

    public User(String email, String name, String surname, String phone) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public User() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getHashID() {
        if (this.email != " ") {
            if (this.email.hashCode() < 0)
                return this.email.hashCode() * (-1);
            else return this.email.hashCode();
        } else return 0;
    }
}
