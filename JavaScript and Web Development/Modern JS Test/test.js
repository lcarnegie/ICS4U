// Questions 1 and 2: 

class Item {
    constructor(name, sku, listprice, saleprice, quant){
        this.name = name; 
        this.sku = sku; 
        this.listprice = listprice; 
        this.saleprice = saleprice; 
        this.quant = quant; 
        this.total = saleprice * quant; 
    }
}

class Bill {
    constructor(){
        this.items = []; 
    }

    push(item){
        this.items.push(item); 
    }

    subtotal(){
      return this.items.reduce((total, current) => total + current, 0); 
    }

    hst(){
        return 0.13 * subtotal(); 
    }

    total(){
        return subtotal() + hst(); 
    }

    sale(){
        return items.filter(item => item.saleprice <= (item.listprice - item.listprice * 0.25)); 
    }

    sortItems(){
        return this.items.sort((a, b) => {
            if(a.name.charAt(0) > b.name.charAt(0)){
                return 1; 
            } else {
                return -1; 
            }
        }); 
    }
}


// Question 3: 

async function fetchUsers(){
    const res = await fetch('https://jsonplaceholder.typicode.com/users'); 
    const data = await res.json(); 
    data.sort((a, b) => {
        if(a.email.charAt(0) > b.email.charAt(0)){
            return 1; 
        } else {
            return -1; 
        }
    }); 

    console.log(data); 
}

fetchUsers(); 


// Question 4: 

const birthYear = [1975, 1997, 2002, 1995, 1985]; 

function getAges(){
    return birthYear.map(birthYear => 2020 - birthYear); 
}



