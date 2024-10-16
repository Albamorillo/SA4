-- Criar tabela de pessoas
CREATE TABLE pessoas (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL UNIQUE
);

-- Criar tabela de professor
CREATE TABLE professores (
    pessoa_id INT PRIMARY KEY,
    departamento VARCHAR(100) NOT NULL,
    FOREIGN KEY (pessoa_id) REFERENCES pessoas(id)
);

-- Criar tabela de estudantes
CREATE TABLE estudantes (
    pessoa_id INT PRIMARY KEY,
    matricula VARCHAR(50) NOT NULL UNIQUE,
    FOREIGN KEY (pessoa_id) REFERENCES pessoas(id)
);