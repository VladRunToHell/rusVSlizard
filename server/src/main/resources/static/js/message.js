const messsageLiz = (dataLiz) => {
	if(document.getElementById("message-container")){
		document.getElementById("message-container").remove;
	};

	const MAIN = document.getElementById("main");
	let innerMessage = '<div class="message-container d-flex align-items-center justify-content-center" id="message-container"><div class="message-text-container d-flex align-items-center justify-content-center text-uppercase"><p class="message-text font-Rubick fs-16" id="message-text"></p></div></div>'
	MAIN.innerHTML = innerMessage;

	const MESSAGECONTAINER = document.getElementById("message-container");
	MESSAGECONTAINER.style.backgroundImage = "url(../img/dia-liz.png)";

	const MESSAGETEXT = document.getElementById("message-text");
	MESSAGETEXT.innerHTML = dataLiz;
}

const messsageRus = (dataRus) => {
	if(document.getElementById("message-container")){
		document.getElementById("message-container").remove;
	};

	const MAIN = document.getElementById("main");
	let innerMessage = '<div class="message-container d-flex align-items-center justify-content-center" id="message-container"><div class="message-text-container d-flex align-items-center justify-content-center"><p class="message-text font-Hirmon fs-20" id="message-text"></p></div></div>'	
	MAIN.innerHTML = innerMessage;

	const MESSAGECONTAINER = document.getElementById("message-container");
	MESSAGECONTAINER.style.backgroundImage = "url(../img/dia-rus.png)";

	const MESSAGETEXT = document.getElementById("message-text");
	MESSAGETEXT.innerHTML = dataRus;
}

let dataRus = '';
let dataLiz = '';

messsageLiz(dataLiz);

messsageRus(dataRus);

const urlRus = "/sendRuss";
const urlLiz = "/sendLizs";

fetch(urlRus).then(response => {
if(!response.ok){throw new Error('Network response was not ok');}
return console.log(response)
}
)
.then(data =>{
messsageRus(data)
})
.catch(error => {
//     // Обрабатываем ошибки
console.error('There has been a problem with your fetch operation:', error);
});

fetch(urlLiz)
.then(response => {
if(!response.ok){throw new Error('Network response was not ok');}
return console.log(response)
}
)
.then(data =>{
messsageLiz(data)
}).catch(error => {
//     // Обрабатываем ошибки
console.error('There has been a problem with your fetch operation:', error);
});