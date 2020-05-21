/**
	A classe EscalonamentoMatriz implementa as opera��es feitas em um sistema de equa��es
	da classe Matriz conforme o algoritmo de gauss.
	Inst�ncias dessa classe operam uma matriz a partir da opera��o solicitada
	pelo usu�rio.
	A classe possui m�todos como: somaDeLinhas, subtracaoDeLinhas, trocaDeValoresLinhas, multiplicacaoPorEscalar.
	@authors Eduardo Migueis & Enzo Spinella
	@since 2019
*/
public class EscalonamentoMatriz
{
	// Objeto da classe matriz usado para melhor funcionamento dos m�todos usados pelo escalonamento
	// fazendo-se n�o neces�rio comandos repetitivos em v�rios m�todos, para coletar, por exemplo, uma linha inteira.
	private Matriz sistema;

	/**
		� constru�da uma nova inst�ncia da classe Escalonamento
		e esta nova inst�ncia instancia nosso sistema como uma matriz passada como par�metro.
		@param Objeto matriz da classe Matriz para representar uma matriz da programa��o.
		@throws Exception caso a matriz passada como par�metro seja nula
	*/
	public EscalonamentoMatriz(Matriz matriz)throws Exception
	{
		if(matriz==null)
			throw new Exception("Matriz Inv�lida");
		sistema = new Matriz(matriz);
	}


	public Matriz getMatriz()
	{
		return this.sistema;
	}


	/**
		M�todo que verifica a exist�ncia coesa do sistema de equa��es
		Este m�todo verifica a exist�ncia dos sistemas a partir de v�rias
		divis�es, em que, caso o resultado da divis�o entre um elemento e outro
		da linha de baixo der o mesmo do que qualquer outra divis�o entre as outras linhas
		ou entre a mesma, o m�todo lan�ar� exce��o para indicar a inexist�ncia do sistema.
		@throws Exception quando ocorre algum erro na verifica��o da exist�ncia ou quando
		o sistema � verificado como inexist�ncia
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
			throw new Exception("Problemas ao verificar a exist�ncia do sistema");
		}

		verificarIgualdadeDoResultado(resultados);
	}

	/**
		M�todo que retira os zeros da diagonal principal da matriz
		Este m�todo retira os zeros da diagonal principal com o intuito
		de melhorar o funcionamento do m�todo de gauss. Ele troca as linhas do sistema de equa��es
		uma pela outra at�
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
			 	throw new Exception("Sistema n�o existe");
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



	 // M�todos Obrigat�rios
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














