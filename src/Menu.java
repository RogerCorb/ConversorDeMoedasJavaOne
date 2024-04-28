import java.util.Scanner;

public class Menu {

    private String par;
    private String descricaoParEscolhido;
    private int valorDigitado ;
    private int opcao;

    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public int getValorDigitado() {
        return valorDigitado;
    }

    public void setValorDigitado(int valorDigitado) {
        this.valorDigitado = valorDigitado;
    }

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

    public void menuOption (Scanner leitura ) {

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

        switch (escolha) {
            case 1:
                setPar("USD/ARS");
                setDescricaoParEscolhido("Dolar ==> Peso Argentino");
                break;
            case 2:
                setPar("ARS/USD");
                setDescricaoParEscolhido("Peso Argentino ==> Dólar");
                break;
            case 3:
                setPar("USD/BRL");
                setDescricaoParEscolhido("Dólar ==> Real Brasileiro");
                break;
            case 4:
                setPar("BRL/USD");
                setDescricaoParEscolhido("Real Brasileiro ==> Dólar");
                break;
            case 5:
                setPar("USD/COP");
                setDescricaoParEscolhido("Dólar ==> Peso Colombiano");
                break;
            case 6:
                setPar("COP/USD");
                setDescricaoParEscolhido("Peso Colombiano ==> Dólar");
                break;
            default:
                escolha = 7 ;
                break;
        }
        if(escolha<7 && escolha>0) {
            System.out.println("Digite o valor inteiro para converter");
            setValorDigitado(leitura.nextInt());
        }
        setOpcao(escolha);
    }
}
