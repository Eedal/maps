package co.edu.unimagdalena.apmoviles.universidad.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import co.edu.unimagdalena.apmoviles.universidad.R;

public class EstacionDeCombustibleAdapter extends CursorAdapter {
    public EstacionDeCombustibleAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.fila_estacion_de_combustible,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtid = view.findViewById(R.id.txtid);
        TextView txtnombre = view.findViewById(R.id.txtnombre);
        TextView txtdepartamento = view.findViewById(R.id.txtDescripcion);
        TextView txtciudad = view.findViewById(R.id.txtciudad);
        TextView txtdireccion = view.findViewById(R.id.txtdireccion);
        TextView txtlatitud = view.findViewById(R.id.txtlatitud);
        TextView txtlongitud = view.findViewById(R.id.txtlongitud);

        String id = cursor.getString(0);
        String nombre = cursor.getString(1);
        String departamento = cursor.getString(2);
        String ciudad = cursor.getString(3);
        String direccion = cursor.getString(4);
        String latitud = cursor.getString(5);
        String longitud = cursor.getString(6);

        txtid.setText(id);
        txtnombre.setText(nombre);
        txtdepartamento.setText(departamento);
        txtciudad.setText(ciudad);
        txtdireccion.setText(direccion);
        txtlatitud.setText(latitud);
        txtlongitud.setText(longitud);
    }
}
