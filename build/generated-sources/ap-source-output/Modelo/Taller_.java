package Modelo;

import Modelo.AgendaMensual;
import Modelo.Deposito;
import Modelo.JefeTaller;
import Modelo.Localidad;
import Modelo.Mecanico;
import Modelo.Perito;
import Modelo.Sector;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:30")
@StaticMetamodel(Taller.class)
public class Taller_ { 

    public static volatile SingularAttribute<Taller, Integer> codigo;
    public static volatile SingularAttribute<Taller, Deposito> unDeposito;
    public static volatile SingularAttribute<Taller, Date> horaEntrada;
    public static volatile SingularAttribute<Taller, String> direccion;
    public static volatile ListAttribute<Taller, AgendaMensual> misAgendasMensuales;
    public static volatile SingularAttribute<Taller, String> nombre;
    public static volatile SingularAttribute<Taller, Date> horaSalida;
    public static volatile SingularAttribute<Taller, Localidad> unaLocalidad;
    public static volatile SingularAttribute<Taller, JefeTaller> unJefeTaller;
    public static volatile ListAttribute<Taller, Sector> misSectores;
    public static volatile SingularAttribute<Taller, Mecanico> unMecanico;
    public static volatile ListAttribute<Taller, Perito> misPeritos;
    public static volatile ListAttribute<Taller, Localidad> zonasCubiertas;
    public static volatile SingularAttribute<Taller, String> correo;
    public static volatile SingularAttribute<Taller, String> telefono;
    public static volatile SingularAttribute<Taller, Boolean> activo;

}