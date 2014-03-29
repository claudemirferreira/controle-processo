CREATE DATABASE  IF NOT EXISTS `sgr` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sgr`;
-- MySQL dump 10.13  Distrib 5.6.11, for Win32 (x86)
--
-- Host: localhost    Database: sgr
-- ------------------------------------------------------
-- Server version	5.6.13-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ieadam_area`
--

DROP TABLE IF EXISTS `ieadam_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ieadam_area` (
  `id_area` bigint(20) NOT NULL,
  `data_ultima_atualizacao` date DEFAULT NULL,
  `nome` varchar(60) NOT NULL,
  `situacao` char(1) NOT NULL,
  `id_nucleo` int(11) DEFAULT NULL,
  `id_pastor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_area`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ieadam_congregacao`
--

DROP TABLE IF EXISTS `ieadam_congregacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ieadam_congregacao` (
  `id_congregacao` bigint(20) NOT NULL,
  `bairro` varchar(60) DEFAULT NULL,
  `cep` varchar(15) DEFAULT NULL,
  `data_cadastro` date DEFAULT NULL,
  `data_fundacao` date DEFAULT NULL,
  `data_ultima_atualizacao` date DEFAULT NULL,
  `endereco` varchar(60) DEFAULT NULL,
  `nome` varchar(60) DEFAULT NULL,
  `situacao` char(1) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `id_area` bigint(20) DEFAULT NULL,
  `cidade` varchar(60) DEFAULT NULL,
  `id_dirigente` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_congregacao`),
  KEY `FK_sedg9bm0l7hij9t49c0mpju8k` (`id_area`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ieadam_membro`
--

DROP TABLE IF EXISTS `ieadam_membro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ieadam_membro` (
  `id_membro` bigint(20) NOT NULL,
  `cep` varchar(15) DEFAULT NULL,
  `cert_casamento` varchar(10) DEFAULT NULL,
  `conjuge` varchar(60) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
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
  `rg` varchar(15) DEFAULT NULL,
  `rg_orgao_emissor` varchar(15) DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `situacao` char(1) NOT NULL,
  `telefone` varchar(40) DEFAULT NULL,
  `titulo_eleitor` varchar(15) DEFAULT NULL,
  `titulo_secao` varchar(6) DEFAULT NULL,
  `titulo_zona` varchar(10) DEFAULT NULL,
  `uf` varchar(2) DEFAULT NULL,
  `id_congregacao` bigint(20) DEFAULT NULL,
  `funcao` varchar(50) DEFAULT NULL,
  `cidade` varchar(60) DEFAULT NULL,
  `fator_rh` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_membro`),
  KEY `FK_ey8cd94hrolqg38kesplym5e1` (`id_congregacao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `ieadam_nucleo`
--

DROP TABLE IF EXISTS `ieadam_nucleo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ieadam_nucleo` (
  `id_nucleo` bigint(20) NOT NULL,
  `data_ultima_atualizacao` date DEFAULT NULL,
  `nome` varchar(60) DEFAULT NULL,
  `situacao` char(1) NOT NULL,
  `id_zona` bigint(20) NOT NULL,
  `id_coordenador` int(11) NOT NULL,
  PRIMARY KEY (`id_nucleo`),
  KEY `FK_neghkrgnkjr9gp4rsaocjs132` (`id_zona`),
  KEY `FK_8b3s8x6sdsvwpq4u10s74f6pw` (`id_coordenador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ieadam_perfil`
--

DROP TABLE IF EXISTS `ieadam_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ieadam_perfil` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ieadam_perfil`
--

LOCK TABLES `ieadam_perfil` WRITE;
/*!40000 ALTER TABLE `ieadam_perfil` DISABLE KEYS */;
/*!40000 ALTER TABLE `ieadam_perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ieadam_zona`
--

DROP TABLE IF EXISTS `ieadam_zona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ieadam_zona` (
  `id_zona` bigint(20) NOT NULL,
  `data_ultima_atualizacao` date DEFAULT NULL,
  `nome` varchar(60) DEFAULT NULL,
  `situacao` char(1) NOT NULL,
  `id_primeiro_resp` bigint(20) DEFAULT NULL,
  `id_segundo_resp` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_zona`),
  KEY `FK_l85o89am41oyb8kbk0pqeeft7` (`id_primeiro_resp`),
  KEY `FK_gyosd1uyx0prsw0hlo3kpbcsa` (`id_segundo_resp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rel_fin_proventos_pastoral`
--

DROP TABLE IF EXISTS `rel_fin_proventos_pastoral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rel_fin_proventos_pastoral` (
  `zona_id` int(11) DEFAULT NULL,
  `nm_Supervisor` varchar(100) DEFAULT NULL,
  `nm_Secretario` varchar(100) DEFAULT NULL,
  `id_Nucleo` int(11) DEFAULT NULL,
  `nm_Coordenador` varchar(100) DEFAULT NULL,
  `id_Area` int(11) DEFAULT NULL,
  `id_Congregacao` int(11) DEFAULT NULL,
  `nm_Congregacao` varchar(100) DEFAULT NULL,
  `nm_Pastor` varchar(100) DEFAULT NULL,
  `CC` int(11) DEFAULT NULL,
  `dt_MesAno` date DEFAULT NULL,
  `vl_1Semana` decimal(10,2) DEFAULT NULL,
  `vl_2Semana` decimal(10,2) DEFAULT NULL,
  `vl_3Semana` decimal(10,2) DEFAULT NULL,
  `vl_4Semana` decimal(10,2) DEFAULT NULL,
  `vl_5Semana` decimal(10,2) DEFAULT NULL,
  `vl_TotalSemanas` decimal(10,2) DEFAULT NULL,
  `vl_Atrasado` decimal(10,2) DEFAULT NULL,
  `qt_Nra` int(11) DEFAULT NULL,
  `vl_1SemanaArea` decimal(10,2) DEFAULT NULL,
  `vl_2SemanaArea` decimal(10,2) DEFAULT NULL,
  `vl_3SemanaArea` decimal(10,2) DEFAULT NULL,
  `vl_4SemanaArea` decimal(10,2) DEFAULT NULL,
  `vl_5SemanaArea` decimal(10,2) DEFAULT NULL,
  `vl_TotalSemanasArea` decimal(10,2) DEFAULT NULL,
  `vl_AtrasadoArea` decimal(10,2) DEFAULT NULL,
  `qt_NraArea` int(11) DEFAULT NULL,
  `vl_ReceitaArea` decimal(10,2) DEFAULT NULL,
  `vl_IndisponivelFinalArea` decimal(10,2) DEFAULT NULL,
  `vl_IndSdoNegRetArea` decimal(10,2) DEFAULT NULL,
  `vl_IsentoFinalArea` decimal(10,2) DEFAULT NULL,
  `vl_PagamentoArea` decimal(10,2) DEFAULT NULL,
  `vl_1SemanaNucleo` decimal(10,2) DEFAULT NULL,
  `vl_2SemanaNucleo` decimal(10,2) DEFAULT NULL,
  `vl_3SemanaNucleo` decimal(10,2) DEFAULT NULL,
  `vl_4SemanaNucleo` decimal(10,2) DEFAULT NULL,
  `vl_5SemanaNucleo` decimal(10,2) DEFAULT NULL,
  `vl_TotalSemanasNucleo` decimal(10,2) DEFAULT NULL,
  `vl_AtrasadoNucleo` decimal(10,2) DEFAULT NULL,
  `qt_NraNucleo` int(11) DEFAULT NULL,
  `vl_ReceitaNucleo` decimal(10,2) DEFAULT NULL,
  `vl_IndisponivelFinalNucleo` decimal(10,2) DEFAULT NULL,
  `vl_IndSdoNegRetNucleo` decimal(10,2) DEFAULT NULL,
  `vl_IsentoFinalNucleo` decimal(10,2) DEFAULT NULL,
  `vl_PagamentoNucleo` decimal(10,2) DEFAULT NULL,
  `vl_1SemanaZona` decimal(10,2) DEFAULT NULL,
  `vl_2SemanaZona` decimal(10,2) DEFAULT NULL,
  `vl_3SemanaZona` decimal(10,2) DEFAULT NULL,
  `vl_4SemanaZona` decimal(10,2) DEFAULT NULL,
  `vl_5SemanaZona` decimal(10,2) DEFAULT NULL,
  `vl_TotalSemanasZona` decimal(10,2) DEFAULT NULL,
  `vl_AtrasadoZona` decimal(10,2) DEFAULT NULL,
  `qt_NraZona` int(11) DEFAULT NULL,
  `vl_ReceitaZona` decimal(10,2) DEFAULT NULL,
  `vl_IndisponivelFinalZona` decimal(10,2) DEFAULT NULL,
  `vl_IndSdoNegRetZona` decimal(10,2) DEFAULT NULL,
  `vl_IsentoFinalZona` decimal(10,2) DEFAULT NULL,
  `vl_PagamentoZona` decimal(10,2) DEFAULT NULL,
  `vl_1SemanaGeral` decimal(10,2) DEFAULT NULL,
  `vl_2SemanaGeral` decimal(10,2) DEFAULT NULL,
  `vl_3SemanaGeral` decimal(10,2) DEFAULT NULL,
  `vl_4SemanaGeral` decimal(10,2) DEFAULT NULL,
  `vl_5SemanaGeral` decimal(10,2) DEFAULT NULL,
  `vl_TotalSemanasGeral` decimal(10,2) DEFAULT NULL,
  `vl_AtrasadoGeral` decimal(10,2) DEFAULT NULL,
  `qt_NraGeral` int(11) DEFAULT NULL,
  `vl_ReceitaGeral` decimal(10,2) DEFAULT NULL,
  `vl_IndisponivelFinalGeral` decimal(10,2) DEFAULT NULL,
  `vl_IndSdoNegRetGeral` decimal(10,2) DEFAULT NULL,
  `vl_IsentoFinalGeral` decimal(10,2) DEFAULT NULL,
  `vl_PagamentoGeral` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_fin_proventos_pastoral`
--

LOCK TABLES `rel_fin_proventos_pastoral` WRITE;
/*!40000 ALTER TABLE `rel_fin_proventos_pastoral` DISABLE KEYS */;
/*!40000 ALTER TABLE `rel_fin_proventos_pastoral` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_fin_saldo_congregacao`
--

DROP TABLE IF EXISTS `rel_fin_saldo_congregacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rel_fin_saldo_congregacao` (
  `id_zona` int(11) DEFAULT NULL,
  `id_nucleo` int(11) DEFAULT NULL,
  `id_area` int(11) DEFAULT NULL,
  `id_congregacao` int(11) DEFAULT NULL,
  `dt_mes_ano` date DEFAULT NULL,
  `nm_congregacao` varchar(100) DEFAULT NULL,
  `nm_pastor` varchar(80) DEFAULT NULL,
  `vl_retiradas` decimal(10,2) DEFAULT NULL,
  `vl_saldo` decimal(10,2) DEFAULT NULL,
  `vl_saldo_negativo` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `saa_perfil`
--

DROP TABLE IF EXISTS `saa_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saa_perfil` (
  `id_perfil` bigint(20) NOT NULL AUTO_INCREMENT,
  `imagem` varchar(60) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `id_sistema` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_perfil`),
  KEY `FK_4hy4snh41hywvhfpa8omdlnqm` (`id_sistema`),
  CONSTRAINT `FK_4hy4snh41hywvhfpa8omdlnqm` FOREIGN KEY (`id_sistema`) REFERENCES `saa_sistema` (`id_sistema`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saa_perfil`
--

LOCK TABLES `saa_perfil` WRITE;
/*!40000 ALTER TABLE `saa_perfil` DISABLE KEYS */;
INSERT INTO `saa_perfil` VALUES (1,'resources/imagens/perfil/secretaria.png','SECRETARIA',2),(2,'resources/imagens/perfil/tesouraria.png','TESOURARIA',2),(3,'resources/imagens/perfil/administrativo.png','ADMINISTRATIVO',2),(4,'resources/imagens/perfil/configuracao.png','CONFIGURAÇÃO',2);
/*!40000 ALTER TABLE `saa_perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saa_perfil_rotina`
--

DROP TABLE IF EXISTS `saa_perfil_rotina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saa_perfil_rotina`
--

LOCK TABLES `saa_perfil_rotina` WRITE;
/*!40000 ALTER TABLE `saa_perfil_rotina` DISABLE KEYS */;
INSERT INTO `saa_perfil_rotina` VALUES (NULL,1,10),(NULL,1,11),(NULL,1,12),(NULL,1,13),(NULL,2,1),(NULL,2,2),(NULL,2,3),(NULL,2,4),(NULL,2,6),(NULL,2,10),(NULL,3,7),(NULL,3,8),(NULL,4,9),(NULL,4,14),(NULL,4,15),(NULL,4,16);
/*!40000 ALTER TABLE `saa_perfil_rotina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saa_rotina`
--

DROP TABLE IF EXISTS `saa_rotina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saa_rotina`
--

LOCK TABLES `saa_rotina` WRITE;
/*!40000 ALTER TABLE `saa_rotina` DISABLE KEYS */;
INSERT INTO `saa_rotina` VALUES (1,'relatorioSaldoCongregacao.init','resources/imagens/rotina/banknote.png','SALDO DA CONGREGAÇÃO',0,2),(2,'relatorioProventoPastoral.init','resources/imagens/rotina/bar_chart.png','PROVENTO PASTORAL',0,2),(3,'relatorioDebitoFinanceiro.init','resources/imagens/rotina/calculator.png','DÉBITO FINANCEIRO',0,2),(4,'relatorioCentroCusto.init','resources/imagens/rotina/cash_register.png','CENTRO DE CUSTO',0,2),(5,'relatorioNadaConsta.init','resources/imagens/rotina/coins.png','NADA CONSTA',0,2),(6,'relatorioSaldoDepartamento.init','resources/imagens/rotina/credit_card.png','SALDO DEPARTAMENTAL',0,2),(7,'relatorioBalanceteAnalitico.init','resources/imagens/rotina/gold_bullion.png','BALANCETE ANALITICO',0,2),(8,'relatorioBalanceteSintetico.init','resources/imagens/rotina/invoice.png','BALANCETE SINTÉTICO',0,2),(9,'usuarioControlador.init','resources/imagens/rotina/invoice.png','CADASTRO DE MEMBROS',0,2),(10,'relatorioDebitoPastoral.init','resources/imagens/rotina/invoice.png','DÉBITO PASTORAL',0,2),(11,'relatorioEstatistico.init','resources/imagens/rotina/gold_bullion.png','ESTATISTICO',0,2),(12,'relatorioDebitoSecretaria.init','resources/imagens/rotina/credit_card.png','DÉBITO SECRETARIA',0,2),(13,'relatorioMembro.init','resources/imagens/rotina/credit_card.png','MEMBROS',0,2),(14,'rotinaControlador.init','resources/imagens/rotina/credit_card.png','CADASTRO DE ROTINAS',0,2),(15,'perfilControlador.init','resources/imagens/rotina/gold_bullion.png','CADASTRO DE PERFIL',0,2),(16,'usuarioControlador.init','resources/imagens/rotina/gold_bullion.png','CADASTRO DE USUARIO',0,2);
/*!40000 ALTER TABLE `saa_rotina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saa_sistema`
--

DROP TABLE IF EXISTS `saa_sistema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saa_sistema` (
  `id_sistema` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(6) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `imagem` varchar(100) NOT NULL,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id_sistema`),
  UNIQUE KEY `UK_ghac1kmyt6ytqt8bxwmxy0dfb` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saa_sistema`
--

LOCK TABLES `saa_sistema` WRITE;
/*!40000 ALTER TABLE `saa_sistema` DISABLE KEYS */;
INSERT INTO `saa_sistema` VALUES (1,'SAA','SISTEMA DE AUTENTICAÇÃO E AUTORIZAÇÃO','IIII','SISTEMA DE AUTENTICAÇÃO E AUTORIZAÇÃO'),(2,'IEADAM','SISTEMA DE EMISSÃO DE RELATORIO','III','SISTEMA DE EMISSÃO DE RELATORIO');
/*!40000 ALTER TABLE `saa_sistema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saa_usuario`
--

DROP TABLE IF EXISTS `saa_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  KEY `FK_b3rhxokdblq7r0odmdbker692` (`id_membro`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saa_usuario`
--

LOCK TABLES `saa_usuario` WRITE;
/*!40000 ALTER TABLE `saa_usuario` DISABLE KEYS */;
INSERT INTO `saa_usuario` VALUES (1,'admin','admin','A',1,1,1,NULL),(2,'zona','zona','A',0,0,0,NULL),(4,'nucleo','nucleo','A',1,1,1,NULL),(5,'area','area','A',1,0,0,NULL);
/*!40000 ALTER TABLE `saa_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saa_usuario_perfil`
--

DROP TABLE IF EXISTS `saa_usuario_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saa_usuario_perfil`
--

LOCK TABLES `saa_usuario_perfil` WRITE;
/*!40000 ALTER TABLE `saa_usuario_perfil` DISABLE KEYS */;
INSERT INTO `saa_usuario_perfil` VALUES (NULL,1,1),(NULL,2,1),(NULL,3,1),(NULL,4,1);
/*!40000 ALTER TABLE `saa_usuario_perfil` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-03-17 19:37:12
