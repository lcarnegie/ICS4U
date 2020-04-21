class Book {
    constructor(title, author, year) {
        this.title = title; 
        this.author = author; 
        this.year = year; 
    }

    getSummary() {
        return `${this.title} was written by 
        ${this.author} in ${this.year}`;
    }
    
    getAge() {
        const years = new Date().getFullYear() - this.year; 
        return `${this.title} is ${years} years old`; 
    }
    
    revise(newYear) {
        this.year = newYear; 
        this.revised = true; 
    }

    static topBookstore(){
        return 'Barnes and Noble'; 
    }
}



//Instantiate
const book1 = new Book ('Book one', 'Johnny', '2002'); 

console.log(book1.getAge()); 
book1.revise(2013); 
console.log(book1.getAge());
console.log(Book.topBookstore()) ; 
