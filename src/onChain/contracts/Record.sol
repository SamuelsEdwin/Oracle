pragma solidity ^0.4.23;


contract Record {
    //variables
    address public owner;
    uint[16] private records;//testing -todo replace
    uint256 private index;

    //mappings
    mapping (address => bool) private allowed;
    mapping (uint256 => Records) public data;
    //data structure
    struct Records {
        string payload;
        string signature;
    }

    constructor() public {
        owner = msg.sender;
        index = 0;
    }

    modifier onlyBy(address _account)
    {
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



    function getOwner() public view returns(address) {
        return owner;
    }
    function modifyAccess(address _usrAddress , bool _permission) public onlyBy(owner) {

        allowed[_usrAddress] = _permission;

    }

    function canAccess(address _usrAddress) public  returns(bool) {
        bool access = allowed[_usrAddress];
        return access;
    }

    function addRecord(uint _record , uint _index) public hasAccess {
        records[_index] = _record;
    }

    function getRecord(uint _index) public view returns (uint) {
        return records[_index];
    }

}
