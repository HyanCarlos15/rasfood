package br.com.rasmoo.restaurante.entity;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String nomeCategoria;

    // Cardinalidade
    /*
    * Many to One
    * Many To Many
    * One To Many
    * One To One -
    * Unidirecional (De um lado para outro - o cardapio tem ocnhecimento da categoria mas a categoria noo)

     */
    public Categoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }


    public Categoria() {

    }


    public Categoria(Integer id, String nomeCategoria) {
        this.id = id;
        this.nomeCategoria = nomeCategoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nomeCategoria='" + nomeCategoria + '\'' +
                '}';
    }
}
