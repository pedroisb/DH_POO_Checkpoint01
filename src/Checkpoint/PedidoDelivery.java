package Checkpoint;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.MINUTES;

public class PedidoDelivery extends Pedido{

    private LocalTime previsaoEntrega;

    public PedidoDelivery() {}

    //Na implementação da previsão de tempo do Delivery acrescentei quantias de tempo segundo zona onde cliente mora: 5min, para zona01 (pequena distância); 10min, para zona02 (média distância); 15min, para zona03 (grande distância).
    @Override
    public LocalTime calcPrevisao() {
        LocalTime tempoPreparoTotal = LocalTime.now().truncatedTo(MINUTES);
        for (ItemCardapio item : getItensPedidos()){
            tempoPreparoTotal = tempoPreparoTotal.plus(item.getTempoPreparo());
        }
        tempoPreparoTotal = tempoPreparoTotal.truncatedTo(MINUTES);
        if (Objects.equals(getCliente().getZona(), 3))
            tempoPreparoTotal = tempoPreparoTotal.plusMinutes(15);
        else if (Objects.equals(getCliente().getZona(), 2))
            tempoPreparoTotal = tempoPreparoTotal.plusMinutes(10);
        else
            tempoPreparoTotal = tempoPreparoTotal.plusMinutes(5);
        return tempoPreparoTotal;
    }

    public LocalTime getPrevisaoEntrega() {
        return previsaoEntrega;
    }

    public void setPrevisaoEntrega(LocalTime previsaoEntrega) {
        this.previsaoEntrega = previsaoEntrega;
    }
}
