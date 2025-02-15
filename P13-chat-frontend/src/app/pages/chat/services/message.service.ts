

import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";


@Injectable({
  providedIn: 'root'
})

export class MessageService {

  private pathService = '/api/messages'; // Remplacer par l'URL http://localhost:3555/messages
  public constructor(private http: HttpClient) {
  }


  // Methode pour recevoir les messages
  public getMessages() {
    return this.http.get<any>(`${this.pathService}`);

  }

}
