public class Util {
    /**
     * método que recebe um cpf por string e retorne true se é valido ou false caso contrário 
     * @param cpf numero identificador da pessoa física
     * @return true se cpf valido
     */
    public static boolean cpfValido(String cpf) {
        if (cpf == null) return false;

        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("\\D", "");

        // Verifica tamanho
        if (cpf.length() != 11) return false;

        // Verifica se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) return false;

        try {
            // Cálculo do primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += (cpf.charAt(i) - '0') * (10 - i);
            }
            int dig1 = 11 - (soma % 11);
            if (dig1 >= 10) dig1 = 0;

            // Cálculo do segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += (cpf.charAt(i) - '0') * (11 - i);
            }
            int dig2 = 11 - (soma % 11);
            if (dig2 >= 10) dig2 = 0;

            // Verifica se os dígitos calculados conferem
            return dig1 == (cpf.charAt(9) - '0') &&
                dig2 == (cpf.charAt(10) - '0');

        } catch (Exception e) {
            return false;
        }
        }
    }
