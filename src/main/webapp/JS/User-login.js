function validateForm() {
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    if (email === '' || password === '') {
        document.getElementById('error').innerText = 'All fields are required.';
        return false;
    }
    return true;
}