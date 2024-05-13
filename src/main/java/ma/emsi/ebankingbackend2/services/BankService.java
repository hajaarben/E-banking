package ma.emsi.ebankingbackend2.services;

import ma.emsi.ebankingbackend2.entities.BankAccount;
import ma.emsi.ebankingbackend2.entities.CurrentAccount;
import ma.emsi.ebankingbackend2.entities.SavingAccount;
import ma.emsi.ebankingbackend2.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankService {
        @Autowired
        private BankAccountRepository bankAccountRepository;
        public void consulter(){
        BankAccount bankAccount=
                bankAccountRepository.findById("0a5cc5b0-b1cd-4eef-8700-8a11fc2a0c14").orElse(null);
        if(bankAccount!=null) {
            System.out.println("***************");
            System.out.println(bankAccount);
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCreatedAt());
            System.out.println(bankAccount.getCustomer().getName());
            System.out.println(bankAccount.getClass().getSimpleName());
            if (bankAccount instanceof CurrentAccount) {
                System.out.println("Over Draft=>" + ((CurrentAccount) bankAccount).getOverDraft());
            } else if (bankAccount instanceof SavingAccount) {
                System.out.println("Rate=>" + ((SavingAccount) bankAccount).getInterestRate());
            }
            bankAccount.getAccountOperations().forEach(op -> {
                System.out.println(op.getType() + "\t" + op.getOperationDate() + "\t" + op.getAmount());
            });
        }
    }
}
