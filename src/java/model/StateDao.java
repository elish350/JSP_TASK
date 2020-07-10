package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.StateBean;
import model.LeaderBean;
import model.DataBase;
public class StateDao {
    private static Connection con;
	public static int save(StateBean bean){
		int status=0;
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("insert into State (name) values(?)");
			ps.setString(1,bean.getName());
			status=ps.executeUpdate();
			con.close();
			
		}catch(SQLException e){System.out.println(e);}
		
		return status;
	}
	public static List<StateBean> view(){
		List<StateBean> list=new ArrayList<StateBean>();
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("select * from State");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				StateBean bean=new StateBean();
				bean.setId(Integer.parseInt(rs.getString("id")));
				bean.setName(rs.getString("name"));
				list.add(bean);
			}
			con.close();
			
		}catch(SQLException e){System.out.println(e);}
		
		return list;
	}
	public static int delete(String id){
		int status=0;
		try{
			con=DataBase.getCon();
			PreparedStatement ps=con.prepareStatement("delete from State where id=?");
			ps.setString(1,id);
			status=ps.executeUpdate();
			con.close();
			
		}catch(SQLException e){System.out.println(e);}
		
		return status;
	}
	
        
        
//    public static int update(StateBean bean) {
//        int status=0;
//        try{
//            con=DataBase.getCon();
//            PreparedStatement ps=con.prepareStatement("update task set title=?,description=?,deadline=?,state=?, projectid=? where id=?");
//            ps.setString(1,bean.getTitle());
//            ps.setString(2,bean.getDescription());
//            ps.setString(3,bean.getDeadline());
//            ps.setString(4,bean.getState());
//            ps.setInt(5,bean.getProject());
//            ps.setInt(6,bean.getId());
//            status=ps.executeUpdate();
//            con.close();
//
//        }catch(SQLException e){System.out.println(e);}
//
//        return status;
//    }
//
//    public static StateBean viewById(int id) {
//        StateBean bean=new StateBean();
//        try{
//                con=DataBase.getCon();
//                PreparedStatement ps=con.prepareStatement("select * from task where id=?");
//                ps.setInt(1,id);
//                ResultSet rs=ps.executeQuery();
//                if(rs.next()){
//                        bean.setId(rs.getInt(1));
//                        bean.setTitle(rs.getString(2));
//                        bean.setDescription(rs.getString(3));
//                        bean.setDeadline(rs.getString(4));
//                        bean.setState(rs.getString(5));
//                        bean.setProject(rs.getInt(6));
//                }
//                con.close();
//
//        }catch(SQLException e){System.out.println(e);}
//
//        return bean;
//    }
}