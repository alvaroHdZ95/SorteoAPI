package api_manager;

/**
 * <h1>Premios</h1>
 * Clase con los parámetros de utilidad para el tratamiento de los premios de la Lotería del Niño.
 *
 * @author Álvaro Hernández Valero
 * @seeAlso <a href="https://servicios.elpais.com/sorteos/loteria-del-nino/api/">API</a>
 * @seeAlso <a href="https://classroom.google.com/u/1/c/NTQ3MTQwMTIwMzY2/a/NTgyMTU3MDcwOTU2/details">Tarea</a>
 */
public class Prizes {

    // FIELDS
    private String timestamp;
    private String status;
    private String fraseTexto;
    private String pdfURL;
    private String error;
    private String premio1;
    private String premio2;
    private String premio3;
    private String[] extracciones4cifras;
    private String[] extracciones3cifras;
    private String[] extracciones2cifras;
    private String[] reintegros;


    // GETTERS & SETTERS
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFraseTexto() {
        return fraseTexto;
    }

    public void setFraseTexto(String fraseTexto) {
        this.fraseTexto = fraseTexto;
    }

    public String getPdfURL() {
        return pdfURL;
    }

    public void setPdfURL(String pdfURL) {
        this.pdfURL = pdfURL;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPremio1() {
        return premio1;
    }

    public void setPremio1(String premio1) {
        this.premio1 = premio1;
    }

    public String getPremio2() {
        return premio2;
    }

    public void setPremio2(String premio2) {
        this.premio2 = premio2;
    }

    public String getPremio3() {
        return premio3;
    }

    public void setPremio3(String premio3) {
        this.premio3 = premio3;
    }

    public String[] getExtracciones4cifras() {
        return extracciones4cifras;
    }

    public void setExtracciones4cifras(String[] extracciones4cifras) {
        this.extracciones4cifras = extracciones4cifras;
    }

    public String[] getExtracciones3cifras() {
        return extracciones3cifras;
    }

    public void setExtracciones3cifras(String[] extracciones3cifras) {
        this.extracciones3cifras = extracciones3cifras;
    }

    public String[] getExtracciones2cifras() {
        return extracciones2cifras;
    }

    public void setExtracciones2cifras(String[] extracciones2cifras) {
        this.extracciones2cifras = extracciones2cifras;
    }

    public String[] getReintegros() {
        return reintegros;
    }

    public void setReintegros(String[] reintegros) {
        this.reintegros = reintegros;
    }
}
