package model;

public class LeaderBean {
    
    private int id,userid;
    private String name,email,password;
    private long mobile;

    public LeaderBean() {}

    public LeaderBean(String name, String email, String password, long mobile) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
    }

    public LeaderBean(int id, String name, String email, String password, long mobile) {
            super();
            this.id = id;
            this.name = name;
            this.email = email;
            this.mobile = mobile;
            this.password = password;
    }

    public int getId() {
            return id;
    }
    public void setId(int id) {
            this.id = id;
    }
    public String getName() {
            return name;
    }
    public void setName(String name) {
            this.name = name;
    }
    public String getEmail() {
            return email;
    }
    public void setEmail(String email) {
            this.email = email;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
