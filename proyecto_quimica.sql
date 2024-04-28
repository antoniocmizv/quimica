-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-04-2024 a las 00:22:18
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materiales`
--

CREATE TABLE `materiales` (
  `Id_Material` int(11) NOT NULL,
  `Tipo` varchar(50) NOT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  `Fecha_Compra` date NOT NULL,
  `Id_Producto` int(11) NOT NULL,
  `N_Serie` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `Id_Producto` int(11) NOT NULL,
  `Nombre` varchar(80) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Stock_Minimo` int(11) NOT NULL,
  `Id_Ubicacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`Id_Producto`, `Nombre`, `Cantidad`, `Stock_Minimo`, `Id_Ubicacion`) VALUES
(1, 'Vasos de precipitados', 4, 1, 3),
(2, 'Matraz erlenmeyer grande', 15, 2, 4),
(3, 'Potenciómetro', 3, 2, 1),
(4, 'Bascula', 45, 2, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_auxiliares`
--

CREATE TABLE `productos_auxiliares` (
  `Id_Producto_Auxiliar` int(11) NOT NULL,
  `Formato` varchar(30) NOT NULL,
  `Id_Producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `quimicos`
--

CREATE TABLE `quimicos` (
  `Id_Quimico` int(11) NOT NULL,
  `Pureza` varchar(20) NOT NULL,
  `Fecha_Caducidad` date DEFAULT NULL,
  `Id_Producto` int(11) NOT NULL,
  `Id_Formato` int(11) NOT NULL,
  `Id_Riesgo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `riesgos`
--

CREATE TABLE `riesgos` (
  `Id_Riesgos` int(11) NOT NULL,
  `Riesgo` mediumblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salas`
--

CREATE TABLE `salas` (
  `Id_Almacen` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `salas`
--

INSERT INTO `salas` (`Id_Almacen`, `Nombre`) VALUES
(1, 'Almacen_General'),
(2, 'Laboratorio_Instrumental');

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
(1, 'estantería 1, balda 3', 1),
(2, 'estantería 1, balda 4', 1),
(3, 'C1', 2),
(4, 'C4', 2);

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
  ADD KEY `Fk_Riesgos_Quimico` (`Id_Riesgo`),
  ADD KEY `Fk_Producto_Quimico` (`Id_Producto`);

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
-- AUTO_INCREMENT de la tabla `formato`
--
ALTER TABLE `formato`
  MODIFY `Id_Formato` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `materiales`
--
ALTER TABLE `materiales`
  MODIFY `Id_Material` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `Id_Producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `productos_auxiliares`
--
ALTER TABLE `productos_auxiliares`
  MODIFY `Id_Producto_Auxiliar` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `quimicos`
--
ALTER TABLE `quimicos`
  MODIFY `Id_Quimico` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `riesgos`
--
ALTER TABLE `riesgos`
  MODIFY `Id_Riesgos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `salas`
--
ALTER TABLE `salas`
  MODIFY `Id_Almacen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
  ADD CONSTRAINT `FK_Ubicacion_Productos` FOREIGN KEY (`Id_Ubicacion`) REFERENCES `ubicaciones` (`Id_Ubicacion`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `productos_auxiliares`
--
ALTER TABLE `productos_auxiliares`
  ADD CONSTRAINT `FK_ProductosAux_Productos` FOREIGN KEY (`Id_Producto`) REFERENCES `productos` (`Id_Producto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `quimicos`
--
ALTER TABLE `quimicos`
  ADD CONSTRAINT `FK_Formato_Quimico` FOREIGN KEY (`Id_Formato`) REFERENCES `formato` (`Id_Formato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Fk_Producto_Quimico` FOREIGN KEY (`Id_Producto`) REFERENCES `productos` (`Id_Producto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Fk_Riesgos_Quimico` FOREIGN KEY (`Id_Riesgo`) REFERENCES `riesgos` (`Id_Riesgos`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ubicaciones`
--
ALTER TABLE `ubicaciones`
  ADD CONSTRAINT `FK_Salas_Ubicaciones` FOREIGN KEY (`Codigo_Almacen`) REFERENCES `salas` (`Id_Almacen`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
