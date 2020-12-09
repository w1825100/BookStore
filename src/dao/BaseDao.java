package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract  class BaseDao {
  private  QueryRunner qr=new QueryRunner();

//  增删改通用
    public int update(String sql,Object ...args){
        Connection conn= JDBCUtils.getConnection();
        try {
            return  qr.update(conn,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
        return -1;
    }
//    返回泛型单个对象
    public <T> T queryForOne(Class<T> type,String sql,Object ...args){
        Connection conn =JDBCUtils.getConnection();
        try {
            return qr.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
        return null;
    }
//    返回对象集合
    public <T> List<T> queryForList(Class<T> type,String sql,Object ...args){
        Connection conn =JDBCUtils.getConnection();
        try {
            return qr.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
        return  null;
    }
//返回单个值
    public Object queryForSingleValue(String sql,Object ...args){
    Connection conn =JDBCUtils.getConnection();
        try {
            return   qr.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
        return null;
    }



}
