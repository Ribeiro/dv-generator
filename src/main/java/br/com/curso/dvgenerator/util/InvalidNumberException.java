package br.com.curso.dvgenerator.util;

/**
 * Excecao disparada caso do numero ter o digito verificador invalio.
 * @author Fabio Barros
 */
public class InvalidNumberException extends Exception {
    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = 1950613373250274773L;

    /**
     * Constutor padrao.
     * @param message mensagem.
     */
    public InvalidNumberException(String message) {
        super(message);
    }
}
