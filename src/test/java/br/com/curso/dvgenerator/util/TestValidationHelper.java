package br.com.curso.dvgenerator.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Teste para a classe {@link ValidationHelper}.
 * @author Fabio Barros
 */
public class TestValidationHelper {

    /**
     * Inicializacao do teste.
     * @throws Exception
     */
    @Before
    public void setUp() {
    }

    /**
     * Teste para {@link ValidationHelper#getNupDV(String)}.
     * @throws InvalidNumberException Caso o metodo dispare um erro
     */
    @Test(expected = InvalidNumberException.class)
    public void testGetNupDV() throws InvalidNumberException {
        assertEquals("87", ValidationHelper.getNupDV("1234567891212"));
        assertEquals("93", ValidationHelper.getNupDV("123456789121212"));
        assertEquals("93", ValidationHelper.getNupDV(""));
    }

    /**
     * Teste para {@link ValidationHelper#getNumeroInscricaoDV(String)}.
     * @throws InvalidNumberException Caso o metodo dispare um erro
     */
    @Test(expected = InvalidNumberException.class)
    public void testGetNumeroInscricaoDV() throws InvalidNumberException {
        assertEquals("51", ValidationHelper.getNumeroInscricaoDV("12345678912"));
        assertEquals("51", ValidationHelper.getNumeroInscricaoDV(""));
    }

    /**
     * Teste para {@link ValidationHelper#getCnpjDV(String)}.
     * @throws InvalidNumberException  Caso o metodo dispare um erro
     */
    @Test(expected = InvalidNumberException.class)
    public void testGetCnpjDV() throws InvalidNumberException {
        assertEquals("51", ValidationHelper.getCnpjDV("012345678912"));
        assertEquals("51", ValidationHelper.getCnpjDV(""));
    }

    /**
     * Teste para {@link ValidationHelper#getCpfDV(String)}.
     * @throws InvalidNumberException  Caso o metodo dispare um erro
     */
    @Test(expected = InvalidNumberException.class)
    public void testGetCpfDV() throws InvalidNumberException {
        assertEquals("09", ValidationHelper.getCpfDV("123456789"));
        assertEquals("09", ValidationHelper.getCpfDV(""));
    }

}
