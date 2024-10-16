Main

//Código Inserir:

        package org.senai;

import org.senai.dao.Conexao;
import org.senai.dao.PessoaDAO;
import org.senai.model.Pessoa;
import java.util.List;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Pessoa henrique = new Pessoa(id: 0, nome: "Henrique", email: "henrique@gmail.com");
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.inserir(henrique);

        List<Pessoa> pessoas = pessoaDAO.listar();

        pessoas.forEach(pessoa -> {
            System.out.print(pessoa);
        });
    }
}

//Código atualizar:

package org.senai;

import org.senai.dao.Conexao;
import org.senai.dao.PessoaDAO;
import org.senai.model.Pessoa;
import java.util.List;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Pessoa bruno = new Pessoa(0, "Bruno", "bruno@gmail.com");
        PessoaDAO pessoaDAO = new PessoaDAO();

        pessoaDAO.inserir(bruno);

        bruno.setNome("Bruno");
        bruno.setEmail("bruno@gmail.com");

        pessoaDAO.atualizar(bruno);
    }
}

//Código deletar:

package org.senai;

import org.senai.dao.Conexao;
import org.senai.dao.PessoaDAO;
import org.senai.model.Pessoa;
import java.util.List;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        //Declarações
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Pessoa> pessoas;

        // Operações
        pessoas = pessoaDAO.listar();
        pessoas.forEach(System.out::println);

        //Deletar
        pessoaDAO.deletar(3);

        pessoas = pessoaDAO.listar();
        pessoas.forEach(System.out::println);

    }
}

//Código professorDAO:

package org.senai;

import org.senai.dao.ProfessorDAO;
import org.senai.model.Professor;

public class Main {
    public static void main(String[] args) {
        ProfessorDAO professorDAO = new ProfessorDAO();

        Professor professor = new Professor(
                0,
                "Carlos Alberto",
                "carlos@universidade.com",
                "Matemática");

        professorDAO.inserir(professor);

        System.out.println("Professor inserido: " + professor);
    }
}

//Codigo busca por ID:

package org.senai;

import org.senai.dao.ProfessorDAO;
import org.senai.model.Professor;

public class Main {
    public static void main(String[] args) {

        ProfessorDAO professorDAO = new ProfessorDAO();

        System.out.println(professorDAO.buscarPorId(6));
    }
}

//Codigo listar ProfessorDAO:

package org.senai;

import org.senai.dao.ProfessorDAO;
import org.senai.model.Professor;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProfessorDAO professorDAO = new ProfessorDAO();
        List<Professor> profesores = professorDAO.listarTodos();
        profesores.forEach(System.out::println);
    }

}

//Atualiza professorDAO

package org.senai;

import org.senai.dao.ProfessorDAO;
import org.senai.model.Professor;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProfessorDAO professorDAO = new ProfessorDAO();

        List<Professor> profesores = professorDAO.listarTodos();
        Professor prof = profesores.getFirst();

        prof.setNome("Maria");
        prof.setDepartamento("Portu");
        prof.setEmail("maria@tudocerto.com");

        professorDAO.atualizar(prof);

        System.out.println(professorDAO.buscarPorId(prof.getId()));
    }
}
//Consultas Main(EstudanteDao):

//Código inserir estudante.

package org.senai;

import org.senai.dao.EstudanteDAO;
import org.senai.model.Estudante;

public class Main {
    public static void main(String[] args) {

        EstudanteDAO estudanteDAO = new EstudanteDAO();

        Estudante estudante = new Estudante(
                0,
                "Omar Jose",
                "Omar@universidades.com",
                "12345");

        estudanteDAO.inserir(estudante);

        System.out.println("Estudante inserido: " + estudante);
    }
}

//Código buscar estudante por ID:

package org.senai;

import org.senai.dao.EstudanteDAO;

public class Main {
    public static void main(String[] args) {

        EstudanteDAO estudanteDAO = new EstudanteDAO();

        System.out.println(estudanteDAO.buscarPorId(11));
    }
}

//Código listar estudantes:

package org.senai;

import org.senai.dao.EstudanteDAO;
import org.senai.model.Estudante;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EstudanteDAO estudanteDAO = new EstudanteDAO();
        List<Estudante> estudante = estudanteDAO.listarTodos();
        estudante.forEach(System.out::println);
    }
}

//Código atualizar estudante:

package org.senai;

import org.senai.dao.EstudanteDAO;
import org.senai.model.Estudante;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EstudanteDAO estudanteDAO = new EstudanteDAO();

        List<Estudante> estudantes = estudanteDAO.listarTodos();
        Estudante estudante = estudantes.getFirst();

        estudante.setNome("Juana");
        estudante.setEmail("juana@tudocerto.com");
        estudante.setMatricula("12345679");

        estudanteDAO.atualizar(estudante);

        System.out.println(estudanteDAO.buscarPorId(estudante.getId()));
    }
}

//Código deletar estudante:

package org.senai;

import org.senai.dao.EstudanteDAO;

public class Main {
    public static void main(String[] args) {

        EstudanteDAO estudanteDAO = new EstudanteDAO();

        int id = 9;

        estudanteDAO.deletar(id);

        System.out.println("Estudante deletado com sucesso!");
    }
}

