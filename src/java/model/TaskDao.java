package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TaskBean;
import model.LeaderBean;
import model.DataBase;
public class TaskDao {
    private static Connection con;
	public static int save(TaskBean bean){
		int status=0;
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("insert into Task (title,description,deadline,state,projectID) values(?,?,?,?,?)");
			ps.setString(1,bean.getTitle());
			ps.setString(2,bean.getDescription());
			ps.setString(3,bean.getDeadline());
                        ps.setString(4,bean.getState());
                        ps.setInt(5,bean.getProject());
			status=ps.executeUpdate();
			con.close();
			
		}catch(SQLException e){System.out.println(e);}
		
		return status;
	}
	public static List<TaskBean> view(){
		List<TaskBean> list=new ArrayList<TaskBean>();
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("select t.*, s.name state_name from Task t, state s where t.state = s.id");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				TaskBean bean=new TaskBean();
				bean.setId(Integer.parseInt(rs.getString("id")));
				bean.setTitle(rs.getString("title"));
				bean.setDescription(rs.getString("description"));
				bean.setDeadline(rs.getString("deadline"));
                                bean.setState(rs.getString("state"));
                                bean.setProject(Integer.parseInt(rs.getString("projectId")));
                                bean.setState_name(rs.getString("state_name"));
				
				list.add(bean);
			}
			con.close();
			
		}catch(SQLException e){System.out.println(e);}
		
		return list;
	}
	public static int delete(int callno){
		int status=0;
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("delete from Task where id=?");
			ps.setInt(1,callno);
			status=ps.executeUpdate();
			con.close();
			
		}catch(SQLException e){System.out.println(e);}
		
		return status;
	}
	public static int getIssued(String callno){
		int issued=0;
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_task where callno=?");
			ps.setString(1,callno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				issued=rs.getInt("issued");
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return issued;
	}
	public static boolean checkIssue(String callno){
		boolean status=false;
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_task where callno=? and quantity>issued");
			ps.setString(1,callno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static int returnBook(String callno,int studentid){
		int status=0;
			try{
				con=DataBase.getCon();
				PreparedStatement ps=con.prepareStatement("update e_issuebook set returnstatus='yes' where callno=? and studentid=?");
				ps.setString(1,callno);
				ps.setInt(2,studentid);
				
				status=ps.executeUpdate();
				if(status>0){
					PreparedStatement ps2=con.prepareStatement("update e_book set issued=? where callno=?");
					ps2.setInt(1,getIssued(callno)-1);
					ps2.setString(2,callno);
					status=ps2.executeUpdate();
				}
				con.close();
				
			}catch(Exception e){System.out.println(e);}
			
			return status;
	}

    public static int update(TaskBean bean) {
        int status=0;
        try{
            con=DataBase.getCon();
            PreparedStatement ps=con.prepareStatement("update task set title=?,description=?,deadline=?,state=?, projectid=? where id=?");
            ps.setString(1,bean.getTitle());
            ps.setString(2,bean.getDescription());
            ps.setString(3,bean.getDeadline());
            ps.setString(4,bean.getState());
            ps.setInt(5,bean.getProject());
            ps.setInt(6,bean.getId());
            status=ps.executeUpdate();
            con.close();

        }catch(SQLException e){System.out.println(e);}

        return status;
    }

    public static TaskBean viewById(int id) {
        TaskBean bean=new TaskBean();
        try{
                con=DataBase.getCon();
                PreparedStatement ps=con.prepareStatement("select * from task where id=?");
                ps.setInt(1,id);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                        bean.setId(rs.getInt(1));
                        bean.setTitle(rs.getString(2));
                        bean.setDescription(rs.getString(3));
                        bean.setDeadline(rs.getString(4));
                        bean.setState(rs.getString(5));
                        bean.setProject(rs.getInt(6));
                }
                con.close();

        }catch(SQLException e){System.out.println(e);}

        return bean;
    }
}