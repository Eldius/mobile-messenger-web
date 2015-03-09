package net.eldiosantos.messenger.listener;

import net.eldiosantos.messenger.constants.script.ScriptConstants;
import net.eldiosantos.messenger.hashtools.SHAHashProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by Eldius on 06/03/2015.
 */
@WebListener
public class UserdatabaseValidationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        new Thread(new ValidatorExecutor()).start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    private static class ValidatorExecutor implements Runnable {
        private final Logger logger = LoggerFactory.getLogger(getClass());

        private Connection connection;


        @Override
        public void run() {

            boolean isExecutionOk = false;

            while(!isExecutionOk) {
                try {
                    if (countUsers() == 0) {
                        createMainUser();
                    }
                    isExecutionOk = true;
                } catch (Exception e) {
                    logger.warn("Error trying to validate main user... Waiting to try again...", e);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e1) {
                        logger.warn("Error while waiting to try again", e1);
                    }
                }
            }
            logger.info("User count validation finished...");
        }

        private int countUsers() throws SQLException, NamingException {
            final ResultSet resultSet = getConnextion().createStatement().executeQuery(ScriptConstants.COUNT_USERS.getScript());
            resultSet.next();
            final int qtd = resultSet.getInt("qtd");
            resultSet.close();
            return qtd;
        }

        private void createMainUser() throws NamingException, SQLException {
            final PreparedStatement st = getConnextion().prepareStatement(ScriptConstants.INSERT_USER.getScript());

            /*
                EMAIL
                , LOGIN
                , MOBILEDEVICEKEY
                , PASSWORD
                , REGISTRATIONID
             */

            st.setString(1, "admin@mailinator.com");
            st.setString(2, "admin");
            st.setNull(3, Types.LONGVARCHAR);
            st.setString(4, new SHAHashProvider().hash("123"));
            st.setNull(5, Types.LONGVARCHAR);
            st.setInt(6, 0);

            st.execute();
            getConnextion().commit();
        }

        private Connection getConnextion() throws NamingException, SQLException {
            if((this.connection == null) || (connection.isClosed())) {
                final InitialContext context = new InitialContext();
                final DataSource datasource = (DataSource) context.lookup("jdbc/datasource");
                this.connection = datasource.getConnection();
            }
            return this.connection;
        }
    }
}
