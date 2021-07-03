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

    public Double getCurrency(String cur_name, String start_search_date, String end_search_date){
        String fooResourceUrl = String.format("http://api.nbp.pl/api/exchangerates/rates/a/%s/%s/%s/?format=json", cur_name, start_search_date, end_search_date);
        Root temp_currency = restTemplate.getForEntity(fooResourceUrl, Root.class).getBody();
        int days = temp_currency.getRates().size();
        List<Double> currency_values = new ArrayList<Double>();
        double sum_currency = 0;

        for(int i=0; i<days; i++){
            currency_values.add(temp_currency.getRates().get(i).getMid());
            sum_currency += currency_values.get(i);
        }

        double avg_currency = sum_currency/days;

        LocalDate date_start_search_date = LocalDate.parse(start_search_date);
        LocalDate date_end_search_date = LocalDate.parse(end_search_date);

        Currency tempCurrency = new Currency(cur_name, date_start_search_date, date_end_search_date, avg_currency);
        curRepository.save(tempCurrency);

        return avg_currency;

    }

    public List<Currency> findAll(){
        return curRepository.findAll();
    }
}
