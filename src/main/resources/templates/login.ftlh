<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <h2>Login page</h2>
    <p>
        <@l.login path="/login" button = "Sign In"/>
    <p>
        <a href="/registration">Registration</a>

</@c.page>