import java.util.Scanner;

public class Conversor {

    public int getValorDigitado() {
        return valorDigitado;
    }

    public void setValorDigitado(int valorDigitado) {
        this.valorDigitado = valorDigitado;
    }

    private int valorDigitado ;

    public int menu (Scanner leitura ,int escolha) {

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
        escolha=leitura.nextInt();
        if(escolha<7 && escolha>0) {
            System.out.println("Digite o valor inteiro para converter");
            setValorDigitado(leitura.nextInt());
        }
        return escolha;
    }

    public void resultConverted(String par,Conectconvert conectconvert) {
        try {
            TrataResposta respostaNew = conectconvert.conectStringtoJson(par,
                    String.valueOf(getValorDigitado()));


            System.out.println("A conversão de "+String.valueOf(getValorDigitado())+" "+
                    respostaNew.base_code() + " para " +
                    respostaNew.target_code() + " é de :" + respostaNew.conversion_result());
        } catch (Exception e) {
            System.out.println("Não consegui conectar ");
        }
    }
}
