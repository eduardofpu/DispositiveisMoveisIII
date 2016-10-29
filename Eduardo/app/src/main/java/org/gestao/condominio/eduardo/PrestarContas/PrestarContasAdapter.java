package org.gestao.condominio.eduardo.PrestarContas;

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
 * Created by Eduardo on 02/10/2016.
 */

public class PrestarContasAdapter extends ArrayAdapter<PrestarContasModel>{


    public PrestarContasAdapter(Context context, List<PrestarContasModel> contas) {
        super(context, 0, contas);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final PrestarContasModel conta = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_prestar_contas, parent, false);
        }

        TextView descricaoTextView = (TextView) convertView.findViewById(R.id.descricaoPrestaContasRow);
        TextView empresaTextView = (TextView) convertView.findViewById(R.id.codempresaPrestarContasRow);
        TextView dataTextView = (TextView) convertView.findViewById(R.id.dataPrestaContasRow);
        TextView horaTextView = (TextView) convertView.findViewById(R.id.horaPrestaContasRow);
        TextView valorTextView = (TextView) convertView.findViewById(R.id.valorPrestaContasRow);


        descricaoTextView.setText(conta.getDescricao());
        empresaTextView.setText(conta.getCodempresa());
        dataTextView.setText(conta.getData().toString()) ;
        horaTextView.setText(conta.getHora().toString()) ;
        valorTextView.setText(conta.getValor().toString());


        final View.OnClickListener codeListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Code: " + conta.getCodempresa(), Snackbar.LENGTH_LONG).show();
            }
        };

        View.OnClickListener fabListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Deleted the cont \"" + conta.getDescricao() + "\"", Snackbar.LENGTH_LONG)
                        .setAction("Code", codeListener).show();

               conta.delete();

                PrestarContasAdapter.this.clear();
                List<PrestarContasModel> contas = conta.findAll();

                for (int i = 0; i < contas.size(); i++) {
                    PrestarContasAdapter.this.insert(contas.get(i), i);
                }

                PrestarContasAdapter.this.notifyDataSetChanged();
            }
        };

        FloatingActionButton fab = (FloatingActionButton)convertView.findViewById(R.id.buttonDelete);
        fab.setOnClickListener(fabListener);

        return convertView;
    }


}
