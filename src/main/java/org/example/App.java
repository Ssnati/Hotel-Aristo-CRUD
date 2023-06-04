package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pojo.PersonasEntity;
import pojo.TiposAcomodacionEntity;
import presenter.Presenter;

import java.sql.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        presenter.start();
//        presenter.read();
//        presenter.update();
//        presenter.delete();
    }
}