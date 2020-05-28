import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.scss'],
})
export class SelectComponent implements OnInit {
  listOfOption: Array<{ value: string; label: string }> = [];
  listOfSelectedValue = ['a10', 'c12'];

  @Input()
  options:any;
  ngOnInit(): void {
    const children: string[] = [];
    for (let i = 10; i < 10000; i++) {
      children.push(`${i.toString(36)}${i}`);
    }
    this.listOfOption = children.map((item) => {
      return {
        value: item,
        label: item,
      };
    });
  }
}
