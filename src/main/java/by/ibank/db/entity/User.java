package by.ibank.db.entity;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Olga on 18.01.2017.
 */
public class User implements Entity {
    private long id;
    private String name;
    private String login;
    private String pass;
//    private Set<Role> roles = new HashSet<>();

    public User (long id, String name, String login, String pass) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.pass = pass;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
