// Constructor
function Book(title, author, year) {
    console.log('Book instantiated'); 
    this.title = title; 
    this.author = author; 
    this.year = year;
}

//getSummary
Book.prototype.getSummary = function() {
        return `${this.title} was written by ${this.author} in ${this.year}`;
}; 

//getAge
Book.prototype.getAge = function(){
    const years = new Date().getFullYear() - this.year; 
    return `${this.title} is ${years} years old`
}

//Revise /Change year
Book.prototype.revise = function(newYear) {
    this.year = newYear; 
    this.revised = true; 
}

//instantiate an object
const book1 = new Book('Book One', 'John Doe', '2020'); 
const book2 = new Book('Book Two', 'Jane Doe', '2019');

console.log(book2); 
book2.revise('2020'); 
console.log(book2); 
