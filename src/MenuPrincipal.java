import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) throws Throwable {


        Scanner scn = new Scanner(System.in);

        System.out.println("----------------------------------------");
        System.out.println("  MERCADO MODERNA - ESCOLHA UMA OPÇÃO  ");
        System.out.println("----------------------------------------");
        System.out.println(" 1 - Cadastrar Produto ");
        System.out.println(" 2 - Atualizar Produto ");
        System.out.println(" 3 - Excluir Produto ");
        System.out.println(" 4 - Cadastrar Secao ");
        System.out.println(" 5 - Atualizar Secao ");
        System.out.println(" 6 - Excluir Secao ");
        System.out.println(" 7 - Listar Produto ");
        System.out.println(" 8 - Listar Secao ");
        System.out.println("-----------------------------------------");
        System.out.println("Opção: ");

        int num1 = scn.nextInt();
        scn.nextLine();
        while (num1 > 8 && num1 < 1){
            System.out.println("Dado inválido, escolha a opção 1 a 8");
            num1 = scn.nextInt();
            scn.nextLine();


        }

        switch (num1) {
            case 1:
                //Chama o metodo
                ProdutoDAO.InserirProduto();
                break;
            case 2:
                ProdutoDAO.atualizarProduto();
                break;
            case 3:
                ProdutoDAO.excluirProduto();
                break;
            case 4:
                SecaoDAO.InserirSecao();
                break;
            case 5:
                SecaoDAO.atualizarSecao();
                break;
            case 6: SecaoDAO.excluirSecao();
                break;
            case 7: ProdutoDAO.listarProdutos();
                break;
            case 8: SecaoDAO.listarsecao();
                break;

        }






    }
}
