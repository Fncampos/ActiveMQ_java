Esse README tem o objetivo explicar como rodar e executar esse projeto. 

# Titulo: Classificados de veículo em Java com Spring Boot, usando Filas com o ActiveMQ, integração com DB h2 e criação de API REST para compartilhamento de dados.

![Imagem esquema lógico](desenho_esquema.png) 

## Objetivo: 

1. Enviar dados de um veículo via Post para um produtor ActiveMQ, usando uma API REST.
2. Usando o Middleware ActiveMQ, o produtor recebe os dados do veículo e coloca em uma fila.
3. O Consumer ActiveMQ retira a mensagem da fila e envia para o Banco de dados H2.
4. Através de outra API rest e uma page WEB, disponibilizar os dados dos veículos cadastrados no Banco.

## Funcionamento:
O projeto está dividio em:
* Insert de dados.
* Read de dados.

## Execução:
Para executar corretamente, você precisa ter o Banco H2 e o middleware ActiveMQ já baixados e rodando.
Links para download: [ActiveMQ](https://activemq.apache.org/components/classic/download/) e [BD H2](https://www.h2database.com/html/main.html)

Agora Execute o lado prudutor e popule a tabela
Execute o lado Consumer
E por fim faça o acesso as informações do banco via API rest






### Sobre os autores
**[Israel Costa](https://github.com/israel1608)**
**[Flávia Campos](https://github.com/Fncampos)**
**Este projeto é parte de uma atividade acadêmica do Curso análise e Desenvolvimentode sistemas - 3º semestre - matéria Sistemas distribuidos, ministrada pelo [Profº Cláudio Martins]()**






