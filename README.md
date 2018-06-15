# burger-server
Burger Sale - Server Side

<b>Aplicação client</b>
https://github.com/danielsmanioto/burger-client

<b>Aplicação server</b> 
https://github.com/danielsmanioto/burger-server


# Instruções de como executar com Docker
docker_run.sh

# Instruções de como executar sem Docker
<ul>
  <li>mvn test (para verificar os tests)</li>
  <li>mvn spring-boot:run (para iniciar a aplicação)
  <li>Baixar a aplicação client em https://github.com/danielsmanioto/burger-client</li>
  <li>Para abrir a aplicação client basta abrir o index.html em um browser</li>
  <li>É possível validar os methodos HTTP usando o client postman basta importar o arquivo --> burger-server\useful\requests\postman</li>
  <li>É possível validar os methodos HTTP gets executar os .sh em --> burger-server\useful\requests\curl</li>
  <li>Acessar o banco de dados --> http://localhost:8080/h2</li>
</ul>

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
	<b>Injeção de dependência e uso de interface:​</b> no service para garantir um contrato e
	obrigatoriedade de implementação das regras fundamentais de cada funcionalidade.
<p/>
<p> <b>API REST verbos:</b> ​Uso de padrões de API para mapeamento correto e intuitivo dos métodos
	expostos pela API.
	Organização do projeto: ​Organização dos pacotes do projeto com objetivo de facilitar o
	entendimento e auxiliar na evolução do sistema.
</p>

# Justificativa e documentação
<ul>
  <li>Justificativa do design da aplicação em --> justificativa_design_codigo.pdf</li>
  <li>Os requisitos estão em --> requisitos.pdf</li>
</ul>  

<b>Requisitos:</b>
<ul>
  <li>JDK 1.8</li>
  <li>Maven</li>
  <li>Ter um browser instalado na maquina
</ul>



