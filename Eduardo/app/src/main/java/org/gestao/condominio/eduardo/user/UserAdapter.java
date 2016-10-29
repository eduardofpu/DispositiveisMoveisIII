package org.gestao.condominio.eduardo.user;

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

public class UserAdapter extends ArrayAdapter<UserModel> {

    public UserAdapter(Context context, List<UserModel> users) {

        super(context, 0, users);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final UserModel useer = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_user, parent, false);
        }

        TextView userTextView = (TextView) convertView.findViewById(R.id.userRow);
        TextView nameTextView = (TextView) convertView.findViewById(R.id.codUserRow);
        TextView emailTextView = (TextView) convertView.findViewById(R.id.emailUserRow);
        TextView passwordTextView = (TextView) convertView.findViewById(R.id.passwodUserRow);

        userTextView.setText(useer.getUser());
        nameTextView.setText(useer.getCodUser());
        emailTextView.setText(useer.getEmail());
        passwordTextView.setText(useer.getPassword());


        final View.OnClickListener codeListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Code: " + useer.getCodUser(), Snackbar.LENGTH_LONG).show();
            }
        };

        View.OnClickListener fabListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Deleted the use \"" + useer.getUser() + "\"", Snackbar.LENGTH_LONG)
                        .setAction("Code", codeListener).show();

                useer.delete();

                UserAdapter.this.clear();
                List<UserModel> users = useer.findAll();

                for (int i = 0; i < users.size(); i++) {
                    UserAdapter.this.insert(users.get(i), i);
                }

                UserAdapter.this.notifyDataSetChanged();
            }
        };

        FloatingActionButton fab = (FloatingActionButton)convertView.findViewById(R.id.buttonDelete);
        fab.setOnClickListener(fabListener);

        return convertView;
    }


}
