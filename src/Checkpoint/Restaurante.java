package Checkpoint;

import java.util.List;

public class Restaurante {

    private String nome;
    private String endereco;
    private String telefone;
    private String estiloCulinario;
    private String avaliacao;
    private String horarioFuncionamento;

    public Restaurante() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEstiloCulinario(String estiloCulinario) {
        this.estiloCulinario = estiloCulinario;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEstiloCulinario() {
        return estiloCulinario;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }
}
