pragma solidity ^0.4.0;


contract Record {
    uint[16] public records;

    function addRecord(uint record , uint index) public {

        records[index] = record;

    }

    function getRecord(uint index) public view returns (uint) {
        return records[index];
    }

}
