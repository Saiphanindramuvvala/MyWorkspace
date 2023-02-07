# #stage 1
# # FROM node:latest as node
# # WORKDIR /app
# # COPY . .
# # RUN npm install
# # RUN npm run build --prod
# #stage 2
# FROM nginx:alpine
# COPY /dist/booking-facility-ui /usr/share/nginx/html

# # # Stage 1
# # FROM node:10-alpine as build-step
# # RUN mkdir -p /app
# # WORKDIR /app
# # COPY package.json /app
# # RUN npm install
# # COPY . /app
# # RUN npm run build --prod

# # # Stage 2
# # FROM nginx:1.17.1-alpine
# # COPY --from=build-step /app/docs /usr/share/nginx/html


# #stage 1
# FROM node:latest as node
# WORKDIR /app
# COPY . .
# RUN npm install
# RUN npm run build --prod
# #stage 2
# FROM nginx:alpine
# COPY --from=node /app/dist/booking-facility-ui /usr/share/nginx/html


# FROM node:latest AS builder
# COPY package.json package-lock.json ./
# # RUN  npm ci && mkdir /booking-facility-ui && mv ./node_modules ./booking-facility-ui
# WORKDIR /booking-facility-ui
# COPY . .
# RUN npm install
# RUN npm run build --prod
# FROM nginx:alpine
# RUN rm -rf /usr/share/nginx/html/*
# COPY --from=builder /booking-facility-ui/dist/booking-facility-ui/ /usr/share/nginx/html
# CMD ["nginx", "-g", "daemon off;"]

FROM node:latest AS builder
COPY package.json package-lock.json ./
RUN  npm ci && mkdir /booking-facility-ui && mv ./node_modules ./booking-facility-ui
WORKDIR /booking-facility-ui
COPY . .
RUN npm install
RUN npm run build --prod
FROM nginx:alpine
COPY nginx/default.conf /etc/nginx/conf.d/
RUN rm -rf /usr/share/nginx/html/*
COPY --from=builder /booking-facility-ui/dist/booking-facility-ui/ /usr/share/nginx/html
CMD ["nginx", "-g", "daemon off;"]