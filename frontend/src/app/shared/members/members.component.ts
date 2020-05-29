import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-members',
  templateUrl: './members.component.html',
  styleUrls: ['./members.component.scss']
})
export class MembersComponent implements OnInit {

  @Input()
  person:any;

  data = [1,2,3,4,5,6,7]
  constructor() { }

  ngOnInit(): void {
  }

}
