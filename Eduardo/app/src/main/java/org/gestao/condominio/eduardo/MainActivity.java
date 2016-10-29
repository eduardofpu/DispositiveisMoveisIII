package org.gestao.condominio.eduardo;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.activeandroid.ActiveAndroid;
import com.activeandroid.Cache;
import org.gestao.condominio.eduardo.CaixaModel.NewCaixaActivity;
import org.gestao.condominio.eduardo.PrestarContas.PrestarContasActivity;
import org.gestao.condominio.eduardo.user.UserActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Cache.isInitialized() && Cache.getTableInfos().isEmpty()) {
            ActiveAndroid.dispose();
        }
        ActiveAndroid.initialize(this);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setActionsUsers();
        setActions();
        setActionsPrestarContas();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onResume() {
        getWindow().getDecorView().findViewById(android.R.id.content).invalidate();

        super.onResume();
    }

    private void setActionsUsers() {

        Button newUser = (Button) findViewById(R.id.buttonNewUser);

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserActivity.class);

                startActivity(intent);
            }
        });
    }



    private void setActions() {
        Button newCaixaButton = (Button) findViewById(R.id.buttonNewCaixa);


        newCaixaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewCaixaActivity.class);

                startActivity(intent);
            }
        });
    }


    private void setActionsPrestarContas() {

        Button newUser = (Button) findViewById(R.id.buttonNewPrestarContas);

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PrestarContasActivity.class);

                startActivity(intent);
            }
        });
    }


}
