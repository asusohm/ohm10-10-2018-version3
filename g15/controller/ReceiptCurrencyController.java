package sut.sa.g15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sut.sa.g15.entity.ReceiptCurrency;
import sut.sa.g15.repository.ReceiptCurrencyRepository;


@RestController
@CrossOrigin(origins =  "http://localhost:4200")
public class ReceiptCurrencyController {
    @Autowired
    private ReceiptCurrencyRepository receiptCurrencyRepository;

    @PostMapping(path = "/receiptcurrency",produces = MediaType.APPLICATION_JSON_VALUE)
    public ReceiptCurrency receiptCurrency(@RequestBody ReceiptCurrency receiptCurrency) { return receiptCurrencyRepository.save(receiptCurrency);}
    @GetMapping(path = "/receiptcurrency/{rcID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReceiptCurrency getOneReceiptCurrency (@PathVariable Long rcID){
        return receiptCurrencyRepository.findById(rcID).get();
    }
}