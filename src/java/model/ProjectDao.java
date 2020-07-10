package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ProjectBean;
import model.LeaderBean;
import model.DataBase;
public class ProjectDao {
    private static Connection con;
	public static int save(ProjectBean bean){
		int status=0;
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("insert into Project (title,startdate,enddate,status,clientid) values(?,?,?,?,?)");
			ps.setString(1,bean.getTitle());
			ps.setString(2,bean.getStartdate());
			ps.setString(3,bean.getEnddate());
                        ps.setString(4,bean.getStatus());
                        ps.setInt(5, bean.getUserid());
			status=ps.executeUpdate();
			con.close();
			
		}catch(SQLException e){System.out.println(e);}
		
		return status;
	}
	public static List<ProjectBean> view(){
		List<ProjectBean> list=new ArrayList<ProjectBean>();
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("select * from Project");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ProjectBean bean=new ProjectBean();
				bean.setId(rs.getInt("id"));
                                bean.setTitle(rs.getString("title"));
				bean.setStartdate(rs.getString("startDate"));
				bean.setEnddate(rs.getString("endDate"));
				bean.setStatus(rs.getString("status"));
                                bean.setUserid(Integer.parseInt(rs.getString("clientid")));
				list.add(bean);
			}
                        System.out.println(list.size()+"---------------");
			con.close();
			
		}catch(SQLException e){System.out.println(e);}
		
		return list;
	}
	public static int delete(int callno){
		int status=0;
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("delete from Project where id=?");
			ps.setInt(1,callno);
			status=ps.executeUpdate();
			con.close();
			
		}catch(SQLException e){System.out.println(e);}
		
		return status;
	}
	public static int update(ProjectBean bean){
		int status=0;
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("update project set title=?,StartDate=?,EndDate=?,Status=?,ClientId=? where id = ?");
			ps.setString(1,bean.getTitle());
			ps.setString(2,bean.getStartdate());
                        ps.setString(3,bean.getEnddate());
                        ps.setString(4,bean.getStatus());
                        ps.setInt(5, bean.getUserid());
                        ps.setInt(6,bean.getId());
			status=ps.executeUpdate();
			con.close();
			
		}catch(SQLException e){System.out.println(e);}
		
		return status;
	}
        public static ProjectBean viewById(int id){
		ProjectBean bean=new ProjectBean();
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("select * from project where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				bean.setId(rs.getInt(1));
				bean.setTitle(rs.getString(2));
                                bean.setStartdate(rs.getString(3));
                                bean.setEnddate(rs.getString(4));
				bean.setStatus(rs.getString(5));
                                bean.setUserid(rs.getInt(6));
			}
			con.close();
			
		}catch(SQLException e){System.out.println(e);}
		
		return bean;
	}
}