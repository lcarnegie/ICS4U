function consoleTest(){
//console.log("This \"is\" "); 

var x = 7; 
//console.log(x); 

x = 'changed the type, just like that!'; 
//console.log(x); 

var arr = []; 

arr[6] = 18; 
arr[11] = "hello"; 
//arr[20] = arr; 

arr[3] = function(){console.log("hi")}; 

arr[3](); 

var obj = {}; 
obj.color = "red"; 
obj.height = 7; 
obj['shoesize'] = 5; //same thing as saying the above
obj.shoesize = 6; 
obj[5] = 8; 

obj.func1 = function(){alert(x)}; 

//console.log(obj); 

//obj.func1(5); 

//arr.push(99); 
//arr.pop(); 
//arr.splice(6,8); 
//var removedItems = arr.splice(6,1); 

//iterator(removedItems); 

mystery(1123, "seventy", "quack", false);

//console.log(obj); 


}

function iterator(coll){
	for(var val in coll){
		//if(val !== undefined)
			console.log('key: ' + val + ', value: ' + coll[val]);
	}
}

function mystery(a, b, c, d){
	console.log(a); 
	console.log(b); 
	console.log(c); 
	console.log(d); 



}


















