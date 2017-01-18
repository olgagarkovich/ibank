package by.ibank.db.entity;

/**
 * Created by Olga on 18.01.2017.
 */
public class Department implements Entity {
    private long id;
    private String name;

    public Department(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
