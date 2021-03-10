<#import "parts/common.ftlh" as c>
<@c.page>
<h2>${user.username}</h2>
<p>
    <form method="post" action="/user">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
<#--        <input type="text" name="username" value="${user.username}"/>-->
        <input type="hidden" name="userId" value="${user.id}"/>
<p>
    <#list roles as role>
    <div>
        <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked","")}>${role}
        </label>

    </div>
</#list>
<p>
<td>is active <input type="checkbox" name="active" ${user.active?string("checked","")}></td>
<p>
    <button type="submit">Save</button>
    </form>

    </@c.page>
