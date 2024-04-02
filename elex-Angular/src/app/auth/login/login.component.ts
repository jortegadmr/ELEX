import { Component } from '@angular/core';
import { FormBuilder, FormControl, ReactiveFormsModule, FormGroup, Validators } from '@angular/forms';
import { RouterLink, RouterOutlet, Router } from '@angular/router';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-login',
  standalone: true,

  imports: [
    ReactiveFormsModule,
    RouterLink,
    RouterOutlet,
    CommonModule
  ],

  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})

export class LoginComponent {

  ngOnInit(): void {}
  
  loginForm = this.formBuilder.group({
    username: ['', Validators.required],
    password: ['', Validators.required]
  });
  constructor(private formBuilder: FormBuilder, private router: Router) {}

  get username(){
    return this.loginForm.get('username');
  }
  get password(){
    return this.loginForm.get('password');
  }
  login(){
    if (this.loginForm.valid) {
      console.log(this.loginForm.value);
      this.router.navigate(['inicio']);
      this.loginForm.reset();
    }
    else {
      this.loginForm.markAllAsTouched();
      alert('Usuario o contraseña incorrectos');
    }
  }
}
