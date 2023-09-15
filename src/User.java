public class User {
    
    private int ID;
    private String FirstName;
    private String LastName;
    private String DateOfBirth;
    private String Gender;
    private String Email;
    private int ContactNo;
    private String PresentAddress;
    private String PermanentAddress;
    private String Department;
    private String Designation;
    private String Status;
    private String DateHired;
    private double BasicSalary;
    private String JobTitle;
    private String UserName;
    private String Password;
    private byte[] Image;
    
    
    
    public User(int Id,String Fname,String Lname,String DOB,String gender,String email,int contactno,String preAdd,String perAdd,
            String dept,String designation,String status,String datehired,double salary,String jobtitle,String Uname,String password,byte[] image)
    {
        this.ID = Id;
        this.FirstName = Fname;
        this.LastName = Lname;
        this.DateOfBirth = DOB;
        this.Gender = gender;
        this.Email = email;
        this.ContactNo = contactno;
        this.PresentAddress = preAdd;
        this.PermanentAddress = perAdd;
        this.Department = dept;
        this.Designation = designation;
        this.Status = status;
        this.DateHired = datehired;
        this.BasicSalary = salary;
        this.JobTitle = jobtitle;
        this.UserName = Uname;
        this.Password = password;
        this.Image = image;
    }
    
    public int getId()
    {
        return ID;
    }
    
    public String getFname()
    {
        return FirstName;
    }
    
    public String getLname()
    {
        return LastName;
    }
    
    public String getDOB()
    {
        return DateOfBirth;
    }
    public String getgender()
    {
        return Gender;
    }
    public String getemail()
    {
        return Email;
    }
    public int getcontactno()
    {
        return ContactNo;
    }
    public String getpreAdd()
    {
        return PresentAddress;
    }
    public String getperAdd()
    {
        return PermanentAddress;
    }
    public String getdept()
    {
        return Department;
    }
    public String getdesignation()
    {
        return Designation;
    }
    public String getstatus()
    {
        return Status;
    }
    public String getdatehired()
    {
        return DateHired;
    }
    public double getsalary()
    {
        return BasicSalary;
    }
    public String getjobtitle()
    {
        return JobTitle;
    }
    public String getuname()
    {
        return UserName;
    }
    public String getpassword()
    {
        return Password;
    }
    public byte[] getimage()
    {
        return Image;
    }
    
}
