package com.control;


import java.util.ArrayList;
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
			Team t2 = new Team("RCB");
			Team t3 = new Team("Delhi");
			
			Player p = new Player();
			p.setAge(28);
			p.setPlayerName("Virat Kolhi");
			p.getTeamList().add(t1);
			p.getTeamList().add(t2);
			p.getTeamList().add(t3);
			session.save(t1);
			session.save(t2);
			session.save(t3);
			session.save(p);
	
			
			transaction.commit();
			session.close();
		} catch (HibernateException ex) {
			// TODO Auto-generated catch block
			System.out.println(ex.getMessage());
		}
		
	}

}
