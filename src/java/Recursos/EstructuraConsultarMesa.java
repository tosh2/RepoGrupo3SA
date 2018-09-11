
package Recursos;

/**
 *
 * @author Denis
 */
public class EstructuraConsultarMesa {
    String NombreDepartamento;
    String NombreMunicipio;
    String DireccionCentroVotacion;
    String Descripcion;
    String NoEmpadronamiento;
    String DPI;
    String Nombre;
    String Apellido;

    public EstructuraConsultarMesa() {
    }

    public EstructuraConsultarMesa(String NombreDepartamento, String NombreMunicipio, String DireccionCentroVotacion, String Descripcion, String NoEmpadronamiento, String DPI, String Nombre, String Apellido) {
        this.NombreDepartamento = NombreDepartamento;
        this.NombreMunicipio = NombreMunicipio;
        this.DireccionCentroVotacion = DireccionCentroVotacion;
        this.Descripcion = Descripcion;
        this.NoEmpadronamiento = NoEmpadronamiento;
        this.DPI = DPI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
    }

    public String getNombreDepartamento() {
        return NombreDepartamento;
    }

    public void setNombreDepartamento(String NombreDepartamento) {
        this.NombreDepartamento = NombreDepartamento;
    }

    public String getNombreMunicipio() {
        return NombreMunicipio;
    }

    public void setNombreMunicipio(String NombreMunicipio) {
        this.NombreMunicipio = NombreMunicipio;
    }

    public String getDireccionCentroVotacion() {
        return DireccionCentroVotacion;
    }

    public void setDireccionCentroVotacion(String DireccionCentroVotacion) {
        this.DireccionCentroVotacion = DireccionCentroVotacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getNoEmpadronamiento() {
        return NoEmpadronamiento;
    }

    public void setNoEmpadronamiento(String NoEmpadronamiento) {
        this.NoEmpadronamiento = NoEmpadronamiento;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    
    
    
}



//SELECT DISTINCT D.nombre,Mu.nombre,CV.direccion,ME.descripcion, P.no_empadronamiento, P.dpi,P.nombre, P.apellido 
//FROM departamento AS D, municipio AS MU, centro_votacion AS CV, mesa as ME, persona AS P
//WHERE D.id_departamento= Mu.DEPARTAMENTO_id && MU.id_municipio= CV.MUNICIPIO_id && CV.id_centro_votacion=ME.CENTRO_VOTACION_id && P.MESA_id=ME.id_mesa;
