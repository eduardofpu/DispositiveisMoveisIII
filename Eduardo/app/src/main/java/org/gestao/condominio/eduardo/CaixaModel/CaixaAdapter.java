package org.gestao.condominio.eduardo.CaixaModel;

import android.content.Context;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.gestao.condominio.eduardo.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eduardo on 30/09/2016.
 */

public class CaixaAdapter extends ArrayAdapter<CaixaModel> {

    public CaixaAdapter(Context context, List<CaixaModel> caixas) {
        super(context, 0, caixas);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final CaixaModel caixa = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_caixa, parent, false);
        }
        TextView gerenteTextView = (TextView) convertView.findViewById(R.id.gerenteCaixaRow);
        TextView valorTextView = (TextView) convertView.findViewById(R.id.codCaixaRow);
        TextView dataTextView = (TextView) convertView.findViewById(R.id.dataCaixaRow);
        TextView horaTextView = (TextView) convertView.findViewById(R.id.horaCaixaRow);


           gerenteTextView.setText(caixa.getGerente());
           valorTextView.setText(caixa.getCodcaixa());
           dataTextView.setText(caixa.getData());
           horaTextView.setText(caixa.getHora());



        final View.OnClickListener codeListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Code: " + caixa.getCodcaixa(), Snackbar.LENGTH_LONG).show();
            }
        };


        View.OnClickListener fabListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Deleted the caix \"" + caixa.getGerente() + "\"", Snackbar.LENGTH_LONG)
                .setAction("Code", codeListener).show();


                caixa.delete();

                CaixaAdapter.this.clear();
                List<CaixaModel> caixas =caixa.findAll();

                for (int i = 0; i < caixas.size(); i++) {
                    CaixaAdapter.this.insert(caixas.get(i), i);
                }

                CaixaAdapter.this.notifyDataSetChanged();
            }
        };

        FloatingActionButton fab = (FloatingActionButton)convertView.findViewById(R.id.buttonDelete);
        fab.setOnClickListener(fabListener);

        return convertView;
    }

}
