package br.com.pordotom;

public class FixtureException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 6171827724136742504L;

    public FixtureException() {
        super();
    }

    public FixtureException(String message, Throwable cause) {
        super("Ocorreu um erro: " + cause + " in " + message);
    }

    public FixtureException(String message) {
        super(message);
    }

    public FixtureException(Throwable cause) {
        super(cause);
    }

}
