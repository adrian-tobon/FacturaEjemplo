package com.curso.springboot.facturaejemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.springboot.facturaejemplo.models.Client;
import com.curso.springboot.facturaejemplo.models.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

	@Autowired
	private Invoice invoice;
	
	@GetMapping("/show")
	public Invoice show() {
		/*Invoice i = new Invoice();
		Client client = new Client();
		client.setName(invoice.getClient().getName());
		client.setLastname(invoice.getClient().getLastname());
		i.setDescription(invoice.getDescription());
		i.setItems(invoice.getItems());
		i.setClient(client);
		return i;*/
		return invoice;
	}
	
}
