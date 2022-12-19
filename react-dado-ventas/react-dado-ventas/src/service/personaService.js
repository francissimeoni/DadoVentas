import axios from 'axios';


export class personaService {
    baseURL = "http://localhost:8080"
    pruebaController() {
        return axios.get(this.baseURL + "/pruebaController").then(res => { 
            
            console.log(res);
        
        });
    }
}
