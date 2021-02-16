<#macro login path button>
    <form action="${path}" method="post">
        <div><label> User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div><input type="submit" value="${button}"/></div>
    </form>
</#macro>

<#macro logout>
<div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Sign Out"/>
        You enter as ${user_name!"GUEST"}
    </form>
</div>
</#macro>