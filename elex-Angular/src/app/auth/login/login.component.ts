import { Component } from '@angular/core';
import { FormBuilder, FormControl, ReactiveFormsModule, FormGroup, Validators } from '@angular/forms';

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
  /* loginForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
  }); */
  loginForm = this.formBuilder.group({
    username: ['', Validators.required],
    password: ['', Validators.required]
  });
  constructor(private formBuilder: FormBuilder) {}

  login(){
    if (this.loginForm.valid) {
      console.log(this.loginForm.value);
    }
    else {
      alert('Error con los datos');
    }
  }
}
