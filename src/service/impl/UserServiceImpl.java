package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao =new UserDaoImpl();
    @Override
    public void registUser(User user) {
            userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
       return userDao.queryByNameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUsername(String name) {
        if (userDao.queryByUserame(name)==null){
            return  true;
        }
        return false;
    }
}
