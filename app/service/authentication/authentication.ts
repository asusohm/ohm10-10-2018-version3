 
import { Injectable } from '@angular/core';

@Injectable()
export class Authentication {
    static authentication:boolean = false;
    static nameAdmin:string = '';
    static username:string;
    static position:string;
    static messageError:string;
    static serviceCenterID:number;
    static serviceCenterName:string;
    constructor() { }
    public static setMessageError(messageError:string){
      this.messageError = messageError;
    }
    public static setAuthentication( authentication:boolean):void{
      this.authentication = authentication;
    }
    public static setNameAdmin(nameAdmin:string):void{
      this.nameAdmin = nameAdmin;
      console.log("Login Name : " + this.nameAdmin)
    }
    public static getNameAdmin():string{
      return this.nameAdmin;
    }
    public static getUsername():string{
      return this.username;
    }
    public static setUsername(username:string){
       this.username = username;
    }
    public static getMessageError():string{
      return this.messageError;
    }
    public static isAuthentication():boolean {
      return this.authentication;
    }
    public static getPosition():string{
      return this.position;
    }
    public static setPosition(position:string):void{
      this.position = position;
    }
    public static setServiceCenterID(id:number):void{
      this.serviceCenterID = id;
    }
    public static getServiceCenterID():number{
      return this.serviceCenterID;
    }
    public static setEmployeeData(data){
      this.nameAdmin = data.personalName;
      this.username = data.personalUser;
      this.position = data.position.positionSymbol;
      this.serviceCenterID = data.serviceCenter.serviceCenID;
      this.serviceCenterName = data.serviceCenter.serviceCenName;

      console.log("Employee Data : ",this.nameAdmin,this.username,this.position,this.serviceCenterID, this.serviceCenterName);
    }
    public static getServiceCenterName():string{
      return this.serviceCenterName;
    }
    
    public static logout():void{
      this.nameAdmin = '';
      this.username = '';
      this.position = '';
      this.messageError = '';
      this.setAuthentication(false);
    }
}
