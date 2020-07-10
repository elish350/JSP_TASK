package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.MemberBean;
import model.DataBase;

public class MemberDao {
    private static Connection con;
	public static int save(MemberBean bean){
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
                            ps=con.prepareStatement("insert into projectmember (name,userid,email,phone) values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
                            ps.setString(1,bean.getName());
                            ps.setString(2,String.valueOf(new_id));
                            ps.setString(3,bean.getEmail());
                            ps.setString(4,String.valueOf(bean.getMobile()));
                            status=ps.executeUpdate();
                        }
                        else {
                            throw new SQLException("Creating user failed, no ID obtained.");
                        }
                        con.close();;
			
		}catch(SQLException e){System.out.println(e);}
		
		return status;
	}
	public static int update(MemberBean bean){
		int status=0;
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("update useraccount,projectmember set useraccount.name=?,useraccount.password=?,projectmember.name=?,projectmember.email=?,projectmember.phone=? where projectmember.id=? and projectmember.userid=useraccount.id");
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getPassword());
                        ps.setString(3,bean.getName());
                        ps.setString(4,bean.getEmail());
                        ps.setString(5,String.valueOf(bean.getMobile()));
			ps.setInt(6,bean.getId());
			status=ps.executeUpdate();
			con.close();
			
		}catch(SQLException e){System.out.println(e);}
		
		return status;
	}
	public static List<MemberBean> view(){
		List<MemberBean> list=new ArrayList<MemberBean>();
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("select projectmember.*,useraccount.password  from projectmember, useraccount where projectmember.userid = useraccount.id");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				MemberBean bean=new MemberBean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setMobile(rs.getLong("phone"));
				list.add(bean);
			}
			con.close();
			
		}catch(SQLException e){System.out.println(e);}
		
		return list;
	}
	public static MemberBean viewById(int id){
		MemberBean bean=new MemberBean();
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("select projectmember.*,password from projectmember,useraccount where projectmember.id=? and useraccount.id = projectmember.userid");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
                                bean.setEmail(rs.getString(4));
                                bean.setMobile(Long.parseLong(rs.getString(5)));
				bean.setPassword(rs.getString(7));
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return bean;
	}
	public static int delete(int id){
		int status=0;
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("delete from projectmember where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
			
		}catch(SQLException e){System.out.println(e);}
		
		return status;
	}

	public static boolean authenticate(String email,String password){
		boolean status=false;
		try{
			con=DataBase.getCon();
                        PreparedStatement ps=con.prepareStatement("select * from projectmember, useraccount where projectmember.email=? and useraccount.password=? and useraccount.id = projectmember.userid");
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(SQLException e){System.out.println(e);}
		
		return status;
	}
}
