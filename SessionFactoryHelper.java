package com.codegnan.helper;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryHelper {
private SessionFactoryHelper() {
}
public static SessionFactory sessionFactory=null;
public static SessionFactory getSessionFactory() {
	if(sessionFactory==null) {
		StandardServiceRegistryBuilder registryBuilder=
				new StandardServiceRegistryBuilder();
		StandardServiceRegistry registry=
				registryBuilder.configure("hibernate.cfg.xml").build();
		MetadataSources sources=new MetadataSources(registry);
		Metadata metadata=sources.getMetadataBuilder().build();
		SessionFactoryBuilder sessionFactoryBuilder=
				metadata.getSessionFactoryBuilder();
		sessionFactory=sessionFactoryBuilder.build();
		
	}
	return sessionFactory;
}
}
