package DB;

import Recursos.EstructuraConsultarMesa;
import Recursos.EstructuraEmitirVoto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Metodos {

    public List<EstructuraConsultarMesa> ConsultarMesa_X_DPI(Connection Conexion, String _DPI) {
        try {
            List<EstructuraConsultarMesa> ListaDatos = new ArrayList<>();
            Statement S = Conexion.createStatement();
            String Query = "SELECT DISTINCT D.nombre DepNombre,MU.nombre MunNombre,CV.direccion,ME.descripcion, P.no_empadronamiento, P.dpi,P.nombre PerNombre, P.apellido \n"
                    + "FROM departamento AS D, municipio AS MU, centro_votacion AS CV, mesa as ME, persona AS P\n"
                    + "WHERE D.id_departamento= MU.DEPARTAMENTO_id && MU.id_municipio= CV.MUNICIPIO_id && CV.id_centro_votacion=ME.CENTRO_VOTACION_id && P.MESA_id=ME.id_mesa && P.dpi=" + _DPI;
            ResultSet Rs = S.executeQuery(Query);

            while (Rs.next()) {
                String NombreDepartamento = Rs.getString("DepNombre");
                String NombreMunicipio = Rs.getString("MunNombre");
                String DireccionCentroVotacion = Rs.getString("direccion");
                String Descripcion = Rs.getString("descripcion");
                String NoEmpadronamiento = Rs.getString("no_empadronamiento");
                String DPI = Rs.getString("dpi");
                String Nombre = Rs.getString("PerNombre");
                String Apellido = Rs.getString("apellido");
                EstructuraConsultarMesa Registro = new EstructuraConsultarMesa(NombreDepartamento, NombreMunicipio, DireccionCentroVotacion, Descripcion, NoEmpadronamiento, DPI, Nombre, Apellido);

                ListaDatos.add(Registro);
            }
            Rs.close();

            Conexion.close();
            return ListaDatos;
        } catch (SQLException ex) {
            return null;
        }
    }

    public List<EstructuraConsultarMesa> ConsultarMesa_X_Padron(Connection Conexion, String _NoPadron) {
        try {
            Statement S = Conexion.createStatement();
            String Query = "SELECT DISTINCT D.nombre DepNombre,MU.nombre MunNombre,CV.direccion,ME.descripcion, P.no_empadronamiento, P.dpi,P.nombre PerNombre, P.apellido \n"
                    + "FROM departamento AS D, municipio AS MU, centro_votacion AS CV, mesa as ME, persona AS P\n"
                    + "WHERE D.id_departamento= MU.DEPARTAMENTO_id && MU.id_municipio= CV.MUNICIPIO_id && CV.id_centro_votacion=ME.CENTRO_VOTACION_id && P.MESA_id=ME.id_mesa && P.no_empadronamiento=" + _NoPadron;

            ResultSet Rs = S.executeQuery(Query);
            List<EstructuraConsultarMesa> ListaDatos = new ArrayList<>();
            while (Rs.next()) {
                String NombreDepartamento = Rs.getString("DepNombre");
                String NombreMunicipio = Rs.getString("MunNombre");
                String DireccionCentroVotacion = Rs.getString("direccion");
                String Descripcion = Rs.getString("descripcion");
                String NoEmpadronamiento = Rs.getString("no_empadronamiento");
                String DPI = Rs.getString("dpi");
                String Nombre = Rs.getString("PerNombre");
                String Apellido = Rs.getString("apellido");
                EstructuraConsultarMesa Registro = new EstructuraConsultarMesa(NombreDepartamento, NombreMunicipio, DireccionCentroVotacion, Descripcion, NoEmpadronamiento, DPI, Nombre, Apellido);

                ListaDatos.add(Registro);
            }
            Rs.close();
            S.close();
            Conexion.close();
            return ListaDatos;
        } catch (SQLException ex) {
            return null;
        }
    }

    public List<EstructuraConsultarMesa> ConsultarTodasLasMesas(Connection Conexion) {
        try {
            Statement S = Conexion.createStatement();
            String Query = "SELECT DISTINCT D.nombre DepNombre,MU.nombre MunNombre,CV.direccion,ME.descripcion, P.no_empadronamiento, P.dpi,P.nombre PerNombre, P.apellido \n"
                    + "FROM departamento AS D, municipio AS MU, centro_votacion AS CV, mesa as ME, persona AS P\n"
                    + "WHERE D.id_departamento= MU.DEPARTAMENTO_id && MU.id_municipio= CV.MUNICIPIO_id && CV.id_centro_votacion=ME.CENTRO_VOTACION_id && P.MESA_id=ME.id_mesa;";

            ResultSet Rs = S.executeQuery(Query);
            List<EstructuraConsultarMesa> ListaDatos = new ArrayList<>();
            while (Rs.next()) {
                String NombreDepartamento = Rs.getString("DepNombre");
                String NombreMunicipio = Rs.getString("MunNombre");
                String DireccionCentroVotacion = Rs.getString("direccion");
                String Descripcion = Rs.getString("descripcion");
                String NoEmpadronamiento = Rs.getString("no_empadronamiento");
                String DPI = Rs.getString("dpi");
                String Nombre = Rs.getString("PerNombre");
                String Apellido = Rs.getString("apellido");
                EstructuraConsultarMesa Registro = new EstructuraConsultarMesa(NombreDepartamento, NombreMunicipio, DireccionCentroVotacion, Descripcion, NoEmpadronamiento, DPI, Nombre, Apellido);

                ListaDatos.add(Registro);
            }
            Rs.close();
            S.close();
            Conexion.close();
            return ListaDatos;
        } catch (SQLException ex) {
            return null;
        }
    }

    public int EmitirVoto(Connection Conexion, int _TipoVotoID, int CandidatoID, int MesaID) {
        try {
            String Query = "INSERT INTO votacion (TIPO_VOTO_id,CADIDATO_id,MESA_id) VALUES(?,?,?)";
            PreparedStatement Pr = Conexion.prepareStatement(Query);
            Pr.setInt(1, _TipoVotoID);
            Pr.setInt(2, CandidatoID);
            Pr.setInt(3, MesaID);

            // execute insert SQL stetement
            Pr.executeUpdate();
            return 1;

        } catch (SQLException E) {
            return 0;
        }
    }

    public String GenerarQueryInsertar(List<EstructuraEmitirVoto> _ListaEmitirVoto) {
        String Query = "";
        int tamanio = _ListaEmitirVoto.size();
        int Contador = 0;
        if (tamanio != 0) {
            Query = "INSERT INTO votacion (TIPO_VOTO_id,CADIDATO_id,MESA_id) VALUES";
        }

        String Coma = ",";
        for (EstructuraEmitirVoto Voto : _ListaEmitirVoto) {
            Contador++;
            if (Contador == tamanio) {
                Coma = "";
            }
            Query += "(" + Voto.TipoVotoID + "," + Voto.CandidatoID + "," + Voto.MesaID + ")" + Coma;
        }

        return Query;
    }

    public int EmitirVotos(Connection Conexion, String Query) {
        try {
            PreparedStatement Pr = Conexion.prepareStatement(Query);
            // execute insert SQL stetement
            Pr.executeUpdate();
            return 1;

        } catch (SQLException E) {
            return 0;
        }
    }
}
