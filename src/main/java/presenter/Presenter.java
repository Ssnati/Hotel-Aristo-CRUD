package presenter;

import model.BDManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pojo.PersonasEntity;
import pojo.ReservasEntity;
import pojo.ReserveFullData;
import pojo.TiposAcomodacionEntity;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Presenter implements ActionListener {
    private BDManager model;
    private View view;

    public Presenter() {
        model = new BDManager();
        view = new View(this);
        model.loadData();
    }

    public void start() {
        view.loadData(adaptToView(model.getReservas()), model.getPersonas(), model.getTiposAcomodacion(),model.getEmpresas());
        view.setVisible(true);
    }

    private List<ReserveFullData> adaptToView(List<ReservasEntity> modelReserves) {
        List<ReserveFullData> reserveFullData = new ArrayList<>();
        for (ReservasEntity modelReserve : modelReserves) {
            ReserveFullData reserve = new ReserveFullData();
            reserve.setIdReserve(modelReserve.getIdReserva());
            reserve.setReserveDate(modelReserve.getFechaReserva());
            reserve.setReserveValue(modelReserve.getValorReserva());
            reserve.setBookingCompanyName(model.getEmpresaById(modelReserve.getIdEmpresa()).getNombreEmpresa());
            reserve.setGuestName(model.getPersonaById(modelReserve.getIdPersonaHuesped()).getNombrePersona());
            reserve.setAcomodateTypeName(model.getTipoAcomodacionById(modelReserve.getIdTipoAcomodacion()).getNombreTipoAcomodacion());
            reserve.setReceptionistName(model.getPersonaById(modelReserve.getIdPersonaRecepcionista()).getNombrePersona());
            reserve.setReserveObservations(modelReserve.getObservacionesHuespedHotel());
            reserveFullData.add(reserve);
        }
        return reserveFullData;
    }

    public List<ReservasEntity> adaptToModel(List<ReserveFullData> viewReserves){
        List<ReservasEntity> reserveFullData = new ArrayList<>();
        for (ReserveFullData viewReserve : viewReserves) {
            ReservasEntity reserve = new ReservasEntity();
            reserve.setIdReserva(viewReserve.getIdReserve());
            reserve.setFechaReserva(viewReserve.getReserveDate());
            reserve.setValorReserva(viewReserve.getReserveValue());
            reserve.setIdEmpresa(model.getEmpresaByName(viewReserve.getBookingCompanyName()).getIdEmpresa());
            reserve.setIdPersonaHuesped(model.getPersonaByName(viewReserve.getGuestName()).getIdPersona());
            reserve.setIdTipoAcomodacion(model.getTipoAcomodacionByName(viewReserve.getAcomodateTypeName()).getIdTipoAcomodacion());
            reserve.setIdPersonaRecepcionista(model.getPersonaByName(viewReserve.getReceptionistName()).getIdPersona());
            reserve.setObservacionesHuespedHotel(viewReserve.getReserveObservations());
            reserveFullData.add(reserve);
        }
        return reserveFullData;
    }

    public void loadConfig() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        addPerson(sessionFactory);
        addTipoAcomodacion(sessionFactory);
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
            session.save(entity);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

    public void read() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            PersonasEntity persona = session.get(PersonasEntity.class, 1);
            List<PersonasEntity> personas = new ArrayList<>();
            personas.add(searchPersonByDocumentNumber(session, 1));
            for (PersonasEntity p : personas) {
                System.out.println(p);
            }
        }
    }

    private PersonasEntity searchPersonByDocumentNumber(Session session, int i) {
        PersonasEntity persona = session.get(PersonasEntity.class, i);
        return persona;
    }

    public void update() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            PersonasEntity persona = session.get(PersonasEntity.class, 1);
            persona.setNombrePersona("Santiago Orjuela");
            session.merge(persona);
            session.getTransaction().commit();
            System.out.println(persona);
        }
    }

    public void delete() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            PersonasEntity persona = session.get(PersonasEntity.class, 1);
            session.remove(persona);
            session.getTransaction().commit();
        }
    }
}
