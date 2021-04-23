CREATE DATABASE CONTROL_INVENTARIO;
USE CONTROL_INVENTARIO;

CREATE TABLE TELEFONO(
Id_Telefono INT AUTO_INCREMENT,
numero VARCHAR(8) UNIQUE NOT NULL,
CONSTRAINT telefonoPK PRIMARY KEY(Id_Telefono));

CREATE TABLE SEXO(
Id_Sexo INT AUTO_INCREMENT,
sexo VARCHAR(15) NOT NULL,
CONSTRAINT sexoPK PRIMARY KEY(Id_Sexo));

CREATE TABLE ROL_EMPLEADO(
Id_Rol INT AUTO_INCREMENT,
rol_empleado VARCHAR(30) UNIQUE NOT NULL,
CONSTRAINT rolPK PRIMARY KEY(Id_Rol));

CREATE TABLE EMPRESA(
Id_Empresa INT AUTO_INCREMENT,
nombre_empresa VARCHAR(50) NOT NULL,
direccion VARCHAR(70),
RTN VARCHAR(15) UNIQUE NOT NULL,
correo VARCHAR(50) UNIQUE,
CONSTRAINT empresaPK PRIMARY KEY(Id_Empresa));

CREATE TABLE TELXEMPRESA(
Id_Telefono INT NOT NULL,
Id_Empresa INT NOT NULL,
CONSTRAINT telefonoFK FOREIGN KEY(Id_Telefono) REFERENCES TELEFONO(Id_Telefono),
CONSTRAINT empresaFK FOREIGN KEY(Id_Empresa) REFERENCES EMPRESA(Id_Empresa));

CREATE TABLE EMPLEADO( 
Id_Empleado INT AUTO_INCREMENT, 
p_nombre VARCHAR(25) NOT NULL,
s_nombre VARCHAR(25),
p_apellido VARCHAR(25) NOT NULL,
s_apellido VARCHAR(25),
correo VARCHAR(50) UNIQUE,
edad CHAR(3),
fecha_ingreso DATE,
salario FLOAT,
DNI VARCHAR(15) UNIQUE NOT NULL,
Id_Empresa INT NOT NULL,
Id_Sexo INT NOT NULL,
Id_Rol INT NOT NULL,
CONSTRAINT empleadoPK PRIMARY KEY(Id_Empleado),
CONSTRAINT empresaFK1 FOREIGN KEY(Id_Empresa) REFERENCES EMPRESA(Id_Empresa),
CONSTRAINT sexoFK FOREIGN KEY(Id_Sexo) REFERENCES SEXO(Id_Sexo),
CONSTRAINT rolFK FOREIGN KEY(Id_Rol) REFERENCES ROL_EMPLEADO(Id_Rol));

CREATE TABLE TELXEMPLEADO(
Id_Telefono INT NOT NULL,
Id_Empleado INT NOT NULL,
CONSTRAINT telefonoFK1 FOREIGN KEY(Id_Telefono) REFERENCES TELEFONO(Id_Telefono),
CONSTRAINT empleadoFK FOREIGN KEY(Id_Empleado) REFERENCES EMPLEADO(Id_Empleado));

CREATE TABLE CLIENTE(
Id_Cliente INT AUTO_INCREMENT,
p_nombre VARCHAR(25) NOT NULL,
s_nombre VARCHAR(25),
p_apellido VARCHAR(25) NOT NULL,
s_apellido VARCHAR(25),
correo VARCHAR(50) UNIQUE,
DNI VARCHAR(15) UNIQUE NOT NULL,
direccion VARCHAR(70),
CONSTRAINT clientePK PRIMARY KEY(Id_Cliente));

CREATE TABLE TELXCLIENTE(
Id_Telefono INT NOT NULL,
Id_Cliente INT NOT NULL,
CONSTRAINT telefonoFK2 FOREIGN KEY(Id_Telefono) REFERENCES TELEFONO(Id_Telefono),
CONSTRAINT clienteFK FOREIGN KEY(Id_Cliente) REFERENCES CLIENTE(Id_Cliente));

CREATE TABLE TIPO_PRODUCTO(
Id_Tipo_Producto INT AUTO_INCREMENT,
nombre_tipo_producto VARCHAR(30) UNIQUE NOT NULL,
CONSTRAINT tipo_productoPK PRIMARY KEY(Id_Tipo_Producto));

CREATE TABLE SECCION_PRODUCTO(
Id_Seccion_Producto INT AUTO_INCREMENT,
nombre_seccion_producto VARCHAR(30) UNIQUE NOT NULL,
CONSTRAINT seccion_productoPK PRIMARY KEY(Id_Seccion_Producto));

CREATE TABLE MARCA(
Id_Marca INT AUTO_INCREMENT,
nombre_marca VARCHAR(30) UNIQUE NOT NULL,
CONSTRAINT marcaPK PRIMARY KEY(Id_Marca));

CREATE TABLE PRODUCTO(
Id_Producto INT AUTO_INCREMENT,
nombre_producto VARCHAR(50) NOT NULL,
fecha_caducidad DATE,
precio_venta FLOAT,
medida VARCHAR(15),
cantidad_disponible CHAR(5),
cantidad_media CHAR(5),
Id_Tipo_Producto INT,
Id_Seccion_Producto INT,
Id_Marca INT,
CONSTRAINT productoPK PRIMARY KEY(Id_Producto),
CONSTRAINT tipo_productoFK FOREIGN KEY(Id_Tipo_Producto) REFERENCES TIPO_PRODUCTO(Id_Tipo_Producto),
CONSTRAINT seccion_productoFK FOREIGN KEY(Id_Seccion_Producto) REFERENCES SECCION_PRODUCTO(Id_Seccion_Producto),
CONSTRAINT marcaFK FOREIGN KEY(Id_Marca) REFERENCES MARCA(Id_Marca));

CREATE TABLE PROVEEDOR(
Id_Proveedor INT AUTO_INCREMENT,
nombre VARCHAR(50) NOT NULL,
correo VARCHAR(50) UNIQUE, 
direccion VARCHAR(70),
RTN VARCHAR(15) UNIQUE NOT NULL,
CONSTRAINT proveedorPK PRIMARY KEY(Id_Proveedor));

CREATE TABLE TELXPROVEEDOR(
Id_Telefono INT NOT NULL,
Id_Proveedor INT NOT NULL,
CONSTRAINT telefonoFK3 FOREIGN KEY(Id_Telefono) REFERENCES TELEFONO(Id_Telefono),
CONSTRAINT proveedorFK FOREIGN KEY(Id_Proveedor) REFERENCES PROVEEDOR(Id_Proveedor));

CREATE TABLE DESCUENTO(
Id_Descuento INT AUTO_INCREMENT,
tipo_descuento VARCHAR(30) NOT NULL UNIQUE,
descuento FLOAT NOT NULL CHECK(descuento>0 and descuento<=1),
CONSTRAINT descuentoPK PRIMARY KEY(Id_Descuento));

CREATE TABLE TIPO_PAGO(
Id_Tipo_Pago INT AUTO_INCREMENT,
nombre_tipo_Pago VARCHAR(20) NOT NULL UNIQUE,
CONSTRAINT tipoPagoPK PRIMARY KEY(Id_Tipo_Pago));

CREATE TABLE PAGO(
Id_Pago INT AUTO_INCREMENT,
tipo_pago INT NOT NULL,
importe_total FLOAT,
importe_x_cuota FLOAT,
cantidad_cuotas CHAR(5),
fecha_limite DATE,
CONSTRAINT pagoPK PRIMARY KEY(Id_Pago),
CONSTRAINT TipoPagoFK FOREIGN KEY(tipo_pago) REFERENCES TIPO_PAGO(Id_Tipo_Pago));

CREATE TABLE CUOTA(
Id_Cuota INT AUTO_INCREMENT,
total_abonado FLOAT,
fecha_pago DATE,
Id_Pago INT NOT NULL,
CONSTRAINT cuotaPK PRIMARY KEY(Id_Cuota),
CONSTRAINT pagoFK FOREIGN KEY(Id_Pago) REFERENCES PAGO(Id_Pago));

CREATE TABLE FACTURA_VENTA(
Id_Venta INT AUTO_INCREMENT,
fecha DATE, 
subtotal FLOAT,
total FLOAT,
cancelo BOOL,
Id_Cliente INT NOT NULL,
Id_Descuento INT, 
Id_Empleado INT NOT NULL,
Id_Empresa INT NOT NULL,
Id_Pago INT NOT NULL,
CONSTRAINT ventaPK PRIMARY KEY(Id_Venta),
CONSTRAINT clienteFK1 FOREIGN KEY(Id_Cliente) REFERENCES CLIENTE(Id_Cliente),
CONSTRAINT descuentoFK FOREIGN KEY(Id_Descuento) REFERENCES DESCUENTO(Id_Descuento),
CONSTRAINT empleadoFK1 FOREIGN KEY(Id_Empleado) REFERENCES EMPLEADO(Id_Empleado),
CONSTRAINT empresaFK2 FOREIGN KEY(Id_Empresa) REFERENCES EMPRESA(Id_Empresa),
CONSTRAINT pagoFK1 FOREIGN KEY(Id_Pago) REFERENCES PAGO(Id_Pago));

CREATE TABLE FACTURA_COMPRA(
Id_Compra INT AUTO_INCREMENT,
fecha DATE,
subtotal FLOAT,
descuento FLOAT,
total FLOAT,
Id_Pago INT NOT NULL,
Id_Proveedor INT NOT NULL,
CONSTRAINT compraPK PRIMARY KEY(Id_Compra),
CONSTRAINT proveedorFK1 FOREIGN KEY(Id_Proveedor) REFERENCES PROVEEDOR(Id_Proveedor),
CONSTRAINT pagoFK2 FOREIGN KEY(Id_Pago) REFERENCES PAGO(Id_Pago));

CREATE TABLE PRODUCTO_COMPRA(
Id_Compra INT NOT NULL,
Id_Producto INT NOT NULL,
precio_unitario FLOAT,
cantidad CHAR(5),
CONSTRAINT producto_compraPK PRIMARY KEY(Id_Compra,Id_Producto),
CONSTRAINT compraFK FOREIGN KEY(Id_Compra) REFERENCES FACTURA_COMPRA(Id_Compra),
CONSTRAINT productoFK1 FOREIGN KEY(Id_Producto) REFERENCES PRODUCTO(Id_Producto));

CREATE TABLE PRODUCTO_VENTA(
Id_Venta INT NOT NULL,
Id_Producto INT NOT NULL,
precio_unitario FLOAT,
cantidad CHAR(5),
CONSTRAINT producto_ventaPK PRIMARY KEY(Id_Venta,Id_Producto),
CONSTRAINT ventaFK FOREIGN KEY(Id_Venta) REFERENCES FACTURA_VENTA(Id_Venta),
CONSTRAINT productoFK2 FOREIGN KEY(Id_Producto) REFERENCES PRODUCTO(Id_Producto));

CREATE TABLE DEVOLUCION_COMPRA(
Id_Dev_Compra INT AUTO_INCREMENT,
fecha_devolucion DATE,
total FLOAT,
Id_Proveedor INT NOT NULL,
CONSTRAINT dev_compraPK PRIMARY KEY(Id_Dev_Compra),
CONSTRAINT proveedorFK2 FOREIGN KEY(Id_Proveedor) REFERENCES PROVEEDOR(Id_Proveedor));

CREATE TABLE PRODUCTOXDEV_COMPRA(
Id_Dev_Compra INT NOT NULL,
Id_Producto INT NOT NULL,
cantidad CHAR(5),
precio_unitario FLOAT,
razon VARCHAR(150),
CONSTRAINT productoxdev_compraPK PRIMARY KEY(Id_Dev_Compra,Id_Producto),
CONSTRAINT dev_compraFK FOREIGN KEY(Id_Dev_Compra) REFERENCES DEVOLUCION_COMPRA(Id_Dev_Compra),
CONSTRAINT productoFK3 FOREIGN KEY(Id_Producto) REFERENCES PRODUCTO(Id_Producto));

CREATE TABLE DEVOLUCION_VENTA(
Id_Dev_Venta INT AUTO_INCREMENT,
fecha_devolucion DATE,
total FLOAT,
Id_Cliente INT NOT NULL,
CONSTRAINT dev_ventaPK PRIMARY KEY(Id_Dev_Venta),
CONSTRAINT clienteFK2 FOREIGN KEY(Id_Cliente) REFERENCES CLIENTE(Id_Cliente));

CREATE TABLE PRODUCTOXDEV_VENTA(
Id_Dev_Venta INT NOT NULL,
Id_Producto INT NOT NULL,
cantidad CHAR(5),
precio_unitario FLOAT,
razon VARCHAR(150),
CONSTRAINT productoxdev_ventaPK PRIMARY KEY(Id_Dev_Venta,Id_Producto),
CONSTRAINT dev_ventaFK FOREIGN KEY(Id_Dev_Venta) REFERENCES DEVOLUCION_VENTA(Id_Dev_Venta),
CONSTRAINT productoFK4 FOREIGN KEY(Id_Producto) REFERENCES PRODUCTO(Id_Producto));

CREATE TABLE PRODUCTOPROVEEDORES(
	Id_Producto INT NOT NULL,
    Id_Proveedor INT NOT NULL,
    precio_compra FLOAT,
	CONSTRAINT ProductoxProveedorPK PRIMARY KEY(Id_Producto,Id_Proveedor),
    CONSTRAINT proveedor_productoFK FOREIGN KEY(Id_Producto) REFERENCES producto(Id_Producto),
    CONSTRAINT producto_proveedorFK FOREIGN KEY(Id_Proveedor) REFERENCES Proveedor(Id_Proveedor)
);
