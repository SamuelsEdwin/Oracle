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

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class Record extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060008054600160a060020a03191633178155601155610aae806100356000396000f3006080604052600436106100ae5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630178fe3f81146100b357806302a569e6146101a957806303e9e60914610236578063130cb1501461026057806318a9d2221461027d5780631d2db6c8146102b2578063528407e5146102ca578063893d20e8146103615780638da5cb5b14610392578063a49efc86146103a7578063f0ba8440146103cd575b600080fd5b3480156100bf57600080fd5b506100cb6004356103e5565b604051808060200180602001838103835285818151815260200191508051906020019080838360005b8381101561010c5781810151838201526020016100f4565b50505050905090810190601f1680156101395780820380516001836020036101000a031916815260200191505b50838103825284518152845160209182019186019080838360005b8381101561016c578181015183820152602001610154565b50505050905090810190601f1680156101995780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b3480156101b557600080fd5b506101c160043561051d565b6040805160208082528351818301528351919283929083019185019080838360005b838110156101fb5781810151838201526020016101e3565b50505050905090810190601f1680156102285780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561024257600080fd5b5061024e6004356105d5565b60408051918252519081900360200190f35b34801561026c57600080fd5b5061027b6004356024356105ec565b005b34801561028957600080fd5b5061029e600160a060020a0360043516610683565b604080519115158252519081900360200190f35b3480156102be57600080fd5b506101c16004356106a6565b3480156102d657600080fd5b506040805160206004803580820135601f810184900484028501840190955284845261024e94369492936024939284019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a9998810197919650918201945092508291508401838280828437509497506107109650505050505050565b34801561036d57600080fd5b506103766107e6565b60408051600160a060020a039092168252519081900360200190f35b34801561039e57600080fd5b506103766107f6565b3480156103b357600080fd5b5061027b600160a060020a03600435166024351515610805565b3480156103d957600080fd5b506100cb6004356108ab565b600081815260136020908152604091829020805483516002600180841615610100026000190190931604601f810185900485028201850190955284815260609485949284019284919083018282801561047f5780601f106104545761010080835404028352916020019161047f565b820191906000526020600020905b81548152906001019060200180831161046257829003601f168201915b5050845460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529597508694509250840190508282801561050d5780601f106104e25761010080835404028352916020019161050d565b820191906000526020600020905b8154815290600101906020018083116104f057829003601f168201915b5050505050905091509150915091565b6060601360008381526020019081526020016000206001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105c95780601f1061059e576101008083540402835291602001916105c9565b820191906000526020600020905b8154815290600101906020018083116105ac57829003601f168201915b50505050509050919050565b6000600182601081106105e457fe5b015492915050565b3360009081526012602052604090205460ff16151560011461066f57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601660248201527f53656e646572206e6f7420617574686f72697a65642e00000000000000000000604482015290519081900360640190fd5b816001826010811061067d57fe5b01555050565b600160a060020a031660009081526012602052604090205460ff16151560011490565b60008181526013602090815260409182902080548351601f60026000196101006001861615020190931692909204918201849004840281018401909452808452606093928301828280156105c95780601f1061059e576101008083540402835291602001916105c9565b33600090815260126020526040812054819060ff16151560011461079557604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601660248201527f53656e646572206e6f7420617574686f72697a65642e00000000000000000000604482015290519081900360640190fd5b506011546000908152601360209081526040909120835190916107bf9160018401918601906109ea565b5083516107d290829060208701906109ea565b505060118054600181019091559392505050565b600054600160a060020a03165b90565b600054600160a060020a031681565b600054600160a060020a031633811461087f57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601660248201527f53656e646572206e6f7420617574686f72697a65642e00000000000000000000604482015290519081900360640190fd5b50600160a060020a03919091166000908152601260205260409020805460ff1916911515919091179055565b60136020908152600091825260409182902080548351601f600260001961010060018616150201909316929092049182018490048402810184019094528084529092918391908301828280156109425780601f1061091757610100808354040283529160200191610942565b820191906000526020600020905b81548152906001019060200180831161092557829003601f168201915b505050505090806001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156109e05780601f106109b5576101008083540402835291602001916109e0565b820191906000526020600020905b8154815290600101906020018083116109c357829003601f168201915b5050505050905082565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610a2b57805160ff1916838001178555610a58565b82800160010185558215610a58579182015b82811115610a58578251825591602001919060010190610a3d565b50610a64929150610a68565b5090565b6107f391905b80821115610a645760008155600101610a6e5600a165627a7a72305820a7e39f11ddb3c8643a10971037c80572c07588320e2200fa47121f2f01f6efaf0029";

    public static final String FUNC_GETDATA = "getData";

    public static final String FUNC_GETSIGNATURE = "getSignature";

    public static final String FUNC_GETRECORD = "getRecord";

    public static final String FUNC_ADDRECORD = "addRecord";

    public static final String FUNC_CANACCESS = "canAccess";

    public static final String FUNC_GETPAYLOAD = "getPayload";

    public static final String FUNC_ADDDATA = "addData";

    public static final String FUNC_GETOWNER = "getOwner";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_MODIFYACCESS = "modifyAccess";

    public static final String FUNC_DATA = "data";

    protected Record(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Record(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
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

    public RemoteCall<String> getSignature(BigInteger _index) {
        final Function function = new Function(FUNC_GETSIGNATURE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> getRecord(BigInteger _index) {
        final Function function = new Function(FUNC_GETRECORD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> addRecord(BigInteger _record, BigInteger _index) {
        final Function function = new Function(
                FUNC_ADDRECORD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_record), 
                new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> canAccess(String _usrAddress) {
        final Function function = new Function(FUNC_CANACCESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_usrAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<String> getPayload(BigInteger _index) {
        final Function function = new Function(FUNC_GETPAYLOAD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    public RemoteCall<Tuple2<String, String>> data(BigInteger param0) {
        final Function function = new Function(FUNC_DATA, 
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

    public static RemoteCall<Record> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Record.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Record> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Record.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Record load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Record(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Record load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Record(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
