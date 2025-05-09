package com.curso.springboot.facturaejemplo;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.curso.springboot.facturaejemplo.models.Item;
import com.curso.springboot.facturaejemplo.models.Product;

@Configuration
@PropertySources({
	@PropertySource(value="classpath:config/data.properties", encoding="UTF-8")	
})

public class FacturaEjemploConfig {
	
	
	@Bean
	@Primary
	List<Item> itemsInvoice()
	{
		Product p1 = new Product("Camara Sony", 800);
		Product p2 = new Product("Playstation 5 Pro", 1200);
		Product p3 = new Product("Bicicleta Bianchi 26", 1200);
		return Arrays.asList(new Item(p1,2),new Item(p2,4),new Item(p3,1));	
	
	}
	
	@Bean("itemsOffice")
	List<Item> itemsInvoiceOficce()
	{
		Product p1 = new Product("Monitor ASUS 24", 700);
		Product p2 = new Product("Notebook Razer", 2400);
		Product p3 = new Product("Impresora HP", 800);
		Product p4 = new Product("Escritorio Oficina", 900);
		return Arrays.asList(new Item(p1,4),new Item(p2,6),new Item(p3,1), new Item(p4,4));	
	
	}

}
