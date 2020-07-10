package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.DataBase;

public class UserDao {
    private static Connection con;
	public static int save(UserBean bean){
		int status=0;
		try{
                    con=DataBase.getCon();
                    PreparedStatement ps=con.prepareStatement("insert into UserAccount (name,password) values(?,?)",Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1,bean.getUsername());
                    ps.setString(2,bean.getPassword());
                    status=ps.executeUpdate();
                    int affectedRows = status;

                    if (affectedRows == 0) {
                        throw new SQLException("Creating user failed, no rows affected.");
                    }
                    con.close();
			
		}catch(SQLException e){System.out.println(e);}
		
		return status;
	}
	public static int update(UserBean bean){
		int status=0;
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("update useraccount set useraccount.name=?,useraccount.password=? where id=?");
			ps.setString(1,bean.getUsername());
			ps.setString(2,bean.getPassword());
			ps.setInt(3,bean.getId());
			status=ps.executeUpdate();
			con.close();
			
		}catch(SQLException e){System.out.println(e);}
		
		return status;
	}
	public static List<UserBean> view(){
		List<UserBean> list=new ArrayList<>();
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("select * from useraccount");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				UserBean bean=new UserBean();
				bean.setId(rs.getInt("id"));
				bean.setUsername(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				list.add(bean);
                                System.out.println(bean.getUsername());
			}
			con.close();
			
		}catch(SQLException e){System.out.println(e);}
		
		return list;
	}
	public static UserBean viewById(int id){
		UserBean bean=new UserBean();
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("select * from useraccount where useraccount.id = ?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				bean.setId(rs.getInt(1));
				bean.setUsername(rs.getString(2));
				bean.setPassword(rs.getString(3));
			}
			con.close();
			
		}catch(SQLException e){System.out.println(e);}
		
		return bean;
	}
	public static int delete(int id){
		int status=0;
		try{
			con=DataBase.getCon();
                        PreparedStatement ps=con.prepareStatement("delete from adminn where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
			
		}catch(SQLException e){System.out.println(e);}
		
		return status;
	}

	public static boolean authenticate(String username,String password){
		boolean status=false;
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("select * from UserAccount where username=? and password=?");
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(SQLException e)
                {System.out.println(e);}
		
		return status;
	}
}
