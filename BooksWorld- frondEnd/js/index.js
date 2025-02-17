async function loadHomePage() {
    const token = localStorage.getItem('token');
    if (!token) {
        window.location.href = '/public/login.html';
    }
    const name = localStorage.getItem('name');
    
    const url = 'http://localhost:8080/api/home';
    const getNameUser = document.getElementById('name_user');
    
    console.log(token);
    
        const response = await fetch(url, {
            headers: {
                Authorization: `Bearer ${token}`,
            }
        });
        getNameUser.textContent = name;
        console.log(response.json());
       
}

async function logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('name');
    window.location.href = '/public/login.html';
}

document.addEventListener('DOMContentLoaded', loadHomePage);

document.getElementById("logout-btn").addEventListener("click", logout);
