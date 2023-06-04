package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pojo.PersonasEntity;
import pojo.TiposAcomodacionEntity;

import java.sql.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        addPerson(sessionFactory);
//        addTipoAcomodacion(sessionFactory);
        // Cerrar la SessionFactory
        sessionFactory.close();
    }

    private static void addTipoAcomodacion(SessionFactory sessionFactory) {
        TiposAcomodacionEntity tipoAcomodacion = new TiposAcomodacionEntity();
        tipoAcomodacion.setNombreTipoAcomodacion("Mini Suite");
        tipoAcomodacion.setPrecioAcomodacion(100000);

        saveEntity(sessionFactory, tipoAcomodacion);
    }

    private static void saveEntity(SessionFactory sessionFactory, Object entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            switch (entity.getClass().getSimpleName()) {
                case "PersonasEntity":
                    session.save((PersonasEntity) entity);
                    break;
                case "TiposAcomodacionEntity":
                    session.save((TiposAcomodacionEntity) entity);
                    break;
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addPerson(SessionFactory sessionFactory) {
        PersonasEntity persona = new PersonasEntity();
        persona.setNumeroDocumento(1002681714);
        persona.setIdTipoDocumento(1);
        persona.setIdLugarExpedicionDocumento(1);
        persona.setIdLugarNacimiento(1);
        persona.setNombrePersona("Santiago Perez");
        persona.setNumeroTelefono("3215004072");
        persona.setFechaExpedicionDocumento(Date.valueOf("2020-01-01"));
        persona.setFechaNacimiento(Date.valueOf("1990-01-01"));
        // Guardar la instancia de Person en la base de datos
        saveEntity(sessionFactory, persona);
    }
}
