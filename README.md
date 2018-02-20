# HellTriangle B2W Test


**FERRAMENTAS E IDE's**
  * Na implementação foi utilizado a IDE eclipse Luna Service Release 2 (4.4.2), linguagem JavaSE-1.8 e para teste foi utilizada o JUnit 4.
  
  
**COMO EXECUTAR A APLICAÇÃO**
  * Para executar a aplicação, é necessário rodar a classe br.com.b2w.helltriangle.main.Principal.java que compõe o método Main 
      passando o argumento de entrada no seguinte formato: "[[6],[3,5],[9,7,1],[4,6,8,4]]". Que consistem em um array de array de inteiros, representando um triângulo.
  * A aplicação exibirá no console a maior soma do topo ao fim do triângulo atendendo as regras requisitadas no documento recebido.
  
  
**ALGORITMO**
  * Foi utilizado um algoritmo recursivo para a varrer da árvore.


**CLASSES PRINCIPAIS**
  * Foi criada uma biblioteca para validar/converter o argumento de entrada em array de inteiros e validar se o array de array condiz com o formato de um triângulo.
  * Foi criada a classe de teste br.com.b2w.helltriangle.teste.Teste.java para verificar a integridade dos métodos da classe 
	    br.com.b2w.helltriangle.util.BibliotecaHellTriangle.java e da classe br.com.b2w.helltriangle.main.Triangulo.java
      
      
 **EXECUÇÃO DO TESTE**
  * Executar com JUnit 4 a classe de teste br.com.b2w.helltriangle.teste.Teste.java
