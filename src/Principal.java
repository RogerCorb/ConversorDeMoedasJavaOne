import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        Conversor conversor = new Conversor();
        Menu menu = new Menu();
        Conectconvert conectconvert = new Conectconvert();

        try {
            int opcao;
            do {
                menu.menuOption(leitura);
                opcao = menu.getOpcao();
                if (opcao > 0 && opcao < 7) {
                    conversor.message(menu.getDescricaoParEscolhido());
                    conversor.resultConverted(conectconvert,menu);
                    opcao= conversor.getOut(leitura);
                }

            } while (opcao != 7);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
