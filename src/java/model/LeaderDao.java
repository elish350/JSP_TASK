package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.DataBase;

import model.LeaderBean;

public class LeaderDao {
        private static Connection con;
	public static int save(LeaderBean bean){
		int status=0;
		try{
                    con=DataBase.getCon();
                    PreparedStatement ps=con.prepareStatement("insert into UserAccount (name,password) values(?,?)",Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1,bean.getName());
                    ps.setString(2,bean.getPassword());
                    status=ps.executeUpdate();
                    int affectedRows = status;

                    if (affectedRows == 0) {
                        throw new SQLException("Creating user failed, no rows affected.");
                    }

                    ResultSet generatedKeys = ps.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        Long new_id = generatedKeys.getLong(1);
                        ps=con.prepareStatement("insert into leader (name,userid,email,phone) values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
                        ps.setString(1,bean.getName());
                        ps.setString(2,String.valueOf(new_id));
                        ps.setString(3,bean.getEmail());
                        ps.setString(4,String.valueOf(bean.getMobile()));
                        status=ps.executeUpdate();
                    }
                    else {
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                    con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static int update(LeaderBean bean){
		int status=0;
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("update useraccount,leader set useraccount.name=?,useraccount.password=?,leader.name=?,leader.email=?,leader.phone=? where leader.id=? and leader.userid=useraccount.id");
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getPassword());
                        ps.setString(3,bean.getName());
                        ps.setString(4,bean.getEmail());
                        ps.setString(5,String.valueOf(bean.getMobile()));
			ps.setInt(6,bean.getId());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static List<LeaderBean> view(){
		List<LeaderBean> list=new ArrayList<LeaderBean>();
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("select leader.*,useraccount.password  from leader, useraccount where leader.userid = useraccount.id");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				LeaderBean bean=new LeaderBean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setMobile(rs.getLong("phone"));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	public static LeaderBean viewById(int id){
		LeaderBean bean=new LeaderBean();
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("select leader.*,password from leader,useraccount where leader.id=? and useraccount.id = leader.userid");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
                                bean.setEmail(rs.getString(4));
                                bean.setMobile(Long.parseLong(rs.getString(5)));
				bean.setPassword(rs.getString(6));
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return bean;
	}
	public static int delete(int id){
		int status=0;
		try{
			con=DataBase.getCon();
                        PreparedStatement ps=con.prepareStatement("select userid from leader where leader.id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
                        int userid = 0;
			if(rs.next()){
				userid = rs.getInt(1);
			}
			ps=con.prepareStatement("delete from UserAccount where id=?");
			ps.setInt(1,userid);
			status=ps.executeUpdate();
                        ps=con.prepareStatement("delete from leader where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}

	public static boolean authenticate(String email,String password){
		boolean status=false;
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("select * from leader, useraccount where leader.email=? and useraccount.password=? and useraccount.id = leader.userid");
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
}
