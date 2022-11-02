<html>
    <body>
        <h1>Article Index</h1>
        <ul>
            <#list articles as article>
                <li>${article.title}</li>
            </#list>
        </ul>
    </body>
</html>