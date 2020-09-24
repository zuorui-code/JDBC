package account;

import com.mysql.jdbc.BalanceStrategy;
import sun.security.util.Password;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zuorui
 * @creat 2020-09-24-19:38
 */
public class accountDaoImpl {

    public int insert(Account account){
        return 0;
    }
    public int delete(String cardNo){
        return 0;
    }

    public int update(Account account) throws SQLException {

        Connection connection;
        PreparedStatement preparedStatement = null;
        connection = DBUtils.getConnection();
        String sql = "update account set password = ?, name = ?,balance = ? where cardNo = ?";
        preparedStatement =connection.prepareStatement(sql);
        preparedStatement.setString(1,account.getPassword());
        preparedStatement.setString(2,account.getName());
        preparedStatement.setDouble(3,account.getBalance());
        preparedStatement.setString(4,account.getCardNo());



        int result = preparedStatement.executeUpdate();



        return  result;

    }

    public Account select(String cardNo) throws SQLException {

        Connection connection ;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Account account = null;
        connection = DBUtils.getConnection();
        String sql = "select * from account where cardNo = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,cardNo);

        resultSet =preparedStatement.executeQuery();

        if(resultSet.next()){

            String cardNo1 = resultSet.getString("cardNo");
            String password = resultSet.getString("password");
            String name = resultSet.getString("name");
           double balance = resultSet.getDouble("balance");
            account = new Account(cardNo1,password,name, balance);
        }






        return account;



    }

}
