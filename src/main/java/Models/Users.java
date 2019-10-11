package Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "name", nullable = true)
    private String userName;
    @Column(name = "password", nullable = true)
    private String userPassword;
    @Column(name = "email", nullable = true)
    private String userMail;
    @Column(name = "datumGeregistreerd", nullable = false)
    private Date datumGeregistreerd;
    @Column(name = "Actief", nullable = false)
    private boolean actief;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public Date getDatumGeregistreerd() {
        return datumGeregistreerd;
    }

    public void setDatumGeregistreerd(Date datumGeregistreerd) {
        this.datumGeregistreerd = datumGeregistreerd;
    }

    public boolean isActief() {
        return actief;
    }

    public void setActief(boolean actief) {
        this.actief = actief;
    }
}
