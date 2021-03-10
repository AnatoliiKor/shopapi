<#import "parts/common.ftlh" as c>
<@c.page>
<h2>${user.username}</h2>

Your old password is "${user.password}"

<p>
    <form method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="hidden" name="userId" value="${user.id}"/>
    Type new
        <input type="text" name="userPassword" value="${user.password}"/>
    <button type="submit">Save Password</button>
    </form>

    </@c.page>
