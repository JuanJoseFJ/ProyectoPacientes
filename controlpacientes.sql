-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 27-10-2017 a las 07:27:29
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `controlpacientes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

CREATE TABLE IF NOT EXISTS `cita` (
  `idCita` int(11) NOT NULL AUTO_INCREMENT,
  `idPaciente` int(11) NOT NULL,
  `idDoctor` int(11) NOT NULL,
  `Fecha` varchar(25) NOT NULL,
  `Hora` int(11) NOT NULL,
  PRIMARY KEY (`idCita`),
  KEY `FKCita603156` (`idPaciente`),
  KEY `FKCita579836` (`idDoctor`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `cita`
--

INSERT INTO `cita` (`idCita`, `idPaciente`, `idDoctor`, `Fecha`, `Hora`) VALUES
(1, 1, 1, '27/10/2017', 12),
(2, 1, 1, '27/10/2017', 13);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `diagnostico`
--

CREATE TABLE IF NOT EXISTS `diagnostico` (
  `idDiagnostico` int(11) NOT NULL AUTO_INCREMENT,
  `idPaciente` int(11) NOT NULL,
  `Sintomas` varchar(200) NOT NULL,
  `PresionArterial` varchar(20) NOT NULL,
  `OtrosDatos` varchar(300) NOT NULL,
  PRIMARY KEY (`idDiagnostico`),
  KEY `FKDiagnostic985855` (`idPaciente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `doctores`
--

CREATE TABLE IF NOT EXISTS `doctores` (
  `idDoctor` int(11) NOT NULL AUTO_INCREMENT,
  `Apellidos` varchar(50) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Direccion` varchar(50) NOT NULL,
  `Telefono` varchar(12) NOT NULL,
  PRIMARY KEY (`idDoctor`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `doctores`
--

INSERT INTO `doctores` (`idDoctor`, `Apellidos`, `Nombre`, `Direccion`, `Telefono`) VALUES
(1, 'Aguilar', 'Fernando', '2dacalle', '12345678');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidades`
--

CREATE TABLE IF NOT EXISTS `especialidades` (
  `idEspecialidad` int(11) NOT NULL AUTO_INCREMENT,
  `idDoctor` int(11) NOT NULL,
  `CodEspecialidad` varchar(12) NOT NULL,
  `Especialidad` varchar(50) NOT NULL,
  PRIMARY KEY (`idEspecialidad`),
  KEY `FKEspecialid889296` (`idDoctor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE IF NOT EXISTS `pacientes` (
  `idPaciente` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  `DIreccion` varchar(50) NOT NULL,
  `Telefono` varchar(12) NOT NULL,
  `Foto` blob NOT NULL,
  `ObservGen` varchar(250) NOT NULL,
  PRIMARY KEY (`idPaciente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `pacientes`
--

INSERT INTO `pacientes` (`idPaciente`, `Nombre`, `Apellidos`, `DIreccion`, `Telefono`, `Foto`, `ObservGen`) VALUES
(1, 'Pegre', 'Rafael', '2da calle', '87654321', 0x313131, 'esta delirando');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cita`
--
ALTER TABLE `cita`
  ADD CONSTRAINT `FKCita579836` FOREIGN KEY (`idDoctor`) REFERENCES `doctores` (`idDoctor`),
  ADD CONSTRAINT `FKCita603156` FOREIGN KEY (`idPaciente`) REFERENCES `pacientes` (`idPaciente`);

--
-- Filtros para la tabla `diagnostico`
--
ALTER TABLE `diagnostico`
  ADD CONSTRAINT `FKDiagnostic985855` FOREIGN KEY (`idPaciente`) REFERENCES `pacientes` (`idPaciente`);

--
-- Filtros para la tabla `especialidades`
--
ALTER TABLE `especialidades`
  ADD CONSTRAINT `FKEspecialid889296` FOREIGN KEY (`idDoctor`) REFERENCES `doctores` (`idDoctor`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
