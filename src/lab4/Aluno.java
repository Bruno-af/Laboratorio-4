package lab4;

/**
 * Representa��o de um Aluno, todo aluno deve possuir uma matr�cula, um nome e um curso.
 * 
 * @author Gabriel Menezes Cabral - 119110372
 *
 */
public class Aluno {
	
	/**
	 * Matr�cula do Aluno.
	 */
	private String matricula;
	
	/**
	 * Nome do Aluno.
	 */
	private String nome;
	
	/**
	 * Curso do Aluno.
	 */
	private String curso;
	
	/**
	 * Constr�i um aluno, a partir da matr�cula, o nome , e o cruso dele.
	 * 
	 * @param matricula eh a matr�cula do aluno.
	 * @param nome eh o nome do aluno.
	 * @param curso eh o curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	/**
	 * M�todo get que pega a Matr�cula de determinado aluno.
	 * 
	 * @return a matr�cula do aluno.
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * M�todo get que pega o nome de determinado aluno.
	 * 
	 * @return o nome do aluno.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * M�todo get que pega o curso de determinado aluno.
	 * 
	 * @return
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * Gera um inteiro que representa o hashCode do aluno mediante sua matr�cula.
	 * 
	 * @return o inteiro que representa o hashCode do aluno.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * M�todo Equals que compara um objeto com outro a partir do seu n�mero de Matr�cula.
	 * 
	 * @param obj objeto que ser� comparado.
	 * @return um valor booleano indicando se os objetos s�o iguais ou n�o, mediante o n�mero da matr�cula.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/**
	 * Retorna a String que representa o Aluno. A representa��o segue o
	 * formato �MATRICULA - Nome do Aluno - Curso�.
	 * 
	 * @return String que representa o aluno.
	 */
	@Override
	public String toString() {
		return this.getMatricula() + " - " + this.getNome() + " - " + this.getCurso();
	}
}

	



