/**
 * Created by Administrator on 2016/10/12.
 */

var p1 = new Promise(function(resolve, reject) {
    resolve("Success!");
    // or
    reject ("Error!");
    throw new Error("Error")
});

p1.then(function(value) {
    console.log(value); // Success!
}, function(reason) {
    console.log(reason); // Error!
}).catch(function(e){
    console.log("Exception");
});



