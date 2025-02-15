FROM node:18 as build
WORKDIR /usr/local/app
# Copier uniquement les fichiers essentiels pour installer les dépendances
COPY package.json /usr/local/app/
RUN npm install

# Copier le reste du code source
COPY ./ /usr/local/app/
RUN npm run build

FROM nginx:latest
COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=build /usr/local/app/dist/p13-chat-frontend/browser /usr/share/nginx/html
EXPOSE 1212
