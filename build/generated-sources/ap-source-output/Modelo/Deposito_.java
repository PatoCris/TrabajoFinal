package Modelo;

import Modelo.Devolucion;
import Modelo.InformePiezaPedido;
import Modelo.JefeDeposito;
import Modelo.PiezaRecambio;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:29")
@StaticMetamodel(Deposito.class)
public class Deposito_ { 

    public static volatile SingularAttribute<Deposito, Integer> codigo;
    public static volatile SingularAttribute<Deposito, JefeDeposito> unJefeDeposito;
    public static volatile ListAttribute<Deposito, InformePiezaPedido> misInformesPPedido;
    public static volatile SingularAttribute<Deposito, String> correo;
    public static volatile ListAttribute<Deposito, Devolucion> misDevoluciones;
    public static volatile ListAttribute<Deposito, PiezaRecambio> misPiezasRecambio;
    public static volatile SingularAttribute<Deposito, String> telefono;
    public static volatile SingularAttribute<Deposito, String> nombre;
    public static volatile SingularAttribute<Deposito, Boolean> activo;

}