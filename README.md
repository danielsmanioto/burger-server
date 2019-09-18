# burger-server
Burger Sale - Server Side

Este repositório contém somente a aplicação server(back-end) 
para ter a aplicação rodando completamente é necessário subir a aplicação cliente(front-end) em paralelo conforme instruções. 

<b>Aplicação client</b>
https://github.com/danielsmanioto/burger-client

<b>Aplicação server</b> 
https://github.com/danielsmanioto/burger-server

<b>Aplicação de testes (funcionais) </b> 
https://github.com/danielsmanioto/burger-test

<b>Swagger - Documentação da API</b>
http://localhost:80/swagger-ui.html

<b>API rodando no Heroku</b>
https://dsmanioto-burger-server.herokuapp.com/

# Instruções de como executar com Docker
execute o arquivo build.sh (exemplo no linux-> ./build.sh) <br>
execute o arquivo run.sh <br>
Verificar se API está no ar -> http://localhost:80

Agora siga os passos na aplicação client

# Instruções de como executar sem Docker

<p>Subir aplicação</p>

`mvn clean install && mvn spring-boot:run`

<p>Executar os testes e verificar cobertura de testes</p>

`mvn clean test`

<p>Verificar cobertura de testes:</p>

./target/site/jacoco/index.html

# Justificativa design da aplicação
<p>
	<b>Clean code:</b>​ métodos intuitivos e sem comentários desnecessários;
</p>
<p>
	<b>SOLID:​</b> Usado os princípios de SOLID para mapeamento e implementação de todas as classes
	com objetivo de manter o sistema escalável, desacoplado.
</p>
<p>
	<b>MVC:</b>​ Organização em camadas para desacoplar as regras corretamente
	<p><b>Controller ou Resource:</b> Chamada da regra de negócio e disponibilização em Json para
	o externo;</p>
	<p><b>Service:</b> Regra de negócio;</p>
	<p><b>Repository ou DAO:</b> Regra e persistência com banco de dados ou qualquer que seja o
	tipo de persistência;</p>
	<p>Model: Java bean.</p>
</p>
<p>
	<b>TDD:</b>​ Uso de testes unitários automatizados para garantir a qualidade do código em pequenos
	blocos e prática em escrever o código antes da regra. Com objetivo final de reduzir o
	acoplamento e ter um sistema com alta coesão e escalável.
</p>
<p>
    <b>Padrão de projeto Builder:</b> Separar a logica de criação dos objetetos​
</p>
<p>
    <b>Padrão de projeto Strategy:</b> Para separar a regra de discontos 
</p>
<p>
	<b>Injeção de dependência e uso de interface:​</b> no service para garantir um contrato e
	obrigatoriedade de implementação das regras fundamentais de cada funcionalidade.
<p/>
<p> <b>API REST verbos:</b> ​Uso de padrões de API para mapeamento correto e intuitivo dos métodos
	expostos pela API.
	Organização do projeto: ​Organização dos pacotes do projeto com objetivo de facilitar o
	entendimento e auxiliar na evolução do sistema.
</p>

# Testes

<p> 
    <b>Teste Unitário:</b> Garantir cobertura de regra de negocio</b> 
</p>
<p> 
    <b>Teste de Integração:</b> Garantir que nossa API esteje sempre funcionando e integrando corretamente com outros sistemas.</b> 
</p>
<p> 
    <b>Teste Funcional:</b> Criado uma aplicação externa(conforme documentação) para realizar os testes funcionais de ponta a ponta.</b> 
</p>

<b>Tecnologias do back-end:</b>
<ul>
  <li>JDK 1.8+</li>
  <li>Maven</li>
  <li>Spring-Boot
</ul>

<b>Requisitos:</b>
<ul>
  <li>JDK 1.8</li>
  <li>Maven</li>
  <li>Ter um browser instalado na maquina
  <li>Ter Docker instalado na maquina
</ul>

