package br.com.rasmoo.restaurante.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity // Atribui como entidade
@Table (name = "cardapio")
public class Cardapio {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração de valor para o ID
    private Integer id;
    private String nome;
    private String descricao;
    private boolean disponivel;
    private BigDecimal valor;
    @ManyToOne
    private Categoria categoria;

    @Column(name = "data_registro")
    private LocalDateTime dataDeRegistro = LocalDateTime.now();

    public Cardapio(String nome, String descricao, boolean disponivel, BigDecimal valor, LocalDateTime dataDeRegistro) {
        this.nome = nome;
        this.descricao = descricao;
        this.disponivel = disponivel;
        this.valor = valor;
        this.dataDeRegistro = dataDeRegistro;
    }

    public Cardapio() {

    }

    public Cardapio(String nome, String descricao, boolean disponivel, BigDecimal valor, Categoria categoria) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(LocalDateTime dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }


    public Cardapio(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    @Override
    public String toString() {
        return "Cardapio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", disponivel=" + disponivel +
                ", valor=" + valor +
                ", categoria=" + categoria +
                ", dataDeRegistro=" + dataDeRegistro +
                '}';
    }
}
