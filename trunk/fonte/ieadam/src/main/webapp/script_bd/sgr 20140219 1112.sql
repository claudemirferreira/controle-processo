-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.37-community-nt


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
  `id` int(11) NOT NULL auto_increment,
  `data_ultima_atualizacao` date default NULL,
  `nome` varchar(60) NOT NULL,
  `situacao` char(1) NOT NULL,
  `nucleo_id` int(11) default NULL,
  `pastor_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `UK_13g18q06ik8htnbqdsnccmgjh` (`nucleo_id`),
  UNIQUE KEY `UK_nhb2dgpjpfjk4sjhvhl7flumm` (`pastor_id`),
  KEY `FK_13g18q06ik8htnbqdsnccmgjh` (`nucleo_id`),
  KEY `FK_nhb2dgpjpfjk4sjhvhl7flumm` (`pastor_id`),
  CONSTRAINT `FK_nhb2dgpjpfjk4sjhvhl7flumm` FOREIGN KEY (`pastor_id`) REFERENCES `ieadam_membro` (`id`),
  CONSTRAINT `FK_13g18q06ik8htnbqdsnccmgjh` FOREIGN KEY (`nucleo_id`) REFERENCES `ieadam_nucleo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ieadam_area`
--

/*!40000 ALTER TABLE `ieadam_area` DISABLE KEYS */;
/*!40000 ALTER TABLE `ieadam_area` ENABLE KEYS */;


--
-- Definition of table `ieadam_cidade`
--

DROP TABLE IF EXISTS `ieadam_cidade`;
CREATE TABLE `ieadam_cidade` (
  `id` int(11) NOT NULL auto_increment,
  `nome` varchar(60) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `data_ultima_atualizacao` datetime default NULL,
  `situacao` char(1) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `id` int(11) NOT NULL auto_increment,
  `bairro` varchar(60) NOT NULL,
  `cep` varchar(8) default NULL,
  `data_cadastro` date default NULL,
  `data_fundacao` date default NULL,
  `data_ultima_atualizacao` date default NULL,
  `endereco` varchar(60) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `situacao` char(1) NOT NULL,
  `telefone` varchar(30) default NULL,
  `area_id` int(11) default NULL,
  `cidade_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `UK_ifcrx9sc82agpy91ibi774jo4` (`area_id`),
  UNIQUE KEY `UK_ciunhejah852oxnefk5me9njs` (`cidade_id`),
  KEY `FK_ifcrx9sc82agpy91ibi774jo4` (`area_id`),
  KEY `FK_ciunhejah852oxnefk5me9njs` (`cidade_id`),
  CONSTRAINT `FK_ciunhejah852oxnefk5me9njs` FOREIGN KEY (`cidade_id`) REFERENCES `ieadam_cidade` (`id`),
  CONSTRAINT `FK_ifcrx9sc82agpy91ibi774jo4` FOREIGN KEY (`area_id`) REFERENCES `ieadam_area` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ieadam_congregacao`
--

/*!40000 ALTER TABLE `ieadam_congregacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `ieadam_congregacao` ENABLE KEYS */;


--
-- Definition of table `ieadam_funcao`
--

DROP TABLE IF EXISTS `ieadam_funcao`;
CREATE TABLE `ieadam_funcao` (
  `id` int(11) NOT NULL auto_increment,
  `data_ultima_atualizacao` date default NULL,
  `descricao` varchar(60) NOT NULL,
  `situacao` char(1) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ieadam_funcao`
--

/*!40000 ALTER TABLE `ieadam_funcao` DISABLE KEYS */;
/*!40000 ALTER TABLE `ieadam_funcao` ENABLE KEYS */;


--
-- Definition of table `ieadam_membro`
--

DROP TABLE IF EXISTS `ieadam_membro`;
CREATE TABLE `ieadam_membro` (
  `id` int(11) NOT NULL auto_increment,
  `cep` varchar(8) default NULL,
  `cert_casamento` varchar(10) default NULL,
  `conjuge` varchar(60) default NULL,
  `cpf` varchar(11) default NULL,
  `data_bat_espirito` date default NULL,
  `data_batismo` date default NULL,
  `data_cadastro` date default NULL,
  `data_decisao` date default NULL,
  `data_nascimento` date default NULL,
  `data_recebimento` date default NULL,
  `email` varchar(60) default NULL,
  `endereco` varchar(60) default NULL,
  `estado_civil` varchar(255) default NULL,
  `fatorrh` char(3) NOT NULL,
  `formacao_teologico` varchar(60) default NULL,
  `nacionalidade` varchar(60) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `nome_mae` varchar(60) default NULL,
  `nome_pai` varchar(60) default NULL,
  `procedencia` varchar(60) default NULL,
  `qtde_filhos` int(11) default NULL,
  `rg` varchar(10) default NULL,
  `rg_orgao_emissor` varchar(10) default NULL,
  `sexo` char(1) NOT NULL,
  `situacao` char(1) NOT NULL,
  `telefone` varchar(40) default NULL,
  `titulo_eleitor` varchar(10) default NULL,
  `titulo_secao` varchar(6) default NULL,
  `titulo_zona` varchar(10) default NULL,
  `uf` varchar(2) NOT NULL,
  `cidade_id` int(11) default NULL,
  `congregacao_id` int(11) default NULL,
  `funcao_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_e054r8l6psqxt27mngg4d9jt6` (`cidade_id`),
  KEY `FK_pwmsm71mc8t7mbju3yhplhvpu` (`congregacao_id`),
  KEY `FK_36rwlcqg1hvpfxfe8y7pdwjm0` (`funcao_id`),
  CONSTRAINT `FK_36rwlcqg1hvpfxfe8y7pdwjm0` FOREIGN KEY (`funcao_id`) REFERENCES `ieadam_funcao` (`id`),
  CONSTRAINT `FK_e054r8l6psqxt27mngg4d9jt6` FOREIGN KEY (`cidade_id`) REFERENCES `ieadam_cidade` (`id`),
  CONSTRAINT `FK_pwmsm71mc8t7mbju3yhplhvpu` FOREIGN KEY (`congregacao_id`) REFERENCES `ieadam_congregacao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ieadam_membro`
--

/*!40000 ALTER TABLE `ieadam_membro` DISABLE KEYS */;
/*!40000 ALTER TABLE `ieadam_membro` ENABLE KEYS */;


--
-- Definition of table `ieadam_nivel_pastoral`
--

DROP TABLE IF EXISTS `ieadam_nivel_pastoral`;
CREATE TABLE `ieadam_nivel_pastoral` (
  `id` int(11) NOT NULL auto_increment,
  `area_id` tinyint(1) default NULL,
  `nucleo_id` tinyint(1) default NULL,
  `zona_id` tinyint(1) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ieadam_nivel_pastoral`
--

/*!40000 ALTER TABLE `ieadam_nivel_pastoral` DISABLE KEYS */;
/*!40000 ALTER TABLE `ieadam_nivel_pastoral` ENABLE KEYS */;


--
-- Definition of table `ieadam_nucleo`
--

DROP TABLE IF EXISTS `ieadam_nucleo`;
CREATE TABLE `ieadam_nucleo` (
  `id` int(11) NOT NULL auto_increment,
  `data_ultima_atualizacao` date default NULL,
  `nome` varchar(60) NOT NULL,
  `situacao` char(1) NOT NULL,
  `zona_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_brbo4sgvh05kx0i2kesbcg9hs` (`zona_id`),
  CONSTRAINT `FK_brbo4sgvh05kx0i2kesbcg9hs` FOREIGN KEY (`zona_id`) REFERENCES `ieadam_zona` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ieadam_nucleo`
--

/*!40000 ALTER TABLE `ieadam_nucleo` DISABLE KEYS */;
/*!40000 ALTER TABLE `ieadam_nucleo` ENABLE KEYS */;


--
-- Definition of table `ieadam_pastor`
--

DROP TABLE IF EXISTS `ieadam_pastor`;
CREATE TABLE `ieadam_pastor` (
  `id` bigint(20) NOT NULL auto_increment,
  `nome` varchar(60) NOT NULL,
  `id_usuario` bigint(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_ptdwfl1759psooqf3633y3x56` (`id_usuario`),
  CONSTRAINT `FK_ptdwfl1759psooqf3633y3x56` FOREIGN KEY (`id_usuario`) REFERENCES `saa_usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ieadam_pastor`
--

/*!40000 ALTER TABLE `ieadam_pastor` DISABLE KEYS */;
/*!40000 ALTER TABLE `ieadam_pastor` ENABLE KEYS */;


--
-- Definition of table `ieadam_zona`
--

DROP TABLE IF EXISTS `ieadam_zona`;
CREATE TABLE `ieadam_zona` (
  `id` int(11) NOT NULL auto_increment,
  `cd_zona_argo` int(11) NOT NULL,
  `data_ultima_atualizacao` date default NULL,
  `nome` varchar(60) NOT NULL,
  `situacao` char(1) NOT NULL,
  `primeiro_resp_id` int(11) default NULL,
  `segundo_resp_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_59ieriajncvkqv15ke9al66ea` (`primeiro_resp_id`),
  KEY `FK_nkpydl4k96oejo386c7r68gcx` (`segundo_resp_id`),
  CONSTRAINT `FK_nkpydl4k96oejo386c7r68gcx` FOREIGN KEY (`segundo_resp_id`) REFERENCES `ieadam_membro` (`id`),
  CONSTRAINT `FK_59ieriajncvkqv15ke9al66ea` FOREIGN KEY (`primeiro_resp_id`) REFERENCES `ieadam_membro` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ieadam_zona`
--

/*!40000 ALTER TABLE `ieadam_zona` DISABLE KEYS */;
/*!40000 ALTER TABLE `ieadam_zona` ENABLE KEYS */;


--
-- Definition of table `saa_perfil`
--

DROP TABLE IF EXISTS `saa_perfil`;
CREATE TABLE `saa_perfil` (
  `id_perfil` bigint(20) NOT NULL auto_increment,
  `imagem` varchar(60) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `id_sistema` bigint(20) default NULL,
  PRIMARY KEY  (`id_perfil`),
  KEY `FK_4hy4snh41hywvhfpa8omdlnqm` (`id_sistema`),
  CONSTRAINT `FK_4hy4snh41hywvhfpa8omdlnqm` FOREIGN KEY (`id_sistema`) REFERENCES `saa_sistema` (`id_sistema`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `saa_perfil`
--

/*!40000 ALTER TABLE `saa_perfil` DISABLE KEYS */;
INSERT INTO `saa_perfil` (`id_perfil`,`imagem`,`nome`,`id_sistema`) VALUES 
 (1,'resources/imagens/perfil/secretaria.png','SECRETARIA',2),
 (2,'resources/imagens/perfil/tesouraria.png','TESOURARIA',2),
 (3,'resources/imagens/perfil/administrativo.png','ADMINISTRATIVO',2),
 (4,'resources/imagens/perfil/configuracao.png','CONFIGURAÇÃO',2);
/*!40000 ALTER TABLE `saa_perfil` ENABLE KEYS */;


--
-- Definition of table `saa_perfil_rotina`
--

DROP TABLE IF EXISTS `saa_perfil_rotina`;
CREATE TABLE `saa_perfil_rotina` (
  `data` datetime default NULL,
  `id_perfil` bigint(20) NOT NULL default '0',
  `id_rotina` bigint(20) NOT NULL default '0',
  PRIMARY KEY  (`id_perfil`,`id_rotina`),
  KEY `FK_kh4c63uwlsyajnqj66sv6btu5` (`id_perfil`),
  KEY `FK_4ey8g8nxrvbs411mm26qda1bf` (`id_rotina`),
  CONSTRAINT `FK_4ey8g8nxrvbs411mm26qda1bf` FOREIGN KEY (`id_rotina`) REFERENCES `saa_rotina` (`id_rotina`),
  CONSTRAINT `FK_kh4c63uwlsyajnqj66sv6btu5` FOREIGN KEY (`id_perfil`) REFERENCES `saa_perfil` (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `id_rotina` bigint(20) NOT NULL auto_increment,
  `acao` varchar(100) NOT NULL,
  `imagem` varchar(100) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `id_sistema` bigint(20) default NULL,
  PRIMARY KEY  (`id_rotina`),
  KEY `FK_54mvu1oxkbqkwg0ifkj9867ar` (`id_sistema`),
  CONSTRAINT `FK_54mvu1oxkbqkwg0ifkj9867ar` FOREIGN KEY (`id_sistema`) REFERENCES `saa_sistema` (`id_sistema`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
 (10,'relatorioDebitoPastoral.init','resources/imagens/rotina/invoice.png','DÉBITO PASTORAL',0,2);
INSERT INTO `saa_rotina` (`id_rotina`,`acao`,`imagem`,`nome`,`status`,`id_sistema`) VALUES 
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
  `id_sistema` bigint(20) NOT NULL auto_increment,
  `codigo` varchar(6) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `imagem` varchar(100) NOT NULL,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY  (`id_sistema`),
  UNIQUE KEY `UK_ghac1kmyt6ytqt8bxwmxy0dfb` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `saa_sistema`
--

/*!40000 ALTER TABLE `saa_sistema` DISABLE KEYS */;
INSERT INTO `saa_sistema` (`id_sistema`,`codigo`,`descricao`,`imagem`,`nome`) VALUES 
 (1,'A','A','A','A'),
 (2,'IEADAM','IEADAM','IEADAM','IEADAM');
/*!40000 ALTER TABLE `saa_sistema` ENABLE KEYS */;


--
-- Definition of table `saa_usuario`
--

DROP TABLE IF EXISTS `saa_usuario`;
CREATE TABLE `saa_usuario` (
  `id_usuario` bigint(20) NOT NULL auto_increment,
  `login` varchar(30) default NULL,
  `nome` varchar(30) NOT NULL,
  `senha` varchar(255) default NULL,
  `status` char(1) NOT NULL,
  PRIMARY KEY  (`id_usuario`),
  UNIQUE KEY `UK_ckrgsi99ta2s36tkydejud4wy` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `saa_usuario`
--

/*!40000 ALTER TABLE `saa_usuario` DISABLE KEYS */;
INSERT INTO `saa_usuario` (`id_usuario`,`login`,`nome`,`senha`,`status`) VALUES 
 (1,'admin','admin','admin','A'),
 (3,'teste','TESTE','teste','A');
/*!40000 ALTER TABLE `saa_usuario` ENABLE KEYS */;


--
-- Definition of table `saa_usuario_perfil`
--

DROP TABLE IF EXISTS `saa_usuario_perfil`;
CREATE TABLE `saa_usuario_perfil` (
  `data` datetime default NULL,
  `id_perfil` bigint(20) NOT NULL default '0',
  `id_usuario` bigint(20) NOT NULL default '0',
  `id_usuario_perfil` bigint(20) NOT NULL auto_increment,
  PRIMARY KEY  USING BTREE (`id_usuario_perfil`),
  UNIQUE KEY `UK_pto2o8v03odq0udr0w1p1wgrw` (`id_usuario`,`id_perfil`,`data`),
  KEY `FK_fpjsxglutlk7m5aho59hito8q` (`id_perfil`),
  KEY `FK_ooqm83bohskwfg89ng9g3kgra` (`id_usuario`),
  CONSTRAINT `FK_id_perfil` FOREIGN KEY (`id_perfil`) REFERENCES `saa_perfil` (`id_perfil`),
  CONSTRAINT `FK_id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `saa_usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `saa_usuario_perfil`
--

/*!40000 ALTER TABLE `saa_usuario_perfil` DISABLE KEYS */;
INSERT INTO `saa_usuario_perfil` (`data`,`id_perfil`,`id_usuario`,`id_usuario_perfil`) VALUES 
 (NULL,1,1,1),
 (NULL,2,1,2),
 (NULL,3,1,3),
 (NULL,4,1,4);
/*!40000 ALTER TABLE `saa_usuario_perfil` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
