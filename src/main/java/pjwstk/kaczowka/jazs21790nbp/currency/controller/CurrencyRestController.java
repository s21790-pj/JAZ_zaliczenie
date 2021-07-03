package pjwstk.kaczowka.jazs21790nbp.currency.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pjwstk.kaczowka.jazs21790nbp.currency.model.Currency;
import pjwstk.kaczowka.jazs21790nbp.currency.service.CurrencyService;

import java.util.List;

@RestController
@RequestMapping("")
public class CurrencyRestController {

    private final CurrencyService currencyService;

    public CurrencyRestController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/currency/{cur_name}")
    public ResponseEntity<Double> getCurrency(@PathVariable String cur_name,
                                              @RequestParam String start_search_date,
                                              @RequestParam String end_search_date){
        return ResponseEntity.ok(currencyService.getCurrency(cur_name, start_search_date, end_search_date));
    }

    @GetMapping("/currency")
    public ResponseEntity<List<Currency>> findAllCurrency() {
        return ResponseEntity.ok(currencyService.findAll());
    }

}

