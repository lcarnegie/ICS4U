q5b(filterM);

function filterM(comments){
	return comments.filter(comment => comment.email.charAt(0) === "M");
}

async function q5b(callback){
	let comments = "";
	await fetch("https://jsonplaceholder.typicode.com/comments")
	.then(res => res.json())
	.then(json => {
		comments = callback(json);
	});
	console.log(comments);
}

const users = fetch('https://jsonplaceholder.typicode.com/users')
	.then(res => res.json())
	.then(data => {
		console.log("List of users");
		console.log(data);
		console.log("List of users sorted by city");
		console.log(data.sort((a,b) => a.address.city.localeCompare(b.address.city)));
});