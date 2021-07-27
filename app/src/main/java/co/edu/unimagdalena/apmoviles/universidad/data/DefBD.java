package co.edu.unimagdalena.apmoviles.universidad.data;


    public class DefBD {
        public static final String nameDb = "restaurantes";
        public static final String tabla_name = "restaurante";
        public static final String col_id = "id";
        public static final String col_departamento = "departamento";
        public static final String col_nombre = "nombre";
        public static final String col_ciudad = "ciudad";
        public static final String col_descripcion = "descripcion";
        public static final String col_latitud = "latitud";
        public static final String col_longitud = "longitud";

        public static final String create_tabla_est = "CREATE TABLE IF NOT EXISTS " + DefBD.tabla_name + " ( " +
                DefBD.col_id + " integer," +
                DefBD.col_nombre + " text," +
                DefBD.col_departamento + " text," +
                DefBD.col_ciudad + " text," +
                DefBD.col_descripcion + " text," +
                DefBD.col_latitud + " real," +
                DefBD.col_longitud + " real" + ");";


}
