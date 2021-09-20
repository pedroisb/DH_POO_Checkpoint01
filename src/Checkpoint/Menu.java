package Checkpoint;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Menu {

    //criado atributo para fins de controle no switch
    private boolean exit = false;

    //criado scanner
    Scanner leitor = new Scanner(System.in);

    //instanciado obj restaurante vazio
    Restaurante restaurante = new Restaurante();

    //instanciadas listas vazias para armazenar objs a serem criados
    List<ItemCardapio> cardapio = new ArrayList<>();
    List<Cliente> listaClientes = new ArrayList<>();
    List<PedidoRetirada> listaPedidosRetirada = new ArrayList<>();
    List<PedidoDelivery> listaPedidosDelivery = new ArrayList<>();


    //------------------------------------------------------------------------------------------------//
    //MENU INICIAL

    //cabeçalho do menu
    public void printHeader() {
        System.out.println("\n+-------------------------------------------+");
        System.out.println("|               BOAS-VINDAS!                |");
        System.out.println("|       Sistema de registro e controle      |");
    }

    public void runMenu() {
        do {
            printMenu();
            short opt = getInput();
            accessOpt(opt);
        } while (!exit);
    }

    private void printMenu() {
        System.out.println("+-------------------------------------------+");
        System.out.println("| 1 - Preencher dados do restaurente        |");
        System.out.println("| 2 - Exibir dados do restaurente           |");
        System.out.println("| 3 - Cadastrar item no cardápio            |");
        System.out.println("| 4 - Exibir cardápio                       |");
        System.out.println("| 5 - Cadastrar cliente                     |");
        System.out.println("| 6 - Exibir clientes cadastrados           |");
        System.out.println("| 7 - Cadastrar pedido                      |");
        System.out.println("| 8 - Exibir pedidos para retirada          |");
        System.out.println("| 9 - Exibir pedidos para delivery          |");
        System.out.println("| 10 - Sair                                 |");
        System.out.println("+-------------------------------------------+");
    }

    private short getInput() {
        short opt = 0;
        do {
            try {
                System.out.print("|Selecione uma opção: ");
                opt = Short.parseShort(leitor.nextLine());
                if (opt < 1 || opt > 10) {
                    System.out.println("\n+-------------------------------------------+");
                    System.out.println("|              Opção inválida               |");
                    System.out.println("|             Digite Novamente              |");
                    System.out.println("+-------------------------------------------+");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n+-------------------------------------------+");
                System.out.println("|              Opção inválida               |");
                System.out.println("|             Digite Novamente              |");
                System.out.println("+-------------------------------------------+");
            }
        } while (opt < 1 || opt > 10);
        return opt;
    }

    private void accessOpt(short opt) {
        switch (opt) {
            case 1:
                registrarRestaurante();
                break;
            case 2:
                printRestaurante();
                break;
            case 3:
                registrarItem();
                break;
            case 4:
                printCardapio();
                break;
            case 5:
                cadastrarCliente();
                break;
            case 6:
                printClientes();
                break;
            case 7:
                runMenuPedido();
                break;
            case 8:
                printRetirada();
                break;
            case 9:
                printDelivery();
                break;
            case 10:
                exit = true;
                System.out.println("\n+-------------------------------------------+");
                System.out.println("|                Até breve!                 |");
                System.out.println("|              d==( ಠ ෴ ಠ )                |");
                System.out.println("+-------------------------------------------+");
                break;
            default:
                System.out.println("\n+-------------------------------------------+");
                System.out.println("|             Erro desconhecido             |");
                System.out.println("+-------------------------------------------+");
        }
    }


    //------------------------------------------------------------------------------------------------//
    //OPÇÃO 1 - PREENCHER DADOS DO RESTAURANTE


    private void registrarRestaurante() {
        System.out.print("\nNome do Restaurante: ");
        restaurante.setNome(leitor.nextLine());

        System.out.print("Endereço: ");
        restaurante.setEndereco(leitor.nextLine());

        System.out.print("Telefone (com código regional): ");
        restaurante.setTelefone(leitor.nextLine());

        System.out.print("Estilo culinário: ");
        restaurante.setEstiloCulinario(leitor.nextLine());

        System.out.print("Nota de avaliação: ");
        restaurante.setAvaliacao(leitor.nextLine());

        System.out.print("Horário de funcionamento: ");
        restaurante.setHorarioFuncionamento(leitor.nextLine());

        System.out.println("+-------------------------------------------+");
        System.out.println("|       Cadastro realizado com êxito        |");
        System.out.println("+-------------------------------------------+");

        System.out.println("\nPressione ENTER para continuar");
        leitor.nextLine(); //utilizado para limpar scanner
    }

    //------------------------------------------------------------------------------------------------//
    //OPÇÃO 2 - EXIBIR DADOS DO RESTAURANTE

    private void printRestaurante() {
        System.out.println("\n+------------------------------------------------------+");
        System.out.println("Nome: " + restaurante.getNome());
        System.out.println("Endereço: " + restaurante.getEndereco());
        System.out.println("Tel: " + restaurante.getTelefone());
        System.out.println("Estilo culinário: " + restaurante.getEstiloCulinario());
        System.out.println("Avaliação: " + restaurante.getAvaliacao());
        System.out.println("Horário de funcionamento: " + restaurante.getHorarioFuncionamento());
        System.out.println("+------------------------------------------------------+");

        System.out.println("\nPressione ENTER para continuar");
        leitor.nextLine(); //uma pausa antes de voltar para menu principal
    }


    //------------------------------------------------------------------------------------------------//
    //OPÇÃO 3 - REGISTRAR ITEM NO CARDÁPIO


    private void registrarItem() {
        ItemCardapio item = new ItemCardapio();

        System.out.print("Nome: ");
        item.setNome(leitor.nextLine());

        System.out.print("Categoria: ");
        item.setCategoria(leitor.nextLine());

        System.out.println("Tempo de preparo em minutos: ");
        System.out.println("(Escrever no formato PT00M)");
        item.setTempoPreparo(Duration.parse(leitor.nextLine()).truncatedTo(ChronoUnit.MINUTES));

        System.out.print("Preço: ");
        item.setPreco(Double.parseDouble(leitor.nextLine()));

        cardapio.add(item);
        item.setId(cardapio.indexOf(item)+1);

        System.out.println("+-------------------------------------------+");
        System.out.println("|         Item cadastrado com êxito         |");
        System.out.println("+-------------------------------------------+");

        System.out.println("\nPressione ENTER para continuar");
        leitor.nextLine(); //uma pausa antes de voltar para menu principal
    }


    //------------------------------------------------------------------------------------------------//
    //OPÇÃO 4 - EXIBIR CARDÁPIO


    private void printCardapio() {

        for (ItemCardapio item : cardapio) {

            System.out.println("\nId: " + item.getId());
            System.out.println("Nome: " + item.getNome());
            System.out.println("Categoria: " + item.getCategoria());
            System.out.println("Tempo de preparo em minutos: " + item.getPreco());
            System.out.println("Preço: R$ " + item.getPreco());
        }

        System.out.println("\nPressione ENTER para continuar");
        leitor.nextLine(); //uma pausa antes de voltar para menu principal
    }


    //------------------------------------------------------------------------------------------------//
    //OPÇÃO 5 - CADASTRAR CLIENTE


    private void cadastrarCliente() {
        Cliente cliente = new Cliente();

        System.out.print("\nNome: ");
        cliente.setNome(leitor.nextLine());

        System.out.print("Sobrenome: ");
        cliente.setSobrenome(leitor.nextLine());

        System.out.print("Endereço: ");
        cliente.setEndereco(leitor.nextLine());

        System.out.println("Zona - Digite: ");
        System.out.println(" 1 - para endereço a curta distância");
        System.out.println(" 2 - para endereço a média distância");
        System.out.println(" 3 - para endereço a longa distância");
        cliente.setZona(Integer.parseInt(leitor.nextLine()));

        System.out.print("Celular (com código regional): ");
        cliente.setCelular(leitor.nextLine());

        listaClientes.add(cliente);
        cliente.setId(listaClientes.indexOf(cliente)+1);

        System.out.println("+-------------------------------------------+");
        System.out.println("|       Cliente cadastrado com êxito        |");
        System.out.println("+-------------------------------------------+");

        System.out.println("\nPressione ENTER para continuar");
        leitor.nextLine(); //uma pausa antes de voltar para menu principal
    }

    //------------------------------------------------------------------------------------------------//
    //OPÇÃO 6 - EXIBIR CLIENTES CADASTRADOS


    private void printClientes() {
        for (Cliente cliente : listaClientes) {

            System.out.println("\nID: " + cliente.getId());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Sobrenome: " + cliente.getSobrenome());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("Celular: " + cliente.getCelular());
            System.out.println("Celular: " + cliente.getCelular());
        }

        System.out.println("\nPressione ENTER para continuar");
        leitor.nextLine(); //uma pausa antes de voltar para menu principal
    }


    //------------------------------------------------------------------------------------------------//
    //OPÇÃO 7 - CADASTRAR PEDIDO
    //CRIADO UM SUB-MENU


    private void runMenuPedido(){
        printMenuPedido();
        short opt = getInputPedido();
        accessOptPedido(opt);
    }

    private void printMenuPedido(){
        System.out.println("\n+-------------------------------------------+");
        System.out.println("| 1 - Pedido para retirada                   |");
        System.out.println("| 2 - Pedido para delivery                   |");
        System.out.println("| 3 - Voltar para o Menu Principal           |");
        System.out.println("+-------------------------------------------+");
    }

    private short getInputPedido(){
        short opt = 0;
        do {
            try {
                System.out.print("|Selecione uma opção: ");
                opt = Short.parseShort(leitor.nextLine());
                if (opt < 1 || opt > 3) {
                    System.out.println("+-------------------------------------------+");
                    System.out.println("|              Opção inválida               |");
                    System.out.println("|             Digite Novamente              |");
                    System.out.println("+-------------------------------------------+");
                }
            } catch (NumberFormatException e) {
                System.out.println("+-------------------------------------------+");
                System.out.println("|              Opção inválida               |");
                System.out.println("|             Digite Novamente              |");
                System.out.println("+-------------------------------------------+");
            }
        } while(opt < 1 || opt > 3);
        return opt;
    }

    private void accessOptPedido(short opt){
        switch (opt) {
            case 1:
                registrarRetirada();
                break;
            case 2:
                registrarDelivery();
                break;
            case 3:
                runMenu();
                break;
            default:
                System.out.println("+-------------------------------------------+");
                System.out.println("|             Erro desconhecido             |");
                System.out.println("+-------------------------------------------+");
        }
    }

    //------------------------------------------------------------------------------------------------//
    //OPÇÃO 7 . 1 - REGISTRAR PEDIDO PARA RETIRADA


    private void registrarRetirada(){
        PedidoRetirada retirada = new PedidoRetirada();

        System.out.print("\nID do Cliente: ");
        int idCliente = Integer.parseInt(leitor.nextLine());
        retirada.setCliente(listaClientes.get(idCliente-1));

        String fim;
        do {
            System.out.print("ID do item: ");
            int idItem = Integer.parseInt(leitor.nextLine());
            retirada.addItem(cardapio.get(idItem - 1));
            System.out.println("\nPara cadastrar outro item, pressione ENTER");
            System.out.println("Para encerrar, digite FIM");
            fim = leitor.nextLine();
        } while(!Objects.equals(fim, "FIM"));

        //preço total será calculado a partir do respectivo método da classe, sem interferência humana
        retirada.setPrecoTotal(retirada.calcPrecoTotal());

        //horário para retirada será calculado a partir do respectivo método da classe, sem interferência humana
        retirada.setPrevisaoRetirada(retirada.calcPrevisao());

        listaPedidosRetirada.add(retirada);
        retirada.setId(listaPedidosRetirada.indexOf(retirada)+1);

        System.out.println("+-------------------------------------------+");
        System.out.println("|        Pedido cadastrado com êxito        |");
        System.out.println("+-------------------------------------------+");

        System.out.println("\nPressione ENTER para continuar");
        leitor.nextLine(); //uma pausa antes de voltar para menu principal
    }


    //------------------------------------------------------------------------------------------------//
    //OPÇÃO 7 . 2 - REGISTRAR PEDIDO PARA DELIVERY


    private void registrarDelivery(){
        PedidoDelivery delivery = new PedidoDelivery();

        System.out.print("\nID do Cliente: ");
        int idCliente = Integer.parseInt(leitor.nextLine());
        delivery.setCliente(listaClientes.get(idCliente-1));

        String fim;
        do {
            System.out.print("ID do item: ");
            int idItem = Integer.parseInt(leitor.nextLine());
            delivery.addItem(cardapio.get(idItem - 1));
            System.out.println("\nPara cadastrar outro item, pressione ENTER");
            System.out.println("Para encerrar, digite FIM");
            fim = leitor.nextLine();
        } while(!Objects.equals(fim, "FIM"));

        //preço total será calculado a partir do respectivo método da classe, sem interferência humana
        delivery.setPrecoTotal(delivery.calcPrecoTotal());

        //horário para retirada será calculado a partir do respectivo método da classe, sem interferência humana
        delivery.setPrevisaoEntrega(delivery.calcPrevisao());

        listaPedidosDelivery.add(delivery);
        delivery.setId(listaPedidosDelivery.indexOf(delivery)+1);

        System.out.println("+-------------------------------------------+");
        System.out.println("|        Pedido cadastrado com êxito        |");
        System.out.println("+-------------------------------------------+");

        System.out.println("\nPressione ENTER para continuar");
        leitor.nextLine(); //uma pausa antes de voltar para menu principal
    }


    //------------------------------------------------------------------------------------------------//
    //OPÇÃO 8 - EXIBE PEDIDOS PARA RETIRADA


    private void printRetirada(){
        System.out.println("+-------------------------------------------+");
        System.out.println("|           Pedidos para Retirada           |");
        for (PedidoRetirada retirada : listaPedidosRetirada) {
            System.out.println("+-------------------------------------------+");
            System.out.println("ID: " + retirada.getId());
            System.out.println("Cliente ID: " + retirada.getCliente().getId());

            for (ItemCardapio item : retirada.getItensPedidos()) {
                System.out.println("Item ID: " + item.getId());
            }

            System.out.println("Preço total: R$" + retirada.getPrecoTotal());
            System.out.println("Hora do pedido: " + retirada.getHoraPedido());
            System.out.println("Previsão para retirada: " + retirada.getPrevisaoRetirada());
            System.out.println("+-------------------------------------------+");
        }
        System.out.println("\nPressione ENTER para continuar");
        leitor.nextLine(); //uma pausa antes de voltar para menu principal
    }


    //------------------------------------------------------------------------------------------------//
    //OPÇÃO 9 - EXIBE PEDIDOS PARA DELIVERY


    private void printDelivery() {
        System.out.println("+-------------------------------------------+");
        System.out.println("|           Pedidos para Delivery           |");
        for (PedidoDelivery delivery : listaPedidosDelivery) {
            System.out.println("+-------------------------------------------+");
            System.out.println("ID: " + delivery.getId());
            System.out.println("Cliente ID: " + delivery.getCliente().getId());

            for (ItemCardapio item : delivery.getItensPedidos()) {
                System.out.println("Item ID: " + item.getId());
            }

            System.out.println("Preço total: R$" + delivery.getPrecoTotal());
            System.out.println("Hora do pedido: " + delivery.getHoraPedido());
            System.out.println("Previsão para retirada: " + delivery.getPrevisaoEntrega());
            System.out.println("+-------------------------------------------+");
        }
        System.out.println("\nPressione ENTER para continuar");
        leitor.nextLine(); //uma pausa antes de voltar para menu principal
    }
}