package lab4;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Representa��o de um Controle, que � respons�vel por manipular os Collections, e guardar alguns m�todos do programa.
 * 
 * @author Gabriel Menezes Cabral - 119110372
 *
 */
public class ControleAlunos {

	/**
	 * Um HashMap que representa os alunos.
	 */
	private HashMap<String, Aluno> alunos;
	
	/**
	 * Um HashMap que representa os grupos.
	 */
	private HashMap<String, Grupo> grupos;
	
	/**
	 * Um ArrayList que representa os alunos Estudiosos (alunos que respondem quest�es).
	 */
	private ArrayList<Aluno> alunosEstudiosos;

	/**
	 * Constr�i um Controle de alunos, e inicializa os HashMap e o ArrayList.
	 */
	public ControleAlunos() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.alunosEstudiosos = new ArrayList<>();
	}

	/**
	 * M�todo que cadastra o Aluno.
	 * 
	 * @param matricula eh a matr�cula do aluno.
	 * @param nome eh o nome do aluno.
	 * @param curso eh o nome do curso do que o aluno faz.
	 * @return um valor booleano dependendo se o aluno foi cadastrado ou n�o.
	 */
	public boolean cadastrarAluno(String matricula, String nome, String curso) {
		if (matricula == null) {
			throw new NullPointerException("Matr�cula Nula");
		}
		if (matricula.trim().isEmpty()) {
			throw new IllegalArgumentException("Matr�cula Inv�lida");
		}
		if (nome == null) {
			throw new NullPointerException("Nome Nulo");
		}
		if (nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome Inv�lido");
		}
		if (curso == null) {
			throw new NullPointerException("Nome do Curso Nulo");
		}
		
		if (curso.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome do Curso Inv�lido");
		}
		
		if (alunos.containsKey(matricula)) {
			return false;
		} else {
			alunos.put(matricula, new Aluno(matricula, nome, curso));
			return true;
		}

	}

	/**
	 * M�todo que exibe o aluno por meio de uma String que representa o aluno.
	 * 
	 * @param matricula eh a matr�cula do aluno.
	 * @return String que representa o aluno. A representa��o segue o formato �MATRICULA - Nome do Aluno - Curso�.
	 * Ou ent�o "Aluno n�o cadastrado." caso o aluno ainda n�o esteja cadastrado.
	 */
	public String exibirAluno(String matricula) {
		if (matricula == null) {
			throw new NullPointerException("Matr�cula Nula");
		}
		if (matricula.trim().isEmpty()) {
			throw new IllegalArgumentException("Matr�cula Inv�lida");
		}
		
		if (alunos.containsKey(matricula)) {
			return System.lineSeparator() + alunos.get(matricula).toString() + System.lineSeparator();
		} else {
			return "\nAluno n�o cadastrado.\n";
		}
	}

	/**
	 * M�todo que cadastra Grupo.
	 * 
	 * @param nomeDoGrupo eh o nome do Grupo.
	 * @return "CADASTRO REALIZADO!" caso seja bem sucedido o cadastro, ou "GRUPO J� CADASTRADO!" caso o grupo j� esteja cadastrado.
	 */
	public String cadastrarGrupo(String nomeDoGrupo) {
		if (nomeDoGrupo == null) {
			throw new NullPointerException("Nome do Grupo Nulo");
		}
		
		if (nomeDoGrupo.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome do Grupo Inv�lido");
		}
		
		if (grupos.containsKey(nomeDoGrupo.toLowerCase())) {
			return "GRUPO J� CADASTRADO!\n";
		} else {
			grupos.put(nomeDoGrupo.toLowerCase(), new Grupo(nomeDoGrupo));
			return "CADASTRO REALIZADO!\n";
		}
	}

	/**
	 * M�todo que aloca o aluno em um determinado grupo.
	 * 
	 * @param matricula eh a matr�cula do aluno.
	 * @param grupo eh o grupo que o aluno vai ser cadastrado.
	 * @return "ALUNO ALOCADO!" caso o aluno seja alocado com sucesso no grupo, ou "Grupo n�o cadastrado" caso o grupo n�o tenha sido
	 * cadastrado, ou "Aluno n�o cadastrado." caso o aluno n�o tenha sido cadsatrado ainda.
	 */
	public String alocarAluno(String matricula, String grupo) {
		if (matricula == null) {
			throw new NullPointerException("Matr�cula Nula");
		}
		if (matricula.trim().isEmpty()) {
			throw new IllegalArgumentException("Matr�cula Inv�lida");
		}
		if (grupo == null) {
			throw new NullPointerException("Nome do Grupo Nulo");
		}
		
		if (grupo.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome do Grupo Inv�lido");
		}
		
		if (alunos.containsKey(matricula)) {
			if (grupos.containsKey(grupo.toLowerCase())) {
				grupos.get(grupo.toLowerCase()).adicionaAluno(alunos.get(matricula));
				return "ALUNO ALOCADO!\n";
			} else {
				return "Grupo n�o cadastrado.\n";
			}
		} else {
			return "Aluno n�o cadastrado.\n";
		}
	}

	/**
	 * M�todo que imprime determinado grupo.
	 * 
	 * @param grupo eh o nome do grupo a ser impresso.
	 * @return String que representa o grupo com seus respectivos alunos. Caso o grupo n�o esteja cadastrado
	 * ele retorna "Grupo n�o cadastrado."
	 */
	public String imprimirGrupo(String grupo) {
		if (grupo == null) {
			throw new NullPointerException("Nome do Grupo Nulo");
		}
		
		if (grupo.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome do Grupo Inv�lido");
		}
		
		if (grupos.containsKey(grupo.toLowerCase())) {
			return grupos.get(grupo.toLowerCase()).toString();
		} else {
			return "Grupo n�o cadastrado.\n";
		}
	}

	/**
	 * M�todo que registra os alunos que respondem quest�es.
	 * 
	 * @param matricula eh a matr�cula do aluno a ser registrado.
	 * @return "ALUNO REGISTRADO!" caso o aluno tenha sido registrado com sucesso, ou "Aluno n�o cadastrado." 
	 * caso o aluno ainda n�o tenha sido cadsatrado.
	 */
	public String registrarEstudiosos(String matricula) {
		if (matricula == null) {
			throw new NullPointerException("Matr�cula Nula");
		}
		if (matricula.trim().isEmpty()) {
			throw new IllegalArgumentException("Matr�cula Inv�lida");
		}
		
		if (alunos.containsKey(matricula)) {
			alunosEstudiosos.add(alunos.get(matricula));
			return "ALUNO REGISTRADO!\n";
		} else {
			return "Aluno n�o cadastrado.\n";
		}
	}
	
	/**
	 * M�todo que imprime os alunos que respondem quest�es.
	 * 
	 * @return String que representa os alunos que respondem quest�es.
	 */
	public String imprimirEstudiosos() {
		String retorno = "\nAlunos:";
		for (int j = 0; j < alunosEstudiosos.size(); j++) {
			retorno += System.lineSeparator() + (j + 1) + ". " + alunosEstudiosos.get(j).toString(); 
		}
		return retorno + System.lineSeparator();
	}
}