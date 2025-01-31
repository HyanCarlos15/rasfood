package br.com.rasmoo.restaurante.service.test;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.CategoriaDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.entity.Categoria;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        cadastrarProdutoCardapio(entityManager, cadastrarCategoria(entityManager));

    }

    private static Categoria cadastrarCategoria (EntityManager entityManager) {
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        Categoria pratoprincipal = new Categoria("Prato Principal");
        entityManager.getTransaction().begin();
        categoriaDao.cadastrar(pratoprincipal); // Sem cadastrar o insert não é possivel
        entityManager.getTransaction().commit();
        entityManager.clear();
        return pratoprincipal;


    }

    private static void cadastrarProdutoCardapio (EntityManager entityManager, Categoria categoria) {

        // Aqui ainda é uma entidade em Transiente - ou seja não está no JPA
        Cardapio risotto = new Cardapio();
        risotto.setNome("Risoto de frutos do mar");
        risotto.setDescricao("Risoto acompanhado com lula");
        risotto.setDisponivel(true);
        risotto.setCategoria(categoria);
        risotto.setValor(BigDecimal.valueOf(88.50));// Aqui ainda é uma entidade em Transiente - ou seja não está no JPA


        Cardapio salmao = new Cardapio();
        salmao.setNome("salmao ao molho de maracuja");
        salmao.setDescricao("salmao grelhado ao molho de maracuja");
        salmao.setDisponivel(true);
        salmao.setCategoria(categoria);
        salmao.setValor(BigDecimal.valueOf(88.50));


         // Gerencia a entidade
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();
        cardapioDao.cadastrar(risotto);
        entityManager.flush();// A partir de agora sai do transiente para o persist, ou seja o JPA tem ciencia dessa classe
        cardapioDao.cadastrar(salmao);
        entityManager.flush();
        System.out.println("O Prato consultado foi: " + cardapioDao.consultar(1));
        System.out.println("O Prato consultado foi: " + cardapioDao.consultar(2));
        // entityManager.getTransaction().commit(); Sincronizar o banco de dados
        entityManager.close();




    }
}
