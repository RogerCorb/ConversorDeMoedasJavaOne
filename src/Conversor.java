import java.util.Scanner;

public class Conversor {

    private String par;
    private String descricaoParEscolhido;

    public String getPar() {
        return par;
    }

    public void setPar(String par) {
        this.par = par;
    }

    public String getDescricaoParEscolhido() {
        return descricaoParEscolhido;
    }

    public void setDescricaoParEscolhido(String descricaoParEscolhido) {
        this.descricaoParEscolhido = descricaoParEscolhido;
    }

    public int getValorDigitado() {
        return valorDigitado;
    }

    public void setValorDigitado(int valorDigitado) {
        this.valorDigitado = valorDigitado;
    }

    private int valorDigitado ;

    public int menu (Scanner leitura ) {

        String menu = """
                *************************************************
                Seja bem vindo menu do  conversor de moedas :)
                          Escolha a opção de conversão
                *************************************************
                
                1) Dolar ==> Peso Argentino.:
                2) Peso Argentino ==> Dólar.:
                3) Dólar ==> Real Brasileiro:
                4) Real Brasileiro ==> Dólar:
                5) Dólar ==> Peso Colombiano:
                6) Peso Colombiano ==> Dólar:
                7) Sair
                
                **************************************************
                """;
        System.out.println(menu);
        System.out.println("Escolha uma opção válida.: ");
        int escolha=leitura.nextInt();
        if (escolha == 1) {
            setPar("pair/USD/ARS");
            setDescricaoParEscolhido("Dolar ==> Peso Argentino");

        } else if (escolha == 2) {
            setPar("pair/ARS/USD");
            setDescricaoParEscolhido("Peso Argentino ==> Dólar");

        } else if (escolha == 3) {
            setPar("pair/USD/BRL");
            setDescricaoParEscolhido("Dólar ==> Real Brasileiro");

        } else if (escolha == 4) {
            setPar("pair/BRL/USD");
            setDescricaoParEscolhido("Real Brasileiro ==> Dólar");

        } else if (escolha == 5) {
            setPar("pair/USD/COP");
            setDescricaoParEscolhido("Dólar ==> Peso Colombiano");

        } else if (escolha == 6) {
            setPar("pair/COP/USD");
            setDescricaoParEscolhido("Peso Colombiano ==> Dólar");

        } else if (escolha != 7) {
            escolha = 0;
        }
        if(escolha<7 && escolha>0) {
            System.out.println("Digite o valor inteiro para converter");
            setValorDigitado(leitura.nextInt());
        }
        return escolha;
    }

    public void resultConverted(Conectconvert conectconvert) {
        try {
            TrataResposta respostaNew = conectconvert.conectStringtoJson(getPar(),
                    String.valueOf(getValorDigitado()));

            System.out.println("A conversão de "+getValorDigitado()+" "+
                    respostaNew.base_code() + " para " +
                    respostaNew.target_code() + " é de :" + respostaNew.conversion_result());
        } catch (Exception e) {
            System.out.println("Não consegui conectar ");
        }
    }

    public void message(){
        System.out.println("Opção Escolhida.:" + getDescricaoParEscolhido());
    }

    public int getOut(Scanner leitura){
        System.out.println("Deseja Continuar S/N.: " );
        var getExit = leitura.next();
        if((getExit).equalsIgnoreCase("S")) {
            return 0;
        }
        return 7;
    }
}
