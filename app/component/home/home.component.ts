import { Component, OnInit } from '@angular/core';
import {  Router } from '@angular/router';
import { CurrencyRateController } from 'src/app/service/controller/currency.rate.controller/currency-rate-controller';
export interface Food {
  value: string;
  viewValue: string;
}
export interface PeriodicElement {
  currencyCode: string;
  currencyName: string;
  curSelect: number;
}


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  dataSource:Array<any>;
  currencys:Array<any>;
  constructor(private router: Router,private controller:CurrencyRateController) { 
    
  }
  
  ngOnInit() {
    this.getExchangeRatesLast();
    this.getCurrency();
  }
  displayedColumns: string[] = ['currencyCode', 'currencyName', 'curSelect'];
  private getExchangeRatesLast(){
    this.controller.getExchangeRatesLast().subscribe(data=>{
      console.log("Data " ,data);
      this.dataSource = data;    
    },error=>{
      console.log("Error : " ,error)
    });
  }
  getCurrency(): void {
    this.controller.getCurrencys().subscribe(data => {
      this.currencys = data;
      console.log(data);
    },error=>{
      console.log("Error : " ,error)
    });
  }
  

  skip(){
    this.router.navigate(['login-admin']);
  }
}
