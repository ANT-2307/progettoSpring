package springpj.restfuls.projectProdottiSpring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springpj.restfuls.projectProdottiSpring.model.Prodotto;
import springpj.restfuls.projectProdottiSpring.repository.IRepoProdotto;

@RestController
public class Avvio {
	
	@Autowired
	IRepoProdotto irp;
	
	@GetMapping("/viewAll")
	public List<Prodotto> viewAll(){
		return irp.findAll();
	}
	
	@GetMapping("/cerca")
	public Optional<Prodotto> cerca(@RequestParam int id){
		return irp.findById(id);
	}
	
	@GetMapping("/rimozione")
	public String rimozione(int id) {
		irp.deleteById(id);
		return "Rimozione avvenuta con successo";
	}

	@PostMapping("/upsert")
	public String upsert(Prodotto prodotto) {
		String messaggio="Inserimento avvenuto con successo";
		if(irp.existsById(prodotto.getId())) {
			messaggio="Modifica avvenuta con successso";
		}
		irp.save(prodotto);
		return messaggio;
	}
	
}
