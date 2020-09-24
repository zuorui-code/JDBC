package account;

import java.sql.SQLException;

/**
 * @author zuorui
 * @creat 2020-09-24-20:30
 */
public class Test {

    public static void main(String[] args) throws SQLException {

        accountServiceImpl accountService = new accountServiceImpl();
        accountService.transfer("1008","990216","1002",1000);
    }

}

