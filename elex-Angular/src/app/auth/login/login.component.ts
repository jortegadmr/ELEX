import { Component } from '@angular/core';
import { FormBuilder, FormControl, ReactiveFormsModule, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,

  imports: [
    ReactiveFormsModule
  ],

  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  loginForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
  });
}
