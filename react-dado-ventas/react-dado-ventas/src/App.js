import logo from './logo.svg';
import React, { Component } from 'react';
import './App.css';
import { personaService } from './service/personaService';

export default class App extends Component {


  constructor() {

    super();
    this.state = {};
    this.personaService = new personaService();

  }

  componentDidMount() {

    this.personaService.pruebaController().then(data => {

      console.log(data);

    })

  }


  render() {
    return (


      <h1>hola mundo</h1>


    );

  }



}
