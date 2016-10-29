package org.gestao.condominio.eduardo.CaixaModel;

/**
 * Created by Eduardo on 30/09/2016.
 */
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import org.gestao.condominio.eduardo.MainActivity;

import java.util.ArrayList;
import java.util.List;



public class CaixaListFragment extends ListFragment{

    private CaixaAdapter adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loadCaixas();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent (getActivity().getApplicationContext(), NewCaixaActivity.class);

        CaixaModel caixa = adapter.getItem(position);
        caixa.setMyId();
        intent.putExtra("caixa", caixa);

        startActivity(intent);
    }

    @Override
    public void onResume() {
        loadCaixas();

        super.onResume();
    }

    private void loadCaixas() {
        List<CaixaModel> caixas = new CaixaModel().findAll();

        adapter = new CaixaAdapter(getActivity(), caixas);

        setListAdapter(adapter);

        getListView().setDivider(ContextCompat.getDrawable(getActivity(), android.R.color.black));
        getListView().setDividerHeight(2);
	  



    }


}
