/**
 * Created by Administrator on 2016/9/8.
 */

var a = Math.abs(-11);
console.log(a);

var result = "hello world".big();
console.log(result);

console.log(Math.ceil(1));

console.log("123456".charAt(1));

console.log("abcdefg".charCodeAt(2));


var s = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPp"
// 只为大写字母创建正则表达式。
var r = new RegExp("[A-Z]", "g");
var a = s.match(r)			// 查找匹配。
console.log(a);
// 只为小写字母编译正则表达式。
r.compile("[a-z]", "g");
var a = s.match(r)			// 查找匹配。
console.log(a);


var pattern1 = new RegExp("o");

var str = "hello world!";

console.log(pattern1.test(str));
console.log(pattern1.exec(str));

pattern1.compile("d");
console.log(pattern1.test(str));

console.log(str.toUpperCase());
console.log(str.toLowerCase());

var x = 0.2 * 10 + 0.1 * 10;
console.log(x / 10);


Math.pow(10, 3);

console.log(Math.max(10, 100));
console.log(Math.min(10, 100));


console.log(Number.MAX_VALUE);
console.log(Number.MIN_VALUE);

console.log(isNaN(1))

console.log(2.1116312312.toFixed(3));


var xs = [1, 2, 3, 4, 5];

// Array.slice是纯函数，因为它没有副作用，对于固定的输入，输出总是固定的
// 可以，这很函数式
xs.slice(0, 3);
//=> [1,2,3]
xs.slice(0, 3);
//=> [1,2,3]

// Array.splice是不纯的，它有副作用，对于固定的输入，输出不是固定的
// 这不函数式
xs.splice(0, 3);
//=> [1,2,3]
xs.splice(0, 3);
//=> [4,5]
xs.splice(0, 3);
//=> []


console.log(encodeURI("/dsd/sdfsd?dfd=你好ssf "));

var compose = function (f,g) {

    return function (x){
        return f(g(x));
    }

}

var add1 = function (x) {
   return x + 1
};
var mul5 = function (x) {
    return x * 5
};

console.log(compose(add1, mul5)(10));


var arr = [1, 2, 4, 5];
var arr2 = [1, 2, 4, 5,6];

arr.map(function(a){
    console.log(a);
});

arr2.forEach(function(a){
    console.log(a);
});

for(var b in arr){
    console.log(b);
    console.log(arr[b]);
}


