import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/core/service/home.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {
  activedIndex = 1
  role = "familia"
  constructor(private homeService:HomeService) { }

  ngOnInit(): void {
      this.homeService.roleUser.subscribe(item=>{
          this.role =  item.role
      })
  }

  onSelecteFooterIcon(index){
    this.activedIndex =  index
  }
  

}
