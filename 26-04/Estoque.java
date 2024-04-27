import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Estoque {
    private List<Item> itens = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        boolean executando = true;

        while (executando) {
            System.out.println("1 - Cadastrar item");
            System.out.println("2 - Listar item");
            System.out.println("3 - Sair");
            System.out.println("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarItem();
                    break;
                case 2:
                    listarItens();
                    break;
                case 3:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

        scanner.close();
    }

    private void cadastrarItem() {
        System.out.print("Nome do item: ");
        String nome = scanner.nextLine();

        System.out.print("Quantidade do item: ");
        int quantidade = scanner.nextInt();

        System.out.print("Preço do item: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        Item item = new Item(nome, quantidade, preco);
        itens.add(item);
        System.out.println("Item cadastrado com sucesso!!!");
    }

    private void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Nenhum item cadastrado");
        } else {
            for (Item item : itens) {
                System.out.println(item);
            }
        }
    }

    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        estoque.iniciar();
    }
}

class Item {
    private String nome;
    private int quantidade;
    private double preco;

    public Item(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Item: " + nome + ", Quantidade: " + quantidade + ", Preço: " + preco;
    }
}
