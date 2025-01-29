async function registerUser() {
    const url = 'http://localhost:8080/api/register';

    const fullName = document.getElementById("username").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirm-password").value;
    const formElement = document.getElementById('register-form');
    const userData = {  email,fullName, password };
    const createElement = document.createElement('p');
    createElement.classList.add('error-p');

    function checkDataValidation(fullName,email,password,confirmPassword) {
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

    function clearInputs() {
        fullName.value = "";
        email.value = "";
        password.value = "";
        confirmPassword.value = "";
    }
    
    checkDataValidation();

    if (!checkDataValidation) {
        return;
    }

    try {
        
        createElement.remove();
        clearInputs();
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        });
        console.log(response);
        
        if (response.ok) {
            // const result = await response.json();
            console.log("Регистрацията е успешна:");
            alert("User registered successfully!");
        } else {
            const error = await response.text();
            console.error("Грешка при регистрацията:", error);
            alert(`Registration failed: ${error}`);
        }
    } catch (error) {
        console.error("Възникна грешка при заявката:", error);
        alert("An error occurred during registration.");
    }
}

document.getElementById("register-btn").addEventListener("click", registerUser);