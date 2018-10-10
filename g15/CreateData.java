package sut.sa.g15;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import sut.sa.g15.entity.*;
import sut.sa.g15.repository.*;

import java.util.Date;

@Component
public class CreateData implements ApplicationRunner {
    private  Date date = new Date();
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ExchangeRateRepository exchangeRateRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private ServiceCenterRepository serviceCenterRepository;
    @Autowired
    private BalanceRepository balanceRepository;
    @Autowired
    private DepositRepository depositRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private WithdrawRepository withdrawRepository;
    @Autowired
    private MembersRepository membersRepository;
    @Autowired
    private QueueRepository  queueRepository;

    @Autowired
    private CurrencyTypeRepository currencyTypeRepository;
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private ReceiptCurrencyRepository receiptCurrencyRepository;

    // Position
    private Position updateRate = new Position("Update Currency Rate Manager", "CM");
    private Position updateTransaction = new Position("Update Transaction Manager", "TM");
    private Position updateReceipt = new Position("Update Personel Exchange", "PE");
    // Service Center
    private ServiceCenter testservice = new ServiceCenter("DewCenter", "DewAddress", "0441254787");
    // Staff
    private Staff s1 = new Staff("cm", "admin", "Sivarut Chuncharoen", updateRate,testservice);
    private Staff s2 = new Staff("tm", "admin", "Natthapon Ano", updateTransaction,testservice);
    private Staff s3 = new Staff("pe", "admin", "Monton Kanpoh", updateReceipt,testservice);

    // Create New Currency
    private Currency usd = new Currency("USD", "US Dollar");
    private Currency eur = new Currency("EUR", "Euro");
    private Currency jpy = new Currency("JPY", "Japanese Yen");
    private Currency krw = new Currency("KRW", "South Korean Won");
    private Currency gpb = new Currency("GBP", "British Pound");
    private Currency aud = new Currency("AUD", "Australian Dollar");
    private Currency chf = new Currency("CHF", "Swiss Franc");
    private Currency nzd = new Currency("NZD", "New Zealand Dollar");


    // Create New Country
    private Country USA = new Country("USA", "United State", usd);
    private Country GRC = new Country("GRC", "Greece", eur);
    private Country JPN = new Country("JPN", "Japan", jpy);
    private Country KOR = new Country("KOR", "South Korea", krw);
    private Country GBR = new Country("GBR", "United Kingdom", gpb);
    private Country AUS = new Country("AUS", "Australia", aud);
    private Country CHE = new Country("CHE", "Switzerland", chf);
    private Country NZL = new Country("NZL", "New Zealand", nzd);


    // Create New Exchange Rate
    private ExchangeRate er = new ExchangeRate(30.11, 30.22, date, usd, s1);



    private Withdraw withdraw = new Withdraw(500);
    private Withdraw withdrawZero = new Withdraw(0.0);
    private Deposit deposit = new Deposit(1000);
    private Deposit depositZero = new Deposit(0.0);
    private Balance balance = new Balance(500.0, testservice, usd);

    private Transaction transaction = new Transaction(date, deposit, withdraw, usd, s2, testservice, balance);


    // prai
    private CurrencyType base = new CurrencyType("Base");
    private CurrencyType dist = new CurrencyType("Dist");
    private Members members = new Members("mem","mem");
    private Queue queue = new Queue(date,date,50.0,members,testservice);
    private QueueCurrency queueCurrency = new QueueCurrency();

    //Create New Receipt
    private Receipt receipt = new Receipt(date,members,s3,testservice);
    private ReceiptCurrency receiptCurrency = new ReceiptCurrency(10000.0,usd,receipt,base);

    @Override
    public void run(ApplicationArguments args) {
        createPosition();
        createStaff();



        currencyTypeRepository.save(base);
        currencyTypeRepository.save(dist);
        membersRepository.save(members);
     //   queueRepository.save(queue);
     //   queueCurrency.setQueue(queue);
       // queueCurrency.setCurrency(usd);
//        queueCurrency.setCurrencyType(base);
//        queue.getQueueCurrency().add(queueCurrency);
        createCurrency();
        createCountry();
        createExchangeRate();
        createTransaction();
//        queueRepository.save(queue);
        receiptRepository.save(receipt);
        receiptCurrencyRepository.save(receiptCurrency);
    }


    private void createPosition() {
        positionRepository.save(updateRate);
        positionRepository.save(updateTransaction);
        positionRepository.save(updateReceipt);
    }

    private void createStaff() {
        serviceCenterRepository.save(testservice);
        staffRepository.save(s1);
        staffRepository.save(s2);
        staffRepository.save(s3);
    }

    private void createCurrency() {
        currencyRepository.save(usd);
        currencyRepository.save(eur);
        currencyRepository.save(jpy);
        currencyRepository.save(krw);
        currencyRepository.save(gpb);
        currencyRepository.save(aud);
        currencyRepository.save(chf);
        currencyRepository.save(nzd);
    }

    private void createCountry() {
        countryRepository.save(USA);
        countryRepository.save(GRC);
        countryRepository.save(JPN);
        countryRepository.save(KOR);
        countryRepository.save(GBR);
        countryRepository.save(AUS);
        countryRepository.save(CHE);
        countryRepository.save(NZL);
    }

    private void createExchangeRate() {
        exchangeRateRepository.save(er);
    }

    private void createTransaction() {

        withdrawRepository.save(withdrawZero);
        depositRepository.save(depositZero);
        withdrawRepository.save(withdraw);
        depositRepository.save(deposit);
        balanceRepository.save(balance);
        transactionRepository.save(transaction);
    }
}
