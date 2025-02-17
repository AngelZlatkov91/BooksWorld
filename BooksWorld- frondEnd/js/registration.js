async function registerUser() {

    const token = localStorage.getItem('token');

    
    const url = 'http://localhost:8080/api/register';
    const fullNameInput = document.getElementById("username");
    const emailInput = document.getElementById("email");
    const passwordInput = document.getElementById("password");
    const confirmPasswordInput = document.getElementById("confirm-password");

    const fullName = fullNameInput.value;
    const email = emailInput.value;
    const password = passwordInput.value;
    const confirmPassword = confirmPasswordInput.value;
    const formElement = document.getElementById('register-form');
    const userData = {  email, fullName, password, confirmPassword };
    const createElement = document.createElement('p');
    createElement.classList.add('error-p');

    function checkDataValidation(fullName, email, password, confirmPassword) {
        
        if (!email || !fullName || !password || !confirmPassword) {       
            createElement.textContent = 'Must not be empty!';
            formElement.appendChild(createElement);
            return false;
        }

        if (password !== confirmPassword) {
            createElement.textContent = 'Must the password must be equal!';
            formElement.appendChild(createElement);
            return false;
        }

        return true;
    }

    
    

    if (!checkDataValidation(fullName, email, password, confirmPassword)) {
        return;
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
        
        
        if (response.ok) {
            // const result = await response.json();
            console.log("Регистрацията е успешна:");
            window.location.href = '/public/login.html';
            alert("User registered successfully!");
        } else {
             const textfrom = response.body.values;
            const error = await response.text();
            console.error(error);
            console.error(textfrom);
            console.error("Грешка при регистрацията:", error);
            alert(`Registration failed: ${error}`);
        }
        
    } catch (error) {
        console.error("Възникна грешка при заявката:", error);
        alert("An error occurred during registration.");
    }
}

document.getElementById("register-btn").addEventListener("click", registerUser);