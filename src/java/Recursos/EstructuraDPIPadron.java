
package Recursos;

/**
 *
 * @author Denis
 */
public class EstructuraDPIPadron {
    public String DPI;
    public String Padron;

    public EstructuraDPIPadron() {
    }

    public EstructuraDPIPadron(String DPI, String Padron) {
        this.DPI = DPI;
        this.Padron = Padron;
    }
    
    

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public String getPadron() {
        return Padron;
    }

    public void setPadron(String Padron) {
        this.Padron = Padron;
    }
}
