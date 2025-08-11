import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> nomesFrota = new ArrayList<>();
    static ArrayList<Double> precoFrota = new ArrayList<>();
    static ArrayList<Integer> quantidadesNaves = new ArrayList<>();
    static ArrayList<Integer> codigoFrota = new ArrayList<>();
    static ArrayList<String> tripulacao = new ArrayList<>();
    static ArrayList<Planeta> planetas = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    static void cadastrarTripulacao() {
        System.out.print("Digite o nome tripulante: ");
        tripulacao.add(sc.next());
        System.out.println("Tripulante Adicionado!\n");
    }

    static void mostrarTripulacao() {
        System.out.println("Tripulantes:");
        for (int i = 0; i < tripulacao.size(); i++) {
            System.out.println(i + " - " + tripulacao.get(i));
        }
        System.out.println("");
    }

    static void deletarTripulacao() {
        System.out.print("Digite o indice a remover: ");
        tripulacao.remove(sc.nextInt());
        System.out.println("Tripulante removido!\n");
    }

    static void alterarTripulacao() {
        System.out.print("Digite o indice a alterar: ");
        int opt = sc.nextInt();
        System.out.print("Tripulante: " + tripulacao.get(opt) + " alterar para: ");
        String novo = sc.next();
        tripulacao.set(opt, novo);
        System.out.println("Tripulante " + opt + " Alterado\n");
    }

    static void cadastroFrota() {
        System.out.println("Informe o nome da nave: ");
        nomesFrota.add(sc.next());
        System.out.println("Informe o valor da nave: ");
        precoFrota.add(sc.nextDouble());
        System.out.println("Informe quantas naves: ");
        quantidadesNaves.add(sc.nextInt());
        codigoFrota.add(nomesFrota.size() - 1);
        System.out.println("Nave cadastrada com sucesso! O código da nave é: " + (nomesFrota.size() - 1));
    }

    static void deletarFrota() {
        System.out.println("Informe o codigo da Frota para eliminar: ");
        int codigo = sc.nextInt();
        if (codigo >= 0 && codigo < nomesFrota.size()) {
            nomesFrota.remove(codigo);
            precoFrota.remove(codigo);
            quantidadesNaves.remove(codigo);
            codigoFrota.remove(Integer.valueOf(codigo));
            System.out.println("Nave removida com sucesso");
        } else {
            System.out.println("Código inválido!");
        }
    }

    static void verFrota() {
        System.out.println("Frota atual: ");
        for (int i = 0; i < nomesFrota.size(); i++) {
            System.out.println("Código: " + codigoFrota.get(i) + " -\n Nome: " + nomesFrota.get(i) + " -\n Preço: "
                    + precoFrota.get(i) + " -\n Quantidade: " + quantidadesNaves.get(i));
        }
    }

    static class Planeta {
        public final String nome;
        public final String tipo;

        public Planeta(String nome, String tipo) {
            this.nome = nome;
            this.tipo = tipo;
        }

        @Override
        public String toString() {
            return nome + " (" + tipo + ")";
        }
    }

    public static void cadastrarPlaneta() {
        System.out.println("Planeta: ");
        String nome = sc.next();
        System.out.println("Tipo: ");
        String tipo = sc.next();
        planetas.add(new Planeta(nome, tipo));
    }

    public static void mostrarPlanetas() {
        if (planetas.isEmpty()) {
            System.out.println("Nenhum planeta cadastrado.");
            return;
        }
        for (int i = 0; i < planetas.size(); i++) {
            System.out.println((i + 1) + " - " + planetas.get(i));
        }
    }

    public static void removerPlaneta() {
        if (planetas.isEmpty()) {
            System.out.println("Nada para remover.");
            return;
        }
        mostrarPlanetas();
        System.out.println("Número do planeta a remover:");
        int idx = sc.nextInt() - 1;
        if (idx >= 0 && idx < planetas.size()) {
            planetas.remove(idx);
            System.out.println("Planeta removido.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void menuPlanetas() {
        while (true) {
            System.out.println("(1) - Novo planeta");
            System.out.println("(2) - Ver planetas");
            System.out.println("(3) - Remover planeta");
            System.out.println("(4) - Sair");
            int menu = sc.nextInt();

            switch (menu) {
                case 1 -> cadastrarPlaneta();
                case 2 -> mostrarPlanetas();
                case 3 -> removerPlaneta();
                case 4 -> {
                    System.out.println("Saindo…");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    static void menuFrota() {
        System.out.println("Frota atual: ");

        while (true) {
            System.out.println("(1) - Ver frotas");
            System.out.println("(2) - Cadastrar Frota");
            System.out.println("(3) - Deletar Frota");
            System.out.println("(0) - Sair");
            int opcao = sc.nextInt();
            if (opcao == 0) break;
            switch (opcao) {
                case 1:
                    verFrota();
                    break;
                case 2:
                    cadastroFrota();
                    break;
                case 3:
                    deletarFrota();
                    break;
            }
        }
    }

    static void menuTripulacao() {
        while (true) {
            System.out.println("Sistema de cadastro tripulação:");
            System.out.println("(1) - Cadastrar Tripulante");
            System.out.println("(2) - Ver Tripulantes");
            System.out.println("(3) - Alterar Tripulante");
            System.out.println("(4) - Remover Tripulante");
            System.out.println("(0) - Sair");
            String opt = sc.next();
            System.out.println();

            if (opt.equalsIgnoreCase("0")) break;

            switch (opt) {
                case "1" -> cadastrarTripulacao();
                case "2" -> mostrarTripulacao();
                case "3" -> alterarTripulacao();
                case "4" -> deletarTripulacao();
                default -> System.out.println("Comando invalido");
            }
        }
    }

    static void iniciarExpedicao() {
        if (nomesFrota.isEmpty() || planetas.isEmpty()) {
            System.out.println("É necessário ter ao menos uma frota cadastrada e um planeta disponível.\n");
            return;
        }

        // Seleção da frota
        System.out.println("Selecione a frota (por código):");
        verFrota();
        int frotaIdx = sc.nextInt();
        if (frotaIdx < 0 || frotaIdx >= nomesFrota.size()) {
            System.out.println("Código de frota inválido.\n");
            return;
        }

        // Seleção do planeta
        System.out.println("Selecione o planeta (por número):");
        mostrarPlanetas();
        int planetaIdx = sc.nextInt() - 1;
        if (planetaIdx < 0 || planetaIdx >= planetas.size()) {
            System.out.println("Planeta inválido.\n");
            return;
        }

        System.out.println("Expedição iniciada com sucesso!");
        System.out.println("Frota: " + nomesFrota.get(frotaIdx));
        System.out.println("Destino: " + planetas.get(planetaIdx) + "\n");
    }

    static void menu() {
        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("(1) - Menu Frotas");
            System.out.println("(2) - Menu Tripulantes");
            System.out.println("(3) - Menu Planetas");
            System.out.println("(4) - Iniciar Expedição");
            System.out.println("(0) - Sair");
            String opt = sc.next();
            System.out.println();

            if (opt.equalsIgnoreCase("0")) break;

            switch (opt) {
                case "1" -> menuFrota();
                case "2" -> menuTripulacao();
                case "3" -> menuPlanetas();
                case "4" -> iniciarExpedicao();
                default -> System.out.println("Comando inválido\n");
            }
        }
    }
}