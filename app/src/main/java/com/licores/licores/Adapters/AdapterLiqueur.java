package com.licores.licores.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.licores.licores.Models.Liqueur;
import com.licores.licores.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterLiqueur extends BaseAdapter {

    List<Liqueur> liqueursList = new ArrayList<>();
    LayoutInflater layoutInflater;
    Context context;

    public AdapterLiqueur(Context context, List<Liqueur> liqueursList) {
        this.context = context;
        this.liqueursList = liqueursList;
        layoutInflater = LayoutInflater.from(this.context);
    }

    public int getCount() {
        return liqueursList.size();
    }

    @Override
    public Liqueur getItem(int position) {
        return liqueursList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.cardview_picture, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Liqueur liqueur = getItem(position);
        viewHolder.type.setText(liqueur.getLiqueur_type());
        viewHolder.name.setText(liqueur.getLiqueur_name());
        viewHolder.size.setText(liqueur.getLiqueur_size());
        viewHolder.price.setText(liqueur.getLiqueur_price());
        viewHolder.description.setText(liqueur.getLiqueur_description());

        return convertView;
    }

    public class ViewHolder{
        TextView type;
        TextView name;
        TextView size;
        TextView price;
        TextView description;

        public ViewHolder(View item) {
            type = (TextView) item.findViewById(R.id.id_item_liqueur_type);
            name = (TextView) item.findViewById(R.id.id_item_liqueur_name);
            size = (TextView) item.findViewById(R.id.id_item_liqueur_size);
            price = (TextView) item.findViewById(R.id.id_item_liqueur_price);
            description = (TextView) item.findViewById(R.id.id_item_liqueur_description);
        }
    }
}