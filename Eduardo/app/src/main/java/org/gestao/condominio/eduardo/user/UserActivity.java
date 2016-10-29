package org.gestao.condominio.eduardo.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.gestao.condominio.eduardo.CaixaModel.CaixaModel;
import org.gestao.condominio.eduardo.CaixaModel.NewCaixaActivity;
import org.gestao.condominio.eduardo.R;

/**
 * Created by Eduardo on 02/10/2016.
 */

public class UserActivity extends AppCompatActivity {
private UserModel user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        setActions();

        user= (UserModel) getIntent().getSerializableExtra("use");

        if (user == null) {
            user = new UserModel();
        } else {
            user = user.findById();

            ((EditText) UserActivity.this.findViewById(R.id.userLogin)).setText(user.getUser());
            ((EditText) UserActivity.this.findViewById(R.id.nameLogin)).setText(user.getCodUser());
            ((EditText) UserActivity.this.findViewById(R.id.emaiLogin)).setText(user.getEmail());
            ((EditText) UserActivity.this.findViewById(R.id.passwordLogin)).setText(user.getPassword());


        }
    }

    private void setActions() {
        final Button cancelButton = (Button) findViewById(R.id.cancelUser);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserActivity .this.finish();
            }
        });

        Button saveButton = (Button) findViewById(R.id.saveUser);

        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText userText = (EditText) UserActivity.this.findViewById(R.id.userLogin);
                EditText nameText = (EditText) UserActivity.this.findViewById(R.id.nameLogin);
                EditText emailText = (EditText) UserActivity.this.findViewById(R.id.emaiLogin);
                EditText passwordText = (EditText) UserActivity.this.findViewById(R.id.passwordLogin);


                user.setUser(userText.getText().toString());
                user.setCodUser(nameText.getText().toString());
                user.setEmail(emailText.getText().toString());
                user.setPassword(passwordText.getText().toString());


                user.save();

                UserActivity .this.finish();
            }
        });
    }
}
