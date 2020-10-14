package gradle.relatorio.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContexto implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// Inserção para uma chamada forçada do arranque do hibernate
		HibernateUtil.getFabricaDeSessoes();		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// 
		HibernateUtil.getFabricaDeSessoes().close();
	}
	
	   
}
