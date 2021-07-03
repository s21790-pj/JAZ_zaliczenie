package pjwstk.kaczowka.jazs21790nbp.currency.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pjwstk.kaczowka.jazs21790nbp.currency.service.CurrencyService;

@RestController
@RequestMapping("")
public class CurrencyRestController {

    private final CurrencyService currencyService;

    public CurrencyRestController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/temp/{cur_name}")
    public ResponseEntity<Double> getCurrency(@PathVariable String cur_name,
                                              @RequestParam String start_search_date,
                                              @RequestParam String end_search_date){
        return ResponseEntity.ok(currencyService.getCurrency(cur_name, start_search_date, end_search_date));
    }

}

// 3.460725
// 2012-02-21
// 2012-02-25