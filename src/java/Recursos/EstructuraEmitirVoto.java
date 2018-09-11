package Recursos;

/**
 *
 * @author Denis
 */
public class EstructuraEmitirVoto {

    public int TipoVotoID;
    public int CandidatoID;
    public int MesaID;

    public EstructuraEmitirVoto() {
    }

    public EstructuraEmitirVoto(int TipoVotoID, int CandidatoID, int MesaID) {
        this.TipoVotoID = TipoVotoID;
        this.CandidatoID = CandidatoID;
        this.MesaID = MesaID;
    }

    public int getTipoVotoID() {
        return TipoVotoID;
    }

    public void setTipoVotoID(int TipoVotoID) {
        this.TipoVotoID = TipoVotoID;
    }

    public int getCandidatoID() {
        return CandidatoID;
    }

    public void setCandidatoID(int CandidatoID) {
        this.CandidatoID = CandidatoID;
    }

    public int getMesaID() {
        return MesaID;
    }

    public void setMesaID(int MesaID) {
        this.MesaID = MesaID;
    }

}
