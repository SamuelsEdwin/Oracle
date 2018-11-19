import hardware.ExtendedRecord;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import wrapper.Record;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class Web3JInterface {
    protected Web3j mywallet;
    protected Credentials credentials;
    public static String KEYSTORE = "/home/orto/Documents/Chain/chaindata/keystore/UTC--2018-11-15T03-24-48.475437816Z--3c8d55888a2172993b4839d94002d26147294bba";
    public static String PASSWORD = "password";
    public static String TO_ADDRESS =  "0x680be24f5d6e9d9ebd4f1b9a5948dbb223ec81d9";
    public static BigInteger GAS_PRICE = new BigInteger("2");
    public static BigInteger GAS_LIMIT = new BigInteger("4793558");
    public static String CONTRACT_ADDRESSES = "0xd21eb67f5966588557b0261a1ce8eb5d2b89c742";
    public static String CONTRACT_ADDRESSi = "0x18f31e60ef9539848fdbe12190f6b325cdc2532d";
    public static String CONTRACT_ADDRESS = "0x7041104326d0e85295d992456b8e9b0b2facdae0";
    public static String HTTP_SERVER = "http://127.0.0.1:8545";
    public static String LOG_FILE = "Unversioned/eventID.log";
    //public static String SENSOR_LOG_FILE = "Unversioned/eventID.log"

    protected Record contract;
    public static void main(String[] args) {
        Web3JInterface web3i = new Web3JInterface();
        //web3i.init();
        try {

        runUI(web3i.contract,web3i);


        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void runUI(Record contract,Web3JInterface web3i) {
        Scanner scanner = new Scanner(System.in);
        String exitCode = "exit";
        String acceptCode = "y";
        String negateCode = "n";
        String input ="";
        while(!input.equalsIgnoreCase(exitCode)) {
            System.out.println("Deploy a contract Y or N type exit to quit");
            input = scanner.nextLine();
            if(input.equalsIgnoreCase(acceptCode)){
                web3i.deploy();
                System.exit(0);

            }else if(input.equalsIgnoreCase(negateCode)){


                HwOracle oracle = new HwOracle("Unversioned/input_1.txt");
                oracle.init();
                ExtendedRecord extendedRecord =oracle.getExtendedRecord("edwin","file");


                web3i.writeRecord(extendedRecord);
                web3i.logTransactions();

            }
        }
        System.exit(0);

    }

    public Web3JInterface() {


        try {
            mywallet = Web3j.build(new HttpService(HTTP_SERVER));
            credentials = WalletUtils.loadCredentials(
                    PASSWORD,
                    KEYSTORE);
            System.out.println("Wallet loaded");
            contract = Record.load(CONTRACT_ADDRESS,mywallet,credentials,GAS_PRICE,GAS_LIMIT);
            if(!contract.isValid()){
                System.out.println("Invalid contract");
                System.exit(0);
            }
            String ownerAddress = contract.getOwner().send();
            System.out.println("Owner Address \t: "+ownerAddress);
            System.out.println("Contract Address \t: "+CONTRACT_ADDRESS);

        }catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void init() {




        mywallet = Web3j.build(new HttpService(HTTP_SERVER));

        try {

             credentials = WalletUtils.loadCredentials(
                    PASSWORD,
                   KEYSTORE);
            System.out.println("Wallet loaded");

            }catch (Exception e) {
            e.printStackTrace();
        }

    }
   public void deploy() {

       try {
           System.out.println("Initiating Deployment ...");

           contract = Record.deploy(mywallet, credentials, GAS_PRICE, GAS_LIMIT).send();
           System.out.println("Contract valid : "+contract.isValid());
           System.out.println("Contract Address : "+contract.getContractAddress());

       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   public void loadContract(String address) {

       try {

            contract = Record.load(address,mywallet,credentials,GAS_PRICE,GAS_LIMIT);
            if(!contract.isValid()){
                System.out.println("Invalid contract");
                System.exit(0);
            }
            String ownerAddress = contract.getOwner().send();
            System.out.println("Owner Address \t: "+ownerAddress);
            System.out.println("Contract Address \t: "+address);

        }catch (Exception e) {
           e.printStackTrace();
       }

   }

    public Record getContract() {
        return contract;
    }

    public static void log(String logFile, String eventID) {


        try {

            // Open given file in append mode.
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(logFile, true));
            out.write(eventID+'\n');

            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void writeRecord(ExtendedRecord extendedRecord) {

        log(LOG_FILE,extendedRecord.mSignaturePointer);
        try {
            TransactionReceipt transactionReceipt = contract.addData(extendedRecord.mRecord.payload(),extendedRecord.mRecord.mEventID).send();
            System.out.println(transactionReceipt);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void logTransactions() {
        try{
            BigInteger index= contract.index().send();
            for(int i = 1;i<index.intValue();i++) {
                System.out.println(contract.getData( BigInteger.valueOf(i)).send());
            }
        }catch (Exception e){
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
