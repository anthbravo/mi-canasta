import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.scss'],
})
export class SelectComponent implements OnInit {
  listOfOption: Array<{ value: string; label: string }> = [];
  listOfSelectedValue = ["Administrador"];

  @Input()
  options:any;
  ngOnInit(): void {
    const children: string[] = ["Administrador", "Comprador"];

    this.listOfOption = children.map((item) => {
      return {
        value: item,
        label: item,
      };
    });
  }
}
