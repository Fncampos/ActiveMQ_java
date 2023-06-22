
# Tecnologias: Java, ActiveMQ, API Rest(spring boot) e Banco H2
# Projeto: Classificados de veículo em Java com Spring Boot, usando Filas com o ActiveMQ, integração com DB h2 e criação de API REST para compartilhamento de dados.

![Imagem esquema lógico](desenho_esquema.png) 

O projeto está dividio em 2:
* Fila_ActiveMq_Veiculos_v3.
* apiRestSitemas-main.

## Objetivo de Fila_ActiveMq_Veiculos_v3.1 : 
1. Enviar dados de um veículo via console para uma fila ActiveMQ.
2. Receber dados através de um consumer 
3. Guardar informações em uma tabela chamada VEICULO no DB H2.

## Objetivo de apiRestSitemas-main.: 
1. Enviar dados de um veículo via Post para uma fila ActiveMQ, usando uma API REST.
2. Os dados são retirados da fila e armazenados em uma tabela chamada VEICULO no DB H2.
4. Através uma page WEB os dados dos veículos cadastrados no Banco podem ser visalizados.

## Funcionamento:

## Execução:
1. Para executar corretamente, você precisa ter o Banco H2 e o middleware ActiveMQ já baixados.
Links para download: [ActiveMQ](https://activemq.apache.org/components/classic/download/) e [BD H2](https://www.h2database.com/html/main.html)
2. Execute o ActiveMQ
3. Abra os projetos Fila_ActiveMq_Veiculos_v3 e apiRestSitemas-main na IDE de sua preferência. Nosso projeto foi feito Netbeans.
4. Agora Execute o "ProducerFila.java" e popule a tabela
5. verfique o status das mensagens via página web, no endereço localhost:8161. Login:Admin e Senha:Admin 
6. Execute o lado Consumer
7. E por fim faça o acesso as informações do banco via API rest, usando Postman ou curl
OBS:






### Sobre os autores
**[Israel Costa](https://github.com/israel1608)** e **[Flávia Campos](https://github.com/Fncampos)**

&nbsp;

**Este projeto é parte de uma atividade acadêmica do Curso análise e Desenvolvimentode sistemas - 3º semestre - matéria Sistemas distribuidos, ministrada pelo [Profº Cláudio Martins]()**






