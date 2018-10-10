import { Component, OnInit } from '@angular/core';
import { TransactionController } from 'src/app/service/controller/transaction.controller/transaction-controller';

import { Router } from '@angular/router';
import { Authentication } from 'src/app/service/authentication/authentication';

@Component({
  selector: 'app-financial',
  templateUrl: './financial.component.html',
  styleUrls: ['./financial.component.css']
})
export class FinancialComponent implements OnInit {
    currencySelect:string;
    employeeName:string;
    position:string;
    serviceCenterName:string;
    expansions:Array<any>;
    serviceID:any ;
    currencys:Array<any>;
    balanceInput:number;
    transactionSelects:Array<any> = ['Withdraw','Deposit'];
   constructor(private controller:TransactionController,private router:Router ) {
   if (Authentication.isAuthentication() == false && !(Authentication.getPosition() == "TM")) {
      this.router.navigate(['login-admin']);
    } else {
      this.router.navigate(['transaction']);
    }
    
  }
  
  ngOnInit() {
    this.getDetail();
    this.getTransactionToList();
    this.getCurrencyToList();
  }

  private getTransactionToList(){
    this.controller.getTransactionBySeviceCenterID(this.serviceID).subscribe(data =>{
      this.expansions = data;
      console.log(data);
    },error=>{
      console.log(error);
    })
  }
  getCurrencyToList(){
    this.controller.getCurrencys().subscribe(data =>{
      this.currencys = data;
    })
  }
  getDetail(){
    this.employeeName = Authentication.getNameAdmin();
    this.position = Authentication.getPosition();
    this.serviceCenterName = Authentication.getServiceCenterName();
    this.serviceID = Authentication.getServiceCenterID();
    console.log(this.employeeName,this.position,this.serviceCenterName);
  }
  putBalance(){
    
  }
 

  addCurrency(){
    let balanceID:number;
    this.controller.postBalance(this.balanceInput,Authentication.getServiceCenterID(),this.currencySelect).subscribe(dataBalance =>{
      balanceID = dataBalance.balanceID
      console.log("Balance :",balanceID);
    })
  }

}


