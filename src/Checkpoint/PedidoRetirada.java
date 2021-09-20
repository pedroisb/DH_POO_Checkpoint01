package Checkpoint;

import java.time.Duration;
import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.MINUTES;

public class PedidoRetirada extends Pedido {

    private LocalTime previsaoRetirada;

    public PedidoRetirada(){};

    @Override
    public LocalTime calcPrevisao() {
        LocalTime tempoPreparoTotal = LocalTime.now().truncatedTo(MINUTES);
        for (ItemCardapio item : getItensPedidos()){
            tempoPreparoTotal = tempoPreparoTotal.plus(item.getTempoPreparo());
        }
        return tempoPreparoTotal;
    }

    public LocalTime getPrevisaoRetirada() {
        return previsaoRetirada;
    }

    public void setPrevisaoRetirada(LocalTime previsaoRetirada) {
        this.previsaoRetirada = previsaoRetirada;
    }
}
