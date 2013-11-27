package br.com.curso.dvgenerator.util;

/**
 * Classe para auxiliar nas validacoes de numeros (CPF, CNPJ, NUP, etc).
 * @author Fabio Barros
 */
public final class ValidationHelper {

    /**
     * Tamanho do CPF.
     */
    public static final int TAMANHO_CPF = 9;

    /**
     * Tamanho do CNPJ.
     */
    public static final int TAMANHO_CNPJ = 12;

    /**
     * Tamanho do Numero da Inscricao.
     */
    public static final int TAMANHO_NUMERO_INSCRICAO = 11;

    /**
     * Tamanho do Numero da Inscricao.
     */
    public static final int TAMANHO_NUMERO_PROCESSO = 15;

    /**
     * Tamanho do Numero da Inscricao.
     */
    public static final int TAMANHO_NUMERO_PROCESSO_ANTIGO = 13;

    /**
     * Calcula o digito verificador do numero do processo.
     *
     * @param nup Numero do processo
     * @return Digito verificador
     * @throws InvalidNumberException Caso o numero seja invalido
     */
    public static String getNupDV(String nup) throws InvalidNumberException {
        if (nup.length() != TAMANHO_NUMERO_PROCESSO
                && nup.length() != TAMANHO_NUMERO_PROCESSO_ANTIGO) {
            throw new InvalidNumberException("Numero do processo deve ter "
                    + TAMANHO_NUMERO_PROCESSO + " ou "
                    + TAMANHO_NUMERO_PROCESSO_ANTIGO + " caracteres. ");
        }
        String dv1 = calculaDvNup(nup);
        String dv2 = calculaDvNup(nup + dv1);
        return dv1 + dv2;
    }

    /**
     * Calcula o DV para o NUP. Peso a partir de 2.
     *
     * @param valor nup
     * @return dv
     */
    private static String calculaDvNup(String valor) {
        int peso = 2;
        int produto = 0;

        for (int i = valor.length() - 1; i >= 0; i--) {
            int algorismo = Integer.valueOf(String.valueOf(valor.charAt(i)));

            produto += algorismo * peso;
            peso++;
        }

        int digito = 11 - (produto % 11);
        if (digito >= 10) {
            return String.valueOf(digito - 10);
        }
        return String.valueOf(digito);
    }

    /**
     * Calcula o digito verificador do Numero da inscricao.
     *
     * @param numeroInscricao valor a ser validado
     * @return true se for valido e false caso contrario
     * @throws InvalidNumberException Caso o numero seja invalido
     */
    public static String getNumeroInscricaoDV(String numeroInscricao)
            throws InvalidNumberException {
        if (numeroInscricao.length() != TAMANHO_NUMERO_INSCRICAO) {
            throw new InvalidNumberException("Numero da inscricao deve ter "
                    + TAMANHO_NUMERO_INSCRICAO + " caracteres. ");
        }
        String dv1 = calculaDvNumeroInscricao(numeroInscricao);
        String dv2 = calculaDvNumeroInscricao(numeroInscricao + dv1);
        return dv1 + dv2;
    }

    /**
     * Calcula o DV para o numero da inscricao. Pesos de 9 a 2.
     *
     * @param valor numero da inscricao
     * @return dv
     */
    private static String calculaDvNumeroInscricao(String valor) {
        int peso = 2;
        int produto = 0;

        for (int i = valor.length() - 1; i >= 0; i--) {
            int algorismo = Integer.valueOf(String.valueOf(valor.charAt(i)));
            produto += algorismo * peso;
            if (peso == 9) {
                peso = 2;
            } else {
                peso++;
            }
        }

        int resto = produto % 11;
        if (resto > 1) {
            return String.valueOf(11 - resto);
        }
        return String.valueOf(resto);
    }

    /**
     * Calcula o digito verificador do CNPJ.
     *
     * @param cnpj valor a ser validado
     * @return true se for valido e false caso contrario
     * @throws InvalidNumberException Caso o CNPJ seja invalido
     */
    public static String getCnpjDV(String cnpj) throws InvalidNumberException {
        if (cnpj.length() != TAMANHO_CNPJ) {
            throw new InvalidNumberException("CNPJ deve ter " + TAMANHO_CNPJ
                    + " caracteres.");
        }

        int dig;
        String cnpjCalc = "";

        char[] cnpjChars = cnpj.toCharArray();

        /* Primeira parte */
        dig = cnpjPrimeiraParte(cnpjChars);
        cnpjCalc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);

        /* Segunda parte */
        cnpjChars = (cnpj + cnpjCalc).toCharArray();
        dig = cnpjSegundaParte(cnpjChars);
        cnpjCalc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);

        return cnpjCalc;
    }

    /**
     * Usado na validacao do CNPJ. Validando 1a parte do cnpj.
     *
     * @param cnpjChars cnpj
     * @return digito verificador da 1a parte
     */
    private static int cnpjSegundaParte(char[] cnpjChars) {
        int soma = 0;
        for (int i = 0; i < 5; i++) {
            if (cnpjChars[i] - 48 >= 0 && cnpjChars[i] - 48 <= 9) {
                soma += (cnpjChars[i] - 48) * (7 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if (cnpjChars[i + 5] - 48 >= 0 && cnpjChars[i + 5] - 48 <= 9) {
                soma += (cnpjChars[i + 5] - 48) * (10 - (i + 1));
            }
        }

        int dig = 11 - (soma % 11);

        return dig;
    }

    /**
     * Usado na validacao do CNPJ. Validando 2a parte do cnpj.
     *
     * @param cnpjChars cnpj
     * @return digito verificador da 2a parte
     */
    private static int cnpjPrimeiraParte(char[] cnpjChars) {
        int soma = 0;
        for (int i = 0; i < 4; i++) {
            if (cnpjChars[i] - 48 >= 0 && cnpjChars[i] - 48 <= 9) {
                soma += (cnpjChars[i] - 48) * (6 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if (cnpjChars[i + 4] - 48 >= 0 && cnpjChars[i + 4] - 48 <= 9) {
                soma += (cnpjChars[i + 4] - 48) * (10 - (i + 1));
            }
        }

        int dig = 11 - (soma % 11);

        return dig;
    }

    /**
     * Valida um CPF.
     * @param cpf valor a ser validado
     * @return true se for valido e false caso contrario
     * @throws InvalidNumberException Caso o numero seja invalido
     */
    public static String getCpfDV(String cpf) throws InvalidNumberException {

        if (cpf.length() != TAMANHO_CPF) {
            throw new InvalidNumberException("CPF deve ter " + TAMANHO_CPF
                    + " caracteres.");
        }

        int d1;
        int d2;
        int digito1;
        int digito2;
        int resto;
        int digitoCPF;
        String nDigResult;

        d1 = 0;
        d2 = 0;
        digito1 = 0;
        digito2 = 0;
        resto = 0;
        String cpfNum = cpf + "00";
        for (int nCount = 1; nCount < cpfNum.length() - 1; nCount++) {
            digitoCPF = Integer.valueOf(cpfNum.substring(nCount - 1, nCount))
                    .intValue();

            // multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4
            // e assim por diante.
            d1 = d1 + (11 - nCount) * digitoCPF;

            // para o segundo digito repita o procedimento incluindo o primeiro
            // digito calculado no passo anterior.
            d2 = d2 + (12 - nCount) * digitoCPF;
        }

        // Primeiro resto da divisao por 11.
        resto = d1 % 11;

        // Se o resultado for 0 ou 1 o digito e 0 caso contrario o digito e 11
        // menos o resultado anterior.
        if (resto < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }

        d2 += 2 * digito1;

        // Segundo resto da divisao por 11.
        resto = d2 % 11;

        // Se o resultado for 0 ou 1 o digito e 0 caso contrario o digito e 11
        // menos o resultado anterior.
        if (resto < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }

        // Digito verificador do CPF que esta sendo validado.
        // String nDigVerific = cpf.substring(cpf.length() - 2, cpf.length());

        // Concatenando o primeiro resto com o segundo.
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

        // comparar o digito verificador do cpf com o primeiro resto + o segundo
        // resto.
        return nDigResult;
    }
}
