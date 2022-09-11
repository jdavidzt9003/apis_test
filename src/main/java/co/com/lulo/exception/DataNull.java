package co.com.lulo.exception;

public class DataNull extends AssertionError {

    public static final String DATA_NULL = "La consulta arrojo la data nula";

    public DataNull(String message, Throwable cause){
        super(message, cause);
    }
}
