async function registerUser() {
    const token = localStorage.getItem('token');
    if (token) {
        window.location.href = '/public/index.html';
       }
    const url = 'http://localhost:8080/api/login';
    const emailInput = document.getElementById("email");
    const passwordInput = document.getElementById("password");
    const email = emailInput.value;
    const password = passwordInput.value;
  
    const formElement = document.getElementById('register-form');
    const userData = {  email, password };
    const createElement = document.createElement('p');
    createElement.classList.add('error-p');

    if (!email || !password) {
        createElement.textContent = 'Email or password must not be empty!';
        formElement.appendChild(createElement);
        clearInputs();
        return;
    }

    function clearInputs() {
       
        emailInput.textContent = "";
        passwordInput.textContent = "";
        
    }
    
    
    try {
        
        createElement.remove();
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        });
        console.log(response);
        
        if (response.ok) {
            const result = await response.json();
            localStorage.setItem('token', result.token);
            window.location.href = '/public/index.html';
            console.log("Регистрацията е успешна:");
            alert("User registered successfully!");
        } else {
             const textfrom = response.body.values;
            const error = await response.text();
            console.error(error);
            console.error(textfrom);
            console.error("Грешка при регистрацията:", error);
            alert(`Registration failed: ${error}`);
        }
        clearInputs();
    } catch (error) {
        console.error("Възникна грешка при заявката:", error);
        alert("An error occurred during registration.");
    }
}

document.getElementById("login-btn").addEventListener("click", registerUser);