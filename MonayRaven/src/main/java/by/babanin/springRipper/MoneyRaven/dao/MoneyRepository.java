package by.babanin.springRipper.MoneyRaven.dao;

import by.babanin.springRipper.MoneyRaven.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyRepository extends JpaRepository<Bank, String> {
}
