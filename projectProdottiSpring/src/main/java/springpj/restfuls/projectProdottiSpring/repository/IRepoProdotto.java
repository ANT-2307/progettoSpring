package springpj.restfuls.projectProdottiSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springpj.restfuls.projectProdottiSpring.model.Prodotto;

@Repository
public interface IRepoProdotto extends JpaRepository<Prodotto, Integer> {

}
