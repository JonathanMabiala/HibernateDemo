package com.control;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.to.Player;
import com.to.Team;

public class HibernateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Configuration configuration = new Configuration().configure();
			configuration.addAnnotatedClass(com.to.Player.class); // Inform java of the annotated classes
			configuration.addAnnotatedClass(com.to.Team.class); // Inform java of the annotated classes
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties() );
			
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Team t1 = new Team("India");
			
			Player p1 = new Player("Virat Kolhi", t1,28);
			Player p2 = new Player("Fox Ben", t1,30);
			Player p3 = new Player("Watson Noah", t1,21);
			Player p4 = new Player("Baxter Baker", t1,22);
			
			session.save(t1);
			session.save(p1);
			session.save(p2);
			session.save(p3);
			session.save(p4);
			
			transaction.commit();
			session.close();
		} catch (HibernateException ex) {
			// TODO Auto-generated catch block
			System.out.println(ex.getMessage());
		}
		
	}

}
