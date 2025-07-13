document.addEventListener('DOMContentLoaded', function() {
    const regForm = document.getElementById('registerForm');
    if (regForm) {
        regForm.onsubmit = async function(e) {
            e.preventDefault();
            const username = document.getElementById('username').value;
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;
            const fullName = document.getElementById('fullName').value;
            const res = await fetch('/api/users/register', {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify({username, email, passwordHash: password, fullName})
            });
            document.getElementById('registerMsg').innerText = await res.text();
        };
    }
    // Add similar handlers for login, dashboard, etc.
}); 