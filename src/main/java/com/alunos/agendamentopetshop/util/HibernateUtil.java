/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alunos.agendamentopetshop.util;

import org.hibernate.HibernateException;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Izaquiel
 */
public class HibernateUtil {

   private static SessionFactory sessionFactory = fabricaDeSessao();
    
    private static SessionFactory fabricaDeSessao() {
        if(sessionFactory == null) {
            try {
                // Create the SessionFactory from standard (hibernate.cfg.xml) 
                // config file.
                Configuration configuracao = new Configuration().configure();
                    StandardServiceRegistryBuilder registradorServico = new StandardServiceRegistryBuilder()
                        .applySettings(configuracao.getProperties());
                    StandardServiceRegistry servico = registradorServico.build();
                    return configuracao.buildSessionFactory(servico);
            } catch(HibernateException e) {
                System.err.println("Erro na construcao do objeto SessionFactory. Erro: " + e);
                throw new ExceptionInInitializerError(e);
            }
        } else {
            return sessionFactory;
        }
        
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
