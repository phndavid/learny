package com.lab.inmotion.learny.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lab.inmotion.learny.Application.App;
import com.lab.inmotion.learny.Model.Child;
import com.lab.inmotion.learny.R;

import java.util.ArrayList;

/**
 * Created by user on 23/11/2015.
 */
public class ChildListAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private ArrayList<Child> children;

    public ChildListAdapter(Context context, ArrayList<Child> children){
        super();
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.children = children;

    }
    @Override
    public int getCount() {
        return children.size();
    }

    @Override
    public Object getItem(int position) {
        return children.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = layoutInflater.inflate(R.layout.child_list_element,parent,false);
        }
        TextView txtPuntaje1 = (TextView) convertView.findViewById(R.id.textView5);
        TextView txtPuntaje2 = (TextView) convertView.findViewById(R.id.textView11);
        TextView txtPuntaje3 = (TextView) convertView.findViewById(R.id.textView7);
        TextView txtPuntaje4 = (TextView) convertView.findViewById(R.id.textView13);
        TextView txtPuntaje5 = (TextView) convertView.findViewById(R.id.textView9);

        TextView txtTime1 = (TextView) convertView.findViewById(R.id.textView4);
        TextView txtTime2 = (TextView) convertView.findViewById(R.id.textView10);
        TextView txtTime3 = (TextView) convertView.findViewById(R.id.textView6);
        TextView txtTime4 = (TextView) convertView.findViewById(R.id.textView12);
        TextView txtTime5 = (TextView) convertView.findViewById(R.id.textView8);

        TextView txtName = (TextView) convertView.findViewById(R.id.txt_nombre_paciente);
        TextView txtGenero = (TextView) convertView.findViewById(R.id.txt_genero);
        TextView txtBirth = (TextView) convertView.findViewById(R.id.txt_birth);
        TextView txtParente = (TextView) convertView.findViewById(R.id.txt_pariente);
        TextView txtColegio = (TextView) convertView.findViewById(R.id.txt_school);
        TextView txtAddress = (TextView) convertView.findViewById(R.id.txt_address);

        Child child = children.get(position);

        txtName.setText(child.getFirstName());
        txtGenero.setText(child.getSex());
        txtBirth.setText(child.getBirth().toString());
        txtParente.setText(child.getParentName());
        txtColegio.setText(child.getSchool());
        txtAddress.setText(child.getAddress());
        txtPuntaje1.setText(child.getPuntajes()[0] + " puntos");
        txtPuntaje2.setText(child.getPuntajes()[1] + " puntos");
        txtPuntaje3.setText(child.getPuntajes()[2] + " puntos");
        txtPuntaje4.setText(child.getPuntajes()[3] + " puntos");
        txtPuntaje5.setText(child.getPuntajes()[4] + " puntos");
        txtTime1.setText(child.getTiempos()[0] + " segundos");
        txtTime2.setText(child.getTiempos()[1] + " segundos");
        txtTime3.setText(child.getTiempos()[2] + " segundos");
        txtTime4.setText(child.getTiempos()[3] + " segundos");
        txtTime5.setText(child.getTiempos()[4] + " segundos");


        return convertView;
    }

}
