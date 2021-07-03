package pjwstk.kaczowka.jazs21790nbp.currency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pjwstk.kaczowka.jazs21790nbp.currency.model.Currency;

public interface CurRepository extends JpaRepository<Currency, Long> {
}
