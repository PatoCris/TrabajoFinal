package Modelo;

import Modelo.Modelo;
import Modelo.TipoPiezaRecambio;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:29")
@StaticMetamodel(PiezaRecambio.class)
public class PiezaRecambio_ { 

    public static volatile SingularAttribute<PiezaRecambio, Integer> codigo;
    public static volatile SingularAttribute<PiezaRecambio, Double> precio;
    public static volatile SingularAttribute<PiezaRecambio, Double> impuesto;
    public static volatile SingularAttribute<PiezaRecambio, String> caracteristica;
    public static volatile SingularAttribute<PiezaRecambio, TipoPiezaRecambio> unTipoPiezaRecambio;
    public static volatile ListAttribute<PiezaRecambio, Modelo> vehiculosCompatibles;
    public static volatile SingularAttribute<PiezaRecambio, String> nombre;
    public static volatile SingularAttribute<PiezaRecambio, Boolean> garantia;
    public static volatile SingularAttribute<PiezaRecambio, Boolean> activo;

}