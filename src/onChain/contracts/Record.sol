pragma solidity ^0.4.7;

contract Record {
//variables
address public owner; 
uint[16] private recordArray; //testing -todo replace
uint256 public index;

//mappings
mapping (address => bool)private allowed; 
mapping (uint256 => Records)public recordData;
//data structure
struct Records {
    string payload; 
    string eventID; 
}
constructor() public {
    owner = msg.sender; 
    index = 0;
    allowed[owner] = true;
}

modifier onlyBy(address _account) {
    require(
    msg.sender == _account, 
    "Sender not authorized."
    ); 
    _; 
}
modifier hasAccess {

require(
allowed[msg.sender] == true, 
"Sender not authorized."
); 
_; 
}



function getOwner()public view returns(address) {
    return owner; 
}
function modifyAccess(address _usrAddress, bool _permission)public onlyBy(owner) {

    allowed[_usrAddress] = _permission; 

}

function canAccess(address _usrAddress)public view returns(bool) {
    return (true == allowed[_usrAddress]); 
}

function addRecord(uint _record, uint _index)public hasAccess {
    recordArray[_index] = _record; 
}

function addData(string _payload, string _eventID) public hasAccess returns (uint256) {
    index++;
    recordData[index]=Records(_payload,_eventID);

    return index;
}

function getData(uint256 _index)public view  returns (string, string) {
    return (recordData[_index].payload, recordData[_index].eventID);
}

function getPayload(uint256 _index)public view returns (string) {

return recordData[_index].payload;

}

function getSignature(uint256 _index)public view returns (string) {
return recordData[_index].eventID;

}


function getRecord(uint _index)public view returns (uint) {
return recordArray[_index]; 
}

}
