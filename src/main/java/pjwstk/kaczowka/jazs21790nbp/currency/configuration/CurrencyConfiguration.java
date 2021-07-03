package pjwstk.kaczowka.jazs21790nbp.currency.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;

@Configuration
public class CurrencyConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public static LocalDate getDate(){
        return java.time.LocalDate.now();
    }

    @Bean
    public static LocalTime getTime(){
        return java.time.LocalTime.now();
    }
}
