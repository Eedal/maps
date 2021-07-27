package co.edu.unimagdalena.apmoviles.universidad.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import co.edu.unimagdalena.apmoviles.universidad.adapters.EstacionDeCombustibleAdapter;
import co.edu.unimagdalena.apmoviles.universidad.R;
import co.edu.unimagdalena.apmoviles.universidad.data.EstacionDeCombustibleDao;

public class ListadoActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ListView listado;
    EstacionDeCombustibleDao estacionDeCombustibleDao;
    SearchView filter;
    EstacionDeCombustibleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        listado = findViewById(R.id.lstlistado);
        filter = findViewById(R.id.svfilter);
        estacionDeCombustibleDao = new EstacionDeCombustibleDao(this);
        Cursor c = estacionDeCombustibleDao.obtenerCursorEstacionDeCombustible();
        adapter = new EstacionDeCombustibleAdapter(this,c,false);
        listado.setAdapter(adapter);
        listado.setTextFilterEnabled(true);
        adapter.setFilterQueryProvider(new FilterQueryProvider() {
            @Override
            public Cursor runQuery(CharSequence constraint) {
                return estacionDeCombustibleDao.filtrarEstacionDeCombustible(constraint);
            }
        });
        filter.setOnQueryTextListener(this);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtid = view.findViewById(R.id.txtid);
                TextView nombre = view.findViewById(R.id.txtnombre);
                TextView departamento = view.findViewById(R.id.txtDescripcion);
                TextView ciudad = view.findViewById(R.id.txtciudad);
                TextView direccion = view.findViewById(R.id.txtdireccion);
                TextView latitud = view.findViewById(R.id.txtlatitud);
                TextView longitud = view.findViewById(R.id.txtlongitud);

                Intent i = new Intent(getApplicationContext(), EdicionActivity.class);
                i.putExtra("id", txtid.getText().toString());
                i.putExtra("nombre", nombre.getText().toString());
                i.putExtra("departamento", departamento.getText().toString());
                i.putExtra("ciudad", ciudad.getText().toString());
                i.putExtra("direccion", direccion.getText().toString());
                i.putExtra("latitud", latitud.getText().toString());
                i.putExtra("longitud", longitud.getText().toString());
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        adapter.notifyDataSetChanged();
        return false;
    }
}
