package hardware;


import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;


import java.io.IOException;

public class EthereumInterface {


    Web3j web3;
    Web3ClientVersion web3ClientVersion;
    String clientVersion;


    public void init() throws IOException {

        web3 = Web3j.build(new HttpService()); // defaults to http://localhost:8545/
        web3ClientVersion = web3.web3ClientVersion().send();
        clientVersion = web3ClientVersion.getWeb3ClientVersion();


    }

}
