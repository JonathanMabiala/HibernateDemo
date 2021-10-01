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

public class HibernateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Configuration configuration = new Configuration().configure();
			configuration.addAnnotatedClass(com.to.Player.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties() );
			
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
//		Player p1 = new Player(10,"Virat","India",30);
//		Player p2 = new Player(13,"Kumar","India",20);
//		session.save(p1);
//		session.save(p2);		
//		Player p = session.get(Player.class,10);
//		System.out.println("The player details: " + p);
//		p.setPlayerName("Dhoni");
//		p.setAge(37);
//		session.delete(p);
//		Player p1 = new Player(10,"Youvraj","India",30);
//		Player p2 = new Player(1,"Azhar","India",40);
//		Player p3 = new Player(9,"Mike","Denver",20);
//		session.save(p1);
//		session.save(p2);
//		session.save(p3);
			
			Query query = session.createQuery("from Player where age between  :age1  and :age2 order by playerName desc");
			
			query.setString("age1", "20");
			query.setString("age2", "30");
			List<Player> playerList = query.list();
			
			System.out.println("Player Details");
			
			for(Player p:playerList) {
				System.out.println(p);
			}
			
			transaction.commit();
			session.close();
		} catch (HibernateException ex) {
			// TODO Auto-generated catch block
			System.out.println(ex.getMessage());
		}
		
	}

}
