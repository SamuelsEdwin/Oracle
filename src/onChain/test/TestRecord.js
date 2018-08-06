var record = arifacts.require("Record");

contract('record',function(){

        let recorder;

        beforeEach(async () => {
            recorder = await record.new();
        });

        it("The input should match the output", async function() {

            let index = 1;
            let set = 77;
            let get;

            await recorder.addRecord(set,index);
            get = await recorder.getRecord(index);
            assert.equal(set,get.toNumber(),"set != get");
        });


    it("The output should not false input", async function() {

        let index = 1;
        let set = 77;
        let get;

        await recorder.addRecord(set,index);
        get = await recorder.getRecord(index);
        assert.equal(78,get.toNumber(),"78 == get");
    });



    }
);