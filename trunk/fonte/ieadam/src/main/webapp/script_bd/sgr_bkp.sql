-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.6.16


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;



--
-- Dumping data for table `saa_usuario_perfil`
--

/*!40000 ALTER TABLE `saa_usuario_perfil` DISABLE KEYS */;
/*!40000 ALTER TABLE `saa_usuario_perfil` ENABLE KEYS */;

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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_ultima_atualizacao` date DEFAULT NULL,
  `nome` varchar(60) NOT NULL,
  `situacao` char(1) NOT NULL,
  `nucleo_id` int(11) DEFAULT NULL,
  `pastor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_13g18q06ik8htnbqdsnccmgjh` (`nucleo_id`),
  UNIQUE KEY `UK_nhb2dgpjpfjk4sjhvhl7flumm` (`pastor_id`),
  KEY `FK_13g18q06ik8htnbqdsnccmgjh` (`nucleo_id`),
  KEY `FK_nhb2dgpjpfjk4sjhvhl7flumm` (`pastor_id`),
  CONSTRAINT `FK_13g18q06ik8htnbqdsnccmgjh` FOREIGN KEY (`nucleo_id`) REFERENCES `ieadam_nucleo` (`id`),
  CONSTRAINT `FK_nhb2dgpjpfjk4sjhvhl7flumm` FOREIGN KEY (`pastor_id`) REFERENCES `ieadam_membro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_area`
--

/*!40000 ALTER TABLE `ieadam_area` DISABLE KEYS */;
INSERT INTO `ieadam_area` (`id`,`data_ultima_atualizacao`,`nome`,`situacao`,`nucleo_id`,`pastor_id`) VALUES 
 (1,NULL,'AREA 1','A',1,NULL);
/*!40000 ALTER TABLE `ieadam_area` ENABLE KEYS */;


--
-- Definition of table `ieadam_cidade`
--

DROP TABLE IF EXISTS `ieadam_cidade`;
CREATE TABLE `ieadam_cidade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `data_ultima_atualizacao` datetime DEFAULT NULL,
  `situacao` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_cidade`
--

/*!40000 ALTER TABLE `ieadam_cidade` DISABLE KEYS */;
INSERT INTO `ieadam_cidade` (`id`,`nome`,`uf`,`data_ultima_atualizacao`,`situacao`) VALUES 
 (1,'MANAUS','AM',NULL,'A'),
 (2,'COARI','AM',NULL,'A');
/*!40000 ALTER TABLE `ieadam_cidade` ENABLE KEYS */;


--
-- Definition of table `ieadam_congregacao`
--

DROP TABLE IF EXISTS `ieadam_congregacao`;
CREATE TABLE `ieadam_congregacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bairro` varchar(60) NOT NULL,
  `cep` varchar(8) DEFAULT NULL,
  `data_cadastro` date DEFAULT NULL,
  `data_fundacao` date DEFAULT NULL,
  `data_ultima_atualizacao` date DEFAULT NULL,
  `endereco` varchar(60) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `situacao` char(1) NOT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `area_id` int(11) DEFAULT NULL,
  `cidade_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ifcrx9sc82agpy91ibi774jo4` (`area_id`),
  UNIQUE KEY `UK_ciunhejah852oxnefk5me9njs` (`cidade_id`),
  KEY `FK_ifcrx9sc82agpy91ibi774jo4` (`area_id`),
  KEY `FK_ciunhejah852oxnefk5me9njs` (`cidade_id`),
  CONSTRAINT `FK_ciunhejah852oxnefk5me9njs` FOREIGN KEY (`cidade_id`) REFERENCES `ieadam_cidade` (`id`),
  CONSTRAINT `FK_ifcrx9sc82agpy91ibi774jo4` FOREIGN KEY (`area_id`) REFERENCES `ieadam_area` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_congregacao`
--

/*!40000 ALTER TABLE `ieadam_congregacao` DISABLE KEYS */;
INSERT INTO `ieadam_congregacao` (`id`,`bairro`,`cep`,`data_cadastro`,`data_fundacao`,`data_ultima_atualizacao`,`endereco`,`nome`,`situacao`,`telefone`,`area_id`,`cidade_id`) VALUES 
 (3,'WWWW','2222',NULL,NULL,NULL,'2222','CIDADE NOVA','A','222222',1,1);
/*!40000 ALTER TABLE `ieadam_congregacao` ENABLE KEYS */;


--
-- Definition of table `ieadam_funcao`
--

DROP TABLE IF EXISTS `ieadam_funcao`;
CREATE TABLE `ieadam_funcao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_ultima_atualizacao` date DEFAULT NULL,
  `descricao` varchar(60) NOT NULL,
  `situacao` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_funcao`
--

/*!40000 ALTER TABLE `ieadam_funcao` DISABLE KEYS */;
INSERT INTO `ieadam_funcao` (`id`,`data_ultima_atualizacao`,`descricao`,`situacao`) VALUES 
 (1,NULL,'PASTOR','A');
/*!40000 ALTER TABLE `ieadam_funcao` ENABLE KEYS */;


--
-- Definition of table `ieadam_membro`
--

DROP TABLE IF EXISTS `ieadam_membro`;
CREATE TABLE `ieadam_membro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
  `cidade_id` int(11) DEFAULT NULL,
  `congregacao_id` int(11) DEFAULT NULL,
  `funcao_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_e054r8l6psqxt27mngg4d9jt6` (`cidade_id`),
  KEY `FK_pwmsm71mc8t7mbju3yhplhvpu` (`congregacao_id`),
  KEY `FK_36rwlcqg1hvpfxfe8y7pdwjm0` (`funcao_id`),
  KEY `FK_2kg376jn4mp4eo7jnlqt0ag0n` (`usuario_id`),
  CONSTRAINT `FK_2kg376jn4mp4eo7jnlqt0ag0n` FOREIGN KEY (`usuario_id`) REFERENCES `ieadam_usuario` (`id`),
  CONSTRAINT `FK_36rwlcqg1hvpfxfe8y7pdwjm0` FOREIGN KEY (`funcao_id`) REFERENCES `ieadam_funcao` (`id`),
  CONSTRAINT `FK_e054r8l6psqxt27mngg4d9jt6` FOREIGN KEY (`cidade_id`) REFERENCES `ieadam_cidade` (`id`),
  CONSTRAINT `FK_pwmsm71mc8t7mbju3yhplhvpu` FOREIGN KEY (`congregacao_id`) REFERENCES `ieadam_congregacao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_membro`
--

/*!40000 ALTER TABLE `ieadam_membro` DISABLE KEYS */;
INSERT INTO `ieadam_membro` (`id`,`cep`,`cert_casamento`,`conjuge`,`cpf`,`data_bat_espirito`,`data_batismo`,`data_cadastro`,`data_decisao`,`data_nascimento`,`data_recebimento`,`email`,`endereco`,`estado_civil`,`fatorrh`,`formacao_teologico`,`nacionalidade`,`nome`,`nome_mae`,`nome_pai`,`procedencia`,`qtde_filhos`,`rg`,`rg_orgao_emissor`,`sexo`,`situacao`,`telefone`,`titulo_eleitor`,`titulo_secao`,`titulo_zona`,`uf`,`cidade_id`,`congregacao_id`,`funcao_id`,`usuario_id`) VALUES 
 (2,'22','22','222','2222222222',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'222','SO','O+','2222','222','ADMIN','AAAaaaa','AAAA','AAAA',1,'111','1111','M','A','22222','2222','2222','222','AM',1,3,1,NULL),
 (3,'','','','',NULL,NULL,NULL,NULL,NULL,NULL,'','','0','O+','','','','','','',0,'','','A','A','','','','','',2,3,NULL,NULL);
/*!40000 ALTER TABLE `ieadam_membro` ENABLE KEYS */;


--
-- Definition of table `ieadam_nucleo`
--

DROP TABLE IF EXISTS `ieadam_nucleo`;
CREATE TABLE `ieadam_nucleo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_ultima_atualizacao` date DEFAULT NULL,
  `nome` varchar(60) NOT NULL,
  `situacao` char(1) NOT NULL,
  `zona_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_brbo4sgvh05kx0i2kesbcg9hs` (`zona_id`),
  CONSTRAINT `FK_brbo4sgvh05kx0i2kesbcg9hs` FOREIGN KEY (`zona_id`) REFERENCES `ieadam_zona` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_nucleo`
--

/*!40000 ALTER TABLE `ieadam_nucleo` DISABLE KEYS */;
INSERT INTO `ieadam_nucleo` (`id`,`data_ultima_atualizacao`,`nome`,`situacao`,`zona_id`) VALUES 
 (1,NULL,'ZONA 1','A',1);
/*!40000 ALTER TABLE `ieadam_nucleo` ENABLE KEYS */;


--
-- Definition of table `ieadam_perfil`
--

DROP TABLE IF EXISTS `ieadam_perfil`;
CREATE TABLE `ieadam_perfil` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) NOT NULL,
  `imagem` varchar(100) NOT NULL,
  `nome` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_perfil`
--

/*!40000 ALTER TABLE `ieadam_perfil` DISABLE KEYS */;
INSERT INTO `ieadam_perfil` (`id`,`descricao`,`imagem`,`nome`) VALUES 
 (1,'RELATÓRIO SECRETARIA','resources/imagens/rotina/calculator.png','SECRETARIA'),
 (2,'TESOURARIA','resources/imagens/rotina/calculator.png','TESOURARIA'),
 (3,'ADMINISTRATIVO','resources/imagens/rotina/calculator.png','ADMINISTRATIVO'),
 (4,'CONFIGURAÇÃO','resources/imagens/rotina/calculator.png','CONFIGURAÇÃO');
/*!40000 ALTER TABLE `ieadam_perfil` ENABLE KEYS */;


--
-- Definition of table `ieadam_rotina`
--

DROP TABLE IF EXISTS `ieadam_rotina`;
CREATE TABLE `ieadam_rotina` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acao` varchar(100) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `imagem` varchar(100) NOT NULL,
  `nome` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_rotina`
--

/*!40000 ALTER TABLE `ieadam_rotina` DISABLE KEYS */;
INSERT INTO `ieadam_rotina` (`id`,`acao`,`descricao`,`imagem`,`nome`) VALUES 
 (1,'paginas/relatorio/saldocongregacao.xhtml','SALDO DA CONGREGAÇÃO','resources/imagens/rotina/banknote.png','SALDO DA CONGREGAÇÃO'),
 (2,'paginas/relatorio/proventopastoral.xhtml','PROVENTO PASTORAL','resources/imagens/rotina/bar_chart.png','PROVENTO PASTORAL'),
 (3,'paginas/relatorio/debitofinanceiro.xhtml','DÉBITO FINANCEIRO','resources/imagens/rotina/calculator.png','DÉBITO FINANCEIRO'),
 (4,'paginas/relatorio/centrocusto.xhtml','CENTRO DE CUSTO','resources/imagens/rotina/cash_register.png','CENTRO DE CUSTO'),
 (5,'paginas/relatorio/nadaconsta.xhtml','NADA CONSTA','resources/imagens/rotina/coins.png','NADA CONSTA'),
 (6,'paginas/relatorio/saldodepartamental.xhtml','SALDO DEPARTAMENTAL','resources/imagens/rotina/credit_card.png','SALDO DEPARTAMENTAL'),
 (7,'paginas/relatorio/balanceteanlitico.xhtml','BALANCETE ANALITICO','resources/imagens/rotina/gold_bullion.png','BALANCETE ANALITICO'),
 (8,'paginas/relatorio/balancetesintetico.xhtml','BALANCETE SINTÉTICO','resources/imagens/rotina/invoice.png','BALANCETE SINTÉTICO'),
 (9,'paginas/membro/pesquisa.xhtml','CADASTRO DE MEMBROS','resources/imagens/rotina/invoice.png','CADASTRO DE MEMBROS'),
 (10,'paginas/relatorio/debitopastoral.xhtml','DÉBITO PASTORAL','resources/imagens/rotina/invoice.png','DÉBITO PASTORAL'),
 (11,'paginas/relatorio/estatistico.xhtml','ESTATISTICO','resources/imagens/rotina/gold_bullion.png','ESTATISTICO'),
 (12,'paginas/relatorio/debitosecretaria.xhtml','DÉBITO SECRETARIA','resources/imagens/rotina/credit_card.png','DÉBITO SECRETARIA'),
 (13,'paginas/relatorio/membro.xhtml','MEMBROS','resources/imagens/rotina/credit_card.png','MEMBROS'),
 (14,'paginas/rotina/pesquisa.xhtml','CADASTRO DE ROTINAS','resources/imagens/rotina/credit_card.png','CADASTRO DE ROTINAS'),
 (15,'paginas/perfil/pesquisa.xhtml','CADASTRO DE PERFIL','resources/imagens/rotina/gold_bullion.png','CADASTRO DE PERFIL');
/*!40000 ALTER TABLE `ieadam_rotina` ENABLE KEYS */;


--
-- Definition of table `ieadam_usuario`
--

DROP TABLE IF EXISTS `ieadam_usuario`;
CREATE TABLE `ieadam_usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(30) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `situacao` char(1) NOT NULL,
  `membro_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_s2vcjircb4iid4d96yvbvj8ra` (`login`),
  UNIQUE KEY `UK_sf7ejblhe613nplv0nkj032un` (`membro_id`),
  KEY `FK_sf7ejblhe613nplv0nkj032un` (`membro_id`),
  CONSTRAINT `FK_sf7ejblhe613nplv0nkj032un` FOREIGN KEY (`membro_id`) REFERENCES `ieadam_membro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_usuario`
--

/*!40000 ALTER TABLE `ieadam_usuario` DISABLE KEYS */;
INSERT INTO `ieadam_usuario` (`id`,`login`,`senha`,`situacao`,`membro_id`) VALUES 
 (2,'admin','admin','a',2);
/*!40000 ALTER TABLE `ieadam_usuario` ENABLE KEYS */;


--
-- Definition of table `ieadam_zona`
--

DROP TABLE IF EXISTS `ieadam_zona`;
CREATE TABLE `ieadam_zona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cd_zona_argo` int(11) NOT NULL,
  `data_ultima_atualizacao` date DEFAULT NULL,
  `nome` varchar(60) NOT NULL,
  `situacao` char(1) NOT NULL,
  `primeiro_resp_id` int(11) DEFAULT NULL,
  `segundo_resp_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_59ieriajncvkqv15ke9al66ea` (`primeiro_resp_id`),
  KEY `FK_nkpydl4k96oejo386c7r68gcx` (`segundo_resp_id`),
  CONSTRAINT `FK_59ieriajncvkqv15ke9al66ea` FOREIGN KEY (`primeiro_resp_id`) REFERENCES `ieadam_membro` (`id`),
  CONSTRAINT `FK_nkpydl4k96oejo386c7r68gcx` FOREIGN KEY (`segundo_resp_id`) REFERENCES `ieadam_membro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_zona`
--

/*!40000 ALTER TABLE `ieadam_zona` DISABLE KEYS */;
INSERT INTO `ieadam_zona` (`id`,`cd_zona_argo`,`data_ultima_atualizacao`,`nome`,`situacao`,`primeiro_resp_id`,`segundo_resp_id`) VALUES 
 (1,111,NULL,'NORTE','A',NULL,NULL);
/*!40000 ALTER TABLE `ieadam_zona` ENABLE KEYS */;


--
-- Definition of table `perfil_rotina`
--

DROP TABLE IF EXISTS `perfil_rotina`;
CREATE TABLE `perfil_rotina` (
  `rotina_id` int(11) NOT NULL,
  `perfil_id` int(11) NOT NULL,
  KEY `FK_85eh52v50rf3hdto67jidfkyq` (`perfil_id`),
  KEY `FK_squ9b9j7qh1vd4j487fpieu8t` (`rotina_id`),
  CONSTRAINT `FK_85eh52v50rf3hdto67jidfkyq` FOREIGN KEY (`perfil_id`) REFERENCES `ieadam_perfil` (`id`),
  CONSTRAINT `FK_squ9b9j7qh1vd4j487fpieu8t` FOREIGN KEY (`rotina_id`) REFERENCES `ieadam_rotina` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `perfil_rotina`
--

/*!40000 ALTER TABLE `perfil_rotina` DISABLE KEYS */;
INSERT INTO `perfil_rotina` (`rotina_id`,`perfil_id`) VALUES 
 (1,2),
 (2,2),
 (3,2),
 (4,2),
 (6,2),
 (10,1),
 (11,1),
 (12,1),
 (13,1),
 (8,3),
 (7,3),
 (14,4),
 (15,4),
 (9,4),
 (10,2);
/*!40000 ALTER TABLE `perfil_rotina` ENABLE KEYS */;


--
-- Definition of table `usuario_perfil`
--

DROP TABLE IF EXISTS `usuario_perfil`;
CREATE TABLE `usuario_perfil` (
  `usuario_id` int(11) NOT NULL,
  `usuario_adm_id` int(11) NOT NULL,
  `perfil_id` int(11) NOT NULL,
  `data_cadastro` date DEFAULT NULL,
  KEY `FK_8bbhfkid7y9tiaj8puml5sgfc` (`perfil_id`),
  KEY `FK_q8xu3cvijngr148ci474pntfy` (`usuario_id`),
  CONSTRAINT `FK_8bbhfkid7y9tiaj8puml5sgfc` FOREIGN KEY (`perfil_id`) REFERENCES `ieadam_perfil` (`id`),
  CONSTRAINT `FK_q8xu3cvijngr148ci474pntfy` FOREIGN KEY (`usuario_id`) REFERENCES `ieadam_usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario_perfil`
--

/*!40000 ALTER TABLE `usuario_perfil` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_perfil` ENABLE KEYS */;

--
-- Create schema temp
--

CREATE DATABASE IF NOT EXISTS temp;
USE temp;

--
-- Definition of table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
CREATE TABLE `aluno` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` char(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `aluno`
--

/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` (`id`,`nome`) VALUES 
 (1,'222'),
 (2,'3333');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;


--
-- Definition of table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
CREATE TABLE `cursos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` char(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cursos`
--

/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` (`id`,`nome`) VALUES 
 (1,'qqqqq');
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;


--
-- Definition of table `notas`
--

DROP TABLE IF EXISTS `notas`;
CREATE TABLE `notas` (
  `aluno_id` int(11) NOT NULL DEFAULT '0',
  `cursos_id` int(11) NOT NULL,
  `nota` double NOT NULL,
  PRIMARY KEY (`aluno_id`,`cursos_id`),
  KEY `i2` (`cursos_id`),
  CONSTRAINT `notas_ibfk_1` FOREIGN KEY (`aluno_id`) REFERENCES `aluno` (`id`) ON DELETE CASCADE,
  CONSTRAINT `notas_ibfk_2` FOREIGN KEY (`cursos_id`) REFERENCES `cursos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `notas`
--

/*!40000 ALTER TABLE `notas` DISABLE KEYS */;
INSERT INTO `notas` (`aluno_id`,`cursos_id`,`nota`) VALUES 
 (1,1,22);
/*!40000 ALTER TABLE `notas` ENABLE KEYS */;

--
-- Create schema teste
--

CREATE DATABASE IF NOT EXISTS teste;
USE teste;

--
-- Definition of table `saa_perfil`
--

DROP TABLE IF EXISTS `saa_perfil`;
CREATE TABLE `saa_perfil` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imagem` varchar(60) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `sistema_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SAA_PERFIL_SISTEMA_ID` (`sistema_id`),
  CONSTRAINT `FK_SAA_PERFIL_SISTEMA_ID` FOREIGN KEY (`sistema_id`) REFERENCES `saa_sistema` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `saa_perfil`
--

/*!40000 ALTER TABLE `saa_perfil` DISABLE KEYS */;
INSERT INTO `saa_perfil` (`id`,`imagem`,`nome`,`sistema_id`) VALUES 
 (1,'QQQ','CADASTRO',2222);
/*!40000 ALTER TABLE `saa_perfil` ENABLE KEYS */;


--
-- Definition of table `saa_sistema`
--

DROP TABLE IF EXISTS `saa_sistema`;
CREATE TABLE `saa_sistema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(200) NOT NULL,
  `imagem` varchar(100) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `codigo` varchar(6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_SISTEMA_CODIGO` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `saa_sistema`
--

/*!40000 ALTER TABLE `saa_sistema` DISABLE KEYS */;
/*!40000 ALTER TABLE `saa_sistema` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
