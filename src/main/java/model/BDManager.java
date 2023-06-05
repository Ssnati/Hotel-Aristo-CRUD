package model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pojo.*;

import java.util.ArrayList;
import java.util.List;

public class BDManager {
    private Configuration configuration;
    private List<ReservasEntity> reservas;
    private List<PersonasEntity> personas;
    private List<TiposAcomodacionEntity> tiposAcomodacion;
    private List<EmpresasEntity> empresas;
    public BDManager() {
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        reservas = new ArrayList<>();
        personas = new ArrayList<>();
        tiposAcomodacion = new ArrayList<>();
        empresas = new ArrayList<>();
    }

    public void loadData(){
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        reservas = sessionFactory.openSession().createQuery("from ReservasEntity ").list();
        personas = sessionFactory.openSession().createQuery("from PersonasEntity ").list();
        tiposAcomodacion = sessionFactory.openSession().createQuery("from TiposAcomodacionEntity ").list();
        empresas = sessionFactory.openSession().createQuery("from EmpresasEntity ").list();
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
}
