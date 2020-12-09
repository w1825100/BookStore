package service;

import domain.User;

public interface UserService {
     void registUser(User user);
    User login(User  user);
    boolean existUsername(String name);
}
