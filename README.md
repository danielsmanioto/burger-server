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

#Swagger - Documentação da API
http://localhost:80/swagger-ui.html

#Heroku
https://dsmanioto-burger-server.herokuapp.com/

# Instruções de como executar com Docker
execute o arquivo build.sh (exemplo no linux-> ./build.sh) <br>
execute o arquivo run.sh <br>
Verificar se API está no ar -> http://localhost:80

Agora siga os passos na aplicação client

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
	<p>Controller ou Resource: Chamada da regra de negócio e disponibilização em Json para
	o externo;</p>
	<p>Service: Regra de negócio;</p>
	<p>Repository ou DAO: Regra e persistência com banco de dados ou qualquer que seja o
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

<b>Requisitos:</b>
<ul>
  <li>JDK 1.8</li>
  <li>Maven</li>
  <li>Ter um browser instalado na maquina
  <li>Ter Docker instalado na maquina
</ul>

