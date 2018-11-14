import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.*;
import java.math.BigDecimal;

public class Web3JInterface {
    protected Web3j mywallet;
    protected Credentials credentials;
    public static String KEYSTORE = "C:\\Users\\Edwin\\Documents\\Geth\\chaindata\\keystore\\UTC--2018-11-09T11-35-39.403547700Z--8157fc3fc71bbdb79c090d5274c28d156e2ec19d";
    public static String PASSWORD = "password";
    public static String TO_ADDRESS =  "0x8157fc3fc71bbdb79c090d5274c28d156e2ec19d";
    public static void main(String[] args) {
        Web3JInterface web3i = new Web3JInterface();
        web3i.init();
        try {


            TransactionReceipt transactionReceipt = Transfer.sendFunds(
                    web3i.mywallet,
                    web3i.credentials,
                    TO_ADDRESS,
                    BigDecimal.valueOf(10),
                    Convert.Unit.ETHER).sendAsync().get();
            System.out.println("Transaction complete : "
                + transactionReceipt.getTransactionHash()
            );
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void init() {




        mywallet = Web3j.build(new HttpService());
        System.out.println(mywallet.ethAccounts());
        try {
            logKeyfile(KEYSTORE);
             credentials = WalletUtils.loadCredentials(
                    PASSWORD,
                   KEYSTORE);
            System.out.println("Wallet loaded");
            }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void logKeyfile(String KEYFILE) throws IOException {
        File f = new File(KEYFILE);
        System.out.println(f.toString());
        String st ;
        BufferedReader BR = new BufferedReader(new FileReader(f));
        while ((st = BR.readLine()) != null){
            System.out.println(st);
        }
    }

}
