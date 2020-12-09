package dao.impl;

import dao.BaseDao;
import dao.UserDao;
import domain.User;

public class UserDaoImpl   extends BaseDao implements UserDao {
    @Override
    public User queryByUserame(String username) {
        String sql="select * from t_user where username=?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public int saveUser(User user) {
        String sql="insert into t_user(username,password,email)values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryByNameAndPassword(String username, String pwd) {
        String sql="select * from t_user where username=? and password=?";
        return queryForOne(User.class,sql,username,pwd);
    }
}
