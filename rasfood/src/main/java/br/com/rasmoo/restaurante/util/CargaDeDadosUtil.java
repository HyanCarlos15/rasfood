package br.com.rasmoo.restaurante.util;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.CategoriaDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.entity.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CargaDeDadosUtil {

    private CargaDeDadosUtil () {}

    public static void cadastrarCategorias (EntityManager entityManager) {
        Categoria entrada = new Categoria("Entradas");
        Categoria salada = new Categoria("Saladas");
        Categoria principal = new Categoria("Principal");
        Categoria sobremesa = new Categoria("Sobremesas");

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        categoriaDao.cadastrar(entrada);
        entityManager.flush();
        categoriaDao.cadastrar(salada);
        entityManager.flush();
        categoriaDao.cadastrar(principal);
        entityManager.flush();
        categoriaDao.cadastrar(sobremesa);
        entityManager.flush();
        entityManager.clear();
    }

    public static void cadastrarProdutosCardapio(EntityManager entityManager) {
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);

        List<Categoria> categorias = categoriaDao.consultarTodos();
        Cardapio moqueca = new Cardapio("moqueca", "Peixe branco, banana terra, arroz e farofa", true, BigDecimal.valueOf(95.00), categorias.get(2));
        Cardapio Spaghetti = new Cardapio("Spaghetti", "Spaghettu ao molho de parmesão e cogumelos", true, BigDecimal.valueOf(68.00), categorias.get(2));
        Cardapio Caesar = new Cardapio("Caesar", "Salada de frango com molho caesar", true, BigDecimal.valueOf(40.00), categorias.get(1));
        Cardapio Caprese = new Cardapio("Caprese", "Caprese", true, BigDecimal.valueOf(47.00), categorias.get(1));
        Cardapio Sorvete = new Cardapio("Sorvete", "Sorvete na tigela de varios sabores", true, BigDecimal.valueOf(37.50), categorias.get(3));
        Cardapio Fondue = new Cardapio("Fondue", "Fondue com frutas", true, BigDecimal.valueOf(88.00), categorias.get(3));

        cardapioDao.cadastrar(moqueca);
        cardapioDao.cadastrar(Spaghetti);
        cardapioDao.cadastrar(Caesar);
        cardapioDao.cadastrar(Caprese);
        cardapioDao.cadastrar(Sorvete);
        cardapioDao.cadastrar(Fondue);
        entityManager.getTransaction().commit();
        entityManager.clear();



    }


}
