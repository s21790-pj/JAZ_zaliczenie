package pjwstk.kaczowka.jazs21790nbp.currency.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pjwstk.kaczowka.jazs21790nbp.currency.model.Currency;
import pjwstk.kaczowka.jazs21790nbp.currency.model.Root;
import pjwstk.kaczowka.jazs21790nbp.currency.repository.CurRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class CurrencyService {

    private final RestTemplate restTemplate;
    private final CurRepository curRepository;

    public CurrencyService(RestTemplate restTemplate, CurRepository curRepository) {
        this.restTemplate = restTemplate;
        this.curRepository = curRepository;
    }

    public Currency save(String cur_name, LocalDate start_search_date, LocalDate end_search_date, double avg_currency){
        Currency theCurrency = new Currency(cur_name, start_search_date, end_search_date, avg_currency);
        return curRepository.save(theCurrency);
    }

    public String getCurrency(String cur_name, LocalDate start_search_date, LocalDate end_search_date){
//        String fooResourceUrl = String.format("http://api.nbp.pl/api/exchangerates/rates/a/%s/%tF/%tF/?format=json", cur_name, start_search_date, end_search_date);
        String fooResourceUrl = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/2021-02-01/2021-02-07/?format=json";
        Root temp_currency = restTemplate.getForEntity(fooResourceUrl, Root.class).getBody();
        double x = temp_currency.getRates().get(1).getMid();
        List<Double> currency_values = new ArrayList<Double>();
        double sum_currency = 0;

        return fooResourceUrl;

    }


}
