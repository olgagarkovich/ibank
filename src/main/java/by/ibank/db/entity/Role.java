package by.ibank.db.entity;

/**
 * Created by Olga on 18.01.2017.
 */
public class Role implements Entity {
    private int id;
    private String role;

    public Role(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public long getId() {
        return id;
    }
}
