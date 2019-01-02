var express = require('express')
var cors = require('cors')
var app = express()
const request = require('request');
app.use(cors())
var a = "rage";
app.get('/products/', function (req, res, next) {


    request('http://localhost:8500/oracle?read', { json: true }, (err, rest , body) => {
        if (err) { return console.log(err); }
        res.json(body);
    });

   // res.json({msg: "shit"})
})

app.listen(80, function () {
    console.log('CORS-enabled web server listening on port 80')
})