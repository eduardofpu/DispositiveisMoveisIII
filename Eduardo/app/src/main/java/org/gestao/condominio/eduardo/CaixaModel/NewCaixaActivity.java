package org.gestao.condominio.eduardo.CaixaModel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.gestao.condominio.eduardo.R;


/**
 * Created by Eduardo on 30/09/2016.
 */

public class NewCaixaActivity extends AppCompatActivity {

    private CaixaModel caixa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_caixa);
         setActions();

        caixa= (CaixaModel) getIntent().getSerializableExtra("caix");

        if (caixa == null) {
            caixa = new CaixaModel();
        } else {
            caixa = caixa.findById();

            ((EditText) NewCaixaActivity.this.findViewById(R.id.gerenteCaixa)).setText(caixa.getGerente());
            ((EditText) NewCaixaActivity.this.findViewById(R.id.valorCaixa)).setText(caixa.getCodcaixa());
            ((EditText) NewCaixaActivity.this.findViewById(R.id.dataCaixa)).setText(caixa.getData());
            ((EditText) NewCaixaActivity.this.findViewById(R.id.horaCaixa)).setText(caixa.getHora());



        }
    }

    private void setActions() {
        final Button cancelButton = (Button) findViewById(R.id.cancelCaixa);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewCaixaActivity .this.finish();
            }
        });

        Button saveButton = (Button) findViewById(R.id.saveCaixa);

        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                EditText gerenteText = (EditText) NewCaixaActivity .this.findViewById(R.id.gerenteCaixa);
                EditText valorText = (EditText) NewCaixaActivity .this.findViewById(R.id.valorCaixa);
                EditText dataText = (EditText) NewCaixaActivity .this.findViewById(R.id.dataCaixa);
                EditText horaText = (EditText) NewCaixaActivity .this.findViewById(R.id.horaCaixa);



                caixa.setGerente(gerenteText.getText().toString());
                caixa.setCodcaixa(valorText.getText().toString());
                caixa.setData(dataText.getText().toString());
                caixa.setHora(horaText.getText().toString());





                caixa.save();

                NewCaixaActivity.this.finish();
            }
        });
    }
}
