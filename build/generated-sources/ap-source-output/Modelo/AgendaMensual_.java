package Modelo;

import Modelo.Modulo;
import Modelo.Turno;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:29")
@StaticMetamodel(AgendaMensual.class)
public class AgendaMensual_ { 

    public static volatile ListAttribute<AgendaMensual, Turno> misTurnos;
    public static volatile SingularAttribute<AgendaMensual, Integer> codigo;
    public static volatile ListAttribute<AgendaMensual, Modulo> misModulos;
    public static volatile SingularAttribute<AgendaMensual, String> nombre;
    public static volatile SingularAttribute<AgendaMensual, Integer> anio;
    public static volatile SingularAttribute<AgendaMensual, Integer> nroMes;
    public static volatile SingularAttribute<AgendaMensual, Boolean> activo;

}