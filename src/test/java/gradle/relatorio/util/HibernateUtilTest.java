package gradle.relatorio.util;

import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;



public class HibernateUtilTest {
	
	@Test
	@Ignore
	public void conectar() {
	
	Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
	//sessao.beginTransaction();
	sessao.close();
	HibernateUtil.getFabricaDeSessoes().close();
	}
}
