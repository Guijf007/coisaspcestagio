-- phpMyAdmin SQL Dump
-- version 5.2.1deb3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Tempo de geração: 06/05/2025 às 17:13
-- Versão do servidor: 10.11.11-MariaDB-0ubuntu0.24.04.2
-- Versão do PHP: 8.3.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `funcionario`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `vt` tinyint(1) NOT NULL,
  `dep14` int(11) NOT NULL,
  `depir` int(11) NOT NULL,
  `salbase` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `funcionario`
--

INSERT INTO `funcionario` (`id`, `nome`, `vt`, `dep14`, `depir`, `salbase`) VALUES
(4, 'aa', 0, 0, 0, 2600);

-- --------------------------------------------------------

--
-- Estrutura para tabela `tabelas`
--

CREATE TABLE `tabelas` (
  `id` int(11) NOT NULL,
  `tinss1` double NOT NULL,
  `ainss1` double NOT NULL,
  `tinss2` double NOT NULL,
  `ainss2` double NOT NULL,
  `tinss3` double NOT NULL,
  `ainss3` double NOT NULL,
  `tinss4` double NOT NULL,
  `ainss4` double NOT NULL,
  `tsf` double NOT NULL,
  `vsf` double NOT NULL,
  `tirrf1` double NOT NULL,
  `tirrf2` double NOT NULL,
  `airrf2` double NOT NULL,
  `dirrf2` double NOT NULL,
  `tirrf3` double NOT NULL,
  `airrf3` double NOT NULL,
  `dirrf3` double NOT NULL,
  `tirrf4` double NOT NULL,
  `airrf4` double NOT NULL,
  `dirrf4` double NOT NULL,
  `airrf5` double NOT NULL,
  `dirrf5` double NOT NULL,
  `dedpdep` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tabelas`
--

INSERT INTO `tabelas` (`id`, `tinss1`, `ainss1`, `tinss2`, `ainss2`, `tinss3`, `ainss3`, `tinss4`, `ainss4`, `tsf`, `vsf`, `tirrf1`, `tirrf2`, `airrf2`, `dirrf2`, `tirrf3`, `airrf3`, `dirrf3`, `tirrf4`, `airrf4`, `dirrf4`, `airrf5`, `dirrf5`, `dedpdep`) VALUES
(1, 1518, 7.5, 2793.88, 9, 4190.83, 12, 8157.41, 14, 1906.04, 65, 2259.2, 2826.65, 7.5, 169.44, 3751.05, 15, 381.44, 4464.68, 22.5, 662.77, 27.5, 896, 189.59);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `tabelas`
--
ALTER TABLE `tabelas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `tabelas`
--
ALTER TABLE `tabelas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
