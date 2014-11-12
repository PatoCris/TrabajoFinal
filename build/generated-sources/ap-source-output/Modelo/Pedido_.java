package Modelo;

import Modelo.Cliente;
import Modelo.JefeDeposito;
import Modelo.JefeTaller;
import Modelo.Perito;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:29")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, String> descripcion;
    public static volatile SingularAttribute<Pedido, JefeTaller> unJefeTaller;
    public static volatile SingularAttribute<Pedido, Date> fecha;
    public static volatile SingularAttribute<Pedido, Integer> codigo;
    public static volatile SingularAttribute<Pedido, JefeDeposito> unJefeDeposito;
    public static volatile SingularAttribute<Pedido, Date> hora;
    public static volatile SingularAttribute<Pedido, Boolean> autorizado;
    public static volatile SingularAttribute<Pedido, Integer> cantidad;
    public static volatile SingularAttribute<Pedido, Boolean> paraRecambio;
    public static volatile SingularAttribute<Pedido, Cliente> unCliente;
    public static volatile SingularAttribute<Pedido, Boolean> activo;
    public static volatile SingularAttribute<Pedido, Perito> unPerito;

}