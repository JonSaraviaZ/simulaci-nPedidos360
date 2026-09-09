import { Component } from '@angular/core';
import { signInWithRedirect, signOut, fetchAuthSession, getCurrentUser } from 'aws-amplify/auth';

@Component({
  selector: 'app-root',
  imports : [],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})

export class App {

  usuario = '';
  token = '';
  autenticado = false;

  async login () {
    await signInWithRedirect();
  }

  async logout () {
    await signOut();
  }

  //lógica del inicio de sesión
  async verSesion(){
    try{

      const user = await getCurrentUser();

      const session = await fetchAuthSession();

      this.usuario = user.username;
      this.token = session.tokens?.accessToken?.toString()??'';
      this.autenticado = true;
      console.log("Usuario:", user);
      console.log("Access Token:", session.tokens?.accessToken?.toString());

    } catch (Error) {
      console.log("Error al obtener la sesión:", Error);
      this.autenticado = false;
    }
  }
}