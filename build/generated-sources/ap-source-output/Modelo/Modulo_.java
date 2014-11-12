package Modelo;

import Modelo.Mecanico;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:29")
@StaticMetamodel(Modulo.class)
public class Modulo_ { 

    public static volatile SingularAttribute<Modulo, Date> horaFin;
    public static volatile SingularAttribute<Modulo, Integer> nroModulo;
    public static volatile SingularAttribute<Modulo, Date> fecha;
    public static volatile SingularAttribute<Modulo, Integer> nroSemana;
    public static volatile SingularAttribute<Modulo, Integer> codigo;
    public static volatile SingularAttribute<Modulo, Mecanico> unMecanico;
    public static volatile SingularAttribute<Modulo, Boolean> libre;
    public static volatile SingularAttribute<Modulo, Date> horaInicio;
    public static volatile SingularAttribute<Modulo, Boolean> activo;

}