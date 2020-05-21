/**
A classe Matriz representa uma matriz de n�meros implemementada
tendo como base dois ints que armazenam, respectivamente, o n�mero de linhas e o n�mero de colunas na matriz, como na matem�tica.
E, uma matriz propriamente dita.
Inst�ncias desta classe permitem a reliza��o das opera��es b�sicas de uma matriz.
Nela encontramos, por exemplo, m�todos para incluir, excluir e listar.

@author Eduardo Migueis e Enzo Spinella
@since 2019
*/

public class Matriz
{
	// Vari�veis que armazenam o numero de linha e o numero de colunas.
	private int numeroDeLinhas;
	private int numeroDeColunas;

	// O atributo principal da classe, uma matriz, usada para o armazenamento de n�meros.
	private double[][] matriz;

	/**
	    Constroi uma nova inst�ncia da classe Matriz.
	    Para tanto, deve ser fornecido o n�meroDeLinhas que a matriz possuir�.
	    @param numeroDeLinhas o n�meroDeLinhas que a matriz possuir�.
	    @throws Exception se o n�mero de linhas for negativo.
	*/
	public Matriz(int numeroDeLinhas) throws Exception
	{
		if(numeroDeLinhas<=1)
			throw new Exception("N�mero de Linhas e Colunas Inv�lido");

		this.numeroDeLinhas = numeroDeLinhas;
		this.numeroDeColunas = numeroDeLinhas+1;// Pois sempre haver� uma coluna a mais
												// para representar o resultado de cada equa��o das linhas

		matriz = new double[numeroDeLinhas][numeroDeColunas];
	}
	/**
		Retorna uma linha espec�fica na mariz.
		@param numeroLinha n�mero da linha o qual se deseja acessar os valores.
		@return ret uma linha espec�fica na matriz.
		@throws Exception se o n�mero de linha for menor que 0 ou maior que o declrado na matriz.
	*/
	public double[] getLinha(int numeroLinha)throws Exception
	{
		if(numeroLinha < 0 || numeroLinha > this.numeroDeLinhas)
		{
			throw new Exception("N�mero de linhas inv�lido");
		}
			double[] ret;
			ret = new double[this.numeroDeColunas];

			for(int i = 0; i < this.numeroDeColunas; i++)
			{
				ret[i] = this.matriz[numeroLinha][i];
			}
			return ret;
	}

	/**
		Retorna uma coluna espec�fica na mariz.
		@param numeroColuna n�mero da coluna o qual se deseja acessar os valores.
		@return ret uma coluna espec�fica na matriz.
		@throws Exception se o n�mero de coluna for menor que 0 ou maior que o declrado na matriz.
	*/
	public double[] getColuna(int numeroColuna) throws Exception
	{
		if(numeroColuna < 0 || numeroColuna > this.numeroDeColunas)
				{
					throw new Exception("N�mero de colunas inv�lido");
				}
					double[] ret;
					ret = new double[this.numeroDeLinhas];

					for(int i = 0; i < this.numeroDeLinhas; i++)
					{
						ret[i] = this.matriz[i][numeroColuna];
					}
			return ret;
	}
	/**
		Altera uma linha da matriz a partir de um vetor.
		@param nmrLinha o n�mero da linha que se deseja alterar.
		@param elem um vetor que ser� colocado em uma linha na matriz.
		@throws Exception se o n�mero da linha for menor que 0 ou maior que o declrado na matriz e se o vetor passado for diferente do n�mro de colunas.
	*/
	public void setLinha(int nmrLinha, double[] elem) throws Exception
	{
		if(nmrLinha > this.numeroDeLinhas || nmrLinha < 0)
			throw new Exception("N�mero de linhas inv�lido.");

		if(elem.length != this.numeroDeColunas)
			throw new Exception("N�mero de valores no vetor inv�lido.");

		for(int i = 0; i < this.numeroDeColunas; i++)
		{
			this.matriz[nmrLinha][i] = elem[i];
		}

	}
	/**
		Altera uma coluna da matriz a partir de um vetor.
		@param nmrColuna n�mero da coluna que se deseja alterar.
		@param elem um vetor que ser� colocado em uma coluna na matriz.
		@throws Exception se o n�mero da coluna for menor que 0 ou maior que o declrado na matriz e se o vetor passado for diferente do n�mro de linhas.
	*/
	public void setColuna(int nmrColuna, double[] elem) throws Exception
	{
		if(nmrColuna > this.numeroDeColunas || nmrColuna < 0)
			throw new Exception("N�mero de colunas inv�lido.");
		if(elem.length != this.numeroDeLinhas)
			throw new Exception("N�mero de valores no vetor inv�lido.");

		for(int i = 0; i < this.numeroDeLinhas; i++)
		{
			this.matriz[i][nmrColuna] = elem[i];
		}
	}
	/**
		Retorna um elemento de uma posi��o espec�fica passada como par�metro na mariz.
		@param linha uma linha realtiva � posi��o que se deseja acessar.
		@param coluna uma coluna realtiva � posi��o que se deseja acessar.
		@return um elemento de uma posi��o espec�fica na matriz.
		@throws Exception se o n�mero de linhas ou coluna for menor que 0 ou maior que o declrado na matriz.
	*/
	public double getElem(int linha, int coluna) throws Exception
	{
		if(linha < 0 || linha > this.numeroDeLinhas || coluna < 0 || coluna > this.numeroDeColunas)
		{
			throw new Exception("N�mero de colunas ou linhas inv�lido");
		}
		return this.matriz[linha][coluna];
	}

	/**
		Retorna o n�mero de colunas da matriz.
		@return retorna o n�mero de colunas da matriz.
	*/
	public int getNumeroDeColunas()
	{
		return this.numeroDeColunas;
	}
	/**
		Retorna o n�mero de linhas da matriz.
		@return retorna o n�mero de linhas da matriz.
	*/
	public int getNumeroDeLinhas()
	{
		return this.numeroDeLinhas;
	}
	/**
		Atera o valor de determinada posi��o na matriz.
		Muda o valor armazenado em determinada posi��o da matriz, usando um valor passado como par�metro.
		@param linha determina a linha da matriz relativa a posi��o que ser� alterada.
		@param coluna determina a coluna da matriz relativa a posi��o que ser� alterada.
		@param elem determina o valor o qual a posicao receber�.
		@throws Exception se o n�mero de colunas ou linhas for negativo ou maior que o declarado na Matriz.
	*/
	public void inserirElem(int linha, int coluna, double elem) throws Exception
	{
		if(linha < 0 || linha > this.numeroDeLinhas || coluna < 0 || coluna > this.numeroDeColunas)
		throw new Exception("N�mero de linha ou coluna inv�lido.");
		try
		{
			elem = new Double(elem);
		}
		catch(Exception ex)
		{
			throw new Exception("O valor passado como par�metro deve ser um double.");
		}

		this.matriz[linha][coluna] = elem;
	}
	/**
		Retorna o valor da diagonal principal da matriz a partir de um vetor.
		Acessa os valores armazenados na diagonal principal.
		@return um vetor que cont�m os valores da diagonal principal.
	*/
	public double[] getDiagonalPrincipal()
	{
		double[] ret;
		ret = new double[this.numeroDeLinhas];
		for(int i = 0; i < this.numeroDeLinhas; i++)
		{
			ret[i] = this.matriz[i][i];
		}
		return ret;
	}
	/**
		Muda o valor da diagonal principal da matriz a partir de um vetor passado como par�metro.
		Altera os valores armazenados na diagonal principal para aqueles relativos ao vetor no par�metro.
		@param diagonal o vetor que ser� usado para alterar os valores da diagonal principal.
		@throws Exception se o n�mero de elementos no vetor passado for diferente do n�mero de linhas na matriz.
	*/
	public void setDiagonalPrincipal(double[] diagonal) throws Exception
	{
		if(this.numeroDeLinhas != diagonal.length)
		{
			throw new Exception("O n�mero de valores no vetor passado deve ser o mesmo de linhas na matriz.");
		}
		for(int i = 0; i< this.numeroDeLinhas; i++)
		{
			this.matriz[i][i] = diagonal[i];
		}
	}
	//M�todos Obrigat�rios:

	/**
	    Gera uma representa��o textual de todo conte�do da matriz.
	    Produz e resulta um String com todos os valores contidos
	    na matriz.
	    @return um String contendo todo o conte�do da matriz.
	    */

	public String toString()
	{
		String ret = "Matriz:"+"\n";
		for(int i = 0; i < this.numeroDeLinhas; i++)// for que percorre a matriz.
		{
			for(int j = 0; j < this.numeroDeColunas; j++)
			{
				ret+= this.matriz[i][j]+ "  ";
			}
			ret+="\n";//pula uma linha juntamente a matriz.
		}
		return ret;
	}
	/**
	    Verifica a igualdade entre duas Matrizes.
	    Verifica se o Object fornecido como par�metro representa uma
	    matriz igual �quela representada pela inst�ncia � qual este
	    m�todo for aplicado, resultando true em caso afirmativo,
	    ou false, caso contr�rio.
	    @param  obj o objeto a ser comparado com a inst�ncia � qual esse m�todo
	            for aplicado.
	    @return true, caso o Object fornecido ao m�todo e a inst�ncia chamante do
	            m�todo representarem agendas iguais, ou false, caso contr�rio.
	    */

	public boolean equals(Object obj)
	{
		if(obj==null)
			return false;
		if(this==obj)
			return true;
		if(this.getClass()!=obj.getClass())
			return false;

		Matriz outra = (Matriz)obj;

		if(outra.numeroDeColunas!=this.numeroDeColunas || this.numeroDeLinhas!=outra.numeroDeLinhas)
			return false;

		for(int linhas = 0; linhas < this.numeroDeLinhas; linhas++)
		{
			for(int colunas = 0; colunas< this.numeroDeColunas; colunas++)
			{
				if(this.matriz[linhas][colunas] != outra.matriz[linhas][colunas])
					return false;
			}
		}
		return true;
	}

	    /**
	    Calcula o c�digo de espalhamento (ou c�digo de hash) de uma matriz.
	    Calcula e resulta o c�digo de espalhamento (ou c�digo de hash, ou ainda o
	    hashcode) da agenda representada pela inst�ncia � qual o m�todo for aplicado.
	    @return o c�digo de espalhamento da matriz chamante do m�todo.
	    */

	public int hashCode()
	{
		int ret = 9;

		ret = ret*7 + new Integer(this.numeroDeLinhas).hashCode();
		ret = ret*7 + new Integer(this.numeroDeColunas).hashCode();

		for(int linhas = 0; linhas<this.numeroDeLinhas; linhas++)
			for(int colunas = 0; colunas<this.numeroDeColunas; colunas++)
			{
				ret = ret*7 + new Double(this.matriz[linhas][colunas]).hashCode();
			}
		return ret;
	}
	/**
	    Constroi uma c�pia da inst�ncia da classe Matriz dada.
	    Para tanto, deve ser fornecida uma instancia da classe
	    Matriz para ser utilizada como modelo para a
	    constru��o da nova inst�ncia criada.
	    @param modelo a inst�ncia da classe Matriz a ser usada
	           como modelo.
	    @throws Exception se o modelo for null.
	    */

	public Matriz(Matriz modelo)throws Exception
	{
		if(modelo==null)
			throw new Exception("Modelo De Matriz Inv�lido");

			this.matriz = modelo.matriz;
			this.numeroDeColunas = modelo.numeroDeColunas;
			this.numeroDeLinhas = modelo.numeroDeLinhas;
	}
	/**
	    Clona uma Matriz.
	    Produz e resulta uma c�pia da matriz representada pela inst�ncia
	    � qual o m�todo for aplicado.
	    @return a c�pia da matriz representada pela inst�ncia � qual
	            o m�todo for aplicado.
	 */

	public Object clone ()
	    {
	        Matriz copia=null;

	        try
	        {
	            copia = new Matriz (this);
	        }
	        catch (Exception e)
	        {}

	        return copia;
	    }

}