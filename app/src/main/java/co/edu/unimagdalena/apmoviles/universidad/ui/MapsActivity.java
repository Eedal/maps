package co.edu.unimagdalena.apmoviles.universidad.ui;

import androidx.fragment.app.FragmentActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import co.edu.unimagdalena.apmoviles.universidad.R;
import co.edu.unimagdalena.apmoviles.universidad.data.EstacionDeCombustibleDao;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    EstacionDeCombustibleDao estacionDeCombustibleDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        estacionDeCombustibleDao = new EstacionDeCombustibleDao(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View v = getLayoutInflater().inflate(R.layout.custom_infowindow, null);

                v.setLayoutParams(new RelativeLayout.LayoutParams(500, RelativeLayout.LayoutParams.WRAP_CONTENT));

                TextView title = (TextView) v.findViewById(R.id.marker_title);
                TextView description = (TextView) v.findViewById(R.id.marker_description);

                title.setText(marker.getTitle());
                description.setText(marker.getSnippet());

                return v;
            }
        });

        Cursor cursor = estacionDeCombustibleDao.obtenerCursorEstacionDeCombustible();
        try {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                LatLng pos = new LatLng(Double.parseDouble(cursor.getString(5)), Float.parseFloat(cursor.getString(6)));
                mMap.addMarker(new MarkerOptions()
                        .position(pos)
                        .title(cursor.getString(1))
                        .snippet("\nDepartamento: "+cursor.getString(2)+"\nCiudad: "+cursor.getString(3)+"\nEstrellas: "+cursor.getString(4)+"\nDirección: "+cursor.getString(5)));
            }

        } finally {
            cursor.close();
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(4.683803, -74.078698), 13 ));
    }


}