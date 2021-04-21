package com.company;


import java.sql.*;

public class ConexionDB {
    private Connection conexion = null;
    private Statement st = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    private String dbURL;
    private String dbUSER;
    private String dbPWD;

    public ConexionDB(String dbName, String dbUSER, String dbPWD, String sql) {
        this.dbURL = "jdbc:mysql://localhost/" +dbName;
        this.dbUSER = dbUSER;
        this.dbPWD = dbPWD;
        iniciarConexionConPSTMT(sql, true);
    }

    public ConexionDB(String dbName, String dbUSER, String dbPWD) {
        this.dbURL = "jdbc:mysql://localhost/" +dbName;
        this.dbUSER = dbUSER;
        this.dbPWD = dbPWD;
        iniciarConexion();
    }


    public void ejecutar() throws SQLException{
        if(pstmt!=null && !pstmt.isClosed())
                pstmt.executeUpdate();
    }

    public int ejecutarRetornarKey() throws SQLException{
        int idGenerado = 0;
        if(pstmt.executeUpdate() > 0){
            ResultSet keysGeneradas = pstmt.getGeneratedKeys();
            if (keysGeneradas.next())
                idGenerado = keysGeneradas.getInt(1);
        }
        return idGenerado;
    }

    /*con Statements
    1)Connection -> canal de comunicacion
    2) Statment -> instrucciones a ejecutar
    3a) Query -> consulta que puede ejecutar dentro del statement
    3b) ResultSet -> el resultado de una query
    Ejemplos:
    SELECT * FROM usuarios LIMIT 10;
    SELECT user, pwd FROM usuarios WHERE id = variable;
    ----> ATAQUE de inyeccion SQL
    si variable = 5
    Entonces la query queda:
    SELECT user, pwe FROM usuarios WHERE id = 5;
    PERO si {VARIABLE} = 5;DROP TABLE usuarios
    Entonces la query queda:
    SELECT user, pwd FROM usuarios WHERE id = 5;DROP TABLE usuarios; // NOTA: DROP TABLE borra el contenido de la tabla.


    con PreparedStatments
    1) connection -> canal de comunicacion
    2) PreparedStatement -> una instruccion predefinida a ejecutar
    3a) Setters del PSTMT -> Establecer valores a las variables del P-Stmt
    3b)ResultSet -> el resultado de la query
    Ejemplo:
    esto se define en (2) ->
    SELECT* FROM usuarios WHERE id = ? LIMIT 10;
    en 3a) -
    pstmt.setInt(1,variable); // donde variable = 5
    que pasa si variable = 5; DROP TABLE usuarios
    pstmt.setInt(1,"5; DROP TABLE usuarios"); -> genera SQLException porque estoy pasando un string en vez de un

     */


    private void iniciarConexionConPSTMT(String sql, boolean retornarKeys){
        try {
            conexion = DriverManager.getConnection(dbURL,dbUSER,dbPWD);
            if(retornarKeys)
                pstmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            else
                pstmt = conexion.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("No se ha podido conectar con la base de datos.");
        }
    }

    private void iniciarConexion(){
        try {
            conexion = DriverManager.getConnection(dbURL, dbUSER, dbPWD);
            st = conexion.createStatement();
        }catch (SQLException e){
            System.out.println("No se ha podido conectar con la base de datos.");
        }
    }


    public ResultSet consultar(String sql) {
        try {
            if(st != null && !st.isClosed())
                rs = st.executeQuery(sql);
        } catch (SQLException | NullPointerException e) {
            System.out.println("No se ha podido realizar su búsqueda.");
        }
        return rs;
    }

    public void cerrar(){
        try {
            if(pstmt != null && !pstmt.isClosed())
                pstmt.close();
            if(st !=null && !st.isClosed())
                st.close();
            if(conexion != null && !conexion.isClosed())
                conexion.close();
        } catch (SQLException e) {
            System.out.println("Conexion con base de datos cerrada.");;
        }
    }

    public int actualizar(String sql) throws SQLException {
        return st.executeUpdate(sql);
    }

    public PreparedStatement getPstmt(){
        return this.pstmt;
    }
}
