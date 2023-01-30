package api_manager;

/**
 * <h1>Búsquedas</h1>
 * Clase con los parámetros de utilidad para el tratamiento de las búsquedas de un número de la Lotería del Niño.
 *
 * @author Álvaro Hernández Valero
 * @seeAlso <a href="https://servicios.elpais.com/sorteos/loteria-del-nino/api/">API</a>
 * @seeAlso <a href="https://classroom.google.com/u/1/c/NTQ3MTQwMTIwMzY2/a/NTgyMTU3MDcwOTU2/details">Tarea</a>
 */

public class Searches {

    // FIELDS
    private String numero;
    private String premio;
    private String timestamp;
    private String status;
    private String error;


    // GETTERS & SETTERS
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPremio() {
        return premio;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }

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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
