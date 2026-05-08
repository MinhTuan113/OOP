package model;

public class Location {
    int id;
    int userId;
    String detail;
    String phone;
    public Location() {};
    public Location(int userId,String detail,String phone)
    {
        this.userId=userId;
        this.detail=detail;
        this.phone=phone;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public int getUserId()
    {
        return userId;
    }
    public void setUserId(int userId)
    {
        this.userId = userId;
    }
    public String getDetail()
    {
        return detail;
    }
    public void setDetail(String detail)
    {
        this.detail = detail;
    }
    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
}
