import java.util.*;

public class Main {
    public static void main(String[] args) {
        Abrigo abrigo = new Abrigo("Abrigo dos Animais", "Rua dos Animais, 123", "abrigo@email.com", "1234-5678", "8h - 18h");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===============================================\n" + //
                                "     🐾   Abrigo dos Animais   🐾\n" + //
                                "===============================================\n" + //
                                "          Seu abrigo de confiança\n" + //
                                "        onde o amor pelos animais começa! 💖\n" + //
                                "===============================================");
            System.out.println();
            System.out.println("Bem-vindo ao sistema do Abrigo dos Animais!");
            System.out.println("\n=== MENU ===");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Login Usuário");
            System.out.println("3. Login Administrador");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Senha: ");
                String senha = sc.nextLine();
                abrigo.cadastrarUsuario(new Usuario(nome, email, senha));
                System.out.println("Usuário cadastrado com sucesso!");
            } else if (opcao == 2) {
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Senha: ");
                String senha = sc.nextLine();

                boolean loginSucesso = abrigo.getUsuarios().stream()
                        .anyMatch(u -> u.getEmail().equals(email) && u.getSenha().equals(senha));

                if (loginSucesso) {
                    System.out.println("Login realizado com sucesso!");
                    while (true) {
                        System.out.println("\n=== MENU USUÁRIO ===");
                        System.out.println("1. Ver animais disponíveis para adoção");
                        System.out.println("2. Solicitar adoção");
                        System.out.println("3. Atualizar dados pessoais");
                        System.out.println("4. Sair");
                        System.out.print("Escolha uma opção: ");
                        int escolhaUsuario = sc.nextInt();
                        sc.nextLine();

                        if (escolhaUsuario == 1) {
                            System.out.println("\n=== ANIMAIS DISPONÍVEIS ===");
                            for (Animal animal : abrigo.getAnimais()) {
                                System.out.println("- Nome: " + animal.getNome() +
                                        ", Idade: " + animal.getIdade() +
                                        ", Espécie: " + animal.getEspecie() +
                                        ", Porte: " + animal.getPorte() +
                                        ", Descrição: " + animal.getDescricao());
                            }
                        } else if (escolhaUsuario == 2) {
                            System.out.print("\nDigite o nome do animal que deseja adotar: ");
                            String nomeAnimal = sc.nextLine();
                            Animal animalParaAdocao = abrigo.buscarAnimalPorNome(nomeAnimal);

                            if (animalParaAdocao != null) {
                                System.out.print("Confirme a data de adoção (dd/MM/yyyy): ");
                                String dataAdocao = sc.nextLine();
                                Pedido pedido = new Pedido(email, animalParaAdocao, dataAdocao);
                                abrigo.registrarPedido(pedido);
                                System.out.println("Pedido de adoção registrado com sucesso!");
                            } else {
                                System.out.println("Animal não encontrado.");
                            }
                        } else if (escolhaUsuario == 3) {
                            System.out.print("\nDigite o novo nome (ou pressione Enter para manter o atual): ");
                            String novoNome = sc.nextLine();
                            System.out.print("Digite o novo email (ou pressione Enter para manter o atual): ");
                            String novoEmail = sc.nextLine();
                            System.out.print("Digite a nova senha (ou pressione Enter para manter a atual): ");
                            String novaSenha = sc.nextLine();

                            for (Usuario usuario : abrigo.getUsuarios()) {
                                if (usuario.getEmail().equals(email)) {
                                    if (!novoNome.isEmpty()) usuario.setNome(novoNome);
                                    if (!novoEmail.isEmpty()) usuario.setEmail(novoEmail);
                                    if (!novaSenha.isEmpty()) usuario.setSenha(novaSenha);
                                    System.out.println("Dados atualizados com sucesso!");
                                    break;
                                }
                            }
                        } else if (escolhaUsuario == 4) {
                            System.out.println("Saindo...");
                            break;
                        } else {
                            System.out.println("Opção inválida.");
                        }
                    }
                } else {
                    System.out.println("Email ou senha incorretos.");
                }
            } else if (opcao == 3) {
                System.out.print("Código do administrador: ");
                String codigo = sc.nextLine();
                if (codigo.equals("1111")) {
                    System.out.println("Login de administrador realizado com sucesso!");
                    while (true) {
                        System.out.println("\n=== MENU ADMINISTRADOR ===");
                        System.out.println("1. Adicionar novo animal");
                        System.out.println("2. Gerenciar pedidos de adoção");
                        System.out.println("3. Sair");
                        System.out.print("Escolha uma opção: ");
                        int escolhaAdmin = sc.nextInt();
                        sc.nextLine();

                        if (escolhaAdmin == 1) {
                            System.out.print("Nome do animal: ");
                            String nomeAnimal = sc.nextLine();
                            System.out.print("Idade do animal: ");
                            int idade = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Espécie do animal: ");
                            String especie = sc.nextLine();
                            System.out.print("Porte do animal: ");
                            String porte = sc.nextLine();
                            System.out.print("Descrição do animal: ");
                            String descricao = sc.nextLine();

                            Animal novoAnimal = new Animal(nomeAnimal, idade, especie, porte, descricao);
                            abrigo.adicionarAnimal(novoAnimal);
                            System.out.println("Animal adicionado com sucesso!");
                        } else if (escolhaAdmin == 2) {
                            System.out.println("\n=== GERENCIAR PEDIDOS ===");
                            for (Pedido pedido : abrigo.getPedidosAdocao()) {
                                System.out.println("Nome do adotante: " + pedido.getNomeAdotante() +
                                        ", Animal: " + pedido.getAnimalAdotado().getNome() +
                                        ", Data de adoção: " + pedido.getDataAdocao());
                                System.out.print("Deseja aprovar este pedido? (s/n): ");
                                String aprovacao = sc.nextLine();
                                if (aprovacao.equalsIgnoreCase("s")) {
                                    System.out.println("Pedido aprovado!");
                                    abrigo.getAnimais().remove(pedido.getAnimalAdotado());
                                } else {
                                    System.out.println("Pedido rejeitado.");
                                }
                            }
                        } else if (escolhaAdmin == 3) {
                            System.out.println("Saindo...");
                            break;
                        } else {
                            System.out.println("Opção inválida.");
                        }
                    }
                } else {
                    System.out.println("Código do administrador incorreto.");
                }
            } else if (opcao == 4) {
                System.out.println("Encerrando o sistema...");
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }
}
