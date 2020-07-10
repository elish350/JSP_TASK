package model;

public class TaskBean {
    private String title,description,deadline,state,state_name;
    private int id,project;

    public TaskBean(int id, String title, String description, String deadline, String state,  int project) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.state = state;
        this.id = id;
        this.project = project;
    }

    public TaskBean(String title, String description, String deadline, String state, int project) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.state = state;
        this.project = project;
    }

    public TaskBean(int id, String title, String description, String deadline, String state, int project, String state_name) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.state = state;
        this.state_name = state_name;
        this.id = id;
        this.project = project;
    }
    
    

    public TaskBean() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }
    
    
}

