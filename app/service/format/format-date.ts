import { Injectable } from "@angular/core";

@Injectable()
export class FormatDate {
    constructor(){
        
    }
    public formatDate(dateInput): string {
        let dateStr = dateInput + ""
        var formatstr = dateStr.split(" ", 4);
        var mouth = formatstr[1];
        console.log(formatstr + mouth);
        switch (mouth) {
          case 'Jan': {
            mouth = "01";
            break;
          }
          case 'Feb': {
            mouth = "02";
            break;
          }
          case 'Mar': {
            mouth = "03";
            break;
          }
          case 'Apr': {
            mouth = "04";
            break;
          }
          case 'May': {
            mouth = "05";
            break;
          }
          case 'Jun': {
            mouth = "06";
            break;
          }
          case 'Jul': {
            mouth = "07";
            break;
          }
          case 'Aug': {
            mouth = "08";
            break;
          }
          case 'Sep': {
            mouth = "09";
            break;
          }
          case 'Oct': {
            mouth = "10";
            break;
          }
          case 'Nov': {
            mouth = "11";
            break;
          }
          case 'Dec': {
            mouth = "12";
            break;
          }
    
          default: {
    
            break;
          }
        }
        console.log("Data Format : " + formatstr[3] + "-" + mouth + "-" + formatstr[2]);
        return formatstr[3] + "-" + mouth + "-" + formatstr[2];
      }
}
