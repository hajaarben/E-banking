package ma.emsi.ebankingbackend2.repositories;

import ma.emsi.ebankingbackend2.entities.AccountOperation;
import ma.emsi.ebankingbackend2.entities.BankAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
    List<AccountOperation> findByBankAccountId (String accountId);
    Page<AccountOperation> findByBankAccountId (String accountId, Pageable pageable);
}
