package Modelo;

import Modelo.Anomalia;
import Modelo.TipoDiagnostico;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:29")
@StaticMetamodel(Diagnostico.class)
public class Diagnostico_ extends Servicio_ {

    public static volatile SingularAttribute<Diagnostico, TipoDiagnostico> unTipoDiagnostico;
    public static volatile ListAttribute<Diagnostico, Anomalia> misAnomalias;

}