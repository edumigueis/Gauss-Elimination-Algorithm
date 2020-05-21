/**
	A classe EscalonamentoMatriz implementa as operações feitas em um sistema de equações
	da classe Matriz conforme o algoritmo de gauss.
	Instâncias dessa classe operam uma matriz a partir da operação solicitada
	pelo usuário.
	A classe possui métodos como: somaDeLinhas, subtracaoDeLinhas, trocaDeValoresLinhas, multiplicacaoPorEscalar.
	@authors Eduardo Migueis & Enzo Spinella
	@since 2019
*/
public class EscalonamentoMatriz
{
	// Objeto da classe matriz usado para melhor funcionamento dos métodos usados pelo escalonamento
	// fazendo-se não necesário comandos repetitivos em vários métodos, para coletar, por exemplo, uma linha inteira.
	private Matriz sistema;

	/**
		É construída uma nova instância da classe Escalonamento
		e esta nova instância instancia nosso sistema como uma matriz passada como parâmetro.
		@param Objeto matriz da classe Matriz para representar uma matriz da programação.
		@throws Exception caso a matriz passada como parâmetro seja nula
	*/
	public EscalonamentoMatriz(Matriz matriz)throws Exception
	{
		if(matriz==null)
			throw new Exception("Matriz Inválida");
		sistema = new Matriz(matriz);
	}


	public Matriz getMatriz()
	{
		return this.sistema;
	}


	/**
		Método que verifica a existência coesa do sistema de equações
		Este método verifica a existência dos sistemas a partir de várias
		divisões, em que, caso o resultado da divisão entre um elemento e outro
		da linha de baixo der o mesmo do que qualquer outra divisão entre as outras linhas
		ou entre a mesma, o método lançará exceção para indicar a inexistência do sistema.
		@throws Exception quando ocorre algum erro na verificação da existência ou quando
		o sistema é verificado como inexistência
	*/
	public void verificarExistencia() throws Exception
	{
		double[] resultados = new double[sistema.getNumeroDeColunas()-1];
		int colunasJaVistas = 0;
		try
		{
			for(int linha1=0;linha1<sistema.getNumeroDeLinhas();linha1++)
				for(int linha2=linha1+1;linha2<sistema.getNumeroDeLinhas();linha2++)
				{
					for(int col=colunasJaVistas;col<sistema.getNumeroDeColunas()-1;col++)
					{
						resultados[colunasJaVistas] = sistema.getElem(linha1, col) / sistema.getElem(linha2, col);
						colunasJaVistas++;
					}
				}
		}
		catch(Exception ex)
		{
			throw new Exception("Problemas ao verificar a existência do sistema");
		}

		verificarIgualdadeDoResultado(resultados);
	}

	/**
		Método que retira os zeros da diagonal principal da matriz
		Este método retira os zeros da diagonal principal com o intuito
		de melhorar o funcionamento do método de gauss. Ele troca as linhas do sistema de equações
		uma pela outra até
	*/
	public void retirarZerosDiagonalPrincipal() throws Exception
	{
		if(haZerosDiagonalPrincipal())
		{
			 loop_Das_Linhas :for(int linha = 0; linha < this.sistema.getNumeroDeLinhas(); linha++)
				loop_Das_Linhas_Comparadas :for(int linhaComparada = 0; linhaComparada < this.sistema.getNumeroDeLinhas(); linhaComparada++)
				{
					if(linha==linhaComparada)
						continue loop_Das_Linhas;
					if(this.sistema.getElem(linha, linha)!=0)
						continue loop_Das_Linhas;
					if(this.sistema.getElem(linhaComparada, linha)==0)
						continue loop_Das_Linhas_Comparadas;

					double[] aux = this.sistema.getLinha(linha);
					this.sistema.setLinha(linha, this.sistema.getLinha(linhaComparada));
					this.sistema.setLinha(linhaComparada, aux);
				}
		}
	 }

	 public void dividirLinhaPorElemDiagonalPrincipal(int numLinha) throws Exception
	 {
		 double elemDiagonalPrincipal = this.sistema.getElem(numLinha, numLinha);
		 if(elemDiagonalPrincipal!=1)
		 {
			 double[] linhaADividir = this.sistema.getLinha(numLinha);
			 for(int col = 0; col < linhaADividir.length; col++)
			 	linhaADividir[col] /= elemDiagonalPrincipal;
			 this.sistema.setLinha(numLinha,linhaADividir);
		 }
	 }
	 public void deixarNumsComValor0(int numColuna)throws Exception
	 {
		for(int linha = 0; linha<this.sistema.getNumeroDeLinhas();linha++)
		{
			if(linha!=numColuna && this.sistema.getElem(linha, numColuna)!=0)
			{
				double[] linhaComVal0 = this.sistema.getLinha(linha);
				double[] linhaASomar = this.sistema.getLinha(numColuna);
				double valASerTransformadoEm0= (-this.sistema.getElem(linha, numColuna));

				linhaASomar = this.multiplicarLinhaPorEscalar(linhaASomar, valASerTransformadoEm0);
				linhaComVal0 = this.somarLinhas(linhaComVal0,linhaASomar);

				this.sistema.setLinha(linha, linhaComVal0);
			}
		}
	 }
	 public double[] multiplicarLinhaPorEscalar(double[] linha, double escalar)throws Exception
	 {
		 for(int col = 0; col < sistema.getNumeroDeColunas(); col++)
		 	linha[col] *= escalar;
		 return linha;
	 }

	 private double[] somarLinhas(double[] linha1, double[] linha2)throws Exception
	 {
		 for(int col = 0; col < sistema.getNumeroDeColunas(); col++)
		 {
		 	double elementoSomado = Math.floor(linha1[col] + linha2[col]);
		 	linha1[col] = elementoSomado;
		 }
		 return linha1;
	 }

	 private void verificarIgualdadeDoResultado(double[] resultado) throws Exception
	 {
		 for(int i = 0; i < resultado.length-1; i++)
		 {
			 if(resultado[i]==resultado[i+1])
			 	throw new Exception("Sistema não existe");
		 }
	 }

	 private boolean haZerosDiagonalPrincipal()
	 {
		 double[] diagPrincipal = this.sistema.getDiagonalPrincipal();
		 for(int i = 0; i < diagPrincipal.length; i++)
		 	if(diagPrincipal[i]==0)
		 		return true;
		 return false;
	 }



	 // Métodos Obrigatórios
	 /*public String toString()
	 {
	 }
	 public int hashCode()
	 {
	 }
	 public EscalonamentoMatriz(EscalonamentoMatriz modelo)
	 {
	 }
	 public Object clone()
	 {
	 }*/
}














