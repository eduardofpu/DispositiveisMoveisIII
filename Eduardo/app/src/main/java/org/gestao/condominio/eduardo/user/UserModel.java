package org.gestao.condominio.eduardo.user;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Eduardo on 02/10/2016.
 */
@Table(name="User")
public class UserModel extends Model implements Serializable {
    private Long myId;
    @Column(name = "User")
    String user;
    @Column(name = "CodUser")
    String codUser;
    @Column(name = "Email")
    String email;
    @Column(name = "password")
    String password;



public UserModel(){
    super();
}


    public UserModel(String user, String codUser, String email, String password) {
        this.user = user;
        this.codUser = codUser;
        this.email = email;
        this.password = password;
    }

    public UserModel findById(){
        return new Select()
                .from(UserModel.class)
                .where("id = ?", myId)
                .executeSingle();
    }


    public List<UserModel> findAll() {
        return new Select().from(UserModel.class).execute();
    }


    public Long getMyId() {
        return myId;
    }

    public void setMyId() {
        this.myId = myId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCodUser() {
        return codUser;
    }

    public void setCodUser(String codUser) {
        this.codUser = codUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}