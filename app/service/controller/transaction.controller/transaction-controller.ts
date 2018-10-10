import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class TransactionController {

    constructor(private httpClient:HttpClient){

    }
    public getTransactionBySeviceCenterID(serviceCenterID:number):Observable<any>{
        return this.httpClient.get('//localhost:8080/transaction-by-serviceID/'+serviceCenterID);
    }
    public putTransaction(id:number,deposit:number,withdraw:number):Observable<any>{
        return this.httpClient.put('//localhost:8080/transaction/'+id,{
            "transactionID": id,
            "transactionDate": "2018-10-08T03:23:09.316+0000",
            "deposit": {
               "depositAmount": deposit
            },
            "withdraw": {
               "withdrawAmount": withdraw
            },
            "currency": {
               
            },
            "staff": {
               
            },
            "serviceCenter": {
             
            },
            "balance": {
              
            }
        })
    }
    public getCurrencys():Observable<any>{
      
        return this.httpClient.get('//localhost:8080/currency');
        
      }
    public postBalance(balanceAmount:number,serviceCenterID:number,currencyCode:string):Observable<any>{
        return this.httpClient.post('//localhost:8080/balance',{
                "balanceID": 0,
                "balanceAmount": balanceAmount,
                "serviceCenter": {
                    "serviceCenID": serviceCenterID
                },
                 "currency": {
                     "currencyCode": currencyCode
                }
        });
    }
}
