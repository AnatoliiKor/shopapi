<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
Add new user
${message!}

<@l.login path="/registration" button = "Register"/>

    <a href="/shop">main page</a>
</@c.page>