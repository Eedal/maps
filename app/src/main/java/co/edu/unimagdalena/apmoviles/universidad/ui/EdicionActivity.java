package co.edu.unimagdalena.apmoviles.universidad.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import co.edu.unimagdalena.apmoviles.universidad.R;
import co.edu.unimagdalena.apmoviles.universidad.data.EstacionDeCombustibleDao;
import co.edu.unimagdalena.apmoviles.universidad.data.EstacionDeCombustibleModel;

public class EdicionActivity extends AppCompatActivity {

    EditText txtid, nombre, departamento, ciudad, descripcion, latitud, longitud;//3 nuevos
    Button actualizar, eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicion);
        Intent i = getIntent();
        String id = i.getStringExtra("id");
        String nom = i.getStringExtra("nombre");
        String dep = i.getStringExtra("departamento");
        String ciud = i.getStringExtra("ciudad");
        String direc = i.getStringExtra("direccion");
        String lati = i.getStringExtra("latitud");
        String longi = i.getStringExtra("longitud");

        txtid = findViewById(R.id.edtid);
        nombre = findViewById(R.id.edtnombre);
        departamento = findViewById(R.id.edtdepartamento);
        ciudad = findViewById(R.id.edtciudad);
        descripcion = findViewById(R.id.edDescripcion);
        latitud = findViewById(R.id.edtlatitud2);
        longitud = findViewById(R.id.edtlongitud2);

        actualizar = findViewById(R.id.btnactualizar);
        eliminar = findViewById(R.id.btneliminar);

        txtid.setText(id);
        txtid.setEnabled(false);
        nombre.setText(nom);
        departamento.setText(dep);
        ciudad.setText(ciud);
        descripcion.setText(direc);
        latitud.setText(lati);
        longitud.setText(longi);


        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EstacionDeCombustibleDao ec = new EstacionDeCombustibleDao(getApplication());
                ec.eliminarEstacionDeCombustible(Integer.parseInt(txtid.getText().toString()));
                finish();
            }
        });
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(txtid.getText().toString()) || TextUtils.isEmpty(ciudad.getText().toString()) || TextUtils.isEmpty(nombre.getText().toString()) ||
                        TextUtils.isEmpty(departamento.getText().toString()) || TextUtils.isEmpty(descripcion.getText().toString()) || TextUtils.isEmpty(latitud.getText().toString()) || TextUtils.isEmpty(longitud.getText().toString())) {
                    Toast.makeText(getBaseContext(), "Todos los datos tienen que estar llenos", Toast.LENGTH_SHORT).show();
                } else {
                    EstacionDeCombustibleModel estacionDeCombustibleModel = new EstacionDeCombustibleModel(Integer.parseInt(txtid.getText().toString()), nombre.getText().toString(), departamento.getText().toString(),
                            ciudad.getText().toString(), descripcion.getText().toString(), latitud.getText().toString(), longitud.getText().toString());

                    EstacionDeCombustibleDao estacionDeCombustibleDao = new EstacionDeCombustibleDao(getApplication());
                    estacionDeCombustibleDao.actualizarEstacionDeCombustible(estacionDeCombustibleModel);
                    finish();
                }
            }
        });
    }
}