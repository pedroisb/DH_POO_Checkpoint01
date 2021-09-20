package Checkpoint;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import static java.time.temporal.ChronoUnit.MINUTES;

public abstract class Pedido {

    private int id;
    private LocalTime horaPedido;
    private Cliente cliente;
    private List<ItemCardapio> itensPedidos;
    private double precoTotal;


    public Pedido() {
        this.horaPedido = LocalTime.now().truncatedTo(MINUTES);
        this.itensPedidos = new ArrayList<>();
    }

    //MÉTODOS ELABORADOS

    //Adiciona item à lista de itens pedidos
    public void addItem(ItemCardapio item){
        this.itensPedidos.add(item);
    }


    //Método que irá somar o preço de todos os itens do pedido
    public double calcPrecoTotal(){
        double total = 0;
        for (ItemCardapio item : itensPedidos){
            total += item.getPreco();
        }
        return total;
    }

    //Método que irá estimar o horário em que o pedido poderá ser retirado, no caso de retirada, ou tempo no qual o pedido será entregue, no caso de delivery.
    public abstract LocalTime calcPrevisao();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(LocalTime horaPedido) {
        this.horaPedido = horaPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemCardapio> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(List<ItemCardapio> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
}



