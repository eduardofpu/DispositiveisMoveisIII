package org.gestao.condominio.eduardo.user;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ListView;

import org.gestao.condominio.eduardo.CaixaModel.CaixaAdapter;
import org.gestao.condominio.eduardo.CaixaModel.CaixaModel;
import org.gestao.condominio.eduardo.CaixaModel.NewCaixaActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eduardo on 02/10/2016.
 */

public class UserListFragment extends ListFragment {

    private UserAdapter adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loadUser();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent (getActivity().getApplicationContext(), NewCaixaActivity.class);

        UserModel user = adapter.getItem(position);
        user.setMyId();
        intent.putExtra("user", user);

        startActivity(intent);
    }


    @Override
    public void onResume() {
        loadUser();

        super.onResume();
    }

    private void loadUser() {

        List<UserModel> users = new UserModel().findAll();


        adapter = new UserAdapter(getActivity(), users);

        setListAdapter(adapter);

        getListView().setDivider(ContextCompat.getDrawable(getActivity(), android.R.color.black));
        getListView().setDividerHeight(2);



    }




}
