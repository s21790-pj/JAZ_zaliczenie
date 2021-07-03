package pjwstk.kaczowka.jazs21790nbp.currency.model;

import io.swagger.annotations.ApiModelProperty;
import pjwstk.kaczowka.jazs21790nbp.currency.configuration.CurrencyConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "id of currency")
    private Long id;

    @ApiModelProperty(notes = "Name of searching currency")
    private String cur_name;
    @ApiModelProperty(notes = "Start date for search")
    private LocalDate start_search_date;
    @ApiModelProperty(notes = "End date for search")
    private LocalDate end_search_date;
    @ApiModelProperty(notes = "The average exchange rate of the currency in a given range")
    private double avg_currency;
    @ApiModelProperty(notes = "Search date")
    private LocalDate search_date;
    @ApiModelProperty(notes = "Search time")
    private LocalTime search_time;

    public Currency() {
    }

    public Currency(String cur_name, LocalDate start_search_date, LocalDate end_search_date, double avg_currency) {
        this.cur_name = cur_name;
        this.start_search_date = start_search_date;
        this.end_search_date = end_search_date;
        this.avg_currency = avg_currency;
        this.search_date = CurrencyConfiguration.getDate();
        this.search_time = CurrencyConfiguration.getTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCur_name() {
        return cur_name;
    }

    public void setCur_name(String cur_name) {
        this.cur_name = cur_name;
    }

    public LocalDate getStart_search_date() {
        return start_search_date;
    }

    public void setStart_search_date(LocalDate start_search_date) {
        this.start_search_date = start_search_date;
    }

    public LocalDate getEnd_search_date() {
        return end_search_date;
    }

    public void setEnd_search_date(LocalDate end_search_date) {
        this.end_search_date = end_search_date;
    }

    public double getAvg_currency() {
        return avg_currency;
    }

    public void setAvg_currency(double avg_currency) {
        this.avg_currency = avg_currency;
    }

    public LocalDate getSearch_date() {
        return search_date;
    }

    public void setSearch_date(LocalDate search_date) {
        this.search_date = search_date;
    }

    public LocalTime getSearch_time() {
        return search_time;
    }

    public void setSearch_time(LocalTime search_time) {
        this.search_time = search_time;
    }
}
