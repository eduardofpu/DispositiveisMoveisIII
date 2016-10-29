package org.gestao.condominio.eduardo.PrestarContas;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ListView;

import org.gestao.condominio.eduardo.CaixaModel.NewCaixaActivity;
import org.gestao.condominio.eduardo.user.UserAdapter;
import org.gestao.condominio.eduardo.user.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eduardo on 02/10/2016.
 */

public class PrestarContasListFragment extends ListFragment {

    private PrestarContasAdapter adapter;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loadPrestarContas();
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent (getActivity().getApplicationContext(), PrestarContasActivity.class);

        PrestarContasModel conta = adapter.getItem(position);
        conta.setMyId();
        intent.putExtra("conta", conta);

        startActivity(intent);
    }

    @Override
    public void onResume() {
        loadPrestarContas();

        super.onResume();
    }

    private void loadPrestarContas() {


       List<PrestarContasModel> prestarContasModels = new PrestarContasModel().findAll();

        adapter = new PrestarContasAdapter(getActivity(), prestarContasModels   );
         setListAdapter(adapter);

        getListView().setDivider(ContextCompat.getDrawable(getActivity(),android.R.color.black));
        getListView().setDividerHeight(2);

    }


}
