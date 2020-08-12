package com.isthari.cassandra.mapper;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.isthari.cassandra.mapper.dao.InventoryMapper;
import com.isthari.cassandra.mapper.dao.InventoryMapperBuilder;
import com.isthari.cassandra.mapper.dao.ProductDao;
import com.isthari.cassandra.mapper.data.Product;

public class TestMapper {
	private static final Log log = LogFactory.getLog(TestMapper.class);

	public static void main(String[] args) {
		// Obtener la conexion
		try ( CqlSession session = SessionFactory.getSession() ){
			// Crear el mapper builder. Solo es necesario hacerlo 1 vez
			log.info("Creando mapper");
			InventoryMapper inventoryMapper = new InventoryMapperBuilder(session).build();
			
			// Obtener el dao
			log.info("Obteniendo productDao");
			ProductDao dao = inventoryMapper.productDao(CqlIdentifier.fromCql("inventory"));
			
			// Operar el dao, parecido a hibernate
			log.info("Insertando registro");
			Product product = new Product(UUID.randomUUID(), "Product 1");
			dao.save(product);
		}
		
	}
}
