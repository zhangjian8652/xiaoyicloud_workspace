/**
 * Created by Administrator on 2016/9/7.
 */

this.x = 9;

var module = {
    x: 81,
    getX: function () {
        return this.x;
    }
}

console.log(module.getX());


var retrieveX = module.getX;

console.log(retrieveX);

var boundGetX = retrieveX.bind(module);
console.log(boundGetX())


function list() {
    return Array.prototype.slice.call(arguments);
}

var list1 = list(1, 2, 3); // [1, 2, 3]
console.log(list1);


// Create a function with a preset leading argument
var leadingThirtysevenList = list.bind(undefined, 37);
var list2 = leadingThirtysevenList();

// [37]
console.log(list2);

var list3 = leadingThirtysevenList(1, 2, 3);
console.log(list3);
// [37, 1, 2, 3]


var myDate = new Date();
myDate.getYear(); //获取当前年份(2位)
myDate.getFullYear(); //获取完整的年份(4位,1970-????)
myDate.getMonth(); //获取当前月份(0-11,0代表1月)         // 所以获取当前月份是myDate.getMonth()+1;
myDate.getDate(); //获取当前日(1-31)
myDate.getDay(); //获取当前星期X(0-6,0代表星期天)
myDate.getTime(); //获取当前时间(从1970.1.1开始的毫秒数)
myDate.getHours(); //获取当前小时数(0-23)
myDate.getMinutes(); //获取当前分钟数(0-59)
myDate.getSeconds(); //获取当前秒数(0-59)
myDate.getMilliseconds(); //获取当前毫秒数(0-999)
myDate.toLocaleDateString(); //获取当前日期
var mytime = myDate.toLocaleTimeString(); //获取当前时间
myDate.toLocaleString(); //获取日期与时间
console.log(mytime);
console.log(myDate.getFullYear());


var xw = {
    name: "小王",
    gender: "男",
    age: 24,
    say: function () {
        console.log(this.name + " , " + this.gender + " ,今年" + this.age);
    }
}

var xh = {
    name: "小红",
    gender: "女",
    age: 18,
    say: function () {
        console.log("================================================")
        console.log(this.name + " , " + this.gender + " ,今年" + this.age);
        console.log(this.say);
        console.log("================================================")
    }
}

function xl(){
    this.name = "a";
    this.gender = "a";
    this.age = 111;
    this.say = function(){};
}

xw.say();

xw.say.call(xh);
xw.say.apply(xh);
xw.say.bind(xh)();

xh.say.call(new xl());
xh.say.apply(new xl());
xh.say.bind(new xl())();


function Animal(name, age) {
    this.name = name;
    this.age = age;
}



function Cat(name, age, color) {
    Animal.call(this, name, age);
    this.color = color;
}

function Dog(name, age, type) {
    Animal.apply(this, [name, age]);
    this.type = type;
}


function Car(){
    this.color = "白色";
}

function BMW(type){
    this.type = type;
}

function extend(Parent, Child) {
    var F = function(){};
    F.prototype = new Parent();
    Child.prototype = F.prototype;
    Child.prototype.constructor = Child;
    Child.uber = Parent.prototype;

}

console.log(new Cat("笑啊", 13, "白色"));
console.log(new Dog("笑啊", 1, "狼狗"));

extend(Car,BMW);
var car = new BMW(1);
console.log(car.color + " " + car.type);



function test(a,b,c){
    console.log("======================================");
    console.log(Array.prototype.slice.call(arguments));
}

test("1", "2", "3");


var ff = {
    a:"aa",
    b:function(){
        console.log(this.a)
    }
}

ff.b();



function Point(x,y){
    this.x = x;
    this.y = y;

    this.toString = function(){
        console.log("x:" + x + "  y:" + y);
    }
}

var p = new Point(1, 2);
p.toString(); // '1,2'

var YAxisPoint = Point.bind(null);


var axisPoint = new YAxisPoint(0,5);

axisPoint.toString();

var emptyObj = {x:2,y:6};
var YAxisPoint = Point.bind(emptyObj,0);

var axisPoint = new YAxisPoint(5);
axisPoint.toString();

console.log("===========================")
axisPoint.toString.bind(emptyObj)();
axisPoint.toString.apply(emptyObj);
axisPoint.toString.call(emptyObj);


function B(x,y){
    Point.call(this,x,y);
}

