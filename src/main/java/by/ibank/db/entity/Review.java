package by.ibank.db.entity;

/**
 * Created by Olga on 18.01.2017.
 */
public class Review implements Entity {
    private long id;
    private int userID;
    private int departmentID;

    public Review(int id, int userID, int departmentID) {
        this.id = id;
        this.userID = userID;
        this.departmentID = departmentID;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }
}
