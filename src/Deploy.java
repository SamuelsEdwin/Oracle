import javafx.util.Pair;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import wrapper.Record;
import org.web3j.abi.datatypes.Address;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.text.ParseException;

public class Deploy {
    private Web3j web3;
    private Credentials credentials;
    private String contractAddress;

    String Password = "placeholder";
    String WalletDir = "Wallet/";


    public Deploy() {
        web3 = Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));
       // web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/
        //generatewallet();

    }

    public Deploy(String pServiceProvider ,String pPassword, String pWalletDirectory) {
        web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/
        //credentials = WalletUtils.loadCredentials(pPassword,pWalletDirectory );

    }

    public void deployContract() throws java.lang.Exception {

        Record contract = Record.deploy(web3,credentials,ManagedTransaction.GAS_PRICE,Contract.GAS_LIMIT).send();
        contractAddress = contract.getContractAddress();
    }

    public void generateWallet() throws
            IOException,
            CipherException,
            InvalidAlgorithmParameterException,
            NoSuchAlgorithmException,
            NoSuchProviderException
    {

            WalletUtils.generateNewWalletFile(Password, new File(WalletDir), true);
            credentials = WalletUtils.loadCredentials(Password, WalletDir);

    }
}
