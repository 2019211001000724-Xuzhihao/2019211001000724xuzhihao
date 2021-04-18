package com.Xuzhihao.dao;

import com.Xuzhihao.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        return null;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql="select * from Usertable where username=? and password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {

        String sql="select * from Usertable where username=?";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        List<User> users = null;
        if(rs.next()){
            User user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {

        String sql="select * from Usertable where password=?";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        List<User> users = null;
        if(rs.next()){
            User user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {

        String sql="select * from Usertable where email=?";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        List<User> users = null;
        if(rs.next()){
            User user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {

        String sql="select * from Usertable where Gender=?";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        List<User> users = null;
        if(rs.next()){
            User user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {

        String sql="select * from Usertable where birthdate=?";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        List<User> users = null;
        if(rs.next()){
            User user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {

        String sql="select * from Usertable";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        List<User> users = null;
        if(rs.next()){
            User user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            users.add(user);
        }
        return users;
    }
}
