import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/core/service/home.service';

@Component({
  selector: 'app-requests-sent',
  templateUrl: './requests-sent.component.html',
  styleUrls: ['./requests-sent.component.scss']
})
export class RequestsSentComponent implements OnInit {
  mock  = [{ familyName: "Familia82BDH" }]

  constructor(private homeService:HomeService) { }

  ngOnInit(): void {
    this.homeService.setStatus({isLoginView:false})
  }

}
