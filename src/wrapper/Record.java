package wrapper;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class Record extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060008054600160a060020a03191633178082556001828155600160a060020a0391909116825260026020526040909120805460ff191690911790556108138061005b6000396000f30060806040526004361061008d5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630178fe3f811461009257806318a9d222146101885780632986c0e5146101bd578063528407e5146101e4578063893d20e81461027b5780638da5cb5b146102ac578063a49efc86146102c1578063cd58b8d6146102e9575b600080fd5b34801561009e57600080fd5b506100aa600435610301565b604051808060200180602001838103835285818151815260200191508051906020019080838360005b838110156100eb5781810151838201526020016100d3565b50505050905090810190601f1680156101185780820380516001836020036101000a031916815260200191505b50838103825284518152845160209182019186019080838360005b8381101561014b578181015183820152602001610133565b50505050905090810190601f1680156101785780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b34801561019457600080fd5b506101a9600160a060020a0360043516610439565b604080519115158252519081900360200190f35b3480156101c957600080fd5b506101d261045c565b60408051918252519081900360200190f35b3480156101f057600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526101d294369492936024939284019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a9998810197919650918201945092508291508401838280828437509497506104629650505050505050565b34801561028757600080fd5b5061029061054b565b60408051600160a060020a039092168252519081900360200190f35b3480156102b857600080fd5b5061029061055b565b3480156102cd57600080fd5b506102e7600160a060020a0360043516602435151561056a565b005b3480156102f557600080fd5b506100aa600435610610565b600081815260036020908152604091829020805483516002600180841615610100026000190190931604601f810185900485028201850190955284815260609485949284019284919083018282801561039b5780601f106103705761010080835404028352916020019161039b565b820191906000526020600020905b81548152906001019060200180831161037e57829003601f168201915b5050845460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959750869450925084019050828280156104295780601f106103fe57610100808354040283529160200191610429565b820191906000526020600020905b81548152906001019060200180831161040c57829003601f168201915b5050505050905091509150915091565b600160a060020a031660009081526002602052604090205460ff16151560011490565b60015481565b3360009081526002602052604081205460ff1615156001146104e557604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601660248201527f53656e646572206e6f7420617574686f72697a65642e00000000000000000000604482015290519081900360640190fd5b600180548101908190556040805180820182528581526020808201869052600093845260038152919092208251805191926105259284929091019061074f565b50602082810151805161053e926001850192019061074f565b5050600154949350505050565b600054600160a060020a03165b90565b600054600160a060020a031681565b600054600160a060020a03163381146105e457604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601660248201527f53656e646572206e6f7420617574686f72697a65642e00000000000000000000604482015290519081900360640190fd5b50600160a060020a03919091166000908152600260205260409020805460ff1916911515919091179055565b60036020908152600091825260409182902080548351601f600260001961010060018616150201909316929092049182018490048402810184019094528084529092918391908301828280156106a75780601f1061067c576101008083540402835291602001916106a7565b820191906000526020600020905b81548152906001019060200180831161068a57829003601f168201915b505050505090806001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156107455780601f1061071a57610100808354040283529160200191610745565b820191906000526020600020905b81548152906001019060200180831161072857829003601f168201915b5050505050905082565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061079057805160ff19168380011785556107bd565b828001600101855582156107bd579182015b828111156107bd5782518255916020019190600101906107a2565b506107c99291506107cd565b5090565b61055891905b808211156107c957600081556001016107d35600a165627a7a723058204e336c37410a59b8582f2f71cddcd9278e32f6199fe9bc58cb53e80141abf0650029";

    public static final String FUNC_GETDATA = "getData";

    public static final String FUNC_CANACCESS = "canAccess";

    public static final String FUNC_INDEX = "index";

    public static final String FUNC_ADDDATA = "addData";

    public static final String FUNC_GETOWNER = "getOwner";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_MODIFYACCESS = "modifyAccess";

    public static final String FUNC_RECORDDATA = "recordData";

    @Deprecated
    protected Record(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Record(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Record(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Record(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<Tuple2<String, String>> getData(BigInteger _index) {
        final Function function = new Function(FUNC_GETDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple2<String, String>>(
                new Callable<Tuple2<String, String>>() {
                    @Override
                    public Tuple2<String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<Boolean> canAccess(String _usrAddress) {
        final Function function = new Function(FUNC_CANACCESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_usrAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> index() {
        final Function function = new Function(FUNC_INDEX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> addData(String _payload, String _eventID) {
        final Function function = new Function(
                FUNC_ADDDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_payload), 
                new org.web3j.abi.datatypes.Utf8String(_eventID)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getOwner() {
        final Function function = new Function(FUNC_GETOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> modifyAccess(String _usrAddress, Boolean _permission) {
        final Function function = new Function(
                FUNC_MODIFYACCESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_usrAddress), 
                new org.web3j.abi.datatypes.Bool(_permission)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple2<String, String>> recordData(BigInteger param0) {
        final Function function = new Function(FUNC_RECORDDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple2<String, String>>(
                new Callable<Tuple2<String, String>>() {
                    @Override
                    public Tuple2<String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue());
                    }
                });
    }

    public static RemoteCall<Record> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Record.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Record> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Record.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Record> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Record.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Record> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Record.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static Record load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Record(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Record load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Record(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Record load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Record(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Record load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Record(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
