package projetoagenda.model;

public class Contato {
    
    String nome;
    String celular;
    Endereco endereco;

    public Contato(String nome, String celular, Endereco endereco) {
        this.nome = nome;
        this.celular = celular;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return  "nome:" + nome + ", celular:" + celular + ", endereco:" + endereco;
    }
    
    
}
