
INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@email.com', '$2a$10$Qzlvk62L6dy2Y4TYovz.8uJZ9sNlmefhUVS.z6l/pqwpXBqLDmMPy');
INSERT INTO USUARIO(nome, email, senha) VALUES('Professor', 'professor@email.com', '$2a$10$Qzlvk62L6dy2Y4TYovz.8uJZ9sNlmefhUVS.z6l/pqwpXBqLDmMPy');

INSERT INTO CURSO(nome, categoria) VALUES('Spring Boot', 'Programa��o');
INSERT INTO CURSO(nome, categoria) VALUES('HTML 5', 'Front-end');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('D�vida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('D�vida 2', 'Projeto n�o compila', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('D�vida 3', 'Tag HTML', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);