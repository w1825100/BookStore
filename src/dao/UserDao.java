package dao;

import domain.User;

public interface UserDao {

     User queryByUserame(String username);
     int saveUser(User user);
     User queryByNameAndPassword(String name,String pwd);


}
