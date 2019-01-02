import javax.script.*;

public class EvalScript {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        // evaluate JavaScript code that defines a function with one parameter
       // engine.eval(new java.io.FileReader("C:\\Users\\Edwin\\OneDrive\\2018\\Second Term\\Projects\\Oracle\\src\\onChain\\js\\web3.min.js"));
        //engine.eval(new java.io.FileReader("src\\onChain\\js\\truffle-contract.js"));
        engine.eval(new java.io.FileReader("src\\onChain\\js\\script.js"));


        Object App = engine.get("App");
        // create an Invocable object by casting the script engine object
        Invocable inv = (Invocable) engine;

        // invoke the function named "hello" with "Scripting!" as the argument
      //  inv.invokeMethod(App,"init");
       // inv.invokeMethod(App,"addressInfo");
    }
}