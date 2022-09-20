-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-03-2022 a las 05:05:17
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bluni`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `computer`
--

CREATE TABLE `computer` (
                            `id` bigint(20) NOT NULL,
                            `board` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                            `color` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                            `disco_duro` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                            `grafica` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                            `mac` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                            `marca` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                            `modelo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                            `procesador` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                            `ram` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                            `tipo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                            `ubicaciones_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
                         `id` int(11) NOT NULL,
                         `user_id` int(11) NOT NULL,
                         `rol` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `user_id`, `rol`) VALUES
                                                 (1, 1, 'ROLE_USER'),
                                                 (3, 2, 'ROLE_ADMIN'),
                                                 (2, 2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicaciones`
--

CREATE TABLE `ubicaciones` (
                               `id` bigint(20) NOT NULL,
                               `ubicacion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
                         `id` int(11) NOT NULL,
                         `username` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
                         `password` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
                         `enabled` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `enabled`) VALUES
                                                                  (1, 'user', '$2a$10$KKN/gjZ/eKQTvlkUrxTBYOUdqjHn/if2lx585Hpb94jXDQFfTmkVm', 1),
                                                                  (2, 'admin', '$2a$10$ftbHEG1WT0bTSrRMxVI6tOKvT0WakVPiaUTbVXGoDsJn8hFqgwqlO', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `computer`
--
ALTER TABLE `computer`
    ADD PRIMARY KEY (`id`),
    ADD KEY `FKstlww21xgcgili44v3efem3ra` (`ubicaciones_id`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `user_id_rol_unique` (`user_id`,`rol`);

--
-- Indices de la tabla `ubicaciones`
--
ALTER TABLE `ubicaciones`
    ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `username_UNIQUE` (`username`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `computer`
--
ALTER TABLE `computer`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ubicaciones`
--
ALTER TABLE `ubicaciones`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `computer`
--
ALTER TABLE `computer`
    ADD CONSTRAINT `FKstlww21xgcgili44v3efem3ra` FOREIGN KEY (`ubicaciones_id`) REFERENCES `ubicaciones` (`id`);

--
-- Filtros para la tabla `roles`
--
ALTER TABLE `roles`
    ADD CONSTRAINT `fk_rol_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
