package com.example.myapplication.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.pregunta2.bean.ProveedorBean;

import java.util.List;

public class Adaptador extends BaseAdapter {


    private List<ProveedorBean> ListaInterna;
    private Context contexto;

    public Adaptador(List<ProveedorBean> listaInterna, Context contexto) {
        ListaInterna = listaInterna;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return ListaInterna.size();
    }

    @Override
    public Object getItem(int position) {
        return ListaInterna.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ListaInterna.get(position).getCodigo();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View pVistaProveedorITEM=convertView;
        if (pVistaProveedorITEM==null)
        {
            LayoutInflater vi=LayoutInflater.from(contexto);
            pVistaProveedorITEM=vi.inflate(R.layout.registroproveedor,null);

        }
        TextView otvRuc=pVistaProveedorITEM.findViewById(R.id.TV_RUC_ITEM);
        TextView otvRazonSocial=pVistaProveedorITEM.findViewById(R.id.TV_RAZONSOCIAL_ITEM);

        otvRuc.setText(ListaInterna.get(position).getRuc());
        otvRazonSocial.setText(ListaInterna.get(position).getRazonSocial());
        return pVistaProveedorITEM;
    }
}
