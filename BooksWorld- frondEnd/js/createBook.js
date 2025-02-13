async function createBook() {
    const url = 'http://localhost:8080/api/create';
    const bookNameInput = document.getElementById("title");
    const authorInput = document.getElementById("author");
    const genreInput = document.getElementById("genre");
    const imageUrlInput = document.getElementById("image");
    const formElement = document.getElementById('create-book');
    const bookName = bookNameInput.value;
    const author = authorInput.value;
    const imageUrl = genreInput.value;
    const genre = imageUrlInput.value;
    const userData = {  bookName, author, imageUrl, genre};
    const token = localStorage.getItem('token');
    if (!token) {
        console.error('Don have Authorization');
       }
    const createElement = document.createElement('p');
    createElement.classList.add('error-p');

    function checkDataValidation(bookName, author, genre, imageUrl) {
        if (!bookName || !author || !genre || !imageUrl) {       
            createElement.textContent = 'Must not be empty!';
            formElement.appendChild(createElement);
            return false;
        }

        return true;
    }

    if (!checkDataValidation(bookNameInput.value, authorInput.value, genreInput.value, imageUrlInput.value)) {
        return;
    }
    function clearInputs() {
        bookNameInput.textContent = "";
        authorInput.textContent = "";
        genreInput.textContent = "";
        imageUrlInput.textContent = "";
    }
    
    try {
        
        createElement.remove();
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                Authorization: `Bearer ${token}`,
                'Content-Type': 'application/json'

            },
            body: JSON.stringify(userData)
        });
        
        
        if (response.ok) {
            console.log("Създадохме книга");
            alert("User registered successfully!");
        }  else if (response.status(401)) {
            window.location.href = '/public/login.html';
            console.log("not authorization");
        }  else {
             const textfrom = response.body.values;
            const error = await response.text();
            console.error(error);
            console.error(textfrom);
            console.error("Грешка при Въвеждане на данни:", error);
            alert(`Registration failed: ${error}`);
        }
        clearInputs();
    } catch (error) {
        console.error("Възникна грешка при заявката:", error);
        alert("An error occurred during registration.");
    }
}

document.getElementById("book-btn").addEventListener("click", createBook);