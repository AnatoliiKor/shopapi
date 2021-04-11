<#import "parts/common.ftlh" as c>
<@c.page>
<h2>${user.username}</h2>

Your Email is "${user.email}"

<p>
    <form method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="hidden" name="userId" value="${user.id}"/>
    Type new
        <input type="text" name="userEmail" value="${user.email}"/>
    <button type="submit">Save Email</button>
    </form>

    </@c.page>
