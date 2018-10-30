import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.io.File;

public class Web3JInterface {
    Web3j mywallet;
    Credentials credentials;

    public void init() {
        mywallet = Web3j.build(new HttpService("http://localhost:7545"));
        System.out.println(mywallet.ethAccounts());
        try {

            String fileName = WalletUtils.generateNewWalletFile(
                    "your password",
                    new File("C:\\Users\\Edwin\\OneDrive\\2018\\Second Term\\Projects\\Oracle\\Wallet"));

            //credentials = WalletUtils.loadCredentials("your password","C:\\Users\\Edwin\\OneDrive\\2018\\Second Term\\Projects\\Oracle\\Wallet");

                  }catch (Exception e) {
            e.printStackTrace();
        }

    }


}
