package org.gestao.condominio.eduardo.PrestarContas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.gestao.condominio.eduardo.R;
import org.gestao.condominio.eduardo.user.UserActivity;
import org.gestao.condominio.eduardo.user.UserModel;

import java.math.BigDecimal;

/**
 * Created by Eduardo on 02/10/2016.
 */

public class PrestarContasActivity extends AppCompatActivity {
    private PrestarContasModel conta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_prestar_contas);
        setActions();

       conta= (PrestarContasModel) getIntent().getSerializableExtra("cont");

        if (conta == null) {
            conta = new PrestarContasModel();
        } else {
            conta = conta.findById();

            ((EditText) PrestarContasActivity.this.findViewById(R.id.pDescricao)).setText(conta.getDescricao());
            ((EditText) PrestarContasActivity.this.findViewById(R.id.pEmpresa)).setText(conta.getCodempresa());
            ((EditText) PrestarContasActivity.this.findViewById(R.id.pData)).setText(conta.getData());
            ((EditText) PrestarContasActivity.this.findViewById(R.id.pHora)).setText(conta.getHora());
            ((EditText) PrestarContasActivity.this.findViewById(R.id.pValor)).setText(conta.getValor());

            

        }
    }

    private void setActions() {
        final Button cancelButton = (Button) findViewById(R.id.cancelP);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrestarContasActivity.this.finish();
            }
        });

        Button saveButton = (Button) findViewById(R.id.saveP);

        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText descricaoText = (EditText) PrestarContasActivity.this.findViewById(R.id.pDescricao);
                EditText empresaText = (EditText) PrestarContasActivity.this.findViewById(R.id.pEmpresa);
                EditText dataText = (EditText) PrestarContasActivity.this.findViewById(R.id.pData);
                EditText horaText = (EditText) PrestarContasActivity.this.findViewById(R.id.pHora);
                EditText valorText = (EditText) PrestarContasActivity.this.findViewById(R.id.pValor);


                conta.setDescricao(descricaoText.getText().toString());
                conta.setCodempresa(empresaText.getText().toString());
                conta.setData(dataText.getText().toString());
                conta.setHora(horaText.getText().toString());
                conta.setValor(valorText.getText().toString());


                conta.save();

                PrestarContasActivity.this.finish();
            }
        });
    }
}
