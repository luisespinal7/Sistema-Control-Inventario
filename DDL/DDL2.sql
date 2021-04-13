CREATE DATABASE CONTROL_INVENTARIO;
USE CONTROL_INVENTARIO;

CREATE TABLE TELEFONO(
Id_Telefono NCHAR(5) NOT NULL,
numero NVARCHAR(8) NOT NULL UNIQUE,
CONSTRAINT telefonoPK PRIMARY KEY(Id_Telefono));

CREATE TABLE SEXO(
Id_Sexo NCHAR(1) NOT NULL,
sexo NVARCHAR(15) NOT NULL,
CONSTRAINT sexoPK PRIMARY KEY(Id_Sexo));

CREATE TABLE ROL_EMPLEADO(
Id_Rol NCHAR(5) NOT NULL,
rol_empleado NVARCHAR(30) NOT NULL UNIQUE,
CONSTRAINT rolPK PRIMARY KEY(Id_Rol));

CREATE TABLE EMPRESA(
Id_Empresa NCHAR(5) NOT NULL,
nombre_empresa NVARCHAR(50) NOT NULL,
direccion NVARCHAR(70),
RTN NVARCHAR(15) NOT NULL UNIQUE,
correo NVARCHAR(50) UNIQUE,
CONSTRAINT empresaPK PRIMARY KEY(Id_Empresa));

CREATE TABLE TELXEMPRESA(
Id_Telefono NCHAR(5) NOT NULL,
Id_Empresa NCHAR(5) NOT NULL,
CONSTRAINT telefonoFK FOREIGN KEY(Id_Telefono) REFERENCES TELEFONO(Id_Telefono),
CONSTRAINT empresaFK FOREIGN KEY(Id_Empresa) REFERENCES EMPRESA(Id_Empresa));

CREATE TABLE EMPLEADO( 
Id_Empleado NCHAR(5) NOT NULL, 
p_nombre NVARCHAR(25) NOT NULL,
s_nombre NVARCHAR(25),
p_apellido NVARCHAR(25) NOT NULL,
s_apellido NVARCHAR(25),
correo NVARCHAR(50) UNIQUE,
edad NCHAR(3),
fecha_ingreso DATE,
salario FLOAT,
DNI NVARCHAR(15) NOT NULL UNIQUE,
Id_Empresa NCHAR(5) NOT NULL,
Id_Sexo NCHAR(1) NOT NULL,
Id_Rol NCHAR(5) NOT NULL,
usuario NVARCHAR(30) NOT NULL UNIQUE,
contrasenia NVARCHAR(30) NOT NULL,
CONSTRAINT empleadoPK PRIMARY KEY(Id_Empleado),
CONSTRAINT empresaFK1 FOREIGN KEY(Id_Empresa) REFERENCES EMPRESA(Id_Empresa),
CONSTRAINT sexoFK FOREIGN KEY(Id_Sexo) REFERENCES SEXO(Id_Sexo),
CONSTRAINT rolFK FOREIGN KEY(Id_Rol) REFERENCES ROL_EMPLEADO(Id_Rol));

CREATE TABLE TELXEMPLEADO(
Id_Telefono NCHAR(5) NOT NULL,
Id_Empleado NCHAR(5) NOT NULL,
CONSTRAINT telefonoFK1 FOREIGN KEY(Id_Telefono) REFERENCES TELEFONO(Id_Telefono),
CONSTRAINT empleadoFK FOREIGN KEY(Id_Empleado) REFERENCES EMPLEADO(Id_Empleado));

CREATE TABLE CLIENTE(
Id_Cliente NCHAR(5) NOT NULL,
p_nombre NVARCHAR(25) NOT NULL,
s_nombre NVARCHAR(25),
p_apellido NVARCHAR(25) NOT NULL,
s_apellido NVARCHAR(25),
correo NVARCHAR(50) UNIQUE,
DNI NVARCHAR(15) NOT NULL UNIQUE,
direccion NVARCHAR(70),
CONSTRAINT clientePK PRIMARY KEY(Id_Cliente));

CREATE TABLE TELXCLIENTE(
Id_Telefono NCHAR(5) NOT NULL,
Id_Cliente NCHAR(5) NOT NULL,
CONSTRAINT telefonoFK2 FOREIGN KEY(Id_Telefono) REFERENCES TELEFONO(Id_Telefono),
CONSTRAINT clienteFK FOREIGN KEY(Id_Cliente) REFERENCES CLIENTE(Id_Cliente));

CREATE TABLE TIPO_PRODUCTO(
Id_Tipo_Producto NCHAR(5) NOT NULL,
nombre_tipo_producto NVARCHAR(30) NOT NULL UNIQUE,
CONSTRAINT tipo_productoPK PRIMARY KEY(Id_Tipo_Producto));

CREATE TABLE SECCION_PRODUCTO(
Id_Seccion_Producto NCHAR(5) NOT NULL,
nombre_seccion_producto NVARCHAR(30) NOT NULL UNIQUE,
CONSTRAINT seccion_productoPK PRIMARY KEY(Id_Seccion_Producto));

CREATE TABLE MARCA(
Id_Marca NCHAR(5) NOT NULL,
nombre_marca NVARCHAR(30) NOT NULL UNIQUE,
CONSTRAINT marcaPK PRIMARY KEY(Id_Marca));

CREATE TABLE PRODUCTO(
Id_Producto NCHAR(5) NOT NULL,
nombre_producto NVARCHAR(50) NOT NULL,
fecha_caducidad DATE,
precio_venta FLOAT,
medida NVARCHAR(15),
cantidad_disponible NCHAR(5),
cantidad_media NCHAR(5),
Id_Tipo_Producto NCHAR(5),
Id_Seccion_Producto NCHAR(5),
Id_Marca NCHAR(5),
CONSTRAINT productoPK PRIMARY KEY(Id_Producto),
CONSTRAINT tipo_productoFK FOREIGN KEY(Id_Tipo_Producto) REFERENCES TIPO_PRODUCTO(Id_Tipo_Producto),
CONSTRAINT seccion_productoFK FOREIGN KEY(Id_Seccion_Producto) REFERENCES SECCION_PRODUCTO(Id_Seccion_Producto),
CONSTRAINT marcaFK FOREIGN KEY(Id_Marca) REFERENCES MARCA(Id_Marca));

CREATE TABLE PROVEEDOR(
Id_Proveedor NCHAR(5) NOT NULL,
nombre NVARCHAR(50),
correo NVARCHAR(50) UNIQUE, 
direccion NVARCHAR(70),
RTN NVARCHAR(15) NOT NULL UNIQUE,
CONSTRAINT proveedorPK PRIMARY KEY(Id_Proveedor));

CREATE TABLE TELXPROVEEDOR(
Id_Telefono NCHAR(5) NOT NULL,
Id_Proveedor NCHAR(5) NOT NULL,
CONSTRAINT telefonoFK3 FOREIGN KEY(Id_Telefono) REFERENCES TELEFONO(Id_Telefono),
CONSTRAINT proveedorFK FOREIGN KEY(Id_Proveedor) REFERENCES PROVEEDOR(Id_Proveedor));

CREATE TABLE DESCUENTO(
Id_Descuento NCHAR(5) NOT NULL,
tipo_descuento NVARCHAR(30) UNIQUE,
descuento FLOAT NOT NULL CHECK(descuento>0 and descuento<=1),
CONSTRAINT descuentoPK PRIMARY KEY(Id_Descuento));

CREATE TABLE PAGO(
Id_Pago NCHAR(5) NOT NULL,
nombre_pago NVARCHAR(30),
importe_total FLOAT,
importe_x_cuota FLOAT,
cantidad_cuotas NCHAR(5),
fecha_limite DATE,
CONSTRAINT pagpPK PRIMARY KEY(Id_Pago));

CREATE TABLE TIPO_PAGO(
Id_Tipo_Pago NCHAR(5) NOT NULL,
nombre_tipo_Pago NVARCHAR(5) UNIQUE,
CONSTRAINT tipoPagoPK PRIMARY KEY(Id_Tipo_Pago));

CREATE TABLE CUOTA(
Id_Cuota NCHAR(5) NOT NULL,
total_abonado FLOAT,
fecha_pago DATE,
Id_Pago NCHAR(5),
CONSTRAINT cuotaPK PRIMARY KEY(Id_Cuota),
CONSTRAINT pagoFK FOREIGN KEY(Id_Pago) REFERENCES PAGO(Id_Pago));

CREATE TABLE FACTURA_VENTA(
Id_Venta NCHAR(5) NOT NULL,
fecha DATE, 
subtotal FLOAT,
total FLOAT,
cancelo BOOL,
Id_Cliente NCHAR(5) NOT NULL,
Id_Descuento NCHAR(5),
Id_Empleado NCHAR(5) NOT NULL,
Id_Empresa NCHAR(5) NOT NULL,
Id_Pago NCHAR(5) NOT NULL,
CONSTRAINT ventaPK PRIMARY KEY(Id_Venta),
CONSTRAINT clienteFK1 FOREIGN KEY(Id_Cliente) REFERENCES CLIENTE(Id_Cliente),
CONSTRAINT descuentoFK FOREIGN KEY(Id_Descuento) REFERENCES DESCUENTO(Id_Descuento),
CONSTRAINT empleadoFK1 FOREIGN KEY(Id_Empleado) REFERENCES EMPLEADO(Id_Empleado),
CONSTRAINT empresaFK2 FOREIGN KEY(Id_Empresa) REFERENCES EMPRESA(Id_Empresa),
CONSTRAINT pagoFK1 FOREIGN KEY(Id_Pago) REFERENCES PAGO(Id_Pago));

CREATE TABLE FACTURA_COMPRA(
Id_Compra NCHAR(5) NOT NULL,
fecha DATE,
subtotal FLOAT,
descuento FLOAT,
total FLOAT,
Id_Pago NCHAR(5),
Id_Proveedor NCHAR(5),
CONSTRAINT compraPK PRIMARY KEY(Id_Compra),
CONSTRAINT proveedorFK1 FOREIGN KEY(Id_Proveedor) REFERENCES PROVEEDOR(Id_Proveedor),
CONSTRAINT pagoFK2 FOREIGN KEY(Id_Pago) REFERENCES PAGO(Id_Pago));

CREATE TABLE PRODUCTO_COMPRA(
Id_Compra NCHAR(5) NOT NULL,
Id_Producto NCHAR(5) NOT NULL,
precio_unitario FLOAT,
cantidad NCHAR(5),
CONSTRAINT producto_compraPK PRIMARY KEY(Id_Compra,Id_Producto),
CONSTRAINT compraFK FOREIGN KEY(Id_Compra) REFERENCES FACTURA_COMPRA(Id_Compra),
CONSTRAINT productoFK1 FOREIGN KEY(Id_Producto) REFERENCES PRODUCTO(Id_Producto));

CREATE TABLE PRODUCTO_VENTA(
Id_Venta NCHAR(5) NOT NULL,
Id_Producto NCHAR(5) NOT NULL,
precio_unitario FLOAT,
cantidad NCHAR(5),
CONSTRAINT producto_ventaPK PRIMARY KEY(Id_Venta,Id_Producto),
CONSTRAINT ventaFK FOREIGN KEY(Id_Venta) REFERENCES FACTURA_VENTA(Id_Venta),
CONSTRAINT productoFK2 FOREIGN KEY(Id_Producto) REFERENCES PRODUCTO(Id_Producto));

CREATE TABLE DEVOLUCION_COMPRA(
Id_Dev_Compra NCHAR(5) NOT NULL,
fecha_devolucion DATE,
total FLOAT,
Id_Proveedor NCHAR(5),
CONSTRAINT dev_compraPK PRIMARY KEY(Id_Dev_Compra),
CONSTRAINT proveedorFK2 FOREIGN KEY(Id_Proveedor) REFERENCES PROVEEDOR(Id_Proveedor));

CREATE TABLE PRODUCTOXDEV_COMPRA(
Id_Dev_Compra NCHAR(5) NOT NULL,
Id_Producto NCHAR(5) NOT NULL,
cantidad NCHAR(5),
precio_unitario FLOAT,
razon VARCHAR(150),
CONSTRAINT productoxdev_compraPK PRIMARY KEY(Id_Dev_Compra,Id_Producto),
CONSTRAINT dev_compraFK FOREIGN KEY(Id_Dev_Compra) REFERENCES DEVOLUCION_COMPRA(Id_Dev_Compra),
CONSTRAINT productoFK3 FOREIGN KEY(Id_Producto) REFERENCES PRODUCTO(Id_Producto));

CREATE TABLE DEVOLUCION_VENTA(
Id_Dev_Venta NCHAR(5) NOT NULL,
fecha_devolucion DATE,
total FLOAT,
Id_Cliente NCHAR(5),
CONSTRAINT dev_ventaPK PRIMARY KEY(Id_Dev_Venta),
CONSTRAINT clienteFK2 FOREIGN KEY(Id_Cliente) REFERENCES CLIENTE(Id_Cliente));

CREATE TABLE PRODUCTOXDEV_VENTA(
Id_Dev_Venta NCHAR(5) NOT NULL,
Id_Producto NCHAR(5) NOT NULL,
cantidad NCHAR(5),
precio_unitario FLOAT,
razon VARCHAR(150),
CONSTRAINT productoxdev_ventaPK PRIMARY KEY(Id_Dev_Venta,Id_Producto),
CONSTRAINT dev_ventaFK FOREIGN KEY(Id_Dev_Venta) REFERENCES DEVOLUCION_VENTA(Id_Dev_Venta),
CONSTRAINT productoFK4 FOREIGN KEY(Id_Producto) REFERENCES PRODUCTO(Id_Producto));