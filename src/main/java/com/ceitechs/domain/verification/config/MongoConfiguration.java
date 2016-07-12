package com.ceitechs.domain.verification.config;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author iddymagohe
 * @since 0.1
 *
 */
@Configuration
@EnableMongoRepositories("com.ceitechs.domain.verification.repositories")
public class MongoConfiguration extends AbstractMongoConfiguration {

    private final static String HOSTS_SEPARATOR = ",";
    private final static String HOSTS__PORT_SEPARATOR = ":";


    @Value("${db.password}")
    private String dbPassword;

    @Value("${db.user}")
    private String dbuser;

    /*
     * Host:port;host:port
     */
    @Value("${db.host.name}")
    private String host;

    @Value("${db.name}")
    private String dbName;


    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Override
    public Mongo mongo() throws Exception {
        List<ServerAddress> addresses = Stream.of(host.split(HOSTS_SEPARATOR))
                .map(addr -> {
                    String[] hostAndport = addr.split(HOSTS__PORT_SEPARATOR);
                    try {
                        return new ServerAddress(hostAndport[0], Integer.valueOf(hostAndport[1]));
                    } catch (UnknownHostException e) {
                        e.printStackTrace(); //TODO log this exception
                        return null;
                    }
                }).collect(Collectors.toList());

        MongoCredential mongoCredential = MongoCredential.createMongoCRCredential(dbuser, dbName, dbPassword.toCharArray());
        Mongo mongo = new MongoClient(addresses, Arrays.asList(mongoCredential));
        mongo.setWriteConcern(WriteConcern.ACKNOWLEDGED);
        return mongo;
    }

    @Bean(name = "coordinatorMongoTemplate")
    public  MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), getDatabaseName());
    }

    @Bean(name = "coordinatorGridFsTemplate")
    public GridFsTemplate gridFsTemplate() throws Exception {
        return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
    }
}
