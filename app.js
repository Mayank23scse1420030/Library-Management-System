document.getElementById('addBookForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const title = document.getElementById('title').value;
    const author = document.getElementById('author').value;
    const genre = document.getElementById('genre').value;

    fetch('http://localhost:8080/addBook', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            title: title,
            author: author,
            genre: genre
        })
    })
    .then(response => response.json())
    .then(data => {
        alert('Book added successfully!');
        loadBooks();
    })
    .catch(error => console.error('Error:', error));
});

function loadBooks() {
    fetch('http://localhost:8080/getBooks')
        .then(response => response.json())
        .then(data => {
            const booksList = document.getElementById('booksList');
            booksList.innerHTML = '';
            data.forEach(book => {
                const li = document.createElement('li');
                li.textContent = `${book.title} by ${book.author}`;
                booksList.appendChild(li);
            });
        })
        .catch(error => console.error('Error:', error));
}

// Load books on page load
window.onload = loadBooks;
