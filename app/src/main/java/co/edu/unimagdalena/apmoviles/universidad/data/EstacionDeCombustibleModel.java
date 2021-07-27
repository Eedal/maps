package co.edu.unimagdalena.apmoviles.universidad.data;

import android.os.Parcel;
import android.os.Parcelable;

public class EstacionDeCombustibleModel implements Parcelable {

    private int id;
    private String departamento;
    private String ciudad;
    private String nombre;
    private String descripcion;
    private String latitud;
    private String longitud;

    public EstacionDeCombustibleModel(int id, String nombre, String departamento, String ciudad, String descripcion, String latitud, String longitud) {
        this.id = id;
        this.departamento = departamento;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    protected EstacionDeCombustibleModel(Parcel in) {
        id = in.readInt();
        departamento = in.readString();
        ciudad = in.readString();
        nombre = in.readString();
        descripcion = in.readString();
        latitud = in.readString();
        longitud = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(departamento);
        dest.writeString(ciudad);
        dest.writeString(nombre);
        dest.writeString(descripcion);
        dest.writeString(latitud);
        dest.writeString(longitud);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<EstacionDeCombustibleModel> CREATOR = new Creator<EstacionDeCombustibleModel>() {
        @Override
        public EstacionDeCombustibleModel createFromParcel(Parcel in) {
            return new EstacionDeCombustibleModel(in);
        }

        @Override
        public EstacionDeCombustibleModel[] newArray(int size) {
            return new EstacionDeCombustibleModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}