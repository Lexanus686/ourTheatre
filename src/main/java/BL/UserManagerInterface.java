package BL;

import BL.entities.User;

public interface UserManagerInterface {
    void addUser(User user);

    User getCurrentUser();

    void setCurrentUser(User user);

    void fullyAddUser();
}
