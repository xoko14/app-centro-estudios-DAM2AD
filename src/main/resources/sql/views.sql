create view profesoresObject as select p.id, dni, p.nombre 'nombre', apellidos, d.nombre 'departamento'
from profesores p inner join departamentos d on p.departamento = d.id;