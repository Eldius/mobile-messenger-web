package net.eldiosantos.messenger.constants.script;

import java.util.Scanner;

/**
 * Created by Eldius on 06/03/2015.
 */
public enum ScriptConstants {
    COUNT_USERS("scripts/count_users.sql")
    , INSERT_USER("scripts/insert_user.sql");

    private final String script;

    ScriptConstants(final String file) {
        final Scanner sc = new Scanner(this.getClass().getClassLoader().getResourceAsStream(file), "utf-8");
        final StringBuffer sql = new StringBuffer();
        while(sc.hasNextLine()) {
            sql.append(sc.nextLine())
                    .append("\n");
        }
        script = sql.toString();
    }

    public String getScript() {
        return script;
    }
}
