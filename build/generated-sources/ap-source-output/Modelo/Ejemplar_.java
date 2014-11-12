package Modelo;

import Modelo.PiezaRecambio;
import Modelo.Proveedor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:29")
@StaticMetamodel(Ejemplar.class)
public class Ejemplar_ { 

    public static volatile SingularAttribute<Ejemplar, Date> fechaIngreso;
    public static volatile SingularAttribute<Ejemplar, Integer> codigo;
    public static volatile SingularAttribute<Ejemplar, PiezaRecambio> unaPiezaRecambio;
    public static volatile SingularAttribute<Ejemplar, Proveedor> unProveedor;
    public static volatile SingularAttribute<Ejemplar, Boolean> activo;

}