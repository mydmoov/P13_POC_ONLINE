import { Routes } from '@angular/router';

export const routes: Routes = [    

    {
        path: '',
        loadChildren: () => import('./pages/chat/chat.module').then(m => m.ChatModule)
    },
   
];
