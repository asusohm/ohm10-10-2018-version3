import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";
import { Injectable } from "@angular/core";
@Injectable()
export class QueueController {
    constructor(private httpClient:HttpClient) { 
 
    }
   
    public getCurrencyBaseList():Observable<any> {
        return this.httpClient.get("//localhost:8080/currency");
      }
    
      public getServiceCenterList():Observable<any>{
        return this.httpClient.get("//localhost:8080/service-center");
      }
      public getCurrencys():Observable<any>{
      
        return this.httpClient.get('//localhost:8080/currency');
        
      }
    
      public postQueue(dateOutShow:string, dateAppointment:string, memberID:string, serviceCenID:number, qDetailID:number):Observable<any>{
        return this.httpClient.post("//localhost:8080/queue",{
          "queueID": 0,
          "dateAppointment": dateAppointment,
          "date": dateOutShow,
          "queueDetail": {
              "qDetailID": qDetailID 
          },
          "members": {
              "memUser": memberID
        
          },
          "serviceCenter": {
              "serviceCenID": serviceCenID
    
          }
        });
      }
    
      public postQueueDetail(baseAmount:number, baseCurrency:string, distCurrency:string ):Observable<any>{
        return this.httpClient.post("//localhost:8080/queue-detail",{
          "qDetailID": 0,
          "baseCurrency": "USA-TEST",
          "baseAmount": baseAmount,
          "distCurrency": "TEST Currency"
        });
      }
    
      public getQueue(queueID:number):Observable<any>{
        return this.httpClient.get("//localhost:8080/queue/"+queueID);
      }
}
