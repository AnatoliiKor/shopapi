<#macro login path button>
    <form action="${path}" method="post">
        <div><label> User Name: <input type="text" name="username"/> </label></div>
        <#if path=="/registration">
        <div><label> Email: <input type="text" name="email"/> </label></div>
        </#if>
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
    </form>
</div>
</#macro>