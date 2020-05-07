const posts = [
    {title: 'Post 1', body: 'This is post 1' },
    {title: 'Post 2', body: 'This is post 2' }
]; 

function getPosts(){
    setTimeout(() => {
        let output = ''; 
        posts.forEach((post, index) => {
            output +=  `<li>${post.title} <br> ${post.body}</li>`
        }); 
        document.getElementById('posts').innerHTML = output; 
    }, 1000); 
}

function createPost(post) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            posts.push(post); 
           
            const error = false; 

            if(!error){
                resolve(); 
            } else {
                reject('Error! Something went wrong.');
            }
        }, 2000); 
    }); 
}

// createPost({title: 'Post 3', body: 'This is post 3'})
// .then(getPosts)
// .catch(err => console.log(err)); 

//Async /Await 

// async function init(){
//     await createPost({title: 'Post 3', body: 'This is post 3'}); 

//     getPosts(); 
// }

// init(); 

//Async /await, but with fetch 

async function fetchUsers(){
    const res = await fetch('https://jsonplaceholder.typicode.com/users'); 

    const data = await res.json(); 

    console.log(data); 
}

fetchUsers(); 


//Promise.all

// const promise1 = Promise.resolve('Hello World!'); 
// const promise2 = 10; 
// const promise3 = new Promise((resolve, reject) => setTimeout(resolve, 2000, 'Goodbye!')); 
// const promise4 = fetch('https://jsonplaceholder.typicode.com/users').then(res => res.json()); 

// //Takes all promises and puts them in an array... NOTE: will take as long as the longest promise to execute
// Promise.all([promise1, promise2, promise3, promise4]).then(values => console.log(values)); 

  