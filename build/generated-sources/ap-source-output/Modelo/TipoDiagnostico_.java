package Modelo;

import Modelo.Proceso;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:29")
@StaticMetamodel(TipoDiagnostico.class)
public class TipoDiagnostico_ { 

    public static volatile SingularAttribute<TipoDiagnostico, String> descripcion;
    public static volatile ListAttribute<TipoDiagnostico, Proceso> misProcesos;
    public static volatile SingularAttribute<TipoDiagnostico, Integer> codigo;
    public static volatile SingularAttribute<TipoDiagnostico, Integer> catidadModulos;
    public static volatile SingularAttribute<TipoDiagnostico, String> nombre;
    public static volatile SingularAttribute<TipoDiagnostico, Boolean> activo;

}