package net.eldiosantos.messenger.util;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.junit.Before;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by eldio.junior on 16/03/2015.
 */
public class DatabaseTest {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    private EntityManagerFactory getEntityManagerFactory() {
        if(!(entityManagerFactory!=null) || !entityManagerFactory.isOpen()) {
            entityManagerFactory = Persistence.createEntityManagerFactory("default");
        }
        return entityManagerFactory;
    }

    protected EntityManager getEntityManager() {
        if(!(entityManager!=null) || !entityManager.isOpen()) {
            entityManager = getEntityManagerFactory().createEntityManager();
        }
        return entityManager;
    }

    @Before
    public void setUp() throws Exception {
        setUpDatabase();
    }

    protected void setUpDatabase() {

        ((Session)getEntityManager().getDelegate()).doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                final Statement st = connection.createStatement();
                st.addBatch(DatabaseTest.this.getScript());
                final int[] results = st.executeBatch();
                for (int qtd : results) {
                    System.out.println("rows updated: " + qtd);
                }
                connection.commit();
            }
        });
    }

    protected String getScript() {
        //final StringBuffer script = new StringBuffer("BEGIN\n");
        final StringBuffer script = new StringBuffer();
        Scanner sc = new Scanner(getClass().getClassLoader().getResourceAsStream("pre_test_script.sql"));
        while(sc.hasNextLine()) {
            script.append(sc.nextLine())
                    .append("\n");
        }
        //script.append("END;");
        return script.toString();
    }

}
