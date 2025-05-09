package com.curso.springboot.facturaejemplo.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//import org.springframework.web.context.annotation.RequestScope;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
//@JsonIgnoreProperties({"targetSource", "advisors"})
public class Invoice {

	@Autowired
	private Client client;

	@Value("${invoice.description.office}")
	private String description;

	@Autowired
	@Qualifier("itemsOffice")
	private List<Item> items;

	public Invoice() {
		System.out.println("en la creacion del componente de Invoice");
		System.out.println(client);
		System.out.println(description);
		System.out.println(items);

	}

	@PostConstruct
	public void init() {
		System.out.println("Luego de la creacion del componente de Invoice");
		setDescription(getDescription().concat(" del cliente: ").concat(client.getName() 
				+ " " + client.getLastname()));
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destruyendo el componente o bean invoice");
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getTotalInvoice() {
		/*
		 * int total = 0; for (Item item :items) { total += item.getImporte(); }
		 */

		int total = items.stream().map(i -> i.getImporte()).reduce(0, (sum, importe) -> sum + importe);
		return total;
	}
}
