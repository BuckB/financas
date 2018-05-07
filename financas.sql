CREATE DATABASE IF NOT EXISTS financas
  CHARACTER SET UTF8
  COLLATE utf8_general_ci;

USE financas;

--
-- Tabela de Contas
--

CREATE TABLE IF NOT EXISTS Conta
(
  id      INT AUTO_INCREMENT PRIMARY KEY,
  agencia VARCHAR(255) NULL,
  banco   VARCHAR(255) NULL,
  numero  VARCHAR(255) NULL,
  titular VARCHAR(255) NULL
);

--
-- Tabela de Movimentações Financeiras
--

CREATE TABLE IF NOT EXISTS Movimentacao
(
  id        INT          NOT NULL PRIMARY KEY,
  valor     decimal      NULL,
  descricao VARCHAR(255) NULL,
  data      date         NULL,
  tipo      VARCHAR(255) NULL,
  contaID   INT          NOT NULL,
  constraint contaID
  foreign key (contaID) references Conta (id)
);

CREATE INDEX contaID
  on Movimentacao (contaID);
