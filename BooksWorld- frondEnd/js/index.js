async function loadHomePage() {
    
        const url = 'http://localhost:8080/api/home';
       const getNameUser = document.getElementById('name_user');
       const token = localStorage.getItem('token');
       if (!token) {
        console.error('Don have Authorization');
       }
        console.log(token);

        try {
            const response = await fetch(url, {
                headers: {
                    Authorization: `Bearer ${token}`,
                }
            });
            console.log(response);
            
            if (response.ok) {
                const result = await response.json();
                
                console.log(result);
                getNameUser.textContent = result.token;
            } else {
                 const textfrom = response.body.values;
                const error = await response.text();
                console.error(error);
                console.error(textfrom);
                console.error("Грешка при регистрацията:", error);
                alert(`Registration failed: ${error}`);
            }
            // clearInputs();
        } catch (error) {
            console.error("Възникна грешка при заявката:", error);
            alert("An error occurred during registration.");
        }
    
    
}

async function logout() {
    localStorage.removeItem('token');
    
}

document.addEventListener('DOMContentLoaded', loadHomePage);

document.getElementById("logout-btn").addEventListener("click", logout);
