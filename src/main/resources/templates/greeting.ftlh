<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<@c.page>
    <div>Hello, guest</div>

    <div>
        <a href="/login">Sign In</a>
    </div>
    <#if isAdmin>
            <a href="/admin">Admin</a>
    </#if>
    <div>
        <a href="/shop">View all products</a>
    </div>

</@c.page>
