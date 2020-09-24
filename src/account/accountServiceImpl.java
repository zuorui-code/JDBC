package account;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.sql.SQLException;

/**
 * @author zuorui
 * @creat 2020-09-24-20:02
 */
public class accountServiceImpl {

    public void transfer(String fromNo,String psw,String toNo,double money) throws SQLException {

        accountDaoImpl accountDao = new accountDaoImpl();



        Account account = accountDao.select(fromNo);
        if(account == null){

            throw  new RuntimeException("卡号不存在");
        }
        if(!account.getPassword().equals(psw)){
            throw  new RuntimeException("密码错误");
        }
        if(account.getBalance() < money){
            throw  new RuntimeException("余额不足");
        }
        Account account1 = accountDao.select(toNo);
        if(account1 == null){
            throw  new RuntimeException("对方卡号不存在");
        }

        account.setBalance(account.getBalance() - money);
        accountDao.update(account);
        account1.setBalance(account1.getBalance() + money);
        accountDao.update(account1);
        System.out.println("转账成功");

    }
}
