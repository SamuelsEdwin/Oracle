clear
echo "Wrapper Process"
read -p "Enter File to Wrap " name
solc contracts/$name.sol --bin --abi --optimize --overwrite -o build/wrapper
../web3j/bin/web3j solidity generate build/wrapper/$name.bin build/wrapper/$name.abi -p wrapper -o ../
web3j solidity generate build/wrapper/Record.bin build/wrapper/Record.abi -o ../ -p wrapper