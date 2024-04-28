import java.util.Scanner;

public class Conversor{


    public void resultConverted(Conectconvert conectconvert, Menu m) {
        try {
            TrataResposta respostaNew = conectconvert.conectStringtoJson(m.getPar(),
                    String.valueOf(m.getValorDigitado()));

            System.out.println("A conversão de "+m.getValorDigitado()+" "+
                    respostaNew.base_code() + " para " +
                    respostaNew.target_code() + " é de :" + respostaNew.conversion_result());
        } catch (Exception e) {
            System.out.println("Não consegui conectar ");
        }
    }

    public void message(String m){
        System.out.println("Opção Escolhida.:" + m);
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