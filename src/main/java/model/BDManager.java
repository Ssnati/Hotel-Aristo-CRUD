package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pojo.*;

import java.util.ArrayList;
import java.util.List;

public class BDManager {
    private Configuration configuration;
    private SessionFactory sessionFactory;
    private List<ReservasEntity> reservas;
    private List<PersonasEntity> personas;
    private List<TiposAcomodacionEntity> tiposAcomodacion;
    private List<EmpresasEntity> empresas;
    public BDManager() {
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
        reservas = new ArrayList<>();
        personas = new ArrayList<>();
        tiposAcomodacion = new ArrayList<>();
        empresas = new ArrayList<>();
    }

    public void loadData() {
        SessionFactory sessionLocal = configuration.buildSessionFactory();
        reservas = sessionLocal.openSession().createQuery("from ReservasEntity ").list();
        personas = sessionLocal.openSession().createQuery("from PersonasEntity ").list();
        tiposAcomodacion = sessionLocal.openSession().createQuery("from TiposAcomodacionEntity ").list();
        empresas = sessionLocal.openSession().createQuery("from EmpresasEntity ").list();
        sessionLocal.close();
    }

    public EmpresasEntity getEmpresaById(int idEmpresa) {
        for (EmpresasEntity empresa : empresas) {
            if (empresa.getIdEmpresa() == idEmpresa) {
                return empresa;
            }
        }
        return null;
    }

    public TiposAcomodacionEntity getTipoAcomodacionById(int idTipoAcomodacion) {
        for (TiposAcomodacionEntity tipoAcomodacion : tiposAcomodacion) {
            if (tipoAcomodacion.getIdTipoAcomodacion() == idTipoAcomodacion) {
                return tipoAcomodacion;
            }
        }
        return null;
    }

    public PersonasEntity getPersonaById(int idPersona) {
        for (PersonasEntity persona : personas) {
            if (persona.getIdPersona() == idPersona) {
                return persona;
            }
        }
        return null;
    }

    public EmpresasEntity getEmpresaByName(String bookingCompanyName) {
        for (EmpresasEntity empresa : empresas) {
            if (empresa.getNombreEmpresa().equals(bookingCompanyName)) {
                return empresa;
            }
        }
        return null;
    }

    public PersonasEntity getPersonaByName(String guestName) {
        for (PersonasEntity persona : personas) {
            if (persona.getNombrePersona().equals(guestName)) {
                return persona;
            }
        }
        return null;
    }

    public TiposAcomodacionEntity getTipoAcomodacionByName(String acomodateTypeName) {
        for (TiposAcomodacionEntity tipoAcomodacion : tiposAcomodacion) {
            if (tipoAcomodacion.getNombreTipoAcomodacion().equals(acomodateTypeName)) {
                return tipoAcomodacion;
            }
        }
        return null;
    }

    public ReservasEntity getReservasById(int idReserva) {
        for (ReservasEntity reserva : reservas) {
            if (reserva.getIdReserva() == idReserva) {
                return reserva;
            }
        }
        return null;
    }

    public void update(ReservasEntity reserveToUpdate) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(reserveToUpdate);
            int index = reservas.indexOf(getReservasById(reserveToUpdate.getIdReserva()));
            reservas.set(index, reserveToUpdate);
            session.getTransaction().commit();
        }
    }

    public void save(ReservasEntity entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(entity);
            reservas.add(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int idReserva) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            ReservasEntity reserva = getReservasById(idReserva);
            session.remove(reserva);
            reservas.remove(reserva);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        sessionFactory.close();
    }

    public List<ReservasEntity> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservasEntity> reservas) {
        this.reservas = reservas;
    }

    public List<PersonasEntity> getPersonas() {
        return personas;
    }

    public void setPersonas(List<PersonasEntity> personas) {
        this.personas = personas;
    }

    public List<TiposAcomodacionEntity> getTiposAcomodacion() {
        return tiposAcomodacion;
    }

    public void setTiposAcomodacion(List<TiposAcomodacionEntity> tiposAcomodacion) {
        this.tiposAcomodacion = tiposAcomodacion;
    }

    public List<EmpresasEntity> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<EmpresasEntity> empresas) {
        this.empresas = empresas;
    }

    public List<ReservasEntity> getReservasByName(String name) {
        List<ReservasEntity> reservasByName = new ArrayList<>();
        for (ReservasEntity reserva : reservas) {
            if (getPersonaById(reserva.getIdPersonaHuesped()).getNombrePersona().toLowerCase().contains(name.toLowerCase())) {
                reservasByName.add(reserva);
            }
        }
        return reservasByName;
    }
}
