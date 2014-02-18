-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.6.15-log


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
  CONSTRAINT `FK_nhb2dgpjpfjk4sjhvhl7flumm` FOREIGN KEY (`pastor_id`) REFERENCES `ieadam_membro` (`id`),
  CONSTRAINT `FK_13g18q06ik8htnbqdsnccmgjh` FOREIGN KEY (`nucleo_id`) REFERENCES `ieadam_nucleo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `data_ultima_atualizacao` datetime DEFAULT NULL,
  `situacao` char(1) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_ultima_atualizacao` date DEFAULT NULL,
  `descricao` varchar(60) NOT NULL,
  `situacao` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  CONSTRAINT `FK_2kg376jn4mp4eo7jnlqt0ag0n` FOREIGN KEY (`usuario_id`) REFERENCES `saa_usuario` (`id`),
  CONSTRAINT `FK_36rwlcqg1hvpfxfe8y7pdwjm0` FOREIGN KEY (`funcao_id`) REFERENCES `ieadam_funcao` (`id`),
  CONSTRAINT `FK_e054r8l6psqxt27mngg4d9jt6` FOREIGN KEY (`cidade_id`) REFERENCES `ieadam_cidade` (`id`),
  CONSTRAINT `FK_pwmsm71mc8t7mbju3yhplhvpu` FOREIGN KEY (`congregacao_id`) REFERENCES `ieadam_congregacao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_membro`
--

/*!40000 ALTER TABLE `ieadam_membro` DISABLE KEYS */;
INSERT INTO `ieadam_membro` (`id`,`cep`,`cert_casamento`,`conjuge`,`cpf`,`data_bat_espirito`,`data_batismo`,`data_cadastro`,`data_decisao`,`data_nascimento`,`data_recebimento`,`email`,`endereco`,`estado_civil`,`fatorrh`,`formacao_teologico`,`nacionalidade`,`nome`,`nome_mae`,`nome_pai`,`procedencia`,`qtde_filhos`,`rg`,`rg_orgao_emissor`,`sexo`,`situacao`,`telefone`,`titulo_eleitor`,`titulo_secao`,`titulo_zona`,`uf`,`cidade_id`,`congregacao_id`,`funcao_id`,`usuario_id`) VALUES 
 (1,'3333','333','33','3333',NULL,NULL,NULL,NULL,NULL,NULL,'333','333','so','O+','3333','33','ADMINISTRADOR DO SISTEMA','333','333','333',3,'33',NULL,'M','0','3333','3333','333','33','AM',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `ieadam_membro` ENABLE KEYS */;


--
-- Definition of table `ieadam_nivel_pastoral`
--

DROP TABLE IF EXISTS `ieadam_nivel_pastoral`;
CREATE TABLE `ieadam_nivel_pastoral` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area_id` tinyint(1) DEFAULT NULL,
  `nucleo_id` tinyint(1) DEFAULT NULL,
  `zona_id` tinyint(1) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_59g4rb7hjfcgnu392kk2g2cfp` (`usuario_id`),
  CONSTRAINT `FK_59g4rb7hjfcgnu392kk2g2cfp` FOREIGN KEY (`usuario_id`) REFERENCES `saa_usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_nivel_pastoral`
--

/*!40000 ALTER TABLE `ieadam_nivel_pastoral` DISABLE KEYS */;
INSERT INTO `ieadam_nivel_pastoral` (`id`,`area_id`,`nucleo_id`,`zona_id`,`usuario_id`) VALUES 
 (1,1,0,0,1);
/*!40000 ALTER TABLE `ieadam_nivel_pastoral` ENABLE KEYS */;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ieadam_nucleo`
--

/*!40000 ALTER TABLE `ieadam_nucleo` DISABLE KEYS */;
/*!40000 ALTER TABLE `ieadam_nucleo` ENABLE KEYS */;


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
  CONSTRAINT `FK_nkpydl4k96oejo386c7r68gcx` FOREIGN KEY (`segundo_resp_id`) REFERENCES `ieadam_membro` (`id`),
  CONSTRAINT `FK_59ieriajncvkqv15ke9al66ea` FOREIGN KEY (`primeiro_resp_id`) REFERENCES `ieadam_membro` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imagem` varchar(60) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `sistema_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_j77n84wmaopj1v2fwhvbdhluc` (`sistema_id`),
  CONSTRAINT `FK_j77n84wmaopj1v2fwhvbdhluc` FOREIGN KEY (`sistema_id`) REFERENCES `saa_sistema` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `saa_perfil`
--

/*!40000 ALTER TABLE `saa_perfil` DISABLE KEYS */;
INSERT INTO `saa_perfil` (`id`,`imagem`,`nome`,`sistema_id`) VALUES 
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime DEFAULT NULL,
  `perfil_id` int(11) DEFAULT NULL,
  `rotina_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_sgaieigex2pn1t80bmv5w75pb` (`perfil_id`),
  KEY `FK_b4qhf2u8hd4rbyjcnbfk78e56` (`rotina_id`),
  CONSTRAINT `FK_b4qhf2u8hd4rbyjcnbfk78e56` FOREIGN KEY (`rotina_id`) REFERENCES `saa_rotina` (`id`),
  CONSTRAINT `FK_sgaieigex2pn1t80bmv5w75pb` FOREIGN KEY (`perfil_id`) REFERENCES `saa_perfil` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `saa_perfil_rotina`
--

/*!40000 ALTER TABLE `saa_perfil_rotina` DISABLE KEYS */;
INSERT INTO `saa_perfil_rotina` (`id`,`data`,`perfil_id`,`rotina_id`) VALUES 
 (1,NULL,2,1),
 (2,NULL,2,2),
 (3,NULL,2,3),
 (4,NULL,2,4),
 (5,NULL,2,6),
 (6,NULL,1,10),
 (7,NULL,1,11),
 (8,NULL,1,12),
 (9,NULL,1,13),
 (11,NULL,3,8),
 (12,NULL,4,14),
 (13,NULL,4,15),
 (14,NULL,4,9),
 (15,NULL,2,10),
 (16,NULL,3,7),
 (17,NULL,4,16);
/*!40000 ALTER TABLE `saa_perfil_rotina` ENABLE KEYS */;


--
-- Definition of table `saa_rotina`
--

DROP TABLE IF EXISTS `saa_rotina`;
CREATE TABLE `saa_rotina` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imagem` varchar(100) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `path` varchar(100) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `sistema_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_3qi4824aom5c61wnyln08wijl` (`sistema_id`),
  CONSTRAINT `FK_3qi4824aom5c61wnyln08wijl` FOREIGN KEY (`sistema_id`) REFERENCES `saa_sistema` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `saa_rotina`
--

/*!40000 ALTER TABLE `saa_rotina` DISABLE KEYS */;
INSERT INTO `saa_rotina` (`id`,`imagem`,`nome`,`path`,`status`,`sistema_id`) VALUES 
 (1,'resources/imagens/rotina/banknote.png','SALDO DA CONGREGAÇÃO','relatorioSaldoCongregacao.init',0,2),
 (2,'resources/imagens/rotina/bar_chart.png','PROVENTO PASTORAL','relatorioProventoPastoral.init',0,2),
 (3,'resources/imagens/rotina/calculator.png','DÉBITO FINANCEIRO','relatorioDebitoFinanceiro.init',0,2),
 (4,'resources/imagens/rotina/cash_register.png','CENTRO DE CUSTO','relatorioCentoCusto.init',0,2),
 (5,'resources/imagens/rotina/coins.png','NADA CONSTA','relatorioNadaConsta.init',0,2),
 (6,'resources/imagens/rotina/credit_card.png','SALDO DEPARTAMENTAL','relatorioSaldoDepartamento.init',0,2),
 (7,'resources/imagens/rotina/gold_bullion.png','BALANCETE ANALITICO','relatorioBalanceteAnalitico.init',0,2),
 (8,'resources/imagens/rotina/invoice.png','BALANCETE SINTÉTICO','relatorioBalanceteSintetico.init',0,2),
 (9,'resources/imagens/rotina/invoice.png','CADASTRO DE MEMBROS','usuarioControlador.init',0,2),
 (10,'resources/imagens/rotina/invoice.png','DÉBITO PASTORAL','relatorioDebitoPastoral.init',0,2),
 (11,'resources/imagens/rotina/gold_bullion.png','ESTATISTICO','relatorioEstatistico.init',0,2),
 (12,'resources/imagens/rotina/credit_card.png','DÉBITO SECRETARIA','relatorioDebitoSecretaria.init',0,2),
 (13,'resources/imagens/rotina/credit_card.png','MEMBROS','relatorioMembro.init',0,2),
 (14,'resources/imagens/rotina/credit_card.png','CADASTRO DE ROTINAS','rotinaControlador.init',0,2),
 (15,'resources/imagens/rotina/gold_bullion.png','CADASTRO DE PERFIL','perfilControlador.init',0,2),
 (16,'resources/imagens/rotina/gold_bullion.png','CADASTRO DE USUARIO','usuarioControlador.init',0,2);
/*!40000 ALTER TABLE `saa_rotina` ENABLE KEYS */;


--
-- Definition of table `saa_sistema`
--

DROP TABLE IF EXISTS `saa_sistema`;
CREATE TABLE `saa_sistema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(6) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `imagem` varchar(100) NOT NULL,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ghac1kmyt6ytqt8bxwmxy0dfb` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `saa_sistema`
--

/*!40000 ALTER TABLE `saa_sistema` DISABLE KEYS */;
INSERT INTO `saa_sistema` (`id`,`codigo`,`descricao`,`imagem`,`nome`) VALUES 
 (1,'SAA','SISTEMA DE AUTENTICAÇÃO E AUTORIZAÇÃO','IIII','SISTEMA DE AUTENTICAÇÃO E AUTORIZAÇÃO'),
 (2,'IEADAM','SISTEMA DE EMISSÃO DE RELATORIO','III','SISTEMA DE EMISSÃO DE RELATORIO');
/*!40000 ALTER TABLE `saa_sistema` ENABLE KEYS */;


--
-- Definition of table `saa_usuario`
--

DROP TABLE IF EXISTS `saa_usuario`;
CREATE TABLE `saa_usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(30) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `membro_id` int(11) DEFAULT NULL,
  `nivelpastoral_id` int(11) DEFAULT NULL,
  `status` char(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ckrgsi99ta2s36tkydejud4wy` (`login`),
  UNIQUE KEY `UK_ss7mxs94k0lujwrjxqa1cutb7` (`membro_id`),
  UNIQUE KEY `UK_9cuivaohasmnsppuixxf9xybs` (`nivelpastoral_id`),
  KEY `FK_ss7mxs94k0lujwrjxqa1cutb7` (`membro_id`),
  KEY `FK_9cuivaohasmnsppuixxf9xybs` (`nivelpastoral_id`),
  CONSTRAINT `FK_9cuivaohasmnsppuixxf9xybs` FOREIGN KEY (`nivelpastoral_id`) REFERENCES `ieadam_nivel_pastoral` (`id`),
  CONSTRAINT `FK_ss7mxs94k0lujwrjxqa1cutb7` FOREIGN KEY (`membro_id`) REFERENCES `ieadam_membro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `saa_usuario`
--

/*!40000 ALTER TABLE `saa_usuario` DISABLE KEYS */;
INSERT INTO `saa_usuario` (`id`,`login`,`senha`,`membro_id`,`nivelpastoral_id`,`status`) VALUES 
 (1,'admin','admin',NULL,1,''),
 (2,'12345678912','123',NULL,NULL,'A'),
 (3,'66106516200','123',NULL,NULL,'A');
/*!40000 ALTER TABLE `saa_usuario` ENABLE KEYS */;


--
-- Definition of table `saa_usuario_perfil`
--

DROP TABLE IF EXISTS `saa_usuario_perfil`;
CREATE TABLE `saa_usuario_perfil` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime DEFAULT NULL,
  `perfil_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_gv0xhytrgfu07mw5ylumvvruh` (`perfil_id`),
  KEY `FK_2wlkydvh3vkmw50j1urhavn6x` (`usuario_id`),
  CONSTRAINT `FK_2wlkydvh3vkmw50j1urhavn6x` FOREIGN KEY (`usuario_id`) REFERENCES `saa_usuario` (`id`),
  CONSTRAINT `FK_gv0xhytrgfu07mw5ylumvvruh` FOREIGN KEY (`perfil_id`) REFERENCES `saa_perfil` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `saa_usuario_perfil`
--

/*!40000 ALTER TABLE `saa_usuario_perfil` DISABLE KEYS */;
INSERT INTO `saa_usuario_perfil` (`id`,`data`,`perfil_id`,`usuario_id`) VALUES 
 (1,NULL,1,1),
 (2,NULL,2,1),
 (3,NULL,3,1),
 (4,NULL,4,1),
 (63,NULL,1,2),
 (64,'2014-02-16 21:47:10',2,2),
 (65,'2014-02-16 22:05:36',3,2);
/*!40000 ALTER TABLE `saa_usuario_perfil` ENABLE KEYS */;


--
-- Definition of table `usuario_perfil`
--

DROP TABLE IF EXISTS `usuario_perfil`;
CREATE TABLE `usuario_perfil` (
  `data` datetime DEFAULT NULL,
  `id_perfil` bigint(20) NOT NULL DEFAULT '0',
  `id_usuario` bigint(20) NOT NULL DEFAULT '0',
  `perfil_id` bigint(20) NOT NULL,
  `usuario_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id_perfil`,`id_usuario`)
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
