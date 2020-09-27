package com.xgxx.springboot.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * @ClassName ElasticSearchConfig
 * @Description TODO
 * @Author Dx
 * @Date 2020/9/27 14:48
 * @Version 1.0
 **/
@Configuration
public class ElasticSearchConfig  {

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        ClientConfiguration configuration = ClientConfiguration.builder(
        )
                .connectedTo("124.71.169.233:9200")
                //.withConnectTimeout(Duration.ofSeconds(5))
                //.withSocketTimeout(Duration.ofSeconds(3))
                //.useSsl()
                //.withDefaultHeaders(defaultHeaders)
                //.withBasicAuth(username, password)
                // ... other options
                .build();
        RestHighLevelClient client = RestClients.create(configuration).rest();
        return client;
    }
}
