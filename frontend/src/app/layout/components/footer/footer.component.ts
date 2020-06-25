import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {
  activedIndex = 1
  constructor( 
    private route: Router
    ) { 
    
  }

  ngOnInit(): void {
  }

  onSelecteFooterIcon(index){
    this.activedIndex =  index
  }

  onSelecteFooterIcon4(){
    this.route.navigate(['/home/user']);
    }
  
    onSelecteFooterIcon2(){
    this.route.navigate(['/home/family/1']);
    }

      
    onSelecteFooterIcon3(){
      this.route.navigate(['/home/sale']);
      }


  

}
