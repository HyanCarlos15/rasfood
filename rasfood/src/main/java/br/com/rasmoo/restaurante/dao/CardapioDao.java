package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

public class CardapioDao {

    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

 /*
 * Crud
 * C = Create
 * R = Read
 * U = Update
 * D = Delete
 */

    public void cadastrar (Cardapio cardapio) {
        this.entityManager.persist(cardapio);
    }

    public Cardapio consultarPorId(final Integer id) {
       return this.entityManager.find(Cardapio.class,id);
    }

    public Cardapio consultarPorNome (final String filtro) {
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE UPPER (c.nome) = UPPER (:nome)";
            return this.entityManager.createQuery(jpql, Cardapio.class).setParameter("nome", filtro).getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    public List<Cardapio> consultarPorValor (final BigDecimal filtro) {
        String jpql = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
        return this.entityManager.createQuery(jpql,Cardapio.class).setParameter("valor",filtro).getResultList();
    }

    public List<Cardapio> consultarTodos() {
        String jpql = "SELECT c FROM Cardapio c"; // jpql - Voltado a orientação a objeto
        return this.entityManager.createQuery(jpql,Cardapio.class).getResultList();
    }

    public void atualizar(final Cardapio cardapio){
        this.entityManager.merge(cardapio);

    }

    public void excluir (final Cardapio cardapio) {
        this.entityManager.remove(cardapio);
    }


}
