package Modelo;

import Modelo.Marca;
import Modelo.Segmento;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:29")
@StaticMetamodel(Modelo.class)
public class Modelo_ { 

    public static volatile SingularAttribute<Modelo, String> descripcion;
    public static volatile SingularAttribute<Modelo, Integer> codigo;
    public static volatile SingularAttribute<Modelo, Marca> unaMarca;
    public static volatile SingularAttribute<Modelo, Segmento> unSegmento;
    public static volatile SingularAttribute<Modelo, String> nombre;
    public static volatile SingularAttribute<Modelo, Boolean> activo;

}