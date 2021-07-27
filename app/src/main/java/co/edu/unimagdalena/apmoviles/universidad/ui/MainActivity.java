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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EstacionDeCombustibleModel estacionDeCombustibleModel;
    EstacionDeCombustibleDao estacionDeCombustibleDao;
    EditText ciudad, nombre, departamento, txtid, descripcion, latitud, longitud;
    Button agregar, mostrar, mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregar = findViewById(R.id.btnguardar);
        mostrar = findViewById(R.id.btnlistado);
        mapa = findViewById(R.id.btnvermapa);

        txtid = findViewById(R.id.edtcodigo);
        ciudad = findViewById(R.id.edtciudad);
        nombre = findViewById(R.id.edtnombre);
        departamento = findViewById(R.id.edtdepartamento);
        descripcion = findViewById(R.id.edDescripcion);
        latitud = findViewById(R.id.edtlatitud);
        longitud = findViewById(R.id.edtlongitud);

        agregar.setOnClickListener(this);
        mostrar.setOnClickListener(this);
        mapa.setOnClickListener(this);

        estacionDeCombustibleDao = new EstacionDeCombustibleDao(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnguardar:
                if (TextUtils.isEmpty(txtid.getText().toString()) || TextUtils.isEmpty(ciudad.getText().toString()) || TextUtils.isEmpty(nombre.getText().toString()) ||
                        TextUtils.isEmpty(departamento.getText().toString()) ||
                        TextUtils.isEmpty(descripcion.getText().toString()) || TextUtils.isEmpty(latitud.getText().toString()) || TextUtils.isEmpty(longitud.getText().toString())) {
                    Toast.makeText(this, "No pueden haber casillas vacias", Toast.LENGTH_LONG).show();
                } else {
                    estacionDeCombustibleModel = new EstacionDeCombustibleModel(Integer.parseInt(txtid.getText().toString()), nombre.getText().toString(), departamento.getText().toString(), ciudad.getText().toString(),
                            descripcion.getText().toString(), latitud.getText().toString(), longitud.getText().toString());
                    if (estacionDeCombustibleDao.buscarEstacionDeCombustible(estacionDeCombustibleModel)) {
                        Toast.makeText(this, " este código ya existe", Toast.LENGTH_LONG).show();
                    } else {
                        estacionDeCombustibleDao.agregarEstacionDeCombustible(estacionDeCombustibleModel);
                        txtid.setText("");
                        nombre.setText("");
                        departamento.setText("");
                        ciudad.setText("");
                        descripcion.setText("");
                        latitud.setText("");
                        longitud.setText("");
                    }
                }
                break;
            case R.id.btnlistado:
                Intent i = new Intent(this, ListadoActivity.class);
                startActivity(i);
                break;
            case R.id.btnvermapa:
                Intent j = new Intent(this, MapsActivity.class);
                startActivity(j);
                break;
        }
    }


}
