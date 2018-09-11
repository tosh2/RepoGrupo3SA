package Recursos;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import DB.ConexionBD;
import DB.Metodos;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationPath("")
@Path("/Recursos-SA")
public class ConsultarMesa extends Application {

    @GET
    @Path("/ConsultarMesaDPI/{DPI}")
    @Produces({MediaType.APPLICATION_JSON})
    public String ConsultarMesaPorDPI(@PathParam("DPI") String _DPI) throws SQLException {
        ConexionBD Conn = new ConexionBD();
        Metodos Mt = new Metodos();
        List<EstructuraConsultarMesa> ListaMesa_X_DPI = Mt.ConsultarMesa_X_DPI(Conn.conectar(), _DPI);
        String JsonConsultarMesa_X_DPI = new Gson().toJson(ListaMesa_X_DPI);
        return JsonConsultarMesa_X_DPI;
    }

    @GET
    @Path("/ConsultarMesaPadron/{NoPadron}")
    @Produces({MediaType.APPLICATION_JSON})
    public String ConsultarMesaPorPadron(@PathParam("NoPadron") String _NoPadron) throws SQLException {
        ConexionBD Conn = new ConexionBD();
        Metodos Mt = new Metodos();
        List<EstructuraConsultarMesa> ListaMesa_X_Padron = Mt.ConsultarMesa_X_Padron(Conn.conectar(), _NoPadron);
        String JsonConsultarMesa_X_Padron = new Gson().toJson(ListaMesa_X_Padron);
        return JsonConsultarMesa_X_Padron;
    }

    @GET
    @Path("/ConsultarMesas")
    @Produces({MediaType.APPLICATION_JSON})
    public String ConsultarMesaPorPadron() throws SQLException {
        ConexionBD Conn = new ConexionBD();
        Metodos Mt = new Metodos();
        List<EstructuraConsultarMesa> ListaMesas = Mt.ConsultarTodasLasMesas(Conn.conectar());
        String JsonConsultarMesa_X_Padron = new Gson().toJson(ListaMesas);
        return JsonConsultarMesa_X_Padron;

    }

    @POST
    @Path("/ConsultarMesaPorDPI")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String ConsultarMesaDPI(EstructuraDPIPadron _EDD_DPI_Padron) {
        ConexionBD Conn = new ConexionBD();
        Metodos Mt = new Metodos();
        List<EstructuraConsultarMesa> ListaMesa_X_DPI = Mt.ConsultarMesa_X_DPI(Conn.conectar(), _EDD_DPI_Padron.DPI);
        String JsonConsultarMesa_X_DPI = new Gson().toJson(ListaMesa_X_DPI);
        return JsonConsultarMesa_X_DPI;
    }

    @POST
    @Path("/ConsultarMesaPorPadron")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String ConsultarMesaPadron(EstructuraDPIPadron _EDD_DPI_Padron) {
        ConexionBD Conn = new ConexionBD();
        Metodos Mt = new Metodos();
        List<EstructuraConsultarMesa> ListaMesa_X_Padron = Mt.ConsultarMesa_X_Padron(Conn.conectar(), _EDD_DPI_Padron.Padron);
        String JsonConsultarMesa_X_Padron = new Gson().toJson(ListaMesa_X_Padron);
        //String A = new Gson().toJ
        return JsonConsultarMesa_X_Padron;
    }

    @PUT
    @Path("/EmitirVoto")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String Emitir_Voto(EstructuraEmitirVoto _EmitirVoto) {
        ConexionBD Conn = new ConexionBD();
        Metodos Mt = new Metodos();
        int EmitirVoto = Mt.EmitirVoto(Conn.conectar(), _EmitirVoto.TipoVotoID, _EmitirVoto.CandidatoID, _EmitirVoto.MesaID);
        String Resultado = "{\"Resultado\" : " + EmitirVoto + "}";
        if (EmitirVoto == 1) {
            //exito
            return Resultado;
        } else {
            //Fracaso
            return Resultado;
        }
    }

    @PUT
    @Path("/CargaMasivaVotos")
    @Consumes({MediaType.APPLICATION_JSON})
    //@Produces({MediaType.APPLICATION_JSON})
    public String CargaMasiva(List<EstructuraEmitirVoto> _ListaEmitirVoto) {
        ConexionBD Conn = new ConexionBD();
        Metodos Mt = new Metodos();
        String GenerarQueryInsertar = Mt.GenerarQueryInsertar(_ListaEmitirVoto);
        int EmitirVotos = Mt.EmitirVotos(Conn.conectar(), GenerarQueryInsertar);
        String Resultado = "{\"Resultado\" : " + EmitirVotos + "}";
        if (EmitirVotos == 1) {
            //exito
            return Resultado;
        } else {
            //Fracaso
            return Resultado;
        }
    }
}
