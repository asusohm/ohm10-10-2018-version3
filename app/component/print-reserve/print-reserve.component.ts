import { Component, OnInit } from '@angular/core';
import { QueueController } from 'src/app/service/controller/queue.controller/queue-controller';
import { ReservationComponent } from 'src/app/component/reservation/reservation.component';

@Component({
  selector: 'app-print-reserve',
  templateUrl: './print-reserve.component.html',
  styleUrls: ['./print-reserve.component.css']

})
export class PrintReserveComponent implements OnInit {
  dateAppointmentShow:string;
  dateOutShow:string;
  serviceCenShow:string;

  constructor(
    private queueController:QueueController
    ) {
      
    }
    

  ngOnInit() {
    this.getQueue();
    this.getServiceCen();
  }
  private getQueue(){
    this.queueController.getQueue(ReservationComponent.getQueueID()).subscribe(data=>{
      this.dateAppointmentShow = data.dateAppointment;
      this.dateOutShow = data.date;  
      console.log("print success");
    },error=>{
      console.log("print error");
    });
  }

  private getServiceCen(){
    
      
  }

}

