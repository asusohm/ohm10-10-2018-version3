package sut.sa.g15.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sut.sa.g15.entity.Deposit;
import sut.sa.g15.entity.Transaction;
import sut.sa.g15.entity.Withdraw;
import sut.sa.g15.exception.BalanceNotFoundException;
import sut.sa.g15.exception.DepositNotFoundException;
import sut.sa.g15.exception.InsufficientfundsException;
import sut.sa.g15.exception.ServiceCenterNotFoundException;
import sut.sa.g15.repository.TransactionRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private DepositController depositController;
    @Autowired
    private BalanceController balanceController;
    @Autowired
    private WithdrawController withdrawController;


    @GetMapping("/transaction")
    public Collection<Transaction> getTreasury() {
        return transactionRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/transaction/{transactionone}")
    public Transaction getOneTreasury(@PathVariable Long transactionone) {
        return transactionRepository.findById(transactionone).get();

    }

    @PostMapping(path = "/transaction", produces = MediaType.APPLICATION_JSON_VALUE)
    public Transaction newTransaction(@RequestBody Transaction newTransaction) throws DepositNotFoundException {
        if (newTransaction.getBalance().getBalanceID() == null)
            throw new BalanceNotFoundException();
        if (newTransaction.getServiceCenter().getServiceCenID() == null)
            throw new ServiceCenterNotFoundException();
        System.out.println(newTransaction.getBalance().getBalanceID().longValue());
        Double oldBalance = balanceController.getBalanceById(newTransaction.getBalance().getBalanceID().longValue()).getBalanceAmount();
        Double depositAmount = newTransaction.getDeposit().getDepositAmount();
        Double withdrawAmount = newTransaction.getWithdraw().getWithdrawAmount();
        Double newBalance = oldBalance + depositAmount - withdrawAmount;

        System.out.println("Balance : " + oldBalance);
        System.out.println("Deposit : " + depositAmount);
        System.out.println("Withdraw : " + withdrawAmount);
        System.out.println("Up Balance : " + newBalance);
        if (newBalance >= 0.0) {

            if (depositController.getDepositByAmount(depositAmount) == null) {
                Deposit newDeposit = new Deposit(newTransaction.getDeposit().getDepositAmount());
                depositController.newDeposit(newDeposit);
                newTransaction.setDeposit(newDeposit);
            } else {
                newTransaction.setDeposit(depositController.getDepositByAmount(depositAmount));
            }
            if (withdrawController.getWithDrawByAmount(withdrawAmount) == null) {
                Withdraw newWithdraw = new Withdraw(newTransaction.getWithdraw().getWithdrawAmount());
                withdrawController.newWithdraw(newWithdraw);
                newTransaction.setWithdraw(newWithdraw);
            } else {
                newTransaction.setWithdraw(withdrawController.getWithDrawByAmount(withdrawAmount));
            }

            balanceController.replaceBalance(null, newTransaction.getBalance().getBalanceID(), newBalance);
            return transactionRepository.save(newTransaction);
        } else {
            throw new InsufficientfundsException();
        }

    }


    /*

    @PutMapping(path = "exchange-rate/{id}")
    public ExchangeRate putExchangeRate(@RequestBody ExchangeRate newExchangeRate, @PathVariable Long id) {
        return exchangeRateRepository.findById(id).map(exchangeRate -> {
                    exchangeRate.setBankNotesBuying(newExchangeRate.getBankNotesBuying());
                    exchangeRate.setBankNotesSelling(newExchangeRate.getBankNotesSelling());
                    exchangeRate.setDate(newExchangeRate.getDate());
                    return exchangeRateRepository.save(exchangeRate);
                }
        ).orElseGet(() -> {
            return exchangeRateRepository.save(newExchangeRate);
        });
    }
     */
    @PutMapping(path = "/transaction/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Transaction putTransaaction(@RequestBody Transaction newTransaction, @PathVariable Long id) {
        if (newTransaction.getWithdraw().getWithdrawAmount() > newTransaction.getBalance().getBalanceAmount())
            throw new InsufficientfundsException();

        Double oldBalance = balanceController.getBalanceById(newTransaction.getBalance().getBalanceID().longValue()).getBalanceAmount();
        Double depositAmount = newTransaction.getDeposit().getDepositAmount();
        Double withdrawAmount = newTransaction.getWithdraw().getWithdrawAmount();
        Double newBalance = oldBalance + depositAmount - withdrawAmount;



        return transactionRepository.findById(id).map(transaction -> {
            transaction.setWithdraw(newTransaction.getWithdraw());
            transaction.setDeposit(newTransaction.getDeposit());
            Double balance = newTransaction.getDeposit().getDepositAmount() - newTransaction.getWithdraw().getWithdrawAmount() + newTransaction.getBalance().getBalanceAmount();
            balanceController.replaceBalance(null,newTransaction.getBalance().getBalanceID(),balance);

            if (newBalance >= 0.0) {

                if (depositController.getDepositByAmount(depositAmount) == null) {
                    Deposit newDeposit = new Deposit(newTransaction.getDeposit().getDepositAmount());
                    depositController.newDeposit(newDeposit);
                    transaction.setDeposit(newDeposit);
                } else {
                    transaction.setDeposit(depositController.getDepositByAmount(depositAmount));
                }
                if (withdrawController.getWithDrawByAmount(withdrawAmount) == null) {
                    Withdraw newWithdraw = new Withdraw(newTransaction.getWithdraw().getWithdrawAmount());
                    withdrawController.newWithdraw(newWithdraw);
                    transaction.setWithdraw(newWithdraw);
                } else {
                    transaction.setWithdraw(withdrawController.getWithDrawByAmount(withdrawAmount));
                }

                balanceController.replaceBalance(null, transaction.getBalance().getBalanceID(), newBalance);

            }

            return transactionRepository.save(transaction);
        }).orElseGet(() -> {
            return transactionRepository.save(newTransaction);
        });

    }

    @GetMapping(path = "/transaction-by-serviceID/{serviceID}")
    public Collection<Transaction> getTransactionByServiceCenterID(@PathVariable Long serviceID) {
        return transactionRepository.findByServiceCenterServiceCenID(serviceID).stream().collect(Collectors.toList());
    }


}
