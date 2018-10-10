import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';


import { Injectable } from '@angular/core';

@Injectable()
export class CurrencyRateController {
    private serverUrl:string='http://localhost:8080/';
    private  currencys:Array<any>;
     Administrator:Observable<any>;
    constructor(private httpClient:HttpClient) { }
  
    public getServerUrl():string{
      return this.serverUrl;
    }
  
   
    
    public getAdministratorFindByUsername(username:string):Observable<any>{
      
      return this.httpClient.get('//localhost:8080/staff/'+username);
  
    
    }
    public getCurrencys():Observable<any>{
      
      return this.httpClient.get('//localhost:8080/currency');
      
    }
    public deleteExchangeRate(id:string){
      return this.httpClient.delete('//localhost:8080/exchange-rate/'+id);
    }
    public putExchangeRate(id:string,buyPriceInput:number,sellPriceInput:number,date:string):Observable<any>{
      return this.httpClient.put('//localhost:8080/exchange-rate/'+id,{
        "bankNotesSelling":sellPriceInput,
        "bankNotesBuying":buyPriceInput,
        "date":date
      });
    }
    public getExchangeRatesLast():Observable<any>{
      return this.httpClient.get('//localhost:8080/exchange-rate-last');
    }
    public getExchangeRate(id:string):Observable<any>{
      return this.httpClient.get('//localhost:8080/exchange-rate/' + id);
    }
    public newCurrencyRate(buyPriceInput:number,sellPriceInput:number,date:string,currencyCode:string,personalUser:string):Observable<any>{
      return this.httpClient.post('//localhost:8080/exchange-rate/'+currencyCode+'/'+personalUser
      ,{
        "bankNotesSelling":sellPriceInput,
        "bankNotesBuying":buyPriceInput,
        "date":date
      });  
      
    }
   
}
