package lab4;

import java.util.HashSet;

/**
 * Representa��o de um Grupo, que deve possuir um nome.
 * 
 * @author Gabriel Menezes Cabral - 119110372
 *
 */
public class Grupo {

	/**
	 * Nome do Grupo.
	 */
	private String nomeDoGrupo;
	
	/**
	 * Um HashSet que representa os alunos do Grupo.
	 */
	public HashSet<Aluno> alunosDoGrupo;

	/**
	 * Constr�i um grupo, a partir do nome do grupo. No grupo podem ser adicionados alunos, pelo HashSet: alunosDoGrupo.
	 * 
	 * @param nomeDoGrupo eh o nome do grupo.
	 */
	public Grupo(String nomeDoGrupo) {
		this.nomeDoGrupo = nomeDoGrupo;
		this.alunosDoGrupo = new HashSet<>();
	}

	/**
	 * M�todo que adiciona um aluno a um determinado grupo.
	 * 
	 * @param aluno eh o aluno a ser adicionado.
	 */
	public void adicionaAluno(Aluno aluno) {
		if (!alunosDoGrupo.contains(aluno)) {
			alunosDoGrupo.add(aluno);
		}
	}

	/**
	 * Retorna a String que representa o grupo com seus respectivos alunos.
	 * 
	 * @return String que representa o aluno.
	 */
	@Override
	public String toString() {
		String retorno = "\nAlunos do grupo " + this.nomeDoGrupo + ":";
		for (Aluno i : alunosDoGrupo) {
			retorno += "\n* " + i.toString();
		}
		return retorno + System.lineSeparator();
	}
	
	/**
	 * Gera um inteiro que representa o hashCode do grupo mediante o nome do Grupo.
	 * 
	 * @return o inteiro que representa o hashCode do grupo.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeDoGrupo == null) ? 0 : nomeDoGrupo.hashCode());
		return result;
	}

	/**
	 * M�todo Equals que compara um objeto com outro a partir do nome do grupo.
	 * 
	 * @param obj objeto que ser� comparado.
	 * @return um valor booleano indicando se os objetos s�o iguais ou n�o, mediante o nome do grupo.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (nomeDoGrupo == null) {
			if (other.nomeDoGrupo != null)
				return false;
		} else if (!nomeDoGrupo.equals(other.nomeDoGrupo))
			return false;
		return true;
	}

}