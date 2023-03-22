-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-03-2023 a las 01:55:37
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `my_citas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cat_horarios`
--

CREATE TABLE `cat_horarios` (
  `idcat_horarios` int(11) NOT NULL,
  `hora` time NOT NULL,
  `status` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cat_horarios`
--

INSERT INTO `cat_horarios` (`idcat_horarios`, `hora`, `status`) VALUES
(1, '08:00:00', 1),
(2, '09:00:00', 1),
(3, '10:00:00', 1),
(4, '11:00:00', 1),
(5, '12:00:00', 1),
(6, '13:00:00', 1),
(7, '14:00:00', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `id_citas` int(11) NOT NULL,
  `id_consultorio` int(11) NOT NULL,
  `id_medico` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `id_cathorario` int(11) NOT NULL,
  `nom_paciente` varchar(45) NOT NULL,
  `estado` int(11) NOT NULL DEFAULT 0,
  `status` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `citas`
--

INSERT INTO `citas` (`id_citas`, `id_consultorio`, `id_medico`, `fecha`, `id_cathorario`, `nom_paciente`, `estado`, `status`) VALUES
(1, 1, 1, '2023-03-21', 1, 'Edgar ', 0, 1),
(2, 1, 1, '2023-03-21', 1, 'Fernando', 0, 1),
(3, 1, 1, '2023-03-21', 1, 'Fernando', 0, 1),
(4, 1, 1, '2023-03-21', 1, 'Fernando', 0, 1),
(5, 1, 1, '2023-03-21', 1, 'Fernando', 0, 1),
(6, 1, 1, '2023-03-21', 1, 'Fernando', 0, 1),
(7, 1, 1, '2023-03-21', 1, 'Fernando', 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consultorios`
--

CREATE TABLE `consultorios` (
  `id` int(11) NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `piso` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `consultorios`
--

INSERT INTO `consultorios` (`id`, `numero`, `piso`, `status`) VALUES
(1, 101, 1, 1),
(2, 102, 2, 1),
(3, 103, 3, 1),
(4, 104, 4, 1),
(5, 105, 5, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicos`
--

CREATE TABLE `medicos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido_paterno` varchar(45) NOT NULL,
  `apellido_materno` varchar(45) NOT NULL,
  `especialidad` varchar(45) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `medicos`
--

INSERT INTO `medicos` (`id`, `nombre`, `apellido_paterno`, `apellido_materno`, `especialidad`, `status`) VALUES
(1, 'Hector', 'Gonzales', 'Ramirez', 'Cirujano', 1),
(2, 'Lidia', 'Perez', 'Ramirez', 'Cirujano', 1),
(3, 'Omar', 'Ortiz', 'Diaz', 'Pediatra', 1),
(4, 'Cecilia', 'Fuentes', 'Salas', 'Traumatologo', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cat_horarios`
--
ALTER TABLE `cat_horarios`
  ADD PRIMARY KEY (`idcat_horarios`);

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`id_citas`),
  ADD KEY `tcitas_fk_idmedico_idx` (`id_medico`),
  ADD KEY `tcitas_fk_id_cathorario_idx` (`id_cathorario`),
  ADD KEY `tcitas_fk_idconsultorio_idx` (`id_consultorio`);

--
-- Indices de la tabla `consultorios`
--
ALTER TABLE `consultorios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `medicos`
--
ALTER TABLE `medicos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cat_horarios`
--
ALTER TABLE `cat_horarios`
  MODIFY `idcat_horarios` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `id_citas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `consultorios`
--
ALTER TABLE `consultorios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `medicos`
--
ALTER TABLE `medicos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `tcitas_fk_id_cathorario` FOREIGN KEY (`id_cathorario`) REFERENCES `cat_horarios` (`idcat_horarios`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tcitas_fk_idconsultorio` FOREIGN KEY (`id_consultorio`) REFERENCES `consultorios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tcitas_fk_idmedico` FOREIGN KEY (`id_medico`) REFERENCES `medicos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
