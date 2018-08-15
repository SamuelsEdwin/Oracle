var record = artifacts.require("Record");

contract('record',function(accounts){

        let recorder;

        beforeEach(async () => {
            recorder = await record.new();
        });

        it("The creator should be the owner", async function() {
            let owner;

            owner = await recorder.owner();

            assert.equal(owner , accounts[0],"owener did not equal creator");

        });



        it("Test access modifier", async function() {

            //let index = 1;
            //let set = 77;
            //let get;

            //let access;
            await recorder.modifyAccess(accounts[1],true,{from: accounts[0]})
            const access = await recorder.canAccess(accounts[1]);
            assert.equal(access
                ,true, "should have access");

            //await recorder.addRecord(set,index);
            //get = await recorder.getRecord(index);
            //assert.equal(set,get.toNumber(),"set != get");
            //assert.equal(77,set,"set != get");
        });


    it("Test default access modifier", async function() {

        await recorder.modifyAccess(accounts[1],true,{from: accounts[0]})
        const access = await recorder.canAccess(accounts[2]);
        assert.equal(access
            ,false, "should not have access");

    });


    it("Wrong owner", async function() {

        try {

            await
            recorder.modifyAccess(accounts[1], true, {from: accounts[1]})
            const access = await
            recorder.canAccess(accounts[2]);

            assert.ok(false);
            } catch(err) {
            assert.ok(true);
            }
    });




    }
);