CREATE TABLE UserAccount(
   	UserAccountId INTEGER NOT NULL, 
	Username VARCHAR(100), 
	Password VARCHAR(100), 
        PRIMARY KEY (Id)
   );

CREATE TABLE  Adminn(
   AdminId int NOT NULL,
	AdminName  varchar(100), 
	UserAccountId int, 
	AdminEmail varchar(100), 
	AdminPhoneNumber int, 
        PRIMARY KEY (AdminId),
        FOREIGN KEY (UserAccountId) REFERENCES UserAccount(UserAccountId)
   );


CREATE TABLE  Leader(
        LeaderId int NOT NULL,
	LeaderName  varchar(100), 
	UserAccountId int, 
	LeaderEmail varchar(100), 
	LeaderPhoneNumber int, 
        PRIMARY KEY (LeaderId),
        FOREIGN KEY (UserAccountId) REFERENCES UserAccount(UserAccountId)
 
   );


CREATE TABLE  ProjectMember(
        MemberId int NOT NULL,
	MemberName  varchar(100), 
	UserAccountId int, 
	MemberEmail varchar(100), 
	MemberPhoneNumber int, 
        ProjectId int,
        PRIMARY KEY (MemberId),
        FOREIGN KEY (UserAccountId) REFERENCES UserAccount(UserAccountId),
        FOREIGN KEY (ProjectId) REFERENCES Project(ProjectId)

   );

CREATE TABLE  Project(
        ProjectId int NOT NULL,
	ProjectTitle  varchar(100), 
        StartDate date,
        EndDate date,
        status varchar(100),
        ClientId int,
        PRIMARY KEY (ProjectId),
        FOREIGN KEY (ClientId) REFERENCES Client(ClientId)
   );

CREATE TABLE  Client(
        ClientId int NOT NULL,
	ClientName  varchar(100), 
	ClientEmail varchar(100), 
	ClientPhoneNumber int, 
        PRIMARY KEY (ClientId)
      
   );

CREATE TABLE  Task(
        TaskId int NOT NULL,
	TaskTitle  varchar(100), 
	TaskDescription varchar(100), 
	Deadline date, 
        state varchar(100),
        ProjectID int,
        PRIMARY KEY (TaskId)
        FOREIGN KEY (ProjectId) REFERENCES Project(ProjectId)

   );


CREATE TABLE  ProjectMemberTask(
        MemberId int NOT NULL,
	TaskId  int NOT NULL), 
	MemberName varchar(100), 
	TaskTitle varchar(100), 
        FOREIGN KEY (MemberId) REFERENCES ProjectMember(MemberId)
        FOREIGN KEY (TaskId) REFERENCES Task(TaskId)
      
   );


CREATE TABLE  AdminnTask(
        AdminId int NOT NULL,
	TaskId  int NOT NULL), 
	AdminName varchar(100), 
	TaskTitle varchar(100), 
        FOREIGN KEY (AdminId) REFERENCES Adminn(AdminId)
        FOREIGN KEY (TaskId) REFERENCES Task(TaskId)
      
   );


CREATE TABLE  LeaderTask(
      LeaderId int NOT NULL,
	TaskId  int NOT NULL), 
	LeaderName varchar(100), 
	TaskTitle varchar(100), 
        FOREIGN KEY (LeaderId) REFERENCES Leader(LeaderId)
        FOREIGN KEY (TaskId) REFERENCES Task(TaskId)
      
   );