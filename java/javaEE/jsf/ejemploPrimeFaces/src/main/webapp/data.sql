DROP TABLE IF EXISTS persona;

CREATE TABLE persona (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nombre VARCHAR(250) NOT NULL,
  apellido VARCHAR(250) NOT NULL,
  edad INT
);

INSERT INTO persona (nombre, apellido, edad) VALUES
  ('Sam', 'Rodriguez', 27),
  ('Ale', 'Juarez', 30),
  ('Naomi', 'Rodriguez', 22);