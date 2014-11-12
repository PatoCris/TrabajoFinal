package Modelo;

import Modelo.Especialidad;
import Modelo.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:29")
@StaticMetamodel(Mecanico.class)
public class Mecanico_ extends Empleado_ {

    public static volatile ListAttribute<Mecanico, Especialidad> misEspecialidades;
    public static volatile ListAttribute<Mecanico, Pedido> misPedidos;

}