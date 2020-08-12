package com.isthari.cassandra.mapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.datastax.oss.driver.api.core.CqlSession;

public class SessionFactory {
	private static CqlSession session;
	private static final Log log = LogFactory.getLog(SessionFactory.class);
			
	public static CqlSession getSession() {
		if (session == null) {
			createDatabase();
			
			log.info("conectando al keyspace inventory");
			session = CqlSession.builder()
					.withKeyspace("inventory")
					.build();
			createTables();
		}
		return session;
	}
	
	private static void createDatabase() {
		try (CqlSession session1 = CqlSession.builder().build()) {
			createKeyspaces(session1);
		}
	}
	
	private static void createKeyspaces(CqlSession session1) {
		log.info("Creando keyspace");
		session1.execute("CREATE KEYSPACE if not exists inventory WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1}");
	}
	
	private static void createTables() {
		log.info("Creando tablas");
		session.execute("CREATE TABLE if not exists inventory.product(id uuid PRIMARY KEY, description text)");
	}
}
