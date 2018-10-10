import { Component, OnInit } from '@angular/core';
import { QueueController } from 'src/app/service/controller/queue.controller/queue-controller';

import { Router } from '@angular/router';
import { FormatDate } from 'src/app/service/format/format-date';


@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {
  static getServiceCen(): any {
    throw new Error("Method not implemented.");
  }
  private static queueId;
  dateAppointment: string;
  private baseAmount: number;
  private baseCurrency: any;
  private distCurrency: string;
  serviceCenter: string;

  private currencyBaseList: Array<any>;
  private currencyDistList: Array<any>;
  private serviceList: Array<any>;

  constructor(
    private queueController: QueueController, 
    private router: Router,
    private formatDateTime: FormatDate) { }


  ngOnInit() {
    this.getServiceCenters();
    this.getCurrencyBaseToList();
    this.getCurrencyDistToList();
  }

  getCurrencyBaseToList(): void {
    this.queueController.getCurrencyBaseList().subscribe(data => {
      this.currencyBaseList = data;
      
      
    });
  }
  test(data):void{
    console.log(data,this.formatDateTime.formatDate(this.dateAppointment));
  }

  getCurrencyDistToList(): void{
    this.queueController.getCurrencyBaseList().subscribe(data => {
      this.currencyDistList = data;
     // delete[this.currencyDistList.indexOf(this.baseCurrency)]
    });
  }
  getServiceCenters(): void {
    this.queueController.getServiceCenterList().subscribe(data => {
      this.serviceList = data;
    });
  }
 
  getServiceSelect(): string {
    return this.serviceCenter;
  }

  public static getQueueID(): number {
    return this.queueId;
  }

  createReserve() {

    this.queueController.postQueueDetail(this.baseAmount, "this.baseCurrency", "this.distCurrency").subscribe(data => {
      console.log("detail " + data);
      this.queueController.postQueue("2018-09-23", "2018-10-29", "senprai", 3, data.qDetailID).subscribe(data2 => {
        console.log("queue " + data2);
        ReservationComponent.queueId = data2.queueID;
        this.router.navigate(['print']);
      }, error => {
        console.log("queue " + error);
      });
    }, error => {
      console.log(error);
    });


  }

}

