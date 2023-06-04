package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pojo.PersonasEntity;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        PersonasEntity persona = new PersonasEntity();
        persona.setIdPersona(2);
        persona.setNumeroDocumento(12345678);
        persona.setIdTipoDocumento(1);
        persona.setIdLugar(1);
        persona.setNombrePersona("Juan Perez");
        persona.setNumeroTelefono("12345678");
        persona.setFechaNacimiento("1990-01-01");
        persona.setIdContactoEmergencia(1);
        persona.setNumeroEmergencia(4623);
        // Guardar la instancia de Person en la base de datos
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(persona);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cerrar la SessionFactory
        sessionFactory.close();
    }
}
