USE control_inventario;

-- Se agregan los sexos
INSERT INTO sexo (Id_Sexo, sexo) 
	VALUES 
		('1', 'Masculino'),
        ('2', 'Femenino');						    

-- Se crea una empresa base
INSERT INTO empresa VALUES('1','La Despensa de Sofy','Col. Rio Grande Sur', '08012000031054','sofiagineth4@gmail.com');

-- Se crean los roles de los empleadosCREATE DATABASE `control_inventario` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

INSERT INTO rol_empleado (rol_empleado)
	VALUES
		('Gerente'),
        ('Vendedor'),
        ('Limpiador'),
        ('Comprador');

-- Se agregan algunos empleados 
INSERT INTO empleado (p_nombre, s_nombre, p_apellido, s_apellido, correo, edad, fecha_ingreso, salario, DNI, Id_Empresa, Id_Sexo, Id_Rol) 
	VALUES 
		('Juan', 'Antonio', 'Gamez', 'Cedillo', 'gamezc@gamil.com', 32, '2020-12-15', 7500.30, '0809-1987-00038', 1, 1, 3),
        ('Elias', 'Javier', 'Rodrigez', 'Mendoza', 'elias.mendoza@gamil.com', 35, '2019-6-15', 15000.30, '0809-1984-06038', 1, 1, 1),
        ('Sindi', 'Yasmin', 'Cedillo', 'Cedillo', 'yasminroma@gamil.com', 21, '2020-01-07', 9000.30, '0809-1999-00020', 1, 2, 2),
        ('Nesly', 'Jossibel', 'Castro', 'Nolasgo', 'nela66@gamil.com', 25, '2020-01-07', 9000.30, '0809-1995-04033', 1, 2, 4);
        
-- Se crean algunos clientes
INSERT INTO cliente (p_nombre, s_nombre, p_apellido, s_apellido, correo, DNI, direccion)
	VALUES
		('Marlon', 'Javier', 'Cedillo', 'Romero', 'javiercm@gmail.com', '1010-2002-00398', 'Bañaderos, San Antonio, Intibuca'),
        ('Anai', 'Karen', 'Argueta', 'Cornejo', 'argueta@gmail.com', '1010-2001-00398', 'Bañaderos, San Antonio, Intibuca'),
        ('Edis', 'Ondina', 'Castro', 'Rodriguez', 'edisondina@gmail.com', '1010-1999-00398', 'Bañaderos, Santa Lucia, Intibuca');
        
-- Se crean algunas marcas
INSERT INTO marca (nombre_marca)
	VALUES 
		('Mazola'),
        ('Torti Masa'),
        ('CocaCola'),
        ('BAYER');

-- Se crean algunas secciones
INSERT INTO seccion_producto (nombre_seccion_producto)
	VALUES 
		('Cocina'),
        ('Refrescos'),
        ('Medicamentos');

-- Se crean algunos tipos de productos
INSERT INTO tipo_producto (nombre_tipo_producto)
	VALUES 
		('Comestible'),
        ('Pastilla'),
        ('Bebible');

-- Se crean algunos productos
INSERT INTO producto (nombre_producto, fecha_caducidad, precio_venta, medida, cantidad_disponible, cantidad_media, Id_Tipo_Producto, Id_Seccion_Producto, Id_Marca)
	VALUES
		('Manteca', '2022-04-28', 11, '1/2 libra', 80, 120, 1, 1, 1),
        ('Manteca', '2022-04-28', 37, '1 kilogramo', 54, 70, 1, 1, 1),
        ('Maseca', '2022-01-02', 20, '2 libra', 70, 120, 1, 1, 2),
        ('Acetaminofen', '2022-06-28', 2, '10 gramos', 120, 300, 2, 3, 4);
        
-- Se agregan algunos proveedores
INSERT INTO proveedor (nombre, correo, direccion, RTN)
	VALUES
		('Distribuidora Perez', 'perez.distribuidora@gmail.com', 'Santa Cruz de Yojoa', '95792653916'),
        ('Infama', 'infamahn@gmail.com', 'San Pedro Sula', '25892653111');
        
-- Asignacion de proveedores a los productos
INSERT INTO productoproveedores (Id_Producto, Id_Proveedor, precio_compra)
	VALUES
		(1, 1, 7.50),
        (2, 1, 31.20),
        (3, 1, 15.80),
        (4, 2, 0.70);
        
