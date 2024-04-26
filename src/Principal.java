import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        Conversor conversor = new Conversor();
        Conectconvert conectconvert = new Conectconvert();

        try {
            int opcao;
            do {

                opcao = conversor.menu(leitura);
                if (opcao > 0 && opcao < 7) {
                    conversor.message();
                    conversor.resultConverted(conectconvert);
                    opcao= conversor.getOut(leitura);
                }

            } while (opcao != 7);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
