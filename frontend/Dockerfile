FROM node:12-alpine

WORKDIR /majorproject-8-mon-17-30-5/frontend

COPY package.json ./
COPY package-lock.json ./

RUN npm install

COPY . .

CMD ["npm", "start"]