<html>
    <head>
        <title>Books Library</title>
        <link rel="stylesheet" href="/style.css">
    </head>
    <body>
        <header>Books Library</header>

        <#list books as book>

        <section>
        Title: #{book.title}
        Author: ${book.author}
        Pages: ${book.pages}

        <a class="delete" href="#">Delete</a>
        <a class="modify" href="#">Modify</a>
        </section>

        <footer>Java Programming - Harbour.Space University</footer>
    </body>
</html>
