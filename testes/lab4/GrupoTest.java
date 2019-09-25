package lab4;

import static org.junit.Assert.*;

import org.junit.Test;

import lab4.Grupo;



public class GrupoTest {
	
	@Test
	public void testaConstrutor() {
		Grupo grupo = new Grupo("Bonit�es de CC");
		assertFalse(grupo == null);
	}
	
	@Test
	public void testaAdicionaAlunos() {
		Grupo grupo = new Grupo("Las Donzelas");
		Aluno aluno1 = new Aluno("135", "Maria", "Letras");
		Aluno aluno2 = new Aluno("618", "Camila", "Odontol�gia");
		
		grupo.adicionaAluno(aluno1);
		assertEquals("\nAlunos do grupo Las Donzelas:" + "\n* 135 - Maria - Letras" + System.lineSeparator(), grupo.toString());
		
		grupo.adicionaAluno(aluno2);
		assertEquals("\nAlunos do grupo Las Donzelas:" + "\n* 135 - Maria - Letras" + "\n* 618 - Camila - Odontol�gia" + System.lineSeparator(),
				grupo.toString());
	}
	
	@Test
	public void testaToString() {
		Grupo grupo = new Grupo("Los Hermanos");
		Aluno aluno1 = new Aluno("119", "Bielzin", "Ci�ncias da Computa��o");
		Aluno aluno2 = new Aluno("324", "Vinicius", "Artes C�nicas");
		Aluno aluno3 = new Aluno("987", "Melqui", "Engenharia da Computa��o");
		grupo.adicionaAluno(aluno1);
		grupo.adicionaAluno(aluno2);
		grupo.adicionaAluno(aluno3);
		
		assertEquals("\nAlunos do grupo Los Hermanos:" + "\n* 324 - Vinicius - Artes C�nicas" + "\n* 987 - Melqui - Engenharia da Computa��o" + 
		"\n* 119 - Bielzin - Ci�ncias da Computa��o" + System.lineSeparator(), grupo.toString());
	}
	
	@Test
	public void testaEquals() {
		Grupo grupo1 = new Grupo("Fogo");
		Grupo grupo2 = new Grupo("�gua");
		Grupo grupo3 = new Grupo("Fogo");
		Grupo grupo4 = new Grupo("�gua");
		
		assertFalse(grupo1.equals(grupo2));
		assertFalse(grupo3.equals(grupo4));
		
		assertTrue(grupo1.equals(grupo3));
		assertTrue(grupo2.equals(grupo4));
	}
	
	@Test
	public void testaHashCode() {
		Grupo grupo1 = new Grupo("Fogo");
		Grupo grupo2 = new Grupo("�gua");
		Grupo grupo3 = new Grupo("Fogo");
		Grupo grupo4 = new Grupo("�gua");
		
		assertFalse(grupo1.hashCode() == grupo2.hashCode());
		assertFalse(grupo3.hashCode() == grupo4.hashCode());
		
		assertTrue(grupo1.hashCode() == grupo3.hashCode());
		assertTrue(grupo2.hashCode() == grupo4.hashCode());
	}
}
