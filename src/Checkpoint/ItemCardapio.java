package Checkpoint;

import java.time.Duration;

public class ItemCardapio {

    private int id;
    private String nome;
    private String categoria;
    private Duration tempoPreparo;
    private double preco;

    public ItemCardapio() {
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public Duration getTempoPreparo() {
        return tempoPreparo;
    }

    public double getPreco() {
        return preco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setTempoPreparo(Duration tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}

