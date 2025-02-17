async function profilePage() { 
    const token = localStorage.getItem('token');
    if (!token) {
        window.location.href = '/public/login.html';
    }
    const name = localStorage.getItem('name');
    const url = 'http://localhost:8080/api/profile';
    const getNameUser = document.getElementById('name_user');
    getNameUser.textContent = name;
        const response = await fetch(url, {
            headers: {
                Authorization: `Bearer ${token}`,
            }
        });
        console.log(response.json());
         
}
document.addEventListener('DOMContentLoaded', profilePage);