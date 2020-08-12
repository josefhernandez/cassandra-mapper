# Despliegue de cassandra
docker run --rm --network=host -e DS_LICENSE=accept --name my-dse datastax/dse-server:6.8.2

# Ejecución del test
mvn compile exec:java -Dexec.mainClass=com.isthari.cassandra.mapper.TestMapper

Resultados 
```
[INFO] --- exec-maven-plugin:1.2.1:java (default-cli) @ mapper ---
2020-08-12 11:19:54 INFO  DefaultMavenCoordinates:37 - DataStax Java driver for Apache Cassandra(R) (com.datastax.oss:java-driver-core) version 4.8.0
2020-08-12 11:19:54 INFO  Clock:40 - Using native clock for microsecond precision
2020-08-12 11:19:54 INFO  MetadataManager:134 - [s0] No contact points provided, defaulting to /127.0.0.1:9042
2020-08-12 11:19:54 INFO  SessionFactory:32 - Creando keyspace
2020-08-12 11:19:56 INFO  SessionFactory:16 - conectando al keyspace inventory
2020-08-12 11:19:56 INFO  Clock:40 - Using native clock for microsecond precision
2020-08-12 11:19:56 INFO  MetadataManager:134 - [s1] No contact points provided, defaulting to localhost/127.0.0.1:9042
2020-08-12 11:19:57 INFO  SessionFactory:37 - Creando tablas
2020-08-12 11:19:57 INFO  TestMapper:22 - Creando mapper
2020-08-12 11:19:57 INFO  TestMapper:26 - Obteniendo productDao
2020-08-12 11:19:57 INFO  TestMapper:30 - Insertando registro
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  7.575 s
[INFO] Finished at: 2020-08-12T11:20:00+02:00
[INFO] ------------------------------------------------------------------------
```

