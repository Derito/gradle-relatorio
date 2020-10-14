package gradle.relatorio.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
		
	private static SessionFactory fabricaDeSessoes = criaFabricaDeSessoes();

	private static SessionFactory criaFabricaDeSessoes() {

		final StandardServiceRegistry registo = new StandardServiceRegistryBuilder().configure().build();
		try {
			fabricaDeSessoes = new MetadataSources(registo).buildMetadata().buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("Erro ao criar a sessao. " + e);
			StandardServiceRegistryBuilder.destroy(registo);
			throw new ExceptionInInitializerError(e);
		}
		return fabricaDeSessoes;
	}
	public static SessionFactory getFabricaDeSessoes() {
		return fabricaDeSessoes;
	}
}
