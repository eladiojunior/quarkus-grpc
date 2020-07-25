# Quarkus e gRPC
 
Exemplo de projeto simple para estudar sobre o framework Quarkus utilizando o gRPC.

gRPC [Google Remote Call Procedures] é um framework desenvolvido pela Google de código aberto (https://grpc.io/docs/what-is-grpc/introduction/) e alto desempenho quer pode ser executado em qualquer ambiente. Utilizado na computação distribuída pode conectar dispositivos, aplicativos móveis e navegadores a serviços de back-end.

![Exemplo](./assets/imgs/gRPC.svg "Visão do gRPC")

## Para esse projeto utilizei as extenções do Quarkus (1.5.1-Final):

- quarkus-grpc
- quarkus-resteasy
- quarkus-resteasy-jsonb
- quarkus-resteasy-mutiny

## Para rodar o exemplo em modo _dev_ use:

Utilize o maven para rodar a aplicação de exemplo:
```
./mvn quarkus:dev
```