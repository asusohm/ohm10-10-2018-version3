import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MatSnackBar } from '@angular/material';
import { DatePipe } from '@angular/common';
import { Router } from '@angular/router';
import { Authentication } from 'src/app/service/authentication/authentication';
import { CurrencyRateController } from 'src/app/service/controller/currency.rate.controller/currency-rate-controller';
import {formatDate} from '@angular/common';

import { FormatDate } from 'src/app/service/format/format-date';


@Component({
  selector: 'app-update-currency',
  templateUrl: './update-currency.component.html',
  styleUrls: ['./update-currency.component.css']
})
export class UpdateCurrencyComponent implements OnInit {
 
  private editAndUpdate_btn:string = "New Exchange Rate";   // Set Label in Button Default "New Exchange Rate"
  private editID:string;                                    // Use for remember id of exchange rate when click edit
  private editStatus:boolean = false;                       // Use for remember update(false) or edit(true) status
  private checkedDateReal: boolean = false;                 // 
  private dateNow:string;                                   
  private currencySelect: any;
  private buyPriceInput: number;
  private sellPriceInput: number;
  private dateReal: string;
  private nameLogin: string
  private currencys: Array<any>;                             
  private expansions: Array<any>;
  constructor(private httpClient: HttpClient, private snackBar: MatSnackBar, private router: Router, private controller: CurrencyRateController, private datePipe: DatePipe,private formatDateTime:FormatDate) {
    if (Authentication.isAuthentication() == false && !(Authentication.getPosition() == "CM")) {
      this.router.navigate(['login-admin']);
    } else {
      this.router.navigate(['update-rate']);
    }

  }


  ngOnInit() {
    this.getCurrency();
    this.getExchangeRatesLastToList();
    this.nameLogin = Authentication.getNameAdmin();
    this.dateNow = formatDate(new Date(), 'yyyy-MM-dd', 'en');
  }

  editRate(id:any){
    this.editStatus = true;
    this.editAndUpdate_btn = "Edit";
    this.editID = id;
    this.controller.getExchangeRate(id+"").subscribe(data => {
      this.currencySelect = data.currency.currencyCode;
      this.buyPriceInput = data.bankNotesBuying;
      this.sellPriceInput = data.bankNotesSelling;
      this.dateReal = data.date;
      console.log("Edit ID " + data.currency.currencyCode,data);

    });
    console.log("Edit ID " + id);
  }

  getCurrency(): void {
    this.controller.getCurrencys().subscribe(data => {
      this.currencys = data;
      console.log(data);
    });
  }
  getExchangeRatesLastToList() {
    this.controller.getExchangeRatesLast().subscribe(data => {
      this.expansions = data;
      console.log(this.dateNow);
    },error =>{

    });
  }
  
  setDate(){
    if (this.checkedDateReal) {
      this.dateReal = this.datePipe.transform(Date.now(), "yyyy-MM-dd");
      console.log("Date Now : " + this.dateReal);
    } else {
      this.dateReal = this.formatDateTime.formatDate(this.dateReal);
      console.log("Date Select : " + this.dateReal);
    }
  }

  editAndupdateRate() {
    console.log("Creating Exchange Rate Process");
    console.log("Currency : " + this.currencySelect.currencyCode);  
    console.log("Buy/Sell Price : " + this.buyPriceInput+ '/' +this.sellPriceInput);  
    console.log("Date Create : " + this.dateReal);  
    // Call Controller Service : function newCurency()
    if(this.editStatus == true){
      this.controller.putExchangeRate(this.editID,this.buyPriceInput,this.sellPriceInput,this.dateReal).subscribe(
        data => {
          console.log("PUT Request is successful ", data);
          this.snackBar.open('Edit', "Success" ,{duration: 3000});
          this.getExchangeRatesLastToList();
          this.clear();
          this.editAndUpdate_btn = "New Exchange Rate";
         
      },
      error => {
          console.log("Error", error);
          this.snackBar.open('Edit', "Error" ,{duration: 3000});
      }
      );
    }else{
      console.log("UserName :",Authentication.getUsername());
      this.controller.newCurrencyRate(this.buyPriceInput, this.sellPriceInput, this.dateReal, this.currencySelect + "", Authentication.getUsername()).subscribe(
       
        data => {
          this.editStatus == false;
          console.log("POST Request is successful ", data);
          this.snackBar.open('New Exchange Rate Success' , this.currencySelect+"",{duration: 3000});
          this.getExchangeRatesLastToList();
          this.clear();
        },
        error => {
          this.snackBar.open('New Exchange Rate Fail', this.currencySelect+"",{duration: 3000});
          console.log("Error", error);
        }
      );
    }
    


  }
  deleteRate(id:any){
    this.controller.deleteExchangeRate(id+"").subscribe(data => {
      console.log("Delete Request is successful ", data);
      this.snackBar.open('Delete', " Success ",{duration: 3000});
      this.getExchangeRatesLastToList();
      this.clear();
    },
    error => {
      this.snackBar.open('Delete', " Error ",{duration: 3000});
      console.log("Delete Error", error);
    });
  }
  clear(){
    this.currencySelect = '';
      this.buyPriceInput = null;
      this.sellPriceInput = null;
      this.dateReal = '';
      this.checkedDateReal =false;
      this.editStatus = false;
  }

 
  logout() {
   if (Authentication.isAuthentication()) {
    Authentication.logout();
      this.router.navigate(['login-admin']);
    }
  }




}
