<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <h2>Add new user</h2>
    <p>
    ${message!}
    <p>
    <@l.login path="/registration" button = "Register"/>

</@c.page>