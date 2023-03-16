package com.tintin.tinapiclientsdk;

import com.tintin.tinapiclientsdk.client.TinapiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("tinapi.client")
@ComponentScan
public class TinapiclientConfig {
    private String accessKey;
    private String secretkey;

    @Bean
    public TinapiClient tinapiClient(){
        return new TinapiClient(accessKey, secretkey);
    }
}