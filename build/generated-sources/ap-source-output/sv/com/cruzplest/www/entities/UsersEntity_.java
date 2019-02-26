package sv.com.cruzplest.www.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.com.cruzplest.www.entities.GeneroEntity;
import sv.com.cruzplest.www.entities.IntentosEntity;
import sv.com.cruzplest.www.entities.NotificationsEntity;
import sv.com.cruzplest.www.entities.PoTableEntity;
import sv.com.cruzplest.www.entities.PrivilegesuserEntity;
import sv.com.cruzplest.www.entities.UsertypeEntity;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-24T19:11:33")
@StaticMetamodel(UsersEntity.class)
public class UsersEntity_ { 

    public static volatile SingularAttribute<UsersEntity, String> apellidos;
    public static volatile ListAttribute<UsersEntity, NotificationsEntity> notificationsEntityList;
    public static volatile SingularAttribute<UsersEntity, String> pass;
    public static volatile SingularAttribute<UsersEntity, UsertypeEntity> tipou;
    public static volatile ListAttribute<UsersEntity, IntentosEntity> intentosEntityList;
    public static volatile ListAttribute<UsersEntity, PoTableEntity> poTableEntityList;
    public static volatile SingularAttribute<UsersEntity, String> correo;
    public static volatile SingularAttribute<UsersEntity, GeneroEntity> genero;
    public static volatile SingularAttribute<UsersEntity, String> codigouser;
    public static volatile ListAttribute<UsersEntity, PrivilegesuserEntity> privilegesuserEntityList;
    public static volatile SingularAttribute<UsersEntity, Integer> telefono;
    public static volatile SingularAttribute<UsersEntity, String> nombre;

}