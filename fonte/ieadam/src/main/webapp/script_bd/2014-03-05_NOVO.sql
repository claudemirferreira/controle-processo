-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.36


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema sgr
--

CREATE DATABASE IF NOT EXISTS sgr;
USE sgr;

--
-- Definition of table `ieadam_area`
--

DROP TABLE IF EXISTS `ieadam_area`;
CREATE TABLE `ieadam_area` (
  `id_area` bigint(20) NOT NULL,
  `data_ultima_atualizacao` date DEFAULT NULL,
  `nome` varchar(60) NOT NULL,
  `situacao` char(1) NOT NULL,
  `id_nucleo` bigint(20) NOT NULL,
  `id_membro` bigint(20) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `nucleo` int(11) DEFAULT NULL,
  `pastor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_area`),
  KEY `FK_heafiodiodfp1d8it6lputiu` (`id_nucleo`),
  KEY `FK_l41diku8ic3tavviqtgxrmkha` (`id_membro`),
  CONSTRAINT `FK_heafiodiodfp1d8it6lputiu` FOREIGN KEY (`id_nucleo`) REFERENCES `ieadam_nucleo` (`id_nucleo`),
  CONSTRAINT `FK_l41diku8ic3tavviqtgxrmkha` FOREIGN KEY (`id_membro`) REFERENCES `ieadam_membro` (`id_membro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Definition of table `ieadam_congregacao`
--

DROP TABLE IF EXISTS `ieadam_congregacao`;
CREATE TABLE `ieadam_congregacao` (
  `id_congregacao` bigint(20) NOT NULL,
  `bairro` varchar(60) DEFAULT NULL,
  `cep` varchar(8) DEFAULT NULL,
  `data_cadastro` date DEFAULT NULL,
  `data_fundacao` date DEFAULT NULL,
  `data_ultima_atualizacao` date DEFAULT NULL,
  `endereco` varchar(60) DEFAULT NULL,
  `nome` varchar(60) DEFAULT NULL,
  `situacao` char(1) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `id_area` bigint(20) NOT NULL,
  `cidade` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id_congregacao`),
  KEY `FK_sedg9bm0l7hij9t49c0mpju8k` (`id_area`),
  CONSTRAINT `FK_sedg9bm0l7hij9t49c0mpju8k` FOREIGN KEY (`id_area`) REFERENCES `ieadam_area` (`id_area`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Definition of table `ieadam_membro`
--

DROP TABLE IF EXISTS `ieadam_membro`;
CREATE TABLE `ieadam_membro` (
  `id_membro` bigint(20) NOT NULL,
  `cep` varchar(8) DEFAULT NULL,
  `cert_casamento` varchar(10) DEFAULT NULL,
  `conjuge` varchar(60) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `data_bat_espirito` date DEFAULT NULL,
  `data_batismo` date DEFAULT NULL,
  `data_cadastro` date DEFAULT NULL,
  `data_decisao` date DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `data_recebimento` date DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `endereco` varchar(60) DEFAULT NULL,
  `estado_civil` varchar(255) DEFAULT NULL,
  `fatorrh` char(3) DEFAULT NULL,
  `formacao_teologico` varchar(60) DEFAULT NULL,
  `nacionalidade` varchar(60) DEFAULT NULL,
  `nome` varchar(60) NOT NULL,
  `nome_mae` varchar(60) DEFAULT NULL,
  `nome_pai` varchar(60) DEFAULT NULL,
  `procedencia` varchar(60) DEFAULT NULL,
  `qtde_filhos` int(11) DEFAULT NULL,
  `rg` varchar(10) DEFAULT NULL,
  `rg_orgao_emissor` varchar(10) DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `situacao` char(1) NOT NULL,
  `telefone` varchar(40) DEFAULT NULL,
  `titulo_eleitor` varchar(10) DEFAULT NULL,
  `titulo_secao` varchar(6) DEFAULT NULL,
  `titulo_zona` varchar(10) DEFAULT NULL,
  `uf` varchar(2) DEFAULT NULL,
  `id_congregacao` bigint(20) DEFAULT NULL,
  `funcao` varchar(50) DEFAULT NULL,
  `cidade` varchar(60) DEFAULT NULL,
  `fator_rh` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_membro`),
  KEY `FK_ey8cd94hrolqg38kesplym5e1` (`id_congregacao`),
  CONSTRAINT `FK_ey8cd94hrolqg38kesplym5e1` FOREIGN KEY (`id_congregacao`) REFERENCES `ieadam_congregacao` (`id_congregacao`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Definition of table `ieadam_nucleo`
--

DROP TABLE IF EXISTS `ieadam_nucleo`;
CREATE TABLE `ieadam_nucleo` (
  `id_nucleo` bigint(20) NOT NULL,
  `data_ultima_atualizacao` date DEFAULT NULL,
  `nome` varchar(60) DEFAULT NULL,
  `situacao` char(1) NOT NULL,
  `id_zona` bigint(20) NOT NULL,
  `id_coordenador` int(11) NOT NULL,
  `id_zona` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_nucleo`),
  KEY `FK_neghkrgnkjr9gp4rsaocjs132` (`id_zona`),
  KEY `FK_8b3s8x6sdsvwpq4u10s74f6pw` (`id_coordenador`),
  CONSTRAINT `FK_8b3s8x6sdsvwpq4u10s74f6pw` FOREIGN KEY (`id_coordenador`) REFERENCES `ieadam_membro` (`id_membro`),
  CONSTRAINT `FK_neghkrgnkjr9gp4rsaocjs132` FOREIGN KEY (`id_zona`) REFERENCES `ieadam_zona` (`id_zona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Definition of table `ieadam_perfil`
--

DROP TABLE IF EXISTS `ieadam_perfil`;
CREATE TABLE `ieadam_perfil` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_perfil`
--

/*!40000 ALTER TABLE `ieadam_perfil` DISABLE KEYS */;
/*!40000 ALTER TABLE `ieadam_perfil` ENABLE KEYS */;

--
-- Definition of table `ieadam_zona`
--

DROP TABLE IF EXISTS `ieadam_zona`;
CREATE TABLE `ieadam_zona` (
  `id_zona` bigint(20) NOT NULL,
  `data_ultima_atualizacao` date DEFAULT NULL,
  `nome` varchar(60) DEFAULT NULL,
  `situacao` char(1) NOT NULL,
  `id_primeiro_resp` bigint(20) DEFAULT NULL,
  `id_segundo_resp` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_zona`),
  KEY `FK_l85o89am41oyb8kbk0pqeeft7` (`id_primeiro_resp`),
  KEY `FK_gyosd1uyx0prsw0hlo3kpbcsa` (`id_segundo_resp`),
  CONSTRAINT `FK_gyosd1uyx0prsw0hlo3kpbcsa` FOREIGN KEY (`id_segundo_resp`) REFERENCES `ieadam_membro` (`id_membro`),
  CONSTRAINT `FK_l85o89am41oyb8kbk0pqeeft7` FOREIGN KEY (`id_primeiro_resp`) REFERENCES `ieadam_membro` (`id_membro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Definition of table `saa_perfil`
--

DROP TABLE IF EXISTS `saa_perfil`;
CREATE TABLE `saa_perfil` (
  `id_perfil` bigint(20) NOT NULL AUTO_INCREMENT,
  `imagem` varchar(60) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `id_sistema` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_perfil`),
  KEY `FK_4hy4snh41hywvhfpa8omdlnqm` (`id_sistema`),
  CONSTRAINT `FK_4hy4snh41hywvhfpa8omdlnqm` FOREIGN KEY (`id_sistema`) REFERENCES `saa_sistema` (`id_sistema`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Definition of table `saa_perfil_rotina`
--

DROP TABLE IF EXISTS `saa_perfil_rotina`;
CREATE TABLE `saa_perfil_rotina` (
  `data` datetime DEFAULT NULL,
  `id_perfil` bigint(20) NOT NULL DEFAULT '0',
  `id_rotina` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_perfil`,`id_rotina`),
  KEY `FK_kh4c63uwlsyajnqj66sv6btu5` (`id_perfil`),
  KEY `FK_4ey8g8nxrvbs411mm26qda1bf` (`id_rotina`),
  CONSTRAINT `FK_4ey8g8nxrvbs411mm26qda1bf` FOREIGN KEY (`id_rotina`) REFERENCES `saa_rotina` (`id_rotina`),
  CONSTRAINT `FK_kh4c63uwlsyajnqj66sv6btu5` FOREIGN KEY (`id_perfil`) REFERENCES `saa_perfil` (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Definition of table `saa_rotina`
--

DROP TABLE IF EXISTS `saa_rotina`;
CREATE TABLE `saa_rotina` (
  `id_rotina` bigint(20) NOT NULL AUTO_INCREMENT,
  `acao` varchar(100) NOT NULL,
  `imagem` varchar(100) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `id_sistema` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_rotina`),
  KEY `FK_54mvu1oxkbqkwg0ifkj9867ar` (`id_sistema`),
  CONSTRAINT `FK_54mvu1oxkbqkwg0ifkj9867ar` FOREIGN KEY (`id_sistema`) REFERENCES `saa_sistema` (`id_sistema`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Definition of table `saa_sistema`
--

DROP TABLE IF EXISTS `saa_sistema`;
CREATE TABLE `saa_sistema` (
  `id_sistema` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(6) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `imagem` varchar(100) NOT NULL,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id_sistema`),
  UNIQUE KEY `UK_ghac1kmyt6ytqt8bxwmxy0dfb` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Definition of table `saa_usuario`
--

DROP TABLE IF EXISTS `saa_usuario`;
CREATE TABLE `saa_usuario` (
  `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(30) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `status` char(1) NOT NULL,
  `area` tinyint(1) DEFAULT NULL,
  `nucleo` tinyint(1) DEFAULT NULL,
  `zona` tinyint(1) DEFAULT NULL,
  `id_membro` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `UK_ckrgsi99ta2s36tkydejud4wy` (`login`),
  KEY `FK_b3rhxokdblq7r0odmdbker692` (`id_membro`),
  CONSTRAINT `FK_b3rhxokdblq7r0odmdbker692` FOREIGN KEY (`id_membro`) REFERENCES `ieadam_membro` (`id_membro`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Definition of table `saa_usuario_perfil`
--

DROP TABLE IF EXISTS `saa_usuario_perfil`;
CREATE TABLE `saa_usuario_perfil` (
  `data` datetime DEFAULT NULL,
  `id_perfil` bigint(20) NOT NULL DEFAULT '0',
  `id_usuario` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_perfil`,`id_usuario`),
  KEY `FK_fpjsxglutlk7m5aho59hito8q` (`id_perfil`),
  KEY `FK_ooqm83bohskwfg89ng9g3kgra` (`id_usuario`),
  CONSTRAINT `FK_fpjsxglutlk7m5aho59hito8q` FOREIGN KEY (`id_perfil`) REFERENCES `saa_perfil` (`id_perfil`),
  CONSTRAINT `FK_ooqm83bohskwfg89ng9g3kgra` FOREIGN KEY (`id_usuario`) REFERENCES `saa_usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;