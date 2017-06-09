package com.licores.licores.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.licores.licores.Models.User;
import com.licores.licores.R;

import java.util.ArrayList;
import java.util.List;

public class UserAdapterSQLite extends BaseAdapter {

    List<User> userList = new ArrayList<>();
    LayoutInflater layoutInflater;
    Context context;

    public UserAdapterSQLite (Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
        layoutInflater = LayoutInflater.from(this.context);
    }

    public int getCount() {
        return userList.size();
    }

    @Override
    public User getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        User user = getItem(position);
        viewHolder.name.setText(user.getName());
        viewHolder.lastname.setText(user.getLastname());
        viewHolder.myuser.setText(user.getMyuser());
        viewHolder.email.setText(user.getEmail());
        viewHolder.address.setText(user.getAddress());
        viewHolder.password.setText(user.getPassword());

        return convertView;
    }

    public class ViewHolder{
        TextView name;
        TextView lastname;
        TextView myuser;
        TextView email;
        TextView address;
        TextView password;


        public ViewHolder(View item) {
            name = (TextView) item.findViewById(R.id.id_item_name);
            lastname = (TextView) item.findViewById(R.id.id_item_lastname);
            myuser = (TextView) item.findViewById(R.id.id_item_myuser);
            email = (TextView) item.findViewById(R.id.id_item_email);
            address = (TextView) item.findViewById(R.id.id_item_address);
            password = (TextView) item.findViewById(R.id.id_item_password);
        }
    }
}