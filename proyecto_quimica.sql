-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-05-2024 a las 22:03:04
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto_quimica`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `formato`
--

CREATE TABLE `formato` (
  `Id_Formato` int(11) NOT NULL,
  `Formato` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `formato`
--

INSERT INTO `formato` (`Id_Formato`, `Formato`) VALUES
(1, '1 Kg'),
(2, '100 g'),
(3, '250 g'),
(4, '500 g'),
(5, '5 g'),
(6, 'No viene reflejado'),
(7, '1 L'),
(8, '500 mL'),
(9, '5 Kg'),
(10, '2,5 L'),
(11, '250 mL'),
(12, '100 mL'),
(13, '250 g,1 kg'),
(14, '10 g');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materiales`
--

CREATE TABLE `materiales` (
  `Id_Material` int(11) NOT NULL,
  `Tipo` varchar(50) NOT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  `Fecha_Compra` varchar(30) NOT NULL,
  `Id_Producto` int(11) NOT NULL,
  `N_Serie` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `materiales`
--

INSERT INTO `materiales` (`Id_Material`, `Tipo`, `Descripcion`, `Fecha_Compra`, `Id_Producto`, `N_Serie`) VALUES
(1, 'plástico ', '1000 ml', 'No viene especificada', 165, 'No viene especificado'),
(2, 'plástico ', '500ml', 'No viene especificada', 166, 'No viene especificado'),
(3, 'plástico ', '1000 ml ', 'No viene especificada', 167, 'No viene especificado'),
(4, 'cristal', '3 L', 'No viene especificada', 168, 'No viene especificado'),
(5, 'cristal ', '1000 ml', 'No viene especificada', 169, 'No viene especificado'),
(6, 'cristal', '2L ', 'No viene especificada', 170, 'No viene especificado'),
(7, 'cristal ', '1000 ml', 'No viene especificada', 171, 'No viene especificado'),
(8, 'plástico ', '2L ', 'No viene especificada', 172, 'No viene especificado'),
(9, 'cristal', '50 ml', 'No viene especificada', 173, 'No viene especificado'),
(10, 'Instrumental Electrónico', 'No viene especificado', 'No viene especificada', 174, '“534031”'),
(11, 'Instrumental Electrónico', 'No viene especificado', 'No viene especificada', 175, '“531030”'),
(12, 'Instrumental Electrónico', 'No viene especificado', 'No viene especificada', 176, '“539010”'),
(13, 'Instrumental Electrónico', 'No viene especificado', 'No viene especificada', 177, '“539007”');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `Id_Producto` int(11) NOT NULL,
  `Nombre_Producto` varchar(80) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Stock_Minimo` int(11) NOT NULL,
  `Id_Ubicacion` int(11) NOT NULL,
  `tipo` int(11) NOT NULL COMMENT '1= quimico, 2= producto_aux, 3= material\r\n'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`Id_Producto`, `Nombre_Producto`, `Cantidad`, `Stock_Minimo`, `Id_Ubicacion`, `tipo`) VALUES
(1, 'AMONIO NITRATO', 1, 1, 1, 1),
(2, 'BROMURO DE AMONIO (PARA ANÁLISIS)', 2, 1, 1, 1),
(3, 'AZUFRE SUBLIMADO (AZUFRE FLOR)', 2, 1, 1, 1),
(4, 'ALUMINIO NITRATO 9-HIDRATO', 2, 1, 1, 1),
(5, 'ACETANILIDA CRISTALIZADA', 1, 1, 1, 1),
(6, 'AMINOMETANO', 1, 1, 1, 1),
(7, 'ESTAÑO II CLORURO', 2, 1, 1, 1),
(8, 'ÁCIDO TARTÁRICO', 2, 1, 1, 1),
(9, 'ÁCIDO TARTÁRICO', 1, 1, 1, 1),
(10, 'BIPIRIDINA', 1, 1, 1, 1),
(11, 'HIDROXIQUINOLEINA', 1, 1, 1, 1),
(12, 'HIDROXIQUINOLEINA', 1, 1, 1, 1),
(13, 'CELITE 545', 1, 1, 1, 1),
(14, 'REACTIVO DE BENEDICT', 1, 1, 1, 1),
(15, 'REACTIVO FEHLING-A', 1, 1, 1, 1),
(16, 'REACTIVO FEHLING-B', 1, 1, 1, 1),
(17, 'UREA', 1, 1, 1, 1),
(18, 'AMONIO MOLIBDATO 4-HIDRATO', 1, 1, 2, 1),
(19, 'AMONIO OXALATO 1-HIDRATO', 1, 1, 2, 1),
(20, 'AMONIO OXALATO 1-HIDRATO', 1, 1, 2, 1),
(21, 'PERSULFATO AMÓNICO', 1, 1, 2, 1),
(22, 'AMÓNIO TIOCIANATO', 1, 1, 2, 1),
(23, 'AMÓNIO TIOCIANATO', 1, 1, 2, 1),
(24, 'AMONIO META-VANADATO', 1, 1, 2, 1),
(25, 'CADMIO NITRATO 4-HIDRATO', 1, 1, 2, 1),
(26, 'COBALTO II NITRATO 6-HIDRATO', 1, 1, 2, 1),
(27, 'COBRE (II) NITRATO 3-HIDRATO', 1, 1, 2, 1),
(28, 'ÓXIDO DE COBRE (II)', 1, 1, 2, 1),
(29, 'COBRE (II) SULFATO 5-HIDRATO', 1, 1, 2, 1),
(30, 'COBRE (II) SULFATO 5-HIDRATO', 1, 1, 2, 1),
(31, 'ESTRONCIO NITRATO ANHIDRO', 1, 1, 2, 1),
(32, 'HIERRO (III) CLORURO 6-HIDRATO', 2, 1, 2, 1),
(33, 'HIERRO (III) NITRATO 9-HIDRATO', 1, 1, 2, 1),
(34, 'HIERRO (II) SULFATO ~ 2-HIDRATO', 2, 1, 2, 1),
(35, 'HIERRO (II) SULFATO 7-HIDRATO', 1, 1, 2, 1),
(36, 'HIERRO (II) SULFATO 7-HIDRATO', 1, 1, 2, 1),
(37, 'LANTANO (III) CLORURO 7-HIDRATO', 1, 1, 2, 1),
(38, 'MANGANESO (IV) ÓXIDO', 1, 1, 2, 1),
(39, 'SULFATO DE MANGANESO 1-HIDRATO', 1, 1, 2, 1),
(40, 'MANGANESO (II) SULFATO 1-HIDRATO', 1, 1, 2, 1),
(41, 'CARBONATO DE NÍQUEL', 1, 1, 2, 1),
(42, 'NÍQUEL (II) NITRATO 6-HIDRATO PRS', 1, 1, 2, 1),
(43, 'PLOMO (II) ACETATO 3-HIDRATO', 1, 1, 2, 1),
(44, 'ZINC NITRATO 6-HIDRATO', 1, 1, 2, 1),
(45, 'ÓXIDO DE ZINC', 1, 1, 2, 1),
(46, 'SULFATO DE ZINC 7-HIDRATO', 1, 1, 2, 1),
(47, 'ZINC SULFATO 1-HIDRATO', 1, 1, 2, 1),
(48, 'SODIO CARBONATO 10-HIDRATO', 4, 1, 3, 1),
(49, 'SODIO CARBONATO ANHIDRO', 1, 1, 3, 1),
(50, 'SODIO CARBONATO ANHIDRO', 1, 1, 3, 1),
(51, 'SODIO OXALATO', 1, 1, 3, 1),
(52, 'SODIO SALICILATO', 1, 1, 3, 1),
(53, 'SODIO SILICATO', 1, 1, 3, 1),
(54, 'SODIO TUNGSTATO 2-HIDRATO', 2, 1, 3, 1),
(55, 'POTASIO DE BROMURO', 1, 1, 3, 1),
(56, 'POTASIO DE BROMURO', 1, 1, 3, 1),
(57, 'POTASIO DE BROMURO', 1, 1, 3, 1),
(58, 'POTASIO DE BROMURO', 1, 1, 3, 1),
(59, 'POTASIO CARBONATO PRS', 2, 1, 3, 1),
(60, 'POTASIO CLORATO', 1, 1, 3, 1),
(61, 'OXALATO DE POTASIO 1-HIDRATO', 2, 1, 3, 1),
(62, 'POTASIO OXALATO', 1, 1, 3, 1),
(63, 'POTASIO BIOXALATO', 1, 1, 3, 1),
(64, 'POTASIO BIOXALATO', 1, 1, 3, 1),
(65, 'PERMANGANATO DE POTASIO', 2, 1, 3, 1),
(66, 'PERMANGANATO DE POTASIO', 1, 1, 3, 1),
(67, 'PERMANGANATO DE POTASIO', 1, 1, 3, 1),
(68, 'PERMANGANATO DE POTASIO', 1, 1, 3, 1),
(69, 'POTASIO TIOCIANATO', 2, 1, 3, 1),
(70, 'POTASIO TIOCIANATO', 1, 1, 3, 1),
(71, 'BARIO ACETATO', 1, 1, 3, 1),
(72, 'BARIO HIDRÓXIDO 8-HIDRATO', 1, 1, 3, 1),
(73, 'BARIO HIDRÓXIDO 8-HIDRATO', 1, 1, 3, 1),
(74, 'CALCIO CLORURO ANHIDRO QP', 1, 1, 3, 1),
(75, 'CALCIO CLORURO 2-HIDRATO PRS', 1, 1, 3, 1),
(76, 'CALCIO OXOLATO-1-HIDRATO', 1, 1, 3, 1),
(77, 'CALCIO HIDROXISO', 1, 1, 3, 1),
(78, 'HIDROXIHAMONIO CLORURO', 1, 1, 3, 1),
(79, 'AMONIO CLORURO', 1, 1, 3, 1),
(80, 'ÁCIDO BENZOICO', 1, 1, 4, 1),
(81, 'ÁCIDO BENZOICO', 1, 1, 4, 1),
(82, '4-DICLOROBENCENO', 1, 1, 4, 1),
(83, 'ÁCIDO 2-CLOROBENZOICO', 1, 1, 4, 1),
(84, 'ÁCIDO 4-CLOROBENZOICO', 1, 1, 4, 1),
(85, 'ÁCIDO 4-AMINOBENZOICO', 1, 1, 4, 1),
(86, 'ÁCIDO 4-NITROBENZOICO', 1, 1, 4, 1),
(87, 'AMONÍACO', 1, 1, 4, 1),
(88, 'ISOBUTANOL', 1, 1, 4, 1),
(89, '2-BUTANOL', 1, 1, 4, 1),
(90, '3-METIL-1-BUTANOL SEGÚN GERBER', 3, 1, 4, 1),
(91, 'CLORAMINA T', 1, 1, 4, 1),
(92, 'CLORAMINA T TRIHIDRATADA', 1, 1, 4, 1),
(93, 'DIMETILGLIOXIMA', 1, 1, 4, 1),
(94, 'ÁCIDO 3,5-DINITROSALICÍLICO PS', 1, 1, 4, 1),
(95, 'ETILENGLICOL', 1, 1, 4, 1),
(96, 'AMONIO FORMATO', 1, 1, 4, 1),
(97, 'CICLOHEXANOL', 1, 1, 4, 1),
(98, 'DICLOROMETANO', 1, 1, 4, 1),
(99, 'NAFTALENO PRS', 1, 1, 4, 1),
(100, 'NAFTALENO PRS', 1, 1, 4, 1),
(101, 'NAFTALENO', 1, 1, 4, 1),
(102, '1-NAFTILAMINA PS', 1, 1, 4, 1),
(103, '1-NAFTOL', 1, 1, 4, 1),
(104, 'p-NITROFENOL', 1, 1, 4, 1),
(105, 'p-NITROFENOL', 1, 1, 4, 1),
(106, 'ÁCIDO OXÁLICO 2-HIDRATO', 2, 1, 4, 1),
(107, 'ÁCIDO OXÁLICO', 1, 1, 4, 1),
(108, 'ÁCIDO OXÁLICO CRISTALIZADO', 1, 1, 4, 1),
(109, 'ÁCIDO SULFANÍLICO', 2, 1, 4, 1),
(110, 'TRITÓN X', 1, 1, 4, 1),
(111, 'ÁCIDO ACÉTICO GLACIAL', 1, 1, 5, 1),
(112, 'ÁCIDO ACÉTICO GLACIAL', 1, 1, 5, 1),
(113, 'ÁCIDO ACÉTICO GLACIAL', 1, 1, 5, 1),
(114, 'ÁCIDO ACÉTICO GLACIAL', 1, 1, 5, 1),
(115, 'ÁCIDO ACÉTICO', 1, 1, 5, 1),
(116, 'ANHÍDRICO ACÉTICO', 1, 1, 5, 1),
(117, 'ÁCIDO CLORHÍDRICO', 4, 1, 5, 1),
(118, 'ÁCIDO CLORHÍDRICO', 3, 1, 5, 1),
(119, 'ÁCIDO CLORHÍDRICO', 1, 1, 5, 1),
(120, 'ÁCIDO PERCLÓRICO EN ÁCIDO ACÉTICO', 2, 1, 5, 1),
(121, 'ÁCIDO PERCLÓRICO', 1, 1, 5, 1),
(122, 'ÁCIDO ORTOFOSFÓRICO', 1, 1, 5, 1),
(123, 'ÁCIDO ORTOFOSFÓRICO', 1, 1, 5, 1),
(124, 'ÁCIDO NÍTRICO', 2, 1, 5, 1),
(125, 'ÁCIDO NÍTRICO', 1, 1, 5, 1),
(126, 'ÁCIDO NÍTRICO', 3, 1, 5, 1),
(127, 'ÁCIDO SULFÚRICO', 3, 1, 5, 1),
(128, 'ÁCIDO SULFÚRICO', 1, 1, 5, 1),
(129, 'ÁCIDO FLUORHÍDRICO', 1, 1, 5, 1),
(130, 'ÁCIDO FÓRMICO', 1, 1, 5, 1),
(131, 'ÁCIDO ORTO-FOSFÓRICO', 1, 1, 5, 1),
(132, 'REACTIVO DE HANUS', 3, 1, 5, 1),
(133, 'REACTIVO DE HANUS', 1, 1, 5, 1),
(134, 'DIETANOLAMINA', 1, 1, 5, 1),
(135, 'CLOROACETILO CLORURO RPE', 1, 1, 5, 1),
(136, 'SODIO ACETATO ANHIDRO', 1, 1, 6, 1),
(137, 'SODIO TETRATO 2 HIDRATO', 1, 1, 6, 1),
(138, 'SODIO TETRA-BORATO 10 HIDRATO', 2, 1, 6, 1),
(139, 'TETRABORATO SODICO', 1, 1, 6, 1),
(140, 'SODIO TETRA-FENILBORATO', 4, 1, 6, 1),
(141, 'SODIO HIDROGENOCARBONATO', 1, 1, 6, 1),
(142, 'SODIO HIDROGENOCARBONATO', 2, 1, 6, 1),
(143, 'CARBOXIMETILCELULOSA SAL SODICA', 1, 1, 6, 1),
(144, 'SODIO FOSFATO MONO-BASICO 2-HIDRATO', 1, 1, 6, 1),
(145, 'SODIO FOSFATO MONO-BASICO 2-HIDRATO', 1, 1, 6, 1),
(146, 'SODIO FOSFATO MONO-BASICO 1-HIDRATO', 2, 1, 6, 1),
(147, 'SODIO FOSFATO MONO-BASICO 2-HIDRATO', 1, 1, 6, 1),
(148, 'SODIO FOSFATO DI-BASICO ANHIDRATO', 1, 1, 6, 1),
(149, 'SODIO HIDRÓGENO FOSFATO ANHIDRO', 1, 1, 6, 1),
(150, 'FOSFATO TRISÓDICO ANHIDRO', 1, 1, 6, 1),
(151, 'DI-SODIO HIDRÓGENO FOSFATO ANHIDRO', 1, 1, 6, 1),
(152, 'DI-SODIO HIDRÓGENO FOSFATO ANHIDRO', 1, 1, 6, 1),
(153, 'ÁCIDO ETILENDIAMINOTETRAACÉTICO SAL DISÓDICA 2-HIDRATO', 1, 1, 6, 1),
(154, 'SODIO MOLIBDATO 2-HIDRATO', 1, 1, 6, 1),
(155, 'SODIO MOLIBDATO CRIST', 1, 1, 6, 1),
(156, 'MOLIBDENO (VI) ÓXIDO', 2, 1, 6, 1),
(157, 'Bandejas ', 4, 0, 13, 2),
(158, 'Vaso medidor ', 2, 0, 13, 2),
(159, 'Botellas con cierre manual', 2, 0, 13, 2),
(160, 'Exprimidor ', 1, 0, 13, 2),
(161, 'Vasos variados ', 10, 0, 13, 2),
(162, 'Coladores ', 3, 0, 13, 2),
(163, 'Ladrillos', 4, 0, 13, 2),
(164, 'Jeringa', 1, 0, 13, 2),
(165, 'Vasos de precipitados', 2, 0, 11, 3),
(166, 'Vasos de precipitados ', 2, 0, 11, 3),
(167, 'Vaso de precipitados ', 1, 0, 11, 3),
(168, 'Matraz erlenmeyer grande', 1, 0, 11, 3),
(169, 'Matraz erlenmeyer con tapón de cristal', 1, 0, 11, 3),
(170, 'Matraz erlenmeyer ', 1, 0, 11, 3),
(171, 'Matraz erlenmeyer ', 1, 0, 11, 3),
(172, 'Recipiente aséptico ', 1, 0, 12, 3),
(173, 'Tubos de ensayo graduados ', 1, 0, 12, 3),
(174, 'Conductímetro', 1, 0, 7, 3),
(175, 'Conductímetro', 1, 0, 8, 3),
(176, 'Potenciómetro', 1, 0, 9, 3),
(177, 'Potenciómetro', 1, 0, 10, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_auxiliares`
--

CREATE TABLE `productos_auxiliares` (
  `Id_Producto_Auxiliar` int(11) NOT NULL,
  `Formato` varchar(50) NOT NULL,
  `Id_Producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos_auxiliares`
--

INSERT INTO `productos_auxiliares` (`Id_Producto_Auxiliar`, `Formato`, `Id_Producto`) VALUES
(1, 'Plástico , verdes, medianas ', 157),
(2, 'Plástico', 158),
(3, 'Cristal', 159),
(4, 'Plástico ', 160),
(5, 'Plástico ', 161),
(6, 'Plástico, metal, tela', 162),
(7, 'De cerámica, 6 cuadrados enteros', 163),
(8, 'Plástico ', 164);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `quimicos`
--

CREATE TABLE `quimicos` (
  `Id_Quimico` int(11) NOT NULL,
  `Pureza` varchar(20) NOT NULL,
  `Fecha_Caducidad` varchar(20) DEFAULT NULL,
  `Id_Producto` int(11) NOT NULL,
  `Id_Formato` int(11) NOT NULL,
  `Id_Riesgo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `quimicos`
--

INSERT INTO `quimicos` (`Id_Quimico`, `Pureza`, `Fecha_Caducidad`, `Id_Producto`, `Id_Formato`, `Id_Riesgo`) VALUES
(1, 'No viene reflejado', 'No viene reflejada', 1, 1, 1),
(2, '99 %', 'No viene reflejada', 2, 1, 2),
(3, 'Puro', 'No viene reflejada', 3, 1, 2),
(4, '98 %', 'No viene reflejada', 4, 1, 3),
(5, 'Purísima', 'No viene reflejada', 5, 1, 4),
(6, '99 %', 'No viene reflejada', 6, 2, 4),
(7, '99 %', 'No viene reflejada', 7, 3, 5),
(8, '99 %', 'No viene reflejada', 8, 4, 6),
(9, '99,7 %', 'No viene reflejada', 9, 1, 6),
(10, 'No viene reflejado', 'No viene reflejada', 10, 5, 7),
(11, '98 %', 'No viene reflejada', 11, 2, 4),
(12, '99 %', 'No viene reflejada', 12, 4, 4),
(13, 'No viene reflejado', 'No viene reflejada', 13, 6, 5),
(14, 'No viene reflejado', 'No viene reflejada', 14, 7, 5),
(15, 'No viene reflejado', 'No viene reflejada', 15, 8, 4),
(16, 'No viene reflejado', 'No viene reflejada', 16, 8, 8),
(17, '99 %', 'No viene reflejada', 17, 6, 4),
(18, '99 %', 'No viene reflejada', 18, 3, 4),
(19, '99,5 %', 'No viene reflejada', 19, 4, 5),
(20, '99 %', 'No viene reflejada', 20, 1, 5),
(21, '98 %', 'No viene reflejada', 21, 6, 4),
(22, '99 %', 'No viene reflejada', 22, 1, 5),
(23, '99 %', 'No viene reflejada', 23, 1, 5),
(24, '99 %', 'No viene reflejada', 24, 3, 5),
(25, '98 %', 'No viene reflejada', 25, 3, 9),
(26, '98 %', 'No viene reflejada', 26, 3, 3),
(27, '99 %', 'No viene reflejada', 27, 4, 10),
(28, '95 %', 'No viene reflejada', 28, 4, 7),
(29, '99 %', 'No viene reflejada', 29, 1, 11),
(30, 'No viene reflejado', 'No viene reflejada', 30, 6, 11),
(31, '98 %', 'No viene reflejada', 31, 1, 12),
(32, '98 %', 'No viene reflejada', 32, 1, 5),
(33, '98 %', 'No viene reflejada', 33, 1, 13),
(34, '80 %', 'No viene reflejada', 34, 1, 4),
(35, '99,5 %', 'No viene reflejada', 35, 1, 5),
(36, '98 %', 'No viene reflejada', 36, 1, 5),
(37, '98 %', 'No viene reflejada', 37, 3, 4),
(38, '85 %', 'No viene reflejada', 38, 4, 5),
(39, 'Purísima', 'No viene reflejada', 39, 1, 4),
(40, '99 %', 'No viene reflejada', 40, 1, 4),
(41, 'No viene reflejado', 'No viene reflejada', 41, 6, 4),
(42, '98 %', 'No viene reflejada', 42, 1, 14),
(43, '99 %', 'No viene reflejada', 43, 1, 5),
(44, '98 %', 'No viene reflejada', 44, 4, 15),
(45, '98 %', 'No viene reflejada', 45, 6, 4),
(46, 'Puro', 'No viene reflejada', 46, 6, 4),
(47, '98 %', 'No viene reflejada', 47, 1, 16),
(48, '99 %', 'No viene reflejada', 48, 1, 6),
(49, 'Puro', 'No viene reflejada', 49, 2, 6),
(50, 'Puro', 'No viene reflejada', 50, 1, 6),
(51, '98 %', 'No viene reflejada', 51, 1, 5),
(52, '99,5 %', 'No viene reflejada', 52, 3, 5),
(53, 'No viene reflejado', 'No viene reflejada', 53, 7, 6),
(54, '99 %', 'No viene reflejada', 54, 3, 5),
(55, '98 %', 'No viene reflejada', 55, 4, 4),
(56, '99 %', 'No viene reflejada', 56, 4, 4),
(57, 'Puro', 'No viene reflejada', 57, 3, 4),
(58, '98 %', 'No viene reflejada', 58, 3, 4),
(59, '99 %', 'No viene reflejada', 59, 1, 5),
(60, '98,5 %', 'No viene reflejada', 60, 6, 3),
(61, '99 %', 'No viene reflejada', 61, 4, 7),
(62, 'No viene reflejado', 'No viene reflejada', 62, 1, 4),
(63, '99 %', 'No viene reflejada', 63, 4, 5),
(64, '99 %', 'No viene reflejada', 64, 1, 5),
(65, 'No viene reflejado', 'No viene reflejada', 65, 3, 17),
(66, 'No viene reflejado', 'No viene reflejada', 66, 2, 17),
(67, '99 %', 'No viene reflejada', 67, 1, 17),
(68, 'Puro', 'No viene reflejada', 68, 6, 17),
(69, '99 %', 'No viene reflejada', 69, 4, 5),
(70, '98 %', 'No viene reflejada', 70, 4, 5),
(71, '98 %', 'No viene reflejada', 71, 4, 5),
(72, 'Puro', 'No viene reflejada', 72, 4, 5),
(73, '98 %', 'No viene reflejada', 73, 1, 5),
(74, '95 %', 'No viene reflejada', 74, 1, 6),
(75, '99 %', 'No viene reflejada', 75, 9, 6),
(76, '98 %', 'No viene reflejada', 76, 4, 5),
(77, '95 %', 'No viene reflejada', 77, 1, 6),
(78, '99,55 %', 'No viene reflejada', 78, 3, 18),
(79, '100 %', 'No viene reflejada', 79, 1, 4),
(80, '99,5 %', 'No viene reflejada', 80, 4, 4),
(81, '99,5 %', 'No viene reflejada', 81, 1, 5),
(82, 'Puro', 'No viene reflejada', 82, 4, 7),
(83, '99 %', 'No viene reflejada', 83, 4, 4),
(84, '97 %', 'No viene reflejada', 84, 3, 5),
(85, '99 %', 'No viene reflejada', 85, 3, 4),
(86, '99 %', 'No viene reflejada', 86, 6, 5),
(87, '30 %', 'No viene reflejada', 87, 7, 19),
(88, '99 %', 'No viene reflejada', 88, 7, 6),
(89, '99 %', 'No viene reflejada', 89, 7, 6),
(90, '98,5 %', 'No viene reflejada', 90, 7, 5),
(91, '98 %', 'No viene reflejada', 91, 3, 6),
(92, '99 %', 'No viene reflejada', 92, 3, 8),
(93, '99 %', 'No viene reflejada', 93, 4, 5),
(94, '99 %', 'No viene reflejada', 94, 2, 20),
(95, '99 %', 'No viene reflejada', 95, 7, 5),
(96, '99 %', 'No viene reflejada', 96, 1, 4),
(97, 'Purísimo', 'No viene reflejada', 97, 6, 4),
(98, 'No viene reflejado', 'No viene reflejada', 98, 7, 21),
(99, '98 %', 'No viene reflejada', 99, 4, 9),
(100, '98 %', 'No viene reflejada', 100, 4, 9),
(101, 'Purísimo', 'No viene reflejada', 101, 6, 22),
(102, '99 %', 'No viene reflejada', 102, 2, 9),
(103, '99 %', 'No viene reflejada', 103, 3, 5),
(104, '96 %', 'No viene reflejada', 104, 2, 5),
(105, '96 %', 'No viene reflejada', 105, 3, 5),
(106, '99 %', 'No viene reflejada', 106, 4, 5),
(107, 'No viene reflejado', 'No viene reflejada', 107, 7, 4),
(108, 'Purísimo', 'No viene reflejada', 108, 6, 7),
(109, '98 %', 'No viene reflejada', 109, 3, 5),
(110, 'No viene reflejado', 'No viene reflejada', 110, 6, 4),
(111, '99,7 %', 'No viene reflejada', 111, 7, 23),
(112, '99,9 %', 'No viene reflejada', 112, 7, 23),
(113, '99,9 %', 'No viene reflejada', 113, 10, 23),
(114, '99,5 %', 'No viene reflejada', 114, 11, 8),
(115, '99,7 %', 'No viene reflejada', 115, 7, 24),
(116, '98 %', 'No viene reflejada', 116, 7, 8),
(117, '37 %', 'No viene reflejada', 117, 10, 25),
(118, '37 %', 'No viene reflejada', 118, 7, 25),
(119, '37 %', 'No viene reflejada', 119, 7, 25),
(120, 'No viene reflejado', 'No viene reflejada', 120, 7, 23),
(121, '60 %', 'No viene reflejada', 121, 7, 26),
(122, '85 %', 'No viene reflejada', 122, 7, 8),
(123, '85 %', 'No viene reflejada', 123, 7, 8),
(124, '65 %', 'No viene reflejada', 124, 7, 27),
(125, '65 %', 'No viene reflejada', 125, 7, 27),
(126, '70 %', 'No viene reflejada', 126, 7, 8),
(127, '96 %', 'No viene reflejada', 127, 6, 4),
(128, '98 %', 'No viene reflejada', 128, 7, 8),
(129, 'No viene reflejado', 'No viene reflejada', 129, 11, 28),
(130, '95 %', 'No viene reflejada', 130, 8, 8),
(131, '85 %', 'No viene reflejada', 131, 7, 8),
(132, 'No viene reflejado', 'No viene reflejada', 132, 7, 8),
(133, 'No viene reflejado', 'No viene reflejada', 133, 7, 8),
(134, '99 %', 'No viene reflejada', 134, 12, 4),
(135, 'Puro', 'No viene reflejada', 135, 12, 8),
(136, '99 %', 'No viene reflejada', 136, 6, 4),
(137, '99 %', 'No viene reflejada', 137, 4, 4),
(138, 'No viene reflejado', 'No viene reflejada', 138, 13, 4),
(139, 'No viene reflejado', 'No viene reflejada', 139, 6, 4),
(140, '99 %', 'No viene reflejada', 140, 14, 4),
(141, '99,9 %', 'No viene reflejada', 141, 1, 4),
(142, '99 %', 'No viene reflejada', 142, 1, 4),
(143, '99,5 %', 'No viene reflejada', 143, 3, 4),
(144, '99,10 %', 'No viene reflejada', 144, 3, 4),
(145, 'Puro', 'No viene reflejada', 145, 3, 4),
(146, '99 %', 'No viene reflejada', 146, 4, 4),
(147, '99 %', 'No viene reflejada', 147, 4, 4),
(148, '98 %', 'No viene reflejada', 148, 4, 4),
(149, '99 %', 'No viene reflejada', 149, 1, 4),
(150, 'No viene reflejado', 'No viene reflejada', 150, 4, 4),
(151, '98 %', 'No viene reflejada', 151, 4, 4),
(152, '99 %', 'No viene reflejada', 152, 4, 4),
(153, '99 %', 'No viene reflejada', 153, 3, 5),
(154, '99 %', 'No viene reflejada', 154, 1, 4),
(155, '99 %', 'No viene reflejada', 155, 1, 4),
(156, '99 %', 'No viene reflejada', 156, 3, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `riesgos`
--

CREATE TABLE `riesgos` (
  `Id_Riesgos` int(11) NOT NULL,
  `Riesgo` mediumblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `riesgos`
--

INSERT INTO `riesgos` (`Id_Riesgos`, `Riesgo`) VALUES
(1, 0x436f6d627572656e74652079206972726974616e746520),
(2, 0x546f7869636964616420616775646120283629),
(3, 0x436f6d627572656e74652079206e6f6369766f),
(4, 0x4174656e6369c3b36e),
(5, 0x4e6f6369766f),
(6, 0x4972726974616e7465),
(7, 0x546f78696369646164206167756461),
(8, 0x436f72726f7369766f),
(9, 0x4e6f6369766f20792070656c6967726f736f207061726120656c206d6564696f20616d6269656e7465),
(10, 0x436f6d627572656e74652c20636f72726f7369766f20792070656c6967726f736f207061726120656c206d6564696f20616d6269656e7465),
(11, 0x4e6f6369766f2c2070656c6967726f736f207061726120656c206d6564696f20616d6269656e7465207920636f72726f7369766f),
(12, 0x436f6d627572656e7465),
(13, 0x436f6d627572656e74652079206972726974616e7465),
(14, 0x4e6f6369766f2c20636f6d627572656e74652c20636f72726f7369766f2c2070656c6967726f736f207061726120656c206d6564696f20616d6269656e746520792063617263696e6f67656e6f),
(15, 0x4e6f6369766f207920636f6d627572656e7465),
(16, 0x436f6d627572656e746520792070656c6967726f736f207061726120656c206d6564696f20616d6269656e7465),
(17, 0x436f6d627572656e74652c206e6f6369766f20792070656c6967726f736f207061726120656c206d6564696f20616d6269656e7465),
(18, 0x436f72726f7369766f2c2070656c6967726f736f207061726120656c206d6564696f20616d6269656e746520792063617263696ec3b367656e6f),
(19, 0x436f72726f7369766f2c2070656c6967726f736f207061726120656c206d6564696f20616d6269656e74652c206e6f6369766f2079206972726974616e7465),
(20, 0x4e6f6369766f2079206972726974616e7465),
(21, 0x4e6f6369766f2c206972726974616e746520792063617263696ec3b367656e6f),
(22, 0x496e666c616d61626c65),
(23, 0x496e666c616d61626c65207920636f72726f7369766f),
(24, 0x546f78696369646164206167756461207920636f72726f7369766f),
(25, 0x436f72726f7369766f2c206e6f6369766f2079206972726974616e7465),
(26, 0x436f6d627572656e7465207920636f72726f7369766f),
(27, 0x436f6d627572656e74652c20746f78696369646164206167756461207920636f72726f7369766f),
(28, 0x546f78696369646164206167756461207920636f72726f7369766f2e);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salas`
--

CREATE TABLE `salas` (
  `Id_Almacen` int(11) NOT NULL,
  `Nombre_Almacen` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `salas`
--

INSERT INTO `salas` (`Id_Almacen`, `Nombre_Almacen`) VALUES
(1, 'Almacén General'),
(2, 'Laboratorio Instrumental'),
(3, 'Almacén 1/principal');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicaciones`
--

CREATE TABLE `ubicaciones` (
  `Id_Ubicacion` int(11) NOT NULL,
  `Nombre_Ubicacion` varchar(100) NOT NULL,
  `Codigo_Almacen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ubicaciones`
--

INSERT INTO `ubicaciones` (`Id_Ubicacion`, `Nombre_Ubicacion`, `Codigo_Almacen`) VALUES
(1, '5N', 3),
(2, '4N', 3),
(3, '3N', 3),
(4, '2N', 3),
(5, '1CA', 3),
(6, '8l', 3),
(7, 'C1', 2),
(8, 'C2', 2),
(9, 'P1', 2),
(10, 'P2', 2),
(11, 'estantería 1, balda 3', 1),
(12, 'estantería 1,balda 4', 1),
(13, 'estantería 0, balda 4 ', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `username` varchar(10) NOT NULL,
  `password` varchar(50) NOT NULL,
  `type` enum('admin','viewer') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`username`, `password`, `type`) VALUES
('admin', 'admin', 'admin'),
('alumno', 'alumno', 'viewer'),
('antonio', 'antonio', 'admin');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `formato`
--
ALTER TABLE `formato`
  ADD PRIMARY KEY (`Id_Formato`);

--
-- Indices de la tabla `materiales`
--
ALTER TABLE `materiales`
  ADD PRIMARY KEY (`Id_Material`),
  ADD KEY `FK_Productos_Materiales` (`Id_Producto`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`Id_Producto`),
  ADD KEY `FK_Ubicacion_Productos` (`Id_Ubicacion`);

--
-- Indices de la tabla `productos_auxiliares`
--
ALTER TABLE `productos_auxiliares`
  ADD PRIMARY KEY (`Id_Producto_Auxiliar`),
  ADD KEY `FK_ProductosAux_Productos` (`Id_Producto`);

--
-- Indices de la tabla `quimicos`
--
ALTER TABLE `quimicos`
  ADD PRIMARY KEY (`Id_Quimico`),
  ADD KEY `FK_Formato_Quimico` (`Id_Formato`),
  ADD KEY `Fk_Producto_Quimico` (`Id_Producto`),
  ADD KEY `Fk_Riesgos_Quimico` (`Id_Riesgo`);

--
-- Indices de la tabla `riesgos`
--
ALTER TABLE `riesgos`
  ADD PRIMARY KEY (`Id_Riesgos`);

--
-- Indices de la tabla `salas`
--
ALTER TABLE `salas`
  ADD PRIMARY KEY (`Id_Almacen`);

--
-- Indices de la tabla `ubicaciones`
--
ALTER TABLE `ubicaciones`
  ADD PRIMARY KEY (`Id_Ubicacion`),
  ADD KEY `FK_Salas_Ubicaciones` (`Codigo_Almacen`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `materiales`
--
ALTER TABLE `materiales`
  MODIFY `Id_Material` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `productos_auxiliares`
--
ALTER TABLE `productos_auxiliares`
  MODIFY `Id_Producto_Auxiliar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `materiales`
--
ALTER TABLE `materiales`
  ADD CONSTRAINT `FK_Productos_Materiales` FOREIGN KEY (`Id_Producto`) REFERENCES `productos` (`Id_Producto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `FK_Ubicacion_Productos` FOREIGN KEY (`Id_Ubicacion`) REFERENCES `ubicaciones` (`Id_Ubicacion`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos_auxiliares`
--
ALTER TABLE `productos_auxiliares`
  ADD CONSTRAINT `FK_ProductosAux_Productos` FOREIGN KEY (`Id_Producto`) REFERENCES `productos` (`Id_Producto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `quimicos`
--
ALTER TABLE `quimicos`
  ADD CONSTRAINT `FK_Formato_Quimico` FOREIGN KEY (`Id_Formato`) REFERENCES `formato` (`Id_Formato`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Fk_Producto_Quimico` FOREIGN KEY (`Id_Producto`) REFERENCES `productos` (`Id_Producto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Fk_Riesgos_Quimico` FOREIGN KEY (`Id_Riesgo`) REFERENCES `riesgos` (`Id_Riesgos`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ubicaciones`
--
ALTER TABLE `ubicaciones`
  ADD CONSTRAINT `FK_Salas_Ubicaciones` FOREIGN KEY (`Codigo_Almacen`) REFERENCES `salas` (`Id_Almacen`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
