<#import "parts/common.ftlh" as c>
<@c.page>
User Editor

    <form method="post" action="/user">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="text" name="username" value="${user.username}"/>
        <#list roles as role>
            <div>
                <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked","")}>${role}</label>

            </div>
        </#list>
        <input type="hidden" name="userId" value="${user.id}"/>
        <button type="submit">Save</button>
    </form>

</@c.page>
