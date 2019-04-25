package BL;

import BL.entities.User;
import Persistence.UserDAO;

import static Persistence.UserDAO.convertUserToUserDTO;

public class UserManager implements UserManagerInterface {

    private UserDAO userRepository;
    private User currentUser;

    public UserManager() {
        userRepository = new UserDAO();
    }

    @Override
    public void fullyAddUser() {
        addUser(this.currentUser);
    }

    @Override
    public void addUser(User user) {
        userRepository.addObject(convertUserToUserDTO(user));
    }

    @Override
    public User getCurrentUser() {
        return this.currentUser;
    }

    @Override
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }
}
