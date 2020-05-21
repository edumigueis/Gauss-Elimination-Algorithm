/**
A classe Matriz representa uma matriz de números implemementada
tendo como base dois ints que armazenam, respectivamente, o número de linhas e o número de colunas na matriz, como na matemática.
E, uma matriz propriamente dita.
Instâncias desta classe permitem a relização das operações básicas de uma matriz.
Nela encontramos, por exemplo, métodos para incluir, excluir e listar.

@author Eduardo Migueis e Enzo Spinella
@since 2019
*/

public class Matriz
{
	// Variáveis que armazenam o numero de linha e o numero de colunas.
	private int numeroDeLinhas;
	private int numeroDeColunas;

	// O atributo principal da classe, uma matriz, usada para o armazenamento de números.
	private double[][] matriz;

	/**
	    Constroi uma nova instância da classe Matriz.
	    Para tanto, deve ser fornecido o númeroDeLinhas que a matriz possuirá.
	    @param numeroDeLinhas o númeroDeLinhas que a matriz possuirá.
	    @throws Exception se o número de linhas for negativo.
	*/
	public Matriz(int numeroDeLinhas) throws Exception
	{
		if(numeroDeLinhas<=1)
			throw new Exception("Número de Linhas e Colunas Inválido");

		this.numeroDeLinhas = numeroDeLinhas;
		this.numeroDeColunas = numeroDeLinhas+1;// Pois sempre haverá uma coluna a mais
												// para representar o resultado de cada equação das linhas

		matriz = new double[numeroDeLinhas][numeroDeColunas];
	}
	/**
		Retorna uma linha específica na mariz.
		@param numeroLinha número da linha o qual se deseja acessar os valores.
		@return ret uma linha específica na matriz.
		@throws Exception se o número de linha for menor que 0 ou maior que o declrado na matriz.
	*/
	public double[] getLinha(int numeroLinha)throws Exception
	{
		if(numeroLinha < 0 || numeroLinha > this.numeroDeLinhas)
		{
			throw new Exception("Número de linhas inválido");
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
		Retorna uma coluna específica na mariz.
		@param numeroColuna número da coluna o qual se deseja acessar os valores.
		@return ret uma coluna específica na matriz.
		@throws Exception se o número de coluna for menor que 0 ou maior que o declrado na matriz.
	*/
	public double[] getColuna(int numeroColuna) throws Exception
	{
		if(numeroColuna < 0 || numeroColuna > this.numeroDeColunas)
				{
					throw new Exception("Número de colunas inválido");
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
		@param nmrLinha o número da linha que se deseja alterar.
		@param elem um vetor que será colocado em uma linha na matriz.
		@throws Exception se o número da linha for menor que 0 ou maior que o declrado na matriz e se o vetor passado for diferente do númro de colunas.
	*/
	public void setLinha(int nmrLinha, double[] elem) throws Exception
	{
		if(nmrLinha > this.numeroDeLinhas || nmrLinha < 0)
			throw new Exception("Número de linhas inválido.");

		if(elem.length != this.numeroDeColunas)
			throw new Exception("Número de valores no vetor inválido.");

		for(int i = 0; i < this.numeroDeColunas; i++)
		{
			this.matriz[nmrLinha][i] = elem[i];
		}

	}
	/**
		Altera uma coluna da matriz a partir de um vetor.
		@param nmrColuna número da coluna que se deseja alterar.
		@param elem um vetor que será colocado em uma coluna na matriz.
		@throws Exception se o número da coluna for menor que 0 ou maior que o declrado na matriz e se o vetor passado for diferente do númro de linhas.
	*/
	public void setColuna(int nmrColuna, double[] elem) throws Exception
	{
		if(nmrColuna > this.numeroDeColunas || nmrColuna < 0)
			throw new Exception("Número de colunas inválido.");
		if(elem.length != this.numeroDeLinhas)
			throw new Exception("Número de valores no vetor inválido.");

		for(int i = 0; i < this.numeroDeLinhas; i++)
		{
			this.matriz[i][nmrColuna] = elem[i];
		}
	}
	/**
		Retorna um elemento de uma posição específica passada como parâmetro na mariz.
		@param linha uma linha realtiva à posição que se deseja acessar.
		@param coluna uma coluna realtiva à posição que se deseja acessar.
		@return um elemento de uma posição específica na matriz.
		@throws Exception se o número de linhas ou coluna for menor que 0 ou maior que o declrado na matriz.
	*/
	public double getElem(int linha, int coluna) throws Exception
	{
		if(linha < 0 || linha > this.numeroDeLinhas || coluna < 0 || coluna > this.numeroDeColunas)
		{
			throw new Exception("Número de colunas ou linhas inválido");
		}
		return this.matriz[linha][coluna];
	}

	/**
		Retorna o número de colunas da matriz.
		@return retorna o número de colunas da matriz.
	*/
	public int getNumeroDeColunas()
	{
		return this.numeroDeColunas;
	}
	/**
		Retorna o número de linhas da matriz.
		@return retorna o número de linhas da matriz.
	*/
	public int getNumeroDeLinhas()
	{
		return this.numeroDeLinhas;
	}
	/**
		Atera o valor de determinada posição na matriz.
		Muda o valor armazenado em determinada posição da matriz, usando um valor passado como parâmetro.
		@param linha determina a linha da matriz relativa a posição que será alterada.
		@param coluna determina a coluna da matriz relativa a posição que será alterada.
		@param elem determina o valor o qual a posicao receberá.
		@throws Exception se o número de colunas ou linhas for negativo ou maior que o declarado na Matriz.
	*/
	public void inserirElem(int linha, int coluna, double elem) throws Exception
	{
		if(linha < 0 || linha > this.numeroDeLinhas || coluna < 0 || coluna > this.numeroDeColunas)
		throw new Exception("Número de linha ou coluna inválido.");
		try
		{
			elem = new Double(elem);
		}
		catch(Exception ex)
		{
			throw new Exception("O valor passado como parâmetro deve ser um double.");
		}

		this.matriz[linha][coluna] = elem;
	}
	/**
		Retorna o valor da diagonal principal da matriz a partir de um vetor.
		Acessa os valores armazenados na diagonal principal.
		@return um vetor que contém os valores da diagonal principal.
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
		Muda o valor da diagonal principal da matriz a partir de um vetor passado como parâmetro.
		Altera os valores armazenados na diagonal principal para aqueles relativos ao vetor no parâmetro.
		@param diagonal o vetor que será usado para alterar os valores da diagonal principal.
		@throws Exception se o número de elementos no vetor passado for diferente do número de linhas na matriz.
	*/
	public void setDiagonalPrincipal(double[] diagonal) throws Exception
	{
		if(this.numeroDeLinhas != diagonal.length)
		{
			throw new Exception("O número de valores no vetor passado deve ser o mesmo de linhas na matriz.");
		}
		for(int i = 0; i< this.numeroDeLinhas; i++)
		{
			this.matriz[i][i] = diagonal[i];
		}
	}
	//Métodos Obrigatórios:

	/**
	    Gera uma representação textual de todo conteúdo da matriz.
	    Produz e resulta um String com todos os valores contidos
	    na matriz.
	    @return um String contendo todo o conteúdo da matriz.
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
	    Verifica se o Object fornecido como parâmetro representa uma
	    matriz igual àquela representada pela instância à qual este
	    método for aplicado, resultando true em caso afirmativo,
	    ou false, caso contrário.
	    @param  obj o objeto a ser comparado com a instância à qual esse método
	            for aplicado.
	    @return true, caso o Object fornecido ao método e a instância chamante do
	            método representarem agendas iguais, ou false, caso contrário.
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
	    Calcula o código de espalhamento (ou código de hash) de uma matriz.
	    Calcula e resulta o código de espalhamento (ou código de hash, ou ainda o
	    hashcode) da agenda representada pela instância à qual o método for aplicado.
	    @return o código de espalhamento da matriz chamante do método.
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
	    Constroi uma cópia da instância da classe Matriz dada.
	    Para tanto, deve ser fornecida uma instancia da classe
	    Matriz para ser utilizada como modelo para a
	    construção da nova instância criada.
	    @param modelo a instância da classe Matriz a ser usada
	           como modelo.
	    @throws Exception se o modelo for null.
	    */

	public Matriz(Matriz modelo)throws Exception
	{
		if(modelo==null)
			throw new Exception("Modelo De Matriz Inválido");

			this.matriz = modelo.matriz;
			this.numeroDeColunas = modelo.numeroDeColunas;
			this.numeroDeLinhas = modelo.numeroDeLinhas;
	}
	/**
	    Clona uma Matriz.
	    Produz e resulta uma cópia da matriz representada pela instância
	    à qual o método for aplicado.
	    @return a cópia da matriz representada pela instância à qual
	            o método for aplicado.
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