package Modelo;

import Modelo.TipoAnomalia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:29")
@StaticMetamodel(Anomalia.class)
public class Anomalia_ { 

    public static volatile SingularAttribute<Anomalia, String> descripcion;
    public static volatile SingularAttribute<Anomalia, Integer> codigo;
    public static volatile SingularAttribute<Anomalia, String> nivelSeveridad;
    public static volatile SingularAttribute<Anomalia, TipoAnomalia> unTipoAnomalia;
    public static volatile SingularAttribute<Anomalia, Boolean> activo;

}