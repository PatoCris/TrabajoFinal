package Modelo;

import Modelo.Especialidad;
import Modelo.PiezaRecambio;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:29")
@StaticMetamodel(Proceso.class)
public class Proceso_ { 

    public static volatile SingularAttribute<Proceso, String> descripcion;
    public static volatile SingularAttribute<Proceso, Integer> codigo;
    public static volatile ListAttribute<Proceso, PiezaRecambio> misPiezasRecambios;
    public static volatile SingularAttribute<Proceso, Integer> cantidadModulos;
    public static volatile SingularAttribute<Proceso, String> nombre;
    public static volatile SingularAttribute<Proceso, Especialidad> unaEspecialidad;
    public static volatile SingularAttribute<Proceso, Boolean> activo;

}