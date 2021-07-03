package pjwstk.kaczowka.jazs21790nbp.currency.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pjwstk.kaczowka.jazs21790nbp.currency.service.CurrencyService;

@RestController
@RequestMapping("")
public class CurrencyRestController {

    private final CurrencyService currencyService;

    public CurrencyRestController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

//    @GetMapping("/temp/{cur_name}")
//    public ResponseEntity<String> getCurrency(@PathVariable String cur_name,
//                                              @RequestParam LocalDate start_search_date,
//                                              @RequestParam LocalDate end_search_date){
//        return ResponseEntity.ok(currencyService.getCurrency(cur_name, start_search_date, end_search_date));
//    }

    @GetMapping("/temp/{cur_name}")
    public ResponseEntity<Double> getCurrency(@PathVariable String cur_name){
        return ResponseEntity.ok(currencyService.getCurrency(cur_name));
    }
}
