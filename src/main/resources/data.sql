INSERT INTO public."CLIENTS"
(phone_number, zip, address, city, country, dni, email, first_name, last_name)
VALUES
(123456789, 28001, 'Calle Mayor 1', 'Madrid', 'España', 'DNI0001', 'ana.lopez@example.com', 'Ana', 'López'),
(234567890, 08002, 'Passeig de Gràcia 10', 'Barcelona', 'España', 'DNI0002', 'carlos.perez@example.com', 'Carlos', 'Pérez'),
(345678901, 41001, 'Avenida de la Constitución 15', 'Sevilla', 'España', 'DNI0003', 'maria.garcia@example.com', 'María', 'García'),
(456789012, 46001, 'Calle Colón 20', 'Valencia', 'España', 'DNI0004', 'juan.martin@example.com', 'Juan', 'Martín'),
(567890123, 50001, 'Paseo Independencia 5', 'Zaragoza', 'España', 'DNI0005', 'lucia.rodriguez@example.com', 'Lucía', 'Rodríguez'),
(678901234, 15001, 'Rúa do Franco 8', 'A Coruña', 'España', 'DNI0006', 'javier.sanchez@example.com', 'Javier', 'Sánchez'),
(789012345, 39001, 'Calle Burgos 3', 'Santander', 'España', 'DNI0007', 'laura.gomez@example.com', 'Laura', 'Gómez'),
(890123456, 33001, 'Calle Uría 12', 'Oviedo', 'España', 'DNI0008', 'david.fernandez@example.com', 'David', 'Fernández'),
(901234567, 07001, 'Carrer de Sant Miquel 7', 'Palma', 'España', 'DNI0009', 'sara.ramos@example.com', 'Sara', 'Ramos'),
(912345678, 35001, 'Avenida Marítima 22', 'Las Palmas', 'España', 'DNI0010', 'diego.ruiz@example.com', 'Diego', 'Ruiz');

INSERT INTO public."EXERCISES"
(recommended_min_reps, recommended_max_reps, recommended_sets, muscle, name, equipment)
VALUES
(8, 12, 3, 'BICEPS', 'Curl de biceps', 'Barra'),
(8, 12, 3, 'BICEPS', 'Curl de biceps', 'Máquina'),
(8, 12, 3, 'BICEPS', 'Curl de biceps', 'Polea'),
(10, 15, 4, 'TRICEPS', 'Fondos en paralelas', 'Peso corporal'),
(10, 15, 4, 'TRICEPS', 'Press francés', 'Mancuernas'),
(10, 15, 4, 'TRICEPS', 'Triceps en polea', 'Polea'),
(8, 12, 3, 'SHOULDER', 'Press militar', 'Mancuernas'),
(8, 12, 3, 'SHOULDER', 'Press militar', 'Máquina'),
(8, 12, 3, 'SHOULDER', 'Press militar', 'Barra'),
(8, 12, 3, 'SHOULDER', 'Elevaciones laterales', 'Mancuernas'),
(8, 12, 3, 'SHOULDER', 'Elevaciones laterales', 'Polea'),
(8, 12, 3, 'FOREARMS', 'Curl inverso con barra', 'Barra'),
(8, 12, 4, 'CHEST', 'Press inclinado con mancuernas', 'Mancuernas'),
(8, 12, 4, 'CHEST', 'Press de pecho', 'Mancuernas'),
(8, 12, 4, 'CHEST', 'Press de pecho', 'Barra'),
(8, 12, 4, 'CHEST', 'Press de pecho', 'Maquina'),
(8, 12, 4, 'UPPER_BACK', 'Remo con barra T', 'Barra'),
(8, 12, 4, 'UPPER_BACK', 'Jalón con agarre abierto', 'Polea'),
(8, 12, 3, 'LATS', 'Jalón con agarre neutro', 'Polea'),
(8, 12, 4, 'QUADS', 'Prensa de piernas', 'Máquina'),
(8, 12, 4, 'QUADS', 'Sentadilla', 'Barra'),
(8, 12, 3, 'FEMORAL', 'Peso muerto rumano', 'Barra'),
(8, 12, 3, 'CALVES', 'Elevación de talones sentado', 'Máquina');