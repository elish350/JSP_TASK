package model;

public class ProjectBean {
    private int id,userid;
    private String title,startdate,enddate,status;

    public ProjectBean() {}

    public ProjectBean(String title, String startdate, String enddate, String status,int userid) {
        this.title = title;
        this.startdate = startdate;
        this.enddate = enddate;
        this.status = status;
        this.userid = userid;
    }

    
    public ProjectBean(int id, String title, String startdate, String enddate, String status, int userid) {
        this.id = id;
        this.userid = userid;
        this.title = title;
        this.startdate = startdate;
        this.enddate = enddate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProjectBean{" + "id=" + id + ", userid=" + userid + ", title=" + title + ", startdate=" + startdate + ", enddate=" + enddate + ", status=" + status + '}';
    }
    
}
