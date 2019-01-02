App = {
  web3Provider: null,
  contracts: {},
  account: '0x0',
    owner: '0x0',
  hasVoted: false,

  init: function() {
    return App.initWeb3();
  },

  initWeb3: function() {
    // TODO: refactor conditional
    if (typeof web3 !== 'undefined') {
      // If a web3 instance is already provided by Meta Mask.
      App.web3Provider = web3.currentProvider;
      web3 = new Web3(web3.currentProvider);
    } else {
      // Specify default instance if no web3 instance provided
      App.web3Provider = new Web3.providers.HttpProvider('http://localhost:7545');
      web3 = new Web3(App.web3Provider);
    }
    return App.initContract();
  },

  initContract: function() {
    $.getJSON("build/contracts/Record.json", function(record) {
      // Instantiate a new truffle contract from the artifact
      App.contracts.Record = TruffleContract(record);
      // Connect provider to interact with contract
      App.contracts.Record.setProvider(App.web3Provider);

      //App.listenForEvents();

      return App.render();
    });
  },



  render: function() {
    var recordInstance;
    var loader = $("#loader");
    var content = $("#content");

    loader.show();
    content.hide();

    // Load account data
    web3.eth.getCoinbase(function(err, account) {
      if (err === null) {
        App.account = account;
        $("#yourAddress").html( account);

      }
    });

    // Load contract data
    App.contracts.Record.deployed().then(function(instance) {
      recordInstance = instance;

      return recordInstance.address;
    }).then(function(address) {
        $("#contractAddress").html( address);

      return recordInstance.getOwner();
    }).then(function(oAddress) {
        App.owner = oAddress;
        $("#ownerAddress").html( App.owner);
        return recordInstance.canAccess(App.account);
    }).then(function(access) {
        if(access){
            $("#hasaccess").html( "True");
        }else {
            $("#hasaccess").html( "False");
        }

        console.log(access);
    }).catch(function(error) {
      console.warn(error);
    });
    return App.fillRecord();
  },

  fillRecord: function() {
    var recordInstance;
      console.log("fill");
    App.contracts.Record.deployed().then(function(instance){

        recordInstance = instance;

        return recordInstance.index();



    }).then(function(index){

        let recordCount = index;
         var recordTable = $("#recordTable");
         var secondIndex;
         recordTable.empty();

        for(var i = 1;i<=recordCount;i++){
            secondIndex = i;

             recordInstance.getData(i).then(function(dataInstance){


            let payload = dataInstance[0];
            let eventID = dataInstance[1];

            var recordTemplate = "<tr><td>" + payload + "</td><td>" + eventID + "</td></tr>"
            recordTable.append(recordTemplate);
            });

        }

    });


  },

    readSensor: function() {
      var recordInstance;
      console.log("Read Sensor");


        App.contracts.Record.deployed().then(function(instance) {

              recordInstance = instance;
              var body  ;

              const Http = new XMLHttpRequest();
              const url='http://localhost:80/products';
              Http.open("GET", url);
              Http.send();
              Http.onreadystatechange = function() {
                  if (this.readyState == 4 && this.status == 200) {
                      // Typical action to be performed when the document is ready:
                      body = JSON.parse(Http.responseText);
                        console.log(body.payload.toString());
                      console.log(body.EventID.toString());

                      $("#event_ID_Out").html( body.EventIDString);


                        let pl = body.payload.toString();
                        let id = body.EventID.toString();//recordInstance.addData(body.payload.toString(),body.EventID.toString(),{from :App.owner,gas :670000})
                      recordInstance.addData(pl,id,{from :App.owner,gas :670000}).then(function (value) {



                      }).catch(function(error) {
                          console.warn(error);
                      });
                  }
              };




        });
        return App.fillRecord();
      },

    castVote: function() {
        console.log("here");
    },

    javaInter: function() {
      var testCloass = Java.type("")
    }
};

$(function() {
  $(window).load(function() {
    App.init();
  });
});
