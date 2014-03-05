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
  `id_area` bigint(20) NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_area`
--

/*!40000 ALTER TABLE `ieadam_area` DISABLE KEYS */;
INSERT INTO `ieadam_area` (`id_area`,`data_ultima_atualizacao`,`nome`,`situacao`,`id_nucleo`,`id_membro`,`id`,`nucleo`,`pastor`) VALUES 
 (1,NULL,'AREA 1','1',1,11,0,NULL,NULL),
 (2,NULL,'AREA 2','1',2,12,0,NULL,NULL),
 (3,NULL,'AREA 3','1',2,12,0,NULL,NULL);
/*!40000 ALTER TABLE `ieadam_area` ENABLE KEYS */;


--
-- Definition of table `ieadam_cidade`
--

DROP TABLE IF EXISTS `ieadam_cidade`;
CREATE TABLE `ieadam_cidade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `uf` varchar(255) DEFAULT NULL,
  `data_ult_atu` datetime DEFAULT NULL,
  `ind_situacao` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_cidade`
--

/*!40000 ALTER TABLE `ieadam_cidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `ieadam_cidade` ENABLE KEYS */;


--
-- Definition of table `ieadam_congregacao`
--

DROP TABLE IF EXISTS `ieadam_congregacao`;
CREATE TABLE `ieadam_congregacao` (
  `id_congregacao` bigint(20) NOT NULL AUTO_INCREMENT,
  `bairro` varchar(60) NOT NULL,
  `cep` varchar(8) DEFAULT NULL,
  `data_cadastro` date DEFAULT NULL,
  `data_fundacao` date DEFAULT NULL,
  `data_ultima_atualizacao` date DEFAULT NULL,
  `endereco` varchar(60) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `situacao` char(1) NOT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `id_area` bigint(20) NOT NULL,
  `cidade` varchar(60) NOT NULL,
  `id` int(11) NOT NULL,
  `area` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_congregacao`),
  KEY `FK_sedg9bm0l7hij9t49c0mpju8k` (`id_area`),
  CONSTRAINT `FK_sedg9bm0l7hij9t49c0mpju8k` FOREIGN KEY (`id_area`) REFERENCES `ieadam_area` (`id_area`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_congregacao`
--

/*!40000 ALTER TABLE `ieadam_congregacao` DISABLE KEYS */;
INSERT INTO `ieadam_congregacao` (`id_congregacao`,`bairro`,`cep`,`data_cadastro`,`data_fundacao`,`data_ultima_atualizacao`,`endereco`,`nome`,`situacao`,`telefone`,`id_area`,`cidade`,`id`,`area`) VALUES 
 (1,'1111','11111',NULL,NULL,NULL,'1111','1111','1','1111',1,'11111',0,NULL);
/*!40000 ALTER TABLE `ieadam_congregacao` ENABLE KEYS */;


--
-- Definition of table `ieadam_funcao`
--

DROP TABLE IF EXISTS `ieadam_funcao`;
CREATE TABLE `ieadam_funcao` (
  `id_funcao` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_ultima_atualizacao` date DEFAULT NULL,
  `descricao` varchar(60) NOT NULL,
  `situacao` char(1) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id_funcao`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_funcao`
--

/*!40000 ALTER TABLE `ieadam_funcao` DISABLE KEYS */;
INSERT INTO `ieadam_funcao` (`id_funcao`,`data_ultima_atualizacao`,`descricao`,`situacao`,`id`) VALUES 
 (1,NULL,'22','1',0);
/*!40000 ALTER TABLE `ieadam_funcao` ENABLE KEYS */;


--
-- Definition of table `ieadam_membro`
--

DROP TABLE IF EXISTS `ieadam_membro`;
CREATE TABLE `ieadam_membro` (
  `id_membro` bigint(20) NOT NULL AUTO_INCREMENT,
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
  `fatorrh` char(3) NOT NULL,
  `formacao_teologico` varchar(60) DEFAULT NULL,
  `nacionalidade` varchar(60) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `nome_mae` varchar(60) DEFAULT NULL,
  `nome_pai` varchar(60) DEFAULT NULL,
  `procedencia` varchar(60) DEFAULT NULL,
  `qtde_filhos` int(11) DEFAULT NULL,
  `rg` varchar(10) DEFAULT NULL,
  `rg_orgao_emissor` varchar(10) DEFAULT NULL,
  `sexo` char(1) NOT NULL,
  `situacao` char(1) NOT NULL,
  `telefone` varchar(40) DEFAULT NULL,
  `titulo_eleitor` varchar(10) DEFAULT NULL,
  `titulo_secao` varchar(6) DEFAULT NULL,
  `titulo_zona` varchar(10) DEFAULT NULL,
  `uf` varchar(2) NOT NULL,
  `id_congregacao` bigint(20) NOT NULL,
  `id_funcao` bigint(20) NOT NULL,
  `cidade` varchar(60) DEFAULT NULL,
  `fator_rh` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_membro`),
  KEY `FK_ey8cd94hrolqg38kesplym5e1` (`id_congregacao`),
  KEY `FK_qt9ap98s6d89r8wremafgyopp` (`id_funcao`),
  CONSTRAINT `FK_ey8cd94hrolqg38kesplym5e1` FOREIGN KEY (`id_congregacao`) REFERENCES `ieadam_congregacao` (`id_congregacao`),
  CONSTRAINT `FK_qt9ap98s6d89r8wremafgyopp` FOREIGN KEY (`id_funcao`) REFERENCES `ieadam_funcao` (`id_funcao`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_membro`
--

/*!40000 ALTER TABLE `ieadam_membro` DISABLE KEYS */;
INSERT INTO `ieadam_membro` (`id_membro`,`cep`,`cert_casamento`,`conjuge`,`cpf`,`data_bat_espirito`,`data_batismo`,`data_cadastro`,`data_decisao`,`data_nascimento`,`data_recebimento`,`email`,`endereco`,`estado_civil`,`fatorrh`,`formacao_teologico`,`nacionalidade`,`nome`,`nome_mae`,`nome_pai`,`procedencia`,`qtde_filhos`,`rg`,`rg_orgao_emissor`,`sexo`,`situacao`,`telefone`,`titulo_eleitor`,`titulo_secao`,`titulo_zona`,`uf`,`id_congregacao`,`id_funcao`,`cidade`,`fator_rh`) VALUES 
 (2,'1',NULL,'1','11',NULL,NULL,NULL,NULL,NULL,NULL,'111','111','SO','O+','UUU','UUU','UUUU','UUU','UUU','UUU',7,'7777','777','M','1','888888','88888','888','8888','AM',1,1,'11111',NULL),
 (3,'2','2','2','2',NULL,NULL,NULL,NULL,NULL,NULL,'2','2','SO','O+','TT','66666','CLAUDEMIR RAMOS FERREIRA','TTT','TTTT','TTTT',5,'5','5','M','1','77','77','77','77','AM',1,1,'1111',NULL),
 (4,'3','3','3','3',NULL,NULL,NULL,NULL,NULL,NULL,'3','3','SO','O+','888','888','ELIMARCOS','88','888','888',8,'8','8','M','1','9999','999','9999','9999','AM',1,1,'7777771',NULL),
 (5,'1',NULL,'1','11',NULL,NULL,NULL,NULL,NULL,NULL,'111','111','SO','O+','UUU','UUU','MEMBRO 4','UUU','UUU','UUU',7,'7777','777','M','1','888888','88888','888','8888','AM',1,1,'11111',NULL),
 (6,'2','2','2','2',NULL,NULL,NULL,NULL,NULL,NULL,'2','2','SO','O+','TT','66666','MEMBRO 5','TTT','TTTT','TTTT',5,'5','5','M','1','77','77','77','77','AM',1,1,'1111',NULL),
 (7,'3','3','3','3',NULL,NULL,NULL,NULL,NULL,NULL,'3','3','SO','O+','888','888','MEMBRO 6','88','888','888',8,'8','8','M','1','9999','999','9999','9999','AM',1,1,'7777771',NULL),
 (8,'1',NULL,'1','11',NULL,NULL,NULL,NULL,NULL,NULL,'111','111','SO','O+','UUU','UUU','MEMBRO 7','UUU','UUU','UUU',7,'7777','777','M','1','888888','88888','888','8888','AM',1,1,'11111',NULL),
 (9,'2','2','2','2',NULL,NULL,NULL,NULL,NULL,NULL,'2','2','SO','O+','TT','66666','MEMBRO 8','TTT','TTTT','TTTT',5,'5','5','M','1','77','77','77','77','AM',1,1,'1111',NULL),
 (10,'3','3','3','3',NULL,NULL,NULL,NULL,NULL,NULL,'3','3','SO','O+','888','888','MEMBRO 9','88','888','888',8,'8','8','M','1','9999','999','9999','9999','AM',1,1,'7777771',NULL),
 (11,'1',NULL,'1','11',NULL,NULL,NULL,NULL,NULL,NULL,'111','111','SO','O+','UUU','UUU','MEMBRO 10','UUU','UUU','UUU',7,'7777','777','M','1','888888','88888','888','8888','AM',1,1,'11111',NULL),
 (12,'2','2','2','2',NULL,NULL,NULL,NULL,NULL,NULL,'2','2','SO','O+','TT','66666','MEMBRO 11','TTT','TTTT','TTTT',5,'5','5','M','1','77','77','77','77','AM',1,1,'1111',NULL),
 (13,'3','3','3','3',NULL,NULL,NULL,NULL,NULL,NULL,'3','3','SO','O+','888','888','MEMBRO 13','88','888','888',8,'8','8','M','1','9999','999','9999','9999','AM',1,1,'7777771',NULL);
/*!40000 ALTER TABLE `ieadam_membro` ENABLE KEYS */;


--
-- Definition of table `ieadam_nucleo`
--

DROP TABLE IF EXISTS `ieadam_nucleo`;
CREATE TABLE `ieadam_nucleo` (
  `id_nucleo` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_ultima_atualizacao` date DEFAULT NULL,
  `nome` varchar(60) NOT NULL,
  `situacao` char(1) NOT NULL,
  `id_zona` bigint(20) NOT NULL,
  `id_membro` bigint(20) NOT NULL,
  `id` int(11) NOT NULL,
  `coordenador` int(11) DEFAULT NULL,
  `zona` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_nucleo`),
  KEY `FK_neghkrgnkjr9gp4rsaocjs132` (`id_zona`),
  KEY `FK_8b3s8x6sdsvwpq4u10s74f6pw` (`id_membro`),
  CONSTRAINT `FK_8b3s8x6sdsvwpq4u10s74f6pw` FOREIGN KEY (`id_membro`) REFERENCES `ieadam_membro` (`id_membro`),
  CONSTRAINT `FK_neghkrgnkjr9gp4rsaocjs132` FOREIGN KEY (`id_zona`) REFERENCES `ieadam_zona` (`id_zona`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_nucleo`
--

/*!40000 ALTER TABLE `ieadam_nucleo` DISABLE KEYS */;
INSERT INTO `ieadam_nucleo` (`id_nucleo`,`data_ultima_atualizacao`,`nome`,`situacao`,`id_zona`,`id_membro`,`id`,`coordenador`,`zona`) VALUES 
 (1,NULL,'NUCLEO 1','1',1,5,0,NULL,NULL),
 (2,NULL,'NUCLEO 2','1',1,6,0,NULL,NULL),
 (3,NULL,'NUCLEO 3','1',2,7,0,NULL,NULL),
 (4,NULL,'NUCLEO 4','1',2,8,0,NULL,NULL),
 (5,NULL,'NUCLEO 5','1',3,9,0,NULL,NULL),
 (6,NULL,'NUCLEO 6','1',3,10,0,NULL,NULL);
/*!40000 ALTER TABLE `ieadam_nucleo` ENABLE KEYS */;


--
-- Definition of table `ieadam_pastor`
--

DROP TABLE IF EXISTS `ieadam_pastor`;
CREATE TABLE `ieadam_pastor` (
  `id_pastor` bigint(20) NOT NULL AUTO_INCREMENT,
  `area` tinyint(1) DEFAULT NULL,
  `nome` varchar(60) NOT NULL,
  `nucleo` tinyint(1) DEFAULT NULL,
  `zona` tinyint(1) DEFAULT NULL,
  `id_membro` bigint(20) DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_pastor`),
  KEY `FK_mirs17ya4t5vmbtk76viae21n` (`id_membro`),
  KEY `FK_ptdwfl1759psooqf3633y3x56` (`id_usuario`),
  CONSTRAINT `FK_ptdwfl1759psooqf3633y3x56` FOREIGN KEY (`id_usuario`) REFERENCES `saa_usuario` (`id_usuario`),
  CONSTRAINT `FK_mirs17ya4t5vmbtk76viae21n` FOREIGN KEY (`id_membro`) REFERENCES `ieadam_membro` (`id_membro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_pastor`
--

/*!40000 ALTER TABLE `ieadam_pastor` DISABLE KEYS */;
/*!40000 ALTER TABLE `ieadam_pastor` ENABLE KEYS */;


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
-- Definition of table `ieadam_usuario`
--

DROP TABLE IF EXISTS `ieadam_usuario`;
CREATE TABLE `ieadam_usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `situacao` int(11) DEFAULT NULL,
  `membro` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_usuario`
--

/*!40000 ALTER TABLE `ieadam_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `ieadam_usuario` ENABLE KEYS */;


--
-- Definition of table `ieadam_zona`
--

DROP TABLE IF EXISTS `ieadam_zona`;
CREATE TABLE `ieadam_zona` (
  `id_zona` bigint(20) NOT NULL AUTO_INCREMENT,
  `cd_zona_argo` int(11) NOT NULL,
  `data_ultima_atualizacao` date DEFAULT NULL,
  `nome` varchar(60) NOT NULL,
  `situacao` char(1) NOT NULL,
  `id_primeiro_resp` bigint(20) DEFAULT NULL,
  `id_segundo_resp` bigint(20) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `primeiro_responsavel` int(11) DEFAULT NULL,
  `segundo_responsavel` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_zona`),
  KEY `FK_l85o89am41oyb8kbk0pqeeft7` (`id_primeiro_resp`),
  KEY `FK_gyosd1uyx0prsw0hlo3kpbcsa` (`id_segundo_resp`),
  CONSTRAINT `FK_gyosd1uyx0prsw0hlo3kpbcsa` FOREIGN KEY (`id_segundo_resp`) REFERENCES `ieadam_membro` (`id_membro`),
  CONSTRAINT `FK_l85o89am41oyb8kbk0pqeeft7` FOREIGN KEY (`id_primeiro_resp`) REFERENCES `ieadam_membro` (`id_membro`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_zona`
--

/*!40000 ALTER TABLE `ieadam_zona` DISABLE KEYS */;
INSERT INTO `ieadam_zona` (`id_zona`,`cd_zona_argo`,`data_ultima_atualizacao`,`nome`,`situacao`,`id_primeiro_resp`,`id_segundo_resp`,`id`,`primeiro_responsavel`,`segundo_responsavel`) VALUES 
 (1,111,NULL,'ZONA 1','1',2,NULL,0,NULL,NULL),
 (2,2,NULL,'ZONA 2','1',3,NULL,0,NULL,NULL),
 (3,3,NULL,'ZONA 3','1',4,NULL,0,NULL,NULL),
 (4,1,NULL,'ADMINISTRADOR','A',NULL,NULL,0,NULL,NULL),
 (5,1,NULL,'ADMINISTRADOR','A',NULL,NULL,0,NULL,NULL);
/*!40000 ALTER TABLE `ieadam_zona` ENABLE KEYS */;


--
-- Definition of table `post`
--

DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `post_date` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `post`
--

/*!40000 ALTER TABLE `post` DISABLE KEYS */;
/*!40000 ALTER TABLE `post` ENABLE KEYS */;


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
-- Dumping data for table `saa_perfil`
--

/*!40000 ALTER TABLE `saa_perfil` DISABLE KEYS */;
INSERT INTO `saa_perfil` (`id_perfil`,`imagem`,`nome`,`id_sistema`) VALUES 
 (1,'resources/imagens/perfil/secretaria.png','SECRETARIA',2),
 (2,'resources/imagens/perfil/tesouraria.png','TESOURARIA',2),
 (3,'resources/imagens/perfil/administrativo.png','ADMINISTRATIVO',2),
 (4,'resources/imagens/perfil/configuracao.png','CONFIGURAÇÃO',2),
 (5,'Perfil Teste','Perfil Teste',3);
/*!40000 ALTER TABLE `saa_perfil` ENABLE KEYS */;


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
-- Dumping data for table `saa_perfil_rotina`
--

/*!40000 ALTER TABLE `saa_perfil_rotina` DISABLE KEYS */;
INSERT INTO `saa_perfil_rotina` (`data`,`id_perfil`,`id_rotina`) VALUES 
 (NULL,1,10),
 (NULL,1,11),
 (NULL,1,12),
 (NULL,1,13),
 (NULL,2,1),
 (NULL,2,2),
 (NULL,2,3),
 (NULL,2,4),
 (NULL,2,6),
 (NULL,2,10),
 (NULL,3,7),
 (NULL,3,8),
 (NULL,4,9),
 (NULL,4,14),
 (NULL,4,15),
 (NULL,4,16);
/*!40000 ALTER TABLE `saa_perfil_rotina` ENABLE KEYS */;


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
-- Dumping data for table `saa_rotina`
--

/*!40000 ALTER TABLE `saa_rotina` DISABLE KEYS */;
INSERT INTO `saa_rotina` (`id_rotina`,`acao`,`imagem`,`nome`,`status`,`id_sistema`) VALUES 
 (1,'relatorioSaldoCongregacao.init','resources/imagens/rotina/banknote.png','SALDO DA CONGREGAÇÃO',0,2),
 (2,'relatorioProventoPastoral.init','resources/imagens/rotina/bar_chart.png','PROVENTO PASTORAL',0,2),
 (3,'relatorioDebitoFinanceiro.init','resources/imagens/rotina/calculator.png','DÉBITO FINANCEIRO',0,2),
 (4,'relatorioCentoCusto.init','resources/imagens/rotina/cash_register.png','CENTRO DE CUSTO',0,2),
 (5,'relatorioNadaConsta.init','resources/imagens/rotina/coins.png','NADA CONSTA',0,2),
 (6,'relatorioSaldoDepartamento.init','resources/imagens/rotina/credit_card.png','SALDO DEPARTAMENTAL',0,2),
 (7,'relatorioBalanceteAnalitico.init','resources/imagens/rotina/gold_bullion.png','BALANCETE ANALITICO',0,2),
 (8,'relatorioBalanceteSintetico.init','resources/imagens/rotina/invoice.png','BALANCETE SINTÉTICO',0,2),
 (9,'usuarioControlador.init','resources/imagens/rotina/invoice.png','CADASTRO DE MEMBROS',0,2),
 (10,'relatorioDebitoPastoral.init','resources/imagens/rotina/invoice.png','DÉBITO PASTORAL',0,2),
 (11,'relatorioEstatistico.init','resources/imagens/rotina/gold_bullion.png','ESTATISTICO',0,2),
 (12,'relatorioDebitoSecretaria.init','resources/imagens/rotina/credit_card.png','DÉBITO SECRETARIA',0,2),
 (13,'relatorioMembro.init','resources/imagens/rotina/credit_card.png','MEMBROS',0,2),
 (14,'rotinaControlador.init','resources/imagens/rotina/credit_card.png','CADASTRO DE ROTINAS',0,2),
 (15,'perfilControlador.init','resources/imagens/rotina/gold_bullion.png','CADASTRO DE PERFIL',0,2),
 (16,'usuarioControlador.init','resources/imagens/rotina/gold_bullion.png','CADASTRO DE USUARIO',0,2);
/*!40000 ALTER TABLE `saa_rotina` ENABLE KEYS */;


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
-- Dumping data for table `saa_sistema`
--

/*!40000 ALTER TABLE `saa_sistema` DISABLE KEYS */;
INSERT INTO `saa_sistema` (`id_sistema`,`codigo`,`descricao`,`imagem`,`nome`) VALUES 
 (1,'SAA','SISTEMA DE AUTENTICAÇÃO E AUTORIZAÇÃO','IIII','SISTEMA DE AUTENTICAÇÃO E AUTORIZAÇÃO'),
 (2,'IEADAM','SISTEMA DE EMISSÃO DE RELATORIO','III','SISTEMA DE EMISSÃO DE RELATORIO'),
 (3,'SISTST','Sistema Teste','Sistema Teste','Sistema Teste');
/*!40000 ALTER TABLE `saa_sistema` ENABLE KEYS */;


--
-- Definition of table `saa_usuario`
--

DROP TABLE IF EXISTS `saa_usuario`;
CREATE TABLE `saa_usuario` (
  `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(30) DEFAULT NULL,
  `nome` varchar(30) NOT NULL,
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
-- Dumping data for table `saa_usuario`
--

/*!40000 ALTER TABLE `saa_usuario` DISABLE KEYS */;
INSERT INTO `saa_usuario` (`id_usuario`,`login`,`nome`,`senha`,`status`,`area`,`nucleo`,`zona`,`id_membro`) VALUES 
 (1,'admin','ADMINISTRADOR DO SISTEMA','admin','A',1,1,1,2),
 (2,'zona','ZONA ','','A',0,0,0,3),
 (4,'nucleo','nucleo ','','A',1,1,1,4),
 (5,'area','area ','','A',1,0,0,5),
 (6,'Usuario Teste','Usuario Teste','teste','A',0,0,0,6);
/*!40000 ALTER TABLE `saa_usuario` ENABLE KEYS */;


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

--
-- Dumping data for table `saa_usuario_perfil`
--

/*!40000 ALTER TABLE `saa_usuario_perfil` DISABLE KEYS */;
INSERT INTO `saa_usuario_perfil` (`data`,`id_perfil`,`id_usuario`) VALUES 
 (NULL,1,1),
 (NULL,2,1),
 (NULL,3,1),
 (NULL,4,1),
 ('2014-02-24 22:13:32',5,6);
/*!40000 ALTER TABLE `saa_usuario_perfil` ENABLE KEYS */;


--
-- Definition of table `usuario_perfil`
--

DROP TABLE IF EXISTS `usuario_perfil`;
CREATE TABLE `usuario_perfil` (
  `id_usuario` int(11) NOT NULL,
  `id_perfil` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_perfil`),
  KEY `FK_fp4srv5mbiqyc9cfb7dvucbiq` (`id_perfil`),
  KEY `FK_g6mv5dao2a6xlg6c0wcx1im4o` (`id_usuario`),
  CONSTRAINT `FK_g6mv5dao2a6xlg6c0wcx1im4o` FOREIGN KEY (`id_usuario`) REFERENCES `ieadam_usuario` (`id`),
  CONSTRAINT `FK_fp4srv5mbiqyc9cfb7dvucbiq` FOREIGN KEY (`id_perfil`) REFERENCES `ieadam_perfil` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario_perfil`
--

/*!40000 ALTER TABLE `usuario_perfil` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_perfil` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
