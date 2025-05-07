package tam.dev.data.model;

public class User {
    public int id;
    public String password;
    public String email;
    public String role;

    public User(int id, String password, String email, String role) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User(String password, String email, String role) {
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
