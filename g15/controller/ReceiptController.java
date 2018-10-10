package sut.sa.g15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sut.sa.g15.entity.Receipt;
import sut.sa.g15.repository.ReceiptRepository;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")
public class ReceiptController {
    @Autowired
    private ReceiptRepository receiptRepository;

    @PostMapping(path = "/receipt", produces = MediaType.APPLICATION_JSON_VALUE)
    public Receipt newReceipt(@RequestBody Receipt receipt) {
        return receiptRepository.save(receipt);
    }
    @GetMapping(path = "/receipt/{rID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Receipt getOneReceipt (@PathVariable Long rID){
        return receiptRepository.findById(rID).get();
    }
}
